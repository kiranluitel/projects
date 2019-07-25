package controller;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import database.db;
import helper.AlertBox;
import helper.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import object.Address;
import object.Administrator;
import object.Author;
import object.Book;
import object.BookCopy;
import object.User;

public class BookController extends AdminController implements Initializable {
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	@FXML
	private ImageView BtnAdd;

	@FXML
	private Pane authorPane;

	@FXML
	private TextArea txtDescription;

	@FXML
	private Button btnOverview;

	@FXML
	private TextField txtIsbn;

	@FXML
	private TextField txtAuthor;

	@FXML
	private TextField txtTitle;
	
	private List<Author> authors;
	private List<BookCopy> bookCopies;
	
	public BookController() {
		if(authors == null)
			authors = new LinkedList<Author>();
		if(bookCopies == null)
			bookCopies = new LinkedList<BookCopy>();
	}
	
	@FXML
	void btnAddBookCopy_Click(ActionEvent ae) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.BookCopyView));
		try {
			Util.changeScene(loader);
		}catch(Exception e) {
			
		}
		BookCopyController bcc = loader.<BookCopyController>getController();
		bcc.setAuthorBookCopy(authors,bookCopies);
	}

	@FXML
	void btnAdd_Click(ActionEvent event) {
		String title = txtTitle.getText();
		String description = txtDescription.getText();
		String isbn = txtIsbn.getText();
		if (title.trim().equals("") || description.trim().equals("") || isbn.trim().equals("")) {
			AlertBox.display("Error", "All fields must be filled");
			return;
		}
		Book b = null;
		try {
			b = new Book(isbn,authors, title,description);
			b.setCopies(bookCopies);
			b = db.getInstance().addBook(b
					);
		} catch (Exception e) {
			AlertBox.display("Error", "It happend a problem creating the Book.");
			return;
		}
		AlertBox.display("Success", "The Book was created and the ID is: " + b.getISBN());
		Util.adminMenu(getClass());
	}

	@FXML
	void btnEdit_Click(ActionEvent event) {
		if (txtIsbn.getText().length() == 0) {
			AlertBox.display("Error", "You must place the Administrator ID");
			return;
		}
		String title = txtTitle.getText();
		String description = txtDescription.getText();
		String isbn = txtIsbn.getText();
		if (title.trim().equals("") || description.trim().equals("") || isbn.trim().equals("")) {
			AlertBox.display("Error", "All fields must be filled");
			return;
		}
		Book book = null;
		try {
			book = db.getInstance().getBookByIsbn(txtIsbn.getText());
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
		book.setTitle(title);
		book.setShortDescription(description);
		book.setISBN(isbn);
		try {
			db.getInstance().updateBook(book);
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
		AlertBox.display("Success", "The Administrator was updated.");
		Util.adminMenu(getClass());
	}
	
	private void populateAuthors() {
		authorPane.getChildren().clear();
		for(Author s : authors) {
			Label label = new Label(s.getLastName() + ", " + s.getFirstName());
			label.setPrefWidth(authorPane.getWidth());
			label.setStyle("-fx-font-weight: bold");
			authorPane.getChildren().add(label);
		}
	}

	@FXML
	void btnSearch_Click(ActionEvent event) {
		
		Book book = null;
		try {
			book = db.getInstance().getBookByIsbn(txtIsbn.getText());
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
		if(book == null) {
			AlertBox.display("Not found.", "Book not found.");
			return;
		}
		txtTitle.setText(book.getTitle());
		txtDescription.setText(book.getShortDescription());
		authors = book.getAuthors();
		populateAuthors();
	}
	
	@FXML
	void BtnAdd(MouseEvent event) {
		/*String author = txtAuthor.getText();
		if(author.trim().length() == 0) {
			AlertBox.display("Error", "Author has to be filled.");
		}
		authors.add(author);
		populateAuthors();*/
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.AuthorFormView));
		try {
			Util.changeScene(loader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AuthorFormController authorFormController = loader.<AuthorFormController>getController();
		authorFormController.setAuthors(authors, bookCopies);
		
	}
	
	public void setAuthorBookCopy(List<Author> authors, List<BookCopy> bookCopies) {
		this.authors = authors;
		this.bookCopies = bookCopies;
		populateAuthors();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
