<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
</head>
<script type="text/javascript">
	$(function() {
		$(document).on("click", "#btn-join", function() {

			let username = $("#username")
			let password = $("#password")
			let re_password = $("#re_password")

			if (username.val() == "") {
				alert("아이디를 입력")
				username.focus()
				return false;
			}
			if (password.val() == "") {
				alert("비밀번호를 입력")
				password.focus()
				return false
			}
			if (re_password.val() == "") {
				alert("비밀번호 재확인 입력")
				re_password.focus()
				return false
			}
			if (password.val() != re_password.val()) {
				alert("비밀번화 확인이 다름")
				return false
			}
			$("form").submit()
		})
		// 현재 입력박스에서 포커스가 벗어났을 때 발생하는 이벤트
		$(document).on("blur","#username",function(){
			let username = $(this).val()
			if(username == ""){
				$("#m_username").text("아이디는 반드시 입력")
				return false
			}
			$.ajax({
				url : "${rootPath}/sec/user/idcheck",
				method : "GET",
				data : {username : username},
				success : function(result) {
					if(result == "USE"){
						$("#m_username").text("이미 아이디가 존재함")
						$("#m_username").css("color","red")
						return false
					}
				},
				error : function() {
					//alert("서버통신오류")
				}
			})
		})
	})
</script>
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
.message{
	color : gray;
	font-weight: bold;
	font-size:0.3rem;
}
</style>
<body>
	<div id="box">
		<form:form method="POST">
			<header class="login-head">
				<h2>회원가입</h2>
				<%-- <input type="text" name="${_csrf.parameterName}" value="${_csrf.token }"> --%>
			</header>
			<div class="input-set">
				<div>
					<label>아이디</label>
					
				</div>
				<input id="username" name="username" placeholder="username">
				<div class="message" id="m_username"></div>
			</div>
			<div class="input-set">
				<div>
					<label>비밀번호</label>
				</div>
				<input type="password" id="password" name="password"
					placeholder="password">

				<div>
					<label>비밀번호 재입력</label>
				</div>
				<input type="password" id="re_password" name="password"
					placeholder="password">
			</div>
			<div class="btn-set">
				<button type="button" id="btn-join">회원가입</button>
				<button type="button" id="btn-loss">아이디/비밀번호 찾기</button>
			</div>
		</form:form>
	</div>
</body>
</html>