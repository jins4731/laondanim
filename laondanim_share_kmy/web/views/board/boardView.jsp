<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<style>
  
    .title{
        border:1px solid red;
        margin-top: 2%;
    }
    .title>h4{
        text-decoration:underline;
    }
    .user-detail{
        border:1px solid red;
        width:700px;
        height: 40px; 
        margin-left: auto;
        margin-right: auto;
        padding-top: 5px;
    }
    .user-detail>div{
        margin-left: 10px;
    }
    .comm-content{
        border:1px solid red;
        width:700px;
        height: 300px; 
        margin-left: auto;
        margin-right: auto;
    }
    .comment-title{
        border:1px solid red;
        border-radius:15px;
        font-weight: bolder;
        background-color:royalblue;
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
    table#tbl-comment tr td:first-of-type{padding: 5px 5px 5px 50px;}
    table#tbl-comment tr td:last-of-type {text-align:right; width: 100px;}
    table#tbl-comment button.btn-reply{display:none;}
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
        <input type="button" value="<%=b.getCategory() %>">
      
    </div>
    <div class="title text-center"><h4><%=c.getTitle()%></h4></div>
    <div class="user-detail text-left">
        <div>
            <img src="user.png" width="30px" height="30px"><%=m.getUserId()%><img src="menu-vertical_icon.png"width="25px" height="25px">
            <sub>2020-02-29   15:56:05 작성</sub>
        </div>
    </div>
    <hr width="720px"/>
    <div class="comm-content">
       <h1>작성내용 출력<h1>

    </div>
    <div class="comment-title text-left">
    &nbsp;&nbsp;댓글
    </div>
    <table id="tbl-comment">
        <!-- 댓글 출력하기 -->
		<tr class="level1">
			<td>
				<sub class="comment-writer">작성자닉네임</sub>
                <sub class="comment-date">작성날짜</sub>
                <sub class="comment-date">작성시간</sub>
				<br>
			</td>
			<td>
				<button class="btn-reply" value="등록">등록</button>
			</td>
        </tr>
    </table>
    </div>
 </section>



<%@ include file="/views/common/footer.jsp"%> 