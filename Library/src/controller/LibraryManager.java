package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import database.DatabaseController;

public class LibraryManager {
	/*
	 * Manager Biblioteki - ulatwia komunikacje z biblioteka pozostalym obiektom.
	 */

	private Library library;
	private DatabaseController database;

	public LibraryManager() {
		this.library = new Library();
		this.database = new DatabaseController();
	}
	
	public boolean checkForReminders() {
		for(Client client : library.getClientList()) {
			if(client.isRemindSet()) {
				if(client.getReminder() == LocalDate.now()) {
					System.out.println("Je");

					return true;
				}
			}
		}
		System.out.println("Ne");

		return false;
	}

	public boolean addNewClient(String name, String surName, String email, String street, String number, String town,
			String telNumber, String id) {

//		Address address = new Address(street, number, town);
//		long telephoneNumber = Long.valueOf(telNumber);
//		long _id = Long.valueOf(id);
//		Client client = new Client(name, surName, email, address, telephoneNumber, _id);
//		library.addClient(client);
			
			return database.insertClient(name, surName, email, street, number, town, telNumber, id);
	}
	
	

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

	public ArrayList<Book> getBookListByTitle(String title) {
		ArrayList<Book> bookList = new ArrayList<>();
		for (Book book : library.getBooksList()) {
			if (book.getTitle().equals(title)) {
				bookList.add(book);
			}
		}
		return bookList;
	}
	
	public Book getBookByTitle(String title) {
		for (Book book : library.getBooksList()) {
			if (book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}

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
	
	public ArrayList<Book> getBookListByAuthor(String lastName){
		ArrayList<Book> bookList = new ArrayList<>();
		if (isAuthorInLibrary(lastName)) {
			for (Book book : library.getBooksList()) {
				if (book.getAuthor().getSurName().equals(lastName)) {
					bookList.add(book);
				}
			}
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

	public boolean addRentToLibrary(String name, String lastName, String title) {
		if (isClientInLibrary(name, lastName) && isBookInLibrary(title)) {
			Book book = getBookByTitle(title);
			Client client = getClientFromLib(name, lastName);
			RentalBook rent = new RentalBook(book, client);
			library.addRent(rent);
			return true;
		} else
			return false;
	}
	
	public boolean addRentToLibrary(String name, String lastName, String title, LocalDate date) {
		if (isClientInLibrary(name, lastName) && isBookInLibrary(title)) {
			Book book = getBookByTitle(title);
			Client client = getClientFromLib(name, lastName);
			client.setReminder(date);
			RentalBook rent = new RentalBook(book, client);
			library.addRent(rent);
			return true;
		} else
			return false;
	}

	// Zmienic zeby wyszukiwalo w wypozyczeniach
	public boolean isRentInLibrary(String bookTitle, String clientName,String clientLastName) {
		if (isBookInLibrary(bookTitle) && isClientInLibrary(clientName ,clientLastName))
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
	
	public ArrayList<RentalBook> getRentListByTitle(String title) {
		ArrayList<RentalBook> rentList = new ArrayList<>();
		if (isBookInLibrary(title)) {
			for (RentalBook rent : library.getListOfRentals()) {
				if (rent.getBook().getTitle().equals(title))
					rentList.add(rent);
			}
		}
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
	
	public ArrayList<RentalBook> getRentListByAuthor(String lastName) {
		ArrayList<RentalBook> rentList = new ArrayList<>();
		if (isAuthorInLibrary(lastName)) {
			for (RentalBook rent : library.getListOfRentals()) {
				if (rent.getBook().getAuthor().getSurName().equals(lastName))
					rentList.add(rent);
			}
		}
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
	
	public ArrayList<RentalBook> getRentListByClient(String clientLastName) {
		ArrayList<RentalBook> rentList = new ArrayList<>();
		if (isClientInLibrary(clientLastName)) {
			for (RentalBook rent : library.getListOfRentals()) {
				if (rent.getClient().getSurName().equals(clientLastName))
					rentList.add(rent);
			}
		}
		return rentList;
	}
	
	public RentalBook getRentByClient(String clientLastName, String title) {
		if (isClientInLibrary(clientLastName) && isBookInLibrary(title)) {
			for (RentalBook rent : library.getListOfRentals()) {
				if (rent.getClient().getSurName().equals(clientLastName)
						&& rent.getBook().getTitle().equals(title))
					return rent;
			}
		}
		return null;
	}
	
	public boolean returnRent(String clientName, String clientLastName, String title) {
		if(isRentInLibrary(title, clientName, clientLastName)) {
			// Znajdz klienta, ksiazke, wypo¿yczenie
			Client client = getClientFromLib(clientName, clientLastName);
			Book book = getBookByTitle(title);
			RentalBook rent = getRentByClient(clientLastName, title);
			library.removeRent(rent);
			return true;
		}		
		return false;
	}
	
	public ArrayList<LocalDate> getAllReturnDates(){
		ArrayList<LocalDate> returnDates = new ArrayList<>();
		for(RentalBook rent : library.getListOfRentals()) {
			returnDates.add(rent.getEndDateTime());
		}
		return returnDates;
	}
}










