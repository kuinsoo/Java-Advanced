package member.service;

import java.util.List;


import member.vo.ProdVo;

public interface IProdService {
	
	public ProdVo getProd(String code);
	
	public List<ProdVo> getAllProd();
	
	public ProdVo insertProdVo(ProdVo prodVo);
	
	public int updateProd(ProdVo prodVo);
	
	public int deleteProd(String code);

    public List<ProdVo> getAllProd2(String select);
}
