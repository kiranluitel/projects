package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import database.db;
import helper.AlertBox;
import helper.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import object.Author;
import object.Book;
import object.BookCopy;
import object.User;

public class BookCopyController extends AdminController implements Initializable {
	private User user;
	
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private TextField txtIsbn;
	
	@FXML
	private TextField txtCopies;
	
	private List<Author> authors;
	
	private List<BookCopy> bookCopies;
	
	@FXML
	private RadioButton chk7;
	
	@FXML
	private RadioButton chk21;
	
	@FXML
	void btnAdd_Click() {
		int nuCopies =Integer.parseInt(txtCopies.getText());
		if(nuCopies == 0) {
			AlertBox.display("Not enought copies", "You must at least one copie.");
			return;
		}
		
		if(!chk7.isSelected() && !chk21.isSelected()) {
			AlertBox.display("Error", "You must select at least one date.");
			return;
		}
		
		int number = chk7.isSelected() ? 7 : 21;
		for(int x = 0; x < nuCopies ; x++) {
			bookCopies.add(new BookCopy(x , null,number));
		}
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.BookFormView));
		try {
			Util.changeScene(loader);
		}catch(Exception e) {
			
		}
		BookController bcc = loader.<BookController>getController();
		bcc.setAuthorBookCopy(authors,bookCopies);
	}
	@FXML
	void btnEdit_Click(ActionEvent ae) {
		
	}

	public void setAuthorBookCopy(List<Author> authors, List<BookCopy> bookCopies) {
		this.authors = authors;
		this.bookCopies = bookCopies;
		
	}

}
