package javaFx;
/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ProgramLayout extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Java 코드를 이용한 화면 구성 예제
        HBox hbox = new HBox();   //컨테이너 객체 생성 (가로박스)


      /*
       <Padding>
       Insets객체를 이용하여 여백을 설정한다.
       이 객체는 위, 오른쪽, 아래, 왼쪽 순으로 값을 설정한다.
       만일 모든 방향이 같으면 하나의 값으로만 설정해도 무관하다.
       i) 방향이 다를때의 설정
       hbox.setPadding(new Insets(10,20,30,40));
       ii) 방향이 같을때의 설정
       hbox.setPadding(new Insets(20));
       */
        hbox.setPadding(new Insets(20));
        hbox.setSpacing(20);
        /*TextField 객체 생성*/
        TextField txt = new TextField();
        txt.setPrefWidth(200);   //TextField의 가로 길이 설정

      /*
        setText는 실제 출력할 내용을 입력할 때 사용
        PromptText는 임시적으로 나타낼때 사용
        실제 내용이 존재할 때는(setText 사용시) PromptText는 나타나지 않는다.
       */
        //txt.setPromptText("아무거나 입력하세요");   //임시로 보여줄 메세지
        txt.setText("실제내용");   //실제 출력할 내용

      /*Button 객체 생성
        Button 객체 생성시 생성자로 이용해 버튼에 들어갈 Text를 지정할 수 도있다.
        이때 생성자 안에 String을 Caption이라 한다.
        이외에도 Button에 들어갈 Text를 따로 지정할 수도 있다.
        ex) Button btn = new Button();
              btn.setText("확인");
       */
        Button btn = new Button("확인");

        hbox.getChildren().addAll(txt,btn);


        //Secene 객체 생성
        Scene scene = new Scene(hbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Program Layout Practice");
        primaryStage.show();

    }
}
