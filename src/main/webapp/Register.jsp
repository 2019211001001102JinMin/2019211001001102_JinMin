<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/3/17
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>

<form method="post" action="register"><!-- within doPost() in servlet-->
    <font>This is my register JSP page.</font><br/><br/>
    id<input type="text" name="id"/><br/>
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender:<input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="Female">Female<br/>
    birthdate:<input type="date" size="40" name="birthdate" placeholder="Date of Birth(yyyy-mm-dd)"/><br/>
    <input type="submit" value="Register" />

</form>
<%@include file="footer.jsp"%>
