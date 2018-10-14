package main;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.IMemLoginService;
import service.MemLoginService;
import vo.MemVo;


public class MemLoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbl_pw;

    @FXML
    private Label lbl_login;

    @FXML
    private Label lbl_id;

    @FXML
    private StackPane root;

    @FXML
    private HBox hbox3;

    @FXML
    private HBox hbox2;

    @FXML
    private TextField tfMem_pw;

    @FXML
    private HBox hbox1;

    @FXML
    private TextField tfMem_id;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_signup;

    @FXML
    private TextArea taResult;

    @FXML
    void login(ActionEvent event) {

    }

    @FXML
    void signUp(ActionEvent event) {
        /* 애니메이션 이용 방식
        try {
            Parent signUpRoot = FXMLLoader.load(getClass().getResource("memSignUp.fxml"));
            StackPane root = (StackPane) btn_signup.getScene().getRoot();
            root.getChildren().add(signUpRoot);

            // 액션 방향
//            signUpRoot.setTranslateX(350);
            signUpRoot.setTranslateX(500);

            Timeline timeline = new Timeline();
            KeyValue keyValue = new KeyValue(signUpRoot.translateXProperty(), 0);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
        }catch (IOException e) {
            System.out.println("IOException : " + e);
        }
        */

        /* Scene 교체 방식 */
        try {
            Parent signUpRoot = FXMLLoader.load(getClass().getResource("memSignUp.fxml"));
            Scene scene = new Scene(signUpRoot);
            Stage primaryStage = (Stage)btn_signup.getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert lbl_pw != null : "fx:id=\"lbl_pw\" was not injected: check your FXML file 'memLogin.fxml'.";
        assert btn_signup != null : "fx:id=\"btn_singup\" was not injected: check your FXML file 'memLogin.fxml'.";
        assert lbl_login != null : "fx:id=\"lbl_login\" was not injected: check your FXML file 'memLogin.fxml'.";
        assert lbl_id != null : "fx:id=\"lbl_id\" was not injected: check your FXML file 'memLogin.fxml'.";
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'memLogin.fxml'.";
        assert hbox3 != null : "fx:id=\"hbox3\" was not injected: check your FXML file 'memLogin.fxml'.";
        assert hbox2 != null : "fx:id=\"hbox2\" was not injected: check your FXML file 'memLogin.fxml'.";
        assert tfMem_pw != null : "fx:id=\"tfMem_pw\" was not injected: check your FXML file 'memLogin.fxml'.";
        assert hbox1 != null : "fx:id=\"hbox1\" was not injected: check your FXML file 'memLogin.fxml'.";
        assert tfMem_id != null : "fx:id=\"tfMem_id\" was not injected: check your FXML file 'memLogin.fxml'.";
        assert btn_login != null : "fx:id=\"btn_login\" was not injected: check your FXML file 'memLogin.fxml'.";
        assert taResult != null : "fx:id=\"taResult\" was not injected: check your FXML file 'memLogin.fxml'.";

        IMemLoginService service = MemLoginService.getInstance();

        btn_login.setOnAction( event -> {
            MemVo memVo =  new MemVo();
            Map<String, String> map = new HashMap<String, String>();
            map.put(tfMem_id.getText(), tfMem_pw.getText());
            memVo = service.login(map);
            if(memVo.getMem_name() != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("로그인 회원명은?");
                alert.setContentText(memVo.getMem_name());
                alert.show();

                taResult.setText(memVo.getMem_name()+ "\n");
                taResult.appendText(memVo.getMem_id() + "\n");
                taResult.appendText(memVo.getMem_pass() + "\n");
                taResult.appendText(memVo.getMem_name() + "\n");
                taResult.appendText(memVo.getMem_regno1() + "\n");
                taResult.appendText(memVo.getMem_regno2() + "\n");
                taResult.appendText(memVo.getMem_bir() + "\n");
                taResult.appendText(memVo.getMem_zip() + "\n");
                taResult.appendText(memVo.getMem_add1() + "\n");
                taResult.appendText(memVo.getMem_add2() + "\n");
                taResult.appendText(memVo.getMem_hometel() + "\n");
                taResult.appendText(memVo.getMem_comtel() + "\n");
                taResult.appendText(memVo.getMem_hp() + "\n");
                taResult.appendText(memVo.getMem_mail() + "\n");
                taResult.appendText(memVo.getMem_job() + "\n");
                taResult.appendText(memVo.getMem_like() + "\n");
                taResult.appendText(memVo.getMem_memorial() + "\n");
                taResult.appendText(memVo.getMem_memorialday() + "\n");
                taResult.appendText(memVo.getMem_mileage() + "\n");
                taResult.appendText(memVo.getMem_delete() + "\n");

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("잘못된 시도 입니다.");
                alert.setContentText(memVo.getMem_id());
                alert.show();
            }
        });

    }
}
