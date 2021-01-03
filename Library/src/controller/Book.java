package controller;

import java.time.LocalDate;

public class Book {

	private String title;
	private Author author;
	private boolean available;
	private LocalDate rentalDate;
	private LocalDate returnDate;
	private String category;

	public Book(String title, Author author) {
		this.title = title;
		this.author = author;
		this.author.addBook(this);
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

	public LocalDate getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(LocalDate rentalDate) {
		this.rentalDate = rentalDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author.getSurName() + ", availability=" + available + ", rentalDate="
				+ rentalDate + ", returnDate=" + returnDate + ", category=" + category + "]";
	};

}
