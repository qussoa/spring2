<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
section {
	margin-bottom: 30px;
}

hr {
	background-color: skyblue;
}

img {
	width: 100%;
	vertical-align: top;
	border: 1px solid gray;
}

.shopimg {
	float: left;
	width: 550px;
}

.header {
	float: right;
	width: 440px;
}

.btn-class {
	margin-top: 50px;
	align-items: center;
	text-align: center;
}

.btn {
	margin-left: 30px;
	margin-top: 230px;
	width: 10%;
	height: 40px;
	font-size: 15px;
	box-sizing: border-box;
}
</style>
<section>
	<form action="">
		<div class="shopimg">
			<img src="/WEB-INF/spring/appServlet/img/empty.png">
		</div>

		<div class="header">
			<hr>
			<h1>상품이름</h1>
			<hr>
			<div class="product">
				<h3>가격</h3>
			</div>
		</div>
		<div class="btn-class">
			<button class="btn btn-primary">장바구니</button>
			<button class="btn btn-primary">바로구매</button>
		</div>
	</form>
</section>
<hr>
<div class="content0">
	<p>내용</p>
</div>