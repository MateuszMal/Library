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

			String query = "SELECT * FROM Author"; 
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
			String query = "SELECT Book.title, Author.surName, Author.name FROM Book "
					+ "INNER JOIN Author ON Book.Author_name = Author.surName";
			ResultSet result = stmt.executeQuery(query);
			String title, authorSurName, authorName;
			while (result.next()) {
				title = result.getString("Book.title");
				authorSurName = result.getString("Author.surName");
				authorName = result.getString("Author.name");
				Author author = new Author(authorName, authorSurName);
				listBooks.add(new Book(title, author));
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

			String query = "SELECT * FROM Client INNER JOIN Address ON Client.Address_street = Address.street";
			ResultSet result = stmt.executeQuery(query);
			int telNumber;
			long id;

			String name, surName, email, clientAddress, street, number, town;
			while (result.next()) {
				id = result.getLong("Client.idClient");
				telNumber = result.getInt("Client.telNumber");
				name = result.getString("Client.name");
				surName = result.getString("Client.surName");
				email = result.getString("Client.email");
				clientAddress = result.getString("Client.Address_street");
				street = result.getString("Address.street");
				number = result.getString("Address.number");
				town = result.getString("Address.town");
				Address address = new Address(street, number, town);
				listClient.add(new Client(name, surName, email, address, telNumber, id));
//				for (Address ad : listAddress()) {
//					if (ad.getStreet().equals(address)) {
//						listClient.add(new Client(name, surName, email, ad, telNumber, id));
//					}
//				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listClient;
	}

	
}
