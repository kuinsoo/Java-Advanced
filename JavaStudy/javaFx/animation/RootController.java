

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RootController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLogin;

    @FXML
    void initialize() {
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Root.fxml'.";

        btnLogin.setOnAction(event -> handleBtnLogin(event));
    }

    public void handleBtnLogin(ActionEvent actionEvent) {
        try {
            Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));

            // 현재 컨트롤을 이용하여 루트 컨테이너 구하기
            StackPane root = (StackPane) btnLogin.getScene().getRoot();
            System.out.println(root);

            //root.getChildren().clear(); // 뒤에 있는 것을 지운다.
            root.getChildren().add(login);

            /* 확대, 축소 배율 */
            login.setScaleX(0); //값이 2면 두배 크기란 의미이다.
            login.setScaleY(0); //값이 2면 두배 크기란 의미이다.
            login.setRotate(10000);

            Timeline timeline = new Timeline();
            KeyValue keyValue1 = new KeyValue(login.scaleXProperty(),1);
            KeyValue keyValue2 = new KeyValue(login.scaleYProperty(),1);
            KeyValue keyValue3 = new KeyValue(login.rotateProperty(),0);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue1,keyValue2, keyValue3);
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();

            /*회전 애니메이션
            login.setRotate(5800);

            Timeline timeline = new Timeline();
            KeyValue keyValue = new KeyValue(login.rotateProperty(),0);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(5000), keyValue);
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
            */

            /* Fade 효과 애니메이션 (불투명도를 이용하여 나타낸다.
            *  값의 범위 : 투명(0,0) ~ 불투명(1.0)
            login.setOpacity(0); // 불투명도를 설정(시작값)

            Timeline timeline = new Timeline();
            KeyValue keyValue = new KeyValue(login.opacityProperty(),1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
            */


//            /* 이동 애니메이션 */
//            login.setTranslateY(350); // x축으로 평행이동할 양 설정
//            Timeline timeline = new Timeline(); // KeyFrame에 설정된 내용대로 애니메이션을 진행시키는 객체
//
//            /* 타겍속성과 종료값을 설정하기 */
//            KeyValue keyValue = new KeyValue(login.translateYProperty(), 0);
//
//            /* 지속시간과 KeyVallue 를 설정하기
//            *  new keyFrame(지속시간, KeyValue 객체
//            *  new keyFrame(지속시간, 애니메이션이 종료된 후 처리될 이벤트 지정 */
//            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
//
//            /* Timeline 에 KeyFrame 추가 */
//            timeline.getKeyFrames().add(keyFrame);
//
//            /* 애니메이션 실행 */
//            timeline.play();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 현재 컨트롤을 이용하여
    }
}
