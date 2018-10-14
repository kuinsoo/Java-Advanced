package javaFx;
/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class AnchorPaneTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        /* AnchorPane ==> 놓여질 컨트롤들을 x,y 좌표를 설정해서 배치한다.*/
        AnchorPane root = new AnchorPane();
        root.setPrefSize(300, 150);

        Label labelId = new Label("아 이 디 : ");
        labelId.setLayoutX(42);
        labelId.setLayoutY(22);

        Label labelPass = new Label("패스워드 :");
        labelPass.setLayoutX(42);
        labelPass.setLayoutY(62);

        TextField txtId = new TextField();
        txtId.setPromptText("아이디를 입력하세요");
        txtId.setLayoutX(125);
        txtId.setLayoutY(22);

        PasswordField txtPass= new PasswordField();
        txtPass.setPromptText("비밀번호를 입력하세요");
        txtPass.setLayoutX(125);
        txtPass.setLayoutY(62);

        Button login = new Button("로그인");
        login.setLayoutX(90);
        login.setLayoutY(110);

        Button cancel= new Button("취소");
        cancel.setLayoutX(180);
        cancel.setLayoutY(110);


        root.getChildren().addAll(labelId, labelPass, txtId, txtPass,login,cancel);
        Scene scene = new Scene(root);



        primaryStage.setScene(scene);
        primaryStage.show();



    }
}
