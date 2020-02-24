<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script>
	$(function() {
		$("#btn-cart").click(function() {
			
			let p_qty = parseInt($("#p_qty").val())
			
			if(p_qty <= 0){
				alert("수량은 0개 이상")
				return false
			}
			$.ajax({
				url : "${rootPath}/user/product/cart",
				type : "POST",
				data : {
					p_code : "${pVO.p_code}",
					p_oprice : "${pVO.p_oprice}",
					p_qty : p_qty,
					"${_csrf.parameterName}" :"${_csrf.token}"
				},
				success: function(result) {
					
					if(result == 'LOGIN_FAIL'){
						alert("먼저 로그인 수행")
					} else if(result =="OK"){
						if(confirm("상품을 담음" + "장바구니로 이동허쉴?")){
							document.location.href = "${rootPath}/user/product/cart_view"
						}	
					}		
					
				},
				error : function() {
					alert("서버통신오류")
				}
			})
			
			// document.location.href = "${rootPath}/user/product/cart?p_code=${pVO.p_code}"
			//		+ "&p_oprice=${pVO.p_oprice}" +"&p_qty=" + p_qty
		})		
	})
</script>
<style>
body {
	height: 100%;
}

.detail-li {
	list-style: none;
}

.product-container-box {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
}

.img-box {
	border: 1px solid black;
	width: 300px;
	height: 270px;
	margin: 3rem;
}

.btn-box {
	display: flex;
	justify-content: center;
	align-items: center;
}

#p-button {
	margin: 3px;
	width: 200px;
}

.producthtag {
	font-weight: bold;
}

p {
	white-space: pre-line;
}
</style>
<body>
	<div class="product-container-box">

		<div class="img-box">
			<img>
		</div>

		<div class="product-item-box">
			<div class="product-name">
				<h2 class="producthtag">${pVO.p_name}</h2>
				<hr />
			</div>
			<table>
				<tbody>
					<tr>
						<th>판매가</th>
						<td><fmt:formatNumber value="${pVO.p_oprice}" type="currency"
								currencySymbol="￦" /></td>
					</tr>
					<tr>
						<th>상품코드</th>
						<td>${pVO.p_code}</td>
					</tr>
					<tr>
						<th>제조사/공급사</th>
						<td>${pVO.p_dcode}</td>
					</tr>
					<tr>
						<th>구매수량</th>
						<td><input type="number" id="p_qty" name="p_qty" value="0"></td>
					</tr>
				</tbody>
			</table>
			<hr />
			<div class="btn-box">
				<button class="btn btn-primary" id="btn-cart">장바구니</button>
				<button class="btn btn-primary" id="btn-buy">바로구매</button>
			</div>
		</div>
	</div>



	<div class="container">
		<hr />
		<p>${pVO.p_detail}</p>
	</div>