package zip.client;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import zip.service.ZipSearchServiceInf;
import zip.vo.ZipVO;

public class ZipSearchMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbSelect;

    @FXML
    private TextField tfBox;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<ZipVO> zipTable;

    @FXML
    private TableColumn<?, ?> zipCol;

    @FXML
    private TableColumn<?, ?> sidoCol;

    @FXML
    private TableColumn<?, ?> gugunCol;

    @FXML
    private TableColumn<?, ?> dongCol;

    @FXML
    private TableColumn<?, ?> riCol;

    @FXML
    private TableColumn<?, ?> bldgCol;

    @FXML
    private TableColumn<?, ?> bunjiCol;

    // 검색 버튼을 클릭했을 때 이벤트 처리
    public void zipSearch(ActionEvent event) {
    	if(tfBox.getText().isEmpty()) {
    		alert("검색할 값을 입력하세요.");
    		return;
    	}
    	
    	String searchData = tfBox.getText();
    	
    	List<ZipVO> result = null;
    	
    	//콤보박스의 선택 항목을 구분해서 검색처리
    	try {
    		if(cmbSelect.getValue().equals("동이름")) {
    			result = service.zipSearchDong(searchData);
    		}else if(cmbSelect.getValue().equals("우편번호")) {
    			result = service.zipSearchZipCode(searchData);
    		}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    	
    	//검색된 결과를 TableView에서 사용하는 List에 넣어주기
    	zipList.clear();
    	zipList.addAll(result);
    	
    	
    }
    
    ZipSearchServiceInf service;	//서버의 Service 객체가 저장될 변수

    ObservableList<ZipVO> zipList = FXCollections.observableArrayList();
    
    @FXML
    void initialize() {
        assert cmbSelect != null : "fx:id=\"cmbSelect\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert tfBox != null : "fx:id=\"tfBox\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert btnSearch != null : "fx:id=\"btnSearch\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert zipTable != null : "fx:id=\"zipTable\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert zipCol != null : "fx:id=\"zipCol\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert sidoCol != null : "fx:id=\"sidoCol\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert gugunCol != null : "fx:id=\"gugunCol\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert dongCol != null : "fx:id=\"dongCol\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert riCol != null : "fx:id=\"riCol\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert bldgCol != null : "fx:id=\"bldgCol\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert bunjiCol != null : "fx:id=\"bunjiCol\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        
      
		btnSearch.setOnAction(event -> zipSearch(event));
        
        //서버의 서비스 객체 구하기
        
        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 9988);
			service = (ZipSearchServiceInf) reg.lookup("zipSearch");
			
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (NotBoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        
        cmbSelect.getItems().addAll("동이름", "우편번호");
        cmbSelect.setValue("동이름");
        
        //TableView의 컬럼들 설정
        zipCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        sidoCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        gugunCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        dongCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        riCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        bldgCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        bunjiCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        
        //TableView에 데이터 셋팅
        zipTable.setItems(zipList);

    }
    
    // alert 창
    public void alert(String msg) {
    	Alert alert = new Alert(AlertType.WARNING);
    	alert.setTitle("경고");
    	alert.setHeaderText("경고메세지");
    	alert.setContentText(msg);
    	alert.showAndWait();
    }
    
    // info 창
    public void info(String msg) {
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("확인");
    	alert.setHeaderText("확인메세지");
    	alert.setContentText(msg);
    	alert.showAndWait();
    	
    }
    
}
