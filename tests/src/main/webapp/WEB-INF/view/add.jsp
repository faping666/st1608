<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加联系人</title>
</head>
<body>
<form action="/tests/add.sw" method="post">
姓名:<input type="text" name="name"> <br>
性别:<input type="radio" name="sex" value="m" checked="checked">男 <input type="radio" name="sex" value="f" >女<br>
家庭电话:<input type="text" name="homeTelNum"> <br>
办公电话:<input type="text" name="officeTelNum"> <br>
所属公司:<input type="text" name="company"> <br>
所属名片夹:<select name="ctid">
<c:forEach items="${calist}" var="c">
<option value="${c.ctid}">${c.ctname}</option>
</c:forEach>
</select>
<input type="submit" value="添加">
</form>
</body>
</html>