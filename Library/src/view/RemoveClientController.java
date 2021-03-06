package view;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.LibraryHolder;
import controller.LibraryManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import utils.DialogsUtils;

public class RemoveClientController implements Initializable {

	@FXML
	private ClientController clientController;
	@FXML
	private AnchorPane removeBorderPane;
	@FXML
	private TextField removeNameTextField;
	@FXML
	private TextField removeLastNameTextField;
	@FXML
	private TextField removeIdTextField;
	@FXML
	private Button removeControllBackButton;
	@FXML
	private Button removeClientButton;

	private LibraryHolder libHolder;
	private LibraryManager libManager;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Sprawdza czy wpisywane sa cyfry. Jesli nie to nie zamienia na puste
		removeIdTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.matches("\\d*"))
				return;
			removeIdTextField.setText(newValue.replaceAll("[^\\d]", ""));
		});
	}

	public void setParentController(ClientController clientController) {
		// Ustawienie controllera rodzica
		this.clientController = clientController;
	}

	public boolean isTetxtFieldsEmpty() {
		// Sprawdza czy wszystkie pola sa uzupelnione
		if (removeNameTextField.getText().trim().isEmpty() || removeLastNameTextField.getText().trim().isEmpty()
				|| removeIdTextField.getText().trim().isEmpty())
			return false;
		else
			return true;

	}

	@FXML
	public void onRemoveClientButton(ActionEvent event) {

		libHolder = LibraryHolder.getInstance();
		libManager = libHolder.getLIbManager();

		// Jesli pola wpisu nie sa puste
		if (isTetxtFieldsEmpty()) {
			Optional<ButtonType> result = DialogsUtils.removeClientConfirmationDialog();
			if (result.get() == ButtonType.OK) {
				int id = Integer.valueOf(removeIdTextField.getText());
				if (libManager.removeClientFromLib(removeNameTextField.getText(), removeLastNameTextField.getText(),
						id)) {
					DialogsUtils.successAction();
				} else {
					DialogsUtils.infoDialog("Nie powiod�o si�");
				}

				removeNameTextField.clear();
				removeLastNameTextField.clear();
				removeIdTextField.clear();
			}
		} else
			DialogsUtils.emptyFields();
	}

	@FXML
	public void onRemoveControllBackButton(ActionEvent event) {
		removeBorderPane.getChildren().clear();
		this.clientController.onClientBackButton(event);

	}
}
