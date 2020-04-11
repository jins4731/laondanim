<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,com.laon.board.model.vo.BoardJoinUser" %>
<%@ include file="/views/common/header.jsp"%>
<%
	List<BoardJoinUser> list=(List)request.getAttribute("list");

	String category=(String)request.getAttribute("category");
	String searchDetail=(String)request.getAttribute("searchDetail");
	String searchBox=(String)request.getAttribute("searchBox");
	int totalData=Integer.parseInt(request.getAttribute("totalData").toString());
%>
<style>
.searchContainer {
	/* border: 1px solid coral; */
	display: flex;
	flex-direction: row;
	justify-content: center;
	padding-top: 50px;
	padding-bottom: 20px;
}

.searchBox {
	/* border: 1px solid coral; */
	display: flex;
	flex-direction: row;
	height: 35px;
/* 	border: 1.5px solid #00abbf;
	border-radius: 20px; */
	
}

.searchBoxElement {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	padding-left: 10px;
	padding-right: 10px;
	border: none;
	/* background-color: #00abbf; */
	border-radius: 20px;
	color: white;
}

.searchBoxElement img {
	width: 20px;
	height: 20px;
	margin-right: 5px;
}

.searchContainer input {
	height: 30px;
	/* border: none; */
	margin-left: 5px;
}

.searchContainer input:focus {
	outline: none;
}

.searchBoxElement>p {
	padding-top: 10px;
}

.board-dropdown {
	margin-top: 30px;
	margin-left: 140px;
	margin-right: auto;
}

.write {
	display: flex;
	flex-direction: row;
	justify-content: space-around;
	align-items: center;
	/* border: 1px solid black; */
	width: 180px;
	margin-left: auto;
	margin-right: 200px;
	margin-bottom: 30px;
}

.write>a {
	border: none;
	border-bottom: 2px solid rgb(224, 224, 224);
	background-color: white;

}

table{
	margin-left:auto;
	margin-right:auto;
	text-align: center;
}
table * {

	
}

.filter {
	/* border: 1px solid black; */
	width: 1000px;
	display: flex;
	margin-right: auto;
	margin-left: auto;
	margin-bottom: 30px;
}

.filter ul {
	list-style: none;
	display: flex;
}

.filter ul>li {
	padding-left: 10px;
}

#filter-container {
	/* border: 1px solid black; */
	margin-left: auto;
	margin-right: 100px;
}

.board-container {
	width: 1000px;
	margin-left: auto;
	margin-right: auto;
}

</style>
<section>
	<div class="searchContainer">
		<div class="searchBox">
			<!-- <div class="searchBoxElement" data-toggle="dropdown"> -->
				<img src="<%=request.getContextPath()%>/icon/search_icon.png"
					alt="search_icon">
				<form action="<%=request.getContextPath()%>/board/search.do" type="post" id="form">
					<select name="category"  data-width="fit">
						<option value="all">전체게시글</option>
						<option value="qna">질문글</option>
						<option value="others">자유글</option>
					</select> 
					<select name="searchDetail"  data-width="fit">
						<option value="writer">작성자</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="tags">키워드태그</option>
					</select>
		<!-- 	</div> -->
				<input type="text" name="searchBox" id="search" size="40px">
				
				<input type="submit" id="searchSubmit" value="검색">
				<!-- 검색한후에 버튼 필터 사용시 -->
				<input type="hidden" value="<%=searchBox %>" id="searchBox"/>
				<input type="hidden" value="<%=category==null?"all":category %>" id="category"/>
				<input type="hidden" value="<%=searchDetail %>" id="searchDetail"/>
			</form>
		</div>
	</div>
	<!--게시글 작성버튼-->
<div class="write">
    <a href="<%=request.getContextPath()%>/board/write.do">게시글 작성<img src="<%=request.getContextPath()%>/icon/pen_icon.png"></a>
</div>
<!--게시글 수 출력/필터링-->
<div class="filter">
    <div id="print-post">총 <%=totalData%>건의 게시물이 있습니다</div>
    <div id="filter-container">
    <ul class="comm-filter">
    <li><button class="btn btn-mg btn-outline-secondary border-0" id="recent">최근 순</button></li>
    <li><button class="btn btn-mg btn-outline-secondary border-0" id="viewCount">조회수 순</button></li>
    </ul>
    </div>
</div>
<!--게시글 내용출력-->
<div class="board-container">
<table class="table table-bordered" style="width:800px">
    <thead>
    <tr>
        <th style="width:10%">NO</th>
        <th style="width:45%">제목</th>
        <th style="width:20%">작성자</th>
        <th style="width:15%">작성일</th>
        <th style="width:10%">조회수</th>
    </tr>
    </thead>
    <%for(BoardJoinUser b:list){ 
			%>	
    <tbody>
    <tr>
        <td><%=b.getNo()%></td>
        <td>
        <a href='<%=request.getContextPath()%>/board/boardView?no=<%=b.getNo()%>'>
        <%=b.getTitle()%>
        </td>
        <td><%=b.getNickName()%></td>
        <td><%=b.getWriteDate() %></td>
        <td><%=b.getViewCount() %></td>
    </tr>
    </tbody>
    <%} %>
</table>
<hr/>
<!--페이징 처리하기-->
<div class="text-center">
       <%=request.getAttribute("pageBar") %>
</div>
</div>
</section>
<script>
$(function(){
		//최신 순 버튼 클릭시 최신순으로 정렬
		//히든값에있는것으로 불러와
	  $("#recent").click(function(){
      	var searchBox= $("#searchBox").val();
        var category = $("#category").val();
        var searchDetail = $("#searchDetail").val();
      	var recent = 'recent';
      	var viewCount='null';
      	location.href="<%=request.getContextPath()%>/board/search.do?searchBox="+searchBox+"&category="+category+"&searchDetail="+searchDetail+"&recent="+recent+"&viewCount="+viewCount;
      });
      
      //좋아요 순 버튼 클릭시 정렬 많은 순으로 정렬
      $("#viewCount").click(function(){
    	  var searchBox= $("#searchBox").val();
          var category = $("#category").val();
          var searchDetail = $("#searchDetail").val();
        var recent = 'null';
        var viewCount='viewCount';
      	location.href="<%=request.getContextPath()%>/board/search.do?searchBox="+searchBox+"&category="+category+"&searchDetail="+searchDetail+"&recent="+recent+"&viewCount="+viewCount;
      });	
});






<%-- $("#searchSubmit").click(()=>
	//셀렉트 옵션값2가지, input text값 보내기
	$.ajax({
		url:"<%=request.getContextPath()%>/board/search.do",
		type:"post",
		data:{category:$("#category").val(),
			detail:$("#searchDetail").val(),
			 text:$("#searchBox").val()
			 recent:'null',
			 viewCount:'null'},
			 
		success:data=>{
			console.log(data);
			
			}
	})
	
	
); --%>


</script>
<%@ include file="/views/common/footer.jsp"%> 

