package com.example.mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Database db = new Database();
	private static final String URL = "jdbc:mysql://localhost:3306/people"; 
	private Connection conn;
	
	public static Database getInstance() {
		return db;
	}
	
	private Database() {
		
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void connect() throws SQLException {
		this.conn = DriverManager.getConnection(this.URL, "root", "hello");
	}
	 
	public void close() throws SQLException {
		this.conn.close();
	}
	
	
}
