<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty errors['GLOBAL'] }">
	<p style="color:red">请更正以下错误：</p>
	<p style="color:red">${errors['GLOBAL'] }</p>
</c:if>

<form action='<c:url value="admin/admin_Login.do"/>' method="post">
	用户名：<input type="text" name="username" value="${param.username }" />
	<i style="color:red">${errors['username'] }</i>
	<br/><br/>
	
	密&nbsp;&nbsp;码：<input type="password" name="password" value="${param.password }" />
	<i style="color:red">${errors['password'] }</i>
	<br/><br/>
	
	<input type="submit" value="登录" />&nbsp;&nbsp;
	<input type="reset" value="重置"/>
</form>