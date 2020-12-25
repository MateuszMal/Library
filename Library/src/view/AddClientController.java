package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddClientController implements Initializable {

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
	private TextField townTetxField;
	@FXML
	private TextField streetTextField;
	@FXML
	private TextField nrTextField;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML
	public void onClientControllAddButton(ActionEvent event) {

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

}
