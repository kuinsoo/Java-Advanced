package javaFx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ComboBox_Gugudan extends Application {

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();

		HBox hBox = new HBox();
		ComboBox<Integer> combox_dan = new ComboBox<>();
		Button btn = new Button("출력");
		TextArea taResult = new TextArea();
		taResult.setPrefColumnCount(15);
		taResult.setPrefRowCount(15);

		ObservableList<Integer> list = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9);
		combox_dan.setItems(list);

		combox_dan.setCellFactory(
				new Callback<ListView<Integer>, ListCell<Integer>>() {

					@Override
					public ListCell<Integer> call(ListView<Integer> param) {
						// TODO Auto-generated method stub
						return new ListCell<Integer>() {
							@Override
							protected void updateItem(Integer item, boolean empty) {
								// TODO Auto-generated method stub
								super.updateItem(item, empty);
								if(item == null || empty) {
									setText(null);
								}else {
									setText(item.toString() + "단" );
								}
							}
						};
					}
				});

		combox_dan.setButtonCell(
				new ListCell<Integer>() {
				@Override
				protected void updateItem(Integer item, boolean empty) {
					// TODO Auto-generated method stub
					super.updateItem(item, empty);
					if(empty) {
						setText(null);
					}else {
						setText(item.toString() + "단");
					}
				}});

		// 이벤트 처리
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int dan = combox_dan.getValue();
				taResult.setText(dan + "단 입니다\n");
				for (int i = 1; i < 10; i++) {
					int result = dan * i;
					taResult.appendText(dan + " * " + i + " = " + result + "\n");
				}
			}
		});

		hBox.getChildren().addAll(combox_dan,btn);
		root.getChildren().addAll(hBox,taResult);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("구구단");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
