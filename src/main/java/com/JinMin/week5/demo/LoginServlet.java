package com.JinMin.week5.demo;

import com.JinMin.dao.UserDao;
import com.JinMin.model.User;

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
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request ,response ) ;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao=new UserDao() ;
        User user=null;
        try {
            user = userDao.findByUsernamePassword(con, username, password);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        if(user!=null){

            /*Cookie c=new Cookie("sessionid",""+user.getId() ) ;
            c.setMaxAge(10*60) ;
            response.addCookie(c) ;*/

            String rememberMe=request.getParameter("remember") ;
            if(rememberMe!=null && rememberMe.equals("1") ){
                Cookie usernameCookie=new Cookie("cUsername",user.getUsername() );
                Cookie passwordCookie=new Cookie("cPassword",user.getPassword() );
                Cookie rememberMeCookie=new Cookie("cRememberMe",request.getParameter("RememberMe") );
                usernameCookie.setMaxAge(5) ;
                passwordCookie.setMaxAge(5) ;
                rememberMeCookie.setMaxAge(5) ;
                response.addCookie(usernameCookie ) ;
                response.addCookie(passwordCookie ) ;
                response.addCookie(rememberMeCookie ) ;

            }
            HttpSession session = request.getSession();
            System.out.println("session id-->"+session.getId()) ;
            session.setMaxInactiveInterval(10) ;

            session.setAttribute("user",user) ;
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp") .forward(request,response ) ;
            }else{
                request.setAttribute("message","Username or Password Error!!!") ;
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request ,response ) ;

            }

        /*
        String sql = "select id,username,password,email,gender,birthdate from  Usertable where username = ? and password = ?";


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
}
