package dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import member.vo.MyMemberVo;
import org.apache.ibatis.io.Resources;
import vo.MemVo;

import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class MemLoginDao implements IMemLoginDao{

    private static MemLoginDao memLoginDao = new MemLoginDao();
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private SqlMapClient sqlMapClient;
    private MemLoginDao() {
        try {
            Reader reader = Resources.getResourceAsReader("resources/sqlMapConfig.xml");
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MemLoginDao getInstance(){
        if(memLoginDao == null) {
            memLoginDao = new MemLoginDao();
        }
        return memLoginDao;
    }

    @Override
    public MemVo login(Map<String, String> m) {

        MemVo memVo = new MemVo();
        String mem_id = null;
        try {
            for (String str  : m.keySet()) {
                mem_id = str;
                System.out.println(str + ", " + m.get(str));
            }
            
            connection = KKu.KKuDbOracle.connectionOracle();

            String sql;
            sql = "select * from member where mem_id = ?  and mem_pass = ? " ;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mem_id);
            preparedStatement.setString(2, m.get(mem_id));

            System.out.println(sql);
            System.out.println(mem_id + " " + m.get(mem_id));
            resultSet = preparedStatement.executeQuery();

            int i = 1;
            while(resultSet.next()) {
                memVo.setMem_id(resultSet.getString         ("mem_id"));
                memVo.setMem_pass(resultSet.getString       ("mem_pass"));
                memVo.setMem_name(resultSet.getString       ("mem_name"));
                memVo.setMem_regno1(resultSet.getString     ("mem_regno1"));
                memVo.setMem_regno2(resultSet.getString     ("mem_regno2"));
                memVo.setMem_bir(resultSet.getString        ("mem_bir"));
                memVo.setMem_zip(resultSet.getString        ("mem_zip"));
                memVo.setMem_add1(resultSet.getString       ("mem_add1"));
                memVo.setMem_add2(resultSet.getString       ("mem_add2"));
                memVo.setMem_hometel(resultSet.getString    ("mem_hometel"));
                memVo.setMem_comtel(resultSet.getString     ("mem_comtel"));
                memVo.setMem_hp(resultSet.getString         ("mem_hp"));
                memVo.setMem_mail(resultSet.getString       ("mem_mail"));
                memVo.setMem_job(resultSet.getString        ("mem_job"));
                memVo.setMem_like(resultSet.getString       ("mem_like"));
                memVo.setMem_memorial(resultSet.getString   ("mem_memorial"));
                memVo.setMem_memorialday(resultSet.getString("mem_memorialday"));
                memVo.setMem_mileage(resultSet.getString    ("mem_mileage"));
                memVo.setMem_delete(resultSet.getString     ("mem_delete"));

            }
        }   catch (Exception e){
            System.out.println("Login : " + e);
        } finally {
            try {
                if(resultSet != null){ resultSet.close();}
                if(statement != null){ statement.close();}
                if(connection != null){ connection.close();}
            }   catch (Exception e2){
                System.out.println("close : " + e2);
            }
        }

        return memVo;
    }

    @Override
    public int insertMember(MemVo memVo) {
        int cnt = 0 ;
        try{
            memVo = (MemVo) sqlMapClient.insert("memberTest.insertMember", memVo);
            if(memVo == null){
                cnt = 0;
                System.out.println("실패");
            }else {
                cnt = 1;
                System.out.println("성공");
            }
        }catch (Exception e){
            System.out.println("Exception : " + e);
        }


        return cnt;
    }

    @Override
    public int delleteMember(String memId) {
        return 0;
    }

    @Override
    public int updateMember(MemVo memVo) {
        return 0;
    }

    @Override
    public List<MyMemberVo> getAllMemberList() {
        return null;
    }

    @Override
    public int getMember(String memId) {
        return 0;
    }
}
