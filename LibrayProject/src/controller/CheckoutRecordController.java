package controller;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import object.Checkout;
import object.CheckoutRecord;

public class CheckoutRecordController implements Initializable{
	private CheckoutRecord checkoutRecord;
	

    @FXML
    private TableView<Checkout> tbRecords;

    @FXML
    private TableColumn<Checkout,String> colDueDate;

    @FXML
    private Label lbname;

    @FXML
    private TableColumn<Checkout,String> colCheckoutDate;

    @FXML
    private TableColumn<Checkout,String> colFine;

    @FXML
    private TableColumn<Checkout,String> colBook;

    
	public void setCheckout(CheckoutRecord cr) {
		checkoutRecord = cr;
		colBook.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().bookName));
    	colCheckoutDate.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCheckoutDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))));
    	colDueDate.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getDueDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))));
    	colFine.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(""));
		lbname.setText(cr.getMember().getFirstName() + " " + cr.getMember().getLastName());
		for(Checkout checkout : checkoutRecord.getCheckouts()) {
			tbRecords.getItems().add(checkout);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
