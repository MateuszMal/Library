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

	private String music = "./src/Resource/beep-01a.mp3";
	private LibraryManager libManager;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		LibraryHolder libHolder = LibraryHolder.getInstance();
		libManager = libHolder.getLIbManager();

		// TODO czy ta klasa nie powinna miec LibraryController?
		Stage stage = primaryStage;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("./fxml/StackPaneWindow.fxml"));
	
		BorderPane borderPane = loader.load();
		
		Scene scene = new Scene(borderPane);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Library");
		primaryStage.show();
		
		// TODO nie dziala
		if(libManager.checkForReminders()) {
			Media sound = new Media(new File(music).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
		}
	}
	

}
