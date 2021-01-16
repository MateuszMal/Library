package view;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.LibraryHolder;
import controller.LibraryManager;
import controller.RentalBook;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.layout.BorderPane;
import utils.FxmlUtils;

public class CalendarController implements Initializable {

	private FxmlUtils fxmlUtils = new FxmlUtils();

	@FXML
	private BorderPane calendarPane;
	@FXML
	private BorderPane calendarBorderPane;
	@FXML
	private Button calendarReturnButton;
	@FXML
	private DatePicker datePicker;
	@FXML
	private DatePickerSkin dateSkin;
	@FXML
	private TextArea calendarTextArea;

	private LibraryManager libManager;
	private ArrayList<LocalDate> returnDays;
	private ArrayList<RentalBook> rentList;
	private String text = "";

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		LibraryHolder libHolder = LibraryHolder.getInstance();
		libManager = libHolder.getLIbManager();

		returnDays = new ArrayList<>();

		rentList = (ArrayList<RentalBook>) libManager.getRentList();

		returnDays.addAll(libManager.getAllReturnDates());

		datePicker = new DatePicker(LocalDate.now());
		dateSkin = new DatePickerSkin(datePicker);
		Node popupContent = dateSkin.getPopupContent();

		calendarBorderPane.setCenter(popupContent);

		calendarTextArea.setWrapText(true);

		datePicker.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				for (RentalBook rent : rentList) {
					if (datePicker.getValue().equals(rent.getEndDateTime())) {
						String name = rent.getClient().getName();
						String lastname = rent.getClient().getSurName();
						String book = rent.getBook().getTitle();
						String date = rent.getEndDateTime().toString();
						text += date + " Klient: " + name + " " + lastname + " powinien dzi� odda� ksiazk� o tytule '" + book
								+ "'.\n";
					}
					calendarTextArea.setText(text);
				}
			}
		});

	}

	public void onCalendarReturnButton(ActionEvent event) {
		fxmlUtils.fxmlLoader(event, "../view/fxml/StackPaneWindow.fxml", calendarPane);
	}
}
