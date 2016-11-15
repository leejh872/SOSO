<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%List myphotolist =  (List)request.getAttribute("MYPHOTO_LIST"); %>	
<c:set var="ctx" value="${pageContext.request.contextPath}" />


	
	<main>
	<div class="content-container">
	<%for (int i = 0 ; i < myphotolist.size() ; i ++) { %>
	<div id="myphoto" class="left">${n.myphoto}</div>
			<a href="${ctx}/customer/detail?code=1"><img src= "${ctx}/customer/upload<%=myphotolist.get(i) %>" width="300" height="300"/></a> 
		<%}%>

	</div>
	</main>