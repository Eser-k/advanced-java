package com.example.mySQL;

import java.sql.SQLException;

public class App {
	public static void main(String[] args) {

		var db = Database.getInstance();
		try {
			db.connect();
		} catch (SQLException e) {
			System.out.println("Cannot connect to the Database");
		}
		
		System.out.println("Connected");
		
		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Cannot close Database Connection");
		}
	}
}
