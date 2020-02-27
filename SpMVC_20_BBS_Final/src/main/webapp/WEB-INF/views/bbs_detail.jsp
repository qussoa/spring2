<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
</head>
<header>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
</header>
<script>
	$(function() {
		/*
		$("button").click(function() {
			let txt = $(this).text()
			
			if(txt == '수정'){
			 document.location.href ="${rootPath}/update?b_id=${BBS.b_id}"	
			}else if(txt == '삭제'){
				if(confirm("삭제허실?")){
					document.location.replace("${rootPath}/delete/${BBS.b_id}")	
				}
			}else if(txt == '저장'){
				return false
			}
			}else{
				document.location.href = "${rootPath}/list"
			}
		}
		*/
		$("button").click(function() {
			let btn_id = $(this).attr("id")
			let url = "${rootPath}/"
			if (btn_id == "btn_delete") {
				url += "delete/${BBS.b_id}"
			} else if (btn_id == "btn_update") {
				url += "/update?b_id=${BBS.b_id}"
			} else if (btn_id == "btn_list") {
				url += "list"
			}
			document.location.href = url
		})
	})
</script>
<section>
	<div>
		<h2>${BBS.b_subject}</h2>
	</div>
	<ul class="list-inline">
		<li class="list-inline-item font-weight-bold text-info">${BBS.b_writer}</li>
		<li class="list-inline-item">&#124; &nbsp;NO.${BBS.b_id}</li>
		<li class="list-inline-item">&#124; &nbsp; ${BBS.b_date_time}</li>
	</ul>
	<hr>
	<div>${BBS.b_content }</div>

	<hr>
	<div>
		<p>댓글</p>
		<div class="form-group row ">
			<div class="col-sm-8 mx-3">
				<input class="form-control" type="text">
			</div>
			<div class="form-group row ">
				<button class="btn btn-info text-white btn-datg">댓글달기</button>
			</div>
		</div>
	</div>
	<hr>
	<article>
		<div class="form-group d-flex justify-content-center">
			<button class="btn btn-info text-white active mr-2" id="btn_list">목록</button>
			<button class="btn btn-info text-white mr-2" id="btn_update">수정</button>
			<button id="btn_delete" class="btn btn-info text-white" >삭제</button>
		</div>

	</article>

</section>