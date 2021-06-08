package cn.test.ServletResponse;
//定时刷新
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletRespDemo05", value = "/ServletRespDemo05")
public class ServletRespDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = "您的用户名或密码有误，3秒后自动跳转到登录页面";
        response.setContentType("text/html;charset=UTF-8");
        //写出数据
        response.getWriter().write(str);

        response.setHeader("Refresh","3;URL=/login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
