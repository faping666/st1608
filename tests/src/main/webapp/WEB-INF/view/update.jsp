<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改联系人</title>
</head>
<body>
<form action="/tests/update.sw" method="post">
姓名:<input type="hidden" name="cid" value="${c.cid}"><input type="text" name="name" value="${c.name}"> <br>
性别:<input type="radio" name="sex" value="m" ${c.sex eq "m" ? "checked" : ""}>男 <input type="radio" name="sex" value="f" ${c.sex eq "f" ? "checked" : ""}>女<br>
家庭电话:<input type="text" name="homeTelNum" value="${c.homeTelNum}"> <br>
办公电话:<input type="text" name="officeTelNum" value="${c.officeTelNum}"> <br>
所属公司:<input type="text" name="company" value="${c.company}"> <br>
所属名片夹:<select name="ctid">
<c:forEach items="${calist}" var="ca">
<option value="${ca.ctid}" ${c.ctid eq ca.ctid ? "selected" : ""}>${ca.ctname} </option>
</c:forEach>
</select>
<input type="submit" value="修改">

</form>
</body>
</html>