package cn.test.ServletRequest;
//流对象获取数据   只支持post
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

@WebServlet(name = "ServletDemo07", value = "/ServletDemo07")
public class ServletDemo07 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  BufferedReader br = request.getReader();
        String line;
        while((line = br.readLine())!= null){
            System.out.println(line);
        }
        //br.close();*/

        //字节流
        ServletInputStream is = request.getInputStream();
        byte[] arr = new byte[1024];
        int len;
        while((len = is.read(arr))!= -1){
            System.out.println(new String(arr,0,len));
        }
        //is.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
