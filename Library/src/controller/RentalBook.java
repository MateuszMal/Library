package controller;

import java.util.Date;

public class RentalBook {

	private Book book;
	private Client client;
	private Date rentDateTime;
	private Date endDateTime;
	int rentalLength;
	
	public RentalBook(Book book, Client client, Date date) {
		this.book = book;
		this.client = client;
		this.rentDateTime = new Date();
		this.rentalLength = 0;
	}

	public Book getBook() {
		return book;
	}

	public Client getClient() {
		return client;
	}

	public Date getRentDateTime() {
		return rentDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public int getRentalLength() {
		return rentalLength;
	}

	@Override
	public String toString() {
		return "RentalBook [book=" + book + ", client=" + client + ", rentDateTime=" + rentDateTime + ", endDateTime="
				+ endDateTime + ", rentalLength=" + rentalLength + "]";
	}

}