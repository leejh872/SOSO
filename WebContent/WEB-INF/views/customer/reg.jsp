<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload Page</title>
<link href="../css/SosoMain.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="content-container">
		<h1>
			<a href="main" class="link">SOSOHEA</a>
		</h1>
		<form action="reg" method="post" enctype="multipart/form-data">
			<fieldset>
				<legend></legend>
				<table border="1">
					<tbody>
						<tr>
							<td>ADD IMAGES</td>
							<%-- <!-- name 키값을 전달함 -->
							<td colspan="3"><input type="text" name="photo"
								value="${n.photo}" /></td> --%>
						</tr>
						<tr>
							<td>첨부파일</td>
							<td><input type="file" name="file" /></td>
							<!--이름이 똑같으면 배열로 간대요.  -->
						</tr>
						<tr>
							<td><textarea name="story" rows="20" cols="60">${n.story}</textarea></td>
						</tr>
					</tbody>
				</table>
				<!-- name 키값을 전달함 -->

				<div>
					<!-- name 키값을 전달함 -->
					'; <input type="submit" value="등록" /> <a href="notice">취소</a>
				</div>
			</fieldset>
		</form>
		</tbody>
		</table>
	</div>
</body>
</html>