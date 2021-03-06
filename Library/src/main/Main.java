package main;

import controller.LibraryHolder;
import controller.LibraryManager;
import javafx.application.Application;
import textVersion.MainMenu;
import view.JavaFxInterface;

public class Main {

	public static void main(String[] args) {
		
		// Utworzenie instancji Biblioteki
		LibraryManager libraryManager = new LibraryManager();
		LibraryHolder libHolder = LibraryHolder.getInstance();
		libHolder.setLibManager(libraryManager);
		
		if(args.length == 0) {
			Application.launch(JavaFxInterface.class, args);
		}
		else {
			if(args[0].equals("text")) {
				MainMenu mainMenu = new MainMenu();
				mainMenu.showTitle();
				mainMenu.showMenu();
			}
			else {
				System.out.println("Nieprawidłowy argument!");
			}
		}			
		Runtime.getRuntime().halt(0);	
	    }
}
