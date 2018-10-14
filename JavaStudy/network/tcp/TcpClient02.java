import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpClient02 {
    public static void main(String[] args) {
        /* 내 컴퓨터를 나타내는 방법
        *   1_ Ip주소
        *   2_ 127.0..1
        *   3_ localhost */
        try {
            String server = "192.168.203.73";
            Socket socket = new Socket(server, 7777);
            System.out.println("서버에 연결 되었습니다.");
            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
