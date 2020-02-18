<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<script>
	$(function() {
		$("#p_dcode").keyup(function(e) {

			const KEY_F10 = 121
			const KEY_F9 = 120
			const KEY_F8 = 119
			const KEY_F7 = 118

			if (e.keyCode == KEY_F9) {
				/*
					121 f10
					120 f9
					119 f8
					118 f7
				 */
				let search = $(this).val()
				let dept_url = "${rootPath}/admin/dept/list"

				let win_style = "toolbar=no,"
				win_style += "scrollvar=yes,"
				win_style += "top=500,"
				win_style += "left=500,"
				win_style += "width=400,"
				win_style += "height=400"
				window.open(dept_url, "_blank", win_style)
			}
		})
	})
</script>


<form:form action="${rootPath}/admin/product/detail"
	modelAttribute="productVO">
	<div class="container-fluid form-group row">
		<form:select path="p_bcode" class="custom-select-sm ">
			<div class="container-fluid row">
				<form:option value="0">품목선택</form:option>
				<form:option value="B0001">공산품</form:option>
				<form:option value="B0002">농산물</form:option>
				<form:option value="B0003">수산물</form:option>
		</form:select>
		<form:errors path="p_bcode" class="in-errors col-6" />
	</div>
	<div class="form-group">
		<div class="container-fluid row">
			<form:input path="p_dcode" class="custom-select-sm col-6" />
			<span id="d_name"></span>
		</div>
	</div>
	<div class="container-fluid row">

		<form:errors path="p_dcode" class="in-errors col-6" />
	</div>
	<div class="form-group">
		<form:input path="p_code" class="form-control" placeholder="상품코드" />
		<form:errors path="p_code" class="in-errors" />
	</div>
	<div class="form-group">
		<form:input path="p_name" class="form-control" placeholder="상품이름" />
		<form:errors path="p_name" class="in-errors" />
	</div>
	<div class="container-fluid form-group row">
		<form:input path="p_iprice" class="form-control col-6"
			placeholder="매입단가" />
		<form:errors path="p_iprice" class="in-errors" />
		<form:input path="p_oprice" class="form-control col-6"
			placeholder="판매단가" />
		<form:errors path="p_oprice" class="in-errors" />
	</div>
	<div class="form-group">
		<button>상세정보 입력</button>
	</div>


</form:form>
