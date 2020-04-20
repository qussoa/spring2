<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<style>
#body {
	display: flex;
	position: fixed;
	top: 60px;
	width: 100%;
	left: 0;
}

#body menu {
	flex: 1;
	border: 1px solid black;
	margin: 5px;
}

#body menu li {
	list-style: none;
}

#body menu li a {
	display: inline-block;
	padding: 5px 10px;
	text-decoration: none;
	width: 150px;
	margin: 10px;
	color: black;
}

#body menu li a:hover {
	background-color: black;
	color: white;
}

#body article {
	flex: 3;
	border: 1px solid black;
	margin: 5px;
}
</style>
<script>
	$(function(){
		$(document).on("click","#user_list",function(){
			$.get("${rootPath}/admin/user_list",function(result){
				$("#admin_content").html(result)
			})
		})
		$(document).on("click","tr.tr_user",function(){
			let username = $(this).data("id")
			$.get("${rootPath}/admin/user_detail_view/"+username,function(result){
				$("#admin_content").html(result)
			})
		})
		$(document).on("click","button#btn_save",function(){
			let formdata = $("form").serialize()
			$.post("${rootPath}/admin/user_detail_view",formdata,function(result){
				$("#admin_content").html(result)
			alert("update 성공")
			})
		})
		$(document).on("click","#auth_append",function(){
			let auth_input = $("<input/>",{	class:"auth",name:"auth"})
			$("div#auth_box").append(auth_input)
		})
	})

</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
	<section id="body">
		<menu>
			<h3>관리자 페이지</h3>
			<ul>
				<li><a href="javascript:void(0)" id="user_list">UserList</a></li>
				<li><a href="#">Menu 1</a></li>
				<li><a href="#">Menu 2</a></li>
			</ul>
		</menu>
		<article id="admin_content"></article>
	</section>
</body>
</html>