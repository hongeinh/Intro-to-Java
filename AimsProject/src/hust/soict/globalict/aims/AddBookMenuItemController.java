package hust.soict.globalict.aims;

import java.io.IOException;
import java.util.ArrayList;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.order.Order;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddBookMenuItemController {
	
	@FXML
	private TextField bookTitleTextField;
	
	@FXML
	private TextField bookCategoryTextField;
	
	@FXML
	private TextField bookAuthorTextField;
	
	@FXML
	private TextField bookCostTextField;
	
	@FXML
	private Label statusLabel;
	
	@FXML
	private Button addAuthorButton;
	
	@FXML
	private Button addBookButton;

	/*
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bookTitleTextField.setVisible(true);
		bookTitleTextField.setEditable(true);
		
		bookCategoryTextField.setVisible(true);
		bookCategoryTextField.setEditable(true);
		
		bookAuthorTextField.setVisible(true);
		bookAuthorTextField.setEditable(true);
		
		bookCostTextField.setVisible(true);
		bookCostTextField.setEditable(true);

		statusLabel.setVisible(true);
		
		addAuthorButton.setVisible(true);
		addBookButton.setVisible(true);
			
	}*/
	
	/**
	 * This functions opens the AddbookView and controls the buttons within it
	 * @param	file	fxml file to render
	 * @param	order	The current order to add book to
	 * @return 	void	Nothing to return
	 * */
	
	public void openBookWindow(String file, Order order) throws IOException {
		ArrayList<String> authors = new ArrayList<String>();
		
		Parent bookRoot = FXMLLoader.load(getClass().getResource(file));
		
		addAuthorButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if(!bookAuthorTextField.getText().trim().equals("")) {
					authors.add(bookAuthorTextField.getText().trim());
				}	
			}
			
		});
		
		addBookButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Book book = new Book(bookTitleTextField.getText(), bookCategoryTextField.getText(), authors, Float.parseFloat(bookCostTextField.getText()));
				int success = order.addMedia(book);
				if(success == 1) {
					statusLabel.setText(bookTitleTextField.getText() + " of ID: " + book.getMediaId() + " added succesfully!");
				} else if (success == 0) {
					statusLabel.setText("Item " + book.getTitle() + " of ID " + book.getMediaId() + " is already in the list! Can not add to order");
				} else if(success == -1) {
					statusLabel.setText("Can not add " + book.getTitle() + " to the order!\nMax number of items reached");
				}
				authors.clear();
				bookAuthorTextField.setText("");
				bookTitleTextField.setText("");
				bookCategoryTextField.setText("");
				bookCostTextField.setText("");
				
			}
			
		});
		Scene scene = new Scene(bookRoot);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.setTitle("Add book menu");
		stage.show();
	}
}	

