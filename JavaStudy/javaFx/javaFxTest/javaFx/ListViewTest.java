package javaFx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ListViewTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		ListView<String> list = new ListView<>();
		Label lbl = new Label();
		
		// 자바 Fx의 컨트롤에 사용되는 데이터를 담을 수 있는 List
		// FXcollections  로 리스트를 만들어 준다.
		ObservableList<String> data = FXCollections.observableArrayList(
				"green", "gold", "red", "blue", "green", "yellow", "black", "brown", "pink", "chocolate"
		);
		
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(10));
		
		vBox.getChildren().addAll(list, lbl);
		
		lbl.setFont(new Font(20)); // Label의 글자 크기 설정
		list.setItems(data);		// ListView에 데이터 설정
		
		
		/* ListView 에서  선택되었을 때 처리 */
		list.getSelectionModel().selectedItemProperty().addListener(
		new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			lbl.setText(newValue);
			lbl.setTextFill(Color.web(newValue));  //글자색 변경
			
			}
		});
		
		// ListView 의 원래 데이터는 변경되지 않고 화면에 보이는 내용을 변경하는 방법
		list.setCellFactory(
			new Callback<ListView<String>, ListCell<String>>() {
				
				@Override
				public ListCell<String> call(ListView<String> param) {
					// TODO Auto-generated method stub
					return new ListCell<String>() {
						protected void updateItem(String item, boolean empty) {
							super.updateItem(item, empty);
							/* 변경될 내용을 기술한다
							 	이 메서드의 첫번째 매개변수 (item)는 원래 데이터를 나타내고 
							 	두번째 매개변수 (empty)는 원래 데이터가 있었는지 혹은 없었는지를 나타낸다.
							*/
							Rectangle rect = new Rectangle(100,20);
							if(item!=null) {
								rect.setFill(Color.web(item));
								Button btn = new Button(item);
								// 그래픽이나 컨트롤로 변결될 때는 setGraphic()메서드를 사용하고 
								// 문자열로 변경될 때는 setText() 메서드를 사용한다
								setGraphic(rect);	// 값을 변경한다
//								setGraphic("bnt");
//								setText("Test " + item);
							}
						};
					};
				}
			}
		);
		
		
		Scene scene = new Scene(vBox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ListView연습");
		primaryStage.show();
		
		
				
	}

	public static void main(String[] args) {
		launch(args);
	}
}
