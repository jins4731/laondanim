<%@page import="java.util.Collections"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.laon.tripinfo.model.vo.Tripinfo"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.laon.etc.model.vo.Picture"%>
<%@page import="java.util.List"%>
<%@page import="com.laon.trip.model.vo.TripSchedule"%>
<%@page import="com.laon.user.model.vo.User"%>
<%@page import="com.laon.trip.model.vo.Trip"%>
<%@page import="com.laon.common.CommonKey"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%
	Object oTrip = request.getAttribute(CommonKey.TRIP_ITEM);
	Trip trip = null;
	if (oTrip != null) {
		trip = (Trip) oTrip;
	}
	//여행기 사진
	List<Picture> tripPicList = trip.getPictureList();
	//유저 정보
	User user = trip.getUser();
	//유저 사진
	List<Picture> userPicList = user.getPictureList();
	// 스케줄 정보
	List<TripSchedule> tripSchedulList = trip.getTripScheduleList();
	Set<Integer> daySet = new HashSet();
	for (int i = 0; i < tripSchedulList.size(); i++) {
		daySet.add(tripSchedulList.get(i).getDay());
	}
	List<Integer> dayList = new ArrayList(daySet);
	Collections.sort(dayList);

	// 스케줄 관련 여행정보
	Map<Integer, Tripinfo> tripinfoMap = new HashMap();
	// 스케줄 관련 여행정보 사진
	Map<Integer, List<Picture>> pictureListMap = new HashMap();
	for (int i = 0; i < tripSchedulList.size(); i++) {
		TripSchedule schedule = tripSchedulList.get(i);
		tripinfoMap.put(schedule.getTripinfoNo(), schedule.getTripinfo());
		pictureListMap.put(schedule.getTripinfoNo(), schedule.getTripinfo().getPictureList());
	}

	// 스케줄 화면 뿌려줄 맵 작성
	Map<Integer, List<TripSchedule>> dayMap = new HashMap();
	for (int i = 0; i < dayList.size(); i++) {

		List<TripSchedule> list = new ArrayList();
		for (int k = 0; k < tripSchedulList.size(); k++) {
			TripSchedule schedule = tripSchedulList.get(k);
			if (schedule.getDay() == (i + 1)) {
				list.add(schedule);
			}
		}
		dayMap.put(i, list);
	}

	System.out.println(tripPicList);
	System.out.println(user);
	System.out.println(userPicList);
	System.out.println(tripSchedulList);
	System.out.println(tripinfoMap);
	System.out.println(pictureListMap);
	System.out.println(dayMap);
%>







	<!-- 지우면 안되는거 -->
	<!-- 지우면 안되는거 -->
    <script src="<%=request.getContextPath() %>/js/bootstrap-datepicker.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap-datepicker.ko.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/mdb.min.css">
    <script src="<%=request.getContextPath() %>/js/mdb.min.js"></script>
 <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=40b8b885a553f3222dde4e5effec0d3e&libraries=services"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=40b8b885a553f3222dde4e5effec0d3e"></script>	
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="<%=request.getContextPath() %>/js/lodash.js"></script>
    <!-- 지우면 안되는거 -->
    <!-- 지우면 안되는거 -->
	<style>
		@media screen and (min-width: 576px) {
			.container-fluid {
				width: 1336px;
			}
		}

		@media screen and (min-width: 768px) {
			.container-fluid {
				width: 1336px;
			}
		}

		@media screen and (min-width: 992px) {
			.container-fluid {
				width: 1336px;
			}
		}

		@media screen and (min-width: 1400px) {
			.container-fluid {
				width: 1336px;
			}
		}




		#head {
			height: 230px;
			background-color: rgba(53, 171, 191, 0.5);
			background-image: url(<%=request.getContextPath()%>/views/picture/trip/<%=tripPicList.get(0).getImage()%>);
			background-size: cover;
			background-position: center center;
		}

	

		.filp {
			transform: rotate(90deg);
			-moz-transform: scaleX(-1);
			-o-transform: scaleX(-1);
			-webkit-transform: scaleX(-1);
			transform: scaleX(-1);
			filter: FlipH;
			-ms-filter: "FlipH";
		}

		.walk {
			transform: rotate(90deg);
			-moz-transform: scaleX(-1);
			-o-transform: scaleX(-1);
			-webkit-transform: scaleX(-1);
			transform: scaleX(-1);
			filter: FlipH;
			-ms-filter: "FlipH";
		}

		.carousel-inner img {
			width: 100%;
			height: 100%;
			object-fit: contain;
		}
		
		.navbar {
		    font-weight: normal;
		    -webkit-box-shadow: none;
		    box-shadow: none;
		}
		header{
			display: flex;
			justify-content: center;
			align-items: center;
		}		
		#title, #tag{
			font-weight: bolder;
			color: white;
			text-shadow: 0 0 5px #000000;
		}
        .ldBtnC{
            border-radius: 20px;
            background-color: white;
            border: 2px solid #00abbf;
            color: #00abbf;
            width: 120px;
            margin-right: 15px;
            padding: 6px 15px 6px 15px;
        }  
        .ldBtnC:hover,.ldBtnC:active {
            color: white;
            background-color: #00abbf;
        } 
        .ldBtn{
            border-radius: 20px;
            background-color: white;
            border: 2px solid #00abbf;
            color: #00abbf;
            padding: 6px 15px 6px 15px;
        }  
        .ldBtn:hover,.ldBtn:active {
            color: white;
            background-color: #00abbf;
        }  		
	</style>
	
	<div style="height: 170px;"></div>
	<section class="container-fluid d-flex flex-column align-items-center">
		<div id="head" class="col">


			<div class="row justify-content-center">
				<h1 class="mt-1" id="title"><%=trip.getTitle()%></h1>
			</div>


			<div class="row justify-content-center">
				<div>
					<span id="tag" class="w-50"><%=trip.getTag()%></span>
				</div>

			</div>


			<div class="row">


				<div class="col-4 font-weight-bold text-dark">
					<div class="row align-items-center p-1">
						<label for="travleLocale" class="col-4 m-0 ">여행지역</label> <span id="taravleLocale"
							class="col-8 border-bottom border-secondary"><%=trip.getTravleLocale()%></span>
					</div>
					<div class="row align-items-center p-1">
						<label for="travleLocale" class="col-4 m-0 ">인원 수</label> <span id="peopleNum"
							class="col-8 border-bottom border-secondary"><%=trip.getPeopleNum()%>명</span>
					</div>
					<div class="row align-items-center p-1">
						<label for="travleLocale" class="col-4 m-0 ">여행유형</label> <span id="travleType"
							class="col-8 border-bottom border-secondary"><%=trip.getTravleType()%></span>
					</div>
					<div class="row align-items-center p-1">
						<label for="travleLocale" class="col-4 m-0 ">여행일</label>
						<div class="d-flex  col-8 border-bottom border-secondary ">
							<img src="../picture/trip/icon/calendar.png" width="20px" alt="">
							<span id="travleStartDate" class="ml-2"><%=trip.getTravleStartDate()%></span>~
							<span id="travleEndDate"><%=trip.getTravleEndDate()%></span>
						</div>
					</div>
				</div>


				<div class="col-8">
					<div class="row h-100">
						<div class=col-8></div>

						<div class="col-4 align-content-center">
							<div class="row h-75"></div>
							<div class="row h-25 p-1 align-items-center justify-content-end">
								<div class="d-flex border-danger justify-content-center">
									<img id="image" class="d-block rounded-circle" width="20px" height="20px"
										src="<%=request.getContextPath() + "/" + userPicList.get(0).getImage()%>"
										alt="frog">
								</div>
								<label class=" m-0 border-primary text-center" for="image"
									id="nickName"><%=user.getNickName()%></label>
								<div class="dropdown">
									<a class=" m-0 p-0 border-success text-center dropdown-toggle-split"
										data-toggle="dropdown" href=""><img class="align-text-top"
											src="../picture/trip/icon/menu.png" width="20px" height="20px"
											alt="menu"></a>
									<div class="dropdown-menu dropdown-menu-right">
										<div class="dropdown-item bg-transparent">
											<a href="javascript:void(0)" onclick="singoBt()"><img
													src="../picture/trip/icon/siren.png" width="20px" alt="">신고하기</a>
											<button class="btn btn-secondary ml-3">취소</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



		<div id="body" class="body col pt-4 border-top mt-3">
			<div class="row pl-2">
				<div class="d-flex col-3">
					<a id="courseTypeBt" onclick="courseTypeBt()" href="javascript:void(0)"
						class="col-5 d-block ldBtnC py-1 active text-center"> 코스 </a> <a id="reviewTypeBt"
						onclick="reviewTypeBt()" href="javascript:void(0)"
						class="col-5 d-block ldBtnC ml-3 py-1 text-center"> 후기 </a>
				</div>
			</div>





			<div id="courseContainer">
				<div class="row dropdown justify-content-center mb-5 mt-5">
					<button class="d-block ldBtnC dropdown-toggle" id="dayBt" data-save="1"
						data-toggle="dropdown"><%=dayList.get(0) %>일차</button>
					<div class="dropdown-menu">
						<%for(int i = 0 ;i< dayList.size();i++){ %>
						<a href="#" onclick="dayBt(event)" data-save="<%=(i+1)%>"
							class="dropdown-item"><%=dayList.get(i) %>일차</a>
						<%} %>
					</div>
				</div>

				<div class="row">
					<div class="col">

					</div>
					<div id="dayContainer" class="col-11">


						<%for(int i=0;i<dayMap.size();i++){
                		List<TripSchedule> list = dayMap.get(i);
                		
                	%>
						<%if(i==0){ %>
						<div id="day<%=""+(i+1) %>" name="day" class="row">
							<%}else{ %>
							<div id="day<%=""+(i+1) %>" name="day" class="row d-none">
								<%} %>
								<%for(int k=0;k<list.size();k++){
							TripSchedule schdule = list.get(k);
							Tripinfo info = tripinfoMap.get(schdule.getTripinfoNo());
							String image = info.getPictureList().get(0).getImage();
						%>
								<%if(k == 0){%>

								<div name="schduleStart" class="col-2 text-center p-2 "
									style="height: 100px; position: relative;">
									<div class="w-100 h-100 text-center view overlay zoom ">
										<img src="<%=request.getContextPath()%>/picture/trip/icon/start.png"
											width="120px" height="100%" class="d-inline-block rounded-lg py-1">
									</div>
								</div>



								<div name="schdule" onclick="scheduleItemBt(event)"
									
									class="col-2 text-center p-2" style="height: 100px;">
									<div class="w-100 h-100 text-center view overlay zoom ">
										<img src="<%=request.getContextPath() %>/views/picture/tripinfo/<%=image%>" width="120px"
											height="100%" class="d-inline-block rounded-lg py-1 shadow">
										<div class="mx-auto mask flex-center rgba-black-strong text-nowrap"
											style="width: 73%;height: 100%;z-index: 1;overflow: hidden;" data-address="<%=info.getAddress()%>" data-name="<%=info.getName() %>">
											<p class="white-text"><%=info.getName()%></p>
										</div>
									</div>
									<div class="col "
										style="position: absolute; top: 25px; left: -40px; width: 80px; height: 50px">
										<img class=""
											src="<%=request.getContextPath() %>/picture/trip/icon/<%=schdule.getTransport()%>.png"
											width="40px" height="25px" alt="">
										<span ><%=schdule.getRequiredHours()%>분</span>
									</div>
								</div>
								<%}else{%>
								<div name="schdule" onclick="scheduleItemBt(event)"
									data-address="<%=info.getAddress()%>" data-name="<%=info.getName() %>"
									class="col-2 text-center p-2" style="height: 100px;">
									<div class="w-100 h-100 text-center view overlay zoom ">
										<img src="<%=request.getContextPath() %>/views/picture/tripinfo/<%=image%>" width="120px"
											height="100%" class="d-inline-block rounded-lg py-1 shadow">
										<div class="mx-auto mask flex-center rgba-black-strong text-nowrap"
											style="width: 73%;height: 100%;z-index: 1;overflow: hidden;" data-address="<%=info.getAddress()%>" data-name="<%=info.getName() %>">
											<p class="white-text"><%=info.getName()%></p>
										</div>
									</div>
									<div class="col "
										style="position: absolute; top: 25px; left: -40px; width: 80px; height: 50px">
										<img class=""
											src="<%=request.getContextPath() %>/picture/trip/icon/<%=schdule.getTransport()%>.png"
											width="40px" height="25px" alt="">
										<span><%=schdule.getRequiredHours()%>분</span>
									</div>
								</div>
								<%}%>
							

							<%} %>

								<div name="schduleEnd" onclick="scheduleItemBt()" class="col-2 text-center p-2 order-1"
									style="height: 100px;">
									<div class="w-100 h-100 text-center view overlay zoom ">
										<img src="<%=request.getContextPath()%>/picture/trip/icon/home.png"
											width="120px" height="100%" class="d-inline-block rounded-lg py-1">
									</div>
								</div>
							</div>

							<%} %>


						</div> <!-- dayContainer -->



						<div class="col">

						</div>



					</div>

					<div class="col p-4">
						<div id="map" style="height:450px;"></div>
					</div>

				</div>





				<div id="reviewContainer" class="d-none">


					<div class="row p-5">


						<div id="reviewImage" class="col p-0 carousel slide rounded-sm bg-dark" data-ride="carousel">

							<!-- 인티케이터 -->
							<ul class="carousel-indicators">
								<%
								for (int i = 0; i < tripPicList.size(); i++) {
							%>
								<li data-target="#reviewImage" data-slide-to="<%=i%>" <%if (i == 0) {%> class="active" <%}%>></li>
							<%
								}
							%> </ul>



									<div class="carousel-inner d-inline-flex align-items-center"
									style="width:100%;height:500px;position: relative;">

										<%
								for (int i = 0; i < tripPicList.size(); i++) {
							%>
										<!-- 1번 아이템 -->
										<div class="carousel-item <%if (i == 0) {%>active<%}%>" style="width:100%;height:500px;"">
											<img src="<%=request.getContextPath()%>/views/picture/trip/<%=tripPicList.get(i).getImage()%>" alt=""
											style="width: 100%;height: 100%;object-fit: contain;">
											<!-- <div class="carousel-caption">
	<h3>Los Angeles</h3>
	<p>우리가 보낸 최고의 시간</p>
</div> -->
										</div>

										<%
								}
							%>

									</div>

									<a href="#reviewImage" data-slide="prev" class="carousel-control-prev"> <span
											class="carousel-control-prev-icon"  style="width: 50px;height: 50px;"></span>
									</a> <a href="#reviewImage" data-slide="next" class="carousel-control-next"> <span
											class="carousel-control-next-icon" style="width: 50px;height: 50px;"></span>
									</a>
						</div>
					</div>

					<div class="row p-5">
						<textarea class="form-control" rows="5" id="content" name="text" readonly>
 <%=trip.getContent()%>
			</textarea>
					</div>
				</div>

			</div>





	</section>




	<script>
		$(function () {
			console.log("onLoad");
		});

		function courseTypeBt() {
			console.log("courseTypeBt")
			$("#courseContainer").removeClass("d-none");
			$("#reviewContainer").addClass("d-none");
			$("#courseTypeBt").addClass("active");
			$("#reviewTypeBt").removeClass("active");
		}

		function reviewTypeBt() {
			console.log("reviewTypeBt")
			$("#reviewContainer").removeClass("d-none");
			$("#courseContainer").addClass("d-none");
			$("#reviewTypeBt").addClass("active");
			$("#courseTypeBt").removeClass("active");
		}

		function singoBt() {
			console.log("singoBt");
		}

		function dayBt(event) {
			console.log("dayBt")
			$("#dayBt").html($(event.target).html());
			$("#dayBt")[0].dataset.save = $(event.target)[0].dataset.save;
			for (let i = 0; i < $("[name='day']").length; i++) {
				$($("[name='day']")[i]).addClass("d-none");
			}
			$($("[name='day']")[($("#dayBt")[0].dataset.save) - 1]).removeClass("d-none");


		}


	


		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			mapOption = {
				center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				level: 3 // 지도의 확대 레벨
			};

		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption);


		function scheduleItemBt(event) {

			console.log("scheduleItemBt")
			console.log("nodeName : " + $.nodeName(event.target,"div"));
			var target = event.target;
			if($.nodeName(event.target,"div")){

			}else{
				target = $(event.target).parent()[0];
			}
			
			
			var search = target.dataset.address;
			var name = target.dataset.name;
			console.log("search : " + search);


			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();


			// 주소로 좌표를 검색합니다
			geocoder.addressSearch(search, function (result, status) {

				// 정상적으로 검색이 완료됐으면 
				if (status === kakao.maps.services.Status.OK) {

					var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

					// 결과값으로 받은 위치를 마커로 표시합니다
					var marker = new kakao.maps.Marker({
						map: map,
						position: coords
					});

					// 인포윈도우로 장소에 대한 설명을 표시합니다
					var infowindow = new kakao.maps.InfoWindow({
						content: '<div style="width:150px;text-align:center;padding:6px 0;">' + name + '</div>'
					});
					infowindow.open(map, marker);

					// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
					map.setCenter(coords);
				}
			});

		}

		console.log("length : " + $("#body div:not(#map)").length);















	</script>
	<div class="text-center mb-2">
		Icons made by <a href="https://www.flaticon.com/authors/those-icons" title="Those Icons">Those Icons</a> from <a
			href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a>
	</div>

	
<%@ include file="/views/common/footer.jsp"%> 