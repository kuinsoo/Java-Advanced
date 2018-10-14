package service;

import vo.MyStudenVo;

import java.util.List;

public interface IMyStudentService {
    public int insertMyStudent(MyStudenVo myStudenVo);

    public int deleteMyStudent(String studentName);

    public int updateMyStudent(MyStudenVo myStudenVo);

    public List<MyStudenVo> allMyStuden();

    public MyStudenVo searchMyStudent(String studentName);

    public int isMyStudent(String studentName);

}
