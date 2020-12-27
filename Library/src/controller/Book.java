package controller;

import java.util.Date;

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
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
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
