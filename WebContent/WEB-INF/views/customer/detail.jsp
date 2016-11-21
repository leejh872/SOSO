<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<main>

<div class="content-container-detail">

	<div class="content-container-detail-top">
		<div class="left">
			<!-- ${empty pn} -->
			<c:if test="${empty pn}">
            	<!-- 이전글이 없습니다. -->
         </c:if>
			<c:if test="${not empty pn}">
				<a class="link" href="detail?code=${pn.code}"><img src="${ctx}/resource/images/left.png" width="30" height="30"/></a>
			</c:if>
		</div>
		<div class="left">
			<c:if test="${empty nn}">
            	<!-- 다음글이 없습니다. -->
         </c:if>
			<c:if test="${not empty nn}">
				<a class="link" href="detail?code=${nn.code}"><img src="${ctx}/resource/images/right.png" width="30" height="30"/></a>
			</c:if>

		</div>


		<div class="right">
			<a href="detail-post-del?pcode=${p.code}" class="link">삭제</a>
		</div>
	</div>

	<h1 class="hidden">사진상세보기</h1>
	<!--  <a href="detail-like?plcode=${p.code}">-->
	<div id="photo" class="content-container"></div>
	
	<%-- <img src = "${ctx}/customer/upload${p.photo}" width="380" height="450"/> --%>

	<%-- <div class="text">
				<form action="detail" method="post"/>
				<table>
					<tr>
						<td></td>
						<td><input type="submit" value="♡"/></td>
					</tr>
					<tr>
						<td>조회수</td>
						<td>좋아요</td>
					</tr>
					<tr>
						<td>${p.hit}</td>
						<td>${pl}</td>
					</tr>
				</table>
				</form>
			</div> --%>

	<!-- </a> -->
	<div id="story">
		<table>
			<tbody>
				<tr>
					<c:forEach var="t" items="${list}">
						<td>${t.name}</td>
						<c:if test="${t.code == 3}">
				</tr>
				<tr>
					</c:if>
					</c:forEach>
				</tr>
				<tr>
					<td colspan="7" class="right"><fmt:formatDate
							pattern="yyyy-MM-dd hh:mm:ss" value="${p.regdate}" /></td>
				</tr>
				<tr>
					<td colspan="7">${p.story}</td>
				</tr>
			</tbody>
		</table>
		<br />
	</div>
</div>
</main>