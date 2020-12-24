package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utils.FxmlUtils;

public class InterfaceController implements Initializable {
	// Chyba trzeba zmienic na StackPaneWindowController

	private FxmlUtils fxmlUtils = new FxmlUtils();
	@FXML
	private BorderPane borderPane;
	@FXML
	private Button bookButton;
//	@FXML
//	public void onBookButton(String fxmlPath) {
//		FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
//		Parent parent = null;
//		try {
//			parent = loader.load();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} borderPane.setCenter(parent);
//	}

//	@FXML
//	public void onBookButton() throws IOException {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("./fxml/BookBorderPane.fxml"));
//		Parent parent = (Parent) loader.load();
//		Stage stage = new Stage();
//		stage.setScene(new Scene(parent));
//		stage.show();
//		
//	}
	@FXML
	public void onBookButton(ActionEvent event) {
//		try {
//			BorderPane newLoadedPane;
//			Button tempButton = (Button) event.getSource();
//			newLoadedPane = FXMLLoader.load(getClass().getResource("./fxml/BookBorderpane.fxml"));
//			borderPane.getChildren().clear();
//			borderPane.getChildren().add(newLoadedPane);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		fxmlUtils.fxmlLoader(event, "../view/fxml/BookBorderpane.fxml", borderPane);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
