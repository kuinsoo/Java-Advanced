package javaFx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		// ���� ��ư���� �������� ó���� ��ü
		ToggleGroup group = new ToggleGroup();
		
		ImageView icon = new ImageView();
		
		RadioButton rb1 = new RadioButton("Home");
		rb1.setToggleGroup(group); // �׷� ����
		rb1.setUserData("Home");	//�������� ���� ���� ��Ÿ���� ���� ����
		
		RadioButton rb2 = new RadioButton("Calendar");
		rb2.setToggleGroup(group);
		rb2.setUserData("Calendar");
		
		
		
		// �ڵ� üũ ����
		rb2.setSelected(true);
		
		RadioButton rb3 = new RadioButton("Contacts");
		rb3.setToggleGroup(group);
		rb3.setUserData("Contacts");
		
		group.selectedToggleProperty().addListener(
			new ChangeListener<Toggle>() {
				@Override
				public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
					// TODO Auto-generated method stub
					String  url = group.getSelectedToggle().getUserData().toString();
					Image 	img = new Image (getClass().getResourceAsStream("images/"+url+".jpg"));
					icon.setImage(img);
				}
			});
		
		
		
		HBox hBox = new HBox();
		VBox vBox = new VBox();
		
		vBox.getChildren().addAll(rb1,rb2,rb3);
		vBox.setSpacing(10);
		
		hBox.getChildren().addAll(vBox, icon);
		hBox.setSpacing(30);
		hBox.setPadding(new Insets(15));
		
		Scene scene = new Scene(hBox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("RadiButton ����");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
