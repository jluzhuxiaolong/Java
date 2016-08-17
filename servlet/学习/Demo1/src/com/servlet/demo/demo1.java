package com.servlet.demo;

import  java.io.*;
import  javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import  javax.servlet.http.*;
import  javax.servlet.*;

/**
 * Created by Administrator on 2016/8/17.
 */
@WebServlet("/Demo1")
public class demo1 extends HttpServlet {

    @Resource(name="name")
    private  String userName;
    @Resource(name="passWord")
    private  String userPassWord;

    @Override
    public  void doGet(HttpServletRequest request,HttpServletResponse response)
        throws  ServletException, IOException{

        String name = request.getParameter("name");
        String passWord = request.getParameter("passWord");

        PrintWriter pw = response.getWriter();
        pw.write("<html>");
        pw.write("<head>");
        pw.write("<title>Servlet demo1</title>");
        pw.write("</head>");
        pw.write("<body>");
        pw.write("<form action='/Demo1' method='post' enctype='application/x-www-form-urlencoded '>");
        pw.write("name:<input type='text' name='name' id='name'/>");
        pw.write("passWord:<input type='password' name ='passWord' id='passWord'/>");
        pw.write("<button type='submit'>submit</button>");
        if(name!=null&& passWord!=null&&name!="") {
            pw.write("passWord:<input type='text' name ='passWord1' id='passWord1'value='"+passWord+"'/>");
            pw.write("name:<input type='text' name ='name1' id='name1'value='"+name+"'/>");
        }
        pw.write("</form>");
        pw.write("</body>");
    }

    @Override
    public  void doPost(HttpServletRequest request,HttpServletResponse response)
        throws  ServletException, IOException{
        String name = request.getParameter("name");
        String passWord = request.getParameter("passWord");
        if(name.equals(userName)&& passWord.equals(userPassWord)){
            request.getRequestDispatcher("index.jsp").forward(request,response);
            return;
        }
        doGet(request,response);
    }
}
