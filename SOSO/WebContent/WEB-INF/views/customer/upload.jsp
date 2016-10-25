<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>SOSOHEA</h1>
	<form action="notice-reg" method="post">
		<fieldset>
			<legend></legend>
			<table border="1">
				<tbody>
					<tr>
						<td>ADD IMAGES</td>					<!-- name 키값을 전달함 -->
						<td colspan="3" ><input type="text" name="photo" value="${n.photo}" /></td>
						<%-- --%>
					</tr>
				</tbody>
			</table>
					<div>
						<textarea name="story" rows="20" cols="60">${n.story}</textarea>
					</div>														<!-- name 키값을 전달함 -->

			<div>				<!-- name 키값을 전달함 -->
				<input type="submit" value="등록"/>
				<a href="notice">취소</a>
			</div>
		</fieldset>
	</form>
</tbody>
</table>
</body>
</html>