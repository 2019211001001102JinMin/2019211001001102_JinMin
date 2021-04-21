<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<h1><%= "Hello World!!!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>
-->
<%@include file="header.jsp"%>

<h2>Welcome to My Online Shop Home Page.</h2>
<form method="get" targer='_black' action="search"></form>
<input type="text" name="txt" size=30/>
<select name="search">
    <option value="baidu">Baidu</option>
    <option value="bing">Bing</option>
    <option value="google">Google</option>
</select>
<input type="submit" value="Search"/>
</form>
<br/>

<a href="hello-servlet">Hello Servlet-week1</a>
<br/>
<a href="Register.jsp">Register Servlet-week3</a>
<br/>
<a href="config">Config parameter-week4</a>
<br/>
<a href="Register.jsp">Register JDBC-week4</a>
<br/>
<a href="count.jsp">Count JSP page-week5</a>
<br/>
<a href="MyJsp.jsp">my JSP page-week5</a>
<br/>
<a href="index.jsp">include-week5</a>
<br/>
<a href="login.jsp">Login-week5</a>
<br/>


<%@include file="footer.jsp"%>
