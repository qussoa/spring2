<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<script type="text/javascript">
	$(function() {
		$("input").prop("readonly", true)

		$(document).on("click", "#btn_update", function() {
			
			let pass = $("#password").val()
			if(pass == ""){
				alert("수정하려면 비밀번호를 입력")
				$("div.password").css("display","block")
				$("#password").prop("readonly",false)
				$("#password").focus()
				return false
			}
			
			if (pass != "") {
				
				$.ajax({
					url : "${rootPath}/user/password",
					method : "GET",
					data : {password:pass},
					seccess : function(result){
						if(result == "PASS_OK"){
							$("input").prop("readonly", false)
							$("input").css("color", "blue")			
						} else{
							alert("비밀번호가 일치하지 않습니다")
						}
					},
					error:function(){
						alert("서버통신오류")
					}
				})
			}
		})
	})
</script>
<style>
section {
	position: fixed;
	top: 70px;
	left: 0;
	width: 100%;
}

form {
	width: 70%;
	margin: 10px auth;
}

form div.password {
	display: none;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
	<section>
		<form:form modelAttribute="userVO">
			<div>
				<form:input path="username" />
			</div>
			<div class="password">
				<input id="password" type="password" placeholder="비밀번호 입력">
			</div>
			<div>
				<form:input path="email" />
			</div>
			<div>
				<form:input path="address" />
			</div>
			<div>
				<button type="button" id="btn_update">수정</button>
				<button type="button" id="btn_delete">삭제</button>
			</div>
		</form:form>
	</section>
</body>
</html>