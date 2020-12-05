package controller;

import java.sql.Date;

public class Book {

	private String title;
	private Author author;
	private boolean available;
	private Date rentalDate;
	private Date returnDate;
	private String category;
	
	public Book(String title, Author author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public Author getAuthor() {
		return author;
	}

	public boolean isAvailability() {
		return available;
	}

	private void setAvailability(boolean availability) {
		this.available = availability;
	}

	public Date getBorrowDate() {
		return rentalDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", availability=" + available + ", rentalDate="
				+ rentalDate + ", returnDate=" + returnDate + ", category=" + category + "]";
	};
	
	
}
