package javaFx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;

public class Calculator_Pane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setPrefSize(500,250);
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        TextField tfld = new TextField("0");
        tfld.setStyle("-fx-background-color: white");
        tfld.setAlignment(Pos.CENTER_RIGHT);
        HBox hBox = new HBox();
        hBox.setStyle("-fx-background-color: #ccc");

        Label lbl = new Label("0000000000000000000000000000000000");
        lbl.setStyle("-fx-background-color: #ffffff");
        String[] str = new String[]{
                                    "MR","MC","MS","M+","M-",
                                    " ","Inv","In","(",")","�넀","CE","C","짹","�닖",
                                    "Int","sinh","sin","x짼","�닆!","7","8","9","/","%",
                                    "dms","cosh","cos","x節�","�겳�닖x","4","5","6","*","1/節�",
                                    "�","tanh","tan","x쨀","쨀�닖x","1","2","3","-","竊�",
                                    "F-E","Exp","Mod","log","10節�","0",".","+"
                                    };
        Button[] bntArr = new Button[str.length];
        for (int i = 0; i <str.length ; i++) {
            bntArr[i] = new Button(str[i]);
            bntArr[i].setMaxSize(80,40);
        }






        root.add(tfld,0,0,10,3);
        root.add(hBox,0,3,5,1);
        root.add(bntArr[0] ,5,3);
        root.add(bntArr[1],6,3);
        root.add(bntArr[2],7,3);
        root.add(bntArr[3],8,3);
        root.add(bntArr[4],9,3);
        root.add(bntArr[5],0,4);
        root.add(bntArr[6],1,4);
        root.add(bntArr[7],2,4);
        root.add(bntArr[8],3,4);
        root.add(bntArr[9],4,4);
        root.add(bntArr[10],5,4);
        root.add(bntArr[11],6,4);
        root.add(bntArr[12],7,4);
        root.add(bntArr[13],8,4);
        root.add(bntArr[14],9,4);
        root.add(bntArr[15],0,5);
        root.add(bntArr[16],1,5);
        root.add(bntArr[17],2,5);
        root.add(bntArr[18],3,5);
        root.add(bntArr[19],4,5);
        root.add(bntArr[20],5,5);
        root.add(bntArr[21],6,5);
        root.add(bntArr[22],7,5);
        root.add(bntArr[23],8,5);
        root.add(bntArr[24],9,5);
        root.add(bntArr[25],0,6);
        root.add(bntArr[26],1,6);
        root.add(bntArr[27],2,6);
        root.add(bntArr[28],3,6);
        root.add(bntArr[29],4,6);
        root.add(bntArr[30],5,6);
        root.add(bntArr[31],6,6);
        root.add(bntArr[32],7,6);
        root.add(bntArr[33],8,6);
        root.add(bntArr[34],9,6);
        root.add(bntArr[35],0,7);
        root.add(bntArr[36],1,7);
        root.add(bntArr[37],2,7);
        root.add(bntArr[38],3,7);
        root.add(bntArr[39],4,7);
        root.add(bntArr[40],5,7);
        root.add(bntArr[41],6,7);
        root.add(bntArr[42],7,7);
        root.add(bntArr[43],8,7);
        root.add(bntArr[44],9,7,1,2);
        root.add(bntArr[45],0,8);
        root.add(bntArr[46],1,8);
        root.add(bntArr[47],2,8);
        root.add(bntArr[48],3,8);
        root.add(bntArr[49],4,8);
        root.add(bntArr[50],5,8,2,1);
        root.add(bntArr[51],7,8);
        root.add(bntArr[52],8,8);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("怨꾩궛湲�");
        primaryStage.show();
    }
}
