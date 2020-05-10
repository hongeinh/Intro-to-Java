package hust.soict.globalict.aims;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddDVDMenuItemController implements Initializable {

	ArrayList<DigitalVideoDisc> dvdList;

	@FXML
	private TextField dvdTitleTextField;

	@FXML
	private TextField dvdCategoryTextField;

	@FXML
	private TextField dvdCostTextField;

	@FXML
	private TextField dvdLengthTextField;

	@FXML
	private TextField dvdDirectorTextField;

	@FXML
	private TextField dvdPlayTitleTextField;

	@FXML
	private TextField dvdPlayLengthTextField;

	@FXML
	private Label statusLabel;

	@FXML
	private Button addDVDButton;

	@FXML
	private Button playDVDButton;

	public AddDVDMenuItemController() {
		dvdList = new ArrayList<DigitalVideoDisc>();
	}

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		dvdTitleTextField.setEditable(true);
		dvdCategoryTextField.setEditable(true);
		dvdCostTextField.setEditable(true);
		dvdLengthTextField.setEditable(true);
		dvdDirectorTextField.setEditable(true);

		dvdPlayTitleTextField.setEditable(false);
		dvdPlayLengthTextField.setEditable(false);
	}

	public void addDVD(ActionEvent event) {
		System.out.println("Add DVD pressed");
		if (dvdTitleTextField.getText().trim().isEmpty() || dvdCategoryTextField.getText().trim().isEmpty()
				|| dvdCostTextField.getText().isEmpty()) {
			statusLabel.setText("One of the DVD fields are empty");
		} else {
			String title = dvdTitleTextField.getText().trim();
			String category = dvdCategoryTextField.getText().trim();
			float cost = Float.parseFloat(dvdCostTextField.getText());
			DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, dvdDirectorTextField.getText(),
					Integer.parseInt(dvdLengthTextField.getText()), cost);
			dvdList.add(dvd);
			System.out.println("Add title text: " + dvdTitleTextField.getText());
			System.out.println("Add category text: " + dvdCategoryTextField.getText());
			System.out.println("Add cost text: " + dvdCostTextField.getText());
			statusLabel.setText("DVD of ID " + dvd.getMediaId() + " added to temp.");

			// clear fields after button is pressed
			dvdTitleTextField.clear();
			dvdCategoryTextField.clear();
			dvdCostTextField.clear();
			dvdDirectorTextField.clear();
			dvdLengthTextField.clear();
		}
	}

	public void playDVD(ActionEvent event) {
		dvdPlayTitleTextField.setText(dvdList.get(dvdList.size()-1).getTitle());
		dvdPlayLengthTextField.setText(Integer.toString(dvdList.get(dvdList.size()-1).getLength()));
	}
	
	public ArrayList<DigitalVideoDisc> getDVDList(){
		return dvdList;
	}
}
