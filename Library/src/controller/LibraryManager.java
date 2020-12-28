package controller;

public class LibraryManager {
	/*
	 * Manager Biblioteki - ulatwia komunikacje z biblioteka pozostalym obiektom.
	 */

	private Library library;

	public LibraryManager() {
		this.library = new Library();
	}

	public void addNewClient(String name, String surName, String email, String street, String number, String town,
			String telNumber, String id) {
		Address address = new Address(street, number, town);
		long telephoneNumber = Long.valueOf(telNumber);
		long _id = Long.valueOf(id);
		Client client = new Client(name, surName, email, address, telephoneNumber, _id);
		library.addClient(client);
	}

	public Client getClientFromLib(String name, String lastName) {
		Client _client = null;
		for (Client client : library.getClientList()) {
			if (client.getName().equals(name) && client.getSurName().equals(lastName)) {
				_client = client;
			}
		}
		return _client;
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

	public Book getBookFromLibraryByTitle(String title) {
		Book _book = null;
		for (Book book : library.getBooksList()) {
			if (book.getTitle().equals(title)) {
				_book = book;
			}
		}
		return _book;
	}

	public Book getBookFromLibraryByAuthor(String lastName) {
		Book _book = null;
		if (isAuthorInLibrary(lastName)) {
			for (Book book : library.getBooksList()) {
				if (book.getAuthor().getSurName().equals(lastName)) {
					_book = book;
				}
			}
		}
		return _book;
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
			Book book = getBookFromLibraryByTitle(title);
			Client client = getClientFromLib(name, lastName);
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

	public RentalBook getRentByAuthor(String lastName) {
		if (isAuthorInLibrary(lastName)) {
			for (RentalBook rent : library.getListOfRentals()) {
				if (rent.getBook().getAuthor().getSurName().equals(lastName))
					return rent;
			}
		}
		return null;
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
			Book book = getBookFromLibraryByTitle(title);
			RentalBook rent = getRentByClient(clientLastName, title);
			library.removeRent(rent);
			return true;
		}		
		return false;
	}
}










