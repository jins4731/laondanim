<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.laon.user.model.vo.User" %>	
<% 
	String key=(String)session.getAttribute("AuthenticationKey");//메일로 보낸인증번호
	String id=(String)session.getAttribute("AuthId");//인증할때 확인한  유저아이디
	//쿠키값을 가져오기--아이디 저장
		Cookie[] cookies=request.getCookies();
		String saveId="";
		if(cookies!=null){
			for(Cookie c : cookies){
				if(c.getName().equals("saveId")){
					saveId=c.getValue();
				}
			}
		}
%>
<%@ include file="/views/common/header.jsp"%>
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
	/* margin-left:30px; */
	display: flex;
}


.findId-container,.findPw-container {
/* 	border: 1px solid black; */
	
	margin-top: 30px;
	margin-left:20px;
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

<!-- 로그인 페이지 -->
<div class="login-container">
	<div id="title">
	<h1><a href="메인페이지">라온다님</a></h1>
	</div>
	<div id="login-submit">
	<form id="login" action="<%=request.getContextPath()%>/user/login.do" method="post" onsubmit="return invalidate();">
		<table>
		<tr>
			<td>
			 <label>USER ID<br>
				<input type="text" id="userId" name="userId" class="form-control" placeholder="아이디 입력">
			</label>
			</td>
		</tr>
		<tr>
			<td>
			 <label>PASSWORD<br>
				<input type="password" id="password" name="password"  class="form-control" placeholder="비밀번호 입력">
			</label>
			</td>
		</tr>
		<tr>
			<td>
			<label for="saveId">
				<!-- 쿠키값이 있으면 checked 없으면 설정안함 -->
				<input type="checkbox" name="saveId" id="saveId" value="자동로그인" <%=!saveId.equals("")?"checked":""%>>아이디 저장<br><br>
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
			<!-- 로그인 버튼 -->
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
						<ul class="nav nav-tabs search-button">
							<li class="nav-item"><a class="nav-link " href="#" onclick="searchId();">아이디찾기</a></li>
							<li class="nav-item"><a class="nav-link" href="#" onclick="searchPw();">비밀번호찾기</a></li>
						</ul>
						<br>
						<div class="findId-container">
							<form action="" method="post">
							<table class="findId-inner-container">
								<tr>
									<td>이름 </td>
									<td><input type="text" class="form-control" placeholder="이름을 입력하세요" name="name" id="name"> </td>
								</tr>
								<tr>
									<td>이메일 </td>
									<td><input type="text" class="form-control" placeholder="danim@abc.com" name="email" id="findIdEmail" required> </td>
									<!-- 이름과 이메일값을 (name) 서블릿을통해 확인한후. 인증번호를 보내줌 -->
									<td><input type="submit" class="btn btn-primary btn-sm" value="인증번호 발송" id="searchId" onclick='checkInfo("findId");'></td>
								</tr>
									<td></td>
									<td colspan="3">									
									<div id="sendMail"></div>
									</td>
								<tr>
									<td>인증번호 </td>
									<td><input type="text" class="form-control" id="keyVal" placeholder="인증번호를 입력하세요">  </td>
									<td><input type="button" class="btn btn-primary btn-sm" value="인증번호 확인" id="keySubmit" ></td>
									<!-- 아이디 값을 가지고 있기위한 이름 input -->
								<%-- 	<%if(id!=null){ %>
										<input type="hidden" name="findUserId" value="<%=id%>"> 
									<% }%> --%>
								</tr>
							</table>
							</form>
						</div>
						<!-- Modal footer -->
				<div class="modal-footer findIdFooter">
					<input type="submit" class="btn btn-danger" data-dismiss="modal"
						value="완료" />
				</div>
<!-- 비밀번호 찾기 모달 -->
	<div class="findPw-container" style="display: none;">
		<form action="" method="post">
			<table class="findPw-inner-container">
				<tr>
					<td>아이디</td>
					<td><input type="text" class="form-control" placeholder="아이디를 입력하세요" name="id" id="findPwuserId"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" class="form-control" placeholder="danim@abc.com" name="email" id="findPwEmail" required>
					</td>
					<td><input type="button" class="btn btn-primary btn-sm" value="임시비밀번호 발송" id="searchPw" onclick='checkInfo("findPw");'></td>
				</tr>
				<tr>
				<td></td>
				<td colspan="3">									
				<div id="sendMail2"></div>
				</td>
				</tr>
				<!-- <tr>
				<tr>
					<td>인증번호</td>
					<td><input type="text" class="form-control" id="pwKeyVal" placeholder="인증번호를 입력하세요"></td>
					<td><input type="button" class="btn btn-primary btn-sm"  value="인증번호 확인" id="pwKeySubmit" onclick="submit();"></td>
				</tr> -->
			</table>
		</form>
	</div>
				<!-- Modal footer -->
				<div class="modal-footer findPwFooter" style="display: none;">
					<input type="submit" class="btn btn-danger" data-dismiss="modal" value="완료" onclick="finishPw();" />
				</div>
<!-- 전체 모달창 닫는 div들 -->
			</div>
		</div>
	</div>
	</div>
</div>


<script>
		function invalidate(){
		//유효성검사 -> 입력받는 값이 내가 원한대로 입력할 수 있게 확인
		// 예) 아이디는 4글자이상, 영문자포함,숫자포함 그외는 안됨!->정규표현식
		const userId=$("#userId").val();
		const password=$("#password").val();
		if(userId.trim().length==0){
			alert("아이디를 입력하세요");
			$("#userId").focus();
			return false;//전송중단!
		}
		if(password.trim().length==0){
			alert("비밀번호를 입력하세요");
			$("#password").focus();
			return false;
		}
		return true;
		}
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
		
		function checkInfo(str) {
			if (str == "findId") {
				var name = $("#name").val();
				var email = $("#findIdEmail").val();
				if (name.trim().length == 0) {
					alert("이름을 입력하세요");
					$("#name").focus();
					return false;
				}
				if (email.trim().length == 0) {
					alert("이메일을 입력하세요");
					$("#findIdEmail").focus();
					return false;
				}
			
			} else if (str == "findPw") {
				var id = $("#findPwuserId").val();
				var email = $("#findPwEmail").val();
				if (id.trim().length == 0) {
					alert("아이디를 입력하세요");
					$("#userId").focus();
					return false;
				}
				if (email.trim().length == 0) {
					alert("이메일을 입력하세요");
					$("#findPwEmail").focus();
					return false;
				}
			}
			return true;
		}
		//아이디찾기-> ajax로 구현
		$("#searchId").click((e)=>{
			e.stopPropagation();
			e.preventDefault();
			/* sessionStorage.removeItem("id");
			sessionStorage.removeItem("key"); */
			
		
			$.ajax({
				url:"<%=request.getContextPath()%>/user/findId.do",
				type:"post",
				data:{name:$("#name").val(),
					 email:$("#findIdEmail").val()},
				success:data=>{
					console.log(data);
				$("#sendMail").html(data);
					}
				
			});
			
		});
		//인증번호비교 해서 맞으면 아이디 출력화면 설정
		//다르면 인증번호가 다릅니다 alert출력
		$("#keySubmit").click((e)=>{
			
			/* location.reload();
			e.preventDefault();  */
			$.ajax({
				url:"<%=request.getContextPath()%>/user/checkKey.do",
				type:"post",
				data:{
					id:'<%=id%>',
					userKey:$("#keyVal").val()},
					success:data=>{
					//아이디찾기화면 숨기기
					//table을 감춤다
					$(".findId-inner-container").hide(); 
					let div=$("<div>").attr("class","findIdEnd-container").html(data);
					$(".findId-container").append(div);  
					
					}
				
			});
		});
		
		//-------------------비밀번호 찾기-------------------------
		
		
		//비밀번호 찾기-> ajax로 구현
			$("#searchPw").click((e)=>{
			e.stopPropagation();
			e.preventDefault();
			
			$.ajax({
				url:"<%=request.getContextPath()%>/user/findPw.do",
				type:"post",
				data:{id:$("#findPwuserId").val(),
					 email:$("#findPwEmail").val()},
				success:data=>{
					console.log(data);
				$("#sendMail2").html(data);
					}
			});
			
		});
			//세션값이 null이아니면 완료할때 alert창을 띄워줄까??
			
		
		
	
	</script>

<%@ include file="/views/common/footer.jsp"%> 
