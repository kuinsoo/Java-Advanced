package dao;


import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import vo.MyMemberVo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

public class MyMemberDaoImpl implements IMyMemberDao {
    private SqlMapClient sqlMapClient;


    public MyMemberDaoImpl() {
        try {
            Reader reader = Resources.getResourceAsReader("resources/sqlMapConfig.xml");
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertMyMember(MyMemberVo myMemberVo) {
        int intResultValue = 0;
        MyMemberVo myMemberVo1 ;
        try {
            myMemberVo = (MyMemberVo) sqlMapClient.insert("memberTest.insertMyMember", myMemberVo);
            if(myMemberVo == null){
                intResultValue = 1;
            } else {
                intResultValue = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return intResultValue;
    }

    @Override
    public MyMemberVo selectMyMember(String myMemberId) {
        return null;
    }

    @Override
    public List<MyMemberVo> selectAllMyMember() {
        return null;
    }

    @Override
    public int deleteMyMember(String myMemberId) {
        return 0;
    }

    @Override
    public int doubleCheckId(String myMemberId) {
        return 0;
    }
}
