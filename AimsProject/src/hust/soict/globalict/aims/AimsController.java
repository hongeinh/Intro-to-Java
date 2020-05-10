package hust.soict.globalict.aims;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.order.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Controller of Aims.fxml
 * 
 * @author Hong Einh
 *
 */
public class AimsController implements Initializable {

	ArrayList<Order> orderList;

	@FXML
	private MenuBar menubar;

	@FXML
	private AnchorPane parentPane;

	@FXML
	private MenuItem createOrderMenuItem;

	@FXML
	private MenuItem test;
	@FXML
	private MenuItem addDVDMenuItem;

	@FXML
	private MenuItem addBookMenuItem;

	@FXML
	private MenuItem addCDMenuItem;

	@FXML
	private MenuItem removeMediaMenuItem;

	@FXML
	private MenuItem displayOrderMenuItem;

	@FXML
	private TextField removeMediaTextField;

	@FXML
	private Button removeMediaButton;

	@FXML
	private Label statusLabel;

	@FXML
	private Label mediaIDLabel;

	@FXML
	private Label orderLabel;

	@FXML
	private TextField orderTextField;

	@FXML
	private Label dateLabel;

	@FXML
	private TextField dateTextField;

	@FXML
	private TableView<Media> displayTable;

	@FXML
	private TableColumn<Media, String> idTableColumn;

	@FXML
	private TableColumn<Media, String> titleTableColumn;

	@FXML
	private TableColumn<Media, String> categoryTableColumn;

	@FXML
	private TableColumn<Media, Float> costTableColumn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// When no order is initialized, set visibility of the belows to false
		setRemoveVisibilityFalse();
		statusLabel.setVisible(false);
		orderLabel.setVisible(false);
		orderTextField.setVisible(false);
		dateLabel.setVisible(false);
		dateTextField.setVisible(false);
		displayTable.setVisible(false);

		// create order list
		orderList = new ArrayList<Order>();
	}

	public void createOrderController(ActionEvent e) {
		System.out.println("Create order controller clicked");
		Order order = Order.createOrder();
		if (order == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Sorry");
			alert.setHeaderText("Can not add order");
			alert.setContentText("Maximum number of orders reached!");
			alert.showAndWait();
		} else {
			orderList.add(order);
			setRemoveVisibilityFalse();
			orderLabel.setVisible(true);
			orderTextField.setVisible(true);
			dateLabel.setVisible(true);
			dateTextField.setVisible(true);
			displayTable.setVisible(true);

			orderTextField.setText(orderList.size() + "");
			dateTextField.setText(order.getDateOrdered().print());

			// so that user can not edit
			dateTextField.setEditable(false);
			orderTextField.setEditable(false);

			statusLabel.setVisible(true);
			statusLabel.setText("Order created");
		}
	}

	@FXML
	public void addBookController() throws IOException {
		if (orderList.size() == 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Alert");
			alert.setHeaderText("No order created");
			alert.setContentText("Can not add media");
			alert.showAndWait();
		} else {
			System.out.println("Open Book controller clicked");
			statusLabel.setText("You chose add book");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddBookView.fxml"));
			Parent addBookView = loader.load();
			Scene bookScene = new Scene(addBookView);

			Stage stage = (Stage) menubar.getScene().getWindow();
			// System.out.println("Root stage gotten");
			Stage newstage = new Stage();
			newstage.initOwner(stage);

			System.out.println("Create new stage");
			newstage.setScene(bookScene);
			newstage.showAndWait();
			AddBookMenuItemController bookController = loader.getController();
			System.out.println("\n\nGot controller");
			ArrayList<Book> books = bookController.getBooks();
			int sz = books.size();
			if (sz != 0) {
				Order order = orderList.get(orderList.size() - 1);
				for (int i = 0; i < sz; i++) {
					int success = order.addMedia(books.get(i));
					System.out.println(success);
				}
			}
		}
	}

	@FXML
	public void addCDController(ActionEvent event) {
		try {
			if (orderList.size() == 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Alert");
				alert.setHeaderText("No order created");
				alert.setContentText("Can not add media");
				alert.showAndWait();
			} else {
				statusLabel.setText("You chose add cd");
				System.out.println("Open CD controller clicked");
				FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCDView.fxml"));
				System.out.println("CDView.fxml loader loaded");
				Parent addCDView = loader.load();
				System.out.println("Root pane loaded");
				Scene cdScene = new Scene(addCDView);
				System.out.println("cdScene created");
				Stage stage = (Stage) menubar.getScene().getWindow();
				// System.out.println("Root stage gotten");
				Stage newstage = new Stage();
				newstage.initOwner(stage);

				System.out.println("Create new stage");
				newstage.setScene(cdScene);
				newstage.showAndWait();

				// Load controller of fxml file
				AddCDMenuItemController cdController = loader.getController();
				System.out.println("\n\nGot controller");
				ArrayList<CompactDisc> cdList = cdController.getCDList();
				int sz = cdList.size();
				if (sz != 0) {
					Order order = orderList.get(orderList.size() - 1);
					for (int i = 0; i < sz; i++) {
						int success = order.addMedia(cdList.get(i));
						System.out.println(success);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	public void addDVDController(ActionEvent event) {
		try {
			if (orderList.size() == 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Alert");
				alert.setHeaderText("No order created");
				alert.setContentText("Can not add media");
				alert.showAndWait();
			} else {
				System.out.println("Add dvd controller clicked");
				statusLabel.setText("You chose add dvd");
				System.out.println("DVDView.fxml loader loaded");
				FXMLLoader loader = new FXMLLoader(getClass().getResource("AddDVDView.fxml"));
				Parent addDVDView = loader.load();
				System.out.println("Root pane loaded");
				Scene dvdScene = new Scene(addDVDView);
				System.out.println("cdScene created");
				Stage stage = (Stage) menubar.getScene().getWindow();
				// System.out.println("Root stage gotten");
				Stage newstage = new Stage();
				newstage.initOwner(stage);

				System.out.println("Create new stage");
				newstage.setScene(dvdScene);
				newstage.showAndWait();

				// Load controller of fxml file
				AddDVDMenuItemController dvdController = loader.getController();
				System.out.println("\n\nGot controller");
				ArrayList<DigitalVideoDisc> dvdList = dvdController.getDVDList();
				int sz = dvdList.size();
				if (sz != 0) {
					Order order = orderList.get(orderList.size() - 1);
					for (int i = 0; i < sz; i++) {
						int success = order.addMedia(dvdList.get(i));
						System.out.println(success);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void removeMediaController() {
		if (orderList.size() == 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Alert");
			alert.setHeaderText("No order created");
			alert.setContentText("Can not remove media");
			alert.showAndWait();
		} else {
			removeMediaTextField.setVisible(true);
			removeMediaButton.setVisible(true);
			mediaIDLabel.setVisible(true);
			removeMediaTextField.setEditable(true);

			removeMediaButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					String id = removeMediaTextField.getText();
					if (id.isEmpty()) {
						statusLabel.setText("No ID has been entered");
					} else {
						int success = orderList.get(orderList.size() - 1).removeMedia(id);
						if (success == 1) {
							statusLabel.setText("Media of ID " + id + " removed successfully");
						} else if (success == -1) {
							statusLabel.setText("Can not find media of ID " + id);
						}

						removeMediaTextField.clear();
					}
				}

			});
		}
	}

	public void displayOrderController() {
		if (orderList.size() == 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Alert");
			alert.setHeaderText("No order created");
			alert.setContentText("Can not display order");
			alert.showAndWait();
		} else {
			System.out.println("Display is pressed");
			orderList.get(orderList.size() - 1).displayOrder();
			
			idTableColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("mediaId"));
			titleTableColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
			categoryTableColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
			costTableColumn.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

			orderList.get(orderList.size()-1).getItemsOrdered().add(Order.getALuckyItem());
			ObservableList<Media> list = FXCollections
					.observableArrayList(orderList.get(orderList.size() - 1).getItemsOrdered());
			displayTable.setItems(list);
		}
	}

	public void setRemoveVisibilityFalse() {
		removeMediaTextField.setVisible(false);
		removeMediaButton.setVisible(false);
		mediaIDLabel.setVisible(false);
	}

}
