package view;

import java.net.URL;
import java.util.ResourceBundle;

import controller.LibraryController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddClientController implements Initializable {

	private LibraryController libraryController;

	@FXML
	private ClientController clientController;
	@FXML
	private AnchorPane addBorderPane;
	@FXML
	private Button clientControllAddButton;
	@FXML
	private Button clientControllBackButton;
	@FXML
	private TextField nameTextField;
	@FXML
	private TextField lastNameTextField;
	@FXML
	private TextField emailTextField;
	@FXML
	private TextField idTextField;
	@FXML
	private TextField telephoneTextField;
	@FXML
	private TextField townTextField;
	@FXML
	private TextField streetTextField;
	@FXML
	private TextField nrTextField;

	public AddClientController() {
		this.libraryController = new LibraryController();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Sprawdza czy wpisywane sa cyfry. Jesli nie to nie zamienia na puste
		idTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.matches("\\d*")) return;
			idTextField.setText(newValue.replaceAll("[^\\d]", ""));
		});
		
		telephoneTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.matches("\\d*")) return;
			telephoneTextField.setText(newValue.replaceAll("[^\\d]", ""));
		});
		
		nrTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.matches("\\d*")) return;
			nrTextField.setText(newValue.replaceAll("[^\\d]", ""));
		});
		
	}

	@FXML
	public void onClientControllAddButton(ActionEvent event) {
		libraryController.addNewClient(nameTextField.getText(), lastNameTextField.getText(), emailTextField.getText(),
				streetTextField.getText(), nrTextField.getText(), townTextField.getText(), telephoneTextField.getText(),
				idTextField.getText());
		nameTextField.clear();
		lastNameTextField.clear();
		emailTextField.clear();
		emailTextField.clear();
		idTextField.clear();
		telephoneTextField.clear();
		townTextField.clear();
		streetTextField.clear();
		nrTextField.clear();
	}

	public void setParentController(ClientController clientController) {
		// Ustawienie controlera rodzica
		this.clientController = clientController;
	}

	@FXML
	public void clientControllBackButton(ActionEvent event) {
		addBorderPane.getChildren().clear();
		this.clientController.onClientBackButton(event);

	}

	public LibraryController getLibraryController() {
		return libraryController;
	}

}
