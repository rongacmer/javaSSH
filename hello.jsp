<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jq/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<script>
	$(document).ready(function(){
		$("#USER").blur(function(){
			$.ajax({
				type:"post",
				url:"test.action",
				data:{"info":$("#USER").val()},
				success:function(data){
					$("#ts").html(data.info);
				}
			})
// 			$("#ts").html($("#USER").val());
// 			alert($("#USER").val());
		});
	})
</script>
<body>
	<input type="text" id="USER"><span id="ts"></span>
</body>
</html>