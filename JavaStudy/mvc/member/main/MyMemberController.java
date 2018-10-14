package member.main;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import member.service.IMyMemberService;
import member.service.MyMemberService;
import member.vo.MyMemberVo;

public class MyMemberController {

    IMyMemberService service = MyMemberService.getInstance();
    Methods methods = new Methods();
    List<MyMemberVo> listMember = null;
    ObservableList<MyMemberVo> myList = null;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnOk;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnEdit;

    @FXML
    private TextField txtTel;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtId;

    @FXML
    private TableColumn<MyMemberVo, String> idCol;

    @FXML
    private Button btnAdd;

    @FXML
    private TableColumn<MyMemberVo, String> telCol;

    @FXML
    private BorderPane root;

    @FXML
    private TableColumn<MyMemberVo,String> nameCol;

    @FXML
    private TableColumn<MyMemberVo, String> addrCol;

    @FXML
    private TextField txtAddr;

    @FXML
    private TableView<MyMemberVo> table;


    @FXML
    private Button btnDel;


    /* 검색 트리거 */
    int isCheck = 0;

    /* TextFiled Clear Method */
    void tfClear(){

        txtId.clear();
        txtName.clear();
        txtTel.clear();
        txtAddr.clear();

    }


    void addTable() {
        myList.add(new MyMemberVo(
                txtId.getText(),
                txtName.getText(),
                txtTel.getText(),
                txtAddr.getText()));
    }

    void removeTable() {
        myList.remove((table.getSelectionModel().getSelectedIndex()));
    }

    void editTable() {
        myList.set(table.getSelectionModel().getSelectedIndex(),
                new MyMemberVo(
                        txtId.getText(),
                        txtName.getText(),
                        txtTel.getText(),
                        txtAddr.getText()));
    }

    /* 에러처리 메서드 */
    int alterError(Button btn) {
         if(txtId.getText().isEmpty()) {
             methods.alertError(txtId);
         }else if (txtName.getText().isEmpty()) {
             methods.alertError(txtName);
         }else if (txtTel.getText().isEmpty()) {
             methods.alertError(txtTel);
         }else if (txtAddr.getText().isEmpty()) {
             methods.alertError(txtAddr);
         }else {
             btn.setDisable(true);
             btnOk.setDisable(false);
             btnCancel.setDisable(false);
         }
         return 0;
     }

     void setDisiable() {
         btnAdd.setDisable(true);
         btnDel.setDisable(true);
         btnEdit.setDisable(true);

         btnOk.setDisable(false);
         btnCancel.setDisable(false);

         txtId.setEditable(true);
         txtName.setEditable(true);
         txtTel.setEditable(true);
         txtAddr.setEditable(true);

         table.setDisable(true);
     }

    @FXML
    void dataAdd(ActionEvent event) {
        alterError(btnAdd);
        isCheck = 1;
        setDisiable();
        System.out.println(isCheck);
    }

    @FXML
    void dataEdit(ActionEvent event) {
        alterError(btnEdit);
        isCheck = 2;
        btnAdd.setDisable(true);
        btnDel.setDisable(true);
        System.out.println(isCheck);
    }

    @FXML
    void dataDel(ActionEvent event) {
        alterError(btnDel);
        isCheck = 3;
        btnAdd.setDisable(true);
        btnEdit.setDisable(true);
        System.out.println(isCheck);
    }

    @FXML
    void dataRun(ActionEvent event) {
        MyMemberVo memVo = new MyMemberVo();
        int cnt = 0;
        switch(isCheck) {
            case 1:     // Insert
                memVo.setMem_id(txtId.getText());
                memVo.setMem_name(txtName.getText());
                memVo.setMem_tel(txtTel.getText());
                memVo.setMem_addr(txtAddr.getText());
                cnt = service.insertMember(memVo);
                if (cnt > 0) { methods.alertImformation("추가 완료"); }
                else { methods.alertImformation("추가 실패"); }
                btnAdd.setDisable(false);
                listMember = service.getAllMemberList();
                myList = FXCollections.observableArrayList(listMember);
                table.setItems(myList);
//              addTable();
                break;

            case 2:     // Update
                memVo = new MyMemberVo();
                memVo.setMem_id(txtId.getText());
                memVo.setMem_name(txtName.getText());
                memVo.setMem_tel(txtTel.getText());
                memVo.setMem_addr(txtAddr.getText());

                cnt = service.updateMember(memVo);
                if (cnt > 0) {methods.alertImformation("수정 완료");}
                else {methods.alertImformation("수정 실패");}
                btnEdit.setDisable(false);
                listMember = service.getAllMemberList();
                myList = FXCollections.observableArrayList(listMember);
                table.setItems(myList);
//              editTable();
                break;

            case 3:     // Delete
                cnt = service.delleteMember(txtId.getText());
                if (cnt > 0) {methods.alertImformation("삭제 완료");}
                else {methods.alertImformation("삭제 실패");}
                btnDel.setDisable(false);
                listMember = service.getAllMemberList();
                myList = FXCollections.observableArrayList(listMember);
                table.setItems(myList);
//              removeTable();
                break;
        }

        btnOk.setDisable(true);
        btnCancel.setDisable(true);
        btnAdd.setDisable(false);
        btnEdit.setDisable(false);
        btnDel.setDisable(false);
        isCheck= 0;
        tfClear();
    }

    @FXML
    void dataCancel(ActionEvent event) {
        btnOk.setDisable(true);
        btnCancel.setDisable(true);
        btnAdd.setDisable(false);
        btnEdit.setDisable(false);
        btnDel.setDisable(false);
        tfClear();
    }

    @FXML
    void initialize() {
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert txtTel != null : "fx:id=\"txtTel\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert idCol != null : "fx:id=\"idCol\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert telCol != null : "fx:id=\"telCol\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert addrCol != null : "fx:id=\"addrCol\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert txtAddr != null : "fx:id=\"txtAddr\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert btnDel != null : "fx:id=\"btnDel\" was not injected: check your FXML file 'MyMember.fxml'.";

        listMember = service.getAllMemberList();
        myList = FXCollections.observableArrayList(listMember);

        table.setItems(myList);
        idCol.setCellValueFactory   (new PropertyValueFactory<MyMemberVo,String>("mem_id"   ));
        nameCol.setCellValueFactory (new PropertyValueFactory<MyMemberVo,String>("mem_name" ));
        telCol.setCellValueFactory  (new PropertyValueFactory<MyMemberVo,String>("mem_tel"  ));
        addrCol.setCellValueFactory (new PropertyValueFactory<MyMemberVo,String>("mem_addr" ));

        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MyMemberVo memVo = table.getSelectionModel().getSelectedItem();
                if(memVo != null){
                    txtId   .setText(memVo.getMem_id());
                    txtName .setText(memVo.getMem_name());
                    txtTel  .setText(memVo.getMem_tel());
                    txtAddr .setText(memVo.getMem_addr());
                }
            }
        });
    }
}
