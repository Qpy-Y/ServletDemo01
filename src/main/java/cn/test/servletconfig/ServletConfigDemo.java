package cn.test.servletconfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
ServletConfig的演示
* */
public class ServletConfigDemo extends HttpServlet {
    private ServletConfig config;

    //通过init方法，对ServletConfig对象进行赋值
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据key获取value
        String encodingValue = config.getInitParameter("encoding");
        System.out.println(encodingValue);
        System.out.println("-----------------");
        //获取所有key
        Enumeration<String> keys = config.getInitParameterNames();
        while(keys.hasMoreElements()){
            String key=keys.nextElement();
            String value = config.getInitParameter(key);
            System.out.println(key+":"+value);
        }
        System.out.println("-----------------");
        String servletName = config.getServletName();
        System.out.println(servletName);
        System.out.println("-----------------");
        ServletContext servletContext = config.getServletContext();
        System.out.println(servletContext);
        Object value = servletContext.getAttribute("username");
        System.out.println(value);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
