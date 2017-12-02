package com.cestarcollege.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	
	private static DatabaseUtil instance = new DatabaseUtil();
	private Connection con = null;
	private DatabaseUtil(){}
	public static DatabaseUtil getInstance(){
		return instance;
	}
	
	public Connection getConnection() {
	    if(con!= null)
	    	return con;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
