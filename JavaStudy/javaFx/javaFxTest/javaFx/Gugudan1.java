package javaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.regex.Pattern;

public class Gugudan1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();


        HBox hBox = new HBox();
        // �떒�엯�젰 李�
        TextField textField = new TextField();

        // 異쒕젰踰꾪듉
        Button button = new Button("異쒕젰");

        // 援ш뎄�떒 異쒕젰
        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(10);
        textArea.setPrefColumnCount(10);


        // �씠踰ㅽ듃 泥섎━
        button.setOnAction(event -> {
            String  strDan = textField.getText();
            Pattern.matches("^[0-9]+$", "strDan"); // �뙣�꽩�쓣 異붽��빐以섎룄 �맂�떎.
            int dan  =  Integer.parseInt(strDan);
            textArea.setText(dan + " �엯�땲�떎\n");
            for (int i = 1; i < 10; i++) {
                int sum = dan * i ;
                int a = 0;
                textArea.appendText(dan + " * " + i + " = " + sum + "\n");
            }

            });
        hBox.getChildren().addAll(textField,button);
        root.getChildren().addAll(hBox,textArea);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("援ш뎄�떒 異쒕젰");
        primaryStage.show();

    }
}
