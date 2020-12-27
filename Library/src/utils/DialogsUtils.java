package utils;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

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
		addClientDialog.setHeaderText("Czy na pewno chcesz doda� tego klienta?");
		Optional<ButtonType> result = addClientDialog.showAndWait();
		return result;
	}
	
	public static Optional<ButtonType> removeClientConfirmationDialog() {
		Alert addClientDialog = new Alert(Alert.AlertType.CONFIRMATION);
		addClientDialog.setTitle("Usu� klienta");
		addClientDialog.setHeaderText("Czy na pewno chcesz usuna� tego klienta?");
		Optional<ButtonType> result = addClientDialog.showAndWait();
		return result;
	}
	
	public static void emptyFields() {
		Alert emptyField = new Alert(Alert.AlertType.INFORMATION);
		emptyField.setTitle("Uwaga");
		emptyField.setHeaderText("Nie mo�esz wykona�!");
		emptyField.setContentText("Niekt�re pola s� puste. Uzupe�nij.");
		emptyField.showAndWait();
	}
	
	public static void successAction() {
		Alert emptyField = new Alert(Alert.AlertType.INFORMATION);
		emptyField.setTitle("Uwaga");
		emptyField.setHeaderText("Uda�o si�.");
		emptyField.setContentText("Ta czynno�� zako�czy�a si� pomy�lnie.");
		emptyField.showAndWait();
	}
	
	public static void infoDialog(String string) {
		Alert infoDialog = new Alert(Alert.AlertType.INFORMATION);
		infoDialog.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		infoDialog.setTitle("Info");
		infoDialog.setHeaderText("Informacja");
		infoDialog.setContentText(string);
		infoDialog.showAndWait();
	}
	
}
