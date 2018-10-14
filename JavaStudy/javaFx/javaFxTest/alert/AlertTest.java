package alert;

import java.util.Optional;



import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AlertTest extends Application {

	@Override

	public void start(Stage primaryStage) {

		/* --------------------------------------------------------------------------------------------------------------- */
		Alert alertInfo = new Alert(AlertType.INFORMATION); // Alert 정보 표현 방법설정
		alertInfo.setTitle("INFORMATION");
		alertInfo.setHeaderText("정보");	// 메세지 제목
		alertInfo.setContentText("사용자에게 알려줄 내용"); // 출력할 메세지
		alertInfo.showAndWait(); // 출력 종류

		/* --------------------------------------------------------------------------------------------------------------- */
		Alert alertError = new Alert(AlertType.ERROR);
		alertError.setTitle("ERROR");
		alertError.setHeaderText("오류");
		alertError.setContentText("오류 내용 출력");
		alertError.showAndWait();

		/* --------------------------------------------------------------------------------------------------------------- */
		Alert alertWarning = new Alert(AlertType.WARNING);
		alertWarning.setTitle("WARNING");
		alertWarning.setHeaderText("경고");
		alertWarning.setContentText("경고 메세지 출력");
		alertWarning.showAndWait();

		/* --------------------------------------------------------------------------------------------------------------- */
		Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
		alertConfirm.setTitle("CONFIRMATION");
		alertConfirm.setHeaderText("선택");
		alertConfirm.setContentText("당신은 남자입니까?");
		ButtonType confirmResult = alertConfirm.showAndWait().get(); // Alert 창을 보여주고 사용자가 누른 버튼 값 읽어오기
		if(confirmResult == ButtonType.OK ) {
			System.out.println("OK 버튼이 눌렸습니다.");
		}else if (confirmResult == ButtonType.CANCEL) {
			System.out.println("취소 버튼이 눌렸습니다.");
		}else {
			System.out.println("...");
		}

		/* --------------------------------------------------------------------------------------------------------------- */
		// 자바스크립트의 prompt() 창과 같은 기능
		TextInputDialog prompt = new TextInputDialog("기본값"); // 기본값은 생략가능
		prompt.setTitle("값입력창");
		prompt.setHeaderText("이름을 입력하세요");

		// 창을 보여주고 사용자가 입력한 값 구하기
		Optional<String> result =  prompt.showAndWait();
		String strResult ="";
		if(result.isPresent()) { 		// 값이 있으면 실행..
			strResult = result.get(); 	//값 꺼내오기
			System.out.println("입력 값 : " + strResult);
		}else {
			System.out.println("취소 되었습니다.");
		}

	}
	public static void main(String[] args) {
		launch(args);
	}
}
