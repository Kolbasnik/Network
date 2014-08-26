package org.hillel.it.network.pull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReUsableNetworkPull implements NetworkPull{
	private String url;
	private int maxConnections;
	private boolean available;
	List <ReUsableConnection> connections;
	private static int i;
	
	public ReUsableNetworkPull (int maxConnections, String url){
		if (maxConnections < 0) {
			throw new RuntimeException ("Wrong max connections");
		}
		else {
			if (url.equals(null)) {
				throw new RuntimeException ("Wrong URL");
			}
			else {
				this.maxConnections=maxConnections;
				available=true;
				connections = new ArrayList<>();
				this.url=url;
			}
		}
	}
	
	public Connection getConnection() {
		for (ReUsableConnection currConnection:connections) {
			if (!currConnection.isBusy()) {
				return currConnection.getConnect();
			}
		}

		if (maxConnections < connections.size()) {
			available=false;
			throw new RuntimeException ("max connections...");
			
		}else {
			try {
				Connection connection=DriverManager.getConnection(url,"1","1");
				ReUsableConnection reConnection = new ReUsableConnection(connection);
				connections.add(reConnection);
				return connection;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
		}
			return null;
	}
	
	public void destroy () {
		
	}
}
