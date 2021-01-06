package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseController;

/**
 * Library manager - a class that manages the library
 * 
 * @author mmate
 *
 */

public class LibraryManager {

	/**
	 * Stores Library instance
	 */
	private Library library;
	/**
	 * Stores DataBase controller instance
	 */
	private DatabaseController database;

	public LibraryManager() {
		this.library = new Library();
		this.database = new DatabaseController();
	}

	public boolean checkForReminders() {
		for (Client client : database.listClient()) {
			if (client.getReminder() != null) {
				if (client.getReminder().compareTo(LocalDate.now()) == 0) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Adds a new client to the database
	 * 
	 * @param name
	 * @param surName
	 * @param email
	 * @param street
	 * @param number
	 * @param town
	 * @param telNumber
	 * @param id
	 * @return Returns true if the operation was successful, false if not
	 */

	public boolean addNewClient(String name, String surName, String email, String street, String number, String town,
			String telNumber, String id) {

//		Address address = new Address(street, number, town);
//		long telephoneNumber = Long.valueOf(telNumber);
//		long _id = Long.valueOf(id);
//		Client client = new Client(name, surName, email, address, telephoneNumber, _id);
//		library.addClient(client);
		long _telNumber = Long.valueOf(telNumber);
		long _id = Long.valueOf(id);
		Address address = new Address(street, number, town);
		Client  client = new Client(name, surName, email, address, _telNumber, _id);
		return database.insertClient(client);
	}

	/**
	 * Returns a list of books store in database
	 * 
	 * @return
	 */

	public List<Book> getBookList() {
		List<Book> list = database.listBook();
		return list;
	}

	/**
	 * Returns a list of rents store in database
	 * 
	 * @return
	 */

	public List<RentalBook> getRentList() {
		List<RentalBook> list = database.listRent();
		return list;
	}

	/**
	 * Returns client from database
	 * 
	 * @param name     The client's name
	 * @param lastName The client's last name
	 * @return returns client
	 */

	public Client getClientFromLib(String name, String lastName) {
		Client _client = null;
//		for (Client client : library.getClientList()) {
//			if (client.getName().equals(name) && client.getSurName().equals(lastName)) {
//				_client = client;
//			}
//		}
		_client = database.findClient(name, lastName);
		return _client;
	}

	/**
	 * Removes client from database
	 * 
	 * @param name    The client's name
	 * @param surName The client's last name
	 * @param id      The client's id number
	 * @return Returns true if the operation was successful, false if not
	 */

	public boolean removeClientFromLib(String name, String surName, int id) {
		return database.deleteClient(name, surName, id);
	}

	public boolean isClientInLibrary(String name, String lastName) {
		boolean result = false;
		for (Client client : library.getClientList()) {
			if (client.getName().equals(name) && client.getSurName().equals(lastName)) {
				return result = true;
			}
		}
		return result;
	}

	public boolean isClientInLibrary(String lastName) {
		boolean result = false;
		for (Client client : library.getClientList()) {
			if (client.getSurName().equals(lastName)) {
				return result = true;
			}
		}
		return result;
	}

	/**
	 * Returns library instance
	 * 
	 * @return Library
	 */
	public Library getLibrary() {
		return library;
	}

	public boolean isAuthorInLibrary(String authorLastName) {
		boolean result = false;
		for (Author author : library.getAuthorList()) {
			if (author.getSurName().equals(authorLastName)) {
				return result = true;
			}
		}
		return result;
	}

	/**
	 * Returns a list of books by title
	 * 
	 * @param title The book's title
	 * @return List of books
	 */

	public ArrayList<Book> getBookListByTitle(String title) {
		ArrayList<Book> bookList = new ArrayList<>();
//		for (Book book : library.getBooksList()) {
//			if (book.getTitle().equals(title)) {
//				bookList.add(book);
//			}
//		}
		for (Book book : database.listBook()) {
			if (book.getTitle().equals(title))
				bookList.add(book);
		}

			return bookList;

	}

	/**
	 * Returns a book by title
	 * 
	 * @param title Book's title
	 * @return
	 */

	public Book getBookByTitle(String title) {
		for (Book book : library.getBooksList()) {
			if (book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}

	/**
	 * Returns a book by author
	 * 
	 * @param lastName Author's last name
	 * @return
	 */

	public Book getBookByAuthor(String lastName) {
		if (isAuthorInLibrary(lastName)) {
			for (Book book : library.getBooksList()) {
				if (book.getAuthor().getSurName().equals(lastName)) {
					return book;
				}
			}
		}
		return null;
	}

	/**
	 * Returns a list of books by author's last name
	 * 
	 * @param lastName The author's last name
	 * @return List of books
	 */

	public ArrayList<Book> getBookListByAuthor(String lastName) {
		ArrayList<Book> bookList = new ArrayList<>();
//		if (isAuthorInLibrary(lastName)) {
//			for (Book book : library.getBooksList()) {
//				if (book.getAuthor().getSurName().equals(lastName)) {
//					bookList.add(book);
//				}
//			}
		for (Book book : database.listBook()) {
			if (book.getAuthor().getSurName().equals(lastName))
				bookList.add(book);
		}
		return bookList;
	}

	public boolean isBookInLibrary(String title) {
		boolean result = false;
		for (Book book : library.getBooksList()) {
			if (book.getTitle().equals(title)) {
				return result = true;
			}
		}
		return result;
	}

	public boolean addRentToLibrary(String name, String lastName, String title, LocalDate date) {
	
		if (getBookListByTitle(title).size() != 0) {
			Book book = getBookListByTitle(title).get(0);
		
		Client client = getClientFromLib(name, lastName);
		client.setReminder(date);

		if (client != null || book != null) {
			RentalBook rent = new RentalBook(book, client);

			int id = (int) (Math.random() * 1000);
			rent.setId(id);
			if (database.insertRent(rent)) {
				return true;
			} else
				return false;
		} else
			return false;}
		 else
				return false;
	}
	
	public boolean returnRent(String clientName, String clientLastName, String title) {
		List<RentalBook> rentList = getRentList();

		for(RentalBook rent : rentList) {
			if(rent.getBook().getTitle().equals(title) && rent.getClient().getSurName().equals(clientLastName)
					&& rent.getClient().getName().equals(clientName)) {
				database.deleteRent(rent);
				return true;
			}
		}
		return false;
	}

	// Zmienic zeby wyszukiwalo w wypozyczeniach
	public boolean isRentInLibrary(String bookTitle, String clientName, String clientLastName) {
		if (isBookInLibrary(bookTitle) && isClientInLibrary(clientName, clientLastName))
			return true;
		else
			return false;
	}

	public RentalBook getRentByTitle(String title) {
		if (isBookInLibrary(title)) {
			for (RentalBook rent : library.getListOfRentals()) {
				if (rent.getBook().getTitle().equals(title))
					return rent;
			}
		}
		return null;
	}

	/**
	 * Returns list of rentals by book's title
	 * 
	 * @param title The book's title
	 * @return RentalBook list
	 */

	public ArrayList<RentalBook> getRentListByTitle(String title) {
		ArrayList<RentalBook> rentList = new ArrayList<>();
		// if (isBookInLibrary(title)) {
		for (RentalBook rent : getRentList()) {
			if (rent.getBook().getTitle().equals(title))
				rentList.add(rent);
		}
		// }
		return rentList;
	}

	public RentalBook getRentByAuthor(String lastName) {
		if (isAuthorInLibrary(lastName)) {
			for (RentalBook rent : library.getListOfRentals()) {
				if (rent.getBook().getAuthor().getSurName().equals(lastName))
					return rent;
			}
		}
		return null;
	}

	/**
	 * Returns rental list by author's last name
	 * 
	 * @param lastName The author's last name
	 * @return RentalBook list
	 */

	public ArrayList<RentalBook> getRentListByAuthor(String lastName) {
		ArrayList<RentalBook> rentList = new ArrayList<>();
		// if (isAuthorInLibrary(lastName)) {
		for (RentalBook rent : getRentList()) {
			if (rent.getBook().getAuthor().getSurName().equals(lastName))
				rentList.add(rent);
		}
		// }
		return rentList;
	}

	public RentalBook getRentByClient(String clientLastName) {
		if (isClientInLibrary(clientLastName)) {
			for (RentalBook rent : library.getListOfRentals()) {
				if (rent.getClient().getSurName().equals(clientLastName))
					return rent;
			}
		}
		return null;
	}

	/**
	 * Returns list of rentals by client's last name
	 * 
	 * @param clientLastName The client's last name
	 * @return RentalBook list
	 */

	public ArrayList<RentalBook> getRentListByClient(String clientLastName) {
		ArrayList<RentalBook> rentList = new ArrayList<>();
//		if (isClientInLibrary(clientLastName)) {
		for (RentalBook rent : getRentList()) {
			if (rent.getClient().getSurName().equals(clientLastName))
				rentList.add(rent);
		}
//		}
		return rentList;
	}

	public RentalBook getRentByClient(String clientLastName, String title) {
		if (isClientInLibrary(clientLastName) && isBookInLibrary(title)) {
			for (RentalBook rent : library.getListOfRentals()) {
				if (rent.getClient().getSurName().equals(clientLastName) && rent.getBook().getTitle().equals(title))
					return rent;
			}
		}
		return null;
	}



	public ArrayList<LocalDate> getAllReturnDates() {
		ArrayList<LocalDate> returnDates = new ArrayList<>();
		for (RentalBook rent : getRentList()) {
			returnDates.add(rent.getEndDateTime());
		}
		return returnDates;
	}
}
