<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main>
<div class="content-container">
	<h1>
		<a href="main" class="link">SOSOHEA</a>
	</h1>
	<form method="post" enctype="multipart/form-data">
		<fieldset>
			<legend></legend>
			<table border="1">
				<tbody>
					<tr>
						<td>ADD IMAGES</td>
						 <!-- name 키값을 전달함 -->
					</tr>
					<tr>
						<td>첨부파일</td>
						
							<td><input type="file" name="photo"/></td>
						<!--이름이 똑같으면 배열로 간대요.  -->
					</tr>
					<tr>
						<td><textarea name="story" rows="20" cols="60"></textarea></td>
					</tr>
					<tr>
						<td><textarea name="name" rows="20" cols="60"></textarea></td>
					</tr>
					
				</tbody>
			</table>
			<!-- name 키값을 전달함 -->

			<div>
				<!-- name 키값을 전달함 -->
			</div>
		</fieldset>
	<input type="submit" value="등록" /> <a href="notice">취소</a>
	</form>
</div>
</main>