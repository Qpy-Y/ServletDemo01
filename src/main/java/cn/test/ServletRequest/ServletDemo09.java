package cn.test.ServletRequest;
/*
*请求转发
* */
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDemo09", value = "/ServletDemo09")
public class ServletDemo09 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置共享数据
        request.setAttribute("encoding","gbk");
        //获取请求调度对象
        RequestDispatcher rd = request.getRequestDispatcher("/ServletDemo10");
        //实现转发
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
