package textVersion;

import java.util.List;
import java.util.Scanner;

import controller.Client;
import controller.LibraryManager;

public class ClientMenu implements MenuInterface {

	private LibraryManager libraryManager = new LibraryManager();
	private Scanner in;

	@Override
	public void showMenuItems() {
		clrscr();

		in = new Scanner(System.in);

		System.out.println("Wybierz:");
		System.out.println();
		System.out.println("1. Poka¿ wszystkich klientów");
		System.out.println("2. Poka¿ info o kliencie");
		System.out.println("3. Dodaj klienta");
		System.out.println("4. Usuñ klienta");
		System.out.println("\n5. Powrót do menu glównego");

		int option = in.nextInt();

		while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5) {
			System.out.println("Bledny wybor. Sprobuj jeszcze raz");
			option = in.nextInt();
		}

		switch (option) {
		case 1: {
			showClients();
			break;
		}
		case 2: {
			in = new Scanner(System.in);
			System.out.println("Podaj imiê klienta:");
			String name = in.next();
			System.out.println("Podaj nazwisko klienta:");
			String surName = in.next();
			clientInfo(name, surName);
			break;
		}
		case 3: {
			addClient();
			break;
		}
		case 4: {
			in = new Scanner(System.in);
			System.out.println("Podaj imiê klienta:");
			String name = in.next();
			System.out.println("Podaj nazwisko klienta:");
			String surName = in.next();
			System.out.println("Podaj nr id:");
			int id = in.nextInt();
			removeClient(name, surName, id);
			break;
		}
		case 5: {
			clrscr();
			backToMainMenu();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}

	public void removeClient(String name, String lastName, int id) {
		if (libraryManager.removeClientFromLib(name, lastName, id)) {
			System.out.println("Uda³o siê!");
		} else {
			System.out.println("Ups. Coœ posz³o nie tak");
		}
		backToMenu();
	}

	public void addClient() {
		in = new Scanner(System.in);
		System.out.println("** Dodawanie klienta **");

		System.out.println("\nPodaj imie:");
		String name = in.nextLine();

		System.out.println("Podaj nazwisko:");
		String surName = in.nextLine();

		System.out.println("Podaj email:");
		String email = in.nextLine();

		System.out.println("Podaj numer telefonu:");
		String telNumber = in.nextLine();

		System.out.println("Podaj numer id:");
		String id = in.nextLine();

		System.out.println("Podaj ulicê:");
		String street = in.nextLine();

		System.out.println("Podaj numer domu:");
		String number = in.nextLine();

		System.out.println("Podaj miasto:");
		String town = in.nextLine();

		if (libraryManager.addNewClient(name, surName, email, street, number, town, telNumber, id)) {
			System.out.println("Uda³o siê!");
		} else {
			System.out.println("Ups. Coœ posz³o nie tak");
		}
		backToMenu();
	}

	public void clientInfo(String name, String surName) {
		List<Client> list = libraryManager.getClientList();
		for (Client client : list) {
			if (client.getName().equals(name) && client.getSurName().equals(surName)) {
				System.out.println(client);
			}
		}
		backToMenu();
	}

	public void showClients() {
		List<Client> list = libraryManager.getClientList();
		for (Client client : list) {
			System.out.println(client);
		}
		backToMenu();
	}
}
