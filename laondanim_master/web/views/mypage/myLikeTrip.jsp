<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.laon.etc.model.vo.*,com.laon.trip.model.vo.TripMyCon,com.laon.tripinfo.model.vo.TripinfoMyMind" %>
<%
	List<Like> likeT=(List)request.getAttribute("likeT");
	List<TripMyCon> tripList=(List)request.getAttribute("tripList");
	List<UserProfile> userNick=(List)request.getAttribute("userNick");
	int likeTripCount=(int)request.getAttribute("likeTripCount");
	String myLTPasing=(String)request.getAttribute("myLTPasing");
%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
<%@ include file="/views/common/header.jsp"%>
<div style="height: 170px;"></div>
<div class="container">
	<div class="row">
	   	<div class="col-4">
			<%@ include file="/views/mypage/myPageAside.jsp" %>
		</div>
		<div class="col-8">
			<section class="d-flex flex-column justify-content-center align-items-center">
				<div id="myMenuBtn">
					<button type="button" id="myCon" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageContent.do?userNo=<%=loginUser.getNo()%>')">내 컨텐츠</button>
					<button type="button" id="myH" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageHeart.do?userNo=<%=loginUser.getNo()%>')">내 마음함</button>
					<button type="button" id="myDh" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageDong.do?userNo=<%=loginUser.getNo()%>')">내 동행</button>
				</div>
				<div id="myPageView" class="w-100">
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
						<div id="myLTInfo">
							<div style="height:45px;">
								<span>총 <%=likeTripCount %>개의 ♥ 다님길</span>
							</div>
							<div id="ltCk1">
								<button class="btn">선택삭제</button>
							</div>
							<div id="ltCk2">
								<label><input type="checkbox" id="jDhAll">&nbsp;전체 선택</label>&nbsp;&nbsp;|&nbsp;&nbsp;
								<button class="btn">삭제</button>&nbsp;&nbsp;|&nbsp;&nbsp;
								<button class="btn" id="ltEndBtn">돌아가기</button>
							</div>
						</div>
						<!-- 게시글위치 -->
						<table id="ltTbl">
							<tr class="d-flex flex-wrap justify-content-center">
							<%for(TripMyCon t:tripList){ %>
								<td class="p-1">
									<div class="ltCk3" style="margin:10px;">
										<input type="checkbox" class="ltCks">
									</div>
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
						</table>
						<div class="d-flex justify-content-center">
							<%=myLTPasing %>
						</div>
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
        /* border:1px solid green; */
    }
    
    #myLTInfo,.manuBar{
    	display:flex;
    	justify-content: space-between;
    	margin-left: 40px;
    	margin-right: 40px;
    }

	#ltCk2,.ltCk3{
		display:none;
	}
	
	#myMenuBtn{
		text-align:center;
	}
	
	#myMenuBtn>#myH{
		color: white;
    	background-color: #00abbf;
	}
	
	#myMenuBtn>button{	
		width:150px;
		margin: 20px;
    	border-radius: 100px;
    	border-radius: 20px;
	    background-color: white;
	    border: 2px solid #00abbf;
	    color: #00abbf;
	    padding: 6px 15px 6px 15px;
	}
	
	#myMenuBtn>button:hover{
		color: white;
    	background-color: #00abbf;
	}
</style>

<script>
	/* 좋아요 여행기 */
	$(function(){
		$("#ltCk1>button").click(()=>{
			$("#ltCk1").css("display","none");
			$("#ltCk2").css("display","block");
			$(".ltCk3").css("display","block");
		});
		
		$("#ltEndBtn").click(()=>{
			$("#ltCk1").css("display","block");
			$("#ltCk2").css("display","none");
			$(".ltCk3").css("display","none");
		});
		
		$("#ltAll").click(()=>{
			if($("#ltAll").is(":checked")){							
				$(".ltCks").prop("checked",true);
			}else{
				$(".ltCks").prop("checked",false);
			}
		});
	});

	$(function(){
		$(".imgDrop").stop().css({"transform":"rotate(-90deg)"});
	});
	var flag=false;
	$(".menu").click(function(){
		if(flag){
			$(this).next().slideDown();
			$(this).find(".imgDrop").stop().css({'transform': 'rotate(-90deg)'},1000);
			flag=false;
		}else{
			$(this).next().slideUp();
			$(this).find(".imgDrop").stop().css({'transform': 'rotate(90deg)'},1000);
			flag=true;
		}
	});
</script>