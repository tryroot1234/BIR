<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>

  </head>
  
  <body>
	<h2>项目目标</h2>
 	<ul>
 		<li>仿真实现一个基于B/S的书籍库存登记系统</li>
 		<li>增量式开发，循序渐进完成项目</li>
 		<li>掌握Web应用程序编程和调试技巧</li>
 		<li>主要涉及以下主要知识点：</li>
 	</ul>
 	<ul>
 		<li>Model 2架构的实现</li>
 		<li>使用Servlet实现控制器、JSP实现视图</li>
 		<li>表单中各种组件的处理</li>
 		<li>使用HttpSession实现用户认证</li>
 		<li>页面使用可复用表示组件</li>
 		<li>使用DAO模式，通过DataSource访问数据库</li>
 		<li>在Web应用程序中整合MySQL数据库</li>
 	</ul>
  </body>
</html>
 	