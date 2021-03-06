package view;

import java.io.File;

import controller.LibraryHolder;
import controller.LibraryManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class JavaFxInterface extends Application {


	private LibraryManager libManager;

	@Override
	public void start(Stage primaryStage) throws Exception {

		LibraryHolder libHolder = LibraryHolder.getInstance();
		libManager = libHolder.getLIbManager();

		Stage stage = primaryStage;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/view/fxml/StackPaneWindow.fxml"));

		BorderPane borderPane = loader.load();

		Scene scene = new Scene(borderPane);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Library");
		primaryStage.show();

	}
}
