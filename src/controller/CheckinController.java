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
import javafx.scene.control.TextField;
import object.Book;
import object.Checkout;
import object.Member;

public class CheckinController implements Initializable {
	private Member m;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void setMember(Member m) {
		this.m = m;
	}

	@FXML
	private TextField txtIsbn;

	@FXML
	void btnSearch_Click(ActionEvent ae) throws SQLException {
		String isbn = txtIsbn.getText();
		if (isbn.trim().equals("")) {
			AlertBox.display("Error", "Invalid ISBN.");
			return;
		}
		Checkout b = null;
		try {
			b = db.getInstance().getCheckoutByIsbn(isbn, m.getIdMember());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AlertBox.display("Error", e.getMessage());
			return;
		}
		if (b == null) {
			AlertBox.display("Error", "Invalid ISBN.");
			return;
		}
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.MemberDisplayView));
		try {
			Util.changeScene(loader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MemberDisplayController mdc = loader.<MemberDisplayController>getController();
		mdc.setMember(m);
	}
}
