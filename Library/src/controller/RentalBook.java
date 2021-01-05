package controller;

import java.time.LocalDate;
import java.util.Date;

	/**
	 * Represents a rents
	 * @author mmate
	 *
	 */
public class RentalBook {

	private int id;

	private Book book;
	private Client client;
	// Data wypozyczenia
	private LocalDate rentDateTime;
	// Data przewidywanego zwrotu
	private LocalDate endDateTime;
	// Data rzyczywistego zwrotu ksiazki
	private LocalDate endRentDate;
	
	int rentalLength;
	


	public RentalBook(Book book, Client client) {
		this.book = book;
		this.client = client;
		this.client.addBook(book);
		this.rentDateTime = LocalDate.now();
		this.rentalLength = 0;
		this.book.setRentalDate(this.rentDateTime);
		this.endDateTime = rentDateTime.plusDays(30);
		this.book.setAvailable(false);
	}

	public Book getBook() {
		return book;
	}

	public Client getClient() {
		return client;
	}

	public LocalDate getRentDateTime() {
		return rentDateTime;
	}

	public LocalDate getEndDateTime() {
		return endDateTime;
	}

	public int getRentalLength() {
		return rentalLength;
	}
	
	public LocalDate getEndRentDate() {
		return endRentDate;
	}

	public void setEndRentDate(LocalDate endRentDate) {
		this.endRentDate = endRentDate;
	}
	
	public boolean isOnTimeReturn() {
		if(endRentDate.isAfter(endDateTime)) return false;
		else return true;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void setBook(Book book) {
		this.book = book;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setRentDateTime(LocalDate rentDateTime) {
		this.rentDateTime = rentDateTime;
	}

	public void setEndDateTime(LocalDate endDateTime) {
		this.endDateTime = endDateTime;
	}

	public void setRentalLength(int rentalLength) {
		this.rentalLength = rentalLength;
	}

	@Override
	public String toString() {
		return "RentalBook [book=" + book + ", client=" + client + ", rentDateTime=" + rentDateTime + ", endDateTime="
				+ endDateTime + ", rentalLength=" + rentalLength + "]";
	}

}
