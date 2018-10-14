import java.awt.image.DataBuffer;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
    public static void main(String[] args) {
        ServerSocket server;
        Socket socket;

        try {
            server = new ServerSocket(7777);
            socket = server.accept();

            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);



            String url  = "D:\\D_Other\\network\\국화2.jpg";
            FileWriter fw = new FileWriter(url);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(dis.readUTF());
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
