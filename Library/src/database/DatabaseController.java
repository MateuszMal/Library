package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.Address;
import controller.Author;
import controller.Book;
import controller.Client;
import controller.RentalBook;

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
			String query = "SELECT Book.idBook, Book.title, Author.surName, Author.name FROM Book "
					+ "INNER JOIN Author ON Book.Author_name = Author.surName";
			ResultSet result = stmt.executeQuery(query);
			int idBook;
			String title, authorSurName, authorName;
			while (result.next()) {
				title = result.getString("Book.title");
				authorSurName = result.getString("Author.surName");
				authorName = result.getString("Author.name");
				idBook = result.getInt("Book.idBook");

				Author author = new Author(authorName, authorSurName);
				Book book = new Book(title, author);
				book.setId(idBook);
				listBooks.add(book);
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
				Date remindDate = result.getDate("Client.reminder");

				Address address = new Address(street, number, town);
				Client client = new Client(name, surName, email, address, telNumber, id);
				// Jesli ustawiono przypomnienie
				if (remindDate != null) {
					LocalDate reminder = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(remindDate));
					client.setReminder(reminder);
				}
				listClient.add(client);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listClient;
	}

	public Client findClient(String name, String surName) {
		Client client = null;
		try {
			conn = DriverManager.getConnection(DB_URL, userName, pass);
			stmt = conn.createStatement();

			String query = "SELECT * FROM Client JOIN Address ON Client.Address_street = Address.street "
					+ "WHERE Client.name = '" + name + "' AND Client.surName = '" + surName + "';";
			ResultSet result = stmt.executeQuery(query);
			int telNumber;
			long id;

			String _name, _surName, email, clientAddress, street, number, town;
			while (result.next()) {
				id = result.getLong("Client.idClient");
				telNumber = result.getInt("Client.telNumber");
				_name = result.getString("Client.name");
				_surName = result.getString("Client.surName");
				email = result.getString("Client.email");
				clientAddress = result.getString("Client.Address_street");
				street = result.getString("Address.street");
				number = result.getString("Address.number");
				town = result.getString("Address.town");
				Date remindDate = result.getDate("Client.reminder");

				Address address = new Address(street, number, town);
				client = new Client(_name, _surName, email, address, telNumber, id);
				// Jesli ustawiono przypomnienie
				if (remindDate != null) {
					LocalDate reminder = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(remindDate));
					client.setReminder(reminder);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return client;
	}

	public Book findBook(String title) {
		Book book = null;
		try {
			conn = DriverManager.getConnection(DB_URL, userName, pass);
			stmt = conn.createStatement();

			String query = "select * from Book JOIN Author ON Book.Author_name = Author.surName "
					+ "Where Book.title = '" + title + "';";
			ResultSet result = stmt.executeQuery(query);

			String _title, name, surName;
			while (result.next()) {
				_title = result.getString("Book.title");
				name = result.getString("Author.name");
				surName = result.getString("Author.surName");

				Author author = new Author(name, surName);
				book = new Book(_title, author);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return book;
	}

	public boolean deleteClient(String name, String surName, int id) {
		try {

			conn = DriverManager.getConnection(DB_URL, userName, pass);
			stmt = conn.createStatement();

			String query = "DELETE FROM Client WHERE Client.idClient = " + id + " AND Client.name = '" + name
					+ "' AND Client.surName ='" + surName + "';";
			stmt.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean deleteRent(RentalBook rent) {
		try {
			conn = DriverManager.getConnection(DB_URL, userName, pass);
			stmt = conn.createStatement();

			String querry = "DELETE FROM Rent WHERE Rent.idRent = " + rent.getId() + ";";
			stmt.executeUpdate(querry);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}
	
	public boolean deleteBook(Book book) {
		try {
			conn = DriverManager.getConnection(DB_URL, userName, pass);
			stmt = conn.createStatement();
			
			String querry = "DELETE FROM Book WHERE Book.idBook = " + book.getId() + ";";
			stmt.executeUpdate(querry);

			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	public List<RentalBook> listRent() {

		List<RentalBook> listRents = new ArrayList<RentalBook>();
		try {
			conn = DriverManager.getConnection(DB_URL, userName, pass);
			stmt = conn.createStatement();

			String query = "SELECT * FROM Rent " + "JOIN Client ON Rent.Client_idClient = Client.idClient "
					+ "JOIN Book On Rent.Book_idBook = Book.idBook;";
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				String ClientName = result.getString("Client.name");
				String ClientSurName = result.getString("Client.surName");
				String title = result.getString("Book.title");
				int idRent = result.getInt("rent.idRent");
				Date rentDateTime = result.getDate("Rent.rentDateTime");
				Date endDateTime = result.getDate("Rent.endDateTime");

				Client client = findClient(ClientName, ClientSurName);
				Book book = findBook(title);

				RentalBook rentalBook = new RentalBook(book, client);

				// Parsowanie dat
				LocalDate rentDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(rentDateTime));
				LocalDate endDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(endDateTime));

				rentalBook.setId(idRent);
				rentalBook.setRentDateTime(rentDate);
				rentalBook.setEndDateTime(endDate);
				listRents.add(rentalBook);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return listRents;
	}

	public boolean insertClient(Client client) {
		try {
			conn = DriverManager.getConnection(DB_URL, userName, pass);
			PreparedStatement prepAdd = conn.prepareStatement("INSERT INTO Address VALUES(?, ?, ?);");
			prepAdd.setString(1, client.getAddress().getStreet());
			prepAdd.setString(2, client.getAddress().getNumber());
			prepAdd.setString(3, client.getAddress().getTown());
			prepAdd.execute();

			PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO Client VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
			int telN = (int) client.getTelNumber();
			int _id = (int) client.getId();

			prepStmt.setInt(1, _id);
			prepStmt.setString(2, client.getName());
			prepStmt.setString(3, client.getSurName());
			prepStmt.setString(4, client.getEmail());
			prepStmt.setString(5, null);
			prepStmt.setInt(6, telN);
			prepStmt.setString(7, client.getAddress().getStreet());
			if (client.getReminder() != null) {
				prepStmt.setDate(8, java.sql.Date.valueOf(client.getReminder()));
			} else
				prepStmt.setDate(8, null);
			prepStmt.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean insertRent(RentalBook rent) {
		try {
			LocalDate date = LocalDate.now();
			LocalDate endRentDay = date.plusDays(30);
			conn = DriverManager.getConnection(DB_URL, userName, pass);
			PreparedStatement prepAdd = conn.prepareStatement("INSERT INTO Rent VALUES(?, ?, ?, ?, ?, ?, ?, ?);");

			prepAdd.setInt(1, rent.getId());
			prepAdd.setString(2, rent.getBook().getTitle());
			prepAdd.setString(3, rent.getClient().getSurName());
			prepAdd.setDate(4, java.sql.Date.valueOf(rent.getRentDateTime()));
			prepAdd.setDate(5, java.sql.Date.valueOf(rent.getEndDateTime()));
			prepAdd.setDate(6, null);
			prepAdd.setInt(7, rent.getBook().getId());
			prepAdd.setInt(8, (int) rent.getClient().getId());
			prepAdd.execute();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}
	
	public boolean insertAuthor(Author author) {
		try {
			conn = DriverManager.getConnection(DB_URL, userName, pass);
			PreparedStatement prepAdd = conn.prepareStatement("INSERT INTO Author VALUES(?, ?, ?);");
			
			prepAdd.setString(1, author.getSurName());
			prepAdd.setString(2, author.getName());
			prepAdd.setString(3, null);
			prepAdd.execute();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public boolean insertBook(Book book) {
		try {
			conn = DriverManager.getConnection(DB_URL, userName, pass);
			PreparedStatement prepAdd = conn.prepareStatement("INSERT INTO Book VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
			
			prepAdd.setInt(1, book.getId());
			prepAdd.setString(2, book.getTitle());
			prepAdd.setString(3, book.getAuthor().getSurName());
			prepAdd.setBoolean(4, true);
			prepAdd.setDate(5, null);
			prepAdd.setDate(6, null);
			prepAdd.setString(7, null);
			prepAdd.setString(8, book.getAuthor().getSurName());
			prepAdd.execute();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

}
