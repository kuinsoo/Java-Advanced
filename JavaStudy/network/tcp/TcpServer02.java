import java.net.ServerSocket;
import java.net.Socket;


/* 메시지를 받는 클래스와 보내는 클래스를 따로 만들어서
 *   작동시키는데 이 클래스는 쓰레드로 작동되록 한다.*/
public class TcpServer02 {
    public static void main(String[] args) {
        /* 서버소켓을 만들고, 클라이언트가 접속해 오면 소켓을 만들어서 메시지를 받는 클래스에 이 소켓을 넘겨준다.*/
        ServerSocket serverSocket = null;
        Socket socket;
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 준비되었습니다.");
            socket = serverSocket.accept();

            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();
        }catch (Exception e){

        }
    }
}
