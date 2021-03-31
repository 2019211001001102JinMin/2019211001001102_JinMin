package com.JinMin.week3.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "RegisterServlet", value = "/Register")

public class RegisterServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() {
        try {
            Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
            con = DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"), getServletConfig().getServletContext().getInitParameter("username"), getServletConfig().getServletContext().getInitParameter("password"));
            System.out.println("init()--> "+con);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");
        PrintWriter writer = response.getWriter();
        writer.println("<table border=\"1\">"+"<tr>"+"<td>id</td>"+"<td>username</td>"+"<td>password</td>"+"<td>email</td>"+"<td>gender</td>"+"<td>birthdate</td>"+"</tr>");


        try {
            Statement createDbStatement = con.createStatement();
            String insertRequire = "insert into usertable(id,username,password,email,gender,birthdate) values('"+id+"','" + username + "','" + password + "','" + email + "','" + gender + "','" + birthdate + "')";
            createDbStatement.executeUpdate(insertRequire);
            String sql = "select * from usertable";
            ResultSet rs = createDbStatement.executeQuery(sql);
            while (rs.next()) {
                id = rs.getString("id");
                username = rs.getString("username");
                password = rs.getString("password");
                email = rs.getString("email");
                gender = rs.getString("gender");
                birthdate = rs.getString("birthdate");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        writer.println("<td>" + id + "</td>" + "<td>" + username + "</td>" + "<td>" + password + "</td>" + "<td>" + email + "</td>" + "<td>" + gender + "</td>" + "<td>" + birthdate + "</td>" + "</tr>");


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
