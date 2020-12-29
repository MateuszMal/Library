package view;

import java.net.URL;
import java.util.ResourceBundle;

import controller.LibraryManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utils.DialogsUtils;
import utils.FxmlUtils;

public class InterfaceController implements Initializable {

	private FxmlUtils fxmlUtils;
	
	@FXML
	private BorderPane borderPane;
	@FXML
	private Button bookButton;
	@FXML
	private Button rentButton;
	@FXML
	private Button clientButton;
	@FXML
	private Button calendarButton;
	@FXML
	private Button settingsButton;
	@FXML
	private Button infoButton;
	@FXML
	private Button exitButton;
	
	public InterfaceController() {

		this.fxmlUtils = new FxmlUtils();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}


	@FXML
	public void onBookButton(ActionEvent event) {

		fxmlUtils.fxmlLoader(event, "../view/fxml/BookBorderpane.fxml", borderPane);
	}
	
	public void onRentButton(ActionEvent event) {

		fxmlUtils.fxmlLoader(event, "../view/fxml/RentBorderPane.fxml", borderPane);
	}
	
	public void onclientButton(ActionEvent event) {

		fxmlUtils.fxmlLoader(event, "../view/fxml/ClientBorderPane.fxml", borderPane);
	}
	
	public void onCalendarButton(ActionEvent event) {

		fxmlUtils.fxmlLoader(event, "../view/fxml/CalendarBorderPane.fxml", borderPane);
	}
	
	public void onSettingsButton(ActionEvent event) {
		
		fxmlUtils.fxmlLoader(event, "../view/fxml/SettingsPane.fxml", borderPane);
	}
	
	public void onInfoButton(ActionEvent event) {

		DialogsUtils.dialogAboutApp();
	}
	
	@FXML
	public void onExitButton(ActionEvent event) {
		final Node source = (Node)event.getSource();
		final Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	
	public FxmlUtils getFxmlUtils() {
		return fxmlUtils;
	}

}
