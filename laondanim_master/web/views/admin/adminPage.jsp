<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List,com.laon.admin.model.vo.Reports" %>
<%
	List<Reports> list=(List)request.getAttribute("reports");

%>	
	
<%@ include file="/views/common/header.jsp"%>
<style>
/* 	.admin-header{
	margin-left:23%;
	} */
	table{
	text-align:center;
	margin-left:auto;
	margin-right:auto;
	margin-top:5%;
	
	}
	
	
</style>
<div style='height: 170px;'></div>
<section class="d-flex flex-column justify-content-center align-items-center">

 <hr/>
    <div class="admin-header d-flex flex-column justify-content-center align-items-center">
        <h2>관리자 게시판</h2>
        <hr class="boder w-100">
    </div>
<aside>

	<div>
	<h4>관리자 페이지</h4>
	<hr/>
	<a href="">신고 리스트 관리</a>
	<br/>
	<a href="">여행정보 등록</a>
</div>

</aside>

    <table class="table table-bordered" style="width:1000px">
        <tr>
            <td colspan="6">
               	 신고리스트 관리
            </td>
        </tr>
        
        <tr>
            <td>NO</td>
            <td>유저아이디</td>
            <td>카테고리</td>
            <td>신고사유</td>
            <td>자세히보기</td>
            <td>유저관리</td>
        </tr>
        <%for (Reports re:list){ %>
        <tr>
            <td><%=re.getNo() %></td>
            <td><%=re.getUserNo() %></td>
            <td>커뮤니티 게시판</td>
            <td><%=re.getReportContent() %></td>
            <td><button class="ref-page btn btn-primary" value="<%=re.getBoardNo()%>">게시글보기</button></td>
            <td><button class="close-account btn btn-warning" value="<%=re.getUserNo()%>">이용정지</button></td>
        </tr>
		<% } %>

    </table>
    <div class="text-center">
       <%=request.getAttribute("pageBar") %>
	</div>

</section>
<script>
$(function(){
	//신고된 해당 게시글을 확인하는 버튼
	$(".ref-page").click(function(){
		var boardNo=$(this).val();
		location.href="<%=request.getContextPath()%>/board/boardView.do?no="+boardNo;
		
		
	})
	
	
	//이용자를 정지시키는 버튼
	$(".close-account").click(function(){
		var closeAcct=confirm("회원을 정지시키겠습니까?");
		if(closeAcct){
		var userNo=$(this).val();
		location.href="<%=request.getContextPath()%>/admin/closeAccount.do?userNo="+userNo;
		}
	})
	
	
})




</script>


<%@ include file="/views/common/footer.jsp"%> 
