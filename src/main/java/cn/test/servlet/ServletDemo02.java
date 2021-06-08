package cn.test.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servletdemo02/*")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int money =1000;

        String path = request.getRequestURI();
        path = path.substring(path.lastIndexOf("/"));

        if("/vip".equals(path)){
            System.out.println("原价："+money+". 打折后："+money*0.9);
        }else if("/vipp".equals(path)){
            System.out.println("原价："+money+". 打折后："+money*0.5);
        }else{
            System.out.println("原价："+money+". 打折后："+money);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
