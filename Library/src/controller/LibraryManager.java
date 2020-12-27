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

	public Client getClientFromLib(String name, String lastName, String id) {
		long _id = Long.valueOf(id);
		Client _client = null;
		for (Client client : library.getClientList()) {
			if (client.getName().equals(name) && client.getSurName().equals(lastName) && client.getId() == _id) {
				_client = client;
			}
		}
		return _client;
	}

	public boolean isClientInLibrary(String name, String lastName, String id) {
		boolean result = false;
		long _id = Long.valueOf(id);
		for (Client client : library.getClientList()) {
			if (client.getName().equals(name) && client.getSurName().equals(lastName) && client.getId() == _id) {
				return result = true;
			}
		}
		return result;
	}

	public Library getLibrary() {
		return library;
	}

}
