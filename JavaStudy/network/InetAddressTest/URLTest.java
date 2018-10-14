import java.net.MalformedURLException;
import java.net.URL;

/* URL 클래스 == 인터넷에 존재하는 서버들의 자원에 접근할 수 있는 주소를 관리하는 클래스 */
public class URLTest {
    public static void main(String[] args) {
        try {
            //URL url = new URL("http://www.ddit.or.kr:80/index.html?ttt=123");
            URL url = new URL("http","www.ddit.or.kr",80,"index.html?ttt=123");
            System.out.println(url.getPort());
            System.out.println("protocol : " + url.getProtocol());
            System.out.println("host : " + url.getHost());
            System.out.println("file : " + url.getFile());
            System.out.println("query : " + url.getQuery());
            System.out.println("path : " + url.getPath());
            System.out.println("port : " + url.getPort());

            String string = url.toString();
            System.out.println(string.indexOf("index"));
            System.out.println(url.toString());
            StringBuffer stringBuffer  = new StringBuffer(string);
            stringBuffer.insert(24,"/");
            System.out.println(stringBuffer.toString());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
