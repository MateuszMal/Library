package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import utils.FxmlUtils;

public class BookControler implements Initializable {

	private FxmlUtils fxmlUtils = new FxmlUtils();
	
	@FXML
	private InterfaceController interfaceController;

	@FXML
	private BorderPane bookBorderPane;

	@FXML
	private Button allBooksButton;
	@FXML
	private TextField bookAuthorTextField;
	@FXML
	private TextField bookTitleTextField;
	@FXML
	private TextField rentBookTextField;
	@FXML
	private CheckBox bookAllCheckBox;
	@FXML
	private ListView bookListView; 
	@FXML
	private Button backButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void onBackButton(ActionEvent event) {
		fxmlUtils.fxmlLoader(event, "../view/fxml/StackPaneWindow.fxml", bookBorderPane);
	}
	
	public void onBookAllCheckView(ActionEvent event) {
		if(bookAllCheckBox.isSelected()) {
			bookAuthorTextField.clear();
			bookTitleTextField.clear();
			rentBookTextField.clear();
			// TODO Dodac wyswietlanie ksiazek
		}
	}
}
