package cn.test.ServletResponse;
//字节流响应消息
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ServletRespDemo01", value = "/ServletRespDemo01")
public class ServletRespDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //1.获取字节输出流对象
        ServletOutputStream os = response.getOutputStream();
        //2.定义一个消息
        String str = "你好，世界";
        //3.通过字节流输出
        os.write(str.getBytes("UTF-8"));
        //os.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
