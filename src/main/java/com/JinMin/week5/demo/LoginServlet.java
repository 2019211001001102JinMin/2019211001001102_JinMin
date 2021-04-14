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
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sql = "select id,username,password,email,gender,birthdate from  Usertable where username = ? and password = ?";

        PrintWriter writer = response.getWriter();
        try {

            ResultSet rs =con.createStatement().executeQuery(sql);
            username = rs.getString("username");
            password = rs.getString("password");
            if(rs.next()){
               // writer.println("successful!!!");
                //writer.println("Welcome," + username );


                request.setAttribute("id",rs.getInt("id")) ;
                request.setAttribute("username",rs.getString("username")) ;
                request.setAttribute("password",rs.getString("password")) ;
                request.setAttribute("email",rs.getString("email")) ;
                request.setAttribute("gender",rs.getString("gender")) ;
                request.setAttribute("birthdate",rs.getString("birthdate")) ;
                request.getRequestDispatcher("userInfo.jsp").forward(request ,response );

            }else{
               // writer.println("Username or Password Error!");
                request.setAttribute("message","Username or Password Error!!!") ;
                request.getRequestDispatcher("login.jsp").forward(request ,response );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
    /*@Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
*/
}
