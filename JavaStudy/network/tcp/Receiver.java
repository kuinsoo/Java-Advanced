import java.io.DataInputStream;
import java.net.Socket;

/* 이 클래스는 소켓에서 메시지를 받아서 화면에 출력하는 일을 담당한다 */
public class Receiver extends  Thread {
    Socket socket;
    DataInputStream dis;

    /* 생성자에서 Socket을 셋팅하고 InputStream객체를 구성한다*/
    public Receiver(Socket socket){
        try{
            dis = new DataInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(dis!=null){
            try {
                System.out.println(dis.readUTF());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
