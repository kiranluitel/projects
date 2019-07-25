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

public class CheckoutController implements Initializable{
	
	private Member member;
	
	public void setMember(Member member) {
		this.member = member;
	}
	@FXML
	private TextField txtIsbn;
	
	@FXML
	void btnSearch_Click(ActionEvent ae) {
		String isbn = txtIsbn.getText();
		if(isbn.trim().equals("")) {
			AlertBox.display("Error", "Invalid ISBN.");
			return;
		}
		try {
			Book b = db.getInstance().getBookByIsbn(isbn);
			if(b == null)
			{
				AlertBox.display("Error", "Invalid ISBN.");
				return;
			}
			try {
				db.getInstance().createNewCheckout(b,member);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.MemberDisplayView));
		try {
			Util.changeScene(loader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MemberDisplayController mdc = loader.<MemberDisplayController>getController();
		mdc.setMember(member);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
