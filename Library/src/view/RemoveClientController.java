package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RemoveClientController implements Initializable{

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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Sprawdza czy wpisywane sa cyfry. Jesli nie to nie zamienia na puste
		removeIdTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.matches("\\d*")) return;
			removeIdTextField.setText(newValue.replaceAll("[^\\d]", ""));
		});
	}

	public void setParentController(ClientController clientController) {
		// Ustawienie controllera rodzica 
		this.clientController = clientController;
	}
	
	@FXML
	public void onRemoveControllBackButton(ActionEvent event) {
		removeBorderPane.getChildren().clear();
		this.clientController.onClientBackButton(event);

	}
}
