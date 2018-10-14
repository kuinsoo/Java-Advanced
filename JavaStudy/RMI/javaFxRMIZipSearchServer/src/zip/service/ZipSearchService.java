package zip.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import ziip.dao.ZipSearchDao;
import ziip.dao.ZipSearchDaoInf;
import zip.vo.ZipVO;

//RMI 서버용 객체
public class ZipSearchService extends UnicastRemoteObject implements ZipSearchServiceInf{
	
	private ZipSearchDaoInf dao ;
	
	public ZipSearchService() throws RemoteException {
		dao = ZipSearchDao.getInstance();
	}
	

	
	@Override
	public List<ZipVO> zipSearchDong(String dong) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.zipSearchDong(dong);
	}

	@Override
	public List<ZipVO> zipSearchZipCode(String zipcode) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.zipSearchZipCode(zipcode);
	}

}
