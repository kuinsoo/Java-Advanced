

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class javaFX_Modality extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btnNONE = new Button("Open NONE Dialog");
        Button btnAPP_MODAL = new Button("Open APPLICATION MODAL Dialog");
        Button btnWIN_MODAL = new Button("Open WINDOW_MODAL Dialog");

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(btnNONE,btnAPP_MODAL,btnWIN_MODAL);
        //**************************************
        // NONE
        btnNONE.setOnAction(event -> {
            Stage dialogNONE = new Stage();
            dialogNONE.initModality(Modality.NONE);
            dialogNONE.initOwner(primaryStage);

            VBox vBox1 = new VBox(10);

            vBox1 = new VBox(10);
            Text txt1 = new Text("NONE Dialog");
            Text txt2 = new Text("모달 기능이 없는 모달리스 창");
            vBox1.getChildren().addAll(txt1, txt2);
            vBox1.setAlignment(Pos.CENTER);
            vBox1.setPadding(new Insets(10));

            Scene scene = new Scene(vBox1, 500, 90);
            dialogNONE.setScene(scene);
            dialogNONE.setTitle("NONE dialog");
            dialogNONE.show();

        });
        // --------------------------------------------

        btnAPP_MODAL.setOnAction(event -> {
            Stage dialogAPP = new Stage();
            dialogAPP.initModality(Modality.APPLICATION_MODAL);
            dialogAPP.initOwner(primaryStage);

            VBox vBox1 = new VBox(10);

            vBox1 = new VBox(10);
            Text txt1 = new Text("APPLICATION_MODAL Dialog");
            Text txt2 = new Text("부모창 및 다른 창을 선택하지 못하는 모달 창");
            vBox1.getChildren().addAll(txt1, txt2);
            vBox1.setAlignment(Pos.CENTER);
            vBox1.setPadding(new Insets(10));

            Scene sceneAPP = new Scene(vBox1, 500, 90);
            dialogAPP.setScene(sceneAPP);

            dialogAPP.setTitle("NONE dialog");
            dialogAPP.show();
        });
        // --------------------------------------------------
        btnWIN_MODAL.setOnAction(event -> {
            Stage dialogWIN = new Stage();
            dialogWIN.initModality(Modality.WINDOW_MODAL);
            dialogWIN.initOwner(primaryStage);

            VBox vBox1 = new VBox(10);

            vBox1 = new VBox(10);
            Text txt1 = new Text("WINDOWS_MODAL Dialog");
            Text txt2 = new Text("부모창을 선택하지 못하는 모달 창");
            vBox1.getChildren().addAll(txt1, txt2);
            vBox1.setAlignment(Pos.CENTER);
            vBox1.setPadding(new Insets(10));

            Scene sceneWIN = new Scene(vBox1, 500, 90);
            dialogWIN.setScene(sceneWIN);
            dialogWIN.setTitle("NONE dialog");
            dialogWIN.show();
        });

        // ----------------------------------------
        Scene scene = new Scene(vBox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("모달연습");
        primaryStage.show();
    }
}
