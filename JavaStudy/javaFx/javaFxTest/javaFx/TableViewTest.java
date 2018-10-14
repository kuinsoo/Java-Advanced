package javaFx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TableViewTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		ObservableList<Member> data = FXCollections.observableArrayList(
				new Member("홍길동","gildong", 30, "010-1234-5678","대전"),
				new Member("홍길북","gilbook", 30, "010-1234-5678","서울"),
				new Member("홍길서","gilseo", 30, "010-1234-5678","인천"),
				new Member("홍길남","gilnam", 30, "010-1234-5678","제주도"));

		BorderPane root = new BorderPane();

		TableView<Member> table = new TableView<Member>(data); // 선택 1
//		tableView.setItems(data); // 선택 2

		/* 각 컬럼 설정하기 */
		TableColumn<Member, String> nameCol 	= new TableColumn<Member, String>("이름"); 	// < 객체,  선택된 Type >("제목");
		TableColumn<Member, String> koreNameCol = new TableColumn<Member, String>("한글");
		TableColumn<Member, String> engNameCol = new TableColumn<Member, String>("영문");

		/* 컬럼에 출력될 데이터 설정 *VO클래스의 멤버변수와 컬럼을 연결한다 */
		koreNameCol.setCellValueFactory(new PropertyValueFactory<Member,String>("korName"));
		engNameCol.setCellValueFactory(new PropertyValueFactory<Member,String>("engName"));
		nameCol.getColumns().addAll(koreNameCol,engNameCol);

		TableColumn<Member, Integer> ageCol = new TableColumn<Member, Integer>("나이");
		ageCol.setCellValueFactory(new PropertyValueFactory<Member,Integer>("age"));

		TableColumn<Member, Integer> telCol = new TableColumn<Member, Integer>("전화번호");
		telCol.setCellValueFactory(new PropertyValueFactory<Member,Integer>("tel"));

		TableColumn<Member, Integer> addrCol = new TableColumn<Member, Integer>("주소");
		addrCol.setCellValueFactory(new PropertyValueFactory<Member,Integer>("addr"));
		addrCol.setPrefWidth(100);

		// 만들어진 각 컬럼들을 TalbeView 에 추가해준다.
		table.getColumns().addAll(nameCol,ageCol,telCol,addrCol);

		GridPane grid = new GridPane();
		Text text1 = new Text("한글이름");
		Text text2 = new Text("영문이름");
		Text text3 = new Text("나　　이");
		Text text4 = new Text("전화번호");
		Text text5 = new Text("주　　소");

		TextField tfKorName = new TextField();
		TextField tfEngName = new TextField();
		TextField tfAge 	= new TextField();
		TextField tfTel 	= new TextField();
		TextField tfAddr 	= new TextField();

		grid.add(text1, 1, 1);
		grid.add(text2, 2, 1);
		grid.add(text3, 3, 1);
		grid.add(text4, 4, 1);
		grid.add(text5, 5, 1);

		grid.add(tfKorName	, 1, 2);
		grid.add(tfEngName	, 2, 2);
		grid.add(tfAge 		, 3, 2);
		grid.add(tfTel 		, 4, 2);
		grid.add(tfAddr 	, 5, 2);

		grid.setVgap(10);
		grid.setHgap(10);

		/* TableView 를 클릭했을 때 처리 */
		table.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				/* TableView에서 선택된 객체 구하기 */
				Member mem = table.getSelectionModel().getSelectedItem();
				if(mem!=null){
				tfKorName	.setText(mem.getKorName());
				tfEngName	.setText(mem.getEngName());
				tfAge 		.setText(String.valueOf("" + mem.getAge()));
				tfTel 		.setText(mem.getTel());
				tfAddr 		.setText(mem.getAddr());


			}
            }
		});


        /* 버튼 액션 */
        Button btnAdd   = new Button("추가");

        btnAdd.setOnAction(event -> {
            if(tfKorName.getText().isEmpty() ||
                tfEngName.getText().isEmpty() ||
                tfAge.getText().isEmpty() ||
                tfTel.getText().isEmpty() ||
                tfAddr.getText().isEmpty()) {
                errorAlert("입력오류","빈 항목이 있습니다.");
            }
            data.add(new Member(
            tfKorName.getText(),
            tfEngName.getText(),
            Integer.parseInt(tfAge.getText()),
            tfTel.getText(),
            tfAddr.getText()));

            infomationAlert("작업결과",tfKorName.getText() + "입니다");
            tfKorName.clear();
            tfEngName.clear();
            tfAge.clear();
            tfTel.clear();
            tfAddr.clear();
        });

        /* ButtonEdit Action */
        Button btnEdit  = new Button("수정");
        btnEdit.setOnAction(event -> {
            if(table.getSelectionModel().isEmpty()) {
                errorAlert("수정작업류", "수정할 데이터를 선택한 후 사용하세요");
                return;
            }

            /* Error 검사 */
            if(tfKorName.getText().isEmpty() ||
                tfEngName.getText().isEmpty() ||
                tfAge.getText().isEmpty() ||
                tfTel.getText().isEmpty() ||
                tfAddr.getText().isEmpty()) {
                errorAlert("입력오류","빈 항목이 있습니다.");
            }

            data.set(table.getSelectionModel().getSelectedIndex(), //선택된 데이터의 index 번호를 구해온다.
                new Member(
                    tfKorName.getText(),
                    tfEngName.getText(),
                    Integer.parseInt(tfAge.getText()),
                    tfTel.getText(),
                    tfAddr.getText()));
            infomationAlert("작업결과", tfKorName.getText() + "시 정보를 수정했습니다.");

            tfKorName.clear();
            tfEngName.clear();
            tfAge.clear();
            tfTel.clear();
            tfAddr.clear();
        });

        /* Button Delete action */
        Button btnDel   = new Button("삭제");
        btnDel.setOnAction(event -> {
            // Selected index
            if(table.getSelectionModel().isEmpty()){
                errorAlert("삭제작업오류", "삭제할 데이터를 선택한 후 사용하세요");
                return;
            }

            // 삭제될 사람의 이름 구하기
            String name = table.getSelectionModel().getSelectedItem().getKorName();
            data.remove((table.getSelectionModel().getSelectedIndex()));
            infomationAlert("작업결과",name + "씨 정보가 삭제 되었습니다.");

            /* Unlock Selection */
            table.getSelectionModel().select(null);

            tfKorName.clear();
            tfEngName.clear();
            tfAge.clear();
            tfTel.clear();
            tfAddr.clear();

        });
        /* 읽기 전용 설정 */
        tfKorName.setEditable(false); // 읽기전용 false  , 쓰기가능 true

        VBox    vBox    = new VBox(10);
        vBox.setPadding(new Insets(10));

        vBox.getChildren().addAll(btnAdd,btnEdit,btnDel);


		/* - - - - - - - -출력 -- - - - - - - - - - -- - - */
		root.setCenter(table);
		root.setBottom(grid);
		root.setMaxSize(600, 400);
        root.setRight(vBox);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TableView 연습");
		primaryStage.show();
	}



	public static void main(String[] args) {
		launch(args);
	}

	/* ..... Alert Functions ..... */
	public void errorAlert(String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(header);
        alert.setContentText(msg);

        alert.show();
    }
    public void infomationAlert(String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText(header);
        alert.setContentText(msg);

        alert.show();
    }
    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	// 사용할 데이터 Class 정의 - VO 역활 수행
	public class Member {
		private String korName;
		private String engName;
		private int age;
		private String tel;
		private String addr;

		/*기본 생성자*/
		public Member() {
			super();
		}

		/*초기화 생성자*/
		public Member(String korName, String engName, int age, String tel, String addr) {
			super();
			this.korName = korName;
			this.engName = engName;
			this.age = age;
			this.tel = tel;
			this.addr = addr;
		}

		/* getter & setter */
		public String getKorName() {
			return korName;
		}

		public void setKorName(String korName) {
			this.korName = korName;
		}

		public String getEngName() {
			return engName;
		}

		public void setEngName(String engName) {
			this.engName = engName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}


	}
}
