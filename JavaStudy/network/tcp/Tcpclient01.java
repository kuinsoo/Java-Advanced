import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Tcpclient01 {
    public static void main(String[] args) {
        String serverIp = "192.168.203.16";

        System.out.println(serverIp + "서버에 연결 중입니다.");

        try {
            /* 소켓을 생성해서 서버에 연결 요청을 보낸다. */
            Socket socket = new Socket(serverIp, 7777);
            /* 이후에는 연결된 후의 내용을 코딩한다 */
            System.out.println("연결되었습니다.");
            System.out.println();
            /* 서버가 보내온 메시지를 출력 하기
            *   메시지를 받기위해 InputStream 객체를 얻는다*/
            InputStream inputStream = socket.getInputStream();
            DataInputStream dis = new DataInputStream(inputStream);

            System.out.println("서버에서 온 메시지" + dis.readUTF());

            System.out.println();
            System.out.println("연결을 종료합니다.");

            /* 소켓과 스트림 객체 닫기 */
            dis.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
