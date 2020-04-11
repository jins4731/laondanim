<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="com.laon.board.model.vo.BoardJoinUser" %>
<%
	BoardJoinUser b=(BoardJoinUser)request.getAttribute("BoardJoinUser");


//태그 분리하여 출력하기
	String tag=b.getTag();
	String[] list=tag.split("#");
	String tags=String.join(" #",list);
%>
<%@ include file="/views/common/header.jsp"%>
<style>
  	section{
  		margin-top:100px;
  	}
    .title{
        /* border:1px solid red; */
        margin-top: 2%;
    }
    .title>h4{
        text-decoration:underline;
    }
    .user-detail{
    
   /* border:1px solid red;  */
        width:700px;
        height: 40px; 
        margin-left: auto;
        margin-right: auto;
        
    }
    .user-detail>div{
        margin-left: 10px;
    }
  /*   글내용 불러올 공간  */
    .comm-content{
       /*  border:1px solid red; */
        width:700px;
        height: 250px; 
        margin-left: auto;
        margin-right: auto;
    }
    .tag-container{
    	width:700px;
   		margin-left: auto;
        margin-right: auto;
    
    }
    .comment-title{
        /* border:1px solid red; */
 		border-radius:15px; 
        font-weight: bolder;
        background-color:lightgrey;
        width:710px;
        height: 30px;
        margin-top: 5px;
        margin-bottom: 5px;
        margin-left: auto;
        margin-right: auto; 
    }

           /*댓글테이블*/
    table#tbl-comment{width:700px; margin:0 auto; border-collapse:collapse; clear:both; } 
    table#tbl-comment tr td{border-bottom:1px solid; border-top:1px solid; padding:5px; text-align:left; line-height:120%;}
    table#tbl-comment tr td:first-of-type{padding: 5px 5px 5px 5px;}
    table#tbl-comment tr td:last-of-type {text-align:right; width: 100px;}
    table#tbl-comment button.btn-reply{border-radius:30%; margin-right:30px;}
    table#tbl-comment tr:hover {background:lightgray;}
    table#tbl-comment tr:hover button.btn-reply{display:inline;}
    table#tbl-comment tr.level2 {color:gray; font-size: 14px;}
    table#tbl-comment sub.comment-writer {color:navy; font-size:14px}
    table#tbl-comment sub.comment-date {color:tomato; font-size:10px}
    table#tbl-comment tr.level2 td:first-of-type{padding-left:100px;}
    table#tbl-comment tr.level2 sub.comment-writer {color:#8e8eff; font-size:14px}
    table#tbl-comment tr.level2 sub.comment-date {color:#ff9c8a; font-size:10px}


    </style>
<section>
    <div class="text-center">
    <a href=""> &lt;전체 게시글</a>
   <input type="button" class="btn btn-secondary disabled" value="<%=b.getCategory()%>">
    
    </div>
    <div class="title text-center"><h4><%=b.getTitle()%></h4></div>
    <hr width="720px"/>
    <div class="user-detail text-left">
        <div>
        <!--  유저아이콘에 사진 넣을건지.. -->
            <img src="<%=request.getContextPath()%>/views/picture/board/user.png" width="30px" height="30px"><%=b.getNickName()%><img src="<%=request.getContextPath()%>/views/picture/board/menu-vertical_icon.png"width="25px" height="25px">
            <sub><%=b.getWriteDate() %></sub>
        </div>
    </div>
    <hr width="720px"/>
    <div class="comm-content">
      <%=b.getContent() %>

    </div>
    <div class="tag-container">
    <%=tags %>
    </div>
    <hr width="720px"/>
    <div class="comment-title text-left">
    &nbsp;&nbsp;댓글
    </div>
    <table id="tbl-comment">
        <!-- 댓글 출력하기 -->
        <!-- 등록된 댓글이 있으면 -->	
        <tr>		
        	<td>
				<sub class="comment-writer">작성자닉네임</sub>
                <sub class="comment-date">작성날짜</sub>
                <sub class="comment-date">작성시간</sub>
				<br>
			</td>
        </tr>
		<tr>
			<td>
			<textarea cols="80" rows="3" placeholder="댓글을 입력해주세요 :)"></textarea>
			</td>
			<td>		
				<button class="btn btn-primary" value="등록">등록</button>
			</td>		
        </tr>
    </table>
    </div>
 </section>



<%@ include file="/views/common/footer.jsp"%> 

<script>


</script>


