package member.main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;
import member.dao.IProdDao;
import member.dao.ProdDao;
import member.service.IProdService;
import member.service.ProdService;
import member.vo.ProdVo;

public class ProdController {
    private IProdService service = ProdService.getInstance();
    private List<ProdVo> listProdVo ;
    private ObservableList<ProdVo> observableList ;
    private int rowPerPage = 10;
    private int totalPage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<ProdVo, String> col_code;

    @FXML
    private TextField tf_search;

    @FXML
    private TableColumn<ProdVo, String> col_div;

    @FXML
    private Button btnSearch;

    @FXML
    private TableColumn<ProdVo, Integer> col_qty;

    @FXML
    private TableView<ProdVo> tv_main;

    @FXML
    private TableColumn<ProdVo, String> col_name;

    @FXML
    private TableColumn<ProdVo, Integer> col_price;

    @FXML
    private ListView<?> list;
    @FXML
    private Pagination pagination;

    @FXML
    private BorderPane root;


    @FXML
    void searchProd(ActionEvent event) {
        if(tf_search.getText().equals("") || tf_search.getText().isEmpty()) {
            searchAllProd();
        } else {
            searchForProd();
        }
    }

    @FXML
    void onClickEvent(MouseEvent event) { //마우스이벤트 설정
        newWindowModal(tv_main.getSelectionModel().getSelectedItem());

        /* 각자 받아 오는 값이 다른다. */
        tv_main.getSelectionModel().getFocusedIndex();
        tv_main.getSelectionModel().getSelectedCells();
        tv_main.getSelectionModel().getSelectedItem();
        tv_main.getSelectionModel().getSelectedItems();

    }

    @FXML
    void searchText(javafx.scene.input.KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            searchProd(null);
        }
    }

    @FXML
    void initialize() {
        assert col_code != null : "fx:id=\"col_code\" was not injected: check your FXML file 'Prod.fxml'.";
        assert tf_search != null : "fx:id=\"tf_search\" was not injected: check your FXML file 'Prod.fxml'.";
        assert col_div != null : "fx:id=\"col_div\" was not injected: check your FXML file 'Prod.fxml'.";
        assert btnSearch != null : "fx:id=\"btnSearch\" was not injected: check your FXML file 'Prod.fxml'.";
        assert col_qty != null : "fx:id=\"col_qty\" was not injected: check your FXML file 'Prod.fxml'.";
        assert tv_main != null : "fx:id=\"tv_main\" was not injected: check your FXML file 'Prod.fxml'.";
        assert col_name != null : "fx:id=\"col_name\" was not injected: check your FXML file 'Prod.fxml'.";
        assert col_price != null : "fx:id=\"col_price\" was not injected: check your FXML file 'Prod.fxml'.";
        assert list != null : "fx:id=\"list\" was not injected: check your FXML file 'Prod.fxml'.";
        assert pagination != null : "fx:id=\"pagination\" was not injected: check your FXML file 'Prod.fxml'.";
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'Prod.fxml'.";

        /*시작*/
        searchAllProd();

    }
    /*pagination*/
    public void changeTableView(int index) {
        int fromIndex = index * rowPerPage;
        int toIndex = Math.min(fromIndex + rowPerPage, listProdVo.size());

        tv_main.setItems(FXCollections.observableArrayList(listProdVo.subList(fromIndex, toIndex)));
    }

    /*searchAll SQL*/
    public void searchAllProd() {
        listProdVo = service.getAllProd();
        observableList = FXCollections.observableArrayList(listProdVo);
        /*pagination totalPage*/
        int totalPage = (listProdVo.size() / rowPerPage) + (listProdVo.size() % rowPerPage > 0 ? 1 : 0);


        tv_main.setItems(observableList);
        col_code.setCellValueFactory(new PropertyValueFactory<ProdVo, String>("prod_code"));
        col_name.setCellValueFactory(new PropertyValueFactory<ProdVo, String>("prod_name"));
        col_div.setCellValueFactory(new PropertyValueFactory<ProdVo, String>("prod_div"));
        col_qty.setCellValueFactory(new PropertyValueFactory<ProdVo, Integer>("prod_qty"));
        col_price.setCellValueFactory(new PropertyValueFactory<ProdVo, Integer>("prod_price"));

        /* 전체 페이지수와 처음 보여줄 인덱스 값으로 초기화 한다. */
        pagination = new Pagination(totalPage);
        pagination.setCurrentPageIndex(0);

        pagination.currentPageIndexProperty().addListener(
            new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    changeTableView(newValue.intValue());
                }
            }
        );
        changeTableView(0);
        root.setBottom(pagination);
    }

    /*searchSQL*/
    public void searchForProd(){
        List<ProdVo> listProdVo = service.getAllProd2(tf_search.getText());
        ObservableList<ProdVo> observableList = FXCollections.observableArrayList(listProdVo);
        int totalPage = (listProdVo.size() / rowPerPage) + (listProdVo.size() % rowPerPage > 0 ? 1 : 0);
        pagination = new Pagination(totalPage);
        pagination.setCurrentPageIndex(0);

        pagination.currentPageIndexProperty().addListener(
            new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    changeTableView(newValue.intValue());
                    int fromIndex = newValue.intValue() * rowPerPage;
                    int toIndex = Math.min(fromIndex + rowPerPage, listProdVo.size());
                    tv_main.setItems(FXCollections.observableArrayList(listProdVo.subList(fromIndex, toIndex)));
                }
            }
        );
        changeTableView(0);
        root.setBottom(pagination);
        tv_main.setItems(observableList);
    }

    /*windowModal*/
    public void newWindowModal(ProdVo prodVo){
        Stage primaryStage = (Stage)tv_main.getScene().getWindow();

        Stage dialogWIN = new Stage();
        dialogWIN.initModality(Modality.WINDOW_MODAL);
        dialogWIN.initOwner(primaryStage);
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("test.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene sceneWIN = new Scene(root);
        dialogWIN.setScene(sceneWIN);
        dialogWIN.setTitle(prodVo.getProd_name());
        dialogWIN.showAndWait();
    }
}
