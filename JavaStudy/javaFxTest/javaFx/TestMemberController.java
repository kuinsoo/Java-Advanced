package javaFx;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class TestMemberController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbl_pw;

    @FXML
    private Label lbl_login;

    @FXML
    private Label lbl_id;

    @FXML
    private VBox root;

    @FXML
    private HBox hbox3;

    @FXML
    private HBox hbox2;

    @FXML
    private TextField tfMem_pw;

    @FXML
    private HBox hbox1;

    @FXML
    private Button btn_clancle;

    @FXML
    private TextField tfMem_id;

    @FXML
    private Button btn_login;

    @FXML
    private TextArea taResult;

    @FXML
    void login(ActionEvent event) {
    	Connection	conn 		= null;
    	PreparedStatement pstmt = null;
    	Statement	stmt		= null;
    	ResultSet	rs			= null;
    	conn = KKu.KKuDbOracle.connectionOracle();

    	String sql = " select * from testmember ";


    	try {
    		stmt 	= conn.createStatement();
    		rs 		= stmt.executeQuery(sql);
    		while(rs.next()) {
    			rs.getString("tMem_id     ");
    			rs.getString("tMem_pw     ");
    			rs.getString("tMem_name   ");
    			rs.getInt	("tMem_tel1   ");
    			rs.getInt	("tMem_tel2   ");
    			rs.getInt	("tMem_tel3   ");
    			rs.getInt	("tMem_regno1 ");
    			rs.getInt	("tMem_regno2 ");
    			rs.getString("tMem_addr   ");

    		}
		}catch (SQLException e) {
    		System.out.println("SQLExeption :" + e);

		}catch (Exception e) {
			System.out.println("Exception :" + e);
		}
    	finally {
			try {
				if(rs		!= null) {rs.close();}
				if(stmt 	!= null) {stmt.close();}
				if(pstmt 	!= null) {pstmt.close();}
				if(conn 	!= null) {conn.close();}
			} catch (Exception e2) {
				System.out.println("close : " + e2);
			}
		}

    }

    @FXML
    void signup(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert lbl_pw != null : "fx:id=\"lbl_pw\" was not injected: check your FXML file 'testMember.fxml'.";
        assert lbl_login != null : "fx:id=\"lbl_login\" was not injected: check your FXML file 'testMember.fxml'.";
        assert lbl_id != null : "fx:id=\"lbl_id\" was not injected: check your FXML file 'testMember.fxml'.";
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'testMember.fxml'.";
        assert hbox3 != null : "fx:id=\"hbox3\" was not injected: check your FXML file 'testMember.fxml'.";
        assert hbox2 != null : "fx:id=\"hbox2\" was not injected: check your FXML file 'testMember.fxml'.";
        assert tfMem_pw != null : "fx:id=\"tfMem_pw\" was not injected: check your FXML file 'testMember.fxml'.";
        assert hbox1 != null : "fx:id=\"hbox1\" was not injected: check your FXML file 'testMember.fxml'.";
        assert btn_clancle != null : "fx:id=\"btn_clancle\" was not injected: check your FXML file 'testMember.fxml'.";
        assert tfMem_id != null : "fx:id=\"tfMem_id\" was not injected: check your FXML file 'testMember.fxml'.";
        assert btn_login != null : "fx:id=\"btn_login\" was not injected: check your FXML file 'testMember.fxml'.";
        assert taResult != null : "fx:id=\"taResult\" was not injected: check your FXML file 'testMember.fxml'.";

    }
}
