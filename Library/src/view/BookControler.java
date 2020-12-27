package view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.LibraryHolder;
import controller.LibraryManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
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
	private ObservableList<String> bookList;
	
	public void prepareList() {
		LibraryHolder libHolder = LibraryHolder.getInstance();
		LibraryManager libManager = libHolder.getLIbManager();
		List lista = libManager.getLibrary().getBooksList();
		bookList = FXCollections.observableArrayList(lista);
		bookListView.setItems(bookList);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		prepareList();
		
//		bookAllCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
//			@Override
//			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
//				// TODO Auto-generated method stub
//				if (newValue) {
//					bookListView.;
//					System.out.println("Jest");
//				} else {
//					bookListView.getItems().clear();
//					System.out.println("nie ma");
//				}
//			}
//		});

	}

	public void onBackButton(ActionEvent event) {
		fxmlUtils.fxmlLoader(event, "../view/fxml/StackPaneWindow.fxml", bookBorderPane);
	}

	public void onBookAllCheckView(ActionEvent event) {
		if (bookAllCheckBox.isSelected()) {
			bookAuthorTextField.clear();
			bookTitleTextField.clear();
			rentBookTextField.clear();
			// TODO Dodac wyswietlanie ksiazek
		}
	}
}
