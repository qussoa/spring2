$(function() {
	/*
	 * input box에 입력한 문자열을 서버로 전송하고 서버에서 전달된 메시지에 따라 응답을 달리 처리하기
	 */
	$("#call_msg").click(function() {

		// alert("Message")
		$.ajax({
			url : rootPath + "/ajax/msg",
			method : "GET",
			data : {
				msg : $("#msg").val()
			},
			success : function(result) {
				if (result == "ERROR") {
					alert("서버에 전달하는 문자열이 잘못되었음")
				}
				alert(result)
			},
			error : function(error) {
				alert("서버통신 오류")
			}
		})
	})
	$(document).on("click", "#call_addr", function() {
		$.ajax({
			url : rootPath + "/ajax/addr",

			method : "GET",
			success : function(result) {
				alert(JSON.stringify(result))
				/*
				 * json으로 받은 객체 데이터를 HOTM tag로 묶어서 DOM문서를 ㅁ나들고
				 * 
				 */
				var addr = "<div>" + result.ad_name + "</div>"
				addr += "<div>" + result.ad_addr + "</div>"
				addr += "<div>" + result.ad_tel + "</div>"
				addr += "<div>" + result.ad_age + "</div>"
				$("#sub").html(addr)
			},
			error : function() {
				alert("서버통신오류")
			}
		})
	})
	$(document).on("click", "#call_addr_view", function() {
		$.ajax({
			url : rootPath + "/ajax/addr_view",
			success : function(result) {
				alert(result)
				$("#sub").html(result)
			}
		})

	})
	/*
	 * ad_name id인 tag는 ajax를 통해서 나중에
	 * 동적으로 붙여내기 하였다
	 * 이런경우 일반적인 click 이벤트는 작동을 하지 않느다
	 */
	//$("#ad_name").click(function() {
	$(document).on("click","#ad_name",function(){
		//alert($(this).text())
		/*
		 * 톰켓은 기본적으로 POST, GET method는 사용할 수 있는데
		 * PUT, DELETE 등의 RESTFull method는 사용 할 수 없도록
		 * 기본값이 막혀 있다
		 */
		$.ajax({
			url : rootPath + "/ajax/put",
			method : "PUT",
			data : {msg : $(this).text()},
			success : function(result){
				alert(result)
			},
			error : function() {
				alert("통신오류")
			}
		})
	})
})
