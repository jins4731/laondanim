<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="com.laon.board.model.vo.BoardJoinUser,com.laon.board.model.vo.BoardCommentJoinUser,java.util.List" %>
<%
	BoardJoinUser b=(BoardJoinUser)request.getAttribute("BoardJoinUser");
	List<BoardCommentJoinUser> comments=(List)request.getAttribute("comments");

//태그 분리하여 출력하기
	
	if(b.getTag()!=null){
	String tag=b.getTag();
	String[] taglist=tag.split("#");
	b.setTag(String.join(" #",taglist));
	}
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
    table#tbl-comment tr td:last-of-type {text-align:left; width: 100px;}
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
    <%=b.getTag()==null?" ":b.getTag() %>
    </div>
    <hr width="720px"/>
    <div class="comment-title text-left">
    &nbsp;&nbsp;댓글
    </div>
    <table id="tbl-comment">
  <%if(comments!=null&&!comments.isEmpty()){
		for(BoardCommentJoinUser bc:comments){
		if(bc.getLevel()==1){%>
        <!-- 댓글 출력하기 -->
        <!-- 등록된 댓글이 있으면 -->	
        <tr>		
        	<td>
				<sub class="comment-writer"><%=bc.getCommentWriter() %></sub>
                <sub class="comment-date"><%=bc.getWriteDate() %></sub>
				<br>
				<%=bc.getContent() %>
				<button class="2ndComment" value="<%=bc.getNo() %>" >답글 달기</button>
			</td>
        </tr>
        <%}else if(bc.getLevel()==2){ %>
		<tr class="level2">
			<td>
				<sub ><%=bc.getCommentWriter() %></sub>
				<sub ><%=bc.getWriteDate() %></sub>
				<br>
				<%=bc.getContent() %>
			
			</td>
			<td>
			</td>
		</tr>
		<% }
			}%>	
		<%} %>
		<tr>
		<form action="<%=request.getContextPath()%>/board/commentInsert.do" method="post">
			<td>
			<textarea name="commentContent" cols="80" rows="3" placeholder="댓글을 입력해주세요 :)"></textarea>
			<!-- 작성할때 작성자는 세션값으로 가져오자 -->
			<input type="hidden" name="commentWriter" value="<%=loginUser.getNo()%>">
			<input type="hidden" name="boardRef" value="<%=b.getNo() %>">
			<input type="hidden" name="level" value="1">
			<input type="hidden" name="commentRef" value="0">
			</td>
			<td>		
				<input type="submit" class="btn btn-primary" value="등록">
			</td>	
		</form>		
        </tr>
    </table>
    </div>
 </section>



<%@ include file="/views/common/footer.jsp"%> 

<script>

$(function(){
	$(".2ndComment").click(function(){
		//댓글 등록 버튼 눌렀을때 
		if(<%=loginUser!=null%>){
			const tr=$("<tr>");
			const td=$("<td>").css({
				"display":"none","text-align":"left"
			}).attr("colspan",2);
			const form=$("<form>").attr({
				"action":"<%=request.getContextPath()%>/board/commentInsert.do",
				"method":"post"
			});
			const textarea=$("<textarea>").attr({"cols":"50","rows":"2",
												"name":"commentContent"});
			const button=$("<input>").attr({"type":"submit","value":"답글"});
			const writer=$("<input>").attr({"type":"hidden",
								"name":"commentWriter","value":"<%=loginUser.getNo()%>"});
			const boardRef=$("<input>").attr({"type":"hidden",
				"name":"boardRef","value":"<%=b.getNo()%>"});
			const level=$("<input>").attr({"type":"hidden",
				"name":"level","value":"2"});
			const commentRef=$("<input>").attr({"type":"hidden",
				"name":"commentRef","value":$(this).val()});
			form.append(textarea).append(button).append(writer)
			.append(boardRef).append(level).append(commentRef);
			td.append(form);
			tr.append(td);
			($(this).parent().parent()).after(tr);
			tr.children("td").slideDown(500);
			$(this).off("click");
		}
	});
});

</script>


