package javaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Gugudan extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane();

        // �떒�엯�젰 李�
        TextField textField = new TextField();

        // 異쒕젰踰꾪듉
        Button button = new Button("異쒕젰");

        // 援ш뎄�떒 異쒕젰
        TextArea textArea = new TextArea();
        textArea.setPrefSize(300,200);

        // �씠踰ㅽ듃 泥섎━
        button.setOnAction(event -> {
            int dan = Integer.parseInt(textField.getText());
            textArea.setText(dan + " �엯�땲�떎\n");
            for (int i = 1; i < 10; i++) {
                int sum = dan * i ;
                textArea.appendText(dan + " * " + i + " = " + sum + "\n");
            }

            });

         root.getChildren().addAll(textField,button,textArea);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("援ш뎄�떒 異쒕젰");
        primaryStage.show();

    }
}
