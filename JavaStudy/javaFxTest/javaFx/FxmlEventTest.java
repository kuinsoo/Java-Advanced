package javaFx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlEventTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		 try {
			 	Parent root = FXMLLoader.load(getClass().getResource("FxmlEventTest.fxml"));
	            //Parent root = FXMLLoader.load(getClass().getResource("FxmlEventTest.fxml"));

	            Scene scene = new Scene(root);
	            primaryStage.setScene(scene);
	            primaryStage.setTitle("Fxml문서 이벤트 처리하기");
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	public static void main(String[] args) {
		launch(args);
	}
}
