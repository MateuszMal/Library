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

	public List<Author> listAuthor() {
		List<Author> listAuthors = new ArrayList<Author>();
		try {
			conn = DriverManager.getConnection(DB_URL, userName, pass);
			stmt = conn.createStatement();

			String query = "SELECT * FROM Author"; //WHERE surName LIKE " + lastName;
			ResultSet result = stmt.executeQuery(query);
			String surName, name;
			while(result.next()) {
				surName = result.getString("surName");
				name = result.getString("name");
				listAuthors.add(new Author(name, surName));
			}			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listAuthors;
	}
	
	public List<Book> listBook(){
		List<Book> listBooks = new ArrayList<Book>();
		try {
		List<Author> listAuthors = listAuthor();
		String query = "SELECT * FROM Book";
		ResultSet result = stmt.executeQuery(query);
		String title, authorSurName;
		while(result.next()) {
			title = result.getString("title");
			authorSurName = result.getString("author");
			System.out.println(authorSurName);
			for(Author a : listAuthors) {
				if(a.getSurName().equals(authorSurName)) {					
					listBooks.add(new Book(title, a));
				}
			}
			
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listBooks;
	}
}
