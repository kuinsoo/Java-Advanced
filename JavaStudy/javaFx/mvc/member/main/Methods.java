package member.main;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Methods {

    public void alertError(TextField type) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText(type.getPromptText() + "을/를 입력해주세요!");
        alert.show();
    }

    public void alertImformation(String imfo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ERROR");
        alert.setContentText(imfo);
        alert.show();
    }
}
