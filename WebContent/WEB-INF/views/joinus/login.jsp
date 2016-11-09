
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<main>
		<div class="content-container">
			<form action="../customer/main">
				<fieldset id="login-form">
					<table align="center" id="login-table" >
						<tr>
							<td ><input type="text" name="email" placeholder="ID"><a href="" class="link">asdasdasdadasdasds?</a></td>
						</tr>
						<tr>
							<td><input type="text" name="password" placeholder="PW"><a href="" class="link">Forgot?</a></td>
						</tr>
					</table>
					<div id="login-menu">
						<div id="checkbox"><input type="checkbox">Stay Logged In</div>
						<div>
							<button type="submit" name="login" class=" login-button">Login</button>
							<a href="join" class="link">
							<button type="button" name="join" class=" join-button">Join</button>
							</a>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</main>
