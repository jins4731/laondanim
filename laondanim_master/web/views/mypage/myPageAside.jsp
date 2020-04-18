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
		
		<div style="height:30px;"></div>
		
		<!-- 가입일수 -->
		<div class="joinDays">
			<div>
				<%=up.getNickName() %>님!
			</div>
			<div>
				라온다님과 함께한지 ㅇㅇ일 ♥
			</div>
		</div>
		
		<div style="height:30px;"></div>
		
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
        /* border:1px solid green; */
    }

	#myProfile{
		display:flex;
	}
	
	#myProfile>div:first-child{
		flex:10;
	}
	
	#myProfile>div:last-child{
		margin-top: 15px;
	}
	
	#myProfile>div:last-child>button{
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
	
	.joinDays{
		margin-left:40px;
		margin-right:20px;
		margin-top:20px;
		margin-bottom:20px;
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
	tips[0]="코로나 확산 방지를 위해<br> 사회적 거리두기에 참여해주세요!";
	tips[1]="원래 잘됐는데.......";
	tips[2]="암호화는 무슨..<br> - 진승연";
	tips[3]="모달창 쓰지 맙시다<br> -현정호";
	tips[4]="또 나야...?<br> -현정호";
	tips[5]="또 너야!<br> -진승연";
	tips[6]="집<br> -정세현";
	tips[7]="에러나신분이요<br> -유병승";
	tips[8]="카드 꼭 찍으세요!<br> -유병승";
	
	$(function(){
		var rn=Math.round(Math.random()*8);
		$(".tip div:last-child").html(tips[rn]);
	});
</script>