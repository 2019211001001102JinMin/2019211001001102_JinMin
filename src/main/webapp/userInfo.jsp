<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/4/14
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<table>
    <tr><td>username:</td><td><%=request.getAttribute("username") %></td></tr>
    <tr><td>passage:</td><td><%=request.getAttribute("password") %></td></tr>
    <tr><td>email:</td><td><%=request.getAttribute("email") %></td></tr>
    <tr><td>gender:</td><td><%=request.getAttribute("gender") %></td></tr>
    <tr><td>birthdate:</td><td><%=request.getAttribute("birthdate") %></td></tr>
</table>
<%@include file="footer.jsp"%>