package service;

import dao.IMemLoginDao;
import dao.MemLoginDao;
import member.vo.MyMemberVo;
import vo.MemVo;

import java.util.List;
import java.util.Map;

public class MemLoginService implements IMemLoginService{
    private static MemLoginService sigleton;
    private MemLoginService(){
        memLoginDao = MemLoginDao.getInstance();
    }
    public static MemLoginService getInstance(){
        if(sigleton == null){
            sigleton = new MemLoginService();
        }
        return sigleton;
    }
    MemLoginDao memLoginDao;

    @Override
    public MemVo login(Map m) {
        return memLoginDao.login(m);
    }

    @Override
    public int insertMember(MemVo memVo) {
        return memLoginDao.insertMember(memVo);
    }

    @Override
    public int delleteMember(String memId) {
        return memLoginDao.delleteMember(memId);
    }

    @Override
    public int updateMember(MemVo memVo) {
        return memLoginDao.updateMember(memVo);
    }

    @Override
    public List<MyMemberVo> getAllMemberList() {
        return memLoginDao.getAllMemberList();
    }

    @Override
    public int getMember(String memId) {
        return memLoginDao.getMember(memId);
    }
}
