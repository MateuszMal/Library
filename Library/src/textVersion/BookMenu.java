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
		System.out.println("1. Poka¿ wszystkie ksi¹¿ki");
		System.out.println("2. Szukaj ksi¹¿ki wg autora");
		System.out.println("3. Szukaj ksi¹¿ki wg tytu³u");
		System.out.println("4. Powrót");

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
			System.out.println("Podaj tytu³ ksi¹¿ki: ");
			in = new Scanner(System.in);
			String title = in.next();
			showBookByAuthor(title);
		}
		
	}

	public void showAllBooks() {
		// TODO powrot do menu powyzej
		List<Book> listBook = libraryManager.getBookList();
		for (Book book : listBook) {
			System.out.println(book);
		}

	}

	public void showBookByAuthor(String name) {
		// TODO powrot do menu powyzej
		ArrayList<Book> listBook = libraryManager.getBookListByAuthor(name);
		for (Book book : listBook) {
			System.out.println(book);
		}
	}

	public void showBookByTitle(String title) {
		List<Book> listBook = libraryManager.getBookList();
		for (Book book : listBook) {
			if (book.getTitle().equals(title)) {
				System.out.println(book);
			}
		}
	}
}
