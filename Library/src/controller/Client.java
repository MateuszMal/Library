package controller;

import java.util.ArrayList;

public class Client {

	private String name;
	private String surName;
	private String email;
	private long id;
	private Address address;
	private long telNumber;
	private ArrayList<Book> listOfRentalBooks;

	public Client(String name, String surName, String email, Address address, long telNumber, long id) {
		super();
		this.name = name;
		this.surName = surName;
		this.email = email;
		this.address = address;
		this.telNumber = telNumber;
		this.id = id;
		listOfRentalBooks = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getSurName() {
		return surName;
	}

	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Address getAddress() {
		return address;
	}

	public long getTelNumber() {
		return telNumber;
	}

	public ArrayList<Book> getListOfRentalBooks() {
		return listOfRentalBooks;
	}

	public void setListOfRentalBooks(ArrayList<Book> listOfRentalBooks) {
		this.listOfRentalBooks = listOfRentalBooks;
	}

	public void addBook(Book book) {
		listOfRentalBooks.add(book);
	}

	public void removeBook(Book book) {
		listOfRentalBooks.remove(book);
	}

	public void removeBook(int i) {
		listOfRentalBooks.remove(i);
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", surName=" + surName + ", email=" + email + ", address=" + address
				+ ", telNumber=" + telNumber + ", listOfRentalBooks=" + listOfRentalBooks + ", id= " + id + "]";
	}

}
