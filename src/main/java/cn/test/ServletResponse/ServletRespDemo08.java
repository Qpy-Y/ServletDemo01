package cn.test.ServletResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "ServletRespDemo08", value = "/ServletRespDemo08")
public class ServletRespDemo08 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String realPath = getServletContext().getRealPath("/img/paojie.jpg");
        //1.创建字节输入流对象，关联读取的文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(realPath));
        //2.设置响应头支持的类型
        /*
        Content-Type:消息头名称，支持的类型
        application/octet-stream 消息头参数 应用的类型为字节流
        */
        response.setHeader("Content-Type","application/octet-stream");
        //3.设置响应头以下载方式打开附件
        /*
        Content-Disposition:消息头名称，处理的形式
        attachment;filename=paojie.jpg 消息头参数 附件的形势处理 指定下载文件的名称
        */
        response.setHeader("Content-Disposition","attachment;filename=paojie.jpg");
        //4.获取字节输出流对象
        ServletOutputStream os = response.getOutputStream();
        //5.循环读写
        byte[] arr = new byte[1024];
        int len;
        while((len = bis.read(arr))!= -1){
            os.write(arr,0,len);
        }
        //6.释放资源
        bis.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
