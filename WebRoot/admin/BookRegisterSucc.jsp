<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" scope="request">书籍库存登记系统(V2.0)</c:set>
<c:set var="mainBody" scope="request">admin/BookRegisterSuccBody.jsp</c:set>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="/WEB-INF/jspf/common/layout.jsp">
	<jsp:param value="登记成功" name="subTitle"/>
</jsp:include>

