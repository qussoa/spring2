<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<section class="container-fluid row">
	<article class="col-7 bg-light pro-input">
		<c:choose>
			<c:when test="${PRO_BODY == 'DETAIL'}">
				<%@ include file="/WEB-INF/views/admin/product-detail.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/admin/product-input.jsp"%>
			</c:otherwise>
		</c:choose>
	</article>

	<article class="col-4 bg-light list-body">
		<%@ include file="/WEB-INF/views/admin/product-list.jsp"%>
	</article>

</section>