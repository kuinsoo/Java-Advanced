package zip.service;

import zip.dao.ZipSearchDao;
import zip.dao.ZipSearchDaoInf;
import zip.vo.ZipVo;

import java.rmi.RemoteException;
import java.util.List;

public class ZipSearchService implements ZipSearchServiceInf {
    private ZipSearchDaoInf zipDao;

    public ZipSearchService() throws RemoteException{
        zipDao = ZipSearchDao.getinstance();
    }


    @Override
    public List<ZipVo> zipSearchDong(String dong) throws RemoteException {
        return zipDao.zipSearchDong(dong);
    }

    @Override
    public List<ZipVo> zipSearchCode(String code) throws RemoteException {
        return zipDao.zipSearchCode(code);
    }
}
