<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="ctx" value="${pageContext.request.contextPath}" />
<main>
<div>
	가입완료됨! <br /> <a href="${ctx}/main" class="link">
		<button type="button" name="main" class="link">main</button>
	</a>
</div>
</main>
