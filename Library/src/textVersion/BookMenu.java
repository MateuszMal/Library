package textVersion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.Author;
import controller.Book;
import controller.LibraryManager;

public class BookMenu implements MenuInterface {

	private LibraryManager libraryManager = new LibraryManager();
	private Scanner in = new Scanner(System.in);

	public void showMenuItems() {

		in = new Scanner(System.in);

		System.out.println("Wybierz:");
		System.out.println();
		System.out.println("1. Poka¿ wszystkie ksi¹¿ki");
		System.out.println("2. Szukaj ksi¹¿ki wg autora");
		System.out.println("3. Szukaj ksi¹¿ki wg tytu³u");
		System.out.println("4. Dodaj ksi¹¿kê");
		System.out.println("5. Usuñ ksi¹¿kê");
		System.out.println("\n6. Powrót do menu glównego");

		int option = in.nextInt();

		while (option != 1 && option != 2 && option != 3 && option != 4
				&& option != 5 && option != 6) {
			System.out.println("Bledny wybor. Sprobuj jeszcze raz");
			option = in.nextInt();
		}

		switch (option) {
		case 1: {
			showAllBooks();
			break;
		}
		case 2: {
			System.out.println("Podaj nazwisko autora: ");
			//in = new Scanner(System.in);
			String name = in.next();
			showBookByAuthor(name);
			break;
		}
		case 3: {
			System.out.println("Podaj tytu³ ksi¹¿ki: ");
			//in = new Scanner(System.in);
			String title = in.nextLine();
			showBookByTitle(title);
			break;
		}
		case 4:{
			addBook();
			break;
		}
		case 6: {
			backToMainMenu();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}

	}
	
	public void addBook() {
		in = new Scanner(System.in);
		System.out.println("**Dodawanie ksi¹¿ki.**");
		System.out.println("Podaj imiê autora: ");
		String authorName = in.nextLine();
		
		System.out.println("Podaj nazwisko autora: ");
		String authorLastName = in.nextLine();
		Author author = new Author(authorName, authorLastName);
		
		System.out.println("Podaj tytu³ ksi¹¿ki: ");
		String title = in.nextLine();
		
		Book book = new Book(title, author);
		for(Author _author : libraryManager.getAuthorsList()) {
			if(_author.getSurName().equals(author)) {
				libraryManager.addBook(book);
				System.out.println("Uda³o siê!");
				backToMenu();
			}
			else {
				libraryManager.addNewAuthor(author);
				libraryManager.addBook(book);
				System.out.println("Uda³o siê!");
				backToMenu();

			}
		}		
			//System.out.println("Ups. Coœ posz³o nie tak.");
		
		backToMenu();
	}

	public void showAllBooks() {
		List<Book> listBook = libraryManager.getBookList();
		for (Book book : listBook) {
			System.out.println(book);
		}
		backToMenu();
	}

	public void showBookByAuthor(String name) {
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

}
