import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class URLTest2 {
    /* 특정 서버의 정보와 파일 내용 출력하기
    * URLConnection 클래스 == 애플리케이션과 URL간의 통신 연결을 위한 추상 클래스 */
    public static void main (String[] args) {

        try {
            URL url = new URL("https://www.naver.com/index.html");
            // Header 정보 가져오기
            URLConnection urlCon = url.openConnection();

            Map<String, List<String>> headerMap = urlCon.getHeaderFields();

            Iterator<String> iterator = headerMap.keySet().iterator();
            while(iterator.hasNext()) {
                String key = iterator.next();
                System.out.println(key + ":" + headerMap.get(key));
            }
            System.out.println("-------------------------------------------");

            System.out.println("index.html 내용 출력하기");
            System.out.println("--------------------------------------------");

            /* 방법1 ==> URLConnection의 getInputStream() 메서드 사용하기
            *  파일을 읽어오기 위한 스트림 객체 구하기*/
            InputStream inputStream = urlCon.getInputStream();
            InputStreamReader inputStreamReader  = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader br = new BufferedReader(inputStreamReader);

            /* 출력 */
            while (true) {
                String string = br.readLine(); // 한줄씩 읽기
                if(string == null) break;
                System.out.println(string);
            }
            br.close();

            /* 방법2 ==> URL 객체의 openStream() 메서드 이용하기 */
            InputStream is = url.openStream();
            InputStreamReader isr  = new InputStreamReader(is,"UTF-8");
            BufferedReader br2 = new BufferedReader(isr);

            /* 출력 */
            while (true) {
                String string = br2.readLine(); // 한줄씩 읽기
                if(string == null) break;
                System.out.println(string);
            }
            br2.close();
        }
        catch (MalformedURLException e) {
            e.printStackTrace(); }
            catch (IOException e) {
            e.printStackTrace(); }


    }
}
