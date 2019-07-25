package controller;

import database.db;
import helper.AlertBox;
import helper.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import object.User;

public class LoginController {

	@FXML
	private TextField txtid;

    @FXML
    private PasswordField txtpass;

	@FXML
	private Button btnLogin;

	@FXML
	void btnLogin_Click(ActionEvent event) {
		try {
			User u = db.getInstance().getUserByIDAndPass(txtid.getText(), txtpass.getText());
			if(u == null)
			{
				AlertBox.display("User ID or password wrong!", "There is no user with that ID and password in our system.");
				return;
			}
			Util.CurrentUser = u;
			Util.changeScene(new FXMLLoader(getClass().getResource(u.menuUrl())));
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
	}

}
