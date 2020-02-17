<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<style>
.in-errors {
	color: red;
	font-size: 8px;
}

tr, td, th {
	white-space: nowrap;
}

.dept-list {
	overflow: auto;
}

td.d_name {
	width: 30px;
	padding: 0 5px;
	overflow: hidden;
	text-overflow: ellipsis;
	display: inline-block;
}
</style>
<section class="container-fluid row">
	<article class="col-7 bg-ligth detp-input">
		<form:form action="${rootPath}/admin/dept/input" modelAttribute="deptVO">
			<div class="form-group">
				<form:input path="d_code" class="form-control" placeholder="거래처코드"/>
				<form:errors path="d_code" class="in-errors"/>
			</div>
			<div class="form-group">
				<form:input path="d_name" class="form-control" placeholder="거래처명"/>
				<form:errors path="d_name" class="in-errors"/>
			</div>
			<div class="form-group">
				<form:input path="d_ceo" class="form-control" placeholder="대표자명"/>
				<form:errors path="d_ceo" class="in-errors"/>
			</div>
			<div class="form-group">
				<form:input path="d_sid" class="form-control" placeholder="사업자번호"/>
				<form:errors path="d_sid" class="in-errors"/>
			</div>
			<div class="form-group">
				<form:input path="d_tel" class="form-control" placeholder="대표 전화번호"/>
			</div>
			<div class="form-group">
				<form:input path="d_addr" class="form-control" placeholder="주소"/>
			</div>
			<div class="form-group">
				<form:input path="d_manager" class="form-control" placeholder="담당자"/>
			</div>
			<div class="form-group">
				<form:input path="d_mtel" class="form-control" placeholder="담당자번호"/>
			</div>
			<div class="form-group">
				<form:input path="d_remark" class="form-control" placeholder="비고"/>
			</div>
			<div class="form-group">
				<button>저장</button>
			</div>			
		</form:form>
	</article>
	<article class="col-4 bg-ligth dept-list">

	</article>

</section>