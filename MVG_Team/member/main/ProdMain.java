package member.main;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import member.service.IProdService;
import member.service.ProdService;
import member.vo.ProdVo;


public class ProdMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("House.fxml"));
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("테스트 물품");
			primaryStage.show();



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

//        IProdService service = ProdService.getInstance();
//        List<ProdVo> listProd = null;
//
//        listProd = service.getAllProd();
//        System.out.println(listProd);
//        for (ProdVo prodVo:
//             listProd) {
//            System.out.println(prodVo.getProd_code());
//            System.out.println(prodVo.getProd_name());
//            System.out.println(prodVo.getProd_div());
//            System.out.println(prodVo.getProd_qty());
//            System.out.println(prodVo.getProd_price());
//        }

	}
}
