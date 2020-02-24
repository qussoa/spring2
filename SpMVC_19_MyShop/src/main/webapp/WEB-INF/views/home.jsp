<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<script>
	$(function() {
		$("a.logout").click(function() {
			$("#logout").submit()
		})
		/*
		$("#btn-search").click(
			function() {
				let product = $("#search-box").val()
				document.location.href = "${rootPath}/user/product/list?p_name="+ product
			})
*/
	})
</script>
<style>
* {
	justify-content: center;
	text-align: center;
}

.header {
	justify-content: center;
	text-align: center;
}

#form-box {
	text-align: center;
	justify-content: center;
	margin-top: 20px;
}
</style>
</head>
<body>
	<header class="jumbotron">
		<h3>MY SHOP</h3>
	</header>
<%@ include file="/WEB-INF/views/include/include-nav.jsp" %>

	<article>
		<form class="form-inline" id="form-box">
			<div class="form-group mx-sm-3 mb-2">
				<input type="text" class="form-control" id="search-box"	placeholder="상품이름">
			</div>
			<button type="button" class="btn btn-primary mb-2" id="btn-search">검색</button>
		</form>
	</article>
</body>
</html>




























