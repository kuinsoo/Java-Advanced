package javaFx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ComboBoxTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		HBox hBox = new HBox();
		TextArea taResult = new TextArea();
		
		//방법 1
		ComboBox<String> comboBox = new ComboBox<String>();
		comboBox.getItems().addAll("한강", "금강", "영산강", "낙동강");
		
		//방법 2
		ObservableList<String> fruitList = 
				FXCollections.observableArrayList(
					"사과","배","딸기","복숭아","감"
				);
				
		ComboBox<String> comboBox2 = new ComboBox<>(fruitList);
		comboBox2.getItems().addAll("포도", "대추", "귤");
		
		Button btn = new Button("확인");
		
		// 콤보박스에서 값이 변경될 때의 처리
		// 즉, change이벤트 처리
		comboBox.valueProperty().addListener(
				new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue,
							String newValue) {
						taResult.setText("현재 선택 값: " + newValue);
						
					}
				});
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// 콤보박스의 현재 선택된 값은 getValue() 메서드를 이용하여 구할 수 있다
				if(comboBox.getValue() != null && comboBox2.getValue()!=null) {
					taResult.setText(comboBox.getValue() + " 지역의 과일은 "
							+ comboBox2.getValue() + "가 유명합니다.");
					
				}
 
 
			}
		});
		
		hBox.getChildren().addAll(comboBox,comboBox2, btn);
		
		root.setTop(hBox);
		root.setCenter(taResult);
		
		Scene scene = new Scene(root, 500, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ComboBox연습");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
