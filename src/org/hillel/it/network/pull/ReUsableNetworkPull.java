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
	
	public ReUsableNetworkPull (int maxConnections, String url){
//		if (maxConnections < 0) {
//			throw new RuntimeException ("Wrong max connections");
//		}
//		else {
//			if (url.equals(null)) {
//				throw new RuntimeException ("Wrong URL");
//			}
//			else {
				{				this.maxConnections=maxConnections;
				available=true;
				connections = new ArrayList<>();
				this.url=url;
	            try {
					DriverManager.registerDriver(new Driver());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//		}
	}
	
	public ReUsableConnection getConnection() {
		for (ReUsableConnection currConnection:connections) {
			if (!currConnection.isBusy()) {
				return (ReUsableConnection) currConnection.getConnect();
			}
		}

		if (maxConnections < connections.size()) {
			available=false;
			throw new RuntimeException ("max connections...");
			
		}
		else {
	        try
	        {
//	            DriverManager.registerDriver(new Driver());
	            Connection connection = DriverManager.getConnection(url, "admin","123456789");
	            ReUsableConnection reconnect = new ReUsableConnection (connection);
	            
	            connections.add(reconnect);
	            System.out.println("Good connection= " + connection);
	            return reconnect;
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
		}
			return null;
	}
	
	public void destroy () {
		available=false;
	}
}
