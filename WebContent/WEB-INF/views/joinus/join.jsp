
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<main>
		<div style = "color:skyblue" ><!-- 에러 메세지 뿌리기 -->
			<c:if test = "${not empty errorMsg}">
				<div>
				${errorMsg}
				</div>
			</c:if>
		</div>
		<div class="content-container">
			<form action="join" method="post">
				<fieldset id="join-form">
				<label>Welcome</label>
					<table align="center" id="join-table" >
						<tr>
							<option></option>
						</tr>
						<tr>
							<td>
							<input type="text" name="email" placeholder="E-mail" value="${email}">
							<input type="submit" name="btn" value="중복확인"/>
							<span>${duplicateResult}</span>
							</td>
						</tr>
						<tr>
							<td>
							<input type="password" name="password" placeholder="Password" value="${password}">
							</td>
						</tr>
						<tr>
							<td>
							<input type="text" name="cellphone" placeholder="ex)010-1234-5678" value="${cellphone}">
							</td>
						</tr>
					</table>
					<div id="join-menu">
						<div id="radio"><input type="radio" name="gender" value="M"/>M</div>
						<div id="radio"><input type="radio" name="gender" value="W"/>W</div>
						<div>
							<a href ="../main" class="link">
							<input type="submit" name="btn" value="join"  class=" join-button"/>
							</a>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</main>