package com.JinMin.week5.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name ="LoginServlet",value="/login")

public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
            con = DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"), getServletConfig().getServletContext().getInitParameter("username"), getServletConfig().getServletContext().getInitParameter("password"));
            System.out.println("hello"+con);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sql = "select * from  Usertable where username = ? and password = ?";
        PreparedStatement rs = null;
        PrintWriter writer = response.getWriter();
        try {
            rs = con.prepareStatement(sql);
            rs.setString(1, username);
            rs.setString(2, password);
            if(rs.executeQuery().next()){
                writer.println("successful!!!");
                writer.println("Welcome," + username );
            }else{
                writer.println("Username or Password Error!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
