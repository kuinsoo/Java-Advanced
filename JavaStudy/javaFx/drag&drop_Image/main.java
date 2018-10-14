import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            URL url =
                getClass()
                    .getResource("image-view.fxml");
            BorderPane root = FXMLLoader.load(url);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage
                .setTitle("JavaFX Drop Image");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
