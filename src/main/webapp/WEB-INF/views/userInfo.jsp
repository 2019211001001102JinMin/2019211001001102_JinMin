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
    User user=(User)request.getAttribute("user") ;
%>
<table>
    <tr><td>username:</td><td><%=user.getUsername() %></td></tr>
    <tr><td>passage:</td><td><%=user.getPassword() %></td></tr>
    <tr><td>email:</td><td><%=user.getEmail() %></td></tr>
    <tr><td>gender:</td><td><%=user.getGender() %></td></tr>
    <tr><td>birthdate:</td><td><%=user.getBirthdate() %></td></tr>
</table>
<%@include file="footer.jsp"%>