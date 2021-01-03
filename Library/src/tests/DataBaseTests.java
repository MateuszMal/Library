package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.Address;
import controller.Author;
import controller.Book;
import controller.Client;
import database.DatabaseController;

public class DataBaseTests {
	
	private List<Author> authorsList = new ArrayList<Author>(); 
	private List<Book> booksList = new ArrayList<Book>(); 
	private List<Address> addressList = new ArrayList<Address>();
	private List<Client> clientList = new ArrayList<Client>();
	private DatabaseController db = new DatabaseController();
	
//	@BeforeEach
//	void setup() {		
//	}
	
	@Test
	void testAuthorsList() {
		authorsList = db.listAuthor();	
		System.out.println(authorsList);
	}
	
	@Test
	void testBookList() {
		booksList = db.listBook();
		System.out.println(booksList);
	}
	
	@Test
	void testAddressList() {
		addressList = db.listAddress();
		System.out.println(addressList);
	}
	
	@Test
	void testClientsList() {
		clientList = db.listClient();
		System.out.println(clientList);
	}
	
//	@Test
//	void testInsertClient() {
//		//db.insertClient("Mateusz", "Matejko", "mm@com.pl", "D³uga", "14", "Kluki", "2343242", "5");
//	}
	
	@Test
	void testFindClient(){
		Client client = db.findClient("Jan", "Nowak");
		assertEquals("Jan", client.getName());
		assertEquals("Nowak", client.getSurName());
	}

}
