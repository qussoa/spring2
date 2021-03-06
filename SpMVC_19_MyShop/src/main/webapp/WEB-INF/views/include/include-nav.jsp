<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<nav class="navbar navbar-expand-sm bg-light">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="${rootPath}">Home</a></li>

			<sec:authorize access="isAnonymous()">
				<li class="nav-item"><a class="nav-link"
					href="${rootPath}/auth/login">로그인</a></li>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">

				<form id="logout" method="POST" action="${rootPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}">
					<li class="nav-item"><a class="nav-link logout" href="#">로그아웃</a></li>
				</form>

			</sec:authorize>
			<sec:authorize access="hasRole('ADMIN')">
				<li class="nav-item"><a class="nav-link"
					href="${rootPath}/admin/">관리자</a></li>
			</sec:authorize>
		</ul>
	</nav>