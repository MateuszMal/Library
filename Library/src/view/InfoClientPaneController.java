package view;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Client;
import controller.LibraryHolder;
import controller.LibraryManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import utils.DialogsUtils;

public class InfoClientPaneController implements Initializable {

	@FXML
	private ClientController clientController;
	@FXML
	private AnchorPane infoClientAnchorPane;
	@FXML
	private Button infoControllBackButton;
	@FXML
	private Button infoControllShowButton;
	@FXML
	private TextField infoNameTextField;
	@FXML
	private TextField infoLastNameTextField;
	@FXML
	private TextField infoIdTextField;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Sprawdza czy wpisywane sa cyfry. Jesli nie to nie zamienia na puste
		infoIdTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.matches("\\d*"))
				return;
			infoIdTextField.setText(newValue.replaceAll("[^\\d]", ""));
		});

	}

	public void setParentController(ClientController clientController) {
		// Ustawienie controllera rodzica
		this.clientController = clientController;
	}

	public boolean isTextFieldEmpty() {
		if (infoNameTextField.getText().trim().isEmpty() || infoLastNameTextField.getText().trim().isEmpty()
				|| infoIdTextField.getText().trim().isEmpty())
			return false;
		else
			return true;
	}

	public void onInfoControllShowButton() {
		if (isTextFieldEmpty()) {
			// Ustawia uniwersalnego singletona i pobiera jego instncje
			LibraryHolder libHolder = LibraryHolder.getInstance();
			LibraryManager libManager = libHolder.getLIbManager();

			// Sprawdza czy dany u¿ytkownik jest w bibliotece
//			if (libManager.isClientInLibrary(infoNameTextField.getText(), infoLastNameTextField.getText()) == true) {

				// Pobieram klienta z biblioteki
				Client client = libManager.getClientFromLib(infoNameTextField.getText(),
						infoLastNameTextField.getText());

				// Wyswietla info o kliencie
				DialogsUtils.infoDialog(client.toString());
//			} else
//				DialogsUtils.infoDialog("Nie ma takiego u¿ytkownika");

		} else
			DialogsUtils.emptyFields();
	}

	@FXML
	public void onInfoControllBackButton(ActionEvent event) {
		infoClientAnchorPane.getChildren().clear();
		this.clientController.onClientBackButton(event);

	}
}
