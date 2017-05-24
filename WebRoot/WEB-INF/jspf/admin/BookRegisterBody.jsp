<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.oracle.bir.service.BookService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<c:if test="${not empty errors }">
	<p style="color:red">请更正以下信息：</p>
	<c:forEach var="error" items="${errors['GLOBAL'] }">
		<p style="color:red">${error }</p>
	</c:forEach>
</c:if>
<form action='<c:url value="admin/BookRegister.do"/>' method="post">
	<% 
		pageContext.setAttribute("bookSvc", BookService.getBookSvc());
	%>

	<input type="hidden" name="bid" value="${param.bid+1 }" />
	书名：<input type="text" name="name" value="${param.name }" />
	&nbsp;<i style="color:red">${errors['name'] }</i>
	<br/><br/>
	类别：
		<c:forEach begin="0" end="4" var="index">
			<input type="checkbox" name="category" value="${bookSvc.category[index] }"
				<c:forEach var="cate" items="${paramValues.category }" >
					<c:if test="${bookSvc.category[index] eq cate }">
						checked
					</c:if>
				</c:forEach>
			/>
			${bookSvc.categorys[index] }
		</c:forEach>
		&nbsp;<i style="color:red">${errors['category'] }</i>
	<br/><br/>
	作者：<input type="text" name="author" value="${param.author }" />
	&nbsp;<i style="color:red">${errors['author'] }</i>
	<br/><br/>
	折扣：
		<c:forEach var="d" items="${bookSvc.discounts }">
		<input type="radio" name="discount" value="${d }"
			<c:if test="${d eq param.discount }">
				checked
			</c:if>
		/>${d }
		</c:forEach>
		&nbsp;<i style="color:red">${errors['discount'] }</i>
	<br/><br/>
	价格：<input type="text" name="price" value="${param.price }" />
	&nbsp;<i style="color:red">${errors['price'] }</i>
	<br/><br/>
	数量：<input type="text" name="amount" value="${param.amount }" />
	&nbsp;<i style="color:red">${errors['amount'] }</i>
	<br/><br/>
	简介：<textarea rows="4" cols="40" name="profile">${param.profile }</textarea>
	&nbsp;<i style="color:red">${errors['profile'] }</i>
	<br/><br/>
	<input type="submit" value="登记" name="ok" />
	<input type="reset" value="重置" />
</form>
