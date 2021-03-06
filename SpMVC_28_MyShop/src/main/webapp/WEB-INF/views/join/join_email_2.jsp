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
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
	<section class="email_body">
		<h2>Email 인증</h2>
		<div>회원가입 Email 인증 수행</div>
		<form:form action="${rootPath}/join/joinok" modelAttribute="userVO">
			<form:input type="email" path="email" placeholder="email" />
			<c:if test="${empty userVO.email}">
				<button>email 인증</button>
			</c:if>
			<c:if test="${not empty userVO.email }">
				<button>email 재전송</button>
			</c:if>
			<c:choose>
				<c:when test="${JOIN == 'EMAIL_OK' }">
					<button>email 재전송</button>
				</c:when>
				<c:otherwise>
					<button>email 인증</button>
				</c:otherwise>
			</c:choose>
		</form:form>
	</section>

</body>
</html>