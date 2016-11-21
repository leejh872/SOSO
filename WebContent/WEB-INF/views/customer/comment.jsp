<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
	
	<content>
			<div class="comment">
		<form action="detail" method="post">
			<fieldset>
				<table class="ctable">
					<thead>
						<tr>
							<input type="hidden" name="c_code" value="${p.code}" />
							<td colspan="4"><textarea name="content" rows="1" cols="100"></textarea></td>
							<td><input type="submit" value="등록" /></td>

						</tr>
					</thead>

					<tbody>
						<c:forEach var="c" items="${clist}">
							<tr>
								<td>${c.gender}</td>
								<td>${c.content}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
										value="${c.regdate}" /></td>
								<td>${c.writer_email}</td>
								<td><a href="detail-cmt-del?ccode=${c.code}" class="link">삭제</a></td>
							</tr>
						</c:forEach>
						<tr>
							<td>
								<%-- <c:if test="${empty param.p}">
									<c:set var="page" value="1" />
								</c:if> <c:if test="${not empty param.p}">
									<c:set var="page" value="${param.p}" />
								</c:if> <c:set var="start" value="${page-(page-1)%5}" /> <c:set
									var="end"
									value="${fn:substringBefore((count%10==0?count/10:count/10+1),'.')}" /> --%>

								<div>
									<h3 class="hidden">페이저</h3>
									<s:pager />
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</form>
	</div>
	</content>