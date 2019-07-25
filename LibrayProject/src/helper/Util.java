package helper;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.AdminController;
import controller.MemberFormController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import object.User;

public class Util {
	public static final String LoginView = "/view/Login.fxml";
	public static final String CheckoutRecordView = "/view/CheckoutRecord.fxml";
	public static final String MemberDisplayView = "/view/MemberDisplay.fxml";
	public static final String MemberSearchView = "/view/MemberSearch.fxml";
	public static final String AdminMenuView = "/view/AdminMenu.fxml";
	public static final String MemberFormView = "/view/MemberFormView.fxml";
	public static final String LibrarianFormView = "/view/LibrarianFormView.fxml";
	public static final String AdministratorFormView = "/view/AdministratorFormView.fxml";
	public static final String BookFormView = "/view/BookFormView.fxml";
	public static final String AuthorFormView = "/view/AuthorFormView.fxml";
	public static final String AdministratorBothView = "/view/AdministratorBoth.fxml";
	public static final String CheckoutView = "/view/MemberCreateCheckout.fxml";
	public static final String MemberCreateCheckin = "/view/MemberCreateCheckin.fxml";
	public static final String BookCopyView = "/view/BookFormAddCopy.fxml";
	public static User CurrentUser;
	public static Stage stage;

	public static void changeScene(FXMLLoader loader) throws IOException {
		BorderPane root = (BorderPane) loader.load();
		Scene sc = new Scene(root);
		// Stage stage = (Stage) txtid.getScene().getWindow();
		// // these two of them return the same stage
		// // Swap screen

		Stage stage = Util.stage;
		stage.setScene(sc);
	}

	public static void memberButtonClick(Class<?> cl) {
		FXMLLoader loader = new FXMLLoader(cl.getResource(Util.MemberFormView));
		try {
			Util.changeScene(loader);
		} catch (IOException e) {
			AlertBox.display("Error", "An error occurred proccessing the call.");
		}
	}

	public static void librarianButtonCick(Class<?> cl) {
		FXMLLoader loader = new FXMLLoader(cl.getResource(Util.LibrarianFormView));
		try {
			Util.changeScene(loader);
		} catch (IOException e) {
			AlertBox.display("Error", "An error occurred proccessing the call.");
		}
	}

	public static void administratorButtonClick(Class<?> cl) {
		FXMLLoader loader = new FXMLLoader(cl.getResource(Util.AdministratorFormView));
		try {
			Util.changeScene(loader);
		} catch (IOException e) {
			AlertBox.display("Error", "An error occurred proccessing the call.");
		}
	}

	public static void bookButtonClick(Class<?> cl) {
		FXMLLoader loader = new FXMLLoader(cl.getResource(Util.BookFormView));
		try {
			Util.changeScene(loader);
		} catch (IOException e) {
			AlertBox.display("Error", "An error occurred proccessing the call.");
		}
	}

	public static void adminMenu(Class<?> cl) {
		FXMLLoader loader = new FXMLLoader(cl.getResource(Util.AdminMenuView));
		try {
			Util.changeScene(loader);
		} catch (IOException e) {
			AlertBox.display("Error", "An error occurred proccessing the call.");
		}
	}

	public static boolean validPhone(String phoneNumber) {

		Pattern pattern = Pattern.compile("((\\+[1-9]{3,4}|0[1-9]{4}|00[1-9]{3})\\-?)?\\d{8,20}");
		Matcher matcher = pattern.matcher(phoneNumber);

		if (matcher.matches())
			return true;

		return false;

	}
}
