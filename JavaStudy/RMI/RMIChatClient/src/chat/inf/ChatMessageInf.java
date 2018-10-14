package chat.inf;

import java.rmi.Remote;
import java.rmi.RemoteException;

/* 클라이언트용 인터페이스 ==> 서버에서 클라이언트쪽의 메서드를 호출하도록 하는 인터페이스 */
public interface ChatMessageInf extends Remote {
   public void setMessage(String msg) throws RemoteException;
   

}