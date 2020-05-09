package hust.soict.globalict.aims;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import hust.soict.globalict.aims.media.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddBookMenuItemController {
	ArrayList<Book> books;
	ArrayList<String> authors;

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

	public AddBookMenuItemController() {
		authors = new ArrayList<String>();
		books = new ArrayList<Book>();
	}
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

		
	}

	public void addAuthor(ActionEvent event) {
		System.out.println("Add author pressed");
		if(bookAuthorTextField.getText().trim().isEmpty()) {
			statusLabel.setText("Author Field is empty");
		} else {	
			System.out.println("Add author text: " + bookAuthorTextField.getText());
			String au = bookAuthorTextField.getText().trim();
			authors.add(au);
			statusLabel.setText("Author added");
		}
	}

	public void addBook(ActionEvent event) {
		System.out.println("Add book pressed");
		
		if(bookTitleTextField.getText().trim().isEmpty() || bookCategoryTextField.getText().trim().isEmpty() || bookCostTextField.getText().isEmpty()) {
			statusLabel.setText("One of the fields are empty");
		} else {
			String title = bookTitleTextField.getText().trim();
			String category = bookCategoryTextField.getText().trim();
			float cost = Float.parseFloat(bookCostTextField.getText());
			Book book = new Book(title, category, authors, cost);
			books.add(book);
			System.out.println("Add title text: " + bookTitleTextField.getText());
			System.out.println("Add category text: " + bookCategoryTextField.getText());
			System.out.println("Add cost text: " + bookCostTextField.getText());
			statusLabel.setText("Book of ID " + book.getMediaId() + " added successfully" );
		}
		

	}

	public ArrayList<Book> getBooks() {
		return books;
	}
}
