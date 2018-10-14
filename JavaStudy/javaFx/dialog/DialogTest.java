
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.*;

import java.io.File;
import java.io.IOException;

public class DialogTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox(10);
        root.setPadding(new Insets(10));

        Button btnFileOpen = new Button("Open FileChooser 실행");
        Button btnFileSave = new Button("Save FileChooser 실행");
        Button btnDirectory = new Button("DirectoryChooser 실행");
        Button btnPopup = new Button("Popup 실행");
        Button btnCustom = new Button("Custom Dialog 실행");

        root.getChildren().addAll(btnFileOpen, btnFileSave, btnDirectory, btnPopup, btnCustom);

        //------------------------------------------------------------

        /* 파일 열기 */
        btnFileOpen.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();

            // 확장자 종류에 맞는 파일 목록을 보이도록 선택하는 옵션설정
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All File", "*.*"),
                new FileChooser.ExtensionFilter("Text File", "*.txt"),
                new FileChooser.ExtensionFilter("Image File", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Audio File", "*.wav")
            );
            // 선택한 파일 표시
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                System.out.println("선택한 파일: " + selectedFile.getPath());
            }

        });

        /* 파일 저장의 파일 선택 창 */
        btnFileSave.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();

            // 확장자 종류에 맞는 파일 목록
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All File", "*.*"),
                new FileChooser.ExtensionFilter("Text File", "*.txt"),
                new FileChooser.ExtensionFilter("Image File", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Audio File", "*.wav")
            );
            File selectedFile = fileChooser.showSaveDialog(primaryStage);
            if (selectedFile != null) {
                System.out.println("선택한 파일(저장): " + selectedFile.getPath());
            }
        });

        /* 디렉토리 선택 창 */
        btnDirectory.setOnAction(event -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File selectedDir = directoryChooser.showDialog(primaryStage);
            if (selectedDir != null) {
                System.out.println("Selected Folder :" + selectedDir.getPath());
            }
        });

        /* Popup창 --> 작업 중 간단한 메시지를 보여주는 창 */
        btnPopup.setOnAction(event -> {
            Popup popup = new Popup();
            HBox popupRoot = new HBox(5);
            popupRoot.setAlignment(Pos.CENTER_LEFT);
            popupRoot.setStyle("-fx-background-color: #e45136; -fx-background-radius: 50;");
            ImageView imageView = new ImageView(new Image(getClass().getResource("images/ok.png").toString()));
            // imageView Size
            imageView.setFitWidth(30);
            imageView.setFitHeight(30);

            imageView.setOnMouseClicked(event1 -> {
                popup.hide(); //popup 창 닫기
            });
            Label lblMessage = new Label();
            lblMessage.setText("메세지가 왔습니다.");
            HBox.setMargin(lblMessage, new Insets(0, 5, 0, 5));
            popupRoot.getChildren().addAll(imageView, lblMessage);
            popup.setAutoHide(true); // 창 외부 아무곳이나 누르면 창이 닫힌다.
            popup.getContent().add(popupRoot);
            popup.show(primaryStage);
        });

        /* 사용자 정의 창 띄우기 */
        btnCustom.setOnAction(event -> {

            Stage dialog = new Stage(StageStyle.UNIFIED); // Style

            // modal -> 자식창이 닫히기 전에는 부모창을 사용하지 못하는 창을 말한다
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(primaryStage); // 부모창 지정

            try {
                // 자식창 디자인 정보 읽어오기
                Parent childRoot = FXMLLoader.load(getClass().getResource("custom.fxml"));
                // 부모창에서 fxml로 만든 자식창의 컨트롤 객체 구하기
                // fxml 문서의 id 값을 이용하여 구할 수 있다.
                Label lblMessage = (Label)childRoot.lookup("#lblMsg");
                lblMessage.setText("이것은 부모창에서 보낸 메세지 입니다.");


                Scene scene = new Scene(childRoot);
                dialog.setScene(scene);
                dialog.setResizable(false); // 창크기 불가능
                dialog.show();



            } catch (IOException e) {
                e.printStackTrace();
            }

        });

            //---------------------------- 출력 ------------------------------
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Dialog 연습");
            primaryStage.setHeight(200);
            primaryStage.show();
    }
}
