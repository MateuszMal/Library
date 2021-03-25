package controller;

public class Newspaper extends Book {
	
	private int numberOfPages;

	public Newspaper(String title, Author author, int numberOfPages) {
		super(title, author);
		this.numberOfPages = numberOfPages;
		// TODO Auto-generated constructor stub
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
}
