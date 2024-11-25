package com.example.mySQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(User u) {
		var conn = Database.getInstance().getConnection();

		try {
			var stmt = conn.prepareStatement("insert into user (name) values (?)");
			stmt.setString(1, u.getName());
			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Optional<User> findByID(int id) {

		var conn = Database.getInstance().getConnection();

		try {
			var stmt = conn.prepareStatement("SELECT name from user WHERE id = ?");
			stmt.setInt(1, id);
			var rs = stmt.executeQuery();

			if (rs.next()) {
				var name = rs.getString("name");
				var user = new User(name, id);
				stmt.close();
				return Optional.of(user);
			}

			stmt.close();

		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return Optional.empty();

	}

	@Override
	public void update(User u) {
		var conn = Database.getInstance().getConnection();

		try {
			var stmt = conn.prepareStatement("UPDATE user SET name = ? WHERE id = ?");
			stmt.setString(1, u.getName());
			stmt.setInt(2, u.getId());
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public void delete(User u) {
		var conn = Database.getInstance().getConnection();

		try {
			var stmt = conn.prepareStatement("DELETE FROM user WHERE id = ?");
			stmt.setInt(1, u.getId());
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public List<User> getAll() {

		var conn = Database.getInstance().getConnection();
		List<User> users = new ArrayList<User>();

		try {
			var stmt = conn.createStatement();

			var rs = stmt.executeQuery("SELECT * from user");

			while (rs.next()) {
				var id = rs.getInt("id");
				var name = rs.getString("name");
				users.add(new User(name, id));
			}

			stmt.close();

		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return users;
	}

}
