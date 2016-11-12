<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- empty = 값이 NULL 일 경우 true를 반환함 -->
<c:if test="${empty param.p}">
	<c:set var="page" value="1" />
</c:if>
<c:if test="${not empty param.p}">
	<c:set var="page" value="${param.p}" />
</c:if>

<c:set var="start" value="${page-(page-1)%5}" />
<c:set var="end" value="${fn:substringBefore((count%10==0?count/10:count/10+1),'.')}" />

<div>
	<div>
		<a href="detail?p=${(start==1)?1:start-1}">이전</a>
	</div>
	<ul>
		<!-- items에서 꺼내서 begin ~ end까지
			items를 안쓰면 그냥 begin ~ end까지 -->
		<c:forEach var="i" begin="0" end="4">
			<c:if test="${start+i <= end}">
				<c:if test="${start+i==page}">
					<!-- empty : null가 빈문자인지 비교함 -->
					<li><a href="detail?p=${start+i}"
						Class="strong">${start+i}</a></li>
					<!-- ★항상 보여지는것은 삼박자로 이루어져야함  p,t,q가 없든 있든 같이 받아져야함. -->
				</c:if>
				<c:if test="${start+i!=page}">
					<li><a href="detail?p=${start+i}"></a></li>
				</c:if>
			</c:if>

		</c:forEach>
	</ul>
	<div>
		<a href="detail?p=${start+5}">다음</a>

	</div>
</div>