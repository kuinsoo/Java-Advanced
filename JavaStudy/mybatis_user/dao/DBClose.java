/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBClose {
    public static void close(Connection conn, PreparedStatement pstmt) {

        try {

            if(pstmt!=null)	pstmt.close();

            if(conn!=null) conn.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }


    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {

        try {

            if(rs!=null) rs.close();

            if(pstmt!=null)	pstmt.close();

            if(conn!=null) conn.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
