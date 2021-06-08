package cn.test.ServletRequest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "ServletDemo03", value = "/ServletDemo03")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数信息
        //根据名称获取数据
        String parameter = request.getParameter("username");
        System.out.println(parameter);
        System.out.println("-------------");
        //根据名称获取所有数据
        String[] parameterValues = request.getParameterValues("hobby");
        for(String hobby:parameterValues){
            System.out.println(hobby);
        }
        System.out.println("-------------");
        //获取所有名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            String parameter1 = request.getParameter(s);
            System.out.println(s+"："+parameter1);
        }
        System.out.println("-------------");
        //获取所有参数的键值对
        Map<String, String[]> parameterMap = request.getParameterMap();
        for(String key:parameterMap.keySet()){
            String[] strings = parameterMap.get(key);
            System.out.print(key+"：");
            for(String value:strings){
                System.out.print(value+" ");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
