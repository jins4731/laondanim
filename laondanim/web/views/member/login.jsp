<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style>
.login-container {
	/* 	border:1px solid black;
		border-radius:5px;
		box-shadow: grey 1px 1px 5px; */
	height: 500px;
	width: 400px;
	text-decoration: none;
	margin-top: 100px;
	margin-left: auto;
	margin-right: auto;
}

.login-container>#title {
	margin-top: 50px;
	margin-left: 130px;
	margin-right: auto;
}

.login-container>#login-submit {
	margin-top: 50px;
	margin-left: 100px;
	margin-right: auto;
}

.login-container>#login-submit h5 {
	text-align: center;
}
/* 아이디/비번찾기 메인모달창 */
.findIdPwTitle {
	margin-top: 30px;
	text-align: center;
}

.search-button {
	margin-top: 30px;
	margin-left:30px;
	display: flex;
}

.search-button button {
	
	margin-right: 10px;
}

.findId-container,.findPw-container {
/* 	border: 1px solid black; */
	
	margin-top: 30px;
	margin-left:30px;
	margin-right: auto;
}

.findId-container input,.findPw-container input{
	margin-bottom: 10px;
}
.findId-container table th,.findPw-container table th {
	padding: 5px 10px;
	text-align: left;
}

.findId-container table td,.findPw-container table td {
	padding: 5px 10px;
	text-align: left;
}
</style>
</head>
<body>
<div class="login-container">
	<div id="title">
	<h1><a href="메인페이지">라온다님</a></h1>
	</div>
	<div id="login-submit">
	<form id="login" action="<%=request.getContextPath()%>/loginEnd.do?" method="post" onsubmit="return invalidate();">
		<table>
		<tr>
			<td>
			 <label>USER ID<br>
				<input type="text" name="userId" class="form-control" placeholder="아이디 입력">
			</label>
			</td>
		</tr>
		<tr>
			<td>
			 <label>PASSWORD<br>
				<input type="password" name="password"  class="form-control"placeholder="비밀번호 입력">
			</label>
			</td>
		</tr>
		<tr>
			<td>
			<label>
				<input type="checkbox" name="" value="자동로그인">로그인 상태 유지<br><br>
			</label>
			</td>
		</tr>
		<tr>
			<td>
				<h5><a href="#findIdPwModal" data-toggle="modal">아이디/비밀번호 찾기</a></h5>
			</td>
		</tr>
		<tr>
			<td>
			 <input type="submit" class="btn btn-primary btn-block" value="로그인"><br>
			</td>
		</tr>

		<tr>
			<td>
			 <input type="button" class="btn btn-primary btn-block" onclick="location.replace('<%=request.getContextPath()%>/memberEnroll.do')" value="회원가입">
			</td>
		</tr>
	</table>
	</form>
	</div>
</div>
	<!-- 아이디/비밀번호 찾기 메인모달 -->


	<div class="modal fade" id="findIdPwModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="idpw-container">
						<div class="findIdPwTitle">
							<h3>아이디/비밀번호 찾기</h3>
						</div>

						<div class="search-button">
							<button class="btn btn-info btn-sm" onclick="searchId();">아이디 찾기</button> 
							<button class="btn btn-info btn-sm" onclick="searchPw();">비밀번호 찾기</button>
						</div>
						
						<br>
						<div class="findId-container">
							<form action="" method="post">
							<table>
								<tr>
									<td>이름 </td>
									<td><input type="text" class="form-control" placeholder="이름을 입력하세요" id="name"> </td>
								</tr>
								<tr>
									<td>이메일 </td>
									<td><input type="text" class="form-control" placeholder="danim@abc.com" name="email" id="findIdEmail" required> </td>
									<td><input type="button" class="btn btn-primary btn-sm" value="인증번호 발송" onclick="checkInfo();"></td>
								</tr>
								<tr>
									<td>인증번호 입력 </td>
									<td><input type="text" class="form-control" placeholder="인증번호를 입력하세요">  </td>
								</tr>
							</table>
							</form>
						</div>
						<!-- Modal footer -->
				<div class="modal-footer findIdFooter">
					<input type="submit" class="btn btn-danger" data-dismiss="modal"
						value="다음" />
				</div>
<!-- 비밀번호 찾기 모달 -->
	<div class="findPw-container" style="display: none;">
		<form action="" method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" class="form-control" placeholder="아이디를 입력하세요" id="userId"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" class="form-control" placeholder="danim@abc.com" name="email" id="findPwEmail" required>
					</td>
					<td><input type="button" class="btn btn-primary btn-sm" value="인증번호 발송" onclick="checkInfo2();"></td>
				</tr>
				<tr>
					<td>인증번호 입력</td>
					<td><input type="text" class="form-control" placeholder="인증번호를 입력하세요"></td>
				</tr>
			</table>
		</form>
	</div>
				<!-- Modal footer -->
				<div class="modal-footer findPwFooter" style="display: none;">
					<input type="submit" class="btn btn-danger" data-dismiss="modal" value="다음" />
				</div>
<!-- 전체 모달창 닫는 div들 -->
			</div>
		</div>
	</div>
	</div>
</div>
	

	<script>
		function searchId(){
			$(".findPwFooter").hide();
			$(".findPw-container").hide();
			$(".findIdFooter").show();
			$(".findId-container").show();
		}
	
	
		function searchPw() {
			$(".findId-container").hide();
			$(".findIdFooter").hide();
			$(".findPw-container").show();
			$(".findPwFooter").show();
			
		}
		function checkInfo(){
			const name=$("#name").val();
			const email=$("#findIdEmail").val();
			if(name.trim().length==0){
				alert("이름을 입력하세요");
				$("#name").focus();
				return false;
			}
			if(email.trim().length==0){
				alert("이메일을 입력하세요");
				$("#findIdEmail").focus();
				return false;
			}
			return true;
		}
		function checkInfo2(){
			const id=$("#userId").val();
			const email=$("#findPwEmail").val();
			if(id.trim().length==0){
				alert("아이디를 입력하세요");
				$("#userId").focus();
				return false;
			}
			if(email.trim().length==0){
				alert("이메일을 입력하세요");
				$("#findPwEmail").focus();
				return false;
			}
			return true;
		}
		//유효성검사 하기
	</script>


