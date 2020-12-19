package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxInterface extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		StackPane stackPane = new StackPane();
		Button okButton = new Button("OK");
		stackPane.getChildren().add(okButton);
		
		Scene scene = new Scene(stackPane, 600, 600);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Library");
		primaryStage.show();
		}
}
