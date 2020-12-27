package main;

import controller.LibraryHolder;
import controller.LibraryManager;
import javafx.application.Application;
import view.AddClientController;
import view.JavaFxInterface;

public class Main {

	public static void main(String[] args) {
		
		LibraryManager libraryManager = new LibraryManager();
		LibraryHolder libHolder = LibraryHolder.getInstance();
		libHolder.setLibManager(libraryManager);

		//System.out.println("Hello, Library");
		Application.launch(JavaFxInterface.class, args);
	    
		System.out.println(libraryManager.getLibrary().getClientList().toString());
		
		Runtime.getRuntime().halt(0);	
	    }
}
