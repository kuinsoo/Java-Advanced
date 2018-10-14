import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root =  new BorderPane();
        Scene scene = new Scene(root, 300, 250);

        MenuBar menuBar = new MenuBar();
        // 메뉴바의 가로 크기를 항상 Stage의 가로크기와 같도록 한다.
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);
        // File menu Menu-- new, save, exit
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(event -> {
            Platform.exit();
        });
        fileMenu.getItems().addAll(newMenuItem, saveMenuItem, exitMenuItem);

        // Checked menu
        Menu webMenu = new Menu("Web");
        CheckMenuItem htmlMenuItem = new CheckMenuItem("HTML");
        CheckMenuItem cssMenuItem = new CheckMenuItem("CSS");
        htmlMenuItem.setSelected(true);
        webMenu.getItems().addAll(htmlMenuItem, cssMenuItem);

        // Radio Button
        Menu sqlMenu = new Menu("SQL");
        ToggleGroup toggleGroup = new ToggleGroup(); // 그룹을 만들어준다.
        RadioMenuItem mysqlMenuItem = new RadioMenuItem("MySQL");
        mysqlMenuItem.setToggleGroup(toggleGroup); // ToggleGroup 에 넣어 준다.
        RadioMenuItem oracleMenuItem = new RadioMenuItem("Oracle");
        oracleMenuItem.setToggleGroup(toggleGroup);// ToggleGroup 에 넣어 준다.

        // Branch
        Menu tutorialMenu = new Menu("Tutorial");
        tutorialMenu.getItems().addAll(
            new CheckMenuItem("JAVA 기초"),
            new CheckMenuItem("JAVA 고급"),
            new CheckMenuItem("DB"),
            new CheckMenuItem("JavaScript")
        );

        sqlMenu.getItems().addAll(mysqlMenuItem, oracleMenuItem,new SeparatorMenuItem(),tutorialMenu);

        menuBar.getMenus().addAll(fileMenu,webMenu, sqlMenu);

        primaryStage.setScene(scene);
        primaryStage.setTitle("메뉴 만들기 연습");
        primaryStage.show();
    }
}
