package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class RemoveClientController implements Initializable{

	@FXML
	private ClientController clientController;
	
	@FXML
	private AnchorPane removeBorderPane;
	
	@FXML
	private Button removeControllBackButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public void setParentController(ClientController clientController) {
		// Ustawienie controlera rodzica 
		this.clientController = clientController;
	}
	
	@FXML
	public void onRemoveControllBackButton(ActionEvent event) {
		removeBorderPane.getChildren().clear();
		this.clientController.onClientBackButton(event);

	}
}
