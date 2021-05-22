<%@ page import="com.JinMin.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/4/14
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    Cookie [] allCookies =request.getCookies() ;
    for(Cookie c:allCookies ){
        out.println("<br/>"+c.getName()+" --- "+c.getValue() );
    }
%>
<%
    User u=(User) session.getAttribute("user") ;
%>
<table>
    <tr><td>username:</td><td><%=u.getUsername() %></td></tr>
    <tr><td>passage:</td><td><%=u.getPassword() %></td></tr>
    <tr><td>email:</td><td><%=u.getEmail() %></td></tr>
    <tr><td>gender:</td><td><%=u.getGender() %></td></tr>
    <tr><td>birthdate:</td><td><%=u.getBirthdate() %></td></tr>
    <tr>
        <a href="updateUser">Update</a>
    </tr>
</table>
<%@include file="footer.jsp"%>