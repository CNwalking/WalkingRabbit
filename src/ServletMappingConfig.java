import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CNwalking
 * @DateTime: 2020/4/28 11:21 上午
 * @Description:
 */
public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    static {
        servletMappingList.add(new ServletMapping("hello",
                "/hello", "HelloWalkingRabbitServlet"));
    }
}
