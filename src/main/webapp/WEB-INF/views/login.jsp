<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/4/7
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> Login</h1>
<%
    if(!(request.getAttribute("message")==null)){
        out.println(request.getAttribute("message") );
    }
%>


<form method="post" action="login"><!-- within doPost() in servlet-->

    username: <input type="text" name="username"/><br/>
    password: <input type="password" name="password"/><br/>
    <input type="submit" value="Login" />

</form>
<%@include file="footer.jsp"%>
