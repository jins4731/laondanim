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
	
	
	
	List<Tripinfo> tripinfoList= new ArrayList();
	tripinfoList.add(new Tripinfo(1,"맛집","# tag","김밥천국1","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"맛집","# tag","김밥천국2","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"맛집","# tag","김밥천국3","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"맛집","# tag","김밥천국4","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"맛집","# tag","김밥천국5","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"맛집","# tag","김밥천국6","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"맛집","# tag","김밥천국7","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"맛집","# tag","김밥천국8","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"맛집","# tag","김밥천국9","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"맛집","# tag","김밥천국10","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"맛집","# tag","김밥천국11","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	
	
	
	
	tripinfoList.add(new Tripinfo(1,"명소","# tag","남산타워1","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"명소","# tag","남산타워2","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"명소","# tag","남산타워3","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"명소","# tag","남산타워4","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"명소","# tag","남산타워5","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"명소","# tag","남산타워6","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"명소","# tag","남산타워7","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"명소","# tag","남산타워8","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"명소","# tag","남산타워9","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"명소","# tag","남산타워10","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"명소","# tag","남산타워11","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	
	
	
	
	tripinfoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔1","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔2","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔3","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔4","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔5","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔6","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔7","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔8","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔9","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔10","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	tripinfoList.add(new Tripinfo(1,"숙소","# tag","힐튼호텔11","서울시 강남구","07:00 ~ 21:00","02-2654-7575","home","naver","sns"));
	
	
	

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

    <script src="../../js/bootstrap-datepicker.min.js"></script>
    <script src="../../js/bootstrap-datepicker.ko.min.js"></script>
    <link rel="stylesheet" href="../../css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="../../css/mdb.min.css">
    <script src="../../js/mdb.min.js"></script>
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=40b8b885a553f3222dde4e5effec0d3e"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
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
                        class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown">
                        글종류 선택
                    </button>
                    <div class="dropdown-menu">
                        <a id="courseDropBt" href="#" class="dropdown-item">일정</a>
                        <a id="reviewDropBt" href="#" class="dropdown-item">후기</a>
                    </div>
                </div>

                <div class="row form-group mb-1">
                    <input type="text" id="user" class="form-control border-top-0 border-left-0 border-right-0 "
                        name="userName" placeholder="여행기 제목을 입력해주세요.">
                </div>

                <div class="row align-items-center justify-content-end">
                    <label for="publicEnabled" class="mb-1">공개</label>
                    <div class="custom-control custom-switch">
                        <input type="checkbox" class="custom-control-input" id="publicEnabled" name="publicEnabled">
                        <label for="publicEnabled" class="custom-control-label"></label>
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
                            <input class="col-6" type="text" id="user"
                                class="form-control border-top-0 border-left-0 border-right-0 " name="title" id="title"
                                placeholder="여행기 제목을 입력해주세요.">
                        </div>
                        <div class="row form-group mb-0">
                            <span class="col-3 pt-1 font-weight-bold">인원 수</span>
                            <input class="col-6" type="number" id="user"
                                class="form-control border-top-0 border-left-0 border-right-0 " name="peopleNum"
                                id="peopleNum" placeholder="인원수를 입력해주세요." autocomplete="off" min=0>
                        </div>
                    </div>
                    <div class="col">
                        <div class="row form-group mb-0">
                            <span class="col-3 pt-1 font-weight-bold">여행유형</span>
                            <input class="col-6" type="text" id="user"
                                class="form-control border-top-0 border-left-0 border-right-0 " name="travleType"
                                id="travleType" placeholder="여행유형을 입력해주세요.">
                        </div>
                        <div class="row form-group mb-0">
                            <span class="col-3 pt-1 font-weight-bold">여행일</span>
                            <input class="col-3 p-0" type="text" id="travleStartDate"
                                class="form-control border-top-0 border-left-0 border-right-0 " data-date="datePicker"
                                name="travleStartDate" id="travleStartDate" placeholder="여행시작일 입력">
                            <input class="col-3 p-0" type="text" id="travleEndDate"
                                class="form-control border-top-0 border-left-0 border-right-0 " data-date="datePicker"
                                name="travleEndDate" id="travleEndDate" placeholder="여행종료일 입력">
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


                <div class="col d-flex bg-info my-2 align-items-center" style="height: auto; width: 50px;">
                    <a href="javascript:void(0)" id="tripinfoPrevBt">
                        <span class="carousel-control-prev-icon" style="width: 50px;height: 50px;"></span>
                    </a>
                </div>


                <div class="col-11 text-nowrap overflow-hidden" style="height: 200px;">

                    <div id="mindSlider" class=" " style="transition: all 1.15s ease-in-out;height: 200px;">

                        <div id="tripinfoItem1" class="d-inline-block " ondrop="drop(event)" ondragover="dragover(event)"
                            style="height: 170px; width: 170px;">
                            <img name="pepe"  id="pepe1"
                                src="https://image.chosun.com/sitedata/image/201705/08/2017050801699_0.jpg"
                                draggable="true" ondragstart="dragstart(event)" alt="">

                        </div>
                        <div id="tripinfoItem2" class="d-inline-block " ondrop="drop(event)" ondragover="dragover(event)"
                             style="height: 170px; width: 170px;">
                            <img name="pepe"  id="pepe2"
                                src="https://pbs.twimg.com/profile_images/814761853372895232/IXujsP7W_400x400.jpg"
                                draggable="true" ondragstart="dragstart(event)" alt="">
                        </div>
                        <div id="tripinfoItem3" class="d-inline-block " ondrop="drop(event)" ondragover="dragover(event)"
                             style="height: 170px; width: 170px;">
                            <img name="pepe"  id="pepe3" name="pepe"
                                src="https://i.pinimg.com/236x/11/b4/45/11b4457b49ac98ab10f7cd66afe4423e.jpg"
                                draggable="true" ondragstart="dragstart(event)" alt="">

                        </div>
                        <div id="tripinfoItem4" class="d-inline-block " ondrop="drop(event)" ondragover="dragover(event)"
                            style="height: 170px; width: 170px;">
                            <img name="pepe"  id="pepe4"
                                src="https://t1.daumcdn.net/cfile/tistory/213D9D48587060432F" draggable="true"
                                ondragstart="dragstart(event)" alt="">

                        </div>
                        <div id="tripinfoItem5" class="d-inline-block" ondrop="drop(event)" ondragover="dragover(event)"
                             style="height: 170px; width: 170px;">
                            <img name="pepe"  id="pepe5"
                                src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTKM3FyepNFfAxawu2e7pT313mRDvi88oA0O0FK1ukWqA-diMTY&usqp=CAU"
                                draggable="true" ondragstart="dragstart(event)" alt="">

                        </div>
                        <div id="tripinfoItem6" class="d-inline-block " ondrop="drop(event)" ondragover="dragover(event)"
                             style="height: 170px; width: 170px;">
                            <img name="pepe"  id="pepe6"
                                src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR0wSpI9Eo22g8lDmchzByOjco2SOLT4F31C9clAYL_k8Bp6ytB&usqp=CAU"
                                draggable="true" ondragstart="dragstart(event)" alt="">

                        </div>
                        <div id="tripinfoItem1" class="d-inline-block " ondrop="drop(event)" ondragover="dragover(event)"
                            style="height: 170px; width: 170px;">
                            <img name="pepe"  id="pepe1"
                                src="https://image.chosun.com/sitedata/image/201705/08/2017050801699_0.jpg"
                                draggable="true" ondragstart="dragstart(event)" alt="">

                        </div>
                        <div id="tripinfoItem2" class="d-inline-block " ondrop="drop(event)" ondragover="dragover(event)"
                             style="height: 170px; width: 170px;">
                            <img name="pepe"  id="pepe2"
                                src="https://pbs.twimg.com/profile_images/814761853372895232/IXujsP7W_400x400.jpg"
                                draggable="true" ondragstart="dragstart(event)" alt="">
                        </div>
                        <div id="tripinfoItem3" class="d-inline-block " ondrop="drop(event)" ondragover="dragover(event)"
                             style="height: 170px; width: 170px;">
                            <img name="pepe"  id="pepe3" name="pepe"
                                src="https://i.pinimg.com/236x/11/b4/45/11b4457b49ac98ab10f7cd66afe4423e.jpg"
                                draggable="true" ondragstart="dragstart(event)" alt="">

                        </div>
                        <div id="tripinfoItem4" class="d-inline-block " ondrop="drop(event)" ondragover="dragover(event)"
                            style="height: 170px; width: 170px;">
                            <img name="pepe"  id="pepe4"
                                src="https://t1.daumcdn.net/cfile/tistory/213D9D48587060432F" draggable="true"
                                ondragstart="dragstart(event)" alt="">

                        </div>
                        <div id="tripinfoItem5" class="d-inline-block" ondrop="drop(event)" ondragover="dragover(event)"
                             style="height: 170px; width: 170px;">
                            <img name="pepe"  id="pepe5"
                                src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTKM3FyepNFfAxawu2e7pT313mRDvi88oA0O0FK1ukWqA-diMTY&usqp=CAU"
                                draggable="true" ondragstart="dragstart(event)" alt="">

                        </div>
                        <div id="tripinfoItem6" class="d-inline-block " ondrop="drop(event)" ondragover="dragover(event)"
                             style="height: 170px; width: 170px;">
                            <img name="pepe"  id="pepe6"
                                src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR0wSpI9Eo22g8lDmchzByOjco2SOLT4F31C9clAYL_k8Bp6ytB&usqp=CAU"
                                draggable="true" ondragstart="dragstart(event)" alt="">

                        </div>
                        
                        

                        




                    </div>

                </div>






                <div class="col d-flex bg-info my-2 align-items-center" style="height: auto; width: 50px;">
                    <a href="javascript:void(0)" id="tripinfoNextBt">
                        <span class="carousel-control-next-icon" style="width: 50px;height: 50px;"></span>
                    </a>
                </div>
            </div>

            <div class="row mx-1 justify-content-center">
                <span>아이템을 선택해 일정을 추가하세요.</span>
            </div>

            <div class="row mx-1" style="height: 50px;">
                <div class="d-flex bg-primary rounded-pill justify-content-center align-items-center"
                    style="height: 100%;width: 60px;">
                    <span class="" style="width: auto;height: auto;">1일차</span>
                </div>
                <div class=" d-flex ml-2 bg-success rounded-pill justify-content-center align-items-center"
                    style="height: auto;width: 60px;">
                    <a href="javascript:void(0)" class="font-weight-bold" id="dayPlusBt">+</a>
                </div>
            </div>

            <div class="row">
                <div class="col">

                </div>
                <div class="col-11">
                    <div class="row">
                        <div name="schedule-item" ondrop="drop(event)" ondragover="dragover(event)"
                            onclick="scheduleItemBt()" data-save="1" class="col bg-danger" style="height: 100px;"></div>
                        <div name="schedule-item" ondrop="drop(event)" ondragover="dragover(event)"
                            onclick="scheduleItemBt()" data-save="2" class="col"></div>
                        <div name="schedule-item" ondrop="drop(event)" ondragover="dragover(event)"
                            onclick="scheduleItemBt()" data-save="3" class="col"></div>
                        <div name="schedule-item" ondrop="drop(event)" ondragover="dragover(event)"
                            onclick="scheduleItemBt()" data-save="4" class="col"></div>
                        <div name="schedule-item" ondrop="drop(event)" ondragover="dragover(event)"
                            onclick="scheduleItemBt()" data-save="5" class="col"></div>
                        <div name="schedule-item" ondrop="drop(event)" ondragover="dragover(event)"
                            onclick="scheduleItemBt()" data-save="6" data-save="1" class="col"></div>
                        <div name="schedule-item" ondrop="drop(event)" ondragover="dragover(event)"
                            onclick="scheduleItemBt()" data-save="7" class="col bg-info">
                        </div>
                    </div>
                    <div class="row">
                        <div name="schedule-item" ondrop="drop(event)" ondragover="dragover(event)"
                            onclick="scheduleItemBt()" data-save="8" class="col bg-danger" style="height: 100px;"></div>
                        <div name="schedule-item" ondrop="drop(event)" ondragover="dragover(event)"
                            onclick="scheduleItemBt()" data-save="9" class="col"></div>
                        <div name="schedule-item" ondrop="drop(event)" ondragover="dragover(event)"
                            onclick="scheduleItemBt()" data-save="10" class="col"></div>
                        <div name="schedule-item" ondrop="drop(event)" ondragover="dragover(event)"
                            onclick="scheduleItemBt()" data-save="11" class="col"></div>
                        <div name="schedule-item" ondrop="drop(event)" ondragover="dragover(event)"
                            onclick="scheduleItemBt()" data-save="12" class="col"></div>
                        <div name="schedule-item" ondrop="drop(event)" ondragover="dragover(event)"
                            onclick="scheduleItemBt()" data-save="13" class="col"></div>
                        <div name="schedule-item" ondrop="drop(event)" ondragover="dragover(event)"
                            onclick="scheduleItemBt()" data-save="14" class="col bg-info">
                        </div>
                    </div>
                </div>

                <div class="col">
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

                            <img src="../../picture/trip/plus.png" alt=""
                                style="object-fit: contain;width: 100%;height: 100%;">
                            <input type="file" id="image" name="image" multiple="true" accept="image/jpg, image/png"
                                style="width: 100%;height: 100%;position: absolute;" form="formId">
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
            var div = $('<div class="d-flex ml-2 bg-primary rounded-pill justify-content-center align-items-center" style="height: 100%;width: 60px;"></div>');
            div.append(span).append(a);
            $(event.target).parent().before(div);

        });

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
            prevNextClickCount++;
            $("#mindSlider").css("transform", "translateX(" + (sliderSize * prevNextClickCount) + "px)");

        });
        $("#tripinfoNextBt").on("click", function (e) {
            console.log("tripinfoNextBt");
            prevNextClickCount--;
            $("#mindSlider").css("transform", "translateX(" + (sliderSize * prevNextClickCount) + "px)");

        });
        $("#tripinfoItem1").on("click", function (e) {
            console.log("tripinfoItem1");

        });
        $("#tripinfoItem2").on("click", function (e) {
            console.log("tripinfoItem2");

        });
        $("#tripinfoItem3").on("click", function (e) {
            console.log("tripinfoItem3");

        });
        $("#tripinfoItem4").on("click", function (e) {
            console.log("tripinfoItem4");

        });
        $("#tripinfoItem5").on("click", function (e) {
            console.log("tripinfoItem5");

        });
        $("#tripinfoItem6").on("click", function (e) {
            console.log("tripinfoItem6");

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


        function drop(event) {
            console.log("ondrop");
            event.preventDefault();
            var data = event.dataTransfer.getData("text");
            event.target.appendChild(document.getElementById(data));
        }

        function dragover(event) {
            console.log("ondragover");
            event.preventDefault();


        }
        function dragstart(event) {
            console.log("ondragstart");
            event.dataTransfer.setData("text", event.target.id);

        }


        function tagDelBt(event) {
            console.log("tagDelBt");
            $(event.target).parent().remove();
        }


        function matzipBt() {
            console.log("matzipBt");

        }
        function myoungsoBt() {
            console.log("myoungsoBt");
        }
        function sooksoBt() {
            console.log("sooksoBt");
        }
        function myBt() {
            console.log("myBt");
        }



        $("#submitBt").on("click", function () {
            console.log("submitBt");
            var _userNo = "";
            var _category = $("#category");
            var _writeDate = $("#writeDate");
            var _tag = $("#tag");
            var _title = $("#title");
            var _content = $("#content");
            var _travleLocale = $("#travleLocale");
            var _peopleNum = $("#peopleNum");
            var _travleType = $("#travleType");
            var _travleStartDate = $("#travleStartDate");
            var _travleEndDate = $("#travleEndDate");
            var _publicEnabled = $("#publicEnabled");


            var _tripinfoNo = $("#category");
            var _day = $("#category");
            var _orders = $("#category");
            var _requiredHours = $("#category");
            var _transport = $("#category");

            var form = $("#tripForm")[0];
            var data = new Form(form);

            var trip = {
                user: _userNo,
                category: _category,
                writeDate: _writeDate,
                tag: _tag,
                title: _title,
                content: _content,
                travleLocale: _travleLocale,
                peopleNum: _peopleNum,
                travleType: _travleType,
                travleStartDate: _travleStartDate,
                travleEndDate: _travleEndDate,
                publicEnabled: _publicEnabled,
                deleted: 'n',
                scheduleList: []
            }

            var schedule = {
                tripinfoNo: _tripinfoNo,
                day: _day,
                orders: _orders,
                requiredHours: _requiredHours,
                transport: _transport,
            }
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
            if (number < 1024) {
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