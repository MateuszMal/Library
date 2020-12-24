package utils;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FxmlUtils {

	public void fxmlLoader(ActionEvent event, String fxmlPath, Pane pane) {
		try {
			BorderPane newLoadedPane;
			Button tempButton = (Button) event.getSource();
			newLoadedPane = FXMLLoader.load(getClass().getResource(fxmlPath));
			pane.getChildren().clear();
			pane.getChildren().add(newLoadedPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
