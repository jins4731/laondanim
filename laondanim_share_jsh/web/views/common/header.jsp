<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.laon.user.model.vo.User" %>	
<%
	User loginUser=(User)session.getAttribute("loginUser");
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/css/bootstrap-select.min.css">
<!-- naver SmartEditor -->
<script type="text/javascript" src="<%=request.getContextPath()%>/smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>




<title>라온다님 메인</title>
<style>
/* 헤더 푸터 값조절 */
html,body {
    margin:0;
	padding:0;
	height:100%;
	width: 100%;
}
header {
	width: 100%;
	height:160px;
	display: flex;
	position: absolute;
	z-index:10;
	top:0px;
	background-color: white;
	box-shadow: 0 0 15px #00acbfb3;
	justify-content: center;
}

#headerDiv{
	width: 1366px;
	height: 100%;
}
#logoNav a #laonLogo{
	width: 230px;
	margin-top: 50px;
}
section {
	display:flex;
	justify-content: center;
    padding:20px;
}

footer {
  /*   position:absolute; */
	bottom:0;
	width:100%;
	height:100px;   
	background:#00abbf;
    padding-top:20px;
	color: white;
	clear:both;
	text-align:center;
} 

/* body안의 전체를 감싸는 wrapper컨테이너 */
/* .body-wrapper{
	position:relative;
	min-height:100%;
} */
.mainTitle-container{
	margin-top:30px;
	margin-left:50px;
}

/* 글자색 통일 */
header a {
	text-decoration: none;
	color: #00abbf;
}

header li>a {
	/* border:1px solid black;*/
	
	padding-left: 30px;
	font-size: 20px;
	text-decoration: none;
}

.main-nav {
	list-style: none;	
}

	/* 메뉴에 마우스 커서만 올려도 드롭다운 메뉴가 자동으로 나오게 */
/* .dropdown:hover .dropdown-menu {
	display: block;
	margin-top: 0;
} */

</style>
</head>
<body style="position: absolute;" >
	<!-- <div class="body-wrapper"> -->
	<header>
		<div id="headerDiv" class="d-flex justify-content-center">
			<div id="logoNav" class="d-flex flex-column justify-content-center w-100">
				<a class="m-0 mt-2 align-items-start" href="<%=request.getContextPath()%>">
					<img src="<%=request.getContextPath()%>/main/laonLogo.png" class="m-0 p-0" id="laonLogo">
				</a>
		
				<nav class="navbar navbar-expand-sm d-flex justify-content-end">
					<!-- Links -->
					<ul class="main-nav d-flex p-0 m-0 justify-content-center align-items-center" style="width:450px;">
						<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/trip/list.do">여행기</a></li>
						<li class="nav-item"><a class="nav-link" href="#">여행정보</a></li>
						<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">커뮤니티</a>
							<div class="dropdown-menu">
						<%if(loginUser==null){ %>
								<a class="dropdown-item" href="javascript:alert('[회원공개] 로그인 해주세요.');">동행찾기</a>	
						<%}else{ %>												
								<a class="dropdown-item" href="<%=request.getContextPath()%>/donghang/donghangListView.do?userTag=<%=loginUser.getTag()%>">동행찾기</a> 
						<%} %>								
								<a class="dropdown-item" href="<%=request.getContextPath()%>/board/list.do">게시판</a>
							</div>
						</li>
						<%if(loginUser==null){ %>
						<!-- 세션의 멤버 값을 가져와서 null 일경우 로그인 페이지로 이동-->
						<li class="nav-item">
						<a class="nav-link" href="<%=request.getContextPath()%>/user/loginPage.do">로그인
						</a>
						</li>
						<%}else{ %>
						<!-- null 이 아닐경우  마이페이지/로그아웃 출력, -->
						<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"> 
							<img src="<%=request.getContextPath()%>/image/profile_icon.png" width="50px" height="50px" class="p-0 m-0">
						</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">마이페이지</a> 
								<a class="dropdown-item" href="<%=request.getContextPath()%>/user/logout.do">로그아웃</a>
							</div>
						</li>
						<%} %>
					</ul>
				</nav>

			</div>
		</div>
	</header>