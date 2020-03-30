<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP page □□□</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
section {
	border: 1px solid blue;
	padding: 1rem;
}
</style>
<script>
	$(function() {
		// jq의 이벤트 핸들러를 작성할 때
		// $("#call_ajax").click이라고 작성한다
		// ajax를 이용 서버로부터 나중에 가져온 페이지는 
		// 해당 이벤트 핸들러 작동이 안된다
		// ajax를 고려할 때 아래와 같은 핸들러를 작성을 하는것을 권장
		$(document).on("click","#call_ajax",function(){
			$.ajax({
				url :"${rootPath}/ajax",
				method : "GET",
				success : function(result){
					/*
					 서버에서 문자열을 return 하면
					 문자열을 신호로하여 클라이언트에서 처리
					*/
	//				alert(result)
				if(result =="OK"){
					alert("서버에서 OK를 보냄")
					}
				},
				error : function(){
					alert("서버통신오류")	
				}
			})
		})
	})
</script>
<script type="text/javascript">
// jsp 외부에서 script를 작성할때는
// el tag로 작성한 변수를 사용할 수 없기 때문에
// 임의로 스크립트
var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/resources/js/ajax.js"></script>
</head>
<body>
	<section id="main">
		<button id="call_ajax">Ajax 호출</button>
		<input type="text" id="msg" />
		<button id="call_msg">메시지 호출</button>
		<button id="call_addr">주소 호출</button>
		<button id="call_addr_view">주소 view 호출</button>
	</section>
	<section id="sub"></section>
</body>
</html>