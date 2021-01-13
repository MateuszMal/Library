package textVersion;

import java.util.Scanner;

public class MainMenu {

	public void showTitle() {
		System.out.println("************************************");
		System.out.println("**                                **");
		System.out.println("**           Biblioteka           **");
		System.out.println("**                                **");
		System.out.println("************************************");
		System.out.println();
	}

	public void showMenu() {

		Scanner in = new Scanner(System.in);

		System.out.println("************************************");
		System.out.println("**            Wybierz:            **");
		System.out.println("**                                **");
		System.out.println("**          1. Ksi¹¿ka            **");
		System.out.println("**       2. Wypo¿yczenia          **");
		System.out.println("**          3. Klient             **");
		System.out.println("**           4. Info              **");
		System.out.println("**         5. Wyjœcie             **");
		System.out.println("************************************");

		int option = in.nextInt();

		while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5) {
			System.out.println("Bledny wybor. Sprobuj jeszcze raz");
			option = in.nextInt();
		}

		switch (option) {
		case 1: {
			BookMenu bookMenu = new BookMenu();
			bookMenu.showMenuItems();
			break;
		}
		case 2: {
			RentMenu rentMenu = new RentMenu();
			rentMenu.showMenuItems();
			break;
		}
		case 3: {
			ClientMenu clientMenu = new ClientMenu();
			clientMenu.showMenuItems();
			break;
		}
		case 5: {
			System.out.println("Good Bye");
			System.exit(0);
		}
		}

//		if (option == 1) {
//			BookMenu bookMenu = new BookMenu();
//			bookMenu.showMenuItems();
//		}
//
//		if (option == 2) {
//			RentMenu rentMenu = new RentMenu();
//			rentMenu.showMenuItems();
//		}
//		
//		if ()
//
//		if (option == 5) {
//			System.out.println("Good Bye");
//			System.exit(0);
//		}
	}

}
