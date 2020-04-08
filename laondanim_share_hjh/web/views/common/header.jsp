<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

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
<title>라온다님 메인</title>
<style>
/* 헤더 푸터 값조절 */
html,body {

    margin:0;
	padding:0;
	height:100%;

}
header {

	height:150px;
	border: 1px solid black;
	display: flex;


}

section {

    padding:20px;

}

footer {

  /*   position:absolute; */
	bottom:0;
	width:100%;
	height:70px;   
	background:#ccc;
    padding-top:20px;
  	background-color:mediumaquamarine;
	clear:both;
	text-align:center;

} 

/* body안의 전체를 감싸는 wrapper컨테이너 */
.body-wrapper{

	position:relative;
	min-height:100%;

}

.mainTitle-container{
	margin-top:30px;
	margin-left:50px;
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

.main-nav {
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
	<div class="body-wrapper">
	<header>
	
		<div class="title-container">
			<h1>
				<div class="mainTitle-container"><a href="" >라온다님</a></div>
			</h1>
		</div>	
		<div class="header-container">
		
			<div class="nav-container">
				<nav class="navbar navbar-expand-sm ">

					<!-- Links -->
					<ul class="navbar-nav main-nav">
						<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/trip/list.do">여행기</a></li>
						<li class="nav-item"><a class="nav-link" href="#">여행정보</a></li>
						<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">커뮤니티</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">동행찾기</a> 
								<a class="dropdown-item" href="#">게시판</a>
							</div>
						</li>
						<!-- 세션의 멤버 값을 가져와서 null 이 아닐경우  마이페이지/로그아웃 출력, null 일경우 로그인 페이지로 이동-->
						<li class="nav-item">
						<a class="nav-link"href="<%=request.getContextPath()%>/login.do"> 
							<img src="<%=request.getContextPath()%>/icon/profile_icon.png" width="50px" height="50px">
						</a>
						</li>
					</ul>

				</nav>
			</div>
		</div>
	</header>