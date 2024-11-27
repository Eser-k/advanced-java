package com.example.mySQL;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class UserDaoImplTest {

	private Connection conn;
	private List<User> users;

	public void loadUsers() throws IOException {

		//@formatter:off
		this.users = Files
				.lines(Paths.get("../names.txt"))
				.map(User::new)
				.collect(Collectors.toList());
		//@formatter:on
	}

	@BeforeEach
	public void setUp() throws SQLException, IOException {

		loadUsers();

		var props = Profile.getProperties("db");
		var db = Database.getInstance();
		db.connect(props);
		conn = db.getConnection();
		conn.setAutoCommit(false);
	}

	@AfterEach
	public void tearDown() throws SQLException {
		Database.getInstance().close();
	}

	@Test
	public void testSaveMultiple() throws SQLException {
		UserDao userDao = new UserDaoImpl();

		for (var u : users) {
			userDao.save(u);
		}

		var stmt = conn.createStatement();

		var rs = stmt.executeQuery("SELECT * FROM user");

		int rowCount = 0;

		while (rs.next()) {
			rowCount++;
			var name = rs.getString("name");
			var id = rs.getInt("id");
			System.out.println(name + "," + id);
		}

		assertEquals(users.size(), rowCount, "Size of users and size of database mismatch");

	}

	@Test
	public void testSave() throws SQLException {

		User user = new User("Ares");
		UserDao userDao = new UserDaoImpl();
		userDao.save(user);

		var stmt = conn.createStatement();

		var rs = stmt.executeQuery("SELECT id,name FROM user ORDER BY id DESC");
		var result = rs.next();
		assertTrue(result, "Cannot retrieve inserted user");

		var name = rs.getString("name");
		assertEquals(name, user.getName(), "User name does not match retrieved one");

		stmt.close();

	}

}
