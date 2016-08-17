package com.servlet.demo1;
import java.io.*;
import  javax.annotation.Resource;
import  javax.servlet.*;
import  javax.servlet.http.*;

/**
 * Created by Administrator on 2016/8/17.
 */
public class HelloWorldServlet extends HttpServlet {

    @Resource(name="Message")
    private  String msg;

    @Override
    public  void doGet(HttpServletRequest request,HttpServletResponse response)
    throws  ServletException, IOException{
        response.setCharacterEncoding("UTF-8");

        PrintWriter pw = response.getWriter();
        pw.write("<h1> "+msg+"</h1>");
        pw.flush();
        pw.close();
    }
}
