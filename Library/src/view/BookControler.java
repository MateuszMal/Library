package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.Book;
import controller.LibraryHolder;
import controller.LibraryManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
	private ListView bookListView;
	@FXML
	private Button backButton;
	@FXML
	private Button searchBookButton;
	@FXML
	private Button allBookButton;
	
	private ObservableList<String> bookList;
	private ObservableList<Book> tmpObsBookList;
	private ArrayList<Book> tmpBookList;
	private LibraryManager libManager;
	
	public void prepareList() {
		
		// Przypisanie listy ksiazek do bookListView
		List lista = libManager.getLibrary().getBooksList();
		bookList = FXCollections.observableArrayList(lista);
		bookListView.setItems(bookList);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// Ustawia uniwersalnego singletona i pobiera jego instncje
		LibraryHolder libHolder = LibraryHolder.getInstance();
		libManager = libHolder.getLIbManager();
		prepareList();
	}
	
	public void onsearchBookButton() {
		// TODO Nie wyswietlac null jesli pole jest puste
		// Czyszczenie listy wyswietlnia
		bookListView.getItems().removeAll(bookList);
		
		// Tymczasowa lista
		tmpBookList = new ArrayList<Book>();
		tmpBookList.add(libManager.getBookFromLibraryByTitle(bookTitleTextField.getText()));
		tmpBookList.add(libManager.getBookFromLibraryByAuthor(bookAuthorTextField.getText()));
		tmpObsBookList = FXCollections.observableArrayList(tmpBookList);
		
		//Wyswietlanie wynikow
		bookListView.setItems(tmpObsBookList);
	}

	public void onBackButton(ActionEvent event) {
		fxmlUtils.fxmlLoader(event, "../view/fxml/StackPaneWindow.fxml", bookBorderPane);
	}
	
	public void onAllBookButton(ActionEvent event) {
		prepareList();
	}

}
