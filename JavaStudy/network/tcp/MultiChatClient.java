import java.awt.*;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MultiChatClient {

public void clientStart() {

    Scanner scanner = new Scanner(System.in);
    String userName = null;

    System.out.println("대화명 입력 : ");
    userName = scanner.next();

    try {
        String serverIp = "192.168.203.73";
        Socket socket = new Socket(serverIp, 7777);
        System.out.println("서버에 연결되었습니다.");

        // 메시지 전송용 객체 생성
        Thread sender = new ClinetSender(socket, userName);

        // 메시지 수신용 객체 생성
        Thread receive = new ClientReceiver(socket);

        sender.start();
        receive.start();

    } catch (Exception e) {

    }
}

    public static void main(String[] args) {
        new MultiChatClient().clientStart();
    }

    // 메시지 전송용  Thread
    class ClinetSender extends  Thread {
        Socket socket;
        DataOutputStream dos;
        String name;
        Scanner scan = new Scanner(System.in);

        public ClinetSender (Socket socket, String name) {
            this.socket = socket;
            this.name = name;
            try {
                dos = new DataOutputStream((socket.getOutputStream()));
            }catch (Exception e) {

            }

        }

        @Override

        public void run() {
            try {
                /* 처음 시작하자 맘자 자신의 이름을 서버로 전송한다 */

                if (dos != null) {
                    dos.writeUTF(name);
                    while (true) {
                        //키보드로 입력한 내용을 서버로 전송한다.
                        for (int i = 0; i < 5; i++) {
                        dos.writeUTF("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");

                        }
                        Thread.sleep(10000);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /* 메시지 수신용 Therea */
    class ClientReceiver extends Thread {
        Socket socket;
        DataInputStream in;

        //생성자

        public ClientReceiver(Socket socket) {
            this.socket = socket;
            try {
                //서버로 부터 메시지를 받을 수 있는 InputStream
                in = new DataInputStream(socket.getInputStream());
            } catch (Exception e) {

            }
        }

        @Override
        public void run() {
            while(in != null) {
                try {
                    /* 서버로부터 전송되어 온 메시지를 받아서 출력한다*/
                    System.out.println(in.readUTF());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

}
