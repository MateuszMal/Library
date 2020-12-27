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
		libraryManager.getLibrary().addBook(book);

		//System.out.println("Hello, Library");
		Application.launch(JavaFxInterface.class, args);
	    
		
		
		Runtime.getRuntime().halt(0);	
	    }
}
