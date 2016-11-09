
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<main>
		<div class="content-container">
			<form action="join" method="post">
				<fieldset id="join-form">
				<label>Welcome</label>
					<table align="center" id="join-table" >
						<tr>
							<option></option>
						</tr>
						<tr>
							<td ><input type="text" name="cellphone" placeholder="ex)+82)010-1234-5678" value = "${j.cellphone}"></td>
						</tr>
						<tr>
							<td ><input type="text" name="email" placeholder="E-mail" value="${j.email}"></td>
						</tr>
						<tr>
							<td><input type="password" name="password" placeholder="Password" value="${j.password}"></td>
						</tr>
					</table>
					<div id="join-menu">
						<div id="radio"><input type="radio" name="gender" value="M">M</div>
						<div id="radio"><input type="radio" name="gender" value="W">W</div>
						<div>
							<a href ="joinsuccess" class="link">
							<!-- <button type="button" name="join" class=" join-button">Join</button> -->
							<input type="submit" value="join"  class=" join-button"/>
							</a>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</main>
