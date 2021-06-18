package com.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalServlet",value = "/CalServlet")
public class CalServlet extends HttpServlet {
    private int add(int firstVal,int secondVal){
        return firstVal+secondVal; }
    private int subtract(int firstVal,int secondVal){
        return firstVal-secondVal; }
    private int multiply(int firstVal,int secondVal){
        return firstVal*secondVal;
    }
    private double divide (int firstVal,int secondVal){
        return (firstVal+0.0)/secondVal;
    }
    private int computeLengthOfString(String s){
        return s.length();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int firstVal = Integer.parseInt(request.getParameter("firstVal"));
        int secondVal = Integer.parseInt(request.getParameter("secondVal"));
        String name = request.getParameter("name");
        String action = request.getParameter("action");
        System.out.println(action);

        if (action.equals("computeLength")){
            Cookie cName = new Cookie("cName", name);
            Cookie cLength  = new Cookie("cLength",String.valueOf(computeLengthOfString(name)));
            response.addCookie(cName);
            response.addCookie(cLength);
            response.sendRedirect(request.getContextPath()+"/lab3/cal.jsp");
        }else {
            String m = null;
            Cookie cFirstValue = new Cookie("cFirstValue", String.valueOf(firstVal));
            Cookie cSecondValue = new Cookie("cSecondValue", String.valueOf(secondVal));
            if (action.equals("add")){
                m = String.valueOf(add(firstVal, secondVal));
            }else if (action.equals("subtract")){
                m =  String.valueOf(subtract(firstVal,secondVal));
            }else if (action.equals("multiply")){
                m =  String.valueOf(multiply(firstVal,secondVal));
            }else {
                m =  String.valueOf(divide(firstVal,secondVal));
            }
            Cookie cResult = new Cookie("cResult", m);
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
            response.sendRedirect(request.getContextPath()+"/lab3/cal.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}