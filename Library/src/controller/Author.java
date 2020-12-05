package controller;

import java.util.ArrayList;

public class Author {

	private String name;
	private String surName;
	private ArrayList<Book> listOfBooks;
	
	public Author(String name, String sureName) {
		this.name = name;
		this.surName = sureName;
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
	
	private void addBook(Book book) {
		listOfBooks.add(book);
	}
	
	private void removeBook(Book book) {
		listOfBooks.remove(book);
	}
	
	private void removeBook(int i) {
		listOfBooks.remove(i);
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", surName=" + surName + ", listOfBooks=" + listOfBooks + "]";
	}
	
	
}
