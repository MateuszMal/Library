package main;

import java.time.LocalDate;

import controller.Address;
import controller.Author;
import controller.Book;
import controller.Client;
import controller.LibraryHolder;
import controller.LibraryManager;
import controller.RentalBook;
import javafx.application.Application;
import view.JavaFxInterface;

public class Main {

	public static void main(String[] args) {
		
		// Utworzenie instancji Biblioteki
		LibraryManager libraryManager = new LibraryManager();
		LibraryHolder libHolder = LibraryHolder.getInstance();
		libHolder.setLibManager(libraryManager);
		
		// Proby. Do usuniecia
		Address address = new Address("Pileckiego", "Lodz","21");
		Client client = new Client("Adam", "Kowalski", "email", address, 34534,23);
		Author autor = new Author("Artur", "Nowak");
		Book book = new Book("Jakas", autor);
		Author autor1 = new Author("Artur1", "Nowak1");
		Book book1 = new Book("Jakas1", autor);
		
		client.setReminder(LocalDate.now());
		
		libraryManager.getLibrary().addClient(client);
		libraryManager.getLibrary().addAuthor(autor);
		libraryManager.getLibrary().addAuthor(autor1);
		libraryManager.getLibrary().addBook(book);
		libraryManager.getLibrary().addBook(book1);
		RentalBook rent = new RentalBook(book, client);
		libraryManager.getLibrary().addRent(rent);

		//System.out.println("Hello, Library");
		Application.launch(JavaFxInterface.class, args);
	    
		
		
		Runtime.getRuntime().halt(0);	
	    }
}
