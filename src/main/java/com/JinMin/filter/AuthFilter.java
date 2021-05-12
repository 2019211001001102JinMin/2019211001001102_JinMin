package com.JinMin.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {


        //System.out.println("In AuthFilter before doFilter"+System.currentTimeMillis() );
        //HttpServletRequest request=(HttpServletRequest)servletRequest;
        //System.out.println(" getRequestURL "+request.getRequestURL());
        System.out.println("i am in LoggerFilter-->doFilter()- before servlet-(request come here)");

        chain.doFilter(request, response);
        System.out.println("i am in AuthFilter-->doFilter()- AFTER servlet (response come here)");
    }
}
