<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*,com.laon.tripinfo.model.vo.*,com.laon.user.model.vo.User"%>
<%
	List<Mind> userMindList = (List)request.getAttribute("userMindList");
	List<Picture> pictureList = (List)request.getAttribute("pictureList");
	List<TripInfo2> tripInfoList = (List)request.getAttribute("tripInfoList");
	List<Mind> mindList = (List)request.getAttribute("mindList");
	
	User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css">
	<script src="https://unpkg.com/swiper/js/swiper.min.js"></script>
<style>
.swiper-slide {
	text-align: center;
	display: flex; /* 내용을 중앙정렬 하기위해 flex 사용 */
	align-items: center; /* 위아래 기준 중앙정렬 */
	justify-content: center; /* 좌우 기준 중앙정렬 */
	height: 180px;
}

.swiper-slide img {
	width: 150px; /* 이미지 사이즈 */
	max-width: 100%; /* 지우면 안됨 이미지 여러장일때 꼭 필요함 */
}

	.mind-delete{
								display:none;
							}
							.swiper-slide:hover .mind-delete{
								display:inline;
							}
							
</style>


<script>
	new Swiper('.swiper-container', {
	
		slidesPerView : 5, // 동시에 보여줄 슬라이드 갯수
		spaceBetween : 20, // 슬라이드간 간격
		slidesPerGroup : 5, // 그룹으로 묶을 수, slidesPerView 와 같은 값을 지정하는게 좋음
	
		// 그룹수가 맞지 않을 경우 빈칸으로 메우기
		// 3개가 나와야 되는데 1개만 있다면 2개는 빈칸으로 채워서 3개를 만듬
		loopFillGroupWithBlank : true,
	
		loop : false, // 무한 반복
		
		navigation : { // 네비게이션
			nextEl : '.swiper-button-next', // 다음 버튼 클래스명
			prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
		},
	});
</script>
</head>
<body>
<!------------------------------------------------찜목록----------------------------------------------------->
		
			
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<!---------------------------------------찜목록 헤더----------------------------------------------->
						<div class="modal-header">
							<h4 class="modal-title"><%=loginUser==null?1:loginUser.getNickName()%>님의 찜목록
							</h4>
							<button class="btn" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="맛집"%>&userNo=<%=loginUser==null?1:loginUser.getNo()%>')">X</button>
						</div>
						<!-----------------------------------------찜목록 바디---------------------------------------------->
						<div class="modal-body">
							<div id="mind-accordion">
							
							<%
							List<TripInfo2> foodList = new ArrayList<TripInfo2>();
							List<TripInfo2> hotelList = new ArrayList<TripInfo2>();
							List<TripInfo2> hotspotList = new ArrayList<TripInfo2>();
							List<Picture> foodPictureList = new ArrayList<Picture>();
							List<Picture> hotelPictureList = new ArrayList<Picture>();
							List<Picture> hotspotPictureList = new ArrayList<Picture>();
							
							for(Mind m : userMindList){
								for(Picture p : pictureList){
									if(m.getTripinfoNo()==p.getTripinfoNo()){
										int tripNo = m.getTripinfoNo();
										for(TripInfo2 ti : tripInfoList){
											if(tripNo == ti.getTripinfoNo()){
												String category = ti.getTripinfoCategory();
												
												switch(category){
												case "맛집":
													foodList.add(ti);
													foodPictureList.add(p);
													break;
													
												case "명소":
													hotspotList.add(ti);
													hotspotPictureList.add(p);
													break;
													
												case "숙소":
													hotelList.add(ti);
													hotelPictureList.add(p);
													break;
												}
											}
										}
									}
								}
							}
												
														
							%>
						<div class="card">
							<div class="card-header">
										<h4>맛집</h4>
							</div>
							<div id="collapseOne">
								<div class="swiper-container">
									<div class="swiper-wrapper">
										<%for(Picture p : foodPictureList){
											if(p.getImage().contains("1")){
										%>
										<div class="swiper-slide" >
											<div class="daasf">
												<div class="dsa">
													<img src="<%=request.getContextPath()%>/views/picture/tripinfo/<%=p.getImage()%>" alt="..."  width="150px" height="150px">
												</div>
												<input type="hidden" class="tripinfoNo" value="<%=p.getTripinfoNo()%>">
												<input type="hidden" class="tripinfoNo" value="<%=loginUser==null?"":loginUser.getNo()%>">
												<div class="d-flex justify-content-center ">
													<div class="mind-delete" style="width:30px">
														<button class="mind-delete-btn" style="padding:0;"><img src="<%=request.getContextPath()%>/views/picture/icon/142125213.jpg" alt="..." width="30px" height="30px"></button>
													</div>
												</div>
											</div>
										</div>
										<%
										}
										}
										%>
									</div>

									<!-- <!— 네비게이션 —> -->
									<div class="swiper-button-next"></div>
									<!-- <!— 다음 버튼 (오른쪽에 있는 버튼) —> -->
									<div class="swiper-button-prev"></div>
									<!-- <!— 이전 버튼 —> -->
								</div>	
							</div>																	
						</div>
						
						
							
						<div class="card">
									<div class="mind-room">
										<h4>숙소</h4>
									</div>
							<div id="collapseTwo" class="collapse show">
										
								
							<div class="swiper-container">
								<div class="swiper-wrapper">
									<%for(Picture p : hotelPictureList){
										if(p.getImage().contains("1")){
										%>
								<div class="swiper-slide">
									<div class="daasf">
										<div class="dsa">
											<img src="<%=request.getContextPath()%>/views/picture/tripinfo/<%=p.getImage() %>" alt="..." width="150px" height="150px">
										</div>	
										<input type="hidden" class="tripinfoNo" value="<%=p.getTripinfoNo()%>">
										<input type="hidden" class="tripinfoNo" value="<%=loginUser==null?"":loginUser.getNo()%>">
										<div class="d-flex justify-content-center ">
											<div class="mind-delete" style="width:30px">
												<button class="mind-delete-btn" style="padding:0;"><img src="<%=request.getContextPath()%>/views/picture/icon/142125213.jpg" alt="..." width="30px" height="30px"></button>
											</div>
										</div>
									</div>
								</div>
									<%} 
									}%>
								</div>

								<!-- <!— 네비게이션 —> -->
								<div class="swiper-button-next"></div>
								<!-- <!— 다음 버튼 (오른쪽에 있는 버튼) —> -->
								<div class="swiper-button-prev"></div>
								<!-- <!— 이전 버튼 —> -->
							</div>
						</div>
					</div>
								
								<div class="card">
									<div class="card-header collapsed card-link mind-hotspot"
										data-toggle="collapse" href="#collapseThree">
										<h4>명소</h4>
									</div>
									<div id="collapseThree" class="collapse show"
										data-parent="#accordion">
										
										
											<div class="swiper-container">
								<div class="swiper-wrapper">
									<%for(Picture p : hotspotPictureList){
										if(p.getImage().contains("1")){%>
								<div class="swiper-slide">
									<div>
										<div>
											<img src="<%=request.getContextPath()%>/views/picture/tripinfo/<%=p.getImage() %>" alt="..." width="150px" height="150px">
										</div>
										<input type="hidden" class="tripinfoNo" value="<%=p.getTripinfoNo()%>">
										<input type="hidden" class="tripinfoNo" value="<%=loginUser==null?"":loginUser.getNo()%>">
										<div class="d-flex justify-content-center ">
											<div class="mind-delete" style="width:30px">
												<button class="mind-delete-btn" style="padding:0;"><img src="<%=request.getContextPath()%>/views/picture/icon/142125213.jpg" alt="..." width="30px" height="30px"></button>
											</div>
										</div>
									</div>
								</div>
									<%}
										}%>
								</div>

								<!-- <!— 네비게이션 —> -->
								<div class="swiper-button-next"></div>
								<!-- <!— 다음 버튼 (오른쪽에 있는 버튼) —> -->
								<div class="swiper-button-prev"></div>
								<!-- <!— 이전 버튼 —> -->
							</div>
										</div>
									</div>
								
							</div>
						</div>
					</div>
				</div>
</body>
<script>

<%-- $(function(){
	
	$(".mind-delete-btn").click(function(e){
		
		 
		
		 $.ajax({
			url:"<%=request.getContextPath()%>/tripinfo/deleteMind.do",
			type:"post",
			data: {
				
				tripinfoNo : $(this).parent("input:eq(1)").val(),
				userNo :  $(this).parent("input:eq(2)").val()
			},
			success:function(data){
				console.log(data);
			},
			error:(r,e,m)=>{ 
				console.log(r);
				console.log(m);
			}
		})
	})

}) 



 <%-- $(function(){
	
	var userNo = $("#userNo").val();
	
	$("#myHeart").click(function(e){
		
		$.ajax({
			url:"<%=request.getContextPath()%>/tripinfo/userMind.do?userNo="+userNo,
			type:"get",
			success:function(data){
				$("#myModal").html(data);
			}
		});
		
		$("#myModal").modal({
			remote : '<%=request.getContextPath()%>/views/tripinfo/myHeartModal.jsp'
		});	
	});	
})  --%>
</script>

</html>