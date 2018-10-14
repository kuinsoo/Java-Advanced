package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.IMyStudentService;
import service.MyStudentService;
import vo.MemVo;
import vo.MyStudenVo;

import javax.swing.text.Style;

public class MyStudentMainController {
    IMyStudentService service = MyStudentService.getInstance();
    List<MyStudenVo> myStudenVoList = new ArrayList<>();

    @FXML
    private TableColumn<MyStudenVo, Integer> colKor;

    @FXML
    private TableColumn<MyStudenVo, Integer> colEng;

    @FXML
    private TableColumn<MyStudenVo, String> colName;

    @FXML
    private Button pieBtn;

    @FXML
    private AnchorPane root;

    @FXML
    private Button bcBtn;

    @FXML
    private TableView<MyStudenVo> tvMain;

    @FXML
    private TableColumn<MyStudenVo, Integer> colMat;

    @FXML
    private Button addBtn;


    @FXML
    void tvMainAction(ActionEvent event) {

    }

    @FXML
    void addAction(ActionEvent event) {
        Stage dialogWIN = new Stage();
        dialogWIN.initModality(Modality.WINDOW_MODAL);
        dialogWIN.initOwner(addBtn.getScene().getWindow());

        try {
            Parent rootAdd = FXMLLoader.load(getClass().getResource("insertMyStudent.fxml"));

            Scene scene = new Scene(rootAdd);
            dialogWIN.setScene(scene);
            dialogWIN.setTitle("회원가입");
            dialogWIN.showAndWait();

            myStudenVoList = service.allMyStuden();
            ObservableList<MyStudenVo> myStudenVoObservableList = FXCollections.observableList(myStudenVoList);
            tvMain.setItems(myStudenVoObservableList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    void barCharAction(ActionEvent event) {
        Stage stage = new Stage(StageStyle.UNIFIED);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(bcBtn.getScene().getWindow());

        CategoryAxis xAxis = new CategoryAxis(); //x축
        NumberAxis yAxis = new NumberAxis(); //y축

        /* 바차트 객체 */
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        xAxis.setLabel(colName.getText());
        yAxis.setLabel("점 수");

        barChart.setTitle("점수차트");

        /* 데이터 셋팅 */
        MyStudenVo myS = tvMain.getSelectionModel().getSelectedItem();
        XYChart.Series[] series = new XYChart.Series[]{
            new XYChart.Series(),
            new XYChart.Series(),
            new XYChart.Series()
        };
        series[0].setName("국어");
        series[0].getData().add(new XYChart.Data<>(myS.getStd_name(),myS.getStd_kor()));
        series[1].setName("영어");
        series[1].getData().add(new XYChart.Data<>(myS.getStd_name(),myS.getStd_eng()));
        series[2].setName("수학");
        series[2].getData().add(new XYChart.Data<>(myS.getStd_name(),myS.getStd_mat()));
        barChart.getData().addAll(series);
        Scene scene = new Scene(barChart);
        stage.setScene(scene);
        stage.setTitle("막대차트");
        stage.show();
        /*

//        System.out.println(tvMain.getColumns().get(1).getText());
        XYChart.Series[] series = new XYChart.Series[tvMain.getColumns().size()-1];
//        System.out.println(tvMain.getColumns().size());
//        System.out.println(tvMain.getColumns().get(0).getText());
        List<XYChart.Series> xyList = new ArrayList<>();

        series[0] = new XYChart.Series();
        series[0].setName("국어");
//        series[0].getData().add(new XYChart.Data<>("구인수",100));
//        series[0].getData().add(new XYChart.Data<>("유다영",200));
//        series[0].getData().add(new XYChart.Data<>("구길동",300));
//        series[0].getData().add(new XYChart.Data<>("나몰라",300));


        series[1] = new XYChart.Series();
        series[1].setName("영어");
//        series[1].getData().add(new XYChart.Data<>("구인수",100));
//        series[1].getData().add(new XYChart.Data<>("유다영",200));
//        series[1].getData().add(new XYChart.Data<>("구길동",300));
//        series[1].getData().add(new XYChart.Data<>("나몰라",300));

        series[2] = new XYChart.Series();
        series[2].setName("수학");
//        series[2].getData().add(new XYChart.Data<>("구인수",100));
//        series[2].getData().add(new XYChart.Data<>("유다영",200));
//        series[2].getData().add(new XYChart.Data<>("구길동",300));
//        series[2].getData().add(new XYChart.Data<>("나몰라",300));

        for (MyStudenVo vo : service.allMyStuden()
             ) {
            int i = 0;
            series[i++].getData().add(new XYChart.Data<>(vo.getStd_name(),vo.getStd_kor()));
            series[i++].getData().add(new XYChart.Data<>(vo.getStd_name(),vo.getStd_eng()));
            series[i++].getData().add(new XYChart.Data<>(vo.getStd_name(),vo.getStd_mat()));
        }

        barChart.getData().addAll(series);
        Scene scene = new Scene(barChart);
        stage.setScene(scene);
        stage.setTitle("막대차트");
        stage.show();
       */
    }

    @FXML
    void pieChartAction(ActionEvent event) {
        if(!tvMain.getSelectionModel().isEmpty()) {
            Stage stage = new Stage(StageStyle.UNIFIED);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(bcBtn.getScene().getWindow());
            MyStudenVo myS = tvMain.getSelectionModel().getSelectedItem();
            ObservableList<PieChart.Data> pieChartDate = FXCollections.observableArrayList();
            pieChartDate.add(new PieChart.Data(tvMain.getColumns().get(1).getText() + " : " + myS.getStd_kor(), myS.getStd_kor()));
            pieChartDate.add(new PieChart.Data(tvMain.getColumns().get(2).getText() + " : " + myS.getStd_eng(), myS.getStd_eng()));
            pieChartDate.add(new PieChart.Data(tvMain.getColumns().get(3).getText() + " : " + myS.getStd_mat(), myS.getStd_mat()));


            PieChart pieChart = new PieChart(pieChartDate);
            pieChart.setTitle("성적 그래프");
            pieChart.setLabelLineLength(10);

            pieChart.setLegendSide(Side.BOTTOM);

//        pieChart.setLegendVisible(false);

            Scene scene = new Scene(pieChart);
            stage.setScene(scene);
            stage.setTitle("막대차트");
            stage.show();
        } else {
            System.out.println("자료없음");
        }
    }



    @FXML
    void initialize() {
        assert colKor != null : "fx:id=\"colKor\" was not injected: check your FXML file 'myStudentMain.fxml'.";
        assert colEng != null : "fx:id=\"colEng\" was not injected: check your FXML file 'myStudentMain.fxml'.";
        assert colName != null : "fx:id=\"colName\" was not injected: check your FXML file 'myStudentMain.fxml'.";
        assert pieBtn != null : "fx:id=\"pieBtn\" was not injected: check your FXML file 'myStudentMain.fxml'.";
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'myStudentMain.fxml'.";
        assert bcBtn != null : "fx:id=\"bcBtn\" was not injected: check your FXML file 'myStudentMain.fxml'.";
        assert tvMain != null : "fx:id=\"tvMain\" was not injected: check your FXML file 'myStudentMain.fxml'.";
        assert colMat != null : "fx:id=\"colMat\" was not injected: check your FXML file 'myStudentMain.fxml'.";
        assert addBtn != null : "fx:id=\"addBtn\" was not injected: check your FXML file 'myStudentMain.fxml'.";

        myStudenVoList = service.allMyStuden();
//        for ( MyStudenVo myStudenVo: myStudenVoList
//             ) {
//            System.out.println(myStudenVo.getStd_name());
//            System.out.println(myStudenVo.getStd_kor());
//            System.out.println(myStudenVo.getStd_eng());
//            System.out.println(myStudenVo.getStd_mat());
//        }
        ObservableList<MyStudenVo> myStudenVoObservableList = FXCollections.observableList(myStudenVoList);

        tvMain.setItems(myStudenVoObservableList);

        colName.setCellValueFactory (new PropertyValueFactory<MyStudenVo, String>("std_name"));
        colKor.setCellValueFactory (new PropertyValueFactory<MyStudenVo, Integer>("std_kor"));
        colEng.setCellValueFactory (new PropertyValueFactory<MyStudenVo, Integer>("std_eng"));
        colMat.setCellValueFactory (new PropertyValueFactory<MyStudenVo, Integer>("std_mat"));

        tvMain.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });



    }
}
