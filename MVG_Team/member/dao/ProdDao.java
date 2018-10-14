package member.dao;



import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import member.vo.ProdVo;

public class ProdDao implements IProdDao{
	private static ProdDao prodDao;
	private SqlMapClient sqlMapClient;
	private ProdDao() {
		try {
			Reader reader = Resources.getResourceAsReader("res/sqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ProdDao getInstance() {
		if(prodDao == null ) {
			prodDao = new ProdDao();
		}
		return prodDao;
	}
	
	@Override
	public ProdVo getProd(String code) {
		return null;
	}

	@Override
	public List<ProdVo> getAllProd() {
		List<ProdVo> listProd = null;
		try {
			System.out.println("나오나요?");
			listProd = sqlMapClient.queryForList("testprod.getAllSearchProd");
			System.out.println("sdfad");
		} catch (SQLException e) {
			System.out.println("getAllProd" + e);
		}
		return listProd;
	}

    @Override
    public List<ProdVo> getAllProd2(String select) {
        List<ProdVo> listProd = null;
        try {

            listProd = sqlMapClient.queryForList("testprod.getAllSearchProd2",select);
        } catch (SQLException e) {
            System.out.println("getAllProd" + e);
        }
        return listProd;

    }

    @Override
	public ProdVo insertProdVo(ProdVo prodVo) {
		return null;
	}

	@Override
	public int updateProd(ProdVo prodVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProd(String code) {
		// TODO Auto-generated method stub
		return 0;
	}

}
