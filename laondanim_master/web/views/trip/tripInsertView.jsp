<%@page import="com.laon.tripinfo.model.vo.Tripinfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.laon.trip.model.vo.TripSchedule"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	String userNo = "1";

	List<TripSchedule> scheduleList= new ArrayList();
	scheduleList.add(new TripSchedule(1,1,1,1,1,"10분","bus"));
	scheduleList.add(new TripSchedule(1,1,1,1,2,"20분","train"));
	scheduleList.add(new TripSchedule(1,1,1,1,3,"30분","walk"));
	scheduleList.add(new TripSchedule(1,1,1,1,4,"40분","plane"));
	scheduleList.add(new TripSchedule(1,1,1,1,5,"50분","subway"));
	scheduleList.add(new TripSchedule(1,1,1,1,6,"10분","bus"));
	scheduleList.add(new TripSchedule(1,1,1,1,7,"20분","train"));
	scheduleList.add(new TripSchedule(1,1,1,1,8,"30분","walk"));
	scheduleList.add(new TripSchedule(1,1,1,1,9,"40분","plane"));
	scheduleList.add(new TripSchedule(1,1,1,1,10,"10분","bus"));
	scheduleList.add(new TripSchedule(1,1,1,1,11,"20분","train"));
	scheduleList.add(new TripSchedule(1,1,1,1,12,"30분","walk"));
	scheduleList.add(new TripSchedule(1,1,1,1,13,"40분","plane"));
	scheduleList.add(new TripSchedule(1,1,1,1,14,"50분","subway"));
	scheduleList.add(new TripSchedule(1,1,1,1,15,"10분","bus"));
	scheduleList.add(new TripSchedule(1,1,1,1,16,"20분","train"));
	scheduleList.add(new TripSchedule(1,1,1,1,17,"30분","walk"));
	scheduleList.add(new TripSchedule(1,1,1,1,18,"40분","plane"));
	
	
	
	
	scheduleList.add(new TripSchedule(1,1,1,2,1,"50분","boat"));
	scheduleList.add(new TripSchedule(1,1,1,2,2,"10분","bus"));
	scheduleList.add(new TripSchedule(1,1,1,2,3,"20분","train"));
	scheduleList.add(new TripSchedule(1,1,1,2,4,"30분","walk"));
	scheduleList.add(new TripSchedule(1,1,1,2,5,"40분","plane"));
	scheduleList.add(new TripSchedule(1,1,1,2,6,"50분","subway"));
	scheduleList.add(new TripSchedule(1,1,1,2,7,"10분","bus"));
	scheduleList.add(new TripSchedule(1,1,1,2,8,"20분","train"));
	scheduleList.add(new TripSchedule(1,1,1,2,9,"30분","plane"));
	scheduleList.add(new TripSchedule(1,1,1,2,10,"50분","boat"));
	scheduleList.add(new TripSchedule(1,1,1,2,11,"10분","bus"));
	scheduleList.add(new TripSchedule(1,1,1,2,12,"20분","train"));
	scheduleList.add(new TripSchedule(1,1,1,2,13,"30분","walk"));
	scheduleList.add(new TripSchedule(1,1,1,2,14,"40분","plane"));
	scheduleList.add(new TripSchedule(1,1,1,2,15,"50분","subway"));
	scheduleList.add(new TripSchedule(1,1,1,2,16,"10분","bus"));
	scheduleList.add(new TripSchedule(1,1,1,2,17,"20분","train"));
	scheduleList.add(new TripSchedule(1,1,1,2,18,"30분","plane"));
	
	
	
	List<Tripinfo> matzipList= new ArrayList();
	matzipList.add(new Tripinfo(1,"맛집","# tag","김밥천국1","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	matzipList.add(new Tripinfo(1,"맛집","# tag","김밥천국2","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	matzipList.add(new Tripinfo(1,"맛집","# tag","김밥천국3","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	matzipList.add(new Tripinfo(1,"맛집","# tag","김밥천국4","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	matzipList.add(new Tripinfo(1,"맛집","# tag","김밥천국5","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	matzipList.add(new Tripinfo(1,"맛집","# tag","김밥천국6","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	matzipList.add(new Tripinfo(1,"맛집","# tag","김밥천국7","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	matzipList.add(new Tripinfo(1,"맛집","# tag","김밥천국8","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	matzipList.add(new Tripinfo(1,"맛집","# tag","김밥천국9","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	matzipList.add(new Tripinfo(1,"맛집","# tag","김밥천국10","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	matzipList.add(new Tripinfo(1,"맛집","# tag","김밥천국11","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	
	
	
	List<Tripinfo> myoungsoList= new ArrayList();
	myoungsoList.add(new Tripinfo(1,"명소","# tag","남산타워1","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	myoungsoList.add(new Tripinfo(1,"명소","# tag","남산타워2","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	myoungsoList.add(new Tripinfo(1,"명소","# tag","남산타워3","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	myoungsoList.add(new Tripinfo(1,"명소","# tag","남산타워4","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	myoungsoList.add(new Tripinfo(1,"명소","# tag","남산타워5","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	myoungsoList.add(new Tripinfo(1,"명소","# tag","남산타워6","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	myoungsoList.add(new Tripinfo(1,"명소","# tag","남산타워7","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	myoungsoList.add(new Tripinfo(1,"명소","# tag","남산타워8","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	myoungsoList.add(new Tripinfo(1,"명소","# tag","남산타워9","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	myoungsoList.add(new Tripinfo(1,"명소","# tag","남산타워10","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	myoungsoList.add(new Tripinfo(1,"명소","# tag","남산타워11","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	
	
	
	List<Tripinfo> sooksoList= new ArrayList();
	sooksoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔1","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	sooksoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔2","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	sooksoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔3","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	sooksoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔4","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	sooksoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔5","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	sooksoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔6","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	sooksoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔7","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	sooksoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔8","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	sooksoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔9","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	sooksoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔10","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	sooksoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔11","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	
	
	

%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

    <script src="<%=request.getContextPath() %>/js/bootstrap-datepicker.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap-datepicker.ko.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/mdb.min.css">
    <script src="<%=request.getContextPath() %>/js/mdb.min.js"></script>
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=40b8b885a553f3222dde4e5effec0d3e"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="<%=request.getContextPath() %>/js/lodash.js"></script>
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

        section div {
            border: 1px solid black;
            box-sizing: border-box;
        }

        footer {
            border: 2px solid blue;
            box-sizing: border-box;

            height: 70px;
        }

        #titleContainer div {
            border: 1px solid black;
            box-sizing: border-box;
        }

        #tripinfoContainer div {
            border: 1px solid black;
            box-sizing: border-box;
        }

        input::placeholder {
            /* text-align: center;  */
        }

        input[data-date="datePicker"]::placeholder {
            text-align: center;
        }

        #carouselInner img {
            width: 100%;
            height: 500px;
            object-fit: contain;
        }

        img[name='pepe'] {
            width: 100%;
            height: 100%;
        }
    </style>
</head>

<body>
    <header class="container-fluid"></header>


    <section class="container-fluid">
        <div id="titleContainer" class="row justify-content-center">
            <div class="col-3">
                <div class="row dropdown justify-content-center">
                    <button type="button" id="category" name="category"
                        class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown">일정</button>
                    <div class="dropdown-menu">
                        <a id="courseDropBt" href="#" class="dropdown-item">일정</a>
                        <a id="reviewDropBt" href="#" class="dropdown-item">후기</a>
                    </div>
                </div>

                <div class="row form-group mb-1">
                    <input type="text" id="title" class="form-control border-top-0 border-left-0 border-right-0 "
                        name="userName" placeholder="여행기 제목을 입력해주세요.">
                </div>

                <div class="row align-items-center justify-content-end">
                    <label for="publicEnabled" class="mb-1">공개</label>
                    <div class="custom-control custom-switch">
                        <input type="checkbox" class="custom-control-input" id="publicEnabledId" name="publicEnabled">
                        <label for="publicEnabledId" class="custom-control-label"></label>
                    </div>
                </div>
            </div>



        </div>


        <div id="tripinfoContainer">
            <div class="border-bottom text-dark">
                <span>여행정보</span>
            </div>

            <div class="col">
                <div class="row p-5">
                    <div class="col">

                        <div class="row form-group mb-0 ">
                            <span class="col-3 pt-1 font-weight-bold">여행지역</span>
                            <input class="col-6" type="text" id="travleLocale"
                                class="form-control border-top-0 border-left-0 border-right-0 " name="title" 
                                placeholder="여행지역을 입력해주세요.">
                        </div>
                        <div class="row form-group mb-0">
                            <span class="col-3 pt-1 font-weight-bold">인원 수</span>
                            <input class="col-6" type="number" id="peopleNum"
                                class="form-control border-top-0 border-left-0 border-right-0 " name="peopleNum"
                                id="peopleNum" placeholder="인원수를 입력해주세요." autocomplete="off" min=0>
                        </div>
                    </div>
                    <div class="col">
                        <div class="row form-group mb-0">
                            <span class="col-3 pt-1 font-weight-bold">여행유형</span>
                            <input class="col-6" type="text" id="travleType"
                                class="form-control border-top-0 border-left-0 border-right-0 " name="travleType"
                                id="travleType" placeholder="여행유형을 입력해주세요.">
                        </div>
                        <div class="row form-group mb-0">
                            <span class="col-3 pt-1 font-weight-bold">여행일</span>
                            <input class="col-3 p-0" type="text"
                                class="form-control border-top-0 border-left-0 border-right-0 " data-date="datePicker"
                                name="travleStartDate" id="travleStartDateId" placeholder="여행시작일 입력">
                            <input class="col-3 p-0" type="text"
                                class="form-control border-top-0 border-left-0 border-right-0 " data-date="datePicker"
                                name="travleEndDate" id="travleEndDateId" placeholder="여행종료일 입력">
                        </div>
                    </div>
                </div>
            </div>
        </div>




        <div id="courseContainer">
            <div class="row mx-1">
                <button id="matzipBt" onclick="matzipBt()" class="btn btn-grey">맛집</button>
                <button id="myoungsoBt" onclick="myoungsoBt()" class="btn btn-grey">명소</button>
                <button id="sooksoBt" onclick="sooksoBt()" class="btn btn-grey">숙소</button>
                <button id="myBt" onclick="myBt()" class="btn btn-grey">마이</button>
            </div>
            <div class="row mx-1" style="height: 200px;">


                <div class="col p-0 d-flex my-2 align-items-center view overlay zoom"
                    style="height: auto; width: 50px;">
                    <a href="javascript:void(0)" id="tripinfoPrevBt">
                        <img class="" src="<%=request.getContextPath()%>/picture/trip/icon/leftArrow.png"
                            style="width: 50px;height: 50px;"></img>
                    </a>
                </div>


                <div class="col-11 d-flex align-items-center overflow-hidden p-0 " style="height: 200px;">

                    <!-- 찜 목록 -->
                    <div id="mindSlider" class="d-block text-nowrap"
                        style="transition: all 1.15s ease-in-out;height: 172px;">



                        <%for(int i=0;i<matzipList.size();i++){ //맛집
                            Tripinfo info = matzipList.get(i);
                            int no = info.getNo();
                            String category = info.getCategory();
                            String tag = info.getTag();
                            String name = info.getName();
                            String address = info.getAddress();
                            String businessHours = info.getBusinessHours();
                            String tel = info.getTel();
                            String homepage = info.getHomepage();
                            String naver = info.getNaver();
                            String sns = info.getSns();
							
						%>

                        <div id="matzipItem<%=i %>" name="matzipItem" class="d-inline-block view zoom"
                            ondrop="drop(event)" ondragover="dragover(event)"
                            style="height: 170px; width: 170px;position: relative;">
                            <img id="matzipImg<%=i %>" name="matzipImg" class="d-block " data-no="<%=no%>" data-category="<%=category %>"
                                data-tag="<%=tag %>" data-name="<%=name %>" data-address="<%=address %>"
                                data-businessHours="<%=businessHours %>" data-tel="<%=tel %>"
                                data-homepage="<%=homepage %>" data-naver="<%=naver %>" data-sns="<%=sns %>"
                                src="https://image.chosun.com/sitedata/image/201705/08/2017050801699_0.jpg"
                                draggable="true" ondragstart="dragstart(event)" alt=""
                                style="position: absolute;left: 0px;top: 0px;width: 100%;height: 100%;z-index: 0;">
                            <div class="mask flex-center rgba-black-strong"
                                style="width: 100%;height: 30px;z-index: 1;">
                                <p class="white-text"><%=name%></p>
                            </div>
                        </div>

                        <%} %>
                        <%for(int i=0;i<myoungsoList.size();i++){ // 명소
                            Tripinfo info = myoungsoList.get(i);
                            int no = info.getNo();
                            String category = info.getCategory();
                            String tag = info.getTag();
                            String name = info.getName();
                            String address = info.getAddress();
                            String businessHours = info.getBusinessHours();
                            String tel = info.getTel();
                            String homepage = info.getHomepage();
                            String naver = info.getNaver();
                            String sns = info.getSns();
						%>

                        <div id="myoungsoItem<%=i %>" name="myoungsoItem" class="d-none view  zoom" ondrop="drop(event)"
                            ondragover="dragover(event)" style="height: 170px; width: 170px;position: relative;">
                                <img id="myoungsoImg<%=i %>" name="myoungsoImg" class="d-block" data-no="<%=no%>"
                                    data-category="<%=category %>" data-tag="<%=tag %>" data-name="<%=name %>"
                                    data-address="<%=address %>" data-businessHours="<%=businessHours %>"
                                    data-tel="<%=tel %>" data-homepage="<%=homepage %>" data-naver="<%=naver %>"
                                    data-sns="<%=sns %>"
                                    src="https://image.chosun.com/sitedata/image/201705/08/2017050801699_0.jpg"
                                    draggable="true" ondragstart="dragstart(event)" alt=""
                                    style="position: absolute;left: 0px;top: 0px;width: 100%;height: 100%;z-index: 0;">
                                <div class="mask flex-center rgba-black-strong"
                                    style="width: 100%;height: 30px;z-index: 1;">
                                    <p class="white-text"><%=name%></p>
                                </div>
                        </div>

                        <%} %>
                        <%for(int i=0;i<sooksoList.size();i++){  //숙소
                            Tripinfo info = sooksoList.get(i);
                            int no = info.getNo();
                            String category = info.getCategory();
                            String tag = info.getTag();
                            String name = info.getName();
                            String address = info.getAddress();
                            String businessHours = info.getBusinessHours();
                            String tel = info.getTel();
                            String homepage = info.getHomepage();
                            String naver = info.getNaver();
                            String sns = info.getSns();
							
						%>

                        <div id="sooksoItem<%=i %>" name="sooksoItem" class="d-none view  zoom" ondrop="drop(event)"
                            ondragover="dragover(event)" style="height: 170px; width: 170px;position: relative;">
                            <img id="sooksoImg<%=i %>" name="sooksoImg" class="d-block" data-no="<%=no%>" data-category="<%=category %>"
                                data-tag="<%=tag %>" data-name="<%=name %>" data-address="<%=address %>"
                                data-businessHours="<%=businessHours %>" data-tel="<%=tel %>"
                                data-homepage="<%=homepage %>" data-naver="<%=naver %>" data-sns="<%=sns %>"
                                src="https://image.chosun.com/sitedata/image/201705/08/2017050801699_0.jpg"
                                draggable="true" ondragstart="dragstart(event)" alt=""
                                style="position: absolute;left: 0px;top: 0px;width: 100%;height: 100%;z-index: 0;">
                            <div class="mask flex-center rgba-black-strong"
                                style="width: 100%;height: 30px;z-index: 1;">
                                <p class="white-text"><%=name%></p>
                            </div>
                        </div>

                        <%} %>


                    </div>

                </div>



                <div class="col p-0 d-flex my-2 align-items-center view overlay zoom"
                    style="height: auto; width: 50px;">
                    <a href="javascript:void(0)" id="tripinfoNextBt">
                        <img class="" src="<%=request.getContextPath()%>/picture/trip/icon/rightArrow.png"
                            style="width: 50px;height: 50px;"></img>
                    </a>
                </div>


            </div>

            <div class="row mx-1 justify-content-center">
                <span>아이템을 선택해 일정을 추가하세요.</span>
            </div>


            <!-- 일차 추가 -->
            <div class="row mx-1" style="height: 50px;">
                <div class="d-flex bg-primary rounded-pill justify-content-center align-items-center"
                    style="height: 100%;width: 60px;cursor: pointer;" data-save="1" onclick="dayBt(event)">
                    <span class="" style="width: auto;height: auto;" data-save="1">1일차</span>
                </div>
                <div class=" d-flex ml-2 bg-success rounded-pill justify-content-center align-items-center font-weight-bold"
                    style="height: auto;width: 60px;cursor: pointer;" id="dayPlusBt">
                    +
                </div>
            </div>


            <!-- 스케줄 추가 -->
            <div id="dayContainer" class="col p-0 mx-1">

                <div id="day1" name="day" data-save="1" class="row mx-1" id="schduleContainer">
                
               


                    <div class="col-12 ">
    
                        <div class="border-danger d-inline-block"
                            style="margin-right: 7rem ;width: 100px;height: 100px;background-size: contain; background-image: url(<%=request.getContextPath()%>/picture/trip/icon/start.png)">
                        </div>
    
                        <div class="border-danger mr-2 d-inline-block" data-order="1"
                            style=" width: 100px;height: 100px;position: relative;background-size: contain ;background-image: url(<%=request.getContextPath()%>/picture/trip/icon/rectangle.png);"
                            ondrop="drop(event)" ondragover="dragover(event)">
                        </div>
    
                    </div>
    
                  
                </div>

            </div>
            



            <div class="col p-4">
                <div id="map" style="height:450px;"></div>
            </div>
        </div>

        <div id="writeContainer">



            <div class="row p-5">
                <!-- 컨테이너 -->

                <div id="imagesContainer" class="col p-0 carousel slide rounded-sm bg-dark" data-ride="carousel">

                    <!-- 인디케이터 -->
                    <ul id="carouselIndicators" class="carousel-indicators">

                    </ul>

                    <!-- 이너 -->
                    <div id="carouselInner" class="carousel-inner  d-inline-flex align-items-center"
                        style="width:100%;height:500px;position: relative;">

                        <div style="position:absolute;left: 50%;top: 50%;width: 50px;height: 50px;
                transform: translate(-50%,-50%);z-index: 1;"
                            class="d-inline-flex  view overlay zoom p-1 img-fluid align-items-center justify-content-center">

                            <img src="<%=request.getContextPath() %>/picture/trip/plus.png" alt=""
                                style="object-fit: contain;width: 100%;height: 100%;">
                            <input type="file" id="image" name="image" multiple accept="image/jpg,image/png"
                                style="width: 100%;height: 100%;position: absolute;" form="tripForm">
                        </div>



                        <!-- 사진 공간 -->



                    </div>

                    <a href="#imagesContainer" data-slide="prev" class="carousel-control-prev">
                        <span class="carousel-control-prev-icon" style="width: 50px;height: 50px;"></span>
                    </a>
                    <a href="#imagesContainer" data-slide="next" class="carousel-control-next">
                        <span class="carousel-control-next-icon" style="width: 50px;height: 50px;"></span>
                    </a>
                </div>
            </div>

            <div class="row p-5">
                <textarea class="form-control bg-light" rows="5" id="content" name="text"></textarea>
            </div>


            <div class="row mx-2" style="height: 100px;">
                <div class="d-flex flex-wrap" style="height: 30px;">
                    <div>
                        <input id="tag" name="tag" type="text" class="border-0" style="width: auto;">

                    </div>
                </div>

            </div>


            <div id="formContainer">
                <form class="d-flex col justify-content-center" id="tripForm"
                    action="<%=request.getContextPath()%>/trip/tripInsertEnd.do" method="POST"
                    enctype="multipart/form-data">
                    <input class="btn btn-grey" type="reset" id="resetBt" value="취소">
                    <input class="btn btn-grey ml-4" type="button" id="submitBt" value="전송">

                </form>
            </div>

    </section>


    <footer class="container-fluid"></footer>






    <!-- 템플릿 -->
    <div id="template" class="d-none">






        <!-- 이동방법, 소요시간 -->
        <div name="tranport" class="col p-0" style="width: 70px;">
            <input type="number" min="0" class="font-smaller" placeholder="분" style="width: 70px;">
            <div name="transportDropdown" class="row dropdown justify-content-center">
                <button name="dropdownBt" class="d-block p-0 btn btn-indigo dropdown-toggle font-small"
                    style="width: 70px;" data-toggle="dropdown">도보
                </button>
                <div name="dropdownMenu" class="dropdown-menu">
                    <a href="javascript:void(0)" onclick="dropdownItemBt(event)" class="dropdown-item ">도보</a>
                    <a href="javascript:void(0)" onclick="dropdownItemBt(event)" class="dropdown-item font-small">버스</a>
                    <a href="javascript:void(0)" onclick="dropdownItemBt(event)"
                        class="dropdown-item font-small">지하철</a>
                    <a href="javascript:void(0)" onclick="dropdownItemBt(event)" class="dropdown-item font-small">기차</a>
                    <a href="javascript:void(0)" onclick="dropdownItemBt(event)" class="dropdown-item font-small">배</a>
                    <a href="javascript:void(0)" onclick="dropdownItemBt(event)"
                        class="dropdown-item font-small">비행기</a>
                </div>
            </div>
        </div>


        <!-- 일정추가 아이템 -->
        <div name="addSchedule" class="border-danger mr-2 d-inline-block"
            style="margin-left: 7rem; width: 100px;height: 100px;position: relative;background-size: contain ;background-image: url(<%=request.getContextPath()%>/picture/trip/icon/rectangle.png);"
            ondrop="drop(event)" ondragover="dragover(event)"></div>




            <!-- 일차 추가 -->
            <div id="dayTemple" class="row mx-1" id="schduleContainer">

                <div class="col-11 ">

                    <div class="border-danger d-inline-block"
                        style="margin-right: 7rem ;width: 100px;height: 100px;background-size: contain; background-image: url(<%=request.getContextPath()%>/picture/trip/icon/start.png)">
                    </div>
                    
                    <div name="scheduleOrder" class="border-danger mr-2 d-inline-block"
                        style=" width: 100px;height: 100px;position: relative;background-size: contain ;background-image: url(<%=request.getContextPath()%>/picture/trip/icon/rectangle.png);"
                        ondrop="drop(event)" ondragover="dragover(event)">
                    </div>

                </div>
               
            </div>


    </div>
    <style>
        #dd {
            transform: translateX(-200px);
        }
    </style>
    <script>
        $(function () {
            $("[data-date='datePicker']").datepicker({
                language: 'ko',
                autoclose: true
            });



            $('.carousel-item').remove();
            $('#carouselIndicators').empty();
        });




        var dayCount = 1;
        $("#dayPlusBt").on("click", function (event) {

            console.log("dayPlusBt");
            var span = $('<span class="" style="width: auto;height: auto;"></span>')
            var a = $('<a href="javascript:void(0)" class="text-light" name="dayDelBt" onclick="dayDelBt(event)">x</a>');
            dayCount++;
            span.html(dayCount + "일차");
            span[0].dataset.save = dayCount;
            var div = $('<div class="d-flex ml-2 bg-primary rounded-pill justify-content-center align-items-center" style="height: 100%;width: 60px;cursor: pointer;" onclick="dayBt(event)"></div>');
            div.append(span).append(a);
            div[0].dataset.save = dayCount;
            $(event.target).before(div);


            var daytemple = $("#dayTemple").clone();
           
            daytemple.attr("id","day"+dayCount);
            daytemple.attr("name","day");
            daytemple[0].dataset.save = dayCount;
            daytemple.addClass("d-none");
            daytemple.find("[name='scheduleOrder']")[0].dataset.order = 1;
            $("#dayContainer").append(daytemple.clone());

        });

        function dayBt(event){
            console.log("dayBt : " + $(event.target)[0]);
            console.log("dayCount : " + $(event.target).data("save"));
            console.log("dayBt Length : " +  $("[name='day']").length);
            var dayLength = $("[name='day']").length;
            console.log("eventTargetSave : " + event.target.dataset.save);
            for(let i = 0 ;i<dayLength;i++){
                console.log("[name='day']Save : " + $("[name='day']")[i].dataset.save);
                if($("[name='day']")[i].dataset.save == event.target.dataset.save){
                    $($("[name='day']")[i]).removeClass("d-none");
                }else{
                    $($("[name='day']")[i]).addClass("d-none");
                }
               
                
                
            }
           
        }

        function dayDelBt(e) {
            console.log("dayDelBt");
            $(e.target).parent().remove();
            dayCount--;
        }




        $("#courseDropBt").on("click", function (e) {
            console.log("courseDropBt");
            $("#category").html("일정");
            $("#category").val("일정")
        });
        $("#reviewDropBt").on("click", function (e) {
            console.log("reviewDropBt");
            $("#category").html("후기");
            $("#category").val("후기")

        });








        var sliderSize = 1182.5;
        var prevNextClickCount = 0;
        $("#tripinfoPrevBt").on("click", function (e) {
            console.log("tripinfoPrevBt");
            if (prevNextClickCount + 1 <= 0) {
                prevNextClickCount++;
            }

            $("#mindSlider").css("transform", "translateX(" + (sliderSize * prevNextClickCount) + "px)");

        });

        var matzipLength = $("[name='matzipItem']").length;
        var myoungsoLength = $("[name='myoungsoItem']").length;
        var sooksoLength = $("[name='sooksoItem']").length;
        var correctionCount = 0;
        console.log("matzipLength : " + matzipLength + " myoungsoLength : " + myoungsoLength + " sooksoLength : " + sooksoLength);
        $("#tripinfoNextBt").on("click", function (e) {
            console.log("tripinfoNextBt");
            if (isWhereSelected == 0) { // 맛집
                correctionCount = (matzipLength * 172) / 1182;
                if (-correctionCount <= prevNextClickCount - 1) {
                    prevNextClickCount--;
                }
            } else if (isWhereSelected == 1) { // 명소
                correctionCount = (myoungsoLength * 172) / 1182;
                if (-correctionCount <= prevNextClickCount - 1) {
                    prevNextClickCount--;
                }
            } else if (isWhereSelected == 2) { // 숙소
                correctionCount = (sooksoLength * 172) / 1182;
                if (-correctionCount <= prevNextClickCount - 1) {
                    prevNextClickCount--;
                }
            }

            $("#mindSlider").css("transform", "translateX(" + (sliderSize * prevNextClickCount) + "px)");

        });


        $("[name='matzipItem']").on("click", function (event) {
            console.log(event.target);
        });
        $("[name='myoungsoItem']").on("click", function (event) {
            console.log(event.target);

        });
        $("[name='sooksoItem']").on("click", function (event) {
            console.log(event.target);

        });






        $("#tag").on("keyup", function (e) {
            console.log("tag : " + e.keyCode);
            var str = $(e.target).val();
            if ($(e.target).val().length > 0 && e.keyCode == 13) {
                var input = $('<input name="tag" type="text" class="border-0" style="width: auto;">');
                input.val(str);
                var a = $('<a href="javascript:void(0)" name="tagDelBt" onclick="tagDelBt(event)">x</a>');
                var div = $("<div>");
                div.addClass("mr-2");
                div.append(input).append(a);
                $(e.target).parent().before(div);

                $(e.target).val("");
            }
        });



        function drop(event) { // 드래그 해서 놓았을때
            console.log("ondrop");
            event.preventDefault();
            const div = $(event.target)[0];
            var order = div.dataset.order;
            var data = event.dataTransfer.getData("itemId");

            var itemClone = $("#" + data).clone(); // 이미지
            console.log(itemClone);
            itemClone.find("img")[0].dataset.order = order;
            itemClone.attr("name","schedule"+itemClone.attr("name"));
            $(itemClone).css({
                width: "100px",
                height: "100px"
            });

            div.appendChild(itemClone.clone()[0]);
            var trantport = $("[name='tranport']").clone(); // 교통편, 이동시간
            var input = trantport.find("input");
            input.val(0);
            input.val(null);
            var button = trantport.find("button");
            button.html("도보");
            trantport.css({
                position: "absolute",
                top: "25px",
                left: "-90px"
            });
            div.appendChild(trantport[0]);
            var addSchedule = $("[name='addSchedule']")[0].cloneNode()// 아이템 추가 공간 생성
            addSchedule.dataset.order= (Number(order)+1);
            event.target.after(addSchedule);
            

        }

        function dragover(event) { // 드래그 해서 위해 호버되었을때
            console.log("ondragover");
            event.preventDefault();


        }
        function dragstart(event) { // 드래그 할 아이템을 움직이기 시작했을때
            console.log("ondragstart");
            event.dataTransfer.setData("itemId", $(event.target).parent()[0].id);
            console.log("itemId : " + $(event.target).parent()[0].id);

        }


        function tagDelBt(event) {
            console.log("tagDelBt");
            $(event.target).parent().remove();
        }

        var isWhereSelected = 0;
        function matzipBt() {
            console.log("matzipBt");
            $("[name='matzipItem']").removeClass("d-none");
            $("[name='matzipItem']").addClass("d-inline-block");

            $("[name='myoungsoItem']").removeClass("d-inline-block");
            $("[name='myoungsoItem']").addClass("d-none");

            $("[name='sooksoItem']").removeClass("d-inline-block");
            $("[name='sooksoItem']").addClass("d-none");
            isWhereSelected = 0;
            $("#mindSlider").css("transform", "translateX(0px)");
        }
        function myoungsoBt() {
            console.log("myoungsoBt");
            $("[name='matzipItem']").removeClass("d-inline-block");
            $("[name='matzipItem']").addClass("d-none");

            $("[name='myoungsoItem']").removeClass("d-none");
            $("[name='myoungsoItem']").addClass("d-inline-block");

            $("[name='sooksoItem']").removeClass("d-inline-block");
            $("[name='sooksoItem']").addClass("d-none");
            isWhereSelected = 1;
            $("#mindSlider").css("transform", "translateX(0px)");
        }
        function sooksoBt() {
            console.log("sooksoBt");
            $("[name='matzipItem']").removeClass("d-inline-block");
            $("[name='matzipItem']").addClass("d-none");

            $("[name='myoungsoItem']").removeClass("d-inline-block");
            $("[name='myoungsoItem']").addClass("d-none");

            $("[name='sooksoItem']").removeClass("d-none");
            $("[name='sooksoItem']").addClass("d-inline-block");
            isWhereSelected = 2;
            $("#mindSlider").css("transform", "translateX(0px)");
        }
        function myBt() {
            console.log("myBt");
        }

        function dropdownItemBt(event) {
            console.log("dropdownBt");
            $(event.target).parent().prev().html($(event.target).html());
            

        }



        $("#submitBt").on("click", function () {
            console.log("submitBt");
           


            var dayList = [];

           
            
            for(let i = 0;i<$("[name='day']").length;i++){
                console.log("day : " + i);

                var day = {
                    no:i,
                    scheduleList:[]
                }
                for(let k = 0 ;k<$($("[name='day']")[i]).find("img").length;k++){
                    console.log("img : " + k)
                    var dayData = $("[name='day']")[i].dataset;
                    var requiredTime = $($($("[name='day']")[i]).find("input")[k]).val();
                    var transport = $($($("[name='day']")[i]).find("button")[k]).html();
                    var schduleData = $($("[name='day']")[i]).find("img")[k].dataset;

                    var schedule = {
                    tripinfoNo: schduleData.no,
                    day: dayData.save,
                    orders: schduleData.order,
                    requiredHours: requiredTime,
                    transport: transport,
                    
                    }
                    console.log("tripinfoNo : " + schedule.tripinfoNo);
                    console.log("order : " + schduleData.order);
                    console.log("requiredTime : " + requiredTime);
                    console.log("transport : " + transport);
                    day.scheduleList.push(schedule);
                }
                dayList.push(day);
            }



            var _userNo = "";
            var _category = $("#category").html(); // 확인
            // var _writeDate = $("#writeDate");  
            var _tag = ""; 
            for(let i =0;i<$("[name='tag']").length;i++){
                _tag += $($("[name='tag']")[0]).val() + ",";
            }
            _tag = _tag.substr(0,_tag.length-1);

            var _title = $("#title").val(); 
            var _content = $("#content").val();
            var _travleLocale = $("#travleLocale").val();
            var _peopleNum = $("#peopleNum").val();
            var _travleType = $("#travleType").val();
            var _travleStartDate = $("#travleStartDateId").val();
            var _travleEndDate = $("#travleEndDateId").val();
            var _publicEnabled = $("#publicEnabledId").val();
          

            var tripData = {
                userNo:_userNo,
                category:_category,
                tag:_tag,
                title:_title,
                content:_content,
                travleLocale:_travleLocale,
                peopleNum:_peopleNum,
                travleTyp:_travleType,
                travleStartDate:_travleStartDate,
                travleEndDate:_travleEndDate,
                publicEnabled:_publicEnabled,
                deleted:'n',
                scheduleData:dayList
            }
            
            var f = $("#tripForm")[0];
            var formData = new FormData(f);
            formData.append("tripData",JSON.stringify(tripData));

         
            $.ajax({
                url: "<%=request.getContextPath()%>/trip/tripInsertViewEnd.do",
                type: "post",
                enctype: "multipart/form-data", 
                data:formData,
                processData: false,
                contentType: false,
                dataType: "html", //xml,html,script,json,jsonp,text
                success: function (data, status, xmlHttpRequest) {
                    console.log(data, status, xmlHttpRequest);
                    // location.replace('<%=request.getContextPath()%>/');
                },
                error: function (xmlHttpRequest, status, error) {
                    console.log(xmlHttpRequest, status, error);
                },
                complete: function (xmlHttpRequest, status) {
                    console.log(xmlHttpRequest, status);
                }
            });
            







        });





        var input = document.querySelector('#image');
        input.style.opacity = 0;
        input.addEventListener('change', updateImageDisplay);

        const fileTypes = [
            'image/jpeg',
            'image/pjpeg',
            'image/png'
        ];
        function validFileType(file) {
            return fileTypes.includes(file.type);
        }
        function returnFileSize(number) {
            if (number < 10) {
                return number + 'bytes';
            } else if (number >= 1024 && number < 1048576) {
                return (number / 1024).toFixed(1) + 'KB';
            } else if (number >= 1048576) {
                return (number / 1048576).toFixed(1) + 'MB';
            }
        }


        function updateImageDisplay() {
            const currentFiles = input.files;
            if (currentFiles.length === 0) { //추가된 파일이 하나도 없을대
                // 파일이 없음을 표시
            } else { // 추가된 파일이 있을때

                var count = 0;
                var isActive = false;
                $('.carousel-item').remove();
                $('#carouselIndicators').empty();
                for (const file of currentFiles) {
                    console.log("count :" + count);
                    console.log("isActive :" + isActive);

                    if (validFileType(file)) {
                        const img = $("<img>").attr("src", URL.createObjectURL(file));
                        const item = $('<div class="carousel-item">').append(img);
                        if (isActive == false) {
                            item.addClass('active');
                        }
                        const inner = $('#carouselInner').append(item);


                        const indicatorItem = $('<li>');
                        indicatorItem.attr("data-target", '#carouselContainer');
                        indicatorItem.attr("data-slide-to", count);
                        if (isActive == false) {
                            indicatorItem.addClass("active");
                            isActive = true;
                            // console.log("count : " + count);
                        }

                        const indicator = $('#carouselIndicators');
                        indicator.append(indicatorItem);

                        if (count == 0) {
                            $("#fileNames").val(file.name + ",")
                        } else {
                            $("#fileNames").val($("#fileNames").val() + file.name + ",")
                        }

                    } else {
                        console.log("잘못된 파일 접근입니다.");
                    }
                    count++;
                }
            }
        }




        console.log("length : " + $("#body div:not(#map)").length);



        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
            mapOption = {
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };

        // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
        var map = new kakao.maps.Map(mapContainer, mapOption);
    </script>
</body>

</html>