<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<style>
.cart-list {
	border-bottom: 1px solid green;
	background-color: #ddd;
}
</style>
<c:choose>
	<c:when test="${empty CART_LIST }">
		<div>카트가 비었음</div>
	</c:when>
	<c:otherwise>
		<c:forEach items="${CART_LIST}" var="cart">
			<div class="cart-list">
				<p>상품이름 : ${cart.p_name}</p>
				<p>상품가격 : ${cart.p_oprice}</p>
				<p>수량 : ${cart.p_qty}</p>
			</div>
		</c:forEach>

	</c:otherwise>
</c:choose>
