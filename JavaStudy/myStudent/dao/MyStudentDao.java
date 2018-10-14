package dao;


import vo.MyStudenVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyStudentDao implements IMyStudentDao {
    static private MyStudentDao myStudentDao ;
    private MyStudentDao(){  }
    public static MyStudentDao getInstance(){
        if(myStudentDao == null){
            myStudentDao = new MyStudentDao();
        }
        return myStudentDao;
    }
    private Connection connection;
    private Statement  statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public int insertMyStudent(MyStudenVo myStudenVo) {
            int count = 0 ;
            connection  = null;
            preparedStatement = null;
            resultSet = null;
            connection = KKu.KKuDbOracle.connectionOracle();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("insert into mystudent (std_name, std_kor, std_eng, std_mat) ");
            sql.append(" values (?,?,?,?) ");
            preparedStatement =  connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, myStudenVo.getStd_name());
            preparedStatement.setInt(2,myStudenVo.getStd_kor());
            preparedStatement.setInt(3,myStudenVo.getStd_eng());
            preparedStatement.setInt(4,myStudenVo.getStd_mat());

            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        endClose();
        return count;
    }

    @Override
    public int deleteMyStudent(String studentName) {
        return 0;
    }

    @Override
    public int updateMyStudent(MyStudenVo myStudenVo) {
        return 0;
    }

    @Override
    public List<MyStudenVo> allMyStuden() {
            List<MyStudenVo>myStudenVoList = new ArrayList<>();
        try {
            connection = KKu.KKuDbOracle.connectionOracle();
            statement = connection.createStatement();
            String sql = " select * from MyStudent ";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                MyStudenVo myStudenVo = new MyStudenVo();
                myStudenVo.setStd_name(resultSet.getString("std_name"));
                myStudenVo.setStd_kor(resultSet.getInt("std_kor"));
                myStudenVo.setStd_eng(resultSet.getInt("std_eng"));
                myStudenVo.setStd_mat(resultSet.getInt("std_mat"));
                myStudenVoList.add(myStudenVo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        endClose();
        return myStudenVoList;
    }

    @Override
    public MyStudenVo searchMyStudent(String studentName) {
        return null;
    }

    @Override
    public int isMyStudent(String studentName) {
        return 0;
    }

    public void endClose() {
        try {
            if(resultSet != null) {resultSet.close();}
            if(statement != null) {statement.close();}
            if(preparedStatement != null) {preparedStatement.close();}
            if(connection != null) {connection.close();}
        } catch (SQLException sqle) {
            System.out.println("SQLExceoption: " + sqle);
        }
    }
}
