package cn.test.ServletRequest;
//请求包含
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDemo11", value = "/ServletDemo11")
public class ServletDemo11 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletDemo11执行了");

        RequestDispatcher rd = request.getRequestDispatcher("/ServletDemo12");
        //实现包含
        rd.include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
