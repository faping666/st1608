<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>名片管理</title>
</head>
<body>
	<!-- <form action="/tests/list.sw" method="post">
		姓名:<input type="text" name="name"> 性别:<input type="radio"
			name="sex" value="A" checked="checked">全选<input type="radio"
			name="sex" value="m">男<input type="radio" name="sex"
			value="f">女   所属名片夹:<select name="ctid">
			<option value="A">请选择</option>
			<c:forEach items="${calist}" var="c">
				<option value="${c.ctid}">${c.ctname}</option>
			</c:forEach>
		</select> <input type="submit" value="查询">
	</form> -->
	<a href="/tests/add.sw">添加名片</a>
	<table border="1">
		<tr>
			<td>姓名</td>
			<td>性别</td>
			<td>家庭电话</td>
			<td>办公电话</td>
			<td>所属公司</td>
			<td>所属名片夹</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${clist}" var="c">
			<tr>
				<td>${c.name }</td>
				<td>${c.sex eq "m" ? "男" :"女"}</td>
				<td>${c.homeTelNum }</td>
				<td>${c.officeTelNum }</td>
				<td>${c.company }</td>
				<td>${c.cardtype.ctname }</td>
				<td><a href="/tests/update/${c.cid}.sw">修改</a>  <a href="/tests/delete/${c.cid}.sw">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>