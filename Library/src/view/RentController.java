package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.LibraryHolder;
import controller.LibraryManager;
import controller.RentalBook;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import utils.DialogsUtils;
import utils.FxmlUtils;

public class RentController implements Initializable {

	// TODO wyszukiwanie wypozyczen poprzez ctrl+F
	private FxmlUtils fxmlUtils = new FxmlUtils();
	private InterfaceController interfaceController;

	// Glowny Pane
	@FXML
	private BorderPane rentBorderPane;

	// Zakladka Wypozycz ksiazke
	@FXML
	private TextField rentTitleField;
	@FXML
	private TextField rentClientNameField;
	@FXML
	private TextField rentClientLastNameField;
	@FXML
	private Button addRentButton;
	@FXML
	private Button rentBackButton;
	@FXML
	private DatePicker remindCallendar;

	// Zakladka Zwroc ksiazke
	@FXML
	private TextField returnTitleField;
	@FXML
	private TextField returnClientNameField;
	@FXML
	private TextField returnClientLastNameField;
	@FXML
	private Button addReturnButton;
	@FXML
	private Button rentBackButton2;

	// Zakladka Pokaz wypozyczenia
	@FXML
	private TextField showTitle1Field;
	@FXML
	private TextField showLastNameField;
	@FXML
	private TextField showAuthorField;
	@FXML
	private Button showSearchButton;
	@FXML
	private Button showAllButton;
	@FXML
	private Button rentBackButton3;
	@FXML
	private ListView rentListView;

	// Listy do wyswietlania wypozyczen
	private LibraryManager libManager;
	private ObservableList<RentalBook> rentList;
	private ObservableList<RentalBook> tmpRentList;
	private ListProperty<RentalBook> listProperty;
	private ArrayList<RentalBook> tmpList;

	public void onShowSearchButton() {

		// TODO nie wyswietlac null jesli jest puste
		// TODO Jesli rent == rent nie wyswietlac tych samych

		// Czyszczenie listy wyswietlania
		rentListView.getItems().removeAll(rentList);

		// Tymczasowa lista
		tmpList = new ArrayList<RentalBook>();
		tmpList.add(libManager.getRentByAuthor(showAuthorField.getText()));
		tmpList.add(libManager.getRentByClient(showLastNameField.getText()));
		tmpList.add(libManager.getRentByTitle(showTitle1Field.getText()));

		tmpRentList = FXCollections.observableArrayList(tmpList);

		rentListView.setItems(tmpRentList);
	}

	public void prepareList() {
		// Przygotowanie list do wyswietlania
		List lista = libManager.getLibrary().getListOfRentals();

		listProperty = new SimpleListProperty<>();
		rentList = FXCollections.observableArrayList(lista);

		listProperty.set(rentList);
	}

	public void onshowAllButton() {

		List lista = libManager.getLibrary().getListOfRentals();

		// Bindowanie list (listproperty obserwuje zmiany w rentList
		listProperty = new SimpleListProperty<>();
		rentList = FXCollections.observableArrayList(lista);
		// Wypisanie listy wypozyczen
		listProperty.set(rentList);
		rentListView.itemsProperty().bindBidirectional(listProperty);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Ustawia uniwersalnego singletona i pobiera jego instncje
		LibraryHolder libHolder = LibraryHolder.getInstance();
		libManager = libHolder.getLIbManager();

		prepareList();

	}

	public boolean isTextFieldEmptyRent() {
		// Sprawdza czy wszystkie pola sa uzupelnione
		if (rentTitleField.getText().trim().isEmpty() || rentClientNameField.getText().trim().isEmpty()
				|| rentClientLastNameField.getText().trim().isEmpty())
			return false;
		else
			return true;
	}

	public boolean isTextFieldEmptyReturn() {
		// Sprawdza czy wszystkie pola sa uzupelnione
		if (returnTitleField.getText().trim().isEmpty() || returnClientNameField.getText().trim().isEmpty()
				|| returnClientLastNameField.getText().trim().isEmpty())
			return false;
		else
			return true;
	}

	public void onRentBackButton(ActionEvent event) {

		fxmlUtils.fxmlLoader(event, "../view/fxml/StackPaneWindow.fxml", rentBorderPane);
	}

	public void onReturnRentButton() {
		if (isTextFieldEmptyReturn()) {
			if (libManager.returnRent(returnClientNameField.getText(), returnClientLastNameField.getText(),
					returnTitleField.getText())) {
				DialogsUtils.successAction();
			} else
				DialogsUtils.infoDialog("Nie uda³o siê zrealizowaæ tego zwrotu.");
		} else
			DialogsUtils.emptyFields();
	}

	public void onAddRentButton() {
		if (isTextFieldEmptyRent()) {
			if (libManager.addRentToLibrary(rentClientNameField.getText(), rentClientLastNameField.getText(),
					rentTitleField.getText())) {
				DialogsUtils.successAction();
			} else
				DialogsUtils.infoDialog("Nie uda³o siê zrealizowaæ tego wypo¿yczenia.");
		} else
			DialogsUtils.emptyFields();
	}

}
