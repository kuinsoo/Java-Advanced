package member.main;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import layout.service.HouseService;
import layout.service.IHouseService;
import layout.vo.HouseVO;

import java.net.URL;
import java.util.ResourceBundle;

public class HouseController {
	IHouseService service = HouseService.getInstance();
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView logOut;

	@FXML
	private ImageView exit;

	@FXML
	private Tab material;

	@FXML
	private ComboBox<String> classificationM;
	
	@FXML
	private TextField tfSearchM;

	@FXML
	private Button btnSearchM;

	@FXML
	private TableView<HouseVO> tbM;

	@FXML
	private Tab inOutBound;

	@FXML
	private ComboBox<String> classificationI;

	@FXML
	private TextField tfSearchI;

	@FXML
	private Button btnSearchI;
	
	@FXML
	private TableColumn<?,?> checkCol;
	
	@FXML
	private TableColumn<HouseVO, String> houseNameCol;
	
	 @FXML
    private TableColumn<HouseVO, String> stockCol;

    @FXML
    private TableColumn<HouseVO, String> qtyCol;
    
    @FXML
    private TableColumn<HouseVO, String> LhouseCol;

    @FXML
    private TableColumn<HouseVO, String> BuyerCol;
    
    @FXML
    private TableColumn<HouseVO, String> houseCol;
    
    @FXML
    private TableColumn<HouseVO, String> standardCol;
    
	/**
	 *@Method Name : goSearchI
	 *@date : 2018. 9. 6.
	 *@author : pc02
	 *@Method 설명 : 입출고검색 버튼을 눌렀을 때 행위
	 *@param event
	 */
	@FXML
	void goSearchI(ActionEvent event) {

	}

	/**
	 *@Method Name : goSearchM
	 *@date : 2018. 9. 6.
	 *@author : pc02
	 *@Method 설명 : 자재검색 버튼을 눌렀을 때 행위
	 *@param event
	 */
	@FXML
	void goSearchM(ActionEvent event) {

	}

	/**
	 *@Method Name : goExit
	 *@date : 2018. 9. 6.
	 *@author : pc02
	 *@Method 설명 : 화면이 꺼집니다.
	 *@param event
	 */
	@FXML
	void goExit(MouseEvent event) {
		Platform.exit();
	}

	/**
	 *@Method Name : goLogOut
	 *@date : 2018. 9. 6.
	 *@author : pc02
	 *@Method 설명 : 창을 닫고, 로그인 화면으로 돌아갑니다
	 *@param event
	 */
	@FXML
	void goLogOut(MouseEvent event) {
		Platform.exit();

	}

	@FXML
	void initialize() {
		   assert houseNameCol != null : "fx:id=\"houseNameCol\" was not injected: check your FXML file 'House.fxml'.";
	        assert btnSearchM != null : "fx:id=\"btnSearchM\" was not injected: check your FXML file 'House.fxml'.";
	        assert stockCol != null : "fx:id=\"stockCol\" was not injected: check your FXML file 'House.fxml'.";
	        assert checkCol != null : "fx:id=\"checkCol\" was not injected: check your FXML file 'House.fxml'.";
	        assert qtyCol != null : "fx:id=\"qtyCol\" was not injected: check your FXML file 'House.fxml'.";
	        assert LhouseCol != null : "fx:id=\"LhouseCol\" was not injected: check your FXML file 'House.fxml'.";
	        assert BuyerCol != null : "fx:id=\"BuyerCol\" was not injected: check your FXML file 'House.fxml'.";
	        assert tfSearchI != null : "fx:id=\"tfSearchI\" was not injected: check your FXML file 'House.fxml'.";
	        assert btnSearchI != null : "fx:id=\"btnSearchI\" was not injected: check your FXML file 'House.fxml'.";
	        assert inOutBound != null : "fx:id=\"inOutBound\" was not injected: check your FXML file 'House.fxml'.";
	        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'House.fxml'.";
	        assert material != null : "fx:id=\"material\" was not injected: check your FXML file 'House.fxml'.";
	        assert tfSearchM != null : "fx:id=\"tfSearchM\" was not injected: check your FXML file 'House.fxml'.";
	        assert houseCol != null : "fx:id=\"houseCol\" was not injected: check your FXML file 'House.fxml'.";
	        assert classificationM != null : "fx:id=\"classificationM\" was not injected: check your FXML file 'House.fxml'.";
	        assert logOut != null : "fx:id=\"logOut\" was not injected: check your FXML file 'House.fxml'.";
	        assert tbM != null : "fx:id=\"tbM\" was not injected: check your FXML file 'House.fxml'.";
	        assert standardCol != null : "fx:id=\"standardCol\" was not injected: check your FXML file 'House.fxml'.";
	        assert classificationI != null : "fx:id=\"classificationI\" was not injected: check your FXML file 'House.fxml'.";
	        
	        //searchAll();




	}
	



}






















