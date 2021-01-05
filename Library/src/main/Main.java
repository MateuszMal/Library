package main;

import controller.LibraryHolder;
import controller.LibraryManager;
import javafx.application.Application;
import view.JavaFxInterface;

public class Main {

	public static void main(String[] args) {
		
		// Utworzenie instancji Biblioteki
		LibraryManager libraryManager = new LibraryManager();
		LibraryHolder libHolder = LibraryHolder.getInstance();
		libHolder.setLibManager(libraryManager);
		

		Application.launch(JavaFxInterface.class, args);
	    
		
		
		Runtime.getRuntime().halt(0);	
	    }
}
