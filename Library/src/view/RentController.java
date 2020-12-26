package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import utils.FxmlUtils;

public class RentController implements Initializable {

	private FxmlUtils fxmlUtils = new FxmlUtils();
	
	
	private InterfaceController interfaceController;
	@FXML
	private BorderPane rentBorderPane;
	@FXML
	private TextField rentTextField;	
	@FXML
	private TextField returnTextField;
	@FXML
	private CheckBox allRentCheckBox;
	@FXML
	private Button rentBackButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	
	public void onRentBackButton(ActionEvent event) {

		fxmlUtils.fxmlLoader(event, "../view/fxml/StackPaneWindow.fxml", rentBorderPane);
	}

	public void onReturnTextField(ActionEvent event) {
		if(allRentCheckBox.isSelected()) {
			rentTextField.clear();
			returnTextField.clear();
			// TODO Dodac wyswietlanie wszystkich wypozyczen
		}
	}
}
