package com.kuebiko.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnectionUtils {
   private static String USER_NAME="root";
   private static String USER_PASSWORD="mysql@1234";
   private static String JDBC_URL="jdbc:mysql://localhost:3306/movie_db";
   private static String JDBC_DRIVER="com.mysql.jdbc.Driver";
   
	
	public static Connection getConn() throws Exception {
		  //Loading the driver
				Class.forName(JDBC_DRIVER);
				//Creating connection to the database
				Connection connection=DriverManager.getConnection(JDBC_URL,USER_NAME,USER_PASSWORD);
				return connection;
	}
}
