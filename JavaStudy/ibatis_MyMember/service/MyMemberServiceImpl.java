package service;

import dao.IMyMemberDao;
import dao.MyMemberDaoImpl;
import vo.MyMemberVo;

import java.util.List;

public class MyMemberServiceImpl implements IMyMemberService {
    private IMyMemberDao myMemberDao = new MyMemberDaoImpl();


    @Override
    public int insertMyMember(MyMemberVo myMemberVo) {
        return myMemberDao.insertMyMember(myMemberVo);
    }

    @Override
    public MyMemberVo selectMyMember(String myMemberId) {
        return myMemberDao.selectMyMember(myMemberId);
    }

    @Override
    public List<MyMemberVo> selectAllMyMember() {
        return myMemberDao.selectAllMyMember();
    }

    @Override
    public int deleteMyMember(String myMemberId) {
        return myMemberDao.deleteMyMember(myMemberId);
    }

    @Override
    public int doubleCheckId(String myMemberId) {
        return myMemberDao.doubleCheckId(myMemberId);
    }
}
