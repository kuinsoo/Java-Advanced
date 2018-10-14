package member.vo;

public class MyMemberVo {

    /* DB테이블이 컬럼명을 멤버 변수로 지정한다. */
    private String mem_id	;
    private String mem_name	;
    private String mem_tel	;
    private String mem_addr	;

    public MyMemberVo() {
    }

    public MyMemberVo(String mem_id, String mem_name, String mem_tel, String mem_addr) {
        this.mem_id = mem_id;
        this.mem_name = mem_name;
        this.mem_tel = mem_tel;
        this.mem_addr = mem_addr;
    }

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    public String getMem_tel() {
        return mem_tel;
    }

    public void setMem_tel(String mem_tel) {
        this.mem_tel = mem_tel;
    }

    public String getMem_addr() {
        return mem_addr;
    }

    public void setMem_addr(String mem_addr) {
        this.mem_addr = mem_addr;
    }
}