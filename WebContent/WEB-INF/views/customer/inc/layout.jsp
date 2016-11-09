<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자</title>

<!-- css가져오기 -->
<link href="../css/layout.css" type="text/css" rel="stylesheet" />
<link href="../css/<tiles:getAsString name="css"/>" type="text/css" rel="stylesheet" />
<%-- <tiles:getAsString name="css" /> --%>

<%-- <script src="../js/modernizr-custom.js" type="text/javascript">
	document.createElement("main");
</script> --%>

<!-- Latest compiled and minified CSS -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
Optional theme
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
Latest compiled and minified JavaScript
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script> -->

</head>
<body>

	<!-- 이미지를 넣어줄때는 상대경로를 사용한다!. alt는 대체한다는뜻(뉴렉처 온라인 제목을 이미지로 대체함.원래있던 제목을 지우지는말것)  -->

	<!-- ------------------------------------------------------<헤더>----------------------------------------------------------------------- -->

	<!-- header 부분 -->
	<%-- <jsp:include page="../inc/header.jsp"></jsp:include> --%>
	<!-- tiles 방법 -->
	<!-- 레이아웃.xml속성을 가져와서 넣다 -->
	<tiles:insertAttribute name="header" />

	<!-- -------------------------------------------------------<visual>------------------------------------------------------------------- -->
	
	<!-- visual 부분 -->
	<%-- <jsp:include page="inc/visual.jsp"></jsp:include> --%>
	<%-- <tiles:insertAttribute name="visual" /> --%>

	<!-- -------------------------------------------------------<body>------------------------------------------------------------------- -->
	<div id="body">
		<div class="content-container clearfix">

			<!-- -------------------------------------------------------aside------------------------------------------------------------------- -->
			<%-- <jsp:include page="inc/aside.jsp"></jsp:include> --%>
			<%-- <tiles:insertAttribute name="aside" /> --%>
			<!-- -------------------------------------------------------메인------------------------------------------------------------------- -->
				<!-- main, content 부분 -->
				<tiles:insertAttribute name="main" />

		</div>
	</div>

	<!-- -------------------------------------------------------<footer>------------------------------------------------------------------- -->
	<!-- footer 부분 -->
	<%-- <jsp:include page="../inc/footer.jsp"></jsp:include> --%>
	<tiles:insertAttribute name="footer" />

</body>
</html>