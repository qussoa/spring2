<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<script>
	$(function() {
		$("button").click(function() {
			let btn_id = $(this).attr("id")
			let url = "${rootPath}/"
			if (btn_id == "btn_delete") {
				url += "delete/${BBS.b_id}"
			} else if (btn_id == "btn_update") {
				url += "update/${BBS.b_id}"
			} else if (btn_id == "btn_list") {
				url += "list"
			}
			document.location.href = url

		})

		var toolbar = [ [ 'style', [ 'bold', 'italic', 'underline' ] ],
				[ 'fontsize', [ 'fontsize' ] ],
				[ 'font Style', [ 'fontname' ] ], [ 'color', [ 'color' ] ],
				[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
				[ 'height', [ 'height' ] ], [ 'table', [ 'table' ] ],
				[ 'insert', [ 'link', 'hr', 'picture' ] ],
				[ 'view', [ 'fullscreen', 'codeview' ] ]

		]

		$("#b_content").summernote({
			lang : 'ko-KR',
			placeholder : '본문을 입력하세요',
			width : '100%',
			toolbar : toolbar,
			height : '200px',
			disableDragAndDrop : false,
			callbacks : {
				onImageUpload : function(files, editor, isEdite) {
					for (let i = files.length - 1; i >= 0; i--) {
						// 파일을 1개씩 업로드할 함수
						upFile(files[i], this)
					}
				}
			}
		}) // end summer

		// ajax를 사용하여 파일을 서버로 업로드 수행하고
		// 실제 저장된 파일 이름을 받아서
		// summernote에 기록된 내용중 img src="" 변경
		function upFile(file, editor) {
			var formData = new FormData()
			// upfile 변수에 file 정보를 담아서
			// 보재기 위한준비
			// editor.insertImage
			// summernote의 내장함수를 callback 형태로
			// 호출해서 현재 summernote box에 표시하고자하는
			// 이미지의 src 부분을 url값으로 대치
			
			// img src="data:base64~!~`"
			// img src="UUID파일.jpg" 형태로 변경
			formData.append('upFile', file)
			
			$.ajax({
				url : "${rootPath}/image_up",
				type : "POST",
				data : formData,
				contentType : false,
				processData : false,
				enctype : "multipart/form-data",
				success : function(result) {
					alert(result)
					result = "${rootPath}/files/" + result
					$(editor).summernote('editor.insertImage', result)
				},
				error : function() {
					alert("서버통신오류")
				}
			})
		}
	})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	<section class="container-fluid">
		<fieldset>
			<form method="POST">
				<div class="form-group">
					<input name="b_writer" placeholder="작성자" value="${BBS.b_writer}"
						class="form-control">
				</div>

				<div class="form-group">
					<input name="b_subject" placeholder="제목" value="${BBS.b_subject}"
						class="form-control">
				</div>

				<div class="form-group">
					<textarea id="b_content" name="b_content" rows="10" cols="10">${BBS.b_content}</textarea>

				</div>
				<div class="form-group d-flex justify-content-end">
					<button type="button" class="btn btn-primary mr-2 active"
						id="btn_list">목록</button>
					<button class="btn btn-primary  mr-2" id="btn_update">저장</button>
					<button type="button" class="btn btn-success" id="btn_delete">삭제</button>

				</div>
			</form>
		</fieldset>
	</section>

</body>
</html>