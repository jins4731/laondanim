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

/* 검색창 구현 */
#searchButton-container{
height:40px;
width:450px;

background:#ffffff;

}
#searchBox{
font-size:16px;
/* width:325px; */
padding:10px;
border:0px;
outline:none;
float:left;
}
#searchSubmit{
width:50px;
height:100%;
border:0px;

outline:none;
float:right;
color:#ffffff;
}



.searchBox {

	display: flex;
	flex-direction: row;
	height: 35px;

	
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

#searchSubmit img {
	width: 25px;
	height: 25px;
	margin-right: 5px;
}

#search-form{
	display:flex;
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
	width: 200px;
	margin-left: auto;
	margin-right: 18%;
	margin-top:2%;
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
	margin-right: 50px;
}
.print-post{
	margin-left:50px;
}


  #searchDIV{
                height: 45px;
                width: 550px;
                border: 3px solid #00abbf;
                background-color: #00abbf;
                border-radius: 30px;
                overflow: hidden;
            }
            #searchDIV select{
                width: 33%;
                height: 100%;
                background-color: #00abbf;
                color: white;
                padding-left: 20px;
                -webkit-appearance: none;
                background-image: url('<%=request.getContextPath()%>/images/down_icon.png');
                background-repeat: no-repeat;
                background-position: right center;
                background: ;
            }
            #searchDIV input[type="text"]{
                width: 57%;
                height: 100%;
                border: none;
            }
            #searchDIV input[type="text"]:focus{
                outline: none;
            }
            #searchDIV button{
            	width: 10%;
            	height: 100%;
            	padding: 0px;
            	margin: 0px;
            	border: none;
            	background: white;
            }
            #searchDIV button:focus{
                outline: none;
            } 
</style>
<div style="height:170px;"></div>
<section class="d-flex flex-column justify-content-center align-items-center">
	<div  id="searchDIV" class="d-flex justify-content-center align-items-center m-5">
		<div class="searchBox" class="pt-5 pb-5">
			
				
				<form action="<%=request.getContextPath()%>/board/search.do" type="post" id="search-form">
					<select name="category" class="form-control border-0 rounded-0" data-width="fit">
						<option value="all">전체게시글</option>
						<option value="qna">질문글</option>
						<option value="others">자유글</option>
					</select> 
					<select name="searchDetail" class= "form-control border-0 rounded-0" data-width="fit">
						<option value="writer">작성자</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="tags">키워드태그</option>
					</select>
				<div id="searchButton-container">
				<input type="text" placeholder="검색어 입력" name="searchBox" id="searchBox"  class="pl-2">
				<button type="submit"  id="searchSubmit" >
				<img src="<%=request.getContextPath()%>/images/inactiveSearch_icon.png" alt="searchSubmit" id="searchSubmit"/>
				</button>
				</div>
				<!-- 검색한후에 버튼 필터 사용시 -->
				<input type="hidden" value="<%=searchBox %>" id="searchBox"/>
				<input type="hidden" value="<%=category==null?"all":category %>" id="category"/>
				<input type="hidden" value="<%=searchDetail %>" id="searchDetail"/>
			</form>
		</div>
	</div>
	<!--게시글 작성버튼-->
<div class="write">
    <a href="<%=request.getContextPath()%>/board/write.do">게시글 작성<img src="<%=request.getContextPath()%>/views/picture/board/pen_icon.png"></a>
</div>
<!--게시글 수 출력/필터링-->
<div class="filter">
    <div class="print-post" style="text-decoration:underline;"><h6>총 <%=totalData%>건의 게시물이 있습니다</h6></div>
    <div id="filter-container">
    <ul class="comm-filter">
    <li><button class="btn btn-mg btn-outline-secondary border-0" id="recent">최근 순</button></li>
    <li><button class="btn btn-mg btn-outline-secondary border-0" id="viewCount">조회수 순</button></li>
    </ul>
    </div>
</div>
<!--게시글 내용출력-->
<div class="board-container">
<table class="table table-bordered" style="width:1000px">
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
        <a href='<%=request.getContextPath()%>/board/boardView.do?no=<%=b.getNo()%>'>
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









</script>
<%@ include file="/views/common/footer.jsp"%> 

