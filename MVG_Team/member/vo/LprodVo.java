package member.vo;

public class LprodVo {
	private String lprod_id;
	private String lprod_name;
	private String lprod_etc;
	private String lprod_prod;
	
	public LprodVo(String lprod_id, String lprod_name, String lprod_etc, String lprod_prod) {
		super();
		this.lprod_id = lprod_id;
		this.lprod_name = lprod_name;
		this.lprod_etc = lprod_etc;
		this.lprod_prod = lprod_prod;
	}
	public String getLprod_id() {
		return lprod_id;
	}
	public void setLprod_id(String lprod_id) {
		this.lprod_id = lprod_id;
	}
	public String getLprod_name() {
		return lprod_name;
	}
	public void setLprod_name(String lprod_name) {
		this.lprod_name = lprod_name;
	}
	public String getLprod_etc() {
		return lprod_etc;
	}
	public void setLprod_etc(String lprod_etc) {
		this.lprod_etc = lprod_etc;
	}
	public String getLprod_prod() {
		return lprod_prod;
	}
	public void setLprod_prod(String lprod_prod) {
		this.lprod_prod = lprod_prod;
	}
	
	
}
