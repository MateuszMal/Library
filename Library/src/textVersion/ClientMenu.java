package textVersion;

import java.util.Scanner;

import controller.LibraryManager;

public class ClientMenu implements MenuInterface{

	private LibraryManager libraryManager = new LibraryManager();
	private Scanner in;
	@Override
	public void showMenuItems() {
		in = new Scanner(System.in);

		System.out.println("Wybierz:");
		System.out.println();
		System.out.println("1. Poka¿ wszystkich klientów");
		System.out.println("2. Poka¿ info o kliencie");
		System.out.println("3. Dodaj klienta");
		System.out.println("4. Usuñ klienta");
		System.out.println("\n5. Powrót do menu glównego");

		int option = in.nextInt();

		while (option != 1 && option != 2 && option != 3 && option != 4
				&& option != 5) {
			System.out.println("Bledny wybor. Sprobuj jeszcze raz");
			option = in.nextInt();
		}
		
		switch (option) {
		case 1: {
			showClients();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}
	
	public void showClients() {
		
	}
}
