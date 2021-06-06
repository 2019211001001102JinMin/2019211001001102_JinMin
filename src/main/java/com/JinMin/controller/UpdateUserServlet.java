package com.JinMin.controller;

import com.JinMin.dao.IUserDao;
import com.JinMin.dao.UserDao;
import com.JinMin.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;

@WebServlet(name="UpdateUserServlet",value="/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {

        con=(Connection)  getServletContext().getAttribute("con") ;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response) ;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        Date birthdate = Date.valueOf(request.getParameter("birthdate"));

        User u=new User(id,username,password,email,gender,birthdate);
        IUserDao iUserDao =new UserDao() ;

        try{
            if(iUserDao.updateUser(con,u) !=0){
                HttpSession session = request.getSession();
                session.setAttribute("user",u) ;
                request.getRequestDispatcher("accountDetails").forward(request,response) ;
            }else{
                request.setAttribute("message","Username or Password Error!!!") ;
                request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request ,response ) ;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
