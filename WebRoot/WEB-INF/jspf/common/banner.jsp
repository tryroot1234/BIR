<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.getAttribute("adminUser"); %>

<table style="border:0; width:800; cellspacing:0; cellpadding:5; align:center">
	<tr style="face:Helevetica, san-serif;">
		<td style="width:500; text-align:center; font-size:40">${pageTitle }</td>
	</tr>
	<tr style="size:5; face:Helevetica, san-serif;">
		<c:if test="${not empty adminUser }">
			<td style="text-align:right;color:blue">当前用户：${adminUser.username } <a href='<c:url value="logout.do"/>'>退出</a></td>
		</c:if>
	</tr>
</table>

<hr>