package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MemSignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tf_mem_zip;

    @FXML
    private TextField tf_mem_mail;

    @FXML
    private TextField tf_mem_like;

    @FXML
    private TextField tf_mem_delete;

    @FXML
    private TextField tf_mem_memorialdate;

    @FXML
    private Button btnOk;

    @FXML
    private TextField tf_mem_comtel;

    @FXML
    private TextField tf_mem_memorial;

    @FXML
    private TextField tf_mem_hometel;

    @FXML
    private TextField tf_mem_regno;

    @FXML
    private TextField tf_mem_job;

    @FXML
    private TextField tf_mem_name;

    @FXML
    private TextField tf_mem_addr;

    @FXML
    private TextField tf_mem_mileage;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField tf_mem_hp;

    @FXML
    private TextField tf_mem_bir;

    @FXML
    private TextField ft_mem_pass;

    @FXML
    private TextField tf_mem_id;

    @FXML
    void signUp(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert tf_mem_zip != null : "fx:id=\"tf_mem_zip\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_mail != null : "fx:id=\"tf_mem_mail\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_like != null : "fx:id=\"tf_mem_like\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_delete != null : "fx:id=\"tf_mem_delete\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_memorialdate != null : "fx:id=\"tf_mem_memorialdate\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_comtel != null : "fx:id=\"tf_mem_comtel\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_memorial != null : "fx:id=\"tf_mem_memorial\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_hometel != null : "fx:id=\"tf_mem_hometel\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_regno != null : "fx:id=\"tf_mem_regno\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_job != null : "fx:id=\"tf_mem_job\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_name != null : "fx:id=\"tf_mem_name\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_addr != null : "fx:id=\"tf_mem_addr\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_mileage != null : "fx:id=\"tf_mem_mileage\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_hp != null : "fx:id=\"tf_mem_hp\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_bir != null : "fx:id=\"tf_mem_bir\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert ft_mem_pass != null : "fx:id=\"ft_mem_pass\" was not injected: check your FXML file 'memSignup.fxml'.";
        assert tf_mem_id != null : "fx:id=\"tf_mem_id\" was not injected: check your FXML file 'memSignup.fxml'.";


    }
}
