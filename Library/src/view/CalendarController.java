package view;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.layout.AnchorPane;
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
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		DatePickerSkin dateSkin = new DatePickerSkin(new DatePicker(LocalDate.now()));
		Node popupContent = dateSkin.getPopupContent();
		
		calendarBorderPane.setCenter(popupContent);

	}
	
	public void onCalendarReturnButton(ActionEvent event) {
		fxmlUtils.fxmlLoader(event, "../view/fxml/StackPaneWindow.fxml", calendarPane);
	}
}
