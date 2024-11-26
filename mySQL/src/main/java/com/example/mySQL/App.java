package com.example.mySQL;

import java.sql.SQLException;
import java.util.Properties;

public class App {
	public static void main(String[] args) {
		
		var props = Profile.getProperties("db");
		
		var db = Database.getInstance();
		
		try {
			db.connect(props);
		} catch (SQLException e) {
			System.out.println("Cannot connect to the Database");
		}

		System.out.println("Connected");

		UserDao userDao = new UserDaoImpl();
		// userDao.save(new User("Mars"));
		// userDao.save(new User("Mercury"));
		
		//userDao.delete(new User("Alice", 1));
		userDao.update(new User("Neptune", 5));

		var users = userDao.getAll();
		users.forEach(System.out::println);

		var user = userDao.findByID(3);

		if (user.isPresent()) {
			System.out.println("Retrieved User: " + user.get().getName());
		} else {
			System.out.println("No such user");
		}

		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Cannot close Database Connection");
		}
	}
}
