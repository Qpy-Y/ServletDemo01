package cn.test.ServletRequest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDemo10", value = "/ServletDemo10")
public class ServletDemo10 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object encoding = request.getAttribute("encoding");
        System.out.println(encoding);

        System.out.println("ServletDemo10执行了");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
