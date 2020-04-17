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


<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>여행기</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<link href="../css/trip/mdb.min.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=40b8b885a553f3222dde4e5effec0d3e"></script>
<script src="../js/trip/mdb.min.js"></script>
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

header {
	border: 2px solid red;
	box-sizing: border-box;
	height: 150px;
}

section {
	border: 2px solid green;
	box-sizing: border-box;
}

footer {
	border: 2px solid blue;
	box-sizing: border-box;
	height: 70px;
}

#head {
	/* height: 200px; */
	/* background-color: aquamarine; */
	/* background-image: url(./image/mesut-kaya-eOcyhe5-9sQ-unsplash.jpg); */
	background-size: cover;
	background-position: center center;
}

#head div {
	/* border: 1px solid black;
                box-sizing: border-box; */
	/* background-color: beige; */
	
}

#body {
	/* height: 500px; */
	/* background-color: thistle; */
	
}

#body div {
	/* border: 1px solid black;
                box-sizing: border-box; */
	/* background-color: beige; */
	
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
}
</style>
</head>

<body>
	<header class="container-fluid"></header>
	<section class="container-fluid">
		<div id="head" class="col">


			<div class="row justify-content-center">
				<h1 class="text-dark" id="title"><%=trip.getTitle()%></h1>
			</div>


			<div class="row justify-content-center">
				<div>
					<span id="tag" class="w-50"><%=trip.getTag()%></span>
				</div>

			</div>


			<div class="row">


				<div class="col-4 font-weight-bold text-dark">
					<div class="row align-items-center p-1">
						<label for="travleLocale" class="col-4 m-0 ">여행지역</label> <span
							id="taravleLocale" class="col-8 border-bottom border-secondary"><%=trip.getTravleLocale()%></span>
					</div>
					<div class="row align-items-center p-1">
						<label for="travleLocale" class="col-4 m-0 ">인원 수</label> <span
							id="peopleNum" class="col-8 border-bottom border-secondary"><%=trip.getPeopleNum()%>명</span>
					</div>
					<div class="row align-items-center p-1">
						<label for="travleLocale" class="col-4 m-0 ">여행유형</label> <span
							id="travleType" class="col-8 border-bottom border-secondary"><%=trip.getTravleType()%></span>
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
								<div class="d-flex border border-danger justify-content-center">
									<img id="image" class="d-block rounded-circle" width="20px"
										height="20px"
										src="<%=request.getContextPath() + "/" + userPicList.get(0).getImage()%>"
										alt="frog">
								</div>
								<label class=" m-0 border border-primary text-center"
									for="image" id="nickName"><%=user.getNickName()%></label>
								<div class="dropdown">
									<a
										class=" m-0 p-0 border border-success text-center dropdown-toggle-split"
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
					<a id="courseTypeBt" onclick="courseTypeBt()"
						href="javascript:void(0)"
						class="col-5 d-block btn btn-indigo py-1 active"> 코스 </a> <a
						id="reviewTypeBt" onclick="reviewTypeBt()"
						href="javascript:void(0)"
						class="col-5 d-block btn btn-indigo ml-3 py-1 "> 후기 </a>
				</div>
			</div>





			<div id="courseContainer">
                <div class="row dropdown justify-content-center">
                    <button class="d-block btn dropdown-toggle" id="dayBt" data-save="1"
                        data-toggle="dropdown"><%=dayList.get(0) %>일차</button>
                    <div class="dropdown-menu">
                        <%for(int i = 0 ;i< dayList.size();i++){ %>
                        <a href="#" onclick="dayBt(event)" data-save="<%=(i+1)%>" class="dropdown-item"><%=dayList.get(i) %>일차</a>
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

								<div name="schduleStart" class="col text-center p-2 " style="height: 100px; position: relative;">
									<div class="w-100 h-100 text-center view overlay zoom ">
										<img src="<%=request.getContextPath()%>/picture/trip/icon/start.png" width="120px" height="100%"
											class="d-inline-block rounded-lg py-1">
									</div>
								</div>



								<div name="schdule" onclick="scheduleItemBt()"
								data-address="<%=info.getAddress()%>" class="col-2 text-center p-2"
								style="height: 100px;">
								<div class="w-100 h-100 text-center view overlay zoom ">
									<img src="<%=request.getContextPath() %>>/upload/<%=image%>" width="120px" height="100%"
										class="d-inline-block rounded-lg py-1 shadow">
									<div class="mx-auto mask flex-center rgba-black-strong text-nowrap"
										style="width: 73%;height: 100%;z-index: 1;overflow: hidden;">
										<p class="white-text"><%=info.getName()%></p>
									</div>
								</div>
								<div class="col "
									style="position: absolute; top: 25px; left: -40px; width: 80px; height: 50px">
									<img class="" src="<%=request.getContextPath() %>/picture/trip/icon/<%=schdule.getTransport()%>.png" width="40px" height="25px" alt="">
									<span><%=schdule.getRequiredHours()%></span>
								</div>
							</div>
							<%}else{%>
								<div name="schdule" onclick="scheduleItemBt()"
								data-address="<%=info.getAddress()%>" class="col-2 text-center p-2"
								style="height: 100px;">
								<div class="w-100 h-100 text-center view overlay zoom ">
									<img src="<%=request.getContextPath() %>>/upload/<%=image%>" width="120px" height="100%"
										class="d-inline-block rounded-lg py-1 shadow">
									<div class="mx-auto mask flex-center rgba-black-strong text-nowrap"
										style="width: 73%;height: 100%;z-index: 1;overflow: hidden;">
										<p class="white-text"><%=info.getName()%></p>
									</div>
								</div>
								<div class="col "
									style="position: absolute; top: 25px; left: -40px; width: 80px; height: 50px">
									<img class="" src="<%=request.getContextPath() %>/picture/trip/icon/<%=schdule.getTransport()%>.png" width="40px" height="25px" alt="">
									<span><%=schdule.getRequiredHours()%></span>
								</div>
							</div>
							<%}%>
							

							<%} %>
							
							<div name="schduleEnd" onclick="scheduleItemBt()" class="col-2 text-center p-2 order-1"
								style="height: 100px;">
								<div class="w-100 h-100 text-center view overlay zoom ">
									<img src="<%=request.getContextPath()%>/picture/trip/icon/home.png" width="120px" height="100%"
										class="d-inline-block rounded-lg py-1">
								</div>
							</div>
                   		</div>
                   
                   <%} %>
                   
                   
                   
                   <%--  <div id="day1_1" class="row">
                    
                    
                        <div name="day1_1_1" onclick="scheduleItemBt()" data-save="1" class="col text-center p-2 "
                            style="height: 100px;position: relative;">
                            <div class="w-100 h-100 text-center view overlay zoom ">
                                <img src="<%=request.getContextPath() %>/picture/trip/icon/start.png" width="120px"
                                    height="100%" class="d-inline-block rounded-lg py-1">
                            </div>
                            <div class="col " style="position: absolute;top:25px;left: 155px;width: 80px;height:50px">
                                <img class="" src="<%=request.getContextPath() %>/picture/trip/icon/airplane.png"
                                    width="40px" height="25px" alt="">
                                <span>30분</span>
                            </div>
                        </div>

                        <div name="day1_1_2" onclick="scheduleItemBt()" data-save="2" class="col text-center p-2"
                            style="height: 100px;">
                            <div class="w-100 h-100 text-center view overlay zoom ">
                                <img src="<%=request.getContextPath() %>/picture/trip/image/01.jpg" width="120px"
                                    height="100%" class="d-inline-block rounded-lg py-1 shadow">
                            </div>
                            <div class="col " style="position: absolute;top:25px;left: 155px;width: 80px;height:50px">
                                <img class="walk" src="<%=request.getContextPath() %>/picture/trip/icon/walk.png"
                                    width="40px" height="25px" alt="">
                                <span>20분</span>
                            </div>
                        </div>

                        <div name="day1_1_3" onclick="scheduleItemBt()" data-save="2" class="col text-center p-2"
                            style="height: 100px;">
                            <div class="w-100 h-100 text-center view overlay zoom ">
                                <img src="<%=request.getContextPath() %>/picture/trip/image/02.jpg" width="120px"
                                    height="100%" class="d-inline-block rounded-lg py-1 shadow">
                            </div>
                            <div class="col " style="position: absolute;top:25px;left: 155px;width: 80px;height:50px">
                                <img class="" src="<%=request.getContextPath() %>/picture/trip/icon/train.png"
                                    width="40px" height="25px" alt="">
                                <span>1시간30분</span>
                            </div>
                        </div>

                        <div name="day1_1_4" onclick="scheduleItemBt()" data-save="2" class="col text-center p-2"
                            style="height: 100px;">
                            <div class="w-100 h-100 text-center view overlay zoom ">
                                <img src="<%=request.getContextPath() %>/picture/trip/image/03.jpg" width="120px"
                                    height="100%" class="d-inline-block rounded-lg py-1 shadow">
                            </div>
                            <div class="col " style="position: absolute;top:25px;left: 155px;width: 80px;height:50px">
                                <img class="" src="<%=request.getContextPath() %>/picture/trip/icon/subway.png"
                                    width="40px" height="25px" alt="">
                                <span>56분</span>
                            </div>
                        </div>

                        <div name="day1_1_5" onclick="scheduleItemBt()" data-save="2" class="col text-center  p-2"
                            style="height: 100px;">
                            <div class="w-100 h-100 text-center view overlay zoom ">
                                <img src="<%=request.getContextPath() %>/picture/trip/image/04.jpg" width="120px"
                                    height="100%" class="d-inline-block rounded-lg py-1 shadow">
                            </div>
                            <div class="col " style="position: absolute;top:25px;left: 155px;width: 80px;height:50px">
                                <img class="" src="<%=request.getContextPath() %>/picture/trip/icon/bus.png"
                                    width="40px" height="25px" alt="">
                                <span>2시간</span>
                            </div>
                        </div>

                        <div name="day1_1_6" onclick="scheduleItemBt()" data-save="2" class="col text-center  p-2"
                            style="height: 100px;">
                            <div class="w-100 h-100 text-center view overlay zoom ">
                                <img src="<%=request.getContextPath() %>/picture/trip/image/05.jpg" width="120px"
                                    height="100%" class="d-inline-block rounded-lg py-1 shadow">
                            </div>
                            <div class="col " style="position: absolute;top:25px;left: 155px;width: 80px;height:50px">
                                <img class="walk" src="<%=request.getContextPath() %>/picture/trip/icon/walk.png"
                                    width="40px" height="25px" alt="">
                                <span>30분</span>
                            </div>
                        </div>
                    </div>



                    <div class="row">

                        <div name="day1_2_1" onclick="scheduleItemBt()" data-save="8"
                            class="col text-center p-2 order-6" style="height: 100px;">
                            <div class="w-100 h-100 text-center view overlay zoom ">
                                <img src="<%=request.getContextPath() %>/picture/trip/image/10.jpg" width="120px"
                                    height="100%" class="d-inline-block rounded-lg py-1">
                            </div>
                            <div class="col " style="position: absolute;top:25px;left: -40px;width: 80px;height:50px">
                                <img class="filp" src="<%=request.getContextPath() %>/picture/trip/icon/airplane.png"
                                    width="40px" height="25px" alt="">
                                <span>33분</span>
                            </div>

                            <div class="col " style="position: absolute;top:0px;left: 155px;width: 80px;height:50px">
                                <img class="walk" src="<%=request.getContextPath() %>/picture/trip/icon/arrow1.png"
                                    width="40px" height="25px" alt="">
                            </div>
                        </div>

                        <div name="day1_2_2" onclick="scheduleItemBt()" data-save="2"
                            class="col text-center p-2 order-5" style="height: 100px;">
                            <div class="w-100 h-100 text-center view overlay zoom ">
                                <img src="<%=request.getContextPath() %>/picture/trip/image/06.jpg" width="120px"
                                    height="100%" class="d-inline-block rounded-lg py-1 shadow">
                            </div>
                            <div class="col " style="position: absolute;top:25px;left: -40px;width: 80px;height:50px">
                                <img class="filp" src="<%=request.getContextPath() %>/picture/trip/icon/train.png"
                                    width="40px" height="25px" alt="">
                                <span>50분</span>
                            </div>
                        </div>

                        <div name="day1_2_3" onclick="scheduleItemBt()" data-save="2"
                            class="col text-center p-2 order-4" style="height: 100px;">
                            <div class="w-100 h-100 text-center view overlay zoom ">
                                <img src="<%=request.getContextPath() %>/picture/trip/image/07.jpg" width="120px"
                                    height="100%" class="d-inline-block rounded-lg py-1 shadow">
                            </div>
                            <div class="col " style="position: absolute;top:25px;left: -40px;width: 80px;height:50px">
                                <img class="filp" src="<%=request.getContextPath() %>/picture/trip/icon/bus.png"
                                    width="40px" height="25px" alt="">
                                <span>1시간10분</span>
                            </div>
                        </div>

                        <div name="day1_2_4" onclick="scheduleItemBt()" data-save="2"
                            class="col text-center p-2 order-3" style="height: 100px;">
                            <div class="w-100 h-100 text-center view overlay zoom ">
                                <img src="<%=request.getContextPath() %>/picture/trip/image/08.jpg" width="120px"
                                    height="100%" class="d-inline-block rounded-lg py-1 shadow">
                            </div>
                            <div class="col " style="position: absolute;top:25px;left: -40px;width: 80px;height:50px">
                                <img class="filp" src="<%=request.getContextPath() %>/picture/trip/icon/subway.png"
                                    width="40px" height="25px" alt="">
                                <span>40분</span>
                            </div>
                        </div>

                        <div name="day1_2_5" onclick="scheduleItemBt()" data-save="2"
                            class="col text-center p-2 order-2" style="height: 100px;">
                            <div class="w-100 h-100 text-center view overlay zoom ">
                                <img src="<%=request.getContextPath() %>/picture/trip/image/09.jpg" width="120px"
                                    height="100%" class="d-inline-block rounded-lg py-1 shadow">
                            </div>
                            <div class="col " style="position: absolute;top:25px;left: -40px;width: 80px;height:50px">
                                <img class="" src="<%=request.getContextPath() %>/picture/trip/icon/walk.png"
                                    width="40px" height="25px" alt="">
                                <span>58분</span>
                            </div>
                        </div>

                        <div name="day1_2_6" onclick="scheduleItemBt()" data-save="2"
                            class="col text-center p-2 order-1" style="height: 100px;">
                            <div class="w-100 h-100 text-center view overlay zoom ">
                                <img src="<%=request.getContextPath() %>/picture/trip/icon/home.png" width="120px"
                                    height="100%" class="d-inline-block rounded-lg py-1">
                            </div>
                        </div>

                   
                    </div> <!-- row --> --%>

                   
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


					<div id="reviewImage" class="col p-0 carousel slide rounded-sm"
						data-ride="carousel">

						<!-- 인티케이터 -->
						<ul class="carousel-indicators">
							<%
								for (int i = 0; i < tripPicList.size(); i++) {
							%>
							<li data-target="#reviewImage" data-slide-to="<%=i%>"
								<%if (i == 0) {%> class="active" <%}%>></li>
							<%
								}
							%>
						</ul>



						<div class="carousel-inner">

							<%
								for (int i = 0; i < tripPicList.size(); i++) {
							%>
							<!-- 1번 아이템 -->
							<div class="carousel-item active">
								<img src="https://www.w3schools.com/bootstrap4/la.jpg"
									alt="Los angeles">
								<!-- <div class="carousel-caption">
	<h3>Los Angeles</h3>
	<p>우리가 보낸 최고의 시간</p>
</div> -->
							</div>

							<%
								}
							%>

						</div>

						<a href="#reviewImage" data-slide="prev"
							class="carousel-control-prev"> <span
							class="carousel-control-prev-icon"></span>
						</a> <a href="#reviewImage" data-slide="next"
							class="carousel-control-next"> <span
							class="carousel-control-next-icon"></span>
						</a>
					</div>
				</div>

				<div class="row p-5">
					<textarea class="form-control bg-light" rows="5" id="content"
						name="text" readonly>
 <%=trip.getContent()%>
			</textarea>
				</div>
			</div>

		</div>





	</section>



	<footer class="container-fluid"></footer>

	<script>
		$(function() {
			console.log("onLoad");
			$("#head").css("background-image",
					"url(./image/mesut-kaya-eOcyhe5-9sQ-unsplash.jpg)");

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
			for(let i=0;i<$("[name='day']").length;i++){
				$($("[name='day']")[i]).addClass("d-none");
			}
			$($("[name='day']")[($("#dayBt")[0].dataset.save)-1]).removeClass("d-none");
			
			
		}

		function scheduleItemBt() {
			console.log("scheduleItemBt")
		}

		console.log("length : " + $("#body div:not(#map)").length);

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption);
	</script>
	<div>
		Icons made by <a href="https://www.flaticon.com/authors/those-icons"
			title="Those Icons">Those Icons</a> from <a
			href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a>
	</div>
</body>

</html>