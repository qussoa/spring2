<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<script>
	$(function() {
		//summernote toolbar
		var toolbar = [ [ 'style', [ 'bold', 'italic', 'underline' ] ],
				[ 'fontsize', [ 'fontsize' ] ],
				[ 'fontstyle', [ 'fontname' ] ], [ 'color', [ 'color' ] ],
				[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
				[ 'height', [ 'height' ] ], [ 'table', [ 'table' ] ],
				[ 'insert', [ 'link', 'hr', 'picture' ] ],
				[ 'view', [ 'fullscreen', 'codeview' ] ]

		]

		$("#p_detail").summernote({
			lang : 'ko-KR',
			witdh : '100%',
			toolbar : toolbar,
			height : '500px',
			// 이미지 업로드는 불가능하나 이미지를 첨부하는 것만 가능
			// ture -> false
			disableDragAndDrop : false
		})
	})
</script>
<form:form 
	action="${rootPath}/admin/product/input" 
	modelAttribute="productVO">

	<div class="form-group">
		<form:textarea path="p_detail" 
		class="form-control" rows="" cols="" placeholder="상세정보"/>
	</div>
	<div class="form-group">
		<button>저장</button>
	</div>
</form:form>	