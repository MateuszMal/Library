package textVersion;

import java.io.IOException;

public class InfoMenu implements MenuInterface {

	@Override
	public void showMenuItems() {
		clrscr();

		System.out.println("** O programie **");
		System.out.println("\n  Biblioteka");
		System.out.println("Autor: Mateusz Malenta");
		System.out.println("Nr indexu: 230191");
		System.out.println("Przedmiot: Programowanie Komponentowe");
		System.out.println("GitHub: https://github.com/MateuszMal");
		System.out.println("rok: 2020");
		try {
			int in = System.in.read();
			clrscr();
			backToMainMenu();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}	}

}
