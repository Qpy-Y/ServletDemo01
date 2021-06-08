package cn.test.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    ServletContext的演示
*/
public class servletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取ServletContext对象
        ServletContext servletContext = getServletContext();
        //2.常用方法演示
        //获取全局配置演示:getInitParameter(String key) 根据key获取value
        String value = servletContext.getInitParameter("globalDesc");
        System.out.println(value);
        //获取应用的虚拟目录:getContextPath()
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        //根据虚拟目录获取绝对路径：getRealPath(String path)
        String realPath = servletContext.getRealPath("/");
        System.out.println(realPath);

        servletContext.setAttribute("username","zhangsan");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
