package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import utils.FxmlUtils;

public class SettingsController implements Initializable {

	private FxmlUtils fxmlUtils = new FxmlUtils();

	@FXML
	private BorderPane settingsBorderPane;
	@FXML
	private Button changeColour;
	@FXML
	private Button settingsBackButton;
	@FXML
	private ComboBox<String> coloursComboBox;

	public void onChangeColour() throws IOException {
		// TODO jesli nie wybrano koloru rzuca bledem
		// TODO dodac zapis do pliku
		// TODO dodac globalne ustawienia kolorow !!!!
		if (coloursComboBox.getValue() != null) {
			String colour = coloursComboBox.getValue();
			switch (colour) {
			case "Niebieski": {
				settingsBorderPane.getParent().setStyle("-fx-background-color:  rgb(204,229,255);");
				break;
			}
			case "Zielony": {
				settingsBorderPane.getParent().setStyle("-fx-background-color: #98FB98;");
				break;
			}

			case "Koralowy": {
				settingsBorderPane.getParent().setStyle("-fx-background-color: #FF7F50;");
				break;
			}
			}
		}

	}

	public void onSettingsBackButton(ActionEvent event) {

		fxmlUtils.fxmlLoader(event, "../view/fxml/StackPaneWindow.fxml", settingsBorderPane);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		coloursComboBox.getItems().addAll("Niebieski", "Zielony", "Koralowy");

	}

}
