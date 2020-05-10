package hust.soict.globalict.aims;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Track;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddCDMenuItemController implements Initializable {

	ArrayList<CompactDisc> cdList;

	@FXML
	private TextField cdTitleTextField;

	@FXML
	private TextField cdCategoryTextField;

	@FXML
	private TextField cdCostTextField;

	@FXML
	private TextField trackTitleTextField;

	@FXML
	private TextField trackLengthTextField;

	@FXML
	private TextField cdLengthTextField;

	@FXML
	private TextField cdCurrentTitleTextField;

	@FXML
	private Button addCDButton;

	@FXML
	private Button addTrackButton;

	@FXML
	private Button playCDButton;

	@FXML
	private TableView<Track> trackPlayTableView;

	@FXML
	private TableColumn<Track, String> trackTitleTableColumn;

	@FXML
	private TableColumn<Track, Integer> trackLengthTableColumn;

	@FXML
	private Label statusLabel;
	
	@FXML
	private Label cdCurrentTitle;

	@FXML
	private Label trackTitleLabel;

	@FXML
	private Label trackLengthLabel;

	public AddCDMenuItemController() {
		cdList = new ArrayList<CompactDisc>();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cdTitleTextField.setVisible(true);
		cdTitleTextField.setEditable(true);

		cdCategoryTextField.setVisible(true);
		cdCategoryTextField.setEditable(true);

		cdCostTextField.setVisible(true);
		cdCostTextField.setEditable(true);

		cdLengthTextField.setVisible(true);

		addCDButton.setVisible(true);
		playCDButton.setVisible(true);

		// Tracks
		trackTitleTextField.setVisible(true);
		trackTitleTextField.setEditable(true);

		trackLengthTextField.setVisible(true);
		trackLengthTextField.setEditable(true);

		addTrackButton.setVisible(true);

		trackTitleLabel.setVisible(true);
		trackLengthLabel.setVisible(true);

		// trackPlayTableView.setVisible(false);
		trackTitleTableColumn.setCellValueFactory(new PropertyValueFactory<Track, String>("title"));
		trackLengthTableColumn.setCellValueFactory(new PropertyValueFactory<Track, Integer>("length"));

		trackTitleTableColumn.setSortType(TableColumn.SortType.DESCENDING);
		trackLengthTableColumn.setSortable(false);

		statusLabel.setVisible(true);
	}

	/**
	 * This function returns the CDList
	 */
	public ArrayList<CompactDisc> getCDList() {
		return cdList;
	}

	/*
	 * We add CD before adding tracks. It is mandatory that a CD has been created
	 * before tracks can be added to that CD.
	 */

	/**
	 * This function creates new CDs and add them to the temporary cdList in this
	 * controller
	 */
	@FXML
	public void addCD(ActionEvent event) {
		System.out.println("Add CD pressed");
		if (cdTitleTextField.getText().trim().isEmpty() || cdCategoryTextField.getText().trim().isEmpty()
				|| cdCostTextField.getText().isEmpty()) {
			statusLabel.setText("One of the CD fields are empty");
		} else {
			String title = cdTitleTextField.getText().trim();
			String category = cdCategoryTextField.getText().trim();
			float cost = Float.parseFloat(cdCostTextField.getText());
			CompactDisc cd = new CompactDisc(title, category, cost);
			cdList.add(cd);
			System.out.println("Add title text: " + cdTitleTextField.getText());
			System.out.println("Add category text: " + cdCategoryTextField.getText());
			System.out.println("Add cost text: " + cdCostTextField.getText());
			statusLabel.setText("Book of ID " + cd.getMediaId() + " added to temp.");
			cdCurrentTitleTextField.setText(cd.getTitle());
			cdLengthTextField.setText(Integer.toString(cd.getLength()));

			// clear fields after button is pressed
			cdTitleTextField.clear(); cdCategoryTextField.clear(); cdCostTextField.clear();
		}
	}

	/**
	 * This method adds tracks to the latest CD created in the CD list
	 */

	@FXML
	public void addTrack(ActionEvent event) {
		if (cdList.size() == 0) {
			statusLabel.setText("Can not add track since there is no CD");
		} else {
			if (trackTitleTextField.getText().trim().isEmpty() || trackLengthTextField.getText().trim().isEmpty()) {
				statusLabel.setText("One of the track fields are empty");
			} else {
				String title = trackTitleTextField.getText().trim();
				int length = Integer.parseInt(trackLengthTextField.getText());
				Track track = new Track(title, length);
				cdList.get(cdList.size() - 1).addTrack(track);
				
				statusLabel.setText("Track added to CD " + cdList.get(cdList.size() - 1).getTitle() + ".");
				cdLengthTextField.setText(Integer.toString(cdList.get(cdList.size() - 1).getLength()));
				
				trackTitleTextField.clear(); trackLengthTextField.clear();
			}
		}
	}

	/**
	 * This functions populates the table view with tracks of the current CD. It
	 * also calculates the CD length
	 */
	@FXML
	public void playCD(ActionEvent event) {
		System.out.println("Play CD is pressed");
		trackPlayTableView.setItems(getTracks());
	}

	/**
	 * This method returns tracks of the current CD to feed to table view when play
	 * button is pressed
	 */
	private ObservableList<Track> getTracks() {
		ObservableList<Track> list = FXCollections.observableArrayList(cdList.get(cdList.size() - 1).getTracks());
		return list;
	}
}
