package javaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventTest extends Application {
	 private TextArea textArea = new TextArea();
	 
	public static void main(String[] args) {
		launch(args);
	}
	@Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10); // 과호 속의 값은 Spacing 값;
        root.setPadding(new Insets(10));

        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(10));
        Button btn1 = new Button("첫번째");
        Button btn2 = new Button("두번째");
        Button btn3 = new Button("세번째");
        Button btn4 = new Button("네번째");



        // 이벤트 설정하기

        /* 방법 1 => 객체.setOn'이벤트명'() 메서드 이용하기
        				EventHandler 인터페이스를 익명구현체 형식으로 구현.
        				(이 인터페이스에는 handle 메서드가 있는데 이 메서드에 처리할 내용을 기술한다.)
        */
        btn1.setOnAction(
//        	new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				// 이 곳에 이벤트를 처리할 내용을 기술한다.
//				textArea.setText("첫번째 버튼 클릭입니다.");
//				textArea.appendText("\n이어서 출력할 내용입니다");
//
//			}
//		}

                //람다식
                event -> { textArea.setText("람다식의 첫번째 버튼 이벤트 처리입니다" );
                textArea.appendText("\nnew EventHandler<ActionEvent>() {\n" +
                        "//\n" +
                        "//\t\t\t@Override\n" +
                        "//\t\t\tpublic void handle(ActionEvent event) {\n" +
                        "//\t\t\t\t// 이 곳에 이벤트를 처리할 내용을 기술한다.\n" +
                        "//\t\t\t\ttextArea.setText(\"첫번째 버튼 클릭입니다.\");\n" +
                        "//\t\t\t\ttextArea.appendText(\"\\n이어서 출력할 내용입니다\");\n" +
                        "//\n" +
                        "//\t\t\t}\n" +
                        "//\t\t}");}
        );

        /* 방법 2 => 객체.addEventHandler() 메서드 이용하기
                        이 메서드의 첫번째 매개변수로 이벤트 종류를 지정하고
                        두번째 매개변수는 EventHandler 인터페이스를 구현한 객체를 지정한다.
        */
        btn2.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.appendText("\n두번째 버튼..");
            }
        });

        /* 방법 3 => EventHandler 인터페이스를 구현한 클래스를 inner 클래스로 작성한다 (class MyEventHandler 참조)
                        객체.setOn이벤트명() 메서드나 객체.addEventHandler() 메서드에 지정한다
        */
        btn3.setOnAction(new MyEventHandler());

        /* 방법 4 => 외부의 독립된 형태의 객체를 이용하는 방법
                        이 객체도 EventHandler 인터페이스를 구현하여 처리한다

        */
        btn4.setOnAction(new MyEvnet(textArea));


        hBox.getChildren().addAll(btn1,btn2,btn3,btn4);
        root.getChildren().addAll(hBox, textArea);

        Scene scene = new Scene(root, 600, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("이벤트 연습");
        primaryStage.show();
    }

    /* 방법 3번째 */
    class MyEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event ) {
            textArea.setText("inner 클래스 이용한 방법 => 세번째\n " +
                    "class MyEventHandler implements EventHandler<ActionEvent> {\n" +
                    "        @Override\n" +
                    "        public void handle(ActionEvent event ) {\n" +
                    "            textArea.setText(\"inner 클래스 이용한 방법 => 세번째\");\n" +
                    "        }\n" +
                    "    }");
        }
    }

}

/* 방법 4번째 */
class MyEvnet implements EventHandler<ActionEvent> {
    TextArea ta;
    //생성자
    public MyEvnet(TextArea ta) {
        this.ta = ta;

    }

    @Override
    public void handle(ActionEvent event) {
        ta.setText("4번째 외부 클래스를 이용한 방법");
    }
}
