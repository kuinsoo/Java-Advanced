import java.io.*;
import java.net.Socket;

public class TcpFileClient {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("192.168.203.16",7777);
            OutputStream os = socket.getOutputStream();
            DataOutputStream ds = new DataOutputStream(os);

            FileReader fr = new FileReader("D:\\D_Other\\network\\국화.jpg");
            BufferedReader bfr = new BufferedReader(fr);

            while(bfr.read() != -1) {
                ds.writeUTF(bfr.readLine());
            }

            bfr.close();
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
