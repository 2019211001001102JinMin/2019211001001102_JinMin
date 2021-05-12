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
<form method="get" target='_black' action="search"></form>
<input type="text" name="txt" size=30/>
<select name="search">
    <option value="baidu">Baidu</option>
    <option value="bing">Bing</option>
    <option value="google">Google</option>
</select>
<input type="submit" value="Search"/>
</form>

<%@include file="footer.jsp"%>
