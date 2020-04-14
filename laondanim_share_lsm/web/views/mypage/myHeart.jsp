<%@page import="java.util.ArrayList"%>
<%@page import="com.laon.trip.model.vo.TripMyCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.laon.etc.model.vo.*,com.laon.tripinfo.model.vo.TripinfoMyMind" %>
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
					
					<%List restaurant=new ArrayList();
					List lodging=new ArrayList();
					List attraction=new ArrayList();
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
								<span>총 <%=resCount %>개의 ♥ 맛집</span>
							</div>
						</div>
						<div class="swiper-container">
							<div class="swiper-wrapper">
							<%-- <%for(){ %>
								<div class="swiper-slide"><img class="card-img" src="<%=request.getContextPath()%>/views/picture/profile/<%=%>"></div>
							<%} %> --%>
							</div>
						
							<!-- 네비게이션 -->
							<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
							<div class="swiper-button-prev"></div><!-- 이전 버튼 -->
						</div>
					</div>
					
					<!-- 숙소 -->
					<div class="menu">
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
						<div id="myDNInfo">
							<div style="height:45px;">
								<span>총 <%=lodCount %>개의 ♥ 숙소</span>
							</div>
						</div>
						<div class="swiper-container">
							<div class="swiper-wrapper">
							<%for(TripinfoMyMind tm:mindList){
								 if(tm.getCategory().equals("숙소")){ %>
								<div class="swiper-slide"><img src="<%=request.getContextPath()%>/views/picture/profile/<%=tm.getImage()%>"></div>
							<%} }%>
							</div>
						
							<!-- 네비게이션 -->
							<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
							<div class="swiper-button-prev"></div><!-- 이전 버튼 -->
						</div>
					</div>
					
					<!-- 명소 -->
					<div class="menu">
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
						<div id="myDNInfo">
							<div style="height:45px;">
								<span>총 <%=attCount %>개의 ♥ 명소</span>
							</div>
						</div>
						<div class="swiper-container">
							<div class="swiper-wrapper">
							<%for(TripinfoMyMind tm:mindList){
								 if(tm.getCategory().equals("명소")){ %>
								<div class="swiper-slide"><img src="<%=request.getContextPath()%>/views/picture/profile/<%=tm.getImage()%>"></div>
							<%} }%>
							</div>
						
							<!-- 네비게이션 -->
							<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
							<div class="swiper-button-prev"></div><!-- 이전 버튼 -->
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
    
    #myDNInfo,.manuBar{
    	display:flex;
    	justify-content: space-between;
    	margin-left: 40px;
    	margin-right: 40px;
    }

	#dnCk2,.dnCk3{
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
	
	.swiper-slide {
		text-align:center;
		display:flex; /* 내용을 중앙정렬 하기위해 flex 사용 */
		align-items:center; /* 위아래 기준 중앙정렬 */
		justify-content:center; /* 좌우 기준 중앙정렬 */
		height:180px;
	}
	.swiper-slide img {
		width:150px; /* 이미지 사이즈 */
		max-width:100%; /* 지우면 안됨 이미지 여러장일때 꼭 필요함 */
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