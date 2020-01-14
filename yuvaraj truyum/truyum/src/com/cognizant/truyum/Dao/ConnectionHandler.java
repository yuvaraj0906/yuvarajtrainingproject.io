package com.cognizant.truyum.Dao;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

		static Connection getConnection() {

			BufferedInputStream bufferedInputStream = (BufferedInputStream) ConnectionHandler.class.getClassLoader()
					.getResourceAsStream("connection.properties");
			Properties prop = new Properties();
			try {
				prop.load(bufferedInputStream);
			} catch (IOException e) {
				System.out.println("unable to load/find connection.properties file");
			}
			String driver = (String) prop.get("driver");
			System.out.println("Driver Name->" + driver);
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				System.out.println("unable to load the my sql driver");
			}
			String user = (String) prop.get("user");
			String password = (String) prop.get("password");
			String url = (String) prop.get("url");
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(url, user, password);

			} catch (SQLException e) {
				System.out.println("unable to connect to database");
			}
			return connection;
		}

		public static void main(String[] args) {
		}
}
