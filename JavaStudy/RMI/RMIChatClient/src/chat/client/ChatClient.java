package chat.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import chat.inf.ChatMessageInf;

// ChatMessageInf를 구현한 클라이언트용 객체
public class ChatClient extends UnicastRemoteObject implements ChatMessageInf{
	
	//생성자
	public ChatClient() throws RemoteException{
		
	}

	@Override
	public void setMessage(String msg) throws RemoteException {
		System.out.println(msg);
	}
}
