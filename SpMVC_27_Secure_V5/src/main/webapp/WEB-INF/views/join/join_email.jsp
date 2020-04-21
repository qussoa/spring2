<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP page □□□</title>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<style type="text/css">
section.email_body {
	width: 80%;
	margin: 120px auto;
	display: flex;
	flex-flow: column;
	justify-content: center;
	align-items: center;
}

span#secret {
	display: none;
}
</style>
<script>
$(function() {
	$(document).on("click","#btn_email_ok",function(){
		let secret_key = $("span#secret").text()
		//alert(secret_key)
		let secret_value = $("input#email_ok").val()
		if(secret_value == ""){
			alert("인증코드를 입력한 후 버튼 클릭")
			$("input#email_ok").focus()
			return false
		}
		$.ajax({
			url : "${rootPath}/join/email_token_check",
			method : "POST",
			data : {
				"${_csrf.parameterName}" : "${_csrf.token}",
				secret_id : "${username}",
				secret_key : secret_key,
				secret_value : secret_value
			},
			success : function(result){
				//alert(result)
				document.location.replace("${rootPath}/user/login")
			},
			error : function(){
				alert("서버통신오류")
			}
			
		})		
	})
})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
	<section class="email_body">
		<h2>Email 인증</h2>
		<div>회원가입 Email 인증 수행</div>
		<form:form action="${rootPath}/join/join_last" modelAttribute="userVO">
			<div>
				<form:input type="email" path="email" placeholder="email" />
			</div>
			<c:choose>
				<c:when test="${JOIN == 'EMAIL_OK' }">
					<button>email 재전송</button>
					<p>E-mail을 열어서 인증 후 입력란에 입력해주시오
					<div>
						<span id="secret">${MY_Email_Secret}</span> <input id="email_ok">
						<button type="button" id="btn_email_ok">인증하기</button>
					</div>
				</c:when>
				<c:otherwise>
					<button>email 인증</button>
				</c:otherwise>
			</c:choose>
		</form:form>
	</section>

</body>
</html>