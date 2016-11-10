<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div id="header" class="content-container">
	<h1>
		<a href="${ctx}/main" class="link">SOSOHEA</a>
	</h1>
	<section id="menu">
		<section>
			<form id="search">
				<input name="q" value=${param.q} > <input type="submit"
					value="검색" />
			</form>
		</section>
		<nav id="main-menu" class="h-menu">
			<ul>
				<c:if test="${empty sessionScope.email}">
					<li><a href="${ctx}/joinus/login" class="link">JOIN/LOGIN</a></li>
				</c:if>
				<c:if test="${not empty sessionScope.email}">
					<li><a href="${ctx}/joinus/logout" class="link">LOGOUT</a></li>
				</c:if>
				<%-- <li><a href="${ctx}/joinus/login" class="link">JOIN/LOGIN</a></li> --%>
				<li><a href="${ctx}/customer/mypage" class="link">MY PAGE</a></li>
				<li><a href="${ctx}/aboutus" class="link">ABOUT US</a></li>
			</ul>
		</nav>
	</section>
</div>