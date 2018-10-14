package dao;

import member.vo.MyMemberVo;
import vo.MemVo;

import javax.lang.model.element.NestingKind;
import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MemLoginDao implements IMemLoginDao{

    private static MemLoginDao memLoginDao = new MemLoginDao();
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private MemLoginDao() {

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
        Connection conn = null;
        PreparedStatement 	pstmt = null;
        ResultSet rs = null;
        int cnt = 0;
        try {
            conn = KKu.KKuDbOracle.connectionOracle();

            String sql = "insert into mymember (MEM_ID, MEM_PASS, MEM_NAME, MEM_REGNO1, MEM_REGNO2, MEM_BIR, MEM_ZIP, MEM_ADD1, MEM_ADD2, MEM_HOMETEL, MEM_COMTEL, MEM_HP, MEM_MAIL, MEM_JOB, MEM_LIKE, MEM_MEMORIAL, MEM_MEMORIALDAY, MEM_MILEAGE, MEM_DELETE)";
                    sql+= " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString( 1,memVo.getMem_id());
            pstmt.setString( 2,memVo.getMem_pass());
            pstmt.setString( 3,memVo.getMem_name());
            pstmt.setString( 4,memVo.getMem_regno1());
            pstmt.setString( 5,memVo.getMem_regno2());
            pstmt.setString( 6,memVo.getMem_bir());
            pstmt.setString( 7,memVo.getMem_zip());
            pstmt.setString( 8,memVo.getMem_add1());
            pstmt.setString( 9,memVo.getMem_add2());
            pstmt.setString(10,memVo.getMem_hometel());
            pstmt.setString(11,memVo.getMem_comtel());
            pstmt.setString(12,memVo.getMem_hp());
            pstmt.setString(13,memVo.getMem_mail());
            pstmt.setString(14,memVo.getMem_job());
            pstmt.setString(15,memVo.getMem_like());
            pstmt.setString(16,memVo.getMem_memorial());
            pstmt.setString(17,memVo.getMem_memorialday());
            pstmt.setString(18,memVo.getMem_mileage());
            pstmt.setString(19,memVo.getMem_delete());
            cnt = pstmt.executeUpdate();


        } catch (SQLException sqle) {
            cnt = 0;
            System.out.println("너냐?");
            sqle.printStackTrace();
        } finally {
            if(pstmt != null ) try { pstmt.close();} catch(SQLException sqle) {}
            if(conn != null ) try { conn.close();} catch(SQLException sqle) {}
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
