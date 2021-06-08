package cn.test.ServletRequest;
//反射的方法封装对象
import cn.test.student.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

@WebServlet(name = "ServletDemo05", value = "/ServletDemo05")
public class ServletDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取所有数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装对象
        Student stu = new Student();
        //遍历集合
        for(String key:map.keySet()){
            String[] value = map.get(key);
            try {
                //获取Student对象的属性描述器
                PropertyDescriptor pd = new PropertyDescriptor(key,stu.getClass());
                //获取set方法
                Method writeMethod = pd.getWriteMethod();
                //执行方法
                if(value.length>1){
                    writeMethod.invoke(stu,(Object) value);
                }else{
                    writeMethod.invoke(stu,value);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println(stu);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
