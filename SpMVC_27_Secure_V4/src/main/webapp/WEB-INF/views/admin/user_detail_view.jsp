<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<script>
	$(function() {
		/*
		$("#auth_append").click(function(){
			let auth_input = $("<input/>",{	class:"auth",name:"auth"})
			$("div#auth_box").append(auth_input)
		})
		 */
	})
</script>
<style>
section {
	margin: 10px auto;
	width: 70%;
}

form {
	width: 100%;
	margin: 10px auto;
}

form label {
	display: inline-block;
	width: 150px;
	text-align: right;
}

form input.auth {
	display: block;
}
</style>
<section>
	<form:form modelAttribute="userVO">
		<div>
			<label for="username">UserName</label>
			<form:input path="username" readonly="true" />
		</div>
		<div>
			<label for="eamil">email </label>
			<form:input path="email" />
		</div>
		<div>
			<label for="phone">phone</label>
			<form:input path="phone" />
		</div>
		<div>
			<label for="address">address</label>
			<form:input path="address" />
		</div>
		<div>
			<label for="address">계정 활성화 </label>
			<form:checkbox path="enabled" />
		</div>
		<div id="auth_box">
			<button id="auth_append" type="button">권한 설정</button>
			<c:if test="${not empty userVO.authorities}">
				<c:forEach items="${userVO.authorities }" var="auth">
					<input name="auth" value="${auth.authority }" class="auth">
				</c:forEach>
			</c:if>
		</div>
		<div>
			<button type="button" id="btn_save">저장</button>
		</div>
	</form:form>
</section>






