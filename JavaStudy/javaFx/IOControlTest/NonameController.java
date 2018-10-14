import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NonameController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private BorderPane root;

    @FXML
    private URL location;

    @FXML
    private MenuItem mi_close;

    @FXML
    private MenuItem mi_new;

    @FXML
    private MenuItem mi_newSave;

    @FXML
    private TextArea ta_main;

    @FXML
    private MenuItem mi_open;

    @FXML
    void newOnAction(ActionEvent event) {
        ta_main.clear();
    }

    @FXML
    void openOnAtion(ActionEvent event) {
        Stage stage =  (Stage)root.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();

        /* 확장자 종류에 맞는 파일 목록을 보이도록 선택하는 옵션 설정 */
        fileChooser.getExtensionFilters().addAll(
          new FileChooser.ExtensionFilter("Text File","*.txt"),
          new FileChooser.ExtensionFilter("All File", "*.*")
        );

        /* 선택한 파일 표시 */
        File selectedFile = fileChooser.showOpenDialog(stage);
        if(selectedFile != null) {
            System.out.println("선택한 파일 : " + selectedFile.getPath());
            System.out.println(selectedFile);
        }

        try {
            BufferedReader br = new BufferedReader( new InputStreamReader(new FileInputStream(selectedFile),"UTF-8"));
            String s ="";
            while( (s = br.readLine()) != null){
                ta_main.appendText(s+ "\n");
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void newSaveOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        // 확장자 종류에 맞는 파일 목록
        fileChooser.getExtensionFilters().addAll(
          new FileChooser.ExtensionFilter("All File", "*.*"),
          new FileChooser.ExtensionFilter("Text File","*.txt")
        );
        fileChooser.setInitialFileName("noName.txt");
        File selectedFile = fileChooser.showSaveDialog(root.getScene().getWindow());
        if(selectedFile != null) {
            System.out.println("선택한 파일 저장 : " + selectedFile);
            System.out.println(fileChooser.getInitialDirectory());
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile));

            bw.write(ta_main.getText());
            bw.close();



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void closeOnAction(ActionEvent event) {
        Stage mainRoot = (Stage) root.getScene().getWindow();
        mainRoot.close();
        Platform.exit();

    }

    @FXML
    void initialize() {
        assert mi_close != null : "fx:id=\"mi_close\" was not injected: check your FXML file 'NoName.fxml'.";
        assert mi_new != null : "fx:id=\"mi_new\" was not injected: check your FXML file 'NoName.fxml'.";
        assert mi_newSave != null : "fx:id=\"mi_newSave\" was not injected: check your FXML file 'NoName.fxml'.";
        assert ta_main != null : "fx:id=\"ta_main\" was not injected: check your FXML file 'NoName.fxml'.";
        assert mi_open != null : "fx:id=\"mi_open\" was not injected: check your FXML file 'NoName.fxml'.";
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'NoName.fxml'.";

    }
}
