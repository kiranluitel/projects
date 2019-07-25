package controller;

import java.net.URL;
import java.util.ResourceBundle;

import database.db;
import helper.AlertBox;
import helper.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import object.Address;
import object.Librarian;
import object.User;

public class LibrarianController extends AdminController implements Initializable {
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

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
	private TextField txtPsw;

	@FXML
	void btnAdd_Click(ActionEvent event) {
		String firstName = txtFirstName.getText();
		String lastName = txtLastName.getText();
		String phoneNumber = txtNuPhone.getText();
		String street = txtStreet.getText();
		String state = txtState.getText();
		String city = txtCity.getText();
		String zip = txtZip.getText();
		String pass = txtPsw.getText();
		if (firstName.trim().equals("") || lastName.trim().equals("") || phoneNumber.trim().equals("")
				|| street.trim().equals("") || state.trim().equals("") || city.trim().equals("")
				|| zip.trim().equals("") || pass.trim().equals("")) {
			AlertBox.display("Error", "All fields must be filled");
			return;
		}
		if(!Util.validPhone(phoneNumber))
		{
			AlertBox.display("Error", "Invalid phone number.");
			return;
		}
		Librarian m = null;
		try {
			m = db.getInstance()
					.addLibrarian(new Librarian(new Address(street, state, city, zip), firstName, lastName, "", phoneNumber,pass));
		} catch (Exception e) {
			AlertBox.display("Error", "It happend a problem creating the Librarian.");
		}
		AlertBox.display("Success", "The Librarian was created and the ID is: " + m.getID());
		Util.adminMenu(getClass());
	}

	@FXML
	void btnEdit_Click(ActionEvent event) {
		int idNummber = Integer.parseInt(txtID.getText());
		if (idNummber == 0) {
			AlertBox.display("Error", "You must place the Librarian ID");
			return;
		}
		String firstName = txtFirstName.getText();
		String lastName = txtLastName.getText();
		String phoneNumber = txtNuPhone.getText();
		String street = txtStreet.getText();
		String state = txtState.getText();
		String city = txtCity.getText();
		String zip = txtZip.getText();
		String pass = txtPsw.getText();
		if (firstName.trim().equals("") || lastName.trim().equals("") || phoneNumber.trim().equals("")
				|| street.trim().equals("") || state.trim().equals("") || city.trim().equals("")
				|| zip.trim().equals("") || pass.trim().equals("")) {
			AlertBox.display("Error", "All fields must be filled");
			return;
		}
		if(!Util.validPhone(phoneNumber))
		{
			AlertBox.display("Error", "Invalid phone number.");
			return;
		}
		Librarian librarian = null;
		try {
			librarian = db.getInstance().getLibrarianByID(txtID.getText());
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
		Address ad = librarian.getAddress();
		ad.setStreet(street);
		ad.setCity(city);
		ad.setState(state);
		ad.setZip(zip);
		librarian.setAddress(ad);
		librarian.setFirstName(firstName);
		librarian.setLastName(lastName);
		librarian.setPhoneNumber(phoneNumber);
		librarian.setPassword(pass);
		try {
			db.getInstance().updateLibrarian(librarian);
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
		AlertBox.display("Success", "The Librarian was updated.");
		Util.adminMenu(getClass());
	}

	@FXML
	void btnSearch_Click(ActionEvent event) {
		int idNummber = Integer.parseInt(txtID.getText());
		if (idNummber == 0) {
			AlertBox.display("Error", "You must place the Librarian ID");
			return;
		}
		Librarian librarian = null;
		try {
			librarian = db.getInstance().getLibrarianByID(txtID.getText());
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
		if(librarian == null)
		{
			AlertBox.display("Not found.", "Librarian not found.");
			return;
		}
		txtFirstName.setText(librarian.getFirstName());
		txtLastName.setText(librarian.getLastName());
		txtNuPhone.setText(librarian.getPhoneNumber());
		txtState.setText(librarian.getAddress().getState());
		txtCity.setText(librarian.getAddress().getCity());
		txtStreet.setText(librarian.getAddress().getStreet());
		txtZip.setText(librarian.getAddress().getZip());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
