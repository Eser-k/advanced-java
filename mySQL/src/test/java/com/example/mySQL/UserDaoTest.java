package com.example.mySQL;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class UserDaoTest {
	
	private Connection conn;
	
	@BeforeEach
	public void setUp() throws SQLException {
		var props = Profile.getProperties("db");
		var db = Database.getInstance();
		db.connect(props);
		conn = db.getConnection();
		
	}
	
	@AfterEach
	public void tearDown() throws SQLException {
		Database.getInstance().close();
	}
	
	@Test
	public void TestSave() {
		assertTrue(true);
	}
}
