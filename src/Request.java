import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: CNwalking
 * @DateTime: 2020/4/28 10:25 上午
 * @Description:
 */
public class Request {

    private String url;
    private String method;

    public Request(InputStream inputStream) throws IOException {
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if ((length = inputStream.read(httpRequestBytes)) > 0) {
            // 通过解码指定的byte构造一个新的String
            httpRequest = new String(httpRequestBytes, 0, length);
        }
        String httpHeader = httpRequest.split("\n")[0];
        // 拿请求头的方法和url
        url = httpHeader.split("\\s")[1];
        method = httpHeader.split("\\s")[0];
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
