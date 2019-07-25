package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import database.db;
import helper.AlertBox;
import helper.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import object.Address;
import object.Author;
import object.BookCopy;
import object.Author;

public class AuthorFormController extends AdminController implements Initializable{
	@FXML
	private TextField txtCity;

	@FXML
	private TextField txtID;

	@FXML
	private TextField txtZip;

	@FXML
	private TextField txtLastName;

	@FXML
	private TextField txtFirstName;

	@FXML
	private TextField txtNuPhone;

	@FXML
	private TextField txtStreet;

	@FXML
	private TextField txtState;
	
	@FXML
	private TextField txtCredentials;
	
	@FXML
	private TextArea txtShortBio;
	
	private List<Author> authors;
	
	private List<BookCopy> bookCopies;

	@FXML
	void btnAdd_Click(ActionEvent event) {
		String firstName = txtFirstName.getText();
		String lastName = txtLastName.getText();
		String phoneNumber = txtNuPhone.getText();
		String street = txtStreet.getText();
		String state = txtState.getText();
		String city = txtCity.getText();
		String zip = txtZip.getText();
		String credentials = txtCredentials.getText();
		String shortBio = txtShortBio.getText();
		if (firstName.trim().equals("") || lastName.trim().equals("") || phoneNumber.trim().equals("")
				|| street.trim().equals("") || state.trim().equals("") || city.trim().equals("")
				|| zip.trim().equals("")|| credentials.trim().equals("")|| shortBio.trim().equals("")) {
			AlertBox.display("Error", "All fields must be filled");
			return;
		}
		if(!Util.validPhone(phoneNumber))
		{
			AlertBox.display("Error", "Invalid phone number.");
			return;
		}
		Author m = new Author(new Address(street, state, city, zip), firstName, lastName, "", phoneNumber,shortBio,credentials);
		authors.add(m);
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.BookFormView));
		try {
			Util.changeScene(loader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BookController bookController = loader.<BookController>getController();
		bookController.setAuthorBookCopy(authors, bookCopies);
	}

	@FXML
	void btnEdit_Click(ActionEvent event) {
		int idNummber = Integer.parseInt(txtID.getText());
		if (idNummber == 0) {
			AlertBox.display("Error", "You must place the Author ID");
			return;
		}
		String firstName = txtFirstName.getText();
		String lastName = txtLastName.getText();
		String phoneNumber = txtNuPhone.getText();
		String street = txtStreet.getText();
		String state = txtState.getText();
		String city = txtCity.getText();
		String zip = txtZip.getText();
		String credentials = txtCredentials.getText();
		String shortBio = txtShortBio.getText();
		if (firstName.trim().equals("") || lastName.trim().equals("") || phoneNumber.trim().equals("")
				|| street.trim().equals("") || state.trim().equals("") || city.trim().equals("")
				|| zip.trim().equals("")|| credentials.trim().equals("")|| shortBio.trim().equals("")) {
			AlertBox.display("Error", "All fields must be filled");
			return;
		}
		if(!Util.validPhone(phoneNumber))
		{
			AlertBox.display("Error", "Invalid phone number.");
			return;
		}
		Author author = null;
		try {
			author = db.getInstance().getAuthorByID(txtID.getText());
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
		Address ad = author.getAddress();
		ad.setStreet(street);
		ad.setCity(city);
		ad.setState(state);
		ad.setZip(zip);
		author.setAddress(ad);
		author.setFirstName(firstName);
		author.setLastName(lastName);
		author.setPhoneNumber(phoneNumber);
		author.setShortBio(shortBio);
		author.setCredentials(credentials);
		try {
			db.getInstance().updateAuthor(author);
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
		AlertBox.display("Success", "The Author was updated.");
		Util.adminMenu(getClass());
	}

	@FXML
	void btnSearch_Click(ActionEvent event) {
		int idNummber = Integer.parseInt(txtID.getText());
		if (idNummber == 0) {
			AlertBox.display("Error", "You must place the Author ID");
			return;
		}
		Author author = null;
		try {
			author = db.getInstance().getAuthorByID(txtID.getText());
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
		if(author == null)
		{
			AlertBox.display("Not found.", "Author not found.");
			return;
		}
		txtFirstName.setText(author.getFirstName());
		txtLastName.setText(author.getLastName());
		txtNuPhone.setText(author.getPhoneNumber());
		txtState.setText(author.getAddress().getState());
		txtCity.setText(author.getAddress().getCity());
		txtStreet.setText(author.getAddress().getStreet());
		txtZip.setText(author.getAddress().getZip());
	}
	
	public void setAuthors(List<Author> authors, List<BookCopy> bookCopies) {
		this.authors = authors;
		this.bookCopies = bookCopies;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}

