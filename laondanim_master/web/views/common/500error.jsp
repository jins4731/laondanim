<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.msg002{
		text-align: center;
		color:skyblue;
	}
	.button{
		display:flex;
		justify-content:center;
	}
	button{
		margin:50px;
	}
			.ldBtn{
	    border-radius: 20px;
	    background-color: white;
	    border: 2px solid #00abbf;
	    color: #00abbf;
	    padding: 6px 15px 6px 15px;
	}
</style>
</head>
<body>
<div class="msg002">
	<img src="<%=request.getContextPath()%>/views/picture/icon/500error.jpg" alt="..." width="700px" height="500px">
</div>
<div class="button">
	<button class="ldBtn" onclick="location.replace('<%=request.getContextPath()%>')">메인으로</button>
</div>
</body>
</html>