package controller;

import java.io.IOException;

import database.db;
import helper.AlertBox;
import helper.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import object.Member;

public class MemberSearchController {

	@FXML
	private TextField txtid;

	@FXML
	private Button btnLogin;

//	@FXML
//    private AnchorPane memberPane;
	
	@FXML
	void btnLogout_Click(ActionEvent event) {
		try {
			Util.changeScene(new FXMLLoader(getClass().getResource(Util.LoginView)));
		    
		} catch (IOException ioe) {
			
		}
	}

	@FXML
	void btnSearch_Click(ActionEvent event) {
		try {
			Member user = db.getInstance().getMemberByID(txtid.getText());
			FXMLLoader loader  = new FXMLLoader(getClass().getResource(Util.MemberDisplayView));
			Util.changeScene(loader);
			
			MemberDisplayController memberDisplayController = loader.<MemberDisplayController>getController();
		    memberDisplayController.setMember(user);
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
	}

}