package service;

import dao.IMyStudentDao;
import dao.MyStudentDao;
import vo.MyStudenVo;

import java.util.List;

public class MyStudentService implements IMyStudentService {
    private static MyStudentService myStudentService;
    MyStudentService(){ myStudentDao = MyStudentDao.getInstance();}
    public static MyStudentService getInstance(){
        if(myStudentService == null){
            myStudentService = new MyStudentService();
        }
        return myStudentService;
    }
    MyStudentDao myStudentDao;
    @Override
    public int insertMyStudent(MyStudenVo myStudenVo) {
        return myStudentDao.insertMyStudent(myStudenVo);
    }

    @Override
    public int deleteMyStudent(String studentName) {
        return myStudentDao.deleteMyStudent(studentName);
    }

    @Override
    public int updateMyStudent(MyStudenVo myStudenVo) {
        return myStudentDao.updateMyStudent(myStudenVo);
    }

    @Override
    public List<MyStudenVo> allMyStuden() {
        return myStudentDao.allMyStuden();
    }

    @Override
    public MyStudenVo searchMyStudent(String studentName) {
        return myStudentDao.searchMyStudent(studentName);
    }

    @Override
    public int isMyStudent(String studentName) {
        return myStudentDao.isMyStudent(studentName);
    }
}
