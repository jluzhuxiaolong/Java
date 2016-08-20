package com.servlet.demo;

import com.model.User;
import com.mysql.demo.UserDAO;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/8/18.
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    @Resource
    private  String servletName;
    @Override
    public  void init() throws ServletException{

        System.out.println("Login Servlet init!");
    }

    @Override
    public  void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws  ServletException,IOException{

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        OutputStream os = response.getOutputStream();

        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> LogIn</title>");

        sb.append("</head>");
        sb.append("<body style='text-align:center;'>");
        sb.append("<form id='form' action='/Login' method='post' style='text-align:center;'>");
        sb.append("<div style='width:100%;text-align:center;'>");
        sb.append("<div style='width:400px;background-color:#f55ff;'>");
        sb.append("UserName:<input name='userName' type='text' />");
        sb.append("</br>");
        sb.append("PassWord:<input name='passWord' type='password' />");
        sb.append("</br>");
        sb.append("<img src='/Identity' /><input type='text' name='identity'/>");
        sb.append("</br>");
        sb.append("<button type='submit'> 登 录 </button>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</form>");
        sb.append("</body>");
        sb.append("</html>");
        os.write(sb.toString().getBytes());

        os.flush();
        os.close();
    }

    @Override
    public  void doPost(HttpServletRequest request,
                        HttpServletResponse response) throws  ServletException,IOException{
        String name = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        if(name==null||passWord==null||name.isEmpty()||passWord.isEmpty()){
            doGet(request,response);
            return;
        }

        String randomString = request.getSession().getAttribute("random").toString();
        UserDAO userDAO = new UserDAO();
        User user = null;
        try {
            user = userDAO.getUser(name);
            if(user!=null) {
                System.out.println("user.name:" + user.getName());
                System.out.println("user.age" + user.getAge());
            }else{
                System.out.println("user is null");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(!randomString.equals(request.getParameter("identity"))||user==null){

            doGet(request,response);
            return;
        }

        response.sendRedirect("/Home");
    }

    @Override
    public  void destroy(){
        System.out.println("Login Servlet destroy!");
    }
}
