package cn.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ServletCookieDemo01", value = "/ServletCookieDemo01")
public class ServletCookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过响应对象写出提示信息
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("欢迎访问本网站，您的最后访问时间为：<br>");
        //2.创建Cookie对象，用于记录最后的访问时间
        Cookie cookie = new Cookie("time",System.currentTimeMillis()+"");
        //3.设置最大存活时间
        cookie.setMaxAge(3600);
        //4.将cookie对象添加到客户端
        response.addCookie(cookie);
        //5.获取Cookie
        Cookie[] cookies = request.getCookies();
        for(Cookie c:cookies ){
            if("time".equals(c.getName())){
                //获取cookie对象中的value
                String value = c.getValue();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = sdf.format(new Date(Long.parseLong(value)));
                writer.write(format);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
