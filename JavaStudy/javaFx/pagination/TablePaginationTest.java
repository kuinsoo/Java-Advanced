import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.List;

public class TablePaginationTest extends Application {
    /* paging 전체 데이터갯수를 알아야 한다. */
    // 전체 데이터 개수 (DB에서 데이터 개수를 구해온다)
    private int dataSize        = 123;
    private int rowsPerPage     = 10; // 한 화면 레코드 수
    private TableView<SampleVO> tableView;
    private List<SampleVO>      dataList;

    private List<SampleVO> data = createData(); // DB 데이터를 저장

    private Pagination pagination; // 페이징 처리를 담당하는 컨트롤 객체 변수

    // 연습용 데이터를 만들어 주는 메서드
    public List<SampleVO> createData() {
        List<SampleVO> sampleVOS = new ArrayList<>();
        for (int i = 0; i < dataSize; i++) {
            sampleVOS.add(new SampleVO(i, "foo" + i, "bar" + i));
        }
        return sampleVOS;
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        tableView = new TableView<>();
        TableColumn<SampleVO, Integer> numCol = new TableColumn<>("번호");
        numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
        numCol.setPrefWidth(150);

        TableColumn<SampleVO, String> fooCol = new TableColumn<>("FOO");
        fooCol.setCellValueFactory(new PropertyValueFactory<>("foo"));
        fooCol.setPrefWidth(250);

        TableColumn<SampleVO, String> barCol = new TableColumn<>("BAR");
        barCol.setCellValueFactory(new PropertyValueFactory<>("bar"));
        barCol.setPrefWidth(250);

        tableView.getColumns().addAll(numCol, fooCol, barCol);
        tableView.setItems(FXCollections.observableArrayList(data));
        // ----------------------------------------------------------

        /* 전체 페이지수와 처음 보여줄 인덱스 값으로 초기화한다. */
        int totalPage = (data.size() / rowsPerPage)+ (data.size()%rowsPerPage > 0 ? 1: 0 );

        /* 방법 1
        pagination = new Pagination(totalPage, 0); // 첫페이지를 보여주게 만든다.
        */

        /* 방법2 */
        pagination = new Pagination(totalPage);
        pagination.setCurrentPageIndex(0);

        changeTableView(0); // 첫번째 페이지가 보이도록 한다.

        /* Pagination 객체의 현재 인덱스값이 변경되면 처리되는 이벤트 */
        pagination.currentPageIndexProperty().addListener(
            new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    changeTableView(newValue.intValue());
                }
            }
        );

        BorderPane root = new BorderPane();
        root.setCenter(tableView);
        root.setBottom(pagination);

        Scene scene = new Scene(root, 1024, 768);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pagination");
        primaryStage.show();
    }

    /* 매개변수로 페이지 인덱스값을 받아서 데이터가 저장된 리스트에서 해당 페이지에 출력할 데이터를
     * 구해서 TAbleView를 변경한다. */
    public void changeTableView(int index) {
        int fromIndex = index * rowsPerPage;
        int toIndex = Math.min(fromIndex + rowsPerPage ,data.size()); // Math.min ( a, b) 중에 작은 값을 불러온다.

        // data.subList(fromIndex, toIndex); // 10, 20  (10~19)까지 입력
        tableView.setItems(FXCollections.observableArrayList(data.subList(fromIndex, toIndex)));
    }

    public class SampleVO {
        private int num;
        private String foo;
        private String bar;

        public SampleVO() {
        }

        public SampleVO(int num, String foo, String bar) {
            this.num = num;
            this.foo = foo;
            this.bar = bar;
        }

        @Override
        public String toString() {
            return "SampleVO{" +
                "num=" + num +
                ", foo='" + foo + '\'' +
                ", bar='" + bar + '\'' +
                '}';
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getFoo() {
            return foo;
        }

        public void setFoo(String foo) {
            this.foo = foo;
        }

        public String getBar() {
            return bar;
        }

        public void setBar(String bar) {
            this.bar = bar;
        }
    }
}
