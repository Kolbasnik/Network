package org.hillel.it.network.pull;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

//http://itpool.ru/blog/jdbc-connection-pool-svoimi-rukami-chast-1.html
//http://itpool.ru/blog/jdbc-connection-pool-svoimi-rukami-chast-2.html

public class DBConnectionPool {

	String url;
	String user;
	String password;
	int maxConn;
	static DBConnectionPool instance;
	static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	List <Connection> freeConnections;
	
	private DBConnectionPool (String url, String user, String password, int maxConn) {
		this.url = url;
		this.user = user;
		this.password = password;
		this.maxConn = maxConn;

		loadDrivers();
	}
	
	private void loadDrivers() {
		try {
			Driver driver = (Driver)Class.forName (DRIVER_NAME).newInstance();
			
			System.out.println("driver = " + driver);
			DriverManager.registerDriver (driver);
			System.out.println("Registered JDBC driver ");
		}
		catch (Exception e) {
			System.out.println("Can't register JDBC driver");
		}
	}
		
		
	public static synchronized DBConnectionPool getInstance (String url, String user, String password, int maxConn) {

		if (instance == null) {
			instance = new DBConnectionPool(url, user, password, maxConn);
		}

		return instance; 
	}
	
	public synchronized Connection getConnection() {

		Connection con = null;
		if  (freeConnections != null) {
			if (!freeConnections.isEmpty())  {
				con = freeConnections.get(freeConnections.size()-1);
				freeConnections.remove(con);

				try {
					if (con.isClosed()) {
						System.out.println("Removed bad connection ");
						freeConnections.remove(con);
						// 	Try again recursively
						con = getConnection();
					}
				}

				catch (SQLException e) {
					System.out.println("Removed bad connection ");
					// 	Try again recursively
					con = getConnection();
				}

				catch (Exception e) {
					System.out.println("Removed bad connection ");
					// 	Try again recursively
					con = getConnection();
				}

			} 
		}
		else {
			con = newConnection();
		}

		return con; 
	}	
	
	private Connection newConnection() {

		Connection con = null;
		try {
			if (user == null) {
				con = DriverManager.
						getConnection(url);
			}

			else {
				con = DriverManager.
						getConnection(url, user, password);
			}
			
			System.out.println("Created a new connection in pool");
		}

		catch (SQLException e) {
			System.out.println("Can't create a new connection for " + url);
			return null;
		}

		return con; 
	}
	
	public synchronized void freeConnection(Connection con) {
		// Put the connection
		// at the end of the List
		if ( (con != null)&&(freeConnections.size() <= maxConn) ) {
			freeConnections.add(con);
		}
	}
	
	public synchronized void released() {
		Iterator <Connection> allConnections = freeConnections.iterator();

		while (allConnections. hasNext()) {
			Connection con = (Connection) allConnections.next();

			try {
				con.close();
				System.out.println("Closed connection for pool");
			}

			catch (SQLException e) {
				System.out.println("Can't close connection for pool");
			}
		}

		freeConnections.clear(); }
}