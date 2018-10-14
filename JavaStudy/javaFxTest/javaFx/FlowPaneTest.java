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
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane();

        root.setPrefSize(300,200);
        root.setHgap(10);
        root.setVgap(30);

        root.setPadding(new Insets(10));

        Button[] btns = new Button[10];

        for (int i = 0; i < btns.length; i++) {
            btns[i] = new Button("버튼_" + i);
        }
        root.getChildren().addAll(btns);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("FlowPane 연습");
        primaryStage.show();
    }
}
