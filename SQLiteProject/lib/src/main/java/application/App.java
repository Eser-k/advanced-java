package application;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		int[] ids = {0,1,2};
		String[] names = {"Alice","Bob","Charlie"};
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/people";
		var conn = DriverManager.getConnection(dbUrl, "root", "hello");
		
		var stmt = conn.createStatement();
		
		var sql = "insert into user (id,name) values (?,?)";
		var insertStmt = conn.prepareStatement(sql);
		
		for(int i = 0; i < ids.length; i++){
			insertStmt.setInt(1, ids[i]);
			insertStmt.setString(2, names[i]);
			
			//insertStmt.executeUpdate();
		}
		
		insertStmt.close();
		
		sql = "Select id, name from user";
		var rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id + " : " + name);
		}
		
		
		stmt.close();
		
		conn.close();
	}

}
