

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class CustomController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnOk;

    @FXML
    private Label lblMsg;

    @FXML
    void btnOkClicked(ActionEvent event) {
        // 현재 창에 있는 컨트롤을 이요하여 현재 창을 가리키는 Stage 객체 구하기
       Stage currentStage = (Stage) btnOk.getScene().getWindow();

       currentStage.close(); // 창닫기
    }

    @FXML
    void initialize() {
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'custom.fxml'.";
        assert lblMsg != null : "fx:id=\"lblMsg\" was not injected: check your FXML file 'custom.fxml'.";


    }
}
