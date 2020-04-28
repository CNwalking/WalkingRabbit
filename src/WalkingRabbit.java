import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: CNwalking
 * @DateTime: 2020/4/28 11:23 上午
 * @Description: 启动类
 */
public class WalkingRabbit {
    private int port = 8080;

    private Map<String, String> urlServletMap = new HashMap<>();

    public WalkingRabbit(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        new WalkingRabbit(8080).start();
    }

    public void start() {
        initServletMapping();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("WalkingRabbit Start");
            while (true) {
                // 阻塞到建立连接
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                Request request = new Request(inputStream);
                Response response = new Response(outputStream);
                // 分发请求
                dispatch(request, response);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initServletMapping() {
        ServletMappingConfig.servletMappingList.forEach(ele->{
            urlServletMap.put(ele.getUrl(), ele.getClazz());
        });
    }

    private void dispatch(Request request, Response response) {

        String clazz = urlServletMap.get(request.getUrl());
        System.out.println("clazz: " + clazz);
        try{
            System.out.println("forName: " + Class.forName(clazz));
            Class<Servlet> servletClass = (Class<Servlet>) Class.forName(clazz);
            Servlet servlet = servletClass.newInstance();
            servlet.service(request, response);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

    }

}

