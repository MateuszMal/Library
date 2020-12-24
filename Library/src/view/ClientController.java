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
		// TODO Auto-generated method stub
		
	}

	public void onClientBackButton(ActionEvent event) {

		fxmlUtils.fxmlLoader(event, "../view/fxml/StackPaneWindow.fxml", clientBorderPane);
		System.out.println("jestem");
	}
}
