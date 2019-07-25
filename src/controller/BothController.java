package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.db;
import helper.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import object.User;

public class BothController extends AdminController implements Initializable {
	private User user;
	
	@FXML
	private Label lbnuBook;


	@FXML
	private Label lbnuMember;


	@FXML
	private Label lbnuAdministrotor;


	@FXML
	private Label lbnuLibrarian;

	
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
	void btnSearchMember_Click(ActionEvent ae) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.MemberSearchView));
		try {
			Util.changeScene(loader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
