package cn.test.ServletResponse;
//请求重定向  两次请求
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletRespDemo06", value = "/ServletRespDemo06")
public class ServletRespDemo06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servletRespDemo06执行了");

        request.setAttribute("username","zhangsan");
        response.sendRedirect(request.getContextPath()+"/ServletRespDemo07");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
