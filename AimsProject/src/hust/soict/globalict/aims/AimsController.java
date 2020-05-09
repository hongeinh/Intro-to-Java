package hust.soict.globalict.aims;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import hust.soict.globalict.aims.order.Order;
import javafx.event.ActionEvent;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AimsController implements Initializable {

	ArrayList<Order> orderList;
	
	// Aims.fxml
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
	private Label statusRemoveMediaLabel;

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
	private TableView displayTable;

	

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// When no order is initialized, set visibility of the belows to false
		setRemoveVisibilityFalse();

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
		}
	}

	@FXML
	public void addBookController() throws IOException {
		if(orderList.size() == 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Alert");
			alert.setHeaderText("No order created");
			alert.setContentText("Can not add media");
		} else {
			System.out.println("Add book controller clicked");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddBookView.fxml"));
			Parent addBookView = loader.load();
			Scene bookScene = new Scene(addBookView);
			Stage stage = (Stage) menubar.getScene().getWindow();
			System.out.println("Root stage gotten");
			stage.setScene(bookScene);
			stage.show();
		}
	}

	@FXML
	public void addCDController(ActionEvent event) {
		try {
			if(orderList.size() == 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Alert");
				alert.setHeaderText("No order created");
				alert.setContentText("Can not add media");
			} else {
				System.out.println("Add cd controller clicked");
				FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCDView.fxml"));
				Parent addBookView = loader.load();
				Scene bookScene = new Scene(addBookView);
				Stage stage = (Stage) menubar.getScene().getWindow();
				System.out.println("Root stage gotten");
				stage.setScene(bookScene);
				stage.show();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	public void addDVDController(ActionEvent event) {
		try {
			if(orderList.size() == 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Alert");
				alert.setHeaderText("No order created");
				alert.setContentText("Can not add media");
			} else {
				System.out.println("Add dvd controller clicked");
				FXMLLoader loader = new FXMLLoader(getClass().getResource("AddDVDView.fxml"));
				Parent addBookView = loader.load();
				Scene bookScene = new Scene(addBookView);
				Stage stage = (Stage) menubar.getScene().getWindow();
				System.out.println("Root stage gotten");
				stage.setScene(bookScene);
				stage.show();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void removeMediaController() {
		statusRemoveMediaLabel.setVisible(true);
		removeMediaTextField.setVisible(true);
		removeMediaButton.setVisible(true);
		mediaIDLabel.setVisible(true);
		removeMediaTextField.setEditable(true);
	}

	public void displayOrderController() {
	}

	public void setRemoveVisibilityFalse() {
		statusRemoveMediaLabel.setVisible(false);
		removeMediaTextField.setVisible(false);
		removeMediaButton.setVisible(false);
		mediaIDLabel.setVisible(false);
	}
	
	
	/*
	 * public void backToMenu(ActionEvent event) { try {
	 * System.out.println("Back to main menu"); FXMLLoader loader = new
	 * FXMLLoader(getClass().getResource("Aims.fxml")); Parent addBookView =
	 * loader.load(); Scene bookScene = new Scene(addBookView); Stage stage =
	 * (Stage) menubar.getScene().getWindow();
	 * System.out.println("Root stage gotten"); stage.setScene(bookScene);
	 * stage.show(); } catch (IOException e) { e.printStackTrace(); } }
	 */
}
