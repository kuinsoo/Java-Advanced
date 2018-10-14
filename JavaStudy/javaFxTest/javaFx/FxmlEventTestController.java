package javaFx;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

	public class FxmlEventTestController {

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private HBox hBox;

	    @FXML
	    private VBox root;

	    @FXML
	    private Button btnDisplay;

	    @FXML
	    private TextField tfDan;

	    @FXML
	    private TextArea taResult;

	    @FXML
	    void displayGugudan(ActionEvent event) {
	    	 String strDan = tfDan.getText();
	            if(!Pattern.matches("^[0-9]+$",strDan)) {
	                taResult.setText("출력할 단을 입력하세요.");
	                return;
	            }

	            int dan = Integer.parseInt(strDan);
	            taResult.setText(dan + "단\n\n");

	            for (int i = 1; i < 10 ; i++) {
	                int result =  dan * i ;
	                taResult.appendText(dan + " * " + i + " = " + result + "\n");
	            }
	    }

	    @FXML
	    void initialize() {
	        assert hBox != null : "fx:id=\"hBox\" was not injected: check your FXML file 'FxmlEventTest.fxml'.";
	        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'FxmlEventTest.fxml'.";
	        assert btnDisplay != null : "fx:id=\"btnDisplay\" was not injected: check your FXML file 'FxmlEventTest.fxml'.";
	        assert tfDan != null : "fx:id=\"tfDan\" was not injected: check your FXML file 'FxmlEventTest.fxml'.";
	        assert taResult != null : "fx:id=\"taResult\" was not injected: check your FXML file 'FxmlEventTest.fxml'.";
	        taResult.setPrefColumnCount(10);
            taResult.setPrefRowCount(15);
	    }
}


