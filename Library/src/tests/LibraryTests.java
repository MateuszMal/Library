package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.Address;
import controller.Author;
import controller.Book;
import controller.Client;
import controller.Library;
import controller.RentalBook;
import java.time.LocalDate;

class LibraryTests {
	
	private Author author;
	private Book book;
	private Client client;
	private Address address;
	private RentalBook rent;
	private Library library;
	
	@BeforeEach
	void setup() {
		author = new Author("Jacek", "Nowak");
		book = new Book("Moja", author);
		book.setCategory("Dramat");
		book.setAvailable(true);
		address = new Address("Krotka", "12", "Lodz");
		client = new Client("Adam", "Nowak", "a@gmail.com", address, 6331214, 12);
		rent = new RentalBook(book, client);
	}
	
	@Test
	void testCreateAuthor() {
		assertEquals("Jacek", author.getName());
		assertEquals("Nowak", author.getSurName());
		assertEquals(1, author.getListOfBooks().size());	
	}
	
	@Test
	void testCreateBook() {
		book.setRentalDate(LocalDate.now());
		assertEquals("Moja", book.getTitle());
		assertEquals(author, book.getAuthor());	
		assertEquals("Dramat", book.getCategory());	
		assertEquals(false, book.isAvailable());
		assertEquals(LocalDate.now(), book.getRentalDate());	
	}
	
	@Test
	public void testCreateClient() {
		assertEquals("Adam", client.getName());
		assertEquals("Nowak", client.getSurName());
		assertEquals("a@gmail.com", client.getEmail());
		assertEquals(6331214, client.getTelNumber());
		assertEquals(12, client.getId());
		assertEquals(address, client.getAddress());
	}

	@Test
	void testRent() {
		
		assertEquals(book, client.getListOfRentalBooks().get(0));
		assertEquals(LocalDate.now(), rent.getRentDateTime());
		assertEquals(LocalDate.now().plusDays(30), rent.getEndDateTime());
		assertEquals(false, book.isAvailable());
		assertEquals(0, rent.getRentalLength());
	}
	
	@Test
	void testLibrary() {
		library = new Library();
		library.addAuthor(author);
		library.addClient(client);
		library.addBook(book);
		library.addRent(rent);
		
		assertEquals(1, library.getListOfRentals().size());
		assertEquals(1, library.getAuthorList().size());
		assertEquals(1, library.getClientList().size());
		assertEquals(1, library.getBooksList().size());
		
		library.removeRent(rent);
		assertEquals(0, library.getListOfRentals().size());
		assertEquals(true, rent.isOnTimeReturn());
		
		library.removeAuthor(author);
		assertEquals(0, library.getAuthorList().size());
		
		library.removeBook(book);
		assertEquals(0, library.getBooksList().size());
		
		library.removeClient(client);
		assertEquals(0, library.getClientList().size());
		
	}
}
