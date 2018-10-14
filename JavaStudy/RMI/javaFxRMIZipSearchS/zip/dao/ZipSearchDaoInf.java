package zip.dao;

import zip.vo.ZipVo;

import java.util.List;

public interface ZipSearchDaoInf {
    public List<ZipVo> zipSearchDong(String dong);

    public List<ZipVo> zipSearchCode(String code);

}
