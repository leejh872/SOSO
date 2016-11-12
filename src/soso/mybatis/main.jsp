<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%List photolist =  (List)request.getAttribute("PHOTO_LIST"); %>	
<c:set var="ctx" value="${pageContext.request.contextPath}" />

	<main>
	<div class="content-container">
	<div id="photo">${n.photo}</div>
		<%for (int i = 0 ; i < photolist.size() ; i ++) { %>
			<a href="${ctx}/customer/detail?code=1"><img src= "../images/<%=photolist.get(i) %>" width="300" height="300"/></a> 
		<%}%>

	</div>
	</main>
	