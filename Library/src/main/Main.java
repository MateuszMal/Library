package main;

import controller.Author;
import controller.Book;
import controller.LibraryHolder;
import controller.LibraryManager;
import javafx.application.Application;
import view.AddClientController;
import view.JavaFxInterface;

public class Main {

	public static void main(String[] args) {
		
		// Utworzenie instancji Biblioteki
		LibraryManager libraryManager = new LibraryManager();
		LibraryHolder libHolder = LibraryHolder.getInstance();
		libHolder.setLibManager(libraryManager);
		
		// Proby. Do usuniecia
		Author autor = new Author("Artur", "Nowak");
		Book book = new Book("Jakas", autor);
		Author autor1 = new Author("Artur1", "Nowak1");
		Book book1 = new Book("Jakas1", autor);
		libraryManager.getLibrary().addAuthor(autor);
		libraryManager.getLibrary().addAuthor(autor1);
		libraryManager.getLibrary().addBook(book);
		libraryManager.getLibrary().addBook(book1);

		//System.out.println("Hello, Library");
		Application.launch(JavaFxInterface.class, args);
	    
		
		
		Runtime.getRuntime().halt(0);	
	    }
}
