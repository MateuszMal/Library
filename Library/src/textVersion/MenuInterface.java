package textVersion;

import java.io.IOException;

public interface MenuInterface {

	void showMenuItems();
	
	default void backToMainMenu() {
		MainMenu menu = new MainMenu();
		menu.showMenu();
	}
	
	default void backToMenu() {
		System.out.println("\nWcisnij dowolny klawisz, aby wróciæ do Menu.");

		try {
			int in = System.in.read();
			showMenuItems();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	default void clrscr() {
		 try {
	            if (System.getProperty("os.name").contains("Windows"))
	                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	            else
	                Runtime.getRuntime().exec("clear");
	        } catch (IOException | InterruptedException ex) {}

	}
}
