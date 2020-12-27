package view;

import java.net.URL;
import java.util.ResourceBundle;

import controller.LibraryHolder;
import controller.LibraryManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import utils.DialogsUtils;
import utils.FxmlUtils;

public class RentController implements Initializable {

	private FxmlUtils fxmlUtils = new FxmlUtils();

	private InterfaceController interfaceController;
	@FXML
	private BorderPane rentBorderPane;
	@FXML
	private TextField rentTitleField;
	@FXML
	private TextField rentClientNameField;
	@FXML
	private TextField rentClientLastNameField;
	@FXML
	private CheckBox allRentCheckBox;
	@FXML
	private Button addRentButton;
	@FXML
	private Button rentBackButton;

	private LibraryManager libManager;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Ustawia uniwersalnego singletona i pobiera jego instncje
		LibraryHolder libHolder = LibraryHolder.getInstance();
		libManager = libHolder.getLIbManager();
	}

	public boolean isTextFieldEmpty() {
		// Sprawdza czy wszystkie pola sa uzupelnione
		if (rentTitleField.getText().trim().isEmpty() || rentClientNameField.getText().trim().isEmpty()
				|| rentClientLastNameField.getText().trim().isEmpty())
			return false;
		else
			return true;
	}

	public void onRentBackButton(ActionEvent event) {

		fxmlUtils.fxmlLoader(event, "../view/fxml/StackPaneWindow.fxml", rentBorderPane);
	}

	public void onAddRentButton() {
		if (isTextFieldEmpty()) {
			if (libManager.addRentToLibrary(rentClientNameField.getText(), rentClientLastNameField.getText(),
					rentTitleField.getText())) {
				DialogsUtils.successAction();
			} else
				DialogsUtils.infoDialog("Nie uda³o siê zrealizowaæ tego wypo¿yczenia");
		} else
			DialogsUtils.emptyFields();
	}

}
