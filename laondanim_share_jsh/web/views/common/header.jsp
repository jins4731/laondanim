<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<!-- FontAwesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">

<title>라온다님 메인</title>
<style>
/* 헤더 푸터 값조절 */
html,body {

    margin:0;
	padding:0;
	height:100%;

}

/* body안의 전체를 감싸는 wrapper컨테이너 */
/* .wrapper {

	position:relative;
	min-height:100%;

} */

header {

	height:150px;
	border: 1px solid black;
	display: flex;


}

section {

    padding:20px;

}

footer {

/*     position:absolute; */
	bottom:0;
	width:100%;
	height:70px;   
	background:#ccc;
    padding-top:20px;
  	background-color:mediumaquamarine;
	clear:both;
	text-align:center;

} 


#title{
	padding-top:70px;
	margin-left: 70px;
}

		/* 글자색 통일 */
header a {
	text-decoration: none;
	color: mediumaquamarine;
}

.header-container{
	border: 1px solid black;
	padding-top: 70px;
	margin-left: auto;
	margin-right: 90px;
}

header li>a {
	/* border:1px solid black;*/
	
	padding-left: 30px;
	font-size: 20px;
	text-decoration: none;
}

.navbar-nav {
	list-style: none;
}

	/* 메뉴에 마우스 커서만 올려도 드롭다운 메뉴가 자동으로 나오게 */
.dropdown:hover .dropdown-menu {
	display: block;
	margin-top: 0;
}

</style>
</head>
<body>
<!-- 	<div class="wrapper"> -->
	<header>
	
		<div class="title-container">
			<h1>
				<span id="title"><a href="" class="title">라온다님</a></span>
			</h1>
		</div>	
		<div class="header-container">
		
			<div class="nav-container">
				<nav class="navbar navbar-expand-sm ">

					<!-- Links -->
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="#">여행기</a></li>
						<li class="nav-item"><a class="nav-link" href="#">여행정보</a></li>
						<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">커뮤니티</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="<%=request.getContextPath()%>/donghang/donghangListView.do">동행찾기</a> 
								<a class="dropdown-item" href="#">커뮤니티</a>
							</div>
						</li>
						<!-- 세션의 멤버 값을 가져와서 null 이 아닐경우  마이페이지/로그아웃 출력, null 일경우 로그인 페이지로 이동-->
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/login.do"> <img
								src="<%=request.getContextPath()%>/icon/profile_icon.png"
								width="50px" height="50px"></a>
						</li>
						<li >
							<a href="<%=request.getContextPath()%>/user/enroll.do">회원가입</a>
						</li>
					</ul>

				</nav>
			</div>
		</div>
	</header>