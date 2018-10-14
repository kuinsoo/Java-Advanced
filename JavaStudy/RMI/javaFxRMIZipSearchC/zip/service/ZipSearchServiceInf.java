package zip.service;

import zip.vo.ZipVo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ZipSearchServiceInf extends Remote {
    public List<ZipVo> zipSearchDong(String dong) throws RemoteException;

    public List<ZipVo> zipSearchCode(String code) throws RemoteException;
}
