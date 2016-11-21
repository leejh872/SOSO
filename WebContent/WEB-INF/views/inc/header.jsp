<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div id="header" class="content-container">
	<h1>
		<a href="${ctx}/main" class="link">SOSOHEA</a>
	</h1>
	<section id="menu">


		<section id="search-form">
			<form action="main" method="post">
				<fieldset>
					<input name="q" placeholder="# tag" value=${param.q}> <input
						type="submit" value="검색" />
				</fieldset>
			</form>
		</section>


		<!-- <section id="search">
			<form>
				<input name="q" placeholder="# tag" value=${param.q}> 
				<input type="submit" value="검색" />
			</form>
		</section>
		</br> </br>
		</section> -->
		</br> </br>
		<nav id="main-menu" class="h-menu">
			<ul>
			
				 <security:authorize ifAnyGranted="ROLE_ADMIN">
				 <li><a href="${ctx}/admin/main" class="link">ADMIN</a></li>
				 </security:authorize>
				 <c:if test="${empty pageContext.request.userPrincipal}">
				 <li><a href="${ctx}/joinus/login" class="link">JOIN/LOGIN</a></li>
				 </c:if>
				 <c:if test="${not empty pageContext.request.userPrincipal}">
				 <li><a href="${ctx}/j_spring_security_logout" class="link">
				 <%-- <security:authentication property="name"/> --%>LOGOUT</a>
				 </li>
				</c:if>

				<li class="sub-menu"><a href="${ctx}/customer/mypage"
					class="link">MY PAGE</a>
					<table class="submenu">
						<tr>
							<td><a href="${ctx}/customer/mypage"
								class="submenuLink link">MY PHOTO</a></td>
						</tr>
						<tr>
							<td><a href="${ctx}/customer/likespage"
								class="submenuLink link">LIKES</a></td>
						</tr>
					</table></li>
				<li><a href="${ctx}/aboutus" class="link">ABOUT US</a></li>
			</ul>
		</nav>
	</section>
</div>