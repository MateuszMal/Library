package controller;

import java.util.ArrayList;
import java.util.Date;

public class Library {
	
	private ArrayList<Book> BooksList;
	private ArrayList<Author> AuthorList;
	private ArrayList<Client> ClientList;
	private RentalBook rentalBook;
	private ArrayList<RentalBook> listOfRentals;
	
	public void addRent(RentalBook rent) {
		listOfRentals.add(rent);
	}
	
	public void removeRent(RentalBook rent) {
		listOfRentals.remove(rent);
	}
	
	public void removeRent(int i) {
		listOfRentals.remove(i);
	}
	
	public void addAuthor(Author author) {
		AuthorList.add(author);
	}
	
	public void removeAuthor(Author author) {
		AuthorList.remove(author);
	}
	
	public void addClient(Client client) {
		ClientList.add(client);
	}
	
	public void removeClient(Client client) {
		ClientList.remove(client);
	}
	
	public void addBook(Book book) {
		BooksList.add(book);
	}
	
	public void removeBook(Book book) {
		BooksList.remove(book);
	}

	public ArrayList<Book> getBooksList() {
		return BooksList;
	}

	public ArrayList<Author> getAuthorList() {
		return AuthorList;
	}

	public ArrayList<Client> getClientList() {
		return ClientList;
	}

	public RentalBook getRentalBook() {
		return rentalBook;
	}

	public ArrayList<RentalBook> getListOfRentals() {
		return listOfRentals;
	}
	
	public String alarm(RentalBook rent, Date date) {
		Date alarmDate = date;
		String alarmText = new String("Przypominamy o oddaniu ksi¹zki: " + rent.getBook().getTitle());
		String alarmText2 = new String("Termin oddania: " + rent.getEndDateTime().toString());
		return alarmText + alarmText2;
	}
	
	@Override
	public String toString() {
		return "Library [BooksList=" + BooksList + ", AuthorList=" + AuthorList + ", ClientList=" + ClientList
				+ ", rentalBook=" + rentalBook + ", listOfRentals=" + listOfRentals + "]";
	}
	
}
