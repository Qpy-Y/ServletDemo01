package cn.test.ServletRequest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ServletDemo02", value = "/ServletDemo02")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求头信息的相关方法

        //获取请求名称获取一个值
        String connection = request.getHeader("connection");
        System.out.println(connection+"\n----------------");
        //获取请求名称获取多个值
        Enumeration<String> headers = request.getHeaders("accept-encoding");
        System.out.println("accept-encoding：");
        while(headers.hasMoreElements()){
            String s = headers.nextElement();
            System.out.println(s);
        }
        System.out.println("--------------");
        //获取所以请求名称
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            String header = request.getHeader(s);
            System.out.println(s+"："+header);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
