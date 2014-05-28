package org.hillel.it.network.pull;

import java.sql.Connection;

public interface NetworkPull {
	public Connection getConnection();
	public void destroy();
}
