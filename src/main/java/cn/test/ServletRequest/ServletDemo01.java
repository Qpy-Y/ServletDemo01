package cn.test.ServletRequest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDemo01", value = "/ServletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取虚拟目录名称：
        String contextPath = req.getContextPath();
        //获取Servlet映射路径
        String servletPath = req.getServletPath();
        //获取访问者ip
        String remoteAddr = req.getRemoteAddr();

        //获取请求消息数据
        String queryString = req.getQueryString();

        //获取统一资源标识符
        String requestURI = req.getRequestURI();  ///ServletDemo01   范围更大
        //获取统一资源定位符
        StringBuffer requestURL = req.getRequestURL();  //http://localhost:8080/ServletDemo01

        System.out.println(contextPath+"\n-----\n"+servletPath+"\n-----\n"+remoteAddr+"\n-----\n"+queryString+"\n-----\n"+requestURI+"\n-----\n"+requestURL);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
