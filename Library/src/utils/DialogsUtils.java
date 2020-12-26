package utils;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class DialogsUtils {

	public static void dialogAboutApp() {
		Alert aboutAppAlert = new Alert(Alert.AlertType.INFORMATION);
		aboutAppAlert.setTitle("O programie");
		aboutAppAlert.setHeaderText("Biblioteka");
		aboutAppAlert.setContentText("Autor: Mateusz Malenta"
				+ "\nNr indexu: 230191" + "\nPrzedmiot: Programowanie Komponentowe"
				+ "\nGitHub: https://github.com/MateuszMal"+ "\nrok: 2020");
		aboutAppAlert.showAndWait();
	}
	
	public static Optional<ButtonType> addClientConfirmationDialog() {
		Alert addClientDialog = new Alert(Alert.AlertType.CONFIRMATION);
		addClientDialog.setTitle("Dodaj klienta");
		addClientDialog.setHeaderText("Czy na pewno chcesz dodaæ tego klienta?");
		Optional<ButtonType> result = addClientDialog.showAndWait();
		return result;
	}
	
	public static Optional<ButtonType> removeClientConfirmationDialog() {
		Alert addClientDialog = new Alert(Alert.AlertType.CONFIRMATION);
		addClientDialog.setTitle("Usuñ klienta");
		addClientDialog.setHeaderText("Czy na pewno chcesz usunaæ tego klienta?");
		Optional<ButtonType> result = addClientDialog.showAndWait();
		return result;
	}
}
