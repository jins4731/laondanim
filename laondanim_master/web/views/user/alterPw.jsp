<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id=(String)request.getAttribute("userId");
%>
<%@ include file="/views/common/header.jsp"%>
<div style="height:170px;"></div>
<section class="d-flex flex-column justify-content-center align-items-center">
<div id="login-submit" style="height: 717px;">
	
		
	<h2>비밀번호 변경</h2>
		<hr>	
		<table>
		<tr>
			<td>
			임시비밀번호 입력:
			</td>
			<td>
				<input type="hidden" id="authId" value="<%=id %>">
				<input type="text" class="form-control" id="authPw" placeholder="전송된  임시 비밀번호 입력"/>
			</td>
			<td>
				<button class="btn btn-primary" id="authPwck">비밀번호 확인</button>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="printpwck"></div>
			</td>
		<tr>
		</table>
		<table id="pwck-table" style="display:none">
			<td>
			새 비밀번호 입력:
			</td>
			<td>
				<input type="password" id="userPw" name="userPw" class="form-control" placeholder="비밀번호 입력" required>
			</td>
		</tr>
		<tr>
			<td>
			비밀번호 확인:
			</td>
			<td> 
				<input type="password" id="pwck" name="pwck"  class="form-control" placeholder="비밀번호 재확인" required>
			</td>
		</tr>
			<tr>
				<td colspan="2">
					<div style="position: relative; width: 394px; height: 45px;">

						<div class="alert alert-light m-0 p-2 text-center" id=""
							style="position: absolute; width: 100%;">비밀번호는 숫자와 영(소)문자
							조합 5~10자리를 사용</div>
						<div class="alert alert-success m-0 p-2 text-center"
							id="alert-success" style="position: absolute; width: 100%;">
							비밀번호가 일치합니다.</div>
						<div class="alert alert-danger m-0 p-2 text-center"
							id="alert-danger" style="position: absolute; width: 100%;">
							비밀번호가 일치하지 않습니다.</div>
						<div class="alert alert-danger m-0 p-2 text-center"
							id="alert-pw-validate" style="position: absolute; width: 100%;">
							숫자, 영문자 조합 5~10자리로 입력해주세요.</div>
					</div>
				</td>
		</tr>
		<tr>
			<td colspan="2">
				
				<button class="btn btn-primary " id="submitPw" >비밀번호 변경하기</button>
			</td>
		</tr>
		</table>
</section>
<script>


//비밀번호 찾기-> ajax로 구현
$("#authPwck").click((e)=>{


$.ajax({
	url:"<%=request.getContextPath()%>/user/authPwck.do",
	type:"post",
	data:{
		authId:$("#authId").val(),
		authPw:$("#authPw").val()},
	success:data=>{
		console.log(data);
		if(data==1){
	$("#printpwck").html("<strong>비밀번호가 일치합니다</strong>");
	$("#pwck-table").show();
		}else{
			$("#printpwck").html("<strong>비밀번호가 일치하지 않습니다</strong>");
		}
		}
});

});
		
		//비밀번호 일치 확인
	$(function(){
	        $("#alert-success").hide();
	        $("#alert-danger").hide();
	        $("#alert-pw-validate").hide();
	});
	        $("#userPw").keyup(()=>{            
	            $("#alert-success").hide();
	            $("#alert-danger").hide();                
	        }) 

	        $("#pwck").keyup(function(){
	            let userPw=$("#userPw").val();
	            let pwck=$("#pwck").val();
	            const reg = /^(?=.*[a-z])(?=.*\d)[a-z\d]{5,10}$/;

	            $("#alert-success").hide();
	            $("#alert-danger").hide();

	            if(!reg.test(userPw)){
	                $("#alert-pw-validate").show();
	            } else if(reg.test(userPw)){
	                $("#alert-pw-validate").hide();
	            }
	            if(userPw != "" || pwck != ""){
	                if(userPw == pwck){ 
	                    $("#alert-success").show(); 
	                    $("#alert-danger").hide();
	                } else{ 
	                    $("#alert-success").hide(); 
	                    $("#alert-danger").show(); 
	                }
	            } 
	        }); 
	    
		
		$("#submitPw").click(()=>{
			
			var userPw=$("#userPw").val(); 
			const reg = /^(?=.*[a-z])(?=.*\d)[a-z\d]{5,10}$/;
     
			if(reg.test(userPw)){
				$.ajax({
					url:"<%=request.getContextPath()%>/user/alterPwEnd.do",
					type:"post",
					data:{
						pw:$("#userPw").val(),
						id:$("#authId").val()},
					success:data=>{
						console.log(data);
					   if(data==1){
						  alert("비밀번호 변경성공");
						  location.href="<%=request.getContextPath()%>/user/loginPage.do";
					   }else{
						   alert("비밀번호 변경 실패");
						   return false;
					   }
					
						}
				});
				
				
			}else{
				alert("비밀번호를 다시 확인해주세요");
				return false;
			}
			
			
		});
		
		
		
		
		</script>



<%@ include file="/views/common/footer.jsp"%> 