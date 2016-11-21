<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

	<main>
		<div class="content-container">
	    	<c:forEach  var="s" items="${searchphotoList}">
				<a href="${ctx}/customer/detail?code=${s.post_code}">
					<img src = "${ctx}/resource/customer/upload/${s.photo}" width="300" height="300"/>
	  			</a>
	 		</c:forEach>
		</div>
	</main>