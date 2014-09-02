package org.hillel.it.network.pull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class ReUsableNetworkPull implements NetworkPull{
	private String url;
	private int maxConnections;
	private boolean available;
	List <ReUsableConnection> connections;
	private static ReUsableNetworkPull instance=null;

	public ReUsableNetworkPull (int maxConnections, String url){
    	try {
			DriverManager.registerDriver(new Driver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		this.maxConnections=maxConnections;
		available=true;
		connections = new ArrayList<>();
		this.url=url;
	}

	
	public static ReUsableNetworkPull getInstance(int maxConnections, String url) {
		if (instance == null) {
			ReUsableNetworkPull instance = new ReUsableNetworkPull(maxConnections, url);
			return instance;
		}
		else {
			return instance;
		}
	}
	
	public Connection getConnection() {
		Connection connection = null;;

		for (ReUsableConnection currConnection:connections) {
			if (!currConnection.isBusy()) {
				return (ReUsableConnection) currConnection.getConnect();
			}
		}

		if (maxConnections < connections.size()) {
			available=false;
			return connection;
		}
		else {
			
	        try
	        {
	        	System.out.println("DB url = " + url);

	        	connection = DriverManager.getConnection(url, "admin","123456789");
	            System.out.println("Good connection= " + connection);
	            
	            connections.add(new ReUsableConnection (connection));
	            return connection;
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            return connection;
	        }
		}
	}		
			
	
	public void destroy () {
		available=false;
	}
}
