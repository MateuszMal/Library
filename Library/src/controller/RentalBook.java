package controller;

import java.time.LocalDate;
import java.util.Date;

public class RentalBook {

	private Book book;
	private Client client;
	// Data wypozyczenia
	private LocalDate rentDateTime;
	// Data przewidywanego zwrotu
	private LocalDate endDateTime;
	// Data rzyczywistego zwrotu ksiazki
	private LocalDate endRentDate;
	
	int rentalLength;
	
	//public RentalBook() {}

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

	@Override
	public String toString() {
		return "RentalBook [book=" + book + ", client=" + client + ", rentDateTime=" + rentDateTime + ", endDateTime="
				+ endDateTime + ", rentalLength=" + rentalLength + "]";
	}

}
