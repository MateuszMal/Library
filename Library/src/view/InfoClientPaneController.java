package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class InfoClientPaneController implements Initializable {
	
	@FXML
	private ClientController clientController;
	@FXML
	private AnchorPane infoClientAnchorPane;
	@FXML
	private Button infoControllBackButton;
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
			if(newValue.matches("\\d*")) return;
			infoIdTextField.setText(newValue.replaceAll("[^\\d]", ""));
		});
		
	}
	public void setParentController(ClientController clientController) {
		// Ustawienie controllera rodzica 
		this.clientController = clientController;
	}
	
	@FXML
	public void onInfoControllBackButton(ActionEvent event) {
		infoClientAnchorPane.getChildren().clear();
		this.clientController.onClientBackButton(event);

	}
}
