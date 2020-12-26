package main;

import controller.LibraryController;
import javafx.application.Application;
import view.AddClientController;
import view.JavaFxInterface;

public class Main {

	public static void main(String[] args) {

		//System.out.println("Hello, Library");
		Application.launch(JavaFxInterface.class, args);
	    Runtime.getRuntime().halt(0);	
	    }
}
