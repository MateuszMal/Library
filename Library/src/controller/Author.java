package controller;

import java.util.ArrayList;

public class Author {

	private String name;
	private String surName;
	private ArrayList<Book> listOfBooks;
	
	public Author(String name, String sureName) {
		this.name = name;
		this.surName = sureName;
		this.listOfBooks = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getSurName() {
		return surName;
	}

	public ArrayList<Book> getListOfBooks() {
		return listOfBooks;
	}
	
	public void addBook(Book book) {
		listOfBooks.add(book);
	}
	
	public void removeBook(Book book) {
		listOfBooks.remove(book);
	}
	
	public void removeBook(int i) {
		listOfBooks.remove(i);
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", surName=" + surName + "]";//", listOfBooks=" + "]"; //listOfBooks + "]";
	}
	
	
}
