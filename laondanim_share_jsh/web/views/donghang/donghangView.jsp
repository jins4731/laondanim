<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp"%>


    <section class="d-flex flex-column justify-content-center align-items-center">
        <div style="width: 1366px;" class="d-flex flex-column justify-content-center align-items-center">

            <!-- 제목 + 버튼 줄 -->
            <div class="d-flex flex-row justify-content-between align-items-center" style="width: 828px; height: 100px;">
                <div class="d-flex flex-row justify-content-center align-items-center" style="width: 480px;">
                    <!--글쓴이 프사 넣기-->
                    <img src="<%=%>" alt="프로필사진" style="width: 50px; height: 50px;">

                    <div class="d-flex flex-column pl-1" style="width: 380px;">
                        <div class="d-flex flex-row align-items-center">
                            <% if(){%>
                            <div class="recruitBox d-inline-block mr-1">모집중</div>
                            <%}%>
                            <p class="m-0">제목이 들어가는 자리</p>

                        </div>
                        <p class="m-0"><%=닉넴 넣기%></p>
                    </div>

                    <img src="icon/menu-vertical_icon.png" alt="메뉴" style="width: 20px; height: 20px;">
                </div>
                <div>
                    <button id="danimLinkBtn" type="button" class="ldBtn">다님일정 보기 <strong class="ml-1">&#9002;</strong></button>
                    <button type="button" class="ldBtn ml-2" data-toggle="modal" data-target="#myModal">참여하기</button>
                </div>
            </div>

            <!-- 이미지 + 정보 줄 -->
            <div class="d-flex justify-content-center align-items-center" style="width: 1000px; height: 350px;">
                <div style="width: 480px; height: 270px; position: relative;" class="border d-flex justify-content-center align-items-center mr-5">
                    <img style="width: 100%; height: 100%;" src="img/1920x1080_img.jpg">
                </div>


                <table class="p-0" style="width: 300px; height: 250px;">
                        <tr>
                            <td class="p-0">
                                <div class="d-flex flex-row justify-content-between align-items-center">
                                    <div class="recruitBox">모집중</div>
                                    <p class="m-0">~ 2020-04-02</p>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td class="p-0">여행지역</td>
                        </tr>
                        <tr>
                            <td class="p-0 border-bottom">
                                <span class="pl-3"></span>경상북도 경주시
                            </td>
                        </tr>

                        <tr>
                            <td class="p-0 pt-2">모집인원</td>
                        </tr>
                        <td class="p-0 border-bottom">
                            <span class="pl-3"></span>2 / 7
                        </td>
                        </tr>
                        <tr>
                            <td class="p-0 pt-2">여행일</td>
                        </tr>
                        <tr>
                            <td class="p-0 border-bottom">
                                <span class="pl-3"></span> 2020-04-02 ~ 2020-04-16
                            </td>
                        </tr>
                </table>
            </div>

            <div class="d-flex flex-column align-items-center" style="width: 828px;">
                <div class="d-flex justify-content-between align-items-center" style="width: 95%;">
                    <p class="m-0">현재 참여 동행인</p>
                    <img src="icon/expand-arrow.png" style="width:17px;"
                    type="button" data-toggle="collapse" data-target="#detailText" aria-expanded="true" aria-controls="detailText">
                </div>
                <hr class="mt-2 mb-1" style="width: 828px; border-bottom: 2px solid #dadada;">
                <div class="row collapse multi-collapse " id="detailText">                            
                    <ul style="list-style: none;" class="d-flex">
                        <li class="d-flex justify-content-center align-items-center m-2">
                            <img src="icon/profile_icon.png" alt="프로필사진" style="width: 50px; height: 50px;">
                            <p class="m-0">닉네임누구누구 님</p>
                        </li>
                        <li class="d-flex justify-content-center align-items-center m-2">
                            <img src="icon/profile_icon.png" alt="프로필사진" style="width: 50px; height: 50px;">
                            <p class="m-0">닉네임123 님</p>
                        </li>
                        <li class="d-flex justify-content-center align-items-center m-2">
                            <img src="icon/profile_icon.png" alt="프로필사진" style="width: 50px; height: 50px;">
                            <p class="m-0">유저01 님</p>
                        </li>
                    </ul>            
                </div>               
            </div>


            <div>
                <div class="d-flex flex-column justify-content-end align-items-center" style="height: 320px; border: 1px solid white;">
                    <fieldset class="form-group">
                        <legend for="email-label" class="bg-white p-0 m-0 text-center" style="width: 20%;">상세내용</legend>
                        <div class="p-4" style="width: 828px; height: 240px; border-radius: 5px; border:2px solid #dadada;">
                        </div>
                    </fieldset>
                </div> 
            </div>            
        </div>
    </section>


    <!------------------------------------------------------------------------------------------------------------------------------>
    <!-- 참여신청 모달 -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header d-flex justify-content-center border-bottom-0 mt-3">
                    <div class="d-flex justify-content-between align-items-center" style="width: 650px;">                        
                        <div class="d-flex flex-row justify-content-start align-items-center">                            
                            <div class="recruitBox d-inline-block mr-1">모집중</div>
                            <h5 class="m-0">제목</h5>
                            <p class="m-0 ml-4">~ 2020-04-02</p>
                        </div>
                        
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" style="font-size: 30px;">&times;</span>
                        </button>
                    </div>
                    
                </div>
                <div class="modal-body">
                    <div class="d-flex flex-column justify-content-center align-items-center"">

                        <div class="d-flex justify-content-between align-items-center mb-4" style="width: 650px; height: 160px;">
                            <div class="d-flex flex-column mr-4">
                                <div class="d-flex justify-content-center align-items-center">
                                    <img src="icon/profile_icon.png" alt="프로필사진" style="width: 70px; height: 70px;" class="m-0">
                                </div>
                                <p class="m-0">아이디user1</p>
                                <p class="m-0">닉네임닉닉닉</p>
                            </div>

                            <table style="width: 420px;">
                                <tr>
                                    <td class="p-0 pr-2">이름</td>
                                    <td class="p-0 pl-2">성별</td>
                                </tr>
                                <tr>
                                    <td class="p-0 pr-2">라온다님<hr class="m-0"></td>
                                    <td class="p-0 pl-2">여성<hr class="m-0"></td>
                                </tr>
                                <tr>
                                    <td class="p-0 pr-2 pt-4">생년월일</td>
                                    <td class="p-0 pl-2 pt-4">휴대전화 번호</td>
                                </tr>
                                <tr>
                                    <td class="p-0 pr-2">2000 - 04 - 03<hr class="m-0"></td>
                                    <td class="p-0 pl-2">010 - 1324 -5678<hr class="m-0"></td>
                                </tr>
                            </table>
                        </div>

                        <div class="d-flex flex-column justify-content-end align-items-center" style="border: 1px solid white;">
                            <fieldset class="form-group m-0">
                                <legend for="email-label" class="bg-white p-0 m-0 w-25 text-center">자기소개</legend>
                                <textarea class="form-control p-2" cols="87" rows="4"></textarea>
                            </fieldset>
                        </div> 
                    </div>
                </div>
                <div class="modal-footer d-flex justify-content-center border-top-0">
                    <button id="danimJoinBtn" type="button" class="ldBtn mb-3" data-dismiss="modal">참여신청</button>
                </div>
            </div>
        </div>
    </div>

    <!--스타일-->
    <style>
        fieldset.form-group {
          position: relative;
        }        
        legend {
          font-size: 18px;
          position: absolute;
          top: -15px;
          left: 1rem;
          transition: all .4s linear;
        }
        .recruitBox{
            width: 40px;
            height: 17px;
            border-radius: 15px;
            text-align: center;
            background-color: #00abbf;
            color: white;
            font-size: 10px;
            font-weight: 600;
            padding: 2px 4px 2px 4px;
        }
        fieldset legend{
            font-size: 16px;
        }
        .ldBtn{
            border-radius: 20px;
            background-color: white;
            border: 2px solid #00abbf;
            color: #00abbf;
            padding: 6px 15px 6px 15px;
        }  
        .ldBtn:hover,.btn:active {
            color: white;
            background-color: #00abbf;
        }               
    </style> 

    <!-- 스크립트 -->
    <script>

    </script>

<%@ include file="/views/common/footer.jsp"%> 