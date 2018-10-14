package main;

import dao.IMemLoginDao;
import dao.MemLoginDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.IMemLoginService;
import service.MemLoginService;
import vo.MemVo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class MemMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("memLogin.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Test회원정보");
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }




    /* 콘솔 출력
    IMemLoginService service = MemLoginService.getInstance();

    public static void main(String[] args) {
        new MemMain().start();
    }

    public void start(){
        Map<String, String> map = new HashMap<>();
        map.put("m001", "pass");
        MemVo memVo = new MemVo();
        memVo = service.login(map);

        System.out.println(memVo.getMem_name());
    }
    */

}
