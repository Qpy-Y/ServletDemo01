package cn.test.ServletResponse;
//设置缓存   建议使用IE浏览器
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletRespDemo04", value = "/ServletRespDemo04")
public class ServletRespDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String news = "这是一条很火爆的新闻！";
        //设置缓存 1小时
        response.setDateHeader("Expires",System.currentTimeMillis()+1*60*60*1000);
        //设置编码格式
        response.setContentType("text/html;charset=UTF-8");
        //写出数据
        response.getWriter().write(news);

        System.out.println("aaa");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
