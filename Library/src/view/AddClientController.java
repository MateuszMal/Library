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

public class AddClientController implements Initializable {

//	private LibraryManager libraryController;

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

//	public AddClientController() {
//		//this.libraryController = new LibraryController();
//	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// Sprawdza czy wpisywane sa cyfry. Jesli nie to nie zamienia na puste
		idTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.matches("\\d*"))
				return;
			idTextField.setText(newValue.replaceAll("[^\\d]", ""));
		});

		telephoneTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.matches("\\d*"))
				return;
			telephoneTextField.setText(newValue.replaceAll("[^\\d]", ""));
		});

		nrTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.matches("\\d*"))
				return;
			nrTextField.setText(newValue.replaceAll("[^\\d]", ""));
		});

	}

	@FXML
	public void onClientControllAddButton(ActionEvent event) {
		
		if (isTextFieldsEmpty()) {
			//libraryController = new LibraryController();
			// Ustawia uniwersalnego singletona i pobiera jego instncje
			LibraryHolder libHolder = LibraryHolder.getInstance();
			LibraryManager libManager = libHolder.getLIbManager();
			
			// Przygotowanie okna dialogowego
			Optional<ButtonType> result = DialogsUtils.addClientConfirmationDialog();
			
			// Jesli pola wpisu nie sa puste utworz nwego klienta
			if (result.get() == ButtonType.OK) {
				libManager.addNewClient(nameTextField.getText(), lastNameTextField.getText(),
						emailTextField.getText(), streetTextField.getText(), nrTextField.getText(),
				
				// czyszcenie pol tekstowych		
				townTextField.getText(), telephoneTextField.getText(), idTextField.getText());
				nameTextField.clear();
				lastNameTextField.clear();
				emailTextField.clear();
				idTextField.clear();
				telephoneTextField.clear();
				townTextField.clear();
				streetTextField.clear();
				nrTextField.clear();
//				System.out.println(libManager.getLibrary().getClientList());
			}
		}
		else DialogsUtils.emptyFields();
	}

	public boolean isTextFieldsEmpty() {
		// Sprawdza czy wszystkie pola sa uzupelnione
		if (nameTextField.getText().trim().isEmpty() || lastNameTextField.getText().trim().isEmpty()
				|| emailTextField.getText().trim().isEmpty() || idTextField.getText().trim().isEmpty()
				|| telephoneTextField.getText().trim().isEmpty() || townTextField.getText().trim().isEmpty()
				|| streetTextField.getText().trim().isEmpty() || nrTextField.getText().trim().isEmpty())
			return false;
		else
			return true;
	}

	public void setParentController(ClientController clientController) {
		// Ustawienie controlera rodzica
		this.clientController = clientController;
	}

	@FXML
	public void clientControllBackButton(ActionEvent event) {
		// Powrot do poprzedniego okna
		addBorderPane.getChildren().clear();
		this.clientController.onClientBackButton(event);

	}

//	public void setLibraryController(LibraryManager libController) {
//		this.libraryController = libController;
//	}
//	public LibraryController getLibraryController() {
//		return libraryController;
//	}

}
