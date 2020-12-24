package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utils.FxmlUtils;

public class InterfaceController implements Initializable {

	private FxmlUtils fxmlUtils = new FxmlUtils();
	@FXML
	private BorderPane borderPane;
	@FXML
	private Button bookButton;
	@FXML
	private Button rentButton;
	@FXML
	private Button clientButton;
	@FXML
	private Button settingsButton;
	@FXML
	private Button infoButton;
	@FXML
	private Button exitButton;

	@FXML
	public void onBookButton(ActionEvent event) {

		fxmlUtils.fxmlLoader(event, "../view/fxml/BookBorderpane.fxml", borderPane);
	}
	
	@FXML
	public void onExitButton(ActionEvent event) {
		final Node source = (Node)event.getSource();
		final Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

}
