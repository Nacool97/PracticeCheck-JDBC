package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class ConnectionHandler {
	
	
	public static Connection getConnection() {
		try {
			Properties properties = new Properties();
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("connection.properties"));
			String driverName = (String) properties.get("driver");
			String url = (String) properties.get("connection-url");
			String username = (String) properties.get("user");
			String password = (String) properties.get("password");
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
			return null;
		
	}

}
