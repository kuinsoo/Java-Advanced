package vo;

public class MyStudenVo {
    private int std_eng;
    private int std_kor;
    private int std_mat;
    private String std_name;

    public MyStudenVo() {
    }

    public MyStudenVo(int std_eng, int std_kor, int std_mat, String std_name) {
        this.std_eng = std_eng;
        this.std_kor = std_kor;
        this.std_mat = std_mat;
        this.std_name = std_name;
    }

    public int getStd_eng() {
        return std_eng;
    }

    public void setStd_eng(int std_eng) {
        this.std_eng = std_eng;
    }

    public int getStd_kor() {
        return std_kor;
    }

    public void setStd_kor(int std_kor) {
        this.std_kor = std_kor;
    }

    public int getStd_mat() {
        return std_mat;
    }

    public void setStd_mat(int std_mat) {
        this.std_mat = std_mat;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }
}
