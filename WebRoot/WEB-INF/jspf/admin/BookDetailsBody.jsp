<%@page import="com.oracle.bir.domain.Book"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.oracle.bir.service.BookService"%>

<% 
	String bidStr = request.getParameter("no");
	int bid = Integer.parseInt(bidStr);
	BookService bookSvc = BookService.getBookSvc();
	Book book = bookSvc.getDetails(bid);
	pageContext.setAttribute("book", book);
%>

<ul style="list-style:none;">
 <li>书名：${book.name }</li>
 <br/><br/>
 <li>类别：
 	<c:forEach begin="0" end="4" var="index">
 		<c:forEach var="c" items="${book.category }">
 			<c:if test="${c eq bookSvc.category[index] }">
 				${bookSvc.categorys[index] },&nbsp;
 			</c:if>
 		</c:forEach>
 	</c:forEach>
 </li>
 <br/><br/>
 <li>作者：${book.author }</li>
 <br/><br/>
 <li>折扣：
 	<c:forEach begin="0" end="4" var="index">
 		<c:if test="${book.discount eq bookSvc.discount[index] }">
 			${bookSvc.discounts[index] },&nbsp;
 		</c:if>
 	</c:forEach>
 </li>
 <br/><br/>
 <li>价格：${book.price }</li>
 <br/><br/>
 <li>数量：${book.amount }</li>
 <br/><br/>
 <li>简介：${book.profile }</li>
</ul>
