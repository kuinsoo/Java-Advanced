package main;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MyStudentDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.IMyStudentService;
import service.MyStudentService;
import vo.MyStudenVo;

public class InsertMyStudentController {
    IMyStudentService service = MyStudentService.getInstance();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancel;

    @FXML
    private AnchorPane root;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfKor;

    @FXML
    private TextField tfMath;

    @FXML
    private TextField tfEng;

    @FXML
    void insertAction(ActionEvent event) {
        MyStudenVo myStudenVo = new MyStudenVo();
        myStudenVo.setStd_name(tfName.getText());
        myStudenVo.setStd_kor(Integer.parseInt(tfKor.getText()));
        myStudenVo.setStd_eng(Integer.parseInt(tfEng.getText()));
        myStudenVo.setStd_mat(Integer.parseInt(tfMath.getText()));

        int cnt = service.insertMyStudent(myStudenVo);
        if(cnt > 0 ) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("추가 결과");
            alert.setContentText("추가 성공");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("추가 실패");
            alert.show();
        }


        MyStudentMainController myCont = new MyStudentMainController();
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();


    }

    @FXML
    void cancelAction(ActionEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();


    }

    @FXML
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'insertMyStudent.fxml'.";
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'insertMyStudent.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'insertMyStudent.fxml'.";
        assert tfName != null : "fx:id=\"tfName\" was not injected: check your FXML file 'insertMyStudent.fxml'.";
        assert tfKor != null : "fx:id=\"tfKor\" was not injected: check your FXML file 'insertMyStudent.fxml'.";
        assert tfMath != null : "fx:id=\"tfMath\" was not injected: check your FXML file 'insertMyStudent.fxml'.";
        assert tfEng != null : "fx:id=\"tfEng\" was not injected: check your FXML file 'insertMyStudent.fxml'.";

    }
}
