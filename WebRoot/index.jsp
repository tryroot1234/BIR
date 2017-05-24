<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<c:set var="pageTitle" scope="request">书籍库存登记系统(V2.0)</c:set>
<c:set var="subTitle" scope="request">首页</c:set>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${pageTitle }</title>
    
  </head>
  
  <body style="background-color:white">
    <table border='0' width='800' cellspacing='0' cellpadding='5' align='left'>
    	<tr>
    		<td width="300" align="center" valign="top">
    			<!-- 在此嵌入logo的表示片段 -->
    			<%@ include file="/WEB-INF/jspf/common/logo.jsp" %>
    		</td>
    		<td align="right">
    			<!-- 在此嵌入banner的表示片段 -->
    			<%@ include file="/WEB-INF/jspf/common/banner.jsp" %>
    		</td>
    	</tr>
    	<tr>
    		<td width="300" style="text-align:center;">
    			<!-- 在此嵌入导航菜单的表示片段 -->
    			<%@ include file="/WEB-INF/jspf/common/navigation.jsp" %>
    		</td>
    		<td>
    			<!-- 在此嵌入主体内容的表示片段 -->
    			<jsp:include page="/WEB-INF/jspf/indexBody.jsp"></jsp:include>
    		</td>
    	</tr>
    	<tr>
    		<td></td>
    		<td align="right">
    			<!-- 在此嵌入版权公告的表示片段 -->
    			<%@ include file="/WEB-INF/jspf/common/footer.jsp" %>
    		</td>
    	</tr>
    </table>
  </body>
</html>
