package textVersion;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import controller.Client;
import controller.LibraryManager;
import controller.RentalBook;

public class RentMenu implements MenuInterface {

	private LibraryManager libraryManager = new LibraryManager();
	private Scanner in;

	public void showMenuItems() {
		in = new Scanner(System.in);

		System.out.println("Wybierz:");
		System.out.println();
		System.out.println("1. Poka¿ wszystkie wypo¿yczenia");
		System.out.println("2. Szukaj wypo¿yczenia wg nazwiska klienta");
		System.out.println("3. Szukaj wypo¿yczenia wg tytu³u ksia¿ki");
		// TODO do zrobienia
		System.out.println("4. Utwórz wypo¿yczenie");
		System.out.println("5. Oddaj ksi¹¿kê");

		System.out.println("\n6. Powrót do menu glównego");

		int option = in.nextInt();

		while (option != 1 && option != 2 && option != 3 && option != 4) {
			System.out.println("Bledny wybor. Sprobuj jeszcze raz");
			option = in.nextInt();
		}

		if (option == 1) {
			showAllRents();
		}
		
		if (option == 2) {
			System.out.println("Podaj nazwisko klienta: ");
			in = new Scanner(System.in);
			String name = in.next();
			showClientRents(name);
		}
		
		if (option == 3) {
			System.out.println("Podaj tytu³ ksia¿ki: ");
			in = new Scanner(System.in);
			String title = in.nextLine();
			showRentsBook(title);
		}
		
		if(option == 4) {
			createRent();
		}
		
		if (option == 6) {
			backToMainMenu();
		}

	}
	
	public void createRent() {
		in = new Scanner(System.in);
		
		System.out.println("** Dodawanie wypo¿yczenia **");
		System.out.println("\nPodaj nazwisko klienta:");
		String clientSurName = in.nextLine();
		
		System.out.println("Podaj imê klienta:");
		String clientName = in.nextLine();
		
		System.out.println("Podaj tytu³ ksia¿ki:");
		String title = in.nextLine();

		
		for(Client cli : libraryManager.getClientList()) {
			if(cli.getSurName().equals(clientSurName) && cli.getName().equals(clientName)) {
				LocalDate date = LocalDate.now();
				if(libraryManager.addRentToLibrary(cli.getName(), cli.getSurName(), title, date)) {
					System.out.println("Uda³o siê!");
				}
				else {
					System.out.println("Ups. Coœ posz³o nie tak.");
				}
			}
		}
		backToMenu();
	}

	public void showAllRents() {
		List<RentalBook> listRents = libraryManager.getRentList();
		for (RentalBook rent : listRents) {
			System.out.println(rent);
		}
		backToMenu();
	}

	public void showClientRents(String lastName) {
		List<RentalBook> listRents = libraryManager.getRentList();
		for (RentalBook rent : listRents) {
			if (rent.getClient().getSurName().equals(lastName)) {
				System.out.println(rent);
			}
		}
		backToMenu();
	}
	
	public void showRentsBook(String title) {
		List<RentalBook> listRents = libraryManager.getRentList();
		for (RentalBook rent : listRents) {
			if(rent.getBook().getTitle().equals(title))
				System.out.println(rent);
		}
		backToMenu();

	}

}
