import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MultiChatServer {

    /* 대화명, 클라이언트 소켓을 저장할 Map 객체 변수 선언 */
    private Map<String, Socket> clients;

    public MultiChatServer() {
        /* 동기화 처리가 가능한 Map 객체 생성 */  // 공부하자 동기화 설정  Map 은 비동기화 !
        clients = Collections.synchronizedMap(new HashMap<>());
    }

    /* 서버 시작 메서드 */
    public void serverStart() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 시작되었습니다");
            System.out.println();

            while(true) {
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속 했습니다.");


                // 서버에서 클라이언트로 메시지를 전송하는 Thread 생성 및
                ServerReceiver threade = new ServerReceiver(socket);
                threade.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null) try {serverSocket.close();} catch (Exception e1){e1.printStackTrace();}
        }
    }

    /* Map(대화방)에 저장되어 있는 전체 사용자들에게 메세지를 전달하는 메서드 */
    public void sendToAll(String msg) {
        try {
            // 대화방에 접속한 사용자의 대화명(키값) 추출하기
            Iterator<String> it = clients.keySet().iterator();
            while(it.hasNext()) {
                String name = it.next(); //카값 Sting (대화명)
                /* 대화명에 해당하는 소켓을 이용하여 OutputStream 객체 구하기 */
                DataOutputStream out = new DataOutputStream(
                    clients.get(name).getOutputStream()
                );
                out.writeUTF(msg); //메시지 전송
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MultiChatServer().serverStart();
    }

    /* 서버에서 클라이언트로 메시지를 전송하는 Thread 클래스 작성
    *   편의를 위해서 Inner 클래수로 정의하여 대화방(Map)에 접근할 수 있도록 한다. */
    class ServerReceiver extends Thread {
        Socket socket;
        DataInput in;
        DataOutputStream out;

        public ServerReceiver (Socket socket) {
            this.socket = socket;
            try {
                /* 클라이언트 소켓에서 데이터를 수신 받기 위한 InnpuitStream 생성 */
                in = new DataInputStream(socket.getInputStream());

                /* 클라이언트 소켓으로 데이터를 전송ㅇ하기 위한 OutputStream */
                out = new DataOutputStream(socket.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String name = "";
            try{
                /* 서버에서 최초에 클라이언트가 보낸 대화명을 받아야 한다 */
                name = in.readUTF();

                // 대화명을 받아서 전체 클라이언트에게 대화방 참여 메시지를 보낸다.
                sendToAll(("[" + name + "] 님이 입장했습니다." ));

                // 대화방(Map에 저장한다.
                clients.put(name, socket);
                System.out.println("현재 접속자수 " + clients.size() + "명");

                /* 클라이언트가 보내온 메세지를 전체 클라이언트에게 보낸다. */
                while(in != null) {
                    sendToAll(in.readUTF());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                /* finally 절이 실행된다는 것은 클라이언트가 빠져 나갔다는 것을 의미한다. */
                sendToAll("[" + name + "] 님이 나갔습니다." );

                /* 대화방(Map) 에서 삭제 */
                clients.remove(name);
                System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 종료 하였습니다.");
                System.out.println("현재 접속자수 : " + clients.size() + "명");
            }
        }
    }

}
