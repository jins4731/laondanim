<%@page import="java.util.List"%>
<%@page import="com.laon.trip.model.vo.TripSchedule"%>
<%@page import="com.laon.user.model.vo.User"%>
<%@page import="com.laon.trip.model.vo.Trip"%>
<%@page import="com.laon.common.CommonKey"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Object tripO = request.getAttribute(CommonKey.TRIP_ITEM);
	Trip trip = null;
	if(tripO != null){
		trip = (Trip)tripO;
	}
	Object userO = request.getAttribute(CommonKey.USER_ITEM);
	User user = null;
	if(userO != null){
		user = (User)userO;
	}
	Object scheduleListO = request.getAttribute(CommonKey.SCHEDULE_LIST);
	List<TripSchedule> scheduleList = null;
	if(scheduleListO != null){
		scheduleList = (List)scheduleListO;
	}


%>


<!DOCTYPE html>
<html>


<head>
    <meta charset="UTF-8">
    <title>여행기</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=40b8b885a553f3222dde4e5effec0d3e"></script>
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
            background-size:cover;
            background-position: center center;
        }

        #head div {
            border: 1px solid black;
            box-sizing: border-box;
            /* background-color: beige; */
        }

        #body {
            /* height: 500px; */
            background-color: thistle;
        }

        #body div{
            border: 1px solid black;
            box-sizing: border-box;
            /* background-color: beige; */
        }
    </style>
</head>

<body>
    <header class="container-fluid"></header>
    <section class="container-fluid">
        <div id="head" class="col">


            <div class="row justify-content-center">
                <h1 class="text-dark" id="title">교촌허니콤보 투어</h1>
            </div>


            <div class="row justify-content-center">
                <span id="tag" class="w-50">#태그 #태그 #태그 #태그 #태그 #태그 #태그 #태그#태그 #태그 #태그 #태그#태그
                    #태그 #태그 #태그#태그 #태그 #태그 #태그</span>
            </div>


            <div class="row">

                
                <div class="col-4 font-weight-bold text-dark">
                    <div class="row align-items-center p-1">
                        <label for="travleLocale" class="col-4 m-0 ">여행지역</label>
                        <span id="taravle-locale" class="col-8 border-bottom border-secondary"><%=trip.getTravleLocale() %></span>
                    </div>
                    <div class="row align-items-center p-1">
                        <label for="travleLocale" class="col-4 m-0 ">인원 수</label>
                        <span id="people-num" class="col-8 border-bottom border-secondary"><%=trip.getPeopleNum() %>명</span>
                    </div>
                    <div class="row align-items-center p-1">
                        <label for="travleLocale" class="col-4 m-0 ">여행유형</label>
                        <span id="travle-type" class="col-8 border-bottom border-secondary"><%=trip.getTravleType() %></span>
                    </div>
                    <div class="row align-items-center p-1">
                        <label for="travleLocale" class="col-4 m-0 ">여행일</label>
                        <div class="d-flex align-items-center col-8 border-bottom border-secondary ">
                            <img src="./icon/calendar.png" width="20px" alt="">
                            <span id="travle-start-date" class="ml-2"><%=trip.getTravleStartDate() %></span>~
                            <span id="travle-end-date"><%=trip.getTravleEndDate() %></span>
                        </div>
                    </div>
                </div>


                <div class="col-8">
                    <div class="row h-100">
                        <div class=col-8></div>

                        <div class="col-4 align-content-center">
                            <div class="row h-75">
                            </div>
                            <div class="row h-25 p-1 align-items-center justify-content-end">
                                <div class="d-flex border border-danger justify-content-center">
                                    <img id="image" class="d-block rounded-circle" width="20px"
                                        src="https://image.chosun.com/sitedata/image/201705/08/2017050801699_0.jpg"
                                        alt="frog">
                                </div>
                                <label class=" m-0 border border-primary text-center" for="image"
                                    id="nickName"><%=user.getNickName() %></label>
                                    <div class="dropdown">
                                        <a class=" m-0 p-0 border border-success text-center dropdown-toggle-split" data-toggle="dropdown" href=""><img
                                            class="align-text-top" src="./icon/menu.png" width="20px" alt="menu"></a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <div class="dropdown-item bg-transparent">
                                                <a href="javascript:void(0)" onclick="singoBt()" ><img src="./icon/siren.png" width="20px" alt="">신고하기</a> 
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
        <div id="body" class="body col pt-4">
            <div class="row pl-2">
                <div class="d-flex col-3">
                    <a id="course-type" onclick="courseTypeBt()" href="javascript:void(0)" class="col-5 d-block btn btn-outline-secondary py-1 active">
                        코스
                    </a>
                    <a id="review-type" onclick="reviewTypeBt()" href="javascript:void(0)" class="col-5 d-block btn btn-outline-secondary ml-3 py-1 ">
                        후기
                    </a>
                </div>
            </div>

            <div class="row">
                <div class="col d-flex dropdown justify-content-center">
                    <button class="d-block btn dropdown-toggle" onclick="dayBt()" data-toggle="dropdown">1일차</button>
                    <div class="dropdown-menu">
                        <a href="#" class="dropdown-item">1일차</a>
                        <a href="#" class="dropdown-item">2일차</a>
                        <a href="#" class="dropdown-item">3일차</a>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col">

                </div>
                <div class="col-11">
                    <div class="row">
                        <div name="schedule-item" onclick="scheduleItemBt()" data-save="1" class="col bg-danger" style="height: 100px;"></div>
                        <div name="schedule-item" onclick="scheduleItemBt()"data-save="2" class="col"></div>
                        <div name="schedule-item" onclick="scheduleItemBt()"data-save="3" class="col"></div>
                        <div name="schedule-item" onclick="scheduleItemBt()"data-save="4" class="col"></div>
                        <div name="schedule-item" onclick="scheduleItemBt()"data-save="5" class="col"></div>
                        <div name="schedule-item" onclick="scheduleItemBt()"data-save="6" data-save="1" class="col"></div>
                        <div name="schedule-item" onclick="scheduleItemBt()"data-save="7" class="col bg-info"></div>
                    </div>
                    <div class="row">
                        <div name="schedule-item" onclick="scheduleItemBt()"data-save="8" class="col bg-danger" style="height: 100px;"></div>
                        <div name="schedule-item" onclick="scheduleItemBt()"data-save="9" class="col"></div>
                        <div name="schedule-item" onclick="scheduleItemBt()"data-save="10" class="col"></div>
                        <div name="schedule-item" onclick="scheduleItemBt()"data-save="11" class="col"></div>
                        <div name="schedule-item" onclick="scheduleItemBt()"data-save="12" class="col"></div>
                        <div name="schedule-item" onclick="scheduleItemBt()"data-save="13" class="col"></div>
                        <div name="schedule-item" onclick="scheduleItemBt()"data-save="14" class="col bg-info"></div>
                    </div>
                </div>

                <div class="col">

                </div>

            </div>


            
        </div>
        <div class="col p-4">
            <div id="map" style="height:450px;"></div>
        </div>
       

    </section>
    <footer class="container-fluid"></footer>

    <script>
        $(function(){
            console.log("onLoad");
            $("#head").css("background-image","url(./image/mesut-kaya-eOcyhe5-9sQ-unsplash.jpg)");

        });


        function courseTypeBt(){
            console.log("courseTypeBt")
        }

        function reviewTypeBt(){
            console.log("reviewTypeBt")
        }

        function singoBt(){
            console.log("singoBt");
        }


        function dayBt(){
            console.log("dayBt")
        }

        function scheduleItemBt(){
            console.log("scheduleItemBt")
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
    <div>Icons made by <a href="https://www.flaticon.com/authors/those-icons" title="Those Icons">Those Icons</a> from
        <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
</body>

</html>
