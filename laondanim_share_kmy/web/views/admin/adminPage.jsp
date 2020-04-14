<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List,com.laon.admin.model.vo.Reports" %>
<%
	List<Reports> list=(List)request.getAttribute("reports");

%>	
	
<%@ include file="/views/common/header.jsp"%>
<style>
	section{
	text-align:center;
	
	}
	table{
	margin-left:auto;
	margin-right:auto;
	margin-top:5%;
	
	}
	
	
</style>
<section>
    <div>
        <h1>관리자 게시판</h1>
    </div>
    <table class="table table-bordered" style="width:800px">
        <tr>
            <td colspan="5">
               	 신고리스트 관리
            </td>
        </tr>
        
        <tr>
            <td>NO</td>
            <td>유저아이디</td>
            <td>내용</td>
            <td>자세히보기</td>
            <td>유저관리</td>
        </tr>
        <%for (Reports re:list){ %>
        <tr>
            <td><%=re.getNo() %></td>
            <td><%=re.getUserNo() %></td>
            <td><%=re.getReportContent() %></td>
            <td><button class="ref-page btn btn-primary" value="게시글번호">게시글보기</button></td>
            <td><button class="close-account btn btn-warning" value="">이용정지</button></td>
        </tr>
		<% } %>

    </table>

</section>
<%@ include file="/views/common/footer.jsp"%> 