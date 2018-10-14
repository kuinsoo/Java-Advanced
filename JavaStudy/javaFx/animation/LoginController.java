import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnMain;

    @FXML
    private BorderPane login;

    @FXML
    void initialize() {
        assert btnMain != null : "fx:id=\"btnMain\" was not injected: check your FXML file 'Login.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'Login.fxml'.";

        btnMain.setOnAction(event -> handleBtnMain(event));
    }

    public void handleBtnMain(ActionEvent event) {
       try {
           Parent main = FXMLLoader.load(getClass().getResource("Root.fxml"));
           StackPane root = (StackPane) btnMain.getScene().getRoot();
           System.out.println(root);
           login.setTranslateY(0);
           Timeline timeline = new Timeline();
           KeyValue keyValue = new KeyValue(login.translateYProperty(),350);
           KeyFrame keyFrame = new KeyFrame(Duration.millis(500),
               new EventHandler<ActionEvent>() {
                   @Override
                   public void handle(ActionEvent event) {
                       root.getChildren().remove(login); // 애니메이션을 마친 객체를 StackPane 에서 제거한다.
                   }
               }, keyValue);
           timeline.getKeyFrames().add(keyFrame);
           timeline.play();

       }catch (Exception e) {

       }


        /* Parent main = null;
        KeyFrame keyFrame;
        KeyValue keyValue;
        Timeline timeline = new Timeline();
        StackPane mainStackPane = (StackPane)btnMain.getScene().getRoot();
        try {
            main = FXMLLoader.load(getClass().getResource("Root.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainStackPane.getChildren().add(main);
        main.setTranslateY(-350);
        keyValue = new KeyValue(main.translateYProperty(), 0 );
        keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        timeline.getKeyFrames().add(keyFrame);

        timeline.play();
        */

//
//        Scene scene = new Scene(main);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Main");
//        primaryStage.show();

    }
}
