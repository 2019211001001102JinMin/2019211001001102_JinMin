<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/16
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="myForm" action="${pageContext.request.contextPath}/CalServlet" method="post">
    First val: <input id="firstVal" type="text" name="firstVal" value="${cookie.cFirstValue.value}">
    Enter a name：<input id="enterName" type="text" name="name" value="${cookie.cName.value}"><br>
    Second val：<input id="secondVal" type="text" name="secondVal" value="${cookie.cSecondValue.value}">
    Length：<input id="length" type="text" readonly value="${cookie.cLength.value}"><br>
    Result：<input id="result" type="text" readonly value="${cookie.cResult.value}"><br>
    <input id="hidden" type="hidden" name="action" value="">
    <button id="add" type="button">Add</button>
    <button id="subtract" type="button">Subtract</button>
    <button id="multiply" type="button">Multiply</button>
    <button id="divide" type="button">Divide</button>
    <button id="computeLength" type="button">Compute Length</button>
    <button id="reset" type="button">Reset</button>
    <br>
</form>
<script src="../js/jquery.js"></script>
<script>
    $('#add').click(function () {
        $("#hidden").attr("value","add");
        if(checkFormNum()){
            $('#myForm').submit();
        }
    })
    $('#subtract').click(function () {
        $('#hidden').attr("value","subtract");
        if(checkFormNum()){
            $('#myForm').submit();
        }
    })
    $('#multiply').click(function () {
        $('#hidden').attr("value","multiply");
        if(checkFormNum()){
            $('#myForm').submit();
        }
    })
    $('#divide').click(function () {
        $('#hidden').attr("value","divide");
        if(checkFormNum()){
            $('#myForm').submit();
        }
    })
    $('#computeLength').click(function () {
        $('#hidden').attr("value","computeLength");
        if(checkFormString()){
            $('#myForm').submit();
        }
    })
    $('#reset').click(function () {
        $('#firstVal').attr("value","");
        $('#secondVal').attr("value","");
        $('#enterName').attr("value","");
        $('#length').attr("value","");
        $('#result').attr("value","");
        $('#hidden').attr("value","");
    })
    function checkFormNum() {
        if (!checkNumber($('#firstVal').val())){
            alert("First val is not a number");
            return false;
        }
        if (!checkNumber($('#secondVal').val())){
            alert("Second val is not a number");
            return false;
        }
        return true;
    }
    function checkFormString() {
        if (checkString($('#enterName').val())){
            alert("Name is not valid");
            return false;
        }
        return true;
    }
    function checkNumber(theObj) {
        var reg = /^[0-9]+.?[0-9]*$/;
        return reg.test(theObj);
    }
    function checkString(str) {
        var reg=/\d/;
        return reg.test(str);
    }
</script>
</body>
</html>