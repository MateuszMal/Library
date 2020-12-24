package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavaFxInterface extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		Stage stage = primaryStage;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("./fxml/StackPaneWindow.fxml"));
		BorderPane borderPane = loader.load();
		
//		InterfaceController controller = loader.getController();
//		System.out.println(controller);
		Scene scene = new Scene(borderPane);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Library");
		primaryStage.show();
		}
	}
//	@FXML
//	private void loadBookBorderPane(ActionEvent event) throws Exception{
//		BorderPane pane = FXMLLoader.load(getClass().getResource("./fxml/BookBorderPane.fxml"));
//		borderPane.getChildren().setAll(pane);
//	}

