import java.io.IOException;

/**
 * @Author: CNwalking
 * @DateTime: 2020/4/28 11:10 上午
 * @Description: 测试一下servlet
 */
public class HelloWalkingRabbitServlet extends Servlet{

    @Override
    public void doGet(Request request, Response response) {
        try {
            response.write("WalkingRabbitServlet --> doGet method");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(Request request, Response response) {
        try {
            response.write("WalkingRabbitServlet --> doPost method");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
