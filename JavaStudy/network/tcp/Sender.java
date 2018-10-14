import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/* 이 클래스는 소켓을 통해서 메시지를 보내는 역할을 담당한다. */
public class Sender extends Thread {
        Socket socket;
        DataOutputStream dos;
        String name;

    /* 생성자는 외부에서 Scoket 객체를 받아서 멤버변수에 셋팅하고
    *   이름과 OutoutStream 을 사용한다 */
    public Sender(Socket socket){
        name = "[" + socket.getInetAddress() + ":" + socket.getPort() + "]";

        try {
          dos = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(dos != null) {
            try {
                dos.writeUTF("Mr.KKu 님: " +  scanner.nextLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
