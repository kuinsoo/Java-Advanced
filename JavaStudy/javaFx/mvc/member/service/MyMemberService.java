package member.service;


import member.dao.MyMemberDao;
import member.vo.MyMemberVo;

import java.util.List;

public class MyMemberService implements IMyMemberService {
    private static MyMemberService singleton;
    private MyMemberService() {memDao = MyMemberDao.getIntance(); }

    public static MyMemberService getInstance() {
        if(singleton == null) {
            singleton = new MyMemberService();
        }
        return singleton;
    }

    MyMemberDao memDao;

    @Override
    public int insertMember(MyMemberVo memVo) {
        return memDao.insertMember(memVo);
    }

    @Override
    public int delleteMember(String memId) {
        return memDao.delleteMember(memId);
    }

    @Override
    public int updateMember(MyMemberVo memVo) {
        return memDao.updateMember(memVo);
    }

    @Override
    public List<MyMemberVo> getAllMemberList() {
        return memDao.getAllMemberList();
    }

    @Override
    public int getMember(String memId) {
        return memDao.getMember(memId);
    }
}
