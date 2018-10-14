import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer_techer {
        ServerSocket server;
        Socket socket;
        InputStream is;
        FileOutputStream fos;
        public void serverRun() {
            try {
                File file = new File("D:\\D_Other\\network\\국화2.jpg");
                if (!file.exists()) {
                    file.createNewFile();
                }
                    server = new ServerSocket(7777);


                    socket = server.accept();

                    is = socket.getInputStream();

                    fos = new FileOutputStream(file);

                    byte[] tmp = new byte[9000];
                        int length = 0;
                        while ((length = is.read(tmp)) != -1) { // 소켓으로 전송 받기
                            fos.write(tmp, 0, length); // 파일로 저장하기

                            System.out.println("파일 다운로드 완료 .. ");
                    }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (is != null) try {
                    is.close();
                } catch (IOException e1) {
                }
                if (fos != null) try {
                    fos.close();
                } catch (IOException e2) {
                }
                if (socket != null) try {
                    socket.close();
                } catch (IOException e3) {
                }
                if (server != null) try {
                    server.close();
                } catch (IOException e4) {
                }
            }
        }

    public static void main(String[] args) {
            new TcpFileServer_techer().serverRun();
    }

}
