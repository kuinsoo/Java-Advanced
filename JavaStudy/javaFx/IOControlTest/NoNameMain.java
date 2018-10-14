import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NoNameMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Noname.fxml"));
            Scene scene = new Scene(root, 700, 500);
            primaryStage.setScene(scene);
            primaryStage.setTitle("NaName.txt");
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
