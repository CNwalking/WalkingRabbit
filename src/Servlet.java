/**
 * @Author: CNwalking
 * @DateTime: 2020/4/28 11:05 上午
 * @Description:
 */
public abstract class Servlet {

    public static String METHOD_POST = "POST";

    public static String METHOD_GET = "GET";

    /**
     * doGet方法,GET请求时候调用
     * @param request
     * @param response
     */
    public abstract void doGet(Request request, Response response);

    /**
     * doPost方法,POST请求时候调用
     * @param request
     * @param response
     */
    public abstract void doPost(Request request, Response response);

    public void service(Request request, Response response) {
        if (METHOD_POST.equalsIgnoreCase(request.getMethod())) {
            doPost(request, response);
        } else if (METHOD_GET.equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        }
    }
}
