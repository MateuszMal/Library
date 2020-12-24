package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class BookControler implements Initializable {

	@FXML
	private InterfaceController interfaceController;
	
	@FXML
	private Button allBooksButton;
	@FXML
	private Button authorButton;
	@FXML
	private Button titleButton;
	@FXML
	private Button rentButton;
	@FXML
	private Button backButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void onBackButton() {
		System.out.println("Wroc");
	}
}
