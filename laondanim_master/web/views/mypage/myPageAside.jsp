<%@page import="com.laon.user.model.vo.UserProfile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.laon.user.model.vo.UserProfile" %>	
<%
	UserProfile up=(UserProfile)request.getAttribute("userProfile");
%>
<aside>
	<div style="height:50px;"></div>
	<div>
		<!-- 프로필 -->
		<div class="card" style="width: 300px">
		<%if(up.getImage()!=null && !up.getImage().equals("")){ %>
			<img class="card-img-top" src="<%=request.getContextPath() %>/views/picture/profile/<%=up.getImage() %>" style="width: 100%">
		<%}else{ %>
			<img class="card-img-top" src="<%=request.getContextPath() %>/images/defaultProfile.png" style="width: 100%">
		<%} %>
			<div class="card-body">
				<div id="myProfile">
					<div>
						<h4 class="card-title"><%=up.getUserId() %></h4>
						<p class="card-text"><%=up.getNickName() %></p>
					</div>
					<div>
						<button type="button" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myInfoPwck.do?userNo=<%=up.getNo()%>')">정보수정</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 알람 -->
		<%-- <div id="alram" data-toggle="modal" data-target="#myModal">
			<label>
				<img src="<%=request.getContextPath() %>/images/alram.png">
				<span>? 개의 알림이 있습니다.</span>
			</label>
		</div> --%>
		
		<!-- <div class="modal fade" id="myModal">
		    <div class="modal-dialog modal-lg">
		      <div class="modal-content">
		      
		        Modal Header
		        <div class="modal-header">
		          <h4 class="modal-title">알림</h4>
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		        </div>
		        
		        Modal body
		        <div class="modal-body">
		          <table class="table">
		          	<tr>
		          		<td>카테고리</td>
		          		<td>내용</td>
		          		<td>삭제</td>
		          	</tr>
		          </table>
		        </div>
		      </div>
		    </div>
		</div> -->
		
		<!-- 팁 -->
		<div class="alert alert-info tip">
			<div>
				<strong>TIP!</strong>
			</div>
			<div>
				<span></span>
			</div>
		</div>
	</div>
</aside>
<style>
	aside{
		width:320px;
	}
	
	*{
        border-collapse:collapse;
        margin:0px;
        padding:0px;
        text-decoration: none;
        color:black;
        list-style:none;
    }

	#myProfile{
		display:flex;
	}
	
	#myProfile>div:first-child{
		flex:8;
	}
	
	#myProfile>div:last-child{
		margin-top: 15px;
	}
	
	#myProfile>div:last-child>button{
		margin: 20px;
    	border-radius: 100px;
    	border-radius: 20px;
	    background-color: white;
	    border: 2px solid #00abbf;
	    color: #00abbf;
	    padding: 6px 15px 6px 15px;
	}
	
	#myProfile>div:last-child>button:hover{
		color: white;
    	background-color: #00abbf;
	}
	
	#alram{
		margin:20px;
	}
	
	.tip{
		display:inline-block;
		width:300px;
		height:150px;
	}
	
	.tip div{
		display:flex;
	}
	
	.tip div:last-child {
		height:100px;
		justify-content:center;
		align-items: center;
		
		
	}
}
</style>

<script>
	var tips=new Array();
	tips[0]="팁팁팁팁팁팁팁팁팁팁팁팁팁팁1";
	tips[1]="팁팁팁팁팁팁팁팁팁팁팁팁팁팁2";
	tips[2]="팁팁팁팁팁팁팁팁팁팁팁팁팁팁3";
	tips[3]="팁팁팁팁팁팁팁팁팁팁팁팁팁팁4";
	
	$(function(){
		var rn=Math.round(Math.random()*3);
		$(".tip div:last-child").html(tips[rn]);
	});
</script>