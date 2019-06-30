package lesson8.listbindingjavafx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Illustrates how JavaFX supports two-way binding
 * of lists to data using ObservableList wrapper.
 * 
 * @author pcorazza
 *
 */
public class ListsJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private List<String> defaultList = new ArrayList<>();
    private ObservableList<String> theList= FXCollections.observableArrayList(defaultList);
    @Override
    public void start(Stage primaryStage) {
    	initializeDefaultList();
        primaryStage.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("List Example");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        ListView<String> listView = createListView();
        grid.add(listView, 0,1,2,1);

//      Label userName = new Label("User Name:");
//      grid.add(userName, 0, 1);

       // TextField userTextField = new TextField();
        //userTextField.setPrefColumnCount(10);
        //userTextField.setPrefWidth(30);
       // grid.add(userTextField, 1, 2);

        //Label pw = new Label("Password:");
       // grid.add(pw, 0, 3);
        //grid.setGridLinesVisible(true) ;

       // PasswordField pwBox = new PasswordField();
       // grid.add(pwBox, 1, 3);

        Button removeBtn = new Button("Remove Selected");
//        HBox hbBtn = new HBox(10);
//        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
//        hbBtn.getChildren().add(btn);
        grid.add(removeBtn, 0, 2, 2, 1);

		removeBtn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        		final int selectedIdx = listView.getSelectionModel().getSelectedIndex();
                if (selectedIdx != -1) {
                  String itemToRemove = listView.getSelectionModel().getSelectedItem();
         
                  final int newSelectedIdx =
                    (selectedIdx == listView.getItems().size() - 1)
                       ? selectedIdx - 1
                       : selectedIdx;
         
                  listView.getItems().remove(selectedIdx);
                  listView.getSelectionModel().select(newSelectedIdx);
                }
                System.out.println(theList);
                
        	}
        });
		
		Button addBtn = new Button("Add Item");
		grid.add(addBtn, 0, 3);
		TextField addItemField = new TextField();
		addItemField.setPrefColumnCount(10);
		grid.add(addItemField, 1, 3);

		addBtn.setOnAction(new EventHandler<ActionEvent>() {
	      	@Override
	      	public void handle(ActionEvent e) {
	      		String toAdd = addItemField.getText();
	      		listView.getItems().add(toAdd);
	      		addItemField.setText("");
	      		System.out.println(theList);
	      	}
		});
		
		//modifies list in the background -- change appears in UI
		Button modifyListBtn = new Button("Modify List");
		grid.add(modifyListBtn, 0, 4);
		TextField modifyListField = new TextField();
		addItemField.setPrefColumnCount(10);
		grid.add(modifyListField, 1, 4);

		modifyListBtn.setOnAction(new EventHandler<ActionEvent>() {
	      	@Override
	      	public void handle(ActionEvent e) {
	      		String toAdd = modifyListField.getText();
	      		theList.add(toAdd);
	      		addItemField.setText("");
	      		System.out.println(theList);
	      	}
		});
		
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void initializeDefaultList() {
		defaultList.add("Red");
		defaultList.add("Blue");
		defaultList.add("Yellow");
		theList = FXCollections.observableArrayList(defaultList);
	}
    
    private ListView<String> createListView() {
    	ListView<String> list = new ListView<String>();
    	list.setItems(theList);
    	list.setPrefWidth(50);
    	list.setPrefHeight(70);
    	return list;
    }
}