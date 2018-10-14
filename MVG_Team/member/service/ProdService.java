package member.service;

import java.util.List;

import member.dao.IProdDao;
import member.dao.ProdDao;
import member.vo.ProdVo;

public class ProdService implements IProdService {
	private IProdDao dao;
	private static ProdService prodService;
	
	private ProdService() {
		dao= ProdDao.getInstance();
	}
	
	public static ProdService getInstance() {
		if(prodService == null) {
			prodService = new ProdService();
		}
		return prodService;
	}
	@Override
	public ProdVo getProd(String code) {
		// TODO Auto-generated method stub
		return dao.getProd(code);
	}

	@Override
	public List<ProdVo> getAllProd() {
		// TODO Auto-generated method stub
		return dao.getAllProd();
	}

	@Override
	public ProdVo insertProdVo(ProdVo prodVo) {
		// TODO Auto-generated method stub
		return dao.insertProdVo(prodVo);
	}

	@Override
	public int updateProd(ProdVo prodVo) {
		// TODO Auto-generated method stub
		return dao.updateProd(prodVo);
	}

	@Override
	public int deleteProd(String code) {
		// TODO Auto-generated method stub
		return dao.deleteProd(code);
	}

    @Override
    public List<ProdVo> getAllProd2(String select) {
        return dao.getAllProd2(select);
    }
}
