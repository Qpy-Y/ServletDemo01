package cn.test.ServletResponse;
//响应图片
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "ServletRespDemo03", value = "/ServletRespDemo03")
public class ServletRespDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过相对路径获取绝对路径
        String realPath = getServletContext().getRealPath("/img/paojie.jpg");
        //1.创建字节输入流对象，关联图片路径
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(realPath));
        //2.通过响应对象获取字节输出流对象
        ServletOutputStream os = response.getOutputStream();

        //3.循环读取
        byte[] arr = new byte[1024];
        int len;
        while((len=bis.read(arr))!=-1){
            os.write(arr,0,len);
        }
        bis.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
