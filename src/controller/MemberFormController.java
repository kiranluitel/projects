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
import object.Member;

public class MemberFormController extends AdminController implements Initializable {

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
	void btnAdd_Click(ActionEvent event) {
		String firstName = txtFirstName.getText();
		String lastName = txtLastName.getText();
		String phoneNumber = txtNuPhone.getText();
		String street = txtStreet.getText();
		String state = txtState.getText();
		String city = txtCity.getText();
		String zip = txtZip.getText();
		if (firstName.trim().equals("") || lastName.trim().equals("") || phoneNumber.trim().equals("")
				|| street.trim().equals("") || state.trim().equals("") || city.trim().equals("")
				|| zip.trim().equals("")) {
			AlertBox.display("Error", "All fields must be filled");
			return;
		}
		if(!Util.validPhone(phoneNumber))
		{
			AlertBox.display("Error", "Invalid phone number.");
			return;
		}
		Member m = null;
		try {
			m = db.getInstance()
					.addMember(new Member(new Address(street, state, city, zip), firstName, lastName, "", phoneNumber));
		} catch (Exception e) {
			AlertBox.display("Error", "It happend a problem creating the member.");
		}
		AlertBox.display("Success", "The member was created and the ID is: " + m.getID());
		Util.adminMenu(getClass());
	}

	@FXML
	void btnEdit_Click(ActionEvent event) {
		int idNummber = Integer.parseInt(txtID.getText());
		if (idNummber == 0) {
			AlertBox.display("Error", "You must place the member ID");
			return;
		}
		String firstName = txtFirstName.getText();
		String lastName = txtLastName.getText();
		String phoneNumber = txtNuPhone.getText();
		String street = txtStreet.getText();
		String state = txtState.getText();
		String city = txtCity.getText();
		String zip = txtZip.getText();
		if (firstName.trim().equals("") || lastName.trim().equals("") || phoneNumber.trim().equals("")
				|| street.trim().equals("") || state.trim().equals("") || city.trim().equals("")
				|| zip.trim().equals("")) {
			AlertBox.display("Error", "All fields must be filled");
			return;
		}
		if(!Util.validPhone(phoneNumber))
		{
			AlertBox.display("Error", "Invalid phone number.");
			return;
		}
		Member member = null;
		try {
			member = db.getInstance().getMemberByID(txtID.getText());
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
		Address ad = member.getAddress();
		ad.setStreet(street);
		ad.setCity(city);
		ad.setState(state);
		ad.setZip(zip);
		member.setAddress(ad);
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setPhoneNumber(phoneNumber);
		try {
			db.getInstance().updateMember(member);
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
		AlertBox.display("Success", "The member was updated.");
		Util.adminMenu(getClass());
	}

	@FXML
	void btnSearch_Click(ActionEvent event) {
		int idNummber = Integer.parseInt(txtID.getText());
		if (idNummber == 0) {
			AlertBox.display("Error", "You must place the member ID");
			return;
		}
		Member member = null;
		try {
			member = db.getInstance().getMemberByID(txtID.getText());
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
		if(member == null)
		{
			AlertBox.display("Not found.", "Member not found.");
			return;
		}
		txtFirstName.setText(member.getFirstName());
		txtLastName.setText(member.getLastName());
		txtNuPhone.setText(member.getPhoneNumber());
		txtState.setText(member.getAddress().getState());
		txtCity.setText(member.getAddress().getCity());
		txtStreet.setText(member.getAddress().getStreet());
		txtZip.setText(member.getAddress().getZip());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
