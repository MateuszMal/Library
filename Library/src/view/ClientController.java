package view;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Client;
import controller.LibraryManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import utils.DialogsUtils;
import utils.FxmlUtils;

public class ClientController implements Initializable {

	private FxmlUtils fxmlUtils;
		
	@FXML
	// Wstrzykniecie controllera klasy potomnej
	private AddClientController addClientController;
	
	@FXML
	// Wstrzykniecie controllera klasy potomnej
	private RemoveClientController removeClientController;
	
	@FXML
	// Wstrzykniecie controllera klasy potomnej
	private InfoClientPaneController infoClientController;
	
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
	
	private LibraryManager libManager = new LibraryManager();
	
	
	
	public ClientController() {
		super();
		this.fxmlUtils = new FxmlUtils();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Ustawienie tego controllera jako rodzica 
		showReminders();
		addClientController.setParentController(this);
		removeClientController.setParentController(this);
		infoClientController.setParentController(this);
	}

	public void onClientBackButton(ActionEvent event) {

		fxmlUtils.fxmlLoader(event, "../view/fxml/StackPaneWindow.fxml", clientBorderPane);
	}

	public void showReminders() {
		LocalDate date = LocalDate.now();
		String text = "";
		for(Client client : libManager.clientWithReminders()) {
			if(client.getReminder().isEqual(date))
			text = client.getName() + " " + client.getSurName() + " ma dzi� do zwrotu ksi��k� " 
			+ client.getListOfRentalBooks();
		}
		if(!text.isEmpty())
			DialogsUtils.infoDialog(text);		
	}
}
