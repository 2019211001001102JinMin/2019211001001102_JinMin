<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/3/17
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form method="post" action="register"><!-- within doPost() in servlet-->
    <font>New User Registration!</font><br/><br/>
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender:<input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="Female">Female<br/>
    <input type="date" size="40" name="Date" placeholder="Date of Birth(yyyy-mm-dd)"/><br/>
    <input type="submit" value="Register" />

</form>
</body>
</html>
