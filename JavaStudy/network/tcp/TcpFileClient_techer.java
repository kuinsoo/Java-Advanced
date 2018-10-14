import java.io.*;
import java.net.Socket;

public class TcpFileClient_techer {
        private Socket socket;
        private OutputStream os;
        private FileInputStream fis;

        public void clientRun() {

            try {
                File file = new File("D:\\D_Other\\network\\국화.jpg");
                if(!file.exists()) {
                    System.out.println("전솔할 파일이 없습니다.");
                    return;
                }
                socket = new Socket("192.168.203.16", 7777);
                System.out.println("파일 전송 시작");

                fis = new FileInputStream(file);
                os = socket.getOutputStream();

                byte[] tmp = new byte[8200];
                int length = 0;
                while((length = fis.read(tmp)) != -1 ) { // 파일읽기
                    os.write(tmp, 0, length); //소켓전송
                }
                System.out.println("파일 전송 완료");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(os!=null)   try{os.close();}      catch (IOException e1) {}
                if(fis!=null)    try{fis.close();}       catch (IOException e2) {}
                if(socket!=null)try{socket.close();}   catch (IOException e3) {}
            }

        }


    public static void main(String[] args) {
        new TcpFileClient_techer().clientRun();

    }
}
