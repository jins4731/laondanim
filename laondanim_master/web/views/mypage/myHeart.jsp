<%@page import="com.laon.trip.model.vo.TripMyCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.laon.etc.model.vo.Like" %>
<%
	List<Like> likeT=(List)request.getAttribute("likeT");
	List<TripMyCon> tripList=(List)request.getAttribute("tripList");
	List<UserProfile> userNick=(List)request.getAttribute("userNick");
	int likeTripCount=(int)request.getAttribute("likeTripCount");
%>
<%@ include file="/views/common/header.jsp"%>
<div class="container">
	<div class="row">
	   	<div class="col-4">
			<%@ include file="/views/mypage/myPageAside.jsp" %>
		</div>
		<div class="col-8">
			<section>
				<div id="myMenuBtn">
					<button type="button" id="myCon" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageContent.do?userNo=<%=loginUser.getNo()%>')">내 컨텐츠</button>
					<button type="button" id="myH" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageHeart.do?userNo=<%=loginUser.getNo()%>')">내 마음함</button>
					<button type="button" id="myDh" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageDong.do?userNo=<%=loginUser.getNo()%>')">내 동행</button>
				</div>
				<div id="myPageView">
					<!-- 다님길 -->
					<div class="menu">
						<div class="manuBar">
							<div>
								<span>다님길</span>
							</div>
							<div>
								<img class="imgDrop" src="<%=request.getContextPath() %>/images/drop.png">
							</div>
						</div>
						<hr>
					</div>
					<!-- 닫힘 내용 -->
					<div>
						<!-- 정보 -->
						<div id="myDNInfo">
							<div style="height:45px;">
								<span>총 <%=likeTripCount %>개의 ♥ 다님길</span>
							</div>
						</div>
						<!-- 게시글위치 -->
						<table id="dnTbl">
							<tr class="d-flex flex-wrap justify-content-center">
							<%for(TripMyCon t:tripList){ %>
								<td class="p-1">
									<div class="card" style="width: 155px; height: 250px;" >
										<div class="d-flex justify-content-between p-2" style="font-size:5px;">
						    				<span><%=t.getCategory() %></span>
						    				<span><%=t.getWriteDate() %></span>
										</div>
										<div>
											<%if(t.getImage()==null){ %>
												<img src="<%=request.getContextPath() %>/images/images.jpeg" class="card-img" alt="..." width="155px" height="155px">
											<%}else{ %>
												<img src="<%=request.getContextPath() %>/views/picture/trip/<%=t.getImage()%>" class="card-img" alt="..." width="155px" height="155px">
											<%} %>
			                           </div>
			                           <div class="d-flex card-body p-2">
			                           		<div style="width:150px;font-size:12px;">
												<p class="mb-0"><%=t.getTitle() %></p>
												<%String nick="";
												for(UserProfile u:userNick){ 
													if(t.getUserTbNo()==u.getNo()){
														nick=u.getNickName();
													}
												}%>
												<span><%=nick %></span>
											</div>
										</div>
									</div>
								</td>
							<%} %>
							</tr>
							<%if(tripList.size()==4){ %>
							<tr>
								<td colspan="4" style="text-align: center;">
									<button class="btn" onclick="location.replace('<%=request.getContextPath()%>/myPage/myConTrip.do?userNo=<%=loginUser.getNo()%>')">+더보기</button>
								</td>
							</tr>
							<%} %>
						</table>
					</div>
					
					<!-- 맛집 -->
					<div class="menu">
						<div class="manuBar">
							<div>
								<span>맛집</span>
							</div>
							<div>
								<img class="imgDrop" src="<%=request.getContextPath() %>/images/drop.png">
							</div>
						</div>
						<hr>
					</div>
					<!-- 닫힘 내용 -->
					<div>
						<!-- 정보 -->
						<div id="myDNInfo">
							<div style="height:45px;">
								<span>총 ?개의 ♥ 맛집</span>
							</div>
						</div>
						<div class="card d-flex">
							<div class="sl d-flex" style="overflow: hidden;">
								<img class="card-img slImg" src="<%=request.getContextPath()%>/images/images.jpeg">
								<img class="card-img slImg" src="<%=request.getContextPath()%>/views/picture/profile/henri.jpeg">
								<img class="card-img slImg" src="<%=request.getContextPath()%>/views/picture/profile/peng.jpg">
								<img class="card-img slImg" src="<%=request.getContextPath()%>/views/picture/profile/peng2.jpg">
								<img class="card-img slImg" src="<%=request.getContextPath()%>/views/picture/profile/peng3.jpeg">
							</div>
							<div><img id="prev" src="<%=request.getContextPath()%>/images/prev.png"></div>
							<%-- <div><img id="next" src="<%=request.getContextPath()%>/images/next.png"></div> --%>
						</div>
						<script>
							$(function(){
								$(".sl").find(".slImg").css("width","155");
								$("#next").click(function(){
									$(".sl").append($(".slImg").first());
									$(".sl").append($(".slImg").first());
									$(".sl").append($(".slImg").first());
									$(".sl").append($(".slImg").first());
								});
								
								/* setInterval(() => {
									$(".sl").append($(".slImg").first());
								}, 3000); */
							});
						</script>
					</div>
					
					
					
				</div>
			</section>
		</div>
	</div>
</div>
<%@ include file="/views/common/footer.jsp"%>
<style>
	div.menu{
		width:auto;
		cursor:pointer;
	}
	
	*{
        border-collapse:collapse;
        margin:0px;
        padding:0px;
        text-decoration: none;
        color:black;
        list-style:none;
        border:1px solid green;
    }
    
    #myDNInfo,#myBDInfo,.manuBar{
    	display:flex;
    	justify-content: space-between;
    	margin-left: 40px;
    	margin-right: 40px;
    }

	#dnCk2,.dnCk3,#bdCk2,.bdCk3{
		display:none;
	}
	
	#myMenuBtn{
		text-align:center;
	}
	
	#myMenuBtn>button{	
		width:150px;
		margin: 20px;
    	border-radius: 100px;
	}
</style>

<script>
	/* 다님길 */
	$(function(){
		$("#dnCk1>button").click(()=>{
			$("#dnCk1").css("display","none");
			$("#dnCk2").css("display","block");
			$(".dnCk3").css("display","block");
		});
		
		$("#dnEndBtn").click(()=>{
			$("#dnCk1").css("display","block");
			$("#dnCk2").css("display","none");
			$(".dnCk3").css("display","none");
		});
		
		$("#dnAll").click(()=>{
			if($("#dnAll").is(":checked")){							
				$(".dnCks").prop("checked",true);
			}else{
				$(".dnCks").prop("checked",false);
			}
		});
	});
	
	$(function(){
		$(".imgDrop").stop().css({"transform":"rotate(90deg)"});
	});
	var flag=false;
	$(".menu").click(function(){
		if(flag){
			$(this).next().slideDown();
			$(this).find(".imgDrop").stop().css({'transform': 'rotate(90deg)'},1000);
			flag=false;
		}else{
			$(this).next().slideUp();
			$(this).find(".imgDrop").stop().css({'transform': 'rotate(-90deg)'},1000);
			flag=true;
		}
	});
</script>
