package javaFx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CheckBoxTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		String[]    names   = new String[] {"Security.png", "Project.png", "Chart.png"};
        Image[]     images  = new Image     [names.length];
        ImageView[] icons   = new ImageView [names.length];
        CheckBox[]  chkBoxs = new CheckBox  [names.length];

        Rectangle rect = new Rectangle(90, 30); // 4각형 그리기
        rect.setArcWidth(10);
        rect.setArcHeight(10);
        rect.setFill(Color.rgb(41,41,41));

        Button btn = new Button("확인");

        for (int i = 0; i < names.length; i++) {
           final Image img      = images[i]   = new Image(getClass().getResourceAsStream("./images/"+ names[i]));
           final ImageView icon = icons[i]    = new ImageView();
            chkBoxs[i]  = new CheckBox(names[i]);

            // CheckBox를 클릭해서 상태값이 변경되었을 때 처리하기
            chkBoxs[i].selectedProperty().addListener(
                    new ChangeListener<Boolean>() {
                    	
                    						@Override
						public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
								Boolean newValue) {
					        // oldValue ==> 변경되기 전 상태값
                            // newValue ==> 변경된 후의 상태값

                            /* 체크박스가 체크되면 해당 이미지를 보이게 한다. */
                            icon.setImage(newValue ? img : null);
							
						}
                    }
            ); // 체크가 되었는지 확인

        }

        btn.setOnAction( e -> {
            boolean isChkBox = chkBoxs[0].isSelected();
            if(isChkBox) {
                System.out.println("첫번째 CheckBox 선택");
            } else {
                System.out.println("첫번째 checkBox 해제");
            }
            // setSelected
            chkBoxs[1].setSelected(!chkBoxs[0].isSelected());
        });

        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(chkBoxs);
        vBox.getChildren().add(btn);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(icons);
        hBox.setPadding(new Insets(0,0,0,5));

        StackPane stack = new StackPane();
        stack.getChildren().addAll(rect,hBox);
        StackPane.setAlignment(rect, Pos.TOP_CENTER);

        HBox root = new HBox();
        root.setPadding(new Insets(20,10,10,20));
        root.setSpacing(40);
        root.getChildren().addAll(vBox,stack);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CheckBox 연습?");
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
