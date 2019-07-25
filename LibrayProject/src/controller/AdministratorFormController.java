package controller;

import java.net.URL;
import java.util.ResourceBundle;

import database.db;
import helper.AlertBox;
import helper.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import object.Address;
import object.Administrator;
import object.User;

public class AdministratorFormController extends AdminController implements Initializable {
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
				|| zip.trim().equals("")|| pass.trim().equals("")) {
			AlertBox.display("Error", "All fields must be filled");
			return;
		}
		if(!Util.validPhone(phoneNumber))
		{
			AlertBox.display("Error", "Invalid phone number.");
			return;
		}
		Administrator m = null;
		try {
			m = db.getInstance()
					.addAdministrator(new Administrator(new Address(street, state, city, zip), firstName, lastName, "", phoneNumber,pass));
		} catch (Exception e) {
			AlertBox.display("Error", "It happend a problem creating the Administrator.");
		}
		AlertBox.display("Success", "The Administrator was created and the ID is: " + m.getID());
		Util.adminMenu(getClass());
	}

	@FXML
	void btnEdit_Click(ActionEvent event) {
		int idNummber = Integer.parseInt(txtID.getText());
		if (idNummber == 0) {
			AlertBox.display("Error", "You must place the Administrator ID");
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
		Administrator administrator = null;
		try {
			administrator = db.getInstance().getAdministratorByID(txtID.getText());
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
		if(administrator == null)
		{
			AlertBox.display("Not found", "Administrator not found.");
			return;
		}
		Address ad = administrator.getAddress();
		ad.setStreet(street);
		ad.setCity(city);
		ad.setState(state);
		ad.setZip(zip);
		administrator.setAddress(ad);
		administrator.setFirstName(firstName);
		administrator.setLastName(lastName);
		administrator.setPhoneNumber(phoneNumber);
		administrator.setPassword(pass);
		try {
			db.getInstance().updateAdministrator(administrator);
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
		AlertBox.display("Success", "The Administrator was updated.");
		Util.adminMenu(getClass());
	}

	@FXML
	void btnSearch_Click(ActionEvent event) {
		int idNummber = Integer.parseInt(txtID.getText());
		if (idNummber == 0) {
			AlertBox.display("Error", "You must place the Administrator ID");
			return;
		}
		Administrator administrator = null;
		try {
			administrator = db.getInstance().getAdministratorByID(txtID.getText());
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
			return;
		}
		if(administrator == null) {
			AlertBox.display("Error", "Administrator not found.");
			return;
		}
		txtFirstName.setText(administrator.getFirstName());
		txtLastName.setText(administrator.getLastName());
		txtNuPhone.setText(administrator.getPhoneNumber());
		txtState.setText(administrator.getAddress().getState());
		txtCity.setText(administrator.getAddress().getCity());
		txtStreet.setText(administrator.getAddress().getStreet());
		txtZip.setText(administrator.getAddress().getZip());
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
