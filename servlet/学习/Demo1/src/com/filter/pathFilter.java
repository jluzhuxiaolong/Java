package com.filter;

import javax.servlet.*;
import java.io.IOException;
import java.sql.SQLException;

import com.mysql.demo.*;

/**
 * Created by Administrator on 2016/8/19.
 */
public class pathFilter implements Filter {
    private  String name ;
    private  String passWord;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        name = filterConfig.getInitParameter("name");
        passWord = filterConfig.getInitParameter("password");
        System.out.println("name:" + name);
        System.out.println("password:"+passWord);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.print("doFilter");

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
