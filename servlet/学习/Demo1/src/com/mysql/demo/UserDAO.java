package com.mysql.demo;

import  com.model.*;

import java.sql.*;

/**
 * Created by Administrator on 2016/8/20.
 */
public class UserDAO {

    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/test";
    static  final  String USER="root";
    static final String PASS="1qaz2wsxE";
    private Statement getCreateStatement() {
        // 注册 JDBC 驱动器
        try {
            Class.forName(JDBC_DRIVER);
            // 打开一个连接
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行 SQL 查询
            return conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public User getUser(String name) throws SQLException {
        User user =new User();

        String sql = "select * from user where name = '"+name+"';";
        Statement stmt = getCreateStatement();
        ResultSet rs =stmt.executeQuery(sql);
        rs.next();
        System.out.println("row count :"+ rs.getRow());
        if(rs.getRow()>0){
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setSex(rs.getString("sex"));
        }else {
            user = null;
        }

        return  user;
    }

}
