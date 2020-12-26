package controller;

public class LibraryController {

	private Library library;

	public LibraryController() {
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

}
