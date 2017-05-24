<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.oracle.bir.service.BookService"%>

<% 
	pageContext.setAttribute("bookSvc", BookService.getBookSvc());
%>

<table style="text-align:left;">
  <tr style="text-align:center;background-color:#00f0f0">
    <th style="width:100">编号</th>
    <th>书名</th>
    <th style="width:100">作者</th>
    <th style="width:100">价格</th>
    <th style="width:100">数量</th>
    <th style="width:100"></th>
  </tr>
  <c:forEach var="book" items="${bookSvc.books }">
  <tr style="text-align:center;background-color:#00f0f0">
  	<td>${book.bid }</td>
    <td>${book.name }</td>
    <td>${book.author }</td>
    <td>${book.price }</td>
    <td>${book.amount }</td>
    <td><a href='<c:url value="admin/BookDetails.jsp?no=${book.bid }"/>'>详情</a></td>
  </tr>
  </c:forEach>
</table>



