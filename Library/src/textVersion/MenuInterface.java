package textVersion;

import java.io.IOException;

public interface MenuInterface {

	void showMenuItems();
	
	default void backToMainMenu() {
		MainMenu menu = new MainMenu();
		menu.showMenu();
	}
	
	default void backToMenu() {
		System.out.println("\nWcisnij dowolny klawisz, aby wr�ci� do Menu.");

		try {
			int in = System.in.read();
			showMenuItems();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
