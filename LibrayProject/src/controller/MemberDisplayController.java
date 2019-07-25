package controller;

import java.io.IOException;
import java.net.URL;
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
import object.CheckoutRecord;
import object.Member;

public class MemberDisplayController implements Initializable {
	private Member member;
	@FXML
	private Label lbid;

	@FXML
	private Label lbname;

	@FXML
	private Label lblname;

	@FXML
	private Button btnLogin;

	@FXML
	void btnCheckOut_Click(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.CheckoutView));
		try {
			Util.changeScene(loader);
		} catch (Exception e) {

		}
		CheckoutController cc = loader.<CheckoutController>getController();
		cc.setMember(member);
	}

	@FXML
	void btnViewRecord_Click(ActionEvent event) {
		try {
			CheckoutRecord cr = db.getInstance().getRecord(member);
			if (cr == null) {
				AlertBox.display("Not found", "There is no checkout for this member.");
				return;
			}
			cr.setMember(member);
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.CheckoutRecordView));

			Util.changeScene(loader);
			CheckoutRecordController checkoutRecordController = loader.<CheckoutRecordController>getController();
			checkoutRecordController.setCheckout(cr);
		} catch (Exception e) {
			AlertBox.display("Error", e.getMessage());
		}
	}
	
	@FXML
	void btnCheckin_Click(ActionEvent ae) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.MemberCreateCheckin));
		try {
			Util.changeScene(loader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CheckinController checkoutRecordController = loader.<CheckinController>getController();
		checkoutRecordController.setMember(member);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void setMember(Member member) {
		this.member = member;
		lbid.setText(member.getID());
		lbname.setText(member.getFirstName());
		lblname.setText(member.getLastName());
	}

}
