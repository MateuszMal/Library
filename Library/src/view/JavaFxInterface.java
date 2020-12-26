package view;

import java.io.IOException;

import controller.LibraryController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavaFxInterface extends Application {

	LibraryController libraryController = new LibraryController();
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		// TODO czy ta klasa nie powinna miec LibraryController?
		Stage stage = primaryStage;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("./fxml/StackPaneWindow.fxml"));
		BorderPane borderPane = loader.load();

//		InterfaceController contr = loader.getController();
		
		
		
		Scene scene = new Scene(borderPane);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Library");
		primaryStage.show();
	}
}
