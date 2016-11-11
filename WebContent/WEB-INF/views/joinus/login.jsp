
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<main>
	<div class="content-container">
		<c:if test="${not empty msg}">${msg}</c:if>
		<form method="post">
			<fieldset id="login-form">
				<table align="center" id="login-table">
					<tr>
						<td><input type="text" name="email" placeholder="ID" />
						<a href="" class="link"></a></td>
					</tr>
					<tr>
						<td><input type="password" name="password" placeholder="PW" /><a
							href="" class="link"></a></td>
					</tr>
				</table>
				<div id="login-menu">
					<!-- <div id="checkbox"><input type="checkbox">Stay Logged In</div> -->
					<div>
						<!-- <a href ="join"> -->
						<input type="button" name="join"  value="join" class=" join-button" onclick="location.href='join'";/>
						<!-- </a> -->
						<input type="submit" name="login" value="login" class=" login-button"/>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	</main>

