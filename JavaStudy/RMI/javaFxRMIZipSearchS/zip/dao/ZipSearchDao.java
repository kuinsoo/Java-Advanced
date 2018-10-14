package zip.dao;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import zip.vo.ZipVo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

public class ZipSearchDao implements ZipSearchDaoInf{
    private static ZipSearchDao zipDao;
    private SqlMapClient smc;
    private ZipSearchDao() {
        try {
            Reader rd = Resources.getResourceAsReader("res/sqlMapConfig.xml");
            smc = SqlMapClientBuilder.buildSqlMapClient(rd);
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ZipSearchDao getinstance(){
        if(zipDao == null) {
            zipDao = new ZipSearchDao();
        }
        return zipDao;
    }
    @Override
    public List<ZipVo> zipSearchDong(String dong) {
        List<ZipVo> ziplist = null;
        try {
            ziplist = smc.queryForList("zipsearch.getSearchDong", dong);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ziplist;
    }

    @Override
    public List<ZipVo> zipSearchCode(String code) {
        List<ZipVo> zipList = null;
        try {
            zipList = smc.queryForList("zipsearch.getSearchCode", code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zipList;
    }
}
