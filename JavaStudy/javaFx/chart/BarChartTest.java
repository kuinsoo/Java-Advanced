import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        /* X축, Y축 객체 만들기 */
        CategoryAxis xAxis  = new CategoryAxis(); // X축 객체
        NumberAxis yAxis    = new NumberAxis(); // y축 객체

        /* Create a BarChart object. */
        BarChart<String, Number> barChart = new BarChart<>(xAxis,yAxis);
        xAxis.setLabel("국가명"); // xAxis title
        yAxis.setLabel("수출액"); // yAxis title

        barChart.setTitle("나라별 수출액 현황");  // chart title

        //데이터 셋팅하기
        XYChart.Series ser1 = new XYChart.Series<>();
        ser1.setName("2016년");
        ser1.getData().add(new XYChart.Data<>("호주", 200.3));
        ser1.getData().add(new XYChart.Data<>("미국", 1234.3));
        ser1.getData().add(new XYChart.Data<>("프랑스", 1234.3));
        ser1.getData().add(new XYChart.Data<>("영국", 1234.3));

        XYChart.Series ser2 = new XYChart.Series<>();
        ser2.setName("2017년");
        ser2.getData().add(new XYChart.Data<>("호주", 334.3));
        ser2.getData().add(new XYChart.Data<>("미국", 3234.3));
        ser2.getData().add(new XYChart.Data<>("프랑스", 3234.3));
        ser2.getData().add(new XYChart.Data<>("영국", 3234.3));

        XYChart.Series ser3 = new XYChart.Series<>();
        ser3.setName("2018년");
        ser3.getData().add(new XYChart.Data<>("호주", 2234.3));
        ser3.getData().add(new XYChart.Data<>("미국", 2234.3));
        ser3.getData().add(new XYChart.Data<>("프랑스", 2234.3));
        ser3.getData().add(new XYChart.Data<>("영국", 4234.3));

        barChart.getData().addAll(ser1, ser2,ser3);
        Scene scene = new Scene(barChart);
        primaryStage.setScene(scene);
        primaryStage.setTitle("");
        primaryStage.show();
    }
}
