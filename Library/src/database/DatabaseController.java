package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import controller.Author;
import controller.Book;

public class DatabaseController {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
	private Connection conn = null;
	private Statement stmt = null;
	private String userName = "root";
	private String pass = "lokomotywa";

	public DatabaseController() {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Author> findAuthor(String lastName) {
		List<Author> listAuthor = new ArrayList<Author>();
		try {
			conn = DriverManager.getConnection(DB_URL, userName, pass);
			stmt = conn.createStatement();
			System.out.println("jestem");

			String query = "SELECT * FROM Author"; //WHERE surName LIKE " + lastName;
			ResultSet result = stmt.executeQuery(query);
			String surName, name;
			while(result.next()) {
				surName = result.getString("surName");
				name = result.getString("name");
				listAuthor.add(new Author(surName, name));
			}
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listAuthor;
	}
}
