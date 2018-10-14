package member.dao;



import member.vo.MyMemberVo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyMemberDao implements IMyMemberDao {

    private static MyMemberDao dao = new MyMemberDao();
    private MyMemberDao() {	}

    public static MyMemberDao getIntance() {
        if( dao == null ) {
            dao = new MyMemberDao();
        }
        return dao;
    }

    /* MemberVO객체에 담겨진 자료를 DB에  insert하는 메서드 */

    public int insertMember(MyMemberVo memVo) {
        Connection conn = null;
        PreparedStatement 	pstmt = null;
        ResultSet rs = null;
        int cnt = 0;
        try {
            conn = KKu.KKuDbOracle.connectionOracle();

            String sql = "insert into mymember (mem_id, mem_name, mem_tel, mem_addr) values (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, memVo.getMem_id());
            pstmt.setString(2, memVo.getMem_name());
            pstmt.setString(3, memVo.getMem_tel());
            pstmt.setString(4, memVo.getMem_addr());

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

    /* 회원 ID를 매게변수로 받아서 해당 회원을 삭제하는 메서드 */
    @Override
    public int delleteMember(String memId) {
        Connection 			conn = null;
        PreparedStatement 	pstmt = null;
        int cnt = 0;

        try {
            conn = KKu.KKuDbOracle.connectionOracle();

            String sql = "delete from mymember where mem_id = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, memId);

            cnt = pstmt.executeUpdate();

        } catch (SQLException sqle) {
            // TODO: handle exception
        }	finally {
            if(pstmt != null ) try { pstmt.close();} catch(SQLException sqle) {}
            if(conn != null ) try { conn.close();} catch(SQLException sqle) {}
        }
        return cnt;
    }

    /* 회원 ID를 매게변수로 받아화 해당 회원을 수정하는 메서드 */
    @Override
    public int updateMember(MyMemberVo memVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = 0;

        try {
            conn = KKu.KKuDbOracle.connectionOracle();

            String temp = "";
            if(memVo.getMem_name()!=null){
                temp += "mem_name = ? ";
            }

            if(memVo.getMem_tel()!=null){
                if(!"".equals(temp)){
                    temp += ", ";
                }
                temp += "mem_tel = ? ";
            }

            if(memVo.getMem_addr()!=null){
                if(!"".equals(temp)){
                    temp += ", ";
                }
                temp += "mem_addr = ? ";
            }

            String sql = "update mymember set " + temp +
                " where mem_id = ? ";

            pstmt = conn.prepareStatement(sql);

            int num = 1;
            if(memVo.getMem_name()!=null){
                pstmt.setString(num++, memVo.getMem_name());
            }

            if(memVo.getMem_tel()!=null){
                pstmt.setString(num++, memVo.getMem_tel());
            }

            if(memVo.getMem_addr()!=null){
                pstmt.setString(num++, memVo.getMem_addr());
            }

            pstmt.setString(num, memVo.getMem_id());

            cnt = pstmt.executeUpdate();


        } catch (SQLException sqle) {
            // TODO: handle exception
        } finally {
            if(pstmt != null ) try { pstmt.close();} catch(SQLException sqle) {}
            if(conn != null ) try { conn.close();} catch(SQLException sqle) {}
        }
        return cnt;
    }

    /* 전체 회원 정보를 DB에서 가져와 List에 담아서 반환하는 메서드 */
    @Override
    public List<MyMemberVo> getAllMemberList() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //데이터를 저장할 List 객체 생성
        List<MyMemberVo> memList = new ArrayList<MyMemberVo>();

        try {
            conn =KKu.KKuDbOracle.connectionOracle();

            String sql = "select * from mymember";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                MyMemberVo memVo = new MyMemberVo();

                memVo.setMem_id(rs.getString("mem_id"));
                memVo.setMem_name(rs.getString("mem_name"));
                memVo.setMem_tel(rs.getString("mem_tel"));
                memVo.setMem_addr(rs.getString("mem_addr"));

                // 데이터가 담긴 MemberVO객체를 List에 추가한다
                memList.add(memVo);

            }
        } catch (SQLException sqle) {
            memList = null;
            sqle.printStackTrace();
        }	finally {

            if(rs != null ) try { rs.close();} catch(SQLException sqle) {}
            if(stmt != null ) try { stmt.close();} catch(SQLException sqle) {}
            if(conn != null ) try { conn.close();} catch(SQLException sqle) {}
        }

        return memList;
    }

    /* 회원 mem_id 조회 */
    @Override
    public int getMember(String memId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int cnt = 0;
        int count = 0;

        try {
            conn = KKu.KKuDbOracle.connectionOracle();
            String sql = "select count(*) cnt from mymember where mem_id =? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);

            rs = pstmt.executeQuery();
            if(rs.next()) {
                count = rs.getInt("cnt");
            }

        }catch (SQLException sqle) {
            count = 0;
            sqle.printStackTrace();
        } finally {
            if(pstmt != null ) try { pstmt.close();} catch(SQLException sqle) {}
            if(conn != null ) try { conn.close();} catch(SQLException sqle) {}
        }
        return count;
    }
}
