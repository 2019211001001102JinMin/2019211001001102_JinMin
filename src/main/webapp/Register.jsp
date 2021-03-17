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
<form>
    <font>New User Registration!</font><br/><br/>
    <input type="text" size="40"  value="Username" onfocus="if(value=='Username'){value=''}"
           onblur="if(value==''){value='Username'}" style="color:gray;background:#CCCCCC"><br/>
    <input type="password" size="40" minlenth="8" placeholder="password" style="color:gray;background:#CCCCCC"/><br/>
    <input type="email" size="40"name="email" placeholder="email" style="color:gray;background:#CCCCCC"/><br/>
    <label>
        <b>
            <font color="black">Gender</font>
        </b>
    </label>
    <input type="radio" name="sex" value="Male" checked/><font color="black">Male</font>
    <input type="radio" name="sex" value="Female" checked/><font color="black">Female</font><br/>
    <input type="date" size="40" name="Date" placeholder="Date of Birth(yyyy-mm-dd)"style="background: #CCCCCC"/><br/>
    <input type="submit" value="Register" style="background: chocolate"/><br/>

</form>
</body>
</html>
