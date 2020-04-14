<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<body>
	<head>
		<h2>회원정보</h2>
	</head>
	<section>
		<div>
			<p>${userVO.username}</p>
			<p>${userVO.enabled}</p>
			<p>${userVO.email}</p>
			<p>${userVO.phone}</p>
			<p>${userVO.address}</p>
		</div>
	</section>
</body>