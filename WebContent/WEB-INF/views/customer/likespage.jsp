<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<main>
		<div class="content-container">
<c:forEach  var="p" items="${photoList}">
			<a href="${ctx}/customer/detail?code=${p.postCode}">
			<div>${p.postCode}</div>
				<img src = "images/${p.photo}" width="300" height="300"/>
  			</a>
 		</c:forEach>
	</main>