import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {
    public static void main(String[] args) {
        try {
            /* TPC 소켓 통신을 위해 ServerSocket 객체 생성 */
            ServerSocket serverSocket = new ServerSocket(7777);
            System.out.println("접속을 기다립니다...");

            /* accept() 메서드는 Client의 연결 요청이 올 때까지 계속 기다린다.
            *   연결이 요청이 오면 Socket 객체를 생성해서 Client 의 Socket 과 연결 한다. */
            Socket socket = serverSocket.accept();

            /* 이후에는 연결된 후의ㅡ 내용을 코딩하면 된다. */
            System.out.println(socket.getInetAddress() + " 에 연결되었습니다.");
            System.out.println("port : " + socket.getPort());
            System.out.println("localPort : " + socket.getLocalPort());

            /* 접속된 Client 에게 메세지 보내기
            *   Socket 의 outputStream 객체를 구성하여 전송한다*/
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(outputStream);

            dos.writeUTF("이 메시지는 나진실부터 시작하여 3명이상에게 다시 보내지 않을 시 좋은 일이 생길 수 있습니다!"); //메시지 보내기
            System.out.println("메시지를 보냈습니다.");

            dos.close();


        } catch (IOException ioe) {
            System.out.println("IOException : " + ioe);
        }
    }
}
