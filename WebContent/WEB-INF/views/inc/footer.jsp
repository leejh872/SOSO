<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<footer id="footer">
	<div class="content-container">
		<dl class="soso">
			<dt class="dt">CREATED BY SOSOHEA</dt>
		</dl>
		<button type="button" name="upload" class="upload_button">
			<a href="${ctx}/customer/reg" class="link">UPLOAD</a>
		</button>
	</div>
</footer>