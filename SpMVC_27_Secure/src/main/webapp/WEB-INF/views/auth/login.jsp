<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<c:set var="rootPath" value="${pageCotext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
<script>
	$(function() {
		$(document).on("click", "button.join", function() {
			document.location.href = "${rootPath}/sec/user/join"
		})
	})
</script>
</head>

<style>
@font-face {
	font-family: 'MapoPeacefull';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/MapoPeacefullA.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

* {
	font-family: MapoPeacefull;
}

body {
	text-align: center;
	margin: 0 auto;
}

#box {
	position: absolute;
	width: 500px;
	height: 500px;
	left: 50%;
	top: 50%;
	margin-left: -250px;
	margin-top: -250px;
}

.login-head {
	text-align: center;
}

.input-set {
	justify-content: center;
	text-align: center;
	margin: 0 auto;
	margin-bottom: 5px;
}

.btn-set {
	margin: 10px;
}
</style>
<body>
	<div id="box">
		<form:form action="${rootPath}/user/join" method="POST">
			<header class="login-head">
				<h2>로그인</h2>
			</header>
			<div class="input-set">
				<div>
					<label>아이디</label>
				</div>
				<input id="username" name="username" placeholder="username">
			</div>
			<div class="input-set">
				<div>
					<label>비밀번호</label>
				</div>
				<input type="password" id="password" name="password"
					placeholder="password">
			</div>
			<div class="btn-set">
				<button type="button" id="login">로그인</button>
				<button type="button" class="join">회원가입</button>
			</div>
		</form:form>
		</div>

</body>
</html>