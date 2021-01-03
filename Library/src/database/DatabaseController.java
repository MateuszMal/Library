package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import controller.Address;
import controller.Author;
import controller.Book;
import controller.Client;

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

			String query = "SELECT * FROM Author"; // WHERE surName LIKE " + lastName;
			ResultSet result = stmt.executeQuery(query);
			String surName, name;
			while (result.next()) {
				surName = result.getString("surName");
				name = result.getString("name");
				listAuthors.add(new Author(name, surName));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listAuthors;
	}

	public List<Book> listBook() {
		List<Book> listBooks = new ArrayList<Book>();
		try {
			conn = DriverManager.getConnection(DB_URL, userName, pass);
			stmt = conn.createStatement();

			List<Author> listAuthors = listAuthor();
			String query = "SELECT * FROM Book";
			ResultSet result = stmt.executeQuery(query);
			String title, authorSurName;
			while (result.next()) {
				title = result.getString("title");
				authorSurName = result.getString("author");
				for (Author a : listAuthors) {
					if (a.getSurName().equals(authorSurName)) {
						listBooks.add(new Book(title, a));
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listBooks;
	}

	public List<Address> listAddress() {
		List<Address> listAddress = new ArrayList<Address>();
		try {
			conn = DriverManager.getConnection(DB_URL, userName, pass);
			stmt = conn.createStatement();

			String query = "SELECT * FROM Address";
			ResultSet result = stmt.executeQuery(query);
			String street, number, town;
			while (result.next()) {
				street = result.getString("street");
				number = result.getString("number");
				town = result.getString("town");
				listAddress.add(new Address(street, number, town));
			}
		} catch (Exception e) {
			System.out.println("B³ad");
			System.out.println(e.getMessage());
		}
		return listAddress;
	}

	public List<Client> listClient() {
		List<Client> listClient = new ArrayList<Client>();
		try {
			conn = DriverManager.getConnection(DB_URL, userName, pass);
			stmt = conn.createStatement();

			String query = "SELECT * FROM Client";
			ResultSet result = stmt.executeQuery(query);
			int telNumber;
			long id;
			//Address address;
			String name, surName, email, address;
			while(result.next()) {
				id = result.getLong("idClient");
				telNumber = result.getInt("telNumber");
				name = result.getString("name");
				surName = result.getString("surName");
				email = result.getString("email");
				address = result.getString("Address_street");
				for(Address ad : listAddress()) {
					if(ad.getStreet().equals(address)) {
						listClient.add(new Client(name, surName, email, ad, telNumber, id));
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listClient;
	}
}
