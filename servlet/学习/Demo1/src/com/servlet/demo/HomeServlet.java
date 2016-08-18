package com.servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/8/18.
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {

    @Override
    public  void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException,IOException{

        PrintWriter pw = response.getWriter();

        pw.write("Home");
    }
}
