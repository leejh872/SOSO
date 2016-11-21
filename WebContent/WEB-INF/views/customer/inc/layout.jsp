<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자</title>

<!-- css가져오기 -->
<link href="${ctx}/resource/customer/css/layout.css" type="text/css"
	rel="stylesheet" />
<link
	href="${ctx}/resource/customer/css/<tiles:getAsString name="css"/>"
	type="text/css" rel="stylesheet" />

<!-- <script src="../js/modernizr-custom.js" type="text/javascript">
	document.createElement("main");
</script> -->

<script type="text/javascript">
var time = <fmt:formatDate pattern="yyyyMMddhhmmss" value="${p.regdate}" />;
	window.onload = function transferTime(time) {
		var now = new Date();
		var sYear = time.substring(0, 4);
		var sMonth = time.substring(4, 6) - 1;
		var sDate = time.substring(6, 8);
		var sHour = time.substring(8, 10);
		var sMin = time.substring(10, 12);
		var sSecond = time.substring(12, 14);
		var sc = 1000;

		var today = new Date(sYear, sMonth, sDate, sHour, sMin, sSecond);
		//지나간 초
		var pastSecond = parseInt((now - today) / sc, 10);

		var date;
		var hour;
		var min;
		var str = "";

		var restSecond = 0;
		if (pastSecond > 86400) {
			date = parseInt(pastSecond / 86400, 10);
			restSecond = pastSecond % 86400;
			str = date + "일 ";
			if (restSecond > 3600) {
				hour = parseInt(restSecond / 3600, 10);
				restSecond = restSecond % 3600;
				str = str + hour + "시간 ";
				if (restSecond > 60) {
					min = parseInt(restSecond / 60, 10);
					restSecond = restSecond % 60;
					str = str + min + "분 " + restSecond + "초 전";
				} else {
					str = str + restSecond + "초 전";
				}
			} else if (restSecond > 60) {
				min = parseInt(restSecond / 60, 10);
				restSecond = restSecond % 60;
				str = str + min + "분 " + restSecond + "초 전";
			} else {
				str = str + restSecond + "초 전";
			}
		} else if (pastSecond > 3600) {
			hour = parseInt(pastSecond / 3600, 10);
			restSecond = pastSecond % 3600;
			str = str + hour + "시간 ";
			if (restSecond > 60) {
				min = parseInt(restSecond / 60, 10);
				restSecond = restSecond % 60;
				str = str + min + "분 " + restSecond + "초 전";
			} else {
				str = str + restSecond + "초 전";
			}
		} else if (pastSecond > 60) {
			min = parseInt(pastSecond / 60, 10);
			restSecond = pastSecond % 60;
			str = str + min + "분 " + restSecond + "초 전";
		} else {
			str = pastSecond + "초 전";
		}

		var timeStr = document.getElementById("time-str");
		timeStr.innerText = transferTime();
		/* timeStr.value = str; */
		return str;
	}
		/* <fmt:formatDate pattern="yyyyMMddhhmmss" value="${p.regdate}" /> */
</script>



<!-- Latest compiled and minified CSS -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
Optional theme
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
Latest compiled and minified JavaScript
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 -->
</head>
<body>
	<!-- header 부분 -->
	<tiles:insertAttribute name="header" />

	<!-- visual 부분 -->
	<%-- <tiles:insertAttribute name="visual" /> --%>

	<!-- body 부분 -->
	<div id="body">
		<div class="content-container clearfix">

			<!-- aside 부분 -->
			<%-- <tiles:insertAttribute name="aside" /> --%>
			
				<!-- main, content 부분 -->
				<tiles:insertAttribute name="main" />

		</div>
	</div>

	<!-- footer 부분 -->
	<tiles:insertAttribute name="footer" />

</body>
</html>