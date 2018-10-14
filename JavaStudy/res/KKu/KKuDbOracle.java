package KKu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class KKuDbOracle {
    /* ResourceBundle을 이용하여 properties 파일 읽어 오기 */
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources/db");

    private KKuDbOracle() { //생성자를 이용한 Driver 로드 시키기
        try {
            Class.forName(bundle.getString("driver"));
        }   catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException:" + cnfe);
        }
    }

    /**
     * ResurceBundle Test Main
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Enumeration enumer = bundle.getKeys();
        while (enumer.hasMoreElements()) {
            String name = (String) enumer.nextElement();
            String value = bundle.getString(name);
            System.out.println(name + " : " + value);
        }
        System.out.println();
    } // main

    /**
     * Connection oracle connection.
     *
     * @return the connection
     */
    public static Connection connectionOracle() {
        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String name = "kuinsoo";
        String password = "0728";

        try {
            conn = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            System.out.println("conn is null");
            System.out.println("Connection : " + e);
        }
        return conn;
    }

} // KKuDbOracle
