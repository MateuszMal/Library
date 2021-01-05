package controller;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents a Client
 * @author mmate
 *
 */

public class Client {

	private String name;
	private String surName;
	private String email;
	private long id;
	private Address address;
	private long telNumber;
	private ArrayList<Book> listOfRentalBooks;
	private LocalDate reminder;

	/**
	 * Create a client
	 * @param name The client's name
	 * @param surName The client's last name
	 * @param email The client's email address
	 * @param address The client's address
	 * @param telNumber The client's telephone number
	 * @param id The client's id number
	 */

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
	
	public LocalDate getReminder() {
		return reminder;
	}
	/**
	 * Method sets the date of the book return reminder
	 * @param reminder
	 */
	public void setReminder(LocalDate reminder) {
		this.reminder = reminder;
	}

	public boolean isRemindSet() {
		if(reminder != null) return true;
		return false;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", surName=" + surName + ", email=" + email + ", address=" + address
				+ ", telNumber=" + telNumber + ", listOfRentalBooks=" + listOfRentalBooks + ", id= " + id + "]";
	}

}
