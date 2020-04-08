<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면!</title>
</head>
<body>
	<button onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="맛집"%>')">길잡이메인</button>
</body>
</html>