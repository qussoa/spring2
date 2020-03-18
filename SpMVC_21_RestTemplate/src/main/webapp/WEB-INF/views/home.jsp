<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP page □□□</title>
</head>
<body>
	<form action="${rootPath}/search" method="GET">
		<select name="cat">
			<option value="NEWS">뉴스
			<option value="BOOK">도서
			<option value="MOVIE">영화
		</select> <input name="search" type="text" placeholder="검색어 입력">
	</form>
</body>
</html>