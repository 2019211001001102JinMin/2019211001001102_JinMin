package com.JinMin.week2.demo;

import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//now its just a java class
//extend HttpServlet
public class HelloWordServlet extends HttpServlet{
    public void doGet(HttpServletRequest request , HttpServletResponse response )
    throws IOException {
        //when client request method is GET - here - inside doGet()
        //we want to send Hello to client
        //we need to write Hello in response
        //get writer - java .io
        PrintWriter writer = response.getWriter();
        writer.println("Name:Jin Min");
        writer.println("ID:2019211001001102") ;
        Date d=new Date();
        String s=null;
        writer.println("Date and Time "+d);//that all
        //next we need to tell about this servlet to tomat - how ? - web.xml

    }
    public void doPost(HttpServletRequest request , HttpServletResponse response )
    {
        //when client request method is POST - here - inside doGet()

    }
}
