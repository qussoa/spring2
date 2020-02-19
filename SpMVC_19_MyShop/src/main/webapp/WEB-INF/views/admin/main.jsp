<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<!DOCTYPE html>
<html>
<head>
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
}

.header {
	margin-top: 200px;
}

.in-errors {
	color: red;
	font-size: 8px;
}
/*
	col-md-7 col-12
	해상도가 768보다 크면 7칸만 차지하고
	그 이하이면 12칸을 차지하여 풀 width 로 보여라
*/
tr, td, th {
	white-space: nowrap;
}

.list-body {
	overflow: auto;
}

.p_name {
	display: inline-block;
	width: 150px;
	padding: 0 5px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
</style>
<script>
	$(function() {
	$("#btn-search").click(function() {
		let product = $("#search-box").val()
		document.location.href = "${rootPath}/user/product/list?p_name="
											+ product
			})
	})
</script>
</head>
<body class="container-xl">
	<header>
		<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
			<ul class="navbar-nav">
				<li class="navbar-item"><a class="nav-link" href="${rootPath}/">Home</a>
				</li>

				<li class="navbar-item"><a class="nav-link"
					href="${rootPath}/admin/product/">상품정보</a></li>
				<li class="navbar-item"><a class="nav-link" href="#">품목정보</a></li>
				<li class="navbar-item"><a class="nav-link"
					href="${rootPath}/admin/dept">거래처정보</a></li>

				<li class="navbar-item"><form:form action="${rootPath}/logout"
						name="logout_form">
						<a class="nav-link" onclick="document.logout_form.submit()"
							href="javascript:void(0)">로그아웃</a>
					</form:form></li>
			</ul>
		</nav>
	</header>
	<section>
		<header class="header">
			<h3>상품검색</h3>
		</header>
		<form class="form-inline" id="form-box">
			<div class="form-group mx-sm-3 mb-2">
				<label for="input" class="sr-only">상품이름</label> <input type="text"
					class="form-control" id="search-box">
			</div>
			<button type="button" class="btn btn-primary mb-2" id="btn-search">검색</button>
		</form>
		<c:choose>
			<c:when test="${BODY == 'PRODUCT'}">
				<%@ include file="/WEB-INF/views/admin/product.jsp"%>
			</c:when>
			<c:when test="${BODY == 'DEPT'}">
				<%@ include file="/WEB-INF/views/admin/dept.jsp"%>
			</c:when>
		</c:choose>
	</section>
</body>
</html>