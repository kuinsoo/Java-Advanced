package basic.inf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import basic.vo.FileInfoVO;
import basic.vo.TestVO;

/*
 	RMI 용 Interface는 Remote를 상속해야 한다.
 */

public interface RemoteInterface extends Remote{
	//이 Interface에 선언되는 모든 메서드는 RemoteException을 throws를 해야한다.
	//throws를 하지 않으면 후에 RMI를 적용하여 실행할때 에러가 발생하게 된다.
	
	public int doRemotePrint(String str) throws RemoteException;		
	
	public void doPrintList(ArrayList<String> list) throws RemoteException;
	
	public void doPrintVo(TestVO vo) throws RemoteException;
	
	public void setFile(FileInfoVO fileVo) throws RemoteException ; 

}
