package member.dao;

import java.util.List;

import member.vo.ProdVo;

public interface IProdDao {
	public ProdVo getProd(String code);
	
	public List<ProdVo> getAllProd();

    public List<ProdVo> getAllProd2(String select);
	
	public ProdVo insertProdVo(ProdVo prodVo);
	
	public int updateProd(ProdVo prodVo);
	
	public int deleteProd(String code);
	
}
