package member.vo;

public class ProdVo {
	private String 	prod_code;
	private String 	prod_name;
	private String 	prod_div;
	private int 	prod_qty;
	private int 	prod_price;

    public ProdVo() {
    }

    public ProdVo(String prod_code, String prod_name, String prod_div, int prod_qty, int prod_price) {
		super();
		this.prod_code = prod_code;
		this.prod_name = prod_name;
		this.prod_div = prod_div;
		this.prod_qty = prod_qty;
		this.prod_price = prod_price;
	}


	public String getProd_code() {
		return prod_code;
	}


	public void setProd_code(String prod_code) {
		this.prod_code = prod_code;
	}


	public String getProd_name() {
		return prod_name;
	}


	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}


	public String getProd_div() {
		return prod_div;
	}


	public void setProd_div(String prod_div) {
		this.prod_div = prod_div;
	}


	public int getProd_qty() {
		return prod_qty;
	}


	public void setProd_qty(int prod_qty) {
		this.prod_qty = prod_qty;
	}


	public int getProd_price() {
		return prod_price;
	}


	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	
	
	
	
}
