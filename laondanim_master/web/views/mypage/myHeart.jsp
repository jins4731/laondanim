<%@page import="java.util.ArrayList"%>
<%@page import="com.laon.trip.model.vo.TripMyCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.laon.etc.model.vo.*,com.laon.trip.model.vo.TripMyCon,com.laon.tripinfo.model.vo.TripinfoMyMind" %>
<%
	List<Like> likeT=(List)request.getAttribute("likeT");
	List<TripMyCon> tripList=(List)request.getAttribute("tripList");
	List<UserProfile> userNick=(List)request.getAttribute("userNick");
	int likeTripCount=(int)request.getAttribute("likeTripCount");
	List<Mind> mind=(List)request.getAttribute("mind");
	List<TripinfoMyMind> mindList=(List)request.getAttribute("mindList");
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
								<span>여행기</span>
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
								<span>총 <%=likeTripCount %>개의 ♥ 여행기</span>
							</div>
						</div>
						<!-- 게시글위치 -->
						<%if(tripList.size()>0){%>
						<table id="ltTbl">
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
												<img src="<%=request.getContextPath() %>/images/images.jpeg" class="card-img" alt="..." width="155px" height="155px" onclick="location.replace('<%=request.getContextPath()%>/trip/tripView.do?no=<%=t.getNo()%>')">
											<%}else{ %>
												<img src="<%=request.getContextPath() %>/views/picture/trip/<%=t.getImage()%>" class="card-img" alt="..." width="155px" height="155px" onclick="location.replace('<%=request.getContextPath()%>/trip/tripView.do?no=<%=t.getNo()%>')">
											<%} %>
			                           </div>
			                           <div class="d-flex card-body p-2">
			                           		<div style="width:150px;font-size:12px;">
												<p class="mb-0 tover"><%=t.getTitle() %></p>
												<%String nick="";
												for(UserProfile u:userNick){ 
													if(t.getUserTbNo()==u.getNo()){
														nick=u.getNickName();
													}
												}%>
												<span><%=nick %></span>
											</div>
											<div class="likeClick">
												<div class="likeCan">
													<button class="myTripLike">
														<%for(Like l:likeT){ 
															if(l.getTripNo()==t.getNo()){%>
																<img src="<%=request.getContextPath()%>/views/picture/trip/likeUnchecked.png" style="width:30px;height:30px;" onclick="location.replace('<%=request.getContextPath()%>/mypage/myLikeTripCancled.do?userNo=<%=loginUser.getNo()%>&likeNo=<%=l.getNo()%>')">
														<%} }%>
													</button>
												</div>
												<img class="ori" src="<%=request.getContextPath() %>/views/picture/trip/likeChecked.png" style="width:30px;height:30px;">
											</div>
										</div>
									</div>
								</td>
								<%} %>
							</tr>
							<%if(tripList.size()==4){ %>
							<tr>
								<td colspan="4" style="text-align: center;">
									<button class="btn" onclick="location.replace('<%=request.getContextPath()%>/myPage/myLikeTrip.do?userNo=<%=loginUser.getNo()%>')">+더보기</button>
								</td>
							</tr>
							<%} %>
						</table>
						<%}else{  %>
						<div style="text-align: center;">
							<span>관심있는 여행기가 없습니다.</span>
						</div>
						<%} %>
					</div>
					
					<%List<TripinfoMyMind> restaurant=new ArrayList<TripinfoMyMind>();
					List<TripinfoMyMind> lodging=new ArrayList<TripinfoMyMind>();
					List<TripinfoMyMind> attraction=new ArrayList<TripinfoMyMind>();
					int resCount=0;
					int lodCount=0;
					int attCount=0;
					for(TripinfoMyMind tm:mindList){
						int count=1;
						if(tm.getCategory().equals("맛집")){
							restaurant.add(tm);
							resCount+=count;
						}else if(tm.getCategory().equals("숙소")){
							lodging.add(tm);
							lodCount+=count;
						}else if(tm.getCategory().equals("명소")){
							attraction.add(tm);
							attCount+=count;
						}
					} %>
					
					<!-- 맛집 -->
					<div class="menu" style="padding-top:20px;">
						<div class="manuBar">
							<div>
								<span>맛집</span>
							</div>
							<div><img class="imgDrop" src="<%=request.getContextPath() %>/images/drop.png"></div>
						</div>
						<hr>
					</div>
					<!-- 닫힘 내용 -->
					<div>
						<!-- 정보 -->
						<div id="myResInfo">
							<div style="height:45px;">
								<span>총 <%=resCount %>개의 ♥ 맛집</span>
							</div>
						</div>
						<%if(restaurant.size()>0){ %>
						<div class="swiper-container">
							<div class="swiper-wrapper">
							<%for(TripinfoMyMind res:restaurant){ %>
								<div class="swiper-slide">
									<div class="broken">
										<button class="btn btn-resMind">
											<img style="width:30px;height:30px;" src="<%=request.getContextPath() %>/images/brokenHeart.png">
											<input type="hidden" value="<%=res.getNo() %>" class="mind">
										</button>
									</div>
									<img class="card-img" src="<%=request.getContextPath()%>/views/picture/tripinfo/<%=res.getImage()%>">
								</div>
							<%} %>
							</div>
							
							<!-- 네비게이션 -->
							<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
							<div class="swiper-button-prev"></div><!-- 이전 버튼 -->
						</div>
						<%}else{ %>
							<div style="text-align: center">
								<span>찜한 맛집이 없습니다.</span>
							</div>
						<%} %>
					</div>
					
					<!-- 숙소 -->
					<div class="menu" style="padding-top:20px;">
						<div class="manuBar">
							<div>
								<span>숙소</span>
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
						<div id="myLodInfo">
							<div style="height:45px;">
								<span>총 <%=lodCount %>개의 ♥ 숙소</span>
							</div>
						</div>
						<%if(lodging.size()>0){ %>
						<div class="swiper-container">
							<div class="swiper-wrapper">
							<%for(TripinfoMyMind lod:lodging){ %>
								<div class="swiper-slide">
									<div class="broken">
										<button class="btn btn-lodMind">
											<img style="width:30px;height:30px;" src="<%=request.getContextPath() %>/images/brokenHeart.png">
											<input type="hidden" value="<%=lod.getNo() %>" class="mind">
										</button>
									</div>
									<img class="card-img" src="<%=request.getContextPath()%>/views/picture/tripinfo/<%=lod.getImage()%>">
								</div>
							<%} %>
							</div>
						
							<!-- 네비게이션 -->
							<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
							<div class="swiper-button-prev"></div><!-- 이전 버튼 -->
						</div>
						<%}else{ %>
							<div style="text-align: center">
								<span>찜한 숙소가 없습니다.</span>
							</div>
						<%} %>
					</div>
					
					<!-- 명소 -->
					<div class="menu" style="padding-top:20px;">
						<div class="manuBar">
							<div>
								<span>명소</span>
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
						<div id="myAttInfo">
							<div style="height:45px;">
								<span>총 <%=attCount %>개의 ♥ 명소</span>
							</div>
						</div>
						<%if(attraction.size()>0){ %>
						<div class="swiper-container">
							<div class="swiper-wrapper">
							<%for(TripinfoMyMind att:attraction){ %>
								<div class="swiper-slide">
									<div class="broken">
										<button class="btn btn-attMind">
											<img style="width:30px;height:30px;" src="<%=request.getContextPath() %>/images/brokenHeart.png">
											<input type="hidden" value="<%=att.getNo() %>" class="mind">
										</button>
									</div>
									<img class="card-img" src="<%=request.getContextPath()%>/views/picture/tripinfo/<%=att.getImage()%>">
								</div>
							<%} %>
							</div>
						
							<!-- 네비게이션 -->
							<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
							<div class="swiper-button-prev"></div><!-- 이전 버튼 -->
						</div>
						<%}else{ %>
							<div style="text-align: center">
								<span>찜한 명소가 없습니다.</span>
							</div>
						<%} %>
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
    
    #myLTInfo,#myResInfo,#myLodInfo,#myAttInfo,.manuBar{
    	display:flex;
    	justify-content: space-between;
    	margin-left: 40px;
    	margin-right: 40px;
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
	
	.swiper-slide {
		text-align:center;
		display:flex; /* 내용을 중앙정렬 하기위해 flex 사용 */
		align-items:center; /* 위아래 기준 중앙정렬 */
		justify-content:center; /* 좌우 기준 중앙정렬 */
		height:180px;
		position:relative;
	}
	.swiper-slide img {
		width:150px; /* 이미지 사이즈 */
		height:150px;
		max-width:100%; /* 지우면 안됨 이미지 여러장일때 꼭 필요함 */
	}
	
	.broken{
		position:absolute;
		visibility: hidden;
	}
	
	.swiper-slide:hover .broken{
		visibility: visible;
	}
	
	section .card-body{
		display:flex;
	}
	
	section .card-body:first-child {
		flex:8;
	}
	
	section .card-body:last-child {
		margin-top:10px;
	}
	
	.likeClick{
		position:relative;
	}
	
	.likeCan{
		position:absolute;
		visibility: hidden;
	}
	
	.likeClick:hover .likeCan{
		visibility: visible;
	}
	
	.likeClick:hover .ori{
		visibility: hidden;
	}
	
	.tover{
		white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
	}
</style>

<script>
	new Swiper('.swiper-container', {
	
		slidesPerView : 4, // 동시에 보여줄 슬라이드 갯수
		spaceBetween : 20, // 슬라이드간 간격
		slidesPerGroup : 4, // 그룹으로 묶을 수, slidesPerView 와 같은 값을 지정하는게 좋음
	
		// 그룹수가 맞지 않을 경우 빈칸으로 메우기
		// 3개가 나와야 되는데 1개만 있다면 2개는 빈칸으로 채워서 3개를 만듬
		loopFillGroupWithBlank : true,
	
		loop : false, // 무한 반복
		
		navigation : { // 네비게이션
			nextEl : '.swiper-button-next', // 다음 버튼 클래스명
			prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
		},
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
	
	/* 맛집 좋아요 취소 */
	$(function(){
		$(".btn-resMind").click(function(e){
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/myMindCancled.do",
				data:{mindNo:$(this).find("input").val(),
					userNo:<%=loginUser.getNo()%>},
				success:function(data){
					if(data>0){
						$(this).parent().parent().addClass("d-none");
						var oldRes=$("#myResInfo").find("span").html();
						var newRes=parseInt(oldRes)-1;
						$("#myResInfo").find("span").html(newRes);
					}
				}
			});
			location.reload();
		});
	});
	
	/* 	숙소 좋아요 취소 */
	$(function(){
		$(".btn-LodMind").click(function(e){
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/myMindCancled.do",
				data:{mindNo:$(this).find("input").val(),
					userNo:<%=loginUser.getNo()%>},
				success:function(data){
					if(data>0){
						$(this).parent().parent().addClass("d-none");
						var oldLod=$("#myLodInfo").find("span").html();
						var newLod=parseInt(oldLod)-1;
						$("#myLodInfo").find("span").html(newLod);
					}
				}
			});
			location.reload();
		});
	});
	
	/* 명소 좋아요 취소 */
	$(function(){
		$(".btn-attMind").click(function(e){
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/myMindCancled.do",
				data:{mindNo:$(this).find("input").val(),
					userNo:<%=loginUser.getNo()%>},
				success:function(data){
					if(data>0){
						$(this).parent().parent().addClass("d-none");
						var oldAtt=$("#myAttInfo").find("span").html();
						var newAtt=parseInt(oldAtt)-1;
						$("#myAttInfo").find("span").html(newAtt);
					}
				}
			});
			location.reload();
		});
	});
</script>