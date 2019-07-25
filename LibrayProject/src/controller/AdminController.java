package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import object.User;

public class AdminController implements Initializable {

	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			lbnuAdministrotor.setText("" + db.getInstance().getNumberAdministrator());
			lbnuBook.setText("" + db.getInstance().getNumberBooks());
			lbnuLibrarian.setText("" + db.getInstance().getNumberLibrarians());
			lbnuMember.setText("" + db.getInstance().getNumberMembers());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private Label lbnuBook;

	@FXML
	private Button btnBook;

	@FXML
	private Label lbnuMember;

	@FXML
	private Button btnLibrarian;

	@FXML
	private Label lbnuAdministrotor;

	@FXML
	private Button btnMember;

	@FXML
	private Label lbnuLibrarian;

	@FXML
	private Button btnAdministrator;

	@FXML
	void btnMember_Click(ActionEvent event) {
		Util.memberButtonClick(getClass());
	}

	@FXML
	void btnLibrarian_Click(ActionEvent event) {
		Util.librarianButtonCick(getClass());
	}

	@FXML
	void btnAdministrator_Click(ActionEvent event) {
		Util.administratorButtonClick(getClass());
	}

	@FXML
	void btnBook_Click(ActionEvent event) {
		Util.bookButtonClick(getClass());
	}

}
