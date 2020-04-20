<%@page import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
<%@page import="com.laon.tripinfo.model.vo.Tripinfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.laon.trip.model.vo.TripSchedule"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%

	String userNo = (String)request.getAttribute("userNo");
	
	List<Tripinfo> matzipList= (List<Tripinfo>)request.getAttribute("matzipList");
	List<Tripinfo> myoungsoList= (List<Tripinfo>)request.getAttribute("myoungsoList");
	List<Tripinfo> sooksoList=(List<Tripinfo>)request.getAttribute("sooksoList");
	
	System.out.println("matzipList : " + matzipList);
	System.out.println("myoungsoList : " + myoungsoList);
	System.out.println("sooksoList : " + sooksoList);


%>

    
<%--     
<!-- 지워도 되는거 -->
<!-- 지워도 되는거 -->
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/css/bootstrap-select.min.css">
<!-- naver SmartEditor -->
<script type="text/javascript" src="<%=request.getContextPath()%>/smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<!-- 폰트 적용 -->
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<!-- 지워도 되는거 -->
<!-- 지워도 되는거 -->

 --%>






<!-- 지우면 안되는거 -->
<!-- 지우면 안되는거 -->
<!-- 달력 -->
<script src="<%=request.getContextPath() %>/js/bootstrap-datepicker.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap-datepicker.ko.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-datepicker.css">
<!-- 부트스트랩 효과 -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mdb.min.css">
<script src="<%=request.getContextPath() %>/js/mdb.min.js"></script>
<!-- 지도 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=40b8b885a553f3222dde4e5effec0d3e&libraries=services"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=40b8b885a553f3222dde4e5effec0d3e"></script>

<!-- 기타 -->
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

/*         header {
            border: 2px solid red;
            box-sizing: border-box;
            height: 150px;
        } */

        section {
            /* border: 2px solid green; */
            box-sizing: border-box;
            width: 1336px;
        }

        section div {
            /* border: 1px solid black; */
            /* box-sizing: border-box; */
        }

/*         footer {
            /* border: 2px solid blue; */
            box-sizing: border-box;

            height: 70px;
        } */

        #titleContainer div {
            /* border: 1px solid black; */
            box-sizing: border-box;
        }

        #tripinfoContainer div {
           /*  border: 1px solid black; */
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
        .ldBtnInactive{
            border-radius: 20px;
            background-color: white;
            border: 2px solid #dadada;
            color: #dadada;
            padding: 6px 15px 6px 15px;
        }   
        .ldBtnInactive:hover,.ldBtnInactive:active {
            color: white;
            background-color: #dadada;
        }                 
        .rotateBtn{
            transform: rotate(180deg);
        }   
		.ldBtnDelet{		
            border-radius: 20px;
            background-color: white;
            border: 2px solid #d60047;
            color: #d60047;
            padding: 6px 15px 6px 15px;
		}
		.ldBtnDelet:hover,.ldBtnDelet:active{	
            color: white;
            background-color: #d60047;
		}   
		.dropdown-menu{
			text-align: center;
		}   
		.dropdown-item{
			color: #00abbf;
		}
		.laonBodyFont{
			font-family: NanumSquare;
			font-size: 22px;
			color: #595959;
		}
		.bolder{
			font-weight: 750;
		}
		.input{
			border: 0;
		}
		.dayBtn{
            border-radius: 20px;
            background-color: #00abbf;
            border: 2px solid #00abbf;
            color: white;
            width: 120px;
            margin-right: 15px;
            padding: 6px 15px 6px 15px;
		}
		#dayPlusBt{
            border: 2px solid #00abbf;
            color: #00abbf;
            font-weight: 900;
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
		.border-danger{
			border-color: #dadada;
		}
		.ldBtnSubmit{
		    border-radius: 20px;
		    background-color: #00abbf;
		    border: 2px solid #00abbf;
		    color: white;
		    padding: 6px 15px 6px 15px;   
		}  
    </style>



    <!-- <header class="container-fluid"></header> -->
	<div style="height: 170px;"></div>

    <section class="container-fluid d-flex flex-column align-items-center">
        <div id="titleContainer" class="row justify-content-center mb-5 w-100">
            <div class="col-4">
                <div class="row dropdown justify-content-center">
                    <button type="button" id="category" name="category"
                        class="ldBtn dropdown-toggle mb-5" data-toggle="dropdown" style="font-weight: 600; width: 150px;">여행 일정</button>
                    <div class="dropdown-menu">
                        <a id="courseDropBt" href="#" class="dropdown-item">여행 일정</a>
                        <a id="reviewDropBt" href="#" class="dropdown-item">여행 후기</a>
                    </div>
                </div>

                <div class="row form-group mb-1">
                    <input type="text" id="title" class="form-control border-top-0 border-left-0 border-right-0 laonBodyFont text-center"
                        name="userName" placeholder="여행기 제목을 입력해주세요." required>
                </div>

                <div class="row align-items-center justify-content-end">
                    <label for="publicEnabled" class="mb-1">공개</label>
                    <div class="custom-control custom-switch">
                        <input type="checkbox" class="custom-control-input" id="publicEnabledId" name="publicEnabled" required>
                        <label for="publicEnabledId" class="custom-control-label"></label>
                    </div>
                </div>
            </div>



        </div>


        <div id="tripinfoContainer" class="w-100">
            <div class="border-bottom text-dark pb-2 pl-2">
                <span class="laonBodyFont bolder">여행정보</span>
            </div>

            <div class="col">
                <div class="row p-5">
                    <div class="col">

                        <div class="row form-group mb-3 ">
                            <span class="col-3 pt-1 font-weight-bold">여행지역</span>
                            <select class="col-6 d-inline-block form-control" id="travleLocale" required>
                                <option value="" disabled selected>여행지역 선택</option>
                                <option>서울</option>
                                <option>부산</option>
                                <option>대구</option>
                                <option>인천</option>
                                <option>광주</option>
                                <option>대전</option>
                                <option>울산</option>
                                <option>세종</option>
                                <option>경기</option>
                                <option>강원</option>
                                <option>충청북도</option>
                                <option>충청남도</option>
                                <option>전라북도</option>
                                <option>전라남도</option>
                                <option>경상북도</option>
                                <option>경상남도</option>
                                <option>제주도</option>
                              </select>        
                        </div>
                        <div class="row form-group mb-0">
                            <span class="col-3 pt-1 font-weight-bold">인원 수</span>
                            <input class="col-6" type="number" id="peopleNum" required
                                class="form-control border-top-0 border-left-0 border-right-0 " name="peopleNum"
                                id="peopleNum" placeholder="인원수를 입력해주세요." autocomplete="off" min=0>
                        </div>
                    </div>
                    <div class="col">
                        <div class="row form-group mb-3">
                            <span class="col-3 pt-1 font-weight-bold">여행유형</span>
                            <select class="col-6 d-inline-block form-control" id="travleType" required>
                                <option value="" disabled selected>여행유형 선택</option>
                                <option>혼자여행</option>
                                <option>가족여행</option>
                                <option>우정여행</option>
                                <option>커플여행</option>
                              </select>    
                        </div>
                        <div class="row form-group mb-0">
                            <span class="col-3 pt-1 font-weight-bold">여행일</span>
                            <input class="col-3 p-0" type="text" required
                                class="form-control border-top-0 border-left-0 border-right-0 " data-date="datePicker"
                                name="travleStartDate" id="travleStartDateId" placeholder="여행시작일 입력">
                            <input class="col-3 p-0" type="text" required
                                class="form-control border-top-0 border-left-0 border-right-0 " data-date="datePicker"
                                name="travleEndDate" id="travleEndDateId" placeholder="여행종료일 입력">
                        </div>
                    </div>
                </div>
            </div>
        </div>




        <div id="courseContainer" class="mt-5 w-100">
            <div class="row mx-1 mb-2">
                <button id="matzipBt" onclick="matzipBt()" class="ldBtnC">맛집</button>
                <button id="myoungsoBt" onclick="myoungsoBt()" class="ldBtnC">명소</button>
                <button id="sooksoBt" onclick="sooksoBt()" class="ldBtnC">숙소</button>
                
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
                            String image = info.getPictureList().get(0).getImage();
							
						%>

                        <div id="matzipItem<%=i %>" name="matzipItem" class="d-inline-block view zoom"
                           
                            style="height: 170px; width: 170px;position: relative;">
                            <img id="matzipImg<%=i %>" onclick="itemBt(event)" name="matzipImg" class="d-block " data-no="<%=no%>" data-category="<%=category %>"
                                data-tag="<%=tag %>" data-name="<%=name %>" data-address="<%=address %>"
                                data-businessHours="<%=businessHours %>" data-tel="<%=tel %>"
                                data-homepage="<%=homepage %>" data-naver="<%=naver %>" data-sns="<%=sns %>"
                                src="<%=request.getContextPath()+"/views/picture/tripinfo/"+image %>"
                                draggable="true" ondragstart="dragstart(event)" alt=""
                                style="position: absolute;left: 0px;top: 0px;width: 100%;height: 100%;z-index: 0;">
                            <div class="mask flex-center rgba-black-strong text-nowrap"
                                style="width: 100%;height: 30px;z-index: 1;overflow: hidden;">
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
                            String image = info.getPictureList().get(0).getImage();
						%>

                        <div id="myoungsoItem<%=i %>" name="myoungsoItem" class="d-none view  zoom"  style="height: 170px; width: 170px;position: relative;">
                                <img id="myoungsoImg<%=i %>"  onclick="itemBt(event)" name="myoungsoImg" class="d-block" data-no="<%=no%>"
                                    data-category="<%=category %>" data-tag="<%=tag %>" data-name="<%=name %>"
                                    data-address="<%=address %>" data-businessHours="<%=businessHours %>"
                                    data-tel="<%=tel %>" data-homepage="<%=homepage %>" data-naver="<%=naver %>"
                                    data-sns="<%=sns %>"
                                    src="<%=request.getContextPath()+"/views/picture/tripinfo/"+image %>"
                                    draggable="true" ondragstart="dragstart(event)" alt=""
                                    style="position: absolute;left: 0px;top: 0px;width: 100%;height: 100%;z-index: 0;">
                                <div class="mask flex-center rgba-black-strong text-nowrap"
                                    style="width: 100%;height: 30px;z-index: 1;overflow: hidden;">
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
                            String image = info.getPictureList().get(0).getImage();
							
						%>

                        <div id="sooksoItem<%=i %>" name="sooksoItem" class="d-none view  zoom"  style="height: 170px; width: 170px;position: relative;">
                            <img id="sooksoImg<%=i %>" onclick="itemBt(event)" name="sooksoImg" class="d-block" data-no="<%=no%>" data-category="<%=category %>"
                                data-tag="<%=tag %>" data-name="<%=name %>" data-address="<%=address %>"
                                data-businessHours="<%=businessHours %>" data-tel="<%=tel %>"
                                data-homepage="<%=homepage %>" data-naver="<%=naver %>" data-sns="<%=sns %>"
                                src="<%=request.getContextPath()+"/views/picture/tripinfo/"+image %>"
                                draggable="true" ondragstart="dragstart(event)" alt=""
                                style="position: absolute;left: 0px;top: 0px;width: 100%;height: 100%;z-index: 0;">
                            <div class="mask flex-center rgba-black-strong text-nowrap"
                                style="width: 100%;height: 30px;z-index: 1;overflow: hidden;">
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
            <div class="row mx-1 mb-4" style="height: 50px;">
                <div id="firstDay" class="d-flex dayBtn rounded-pill justify-content-center align-items-center"
                    style="height: 100%; cursor: pointer;" data-save="1" onclick="dayBt(event)">
                    <span class="" style="width: auto;height: auto;" data-save="1">1일차</span>
                </div>
                <div class=" d-flex ml-2 rounded-pill justify-content-center align-items-center font-weight-bold"
                    style="height: auto;width: 60px;cursor: pointer;" id="dayPlusBt">
                    +
                </div>
            </div>


            <!-- 스케줄 추가 -->
            
            <div id="dayContainer" class="col p-0 mx-1 mt-3 mb-3">

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
                                style="object-fit: contain;width: 120%;height: 120%; opacity: 0.6; cursor: pointer;">
                            <input type="file" id="image" name="image" multiple accept=".jpg, .png"
                                style="width: 100%;height: 100%;position: absolute; cursor: pointer;" form="tripForm" required>
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
                <textarea class="form-control" rows="5" id="content" name="text"></textarea>
            </div>


            <div class="row mx-2 justify-content-center" style="height: 120px;">
                <!-- <div class="d-flex flex-wrap" style="height: 30px;">
                    <div>
                        <input id="tag" name="tag" type="text" class="border-0" style="width: auto;" required>

                    </div>
                </div> -->


                <div class="form-group d-flex flex-column flex-wrap justify-content-center"
                    style="width: 100%;height: 120px;">
                    <p class="mb-2 ml-2 align-items-start">관심태그를 <strong>클릭</strong>해주세요. (최대 5개)</p>
                    <div class="checkbox border text-center p-2 rounded-lg">
                        <input type="checkbox" name="likeTag" id="cb1" value="혼자여행"><label for="cb1">#혼자여행</label>
                        <input type="checkbox" name="likeTag" id="cb2" value="가족여행"><label for="cb2">#가족여행</label>
                        <input type="checkbox" name="likeTag" id="cb3" value="우정여행"><label for="cb3">#우정여행</label>
                        <input type="checkbox" name="likeTag" id="cb4" value="커플여행"><label for="cb4">#커플여행</label>
                        <input type="checkbox" name="likeTag" id="cb5" value="맛집투어"><label for="cb5">#맛집투어</label>
                        <input type="checkbox" name="likeTag" id="cb6" value="카페투어"><label for="cb6">#카페투어</label>
                        <input type="checkbox" name="likeTag" id="cb7" value="관광지_탐방"><label for="cb7">#관광지_탐방</label>
                        <input type="checkbox" name="likeTag" id="cb8" value="힐링"><label for="cb8">#힐링</label>
                        <input type="checkbox" name="likeTag" id="cb9" value="축제"><label for="cb9">#축제</label>
                        <input type="checkbox" name="likeTag" id="cb10" value="인생샷"><label for="cb10">#인생샷</label>
                        <input type="checkbox" name="likeTag" id="cb11" value="숨은_명소"><label for="cb11">#숨은_명소</label>
                        <input type="checkbox" name="likeTag" id="cb12" value="액티비티"><label for="cb12">#액티비티</label>
                        <input type="checkbox" name="likeTag" id="cb13" value="당일치기"><label for="cb13">#당일치기</label>
                        <input type="checkbox" name="likeTag" id="cb14" value="주말여행"><label for="cb14">#주말여행</label>
                        <input type="checkbox" name="likeTag" id="cb15" value="캠핑"><label for="cb15">#캠핑</label>
                    </div>
                </div>

            </div>


            <div id="formContainer" style="height: 150px;" class="d-flex align-items-center">
                <form class="d-flex col justify-content-center" id="tripForm"
                    action="<%=request.getContextPath()%>/trip/tripInsertEnd.do" method="POST"
                    enctype="multipart/form-data">
                    <input class="ldBtn" type="reset" id="resetBt" value="취소" style="width: 120px;">
                    <input class="ldBtnSubmit ml-4" type="button" id="submitBt" value="전송" style="width: 120px;">
                    <input type="hidden" id="fileNames" name="fileNames" value="">

                </form>
            </div>

    </section>


<!--     <footer class="container-fluid"></footer> -->






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
            var div = $('<div class="d-flex ml-2 dayBtn rounded-pill justify-content-center align-items-center" style="height: 100%;width: 120px;cursor: pointer;" onclick="dayBt(event)"></div>');
            div.append(span).append(a);
            div[0].dataset.save = dayCount;
            $(event.target).before(div);
            $(event.target).prev().prev().find("a").remove();


            var daytemple = $("#dayTemple").clone();
           
            daytemple.attr("id","day"+dayCount);
            daytemple.attr("name","day");
            daytemple[0].dataset.save = dayCount;
            daytemple.addClass("d-none");
            daytemple.find("[name='scheduleOrder']")[0].dataset.order = 1;
            var daytempleClone = daytemple.clone();
            $("#dayContainer").append(daytempleClone);
            setTimeout(function(){
                $(event.target).prev().trigger("click");
               
                
            },10);
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
           
           console.log("dayBt")
        }

        
        
        
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
            mapOption = {
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };

        // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
        var map = new kakao.maps.Map(mapContainer, mapOption);

        function itemBt(event) {
            console.log("itemBt")
            console.log("nodeName : " + $.nodeName(event.target, "img"));
            var target = event.target;
            if ($.nodeName(event.target, "img")) {

            } else {
                // target = $(event.target).parent()[0];
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
    
    
        function dayDelBt(e) {
            console.log("dayDelBt");
            $("[name='day']")
            for(let i=0;i<$("[name='day']").length;i++){
                if($(e.target).parent()[0].dataset.save == $("[name='day']")[i].dataset.save){
                    $($("[name='day']")[i]).remove();
                }
                
            }
            
            console.log("daylksjdflkjsldkjlfkj : "  + $(e.target).parent()[0].dataset.save)
            if($(e.target).parent().prev()[0].dataset.save != 1){
                    var a = $('<a href="javascript:void(0)" class="text-light" name="dayDelBt" onclick="dayDelBt(event)">x</a>');
                    $(e.target).parent().prev().append(a);
            }
            var prev = $(e.target).parent().prev();
            $(e.target).parent().remove();
            dayCount--;
           
            setTimeout(function(){
                prev.trigger("click");
               
                
            },10);
        }




        $("#courseDropBt").on("click", function (e) {
            console.log("courseDropBt");
            $("#category").html("여행 일정");
            $("#category").val("여행 일정")
        });
        $("#reviewDropBt").on("click", function (e) {
            console.log("reviewDropBt");
            $("#category").html("여행 후기");
            $("#category").val("여행 후기")

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

        var tag = "";
        $(":checkbox").change(function () {
            tag = "";
            var cnt = 5;
            if($("#publicEnabledId").is(":checked")){
                cnt = 6;
            }
            

            // 셀렉트박스의 값과 체크박스중 체크된 갯수가 같을때, 다른 체크박스들을 disable 처리
            if (cnt == $(":checkbox:checked").length) {
                $(":checkbox:not(:checked)").attr("disabled", "disabled");
            }
            // 체크된 갯수가 다르면 활성화 시킴
            else {
                $(":checkbox").removeAttr("disabled");
            }

            for(let i=0;i<$(":checkbox:checked").length;i++){
                tag += $($(":checkbox:checked")[i]).val()+",";
            }
            console.log("tag : " + tag);

        });






        // $("#tag").on("keyup", function (e) {
        //     console.log("tag : " + e.keyCode);
        //     var str = $(e.target).val();
        //     if ($(e.target).val().length > 0 && e.keyCode == 13) {
        //         var input = $('<input name="tag" type="text" class="border-0" style="width: auto;">');
        //         input.val(str);
        //         var a = $('<a href="javascript:void(0)" name="tagDelBt" onclick="tagDelBt(event)">x</a>');
        //         var div = $("<div>");
        //         div.addClass("mr-2");
        //         div.append(input).append(a);
        //         $(e.target).parent().before(div);

        //         $(e.target).val("");
        //     }
        // });



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
         
            //캘린더 체크
            var startDate = Number($("#travleStartDateId").val().split("-").join(""));
            var endDate = Number($("#travleEndDateId").val().split("-").join(""));
            console.log(startDate);
            console.log(endDate);
            if(startDate > endDate){
                alert("여행일을 다시 확인해 주세요.");
                return false;
            }


            //관심사 태그 체크박스 하나 이상 확인
            if ($("input[type=checkbox][name=likeTag]:checked").length == 0) {
                alert("관심 태그 항목을 하나 이상 체크해 주세요.");
                return false;
            }


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
                    console.log("requiredTime : "+requiredTime);
                    if(requiredTime == ""){
                        //alert("이동 소요시간을 입력해주세요.");
                    }
                    var schedule = {
                    tripinfoNo: schduleData.no,
                    days: dayData.save,
                    orders: schduleData.order,
                    requiredHours: requiredTime,
                    transport: transport,
                    
                    }
                    console.log("dayData.save : " + dayData.save);
                    console.log("tripinfoNo : " + schedule.tripinfoNo);
                    console.log("order : " + schduleData.order);
                    console.log("requiredTime : " + requiredTime);
                    console.log("transport : " + transport);
                    day.scheduleList.push(schedule);
                }
                dayList.push(day);
            }



            var _userNo = "<%=userNo%>";
            var _category = $("#category").html(); // 확인
            // var _writeDate = $("#writeDate");
            tag = tag.substr(0,tag.length-1);
            var _tag = tag;
            var _title = $("#title").val();
            var _content = $("#content").val();
            var _travleLocale = $("#travleLocale").val();
            var _peopleNum = $("#peopleNum").val();
            var _travleType = $("#travleType").val();
            var _travleStartDate = $("#travleStartDateId").val();
            var _travleEndDate = $("#travleEndDateId").val();
            var isEnabled = $("#publicEnabledId").is(":checked") == true ? 'y' : 'n';
            var _publicEnabled = isEnabled;


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
                    window.document.write(data);
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
<%@ include file="/views/common/footer.jsp"%> 