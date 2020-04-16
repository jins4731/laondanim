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
			<td colspan="2">
				<button class="btn btn-warning" id="pw-exit">나중에 변경하기</button>
				<input type="hidden" value="<%=id%>" id="userId">
				<button class="btn btn-primary pwck-table" value="<%=id%>" id="enterPw" >비밀번호 변경</button>
			</td>
		</tr>
		</table>
</div>
</section>
<script>
$("#pw-exit").click(()=>{
	
	//나중에 변경하기 누르면 로그인 페이지로 이동
	location.href="<%=request.getContextPath()%>/user/loginPage.do";
});
$("#enterPw").click(()=>{
	var userId=$("#userId").val();
	location.href="<%=request.getContextPath()%>/user/pwPage.do?userId="+userId;
});

</script>
<%@ include file="/views/common/footer.jsp"%> 