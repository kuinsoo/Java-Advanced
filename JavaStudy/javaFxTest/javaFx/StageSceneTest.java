package javaFx;
/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StageSceneTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(); // control 들을 세로로 배치하는 Container

        root.setPrefWidth(650); // 가로 크기
        root.setPrefHeight(150);// 새로 크기

        root.setAlignment(Pos.CENTER); // 컨트롤들을 가운데 정렬
        root.setSpacing(20);

        Label label = new Label(); // Label control
        label.setText("안녕하세요. JavaFx입니다.");
        label.setFont(new Font(50));    // Font 객체를 이용하여 글자 크기 설정

        Button btn = new Button();
        btn.setText("확인");
        // 버튼을 클릭했을 때 이벤트 처리하기

        // 람다식 표현
        btn.setOnAction((evnet) -> {
                Platform.exit();
        });

        // 기본식
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                /*처리할 내용을 이곳에 기술한다.*/

                // 창 닫기 (프로그램 종료)
                // primaryStage.close();

                Platform.exit();

                /*시스템 종료 Stop() 메서드가 실핼되지 않는다. */
                //System.exit(0);
            }
        });



        // VBox 컨테이너에 컨트롤들 추가히기

        // 방법1. 각각 컨트롤들을 하나씩 추가(add() 메서드 이용)
//        root.getChildren().add(label);
//        root.getChildren().add(btn);

        // 방법2. 여러개의 컨트롤들을 한꺼번에 추가 (addAll() 메서드 이용)
        root.getChildren().addAll(label,btn);
        /*-------------------------------------------------------------*/

        //VBox를 루트 컨터이너로 하는 Scene객체 생성
        Scene scene = new Scene(root);

        // Scene 객체를 Stage 객체 추가
        primaryStage.setScene(scene);

        primaryStage.setTitle("Stage와  Scene연습"); // 창 제목

        primaryStage.show(); // 창보이기


    }
}
