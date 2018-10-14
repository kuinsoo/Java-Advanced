package javaFx;

import java.util.Optional;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex_checkbox_radio extends Application {

	@Override
	public void start(Stage primaryStage) {
		String[] hobbies = new String []{"여행","등산","독서","바둑","장기","게임","테니스","배드민턴"};
		VBox root = new VBox();
		root.setSpacing(10);
		root.setPadding(new Insets(10));
		HBox hBox1 = new HBox();
		HBox hBox2 = new HBox();
		HBox hBox3 = new HBox(5);
		HBox hBox4 = new HBox();
		Label lblName =  new Label("이름 : ");
		TextField tfName =  new TextField();

		Label lblGender =  new Label("성별 : ");
		ToggleGroup group =  new ToggleGroup();
		RadioButton rbGender1 =  new RadioButton("남");
		rbGender1.setToggleGroup(group);
		rbGender1.setUserData("남");
		RadioButton rbGender2 =  new RadioButton("여");
		rbGender2.setToggleGroup(group);
		rbGender2.setUserData("여");

		Label lblHobby =  new Label("취미 : ");
		CheckBox[] cbArr = new CheckBox[hobbies.length];
		for (int i = 0; i < hobbies.length; i++) {
			cbArr[i] = new CheckBox(hobbies[i]);
		}

		Button btn = new Button("출력");

		TextArea taResult = new TextArea();

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(!tfName.getText().equals("") && tfName.getText().length() != 0) {
				taResult.setText(tfName.getText() + "\n");
				} else {
					Alert alertWarning = new Alert(AlertType.WARNING);
					alertWarning.setTitle("WARNING");
					alertWarning.setHeaderText("경고");
					alertWarning.setContentText("이름을 입력해주세요.");
					alertWarning.showAndWait();

					return;
				}

				if(group.getSelectedToggle() != null ) {
				String str = group.getSelectedToggle().getUserData().toString();
				taResult.appendText(str + "\n");
				} else {
					taResult.setText("성별을 체크해주세요");
					return;
				}

				boolean isHobby = false;
				String strHob = "";
					for (int i = 0; i < cbArr.length; i++) {

						if(cbArr[i].isSelected()) {
							if(!strHob.equals("")) {
								strHob += ", ";
							}
							strHob += cbArr[i].getText();
							isHobby = true;
						}
					}
					taResult.appendText(strHob);

					if(isHobby == false ) {
						taResult.setText("취미가 없으신가요?\n 한번 만들어 봐요");
						return;
				}


			}
		});

		hBox1.getChildren().addAll(lblName, tfName);
		hBox2.getChildren().addAll(lblGender,rbGender1,rbGender2);
		hBox3.getChildren().addAll(cbArr);
		hBox4.getChildren().addAll(lblHobby,hBox3);
		root.getChildren().addAll(hBox1,hBox2,hBox4,btn,taResult);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("취미를 알아보자");
		primaryStage.show();


	}

	public static void main(String[] args) {
		launch(args);
	}
}
