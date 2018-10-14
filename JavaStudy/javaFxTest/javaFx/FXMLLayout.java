package javaFx;
/*
* * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLLayout extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //FXML로 디자인된 문서를 읽어와 보여주기 방법1
        //                     현재 클래스    FXML이 있는 파일명(경로)
//      HBox hbox = FXMLLoader.load(getClass().getResource("FxmlLayout.fxml"));
//      Parent hbox = FXMLLoader.load(getClass().getResource("FxmlLayout.fxml"));

        //FXML 문서 읽기 방법2
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("FxmlLayout.fxml"));
        Parent hbox = loader.load();
        Scene scene = new Scene(hbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("FXML문서를 이용한 레이아이웃");
        primaryStage.show();

    }
}
