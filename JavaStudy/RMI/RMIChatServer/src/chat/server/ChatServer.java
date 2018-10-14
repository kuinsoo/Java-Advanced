package chat.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import chat.inf.ChatMessageInf;
import chat.inf.ChatServerInf;

//ChatServerInf를 구현한 서버용 객체
public class ChatServer extends UnicastRemoteObject implements ChatServerInf{
	
	// 접속한 클라이언트 객체를 저장할 List객체 생성
	ArrayList<ChatMessageInf> clientList = new ArrayList<>();
	
	public ChatServer() throws RemoteException{
		// TODO Auto-generated constructor stub
	}

	// 접속한 클라이언트 객체를 리스트에 추가하는 메서드 구현
	@Override
	public void setClient(ChatMessageInf client) throws RemoteException {
		// TODO Auto-generated method stub
		clientList.add(client);
	}
	
	// 리스트에 등록된 모든 클라이언트 객체에게 메세지를 전달하는 메서드 구현
	@Override
	public void setMessage(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		for(ChatMessageInf cmi : clientList) {
			System.out.println("msg");
			cmi.setMessage(msg);
			
		}
	}
}
