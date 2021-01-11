package textVersion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.Book;
import controller.LibraryManager;

public class BookMenu {

	private LibraryManager libraryManager = new LibraryManager();
	private Scanner in;

	public void showBooktMenu() {

		in = new Scanner(System.in);

		System.out.println("Wybierz:");
		System.out.println();
		System.out.println("1. Poka� wszystkie ksi��ki");
		System.out.println("2. Szukaj ksi��ki wg autora");
		System.out.println("3. Szukaj ksi��ki wg tytu�u");
		System.out.println("\n4. Powr�t do menu gl�wnego");

		int option = in.nextInt();

		while (option != 1 && option != 2 && option != 3 && option != 4) {
			System.out.println("Bledny wybor. Sprobuj jeszcze raz");
			option = in.nextInt();
		}

		if (option == 1) {
			showAllBooks();
		}
		if (option == 2) {
			System.out.println("Podaj nazwisko autora: ");
			in = new Scanner(System.in);
			String name = in.next();
			showBookByAuthor(name);
		}

		if (option == 3) {
			System.out.println("Podaj tytu� ksi��ki: ");
			in = new Scanner(System.in);
			String title = in.next();
			showBookByTitle(title);
		}
		
		if(option == 4) {
			backToMainMenu();
		}

	}

	public void backToMenu() {
		System.out.println("\nWcisnij dowolny klawisz, aby wr�ci� do Menu.");

		try {
			int in = System.in.read();
			showBooktMenu();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void showAllBooks() {
		// TODO powrot do menu powyzej
		List<Book> listBook = libraryManager.getBookList();
		for (Book book : listBook) {
			System.out.println(book);
		}
		backToMenu();
	}

	public void showBookByAuthor(String name) {
		// TODO powrot do menu powyzej
		ArrayList<Book> listBook = libraryManager.getBookListByAuthor(name);
		for (Book book : listBook) {
			System.out.println(book);
		}
		backToMenu();

	}

	public void showBookByTitle(String title) {
		List<Book> listBook = libraryManager.getBookList();
		for (Book book : listBook) {
			if (book.getTitle().equals(title)) {
				System.out.println(book);
			}
		}
		backToMenu();

	}
	
	public void backToMainMenu() {
		MainMenu menu = new MainMenu();
		menu.showMenu();
	}
}