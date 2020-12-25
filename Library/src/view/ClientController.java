package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import utils.FxmlUtils;

public class ClientController implements Initializable {

	private FxmlUtils fxmlUtils = new FxmlUtils();
	
	private InterfaceController interfaceController;
	
	@FXML
	// Wstrzykniecie controllera klasy potomnej
	private AddClientController addClientController;
	
	@FXML
	// Wstrzykniecie controllera klasy potomnej
	private RemoveClientController removeClientController;
	
	@FXML
	private BorderPane clientBorderPane;
	
	@FXML
	private Button clientAddButton;
	@FXML
	private Button clientRemoveButton;
	@FXML
	private Button clientInfoButton;
	@FXML
	private Button clientBackButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Ustawienie tego controllera jako rodzica 
		
		addClientController.setParentController(this);
		removeClientController.setParentController(this);
		
	}

	public void onClientBackButton(ActionEvent event) {

		fxmlUtils.fxmlLoader(event, "../view/fxml/StackPaneWindow.fxml", clientBorderPane);
	}
}
