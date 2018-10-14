import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ObservableList<PieChart.Data> pieChartDate = FXCollections.observableArrayList(
          new PieChart.Data("이쑨쉰", 87),
          new PieChart.Data("이쑨쉰", 83),
          new PieChart.Data("성추행", 20),
          new PieChart.Data("이몰골", 58),
          new PieChart.Data("변했또", 48),
          new PieChart.Data("강감자", 34)
        );

        PieChart pieChart = new PieChart(pieChartDate);
        pieChart.setTitle("성적 그래프");
        pieChart.setLabelLineLength(10); //값 영역과 레이브르 사이의 선 길이
        pieChart.setLegendSide(Side.LEFT); // 범례 위치

        Scene scene = new Scene(pieChart);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setTitle("PieChart");
        primaryStage.show();
    }
}
