<%@page import="com.laon.common.CommonKey"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.List" %>
<%@page import="com.laon.etc.model.vo.Like" %>
<%@page import="com.laon.trip.model.vo.TripMyCon" %>

<%
	List<TripMyCon> tripList = (List<TripMyCon>)request.getAttribute(CommonKey.TRIP_LIST);
	List<Like> likeList = (List<Like>)request.getAttribute(CommonKey.LIKE_LIST);
	
%>

<%@ include file="/views/common/header.jsp"%>
   	<div style="height: 170px;"></div>
    <section class="d-flex flex-column justify-content-center align-items-center">
        <div style="width: 1366px;" class="d-flex flex-column justify-content-center align-items-center">

    <form action="<%=request.getContextPath() %>/donghang/donghangWriteEnd.do?userNo=<%=loginUser.getNo()%>" method="post"
    	enctype="multipart/form-data">
            <!-- 제목 -->
            <div class="d-flex flex-column justify-content-center align-items-center" style="height: 150px; border: 1px solid white;">
                <!-- <h5 style="width: 380px;" class="d-flex justify-content-center border-bottom p-2">제목이 들어가는 자리</h5> -->
                <input type="text" name="donghangTitle" placeholder="제목을 입력하세요" style="width: 380px;" class="d-flex text-center border-0 p-2">
                <hr style="width: 380px;" class="m-0">
            </div>

            <!-- 이미지 + 정보 줄 -->
            <div class="d-flex justify-content-center align-items-center" style="width: 1000px; height: 350px;">
                <div style="width: 480px; height: 270px; position: relative;" class="border d-flex justify-content-center align-items-center mr-5">
                    <!--사진 넣는 버튼-->
                    <input type="file" id="file" name="imageFile" accept="image/*" onchange="changeValue(this)"/>
                    <button type="button" id="btnFileUplaod" style="width: 50px; height: 50px; border-radius: 25px; position: absolute; background-color: rgba(0, 0, 0, 0.746); color: white; display: flex;
                    justify-content: center; align-items: center; font-size: 25px;" class="border-0">
                        <p style="height: 50px;" class="m-0 pt-1">+</p>
                    </button>
                    <img id="preview" style="width: 100%; height: 100%;">
                </div>


                <table class="p-0" style="width: 300px; height: 250px;">
                    <tr>
                        <td class="p-0">여행지역</td>
                    </tr>
                    <tr>
                        <td class="p-0 border-bottom">
                            <div class="form-group m-0">
                                <select name="travelLocalSelect" class="form-control border-0" id="travelLocalSelect" required>
                                  <option value="" disabled selected>관심지역 선택</option>
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
                            <input type="hidden" id="travelLocal" name="travelLocal">
                        </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="p-0 pt-2">동행인원수</td>
                    </tr>
                    <td class="p-0 border-bottom d-flex align-items-center">
                        <div id="minus" class="ml-3"></div>
                        <input type="number" class="form-control w-50 text-center border-0" value="1" placeholder="동행(모집) 인원" name="recruitPeopleNo" id="recruitPeopleNo" required>
                        <div id="plus"></div>
                    </td>
                    </tr>
                    <tr>
                        <td class="p-0 pt-2">여행일</td>
                    </tr>
                    <tr>
                        <td class="p-0 border-bottom">
                            <span class="pl-3 d-flex justify-content-around">
                            <input type="date" name="travelStartDate" id="travelStartDate" class="border-0 text-center" required>
                                <span class="ml-3 mr-3"> ~ </span> 
                            <input type="date" name="travelEndDate" id="travelEndDate" class="border-0 text-center" required>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="p-0 pt-2">모집기간</td>
                    </tr>
                    <tr>
                        <td class="p-0 border-bottom">
                        <span class="pl-3 d-flex justify-content-around">
                            <input type="date" name="recruitStartDate" id="recruitStartDate" class="border-0 text-center" required>
                            <span class="ml-3 mr-3"> ~ </span> 
                            <input type="date" name="recruitEndDate" id="recruitEndDate" class="border-0 text-center" required>
                        </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="p-0 pt-2">
                            	공개설정                     
                        </td>
                    </tr>
                    <tr>
                        <td class="p-0 border-bottom d-flex" style="height: 28px;">
                        <!-- Default checked -->
                        <span class="pl-3"></span>
                        <input type="checkbox" name="publicEnabled" id="publicEnabled" checked>
                        <label for="publicEnabled" class="d-flex align-items-center">
                            <div id="switchBtnBox" class="d-flex align-items-center">
                                <div id="switchBtn"></div>
                            </div>
                            <span  id="publicEnabledLabel">공개</span>
                        </label>
                            <input type="password"" name="donghangPw" id="donghangPw" class="ml-5 border-0" placeholder="비밀번호 입력">
                        </td>
                    </tr>
                </table>

                
            </div>



                <!-- trip 연결 -->
                <div class="d-flex flex-column justify-content-center align-items-center" style="height: 150px; border: 1px solid white;">
                    <button type="button" id="danimLinkBtn" class="ldBtn mb-3" data-toggle="modal" data-target="#myModal">여행일정 연결하기</button>
                    <div id="danimTitleBox">
                    	<span id="danimTitle"></span>
                    </div>
                </div>

				<!-- tripList에서 클릭된 값을 저장하는 input -->
				<input type="hidden" name="selectTripNo" id="selectTripNo" value="0">


                <!--상세내용-->
                <div>
                    <div class="d-flex flex-column justify-content-end align-items-center" style="height: 320px; border: 1px solid white;">
                        <fieldset class="form-group">
                            <legend for="email-label" class="bg-white p-0 m-0 w-25 text-center">상세내용</legend>
                            <textarea name="content" class="p-4" style="width: 870px; height: 240px; border-radius: 5px; border:2px solid #dadada;"></textarea>
                        </fieldset>
                    </div> 
                </div>            

                <!--태그-->
                <div>
                    <div class="d-flex flex-column justify-content-end align-items-center mt-3" style="border: 1px solid white;">
                        <fieldset class="form-group">
                            <legend for="email-label" class="bg-white p-0 m-0 w-25 text-center">태그</legend>
                            <textarea name="tag"" class="p-4" style="width: 870px; height: 90px; border-radius: 5px; border:2px solid #dadada;"></textarea>
                        </fieldset>
                    </div> 
                </div>   


                <!-- 취소/등록 -->
                <div class="d-flex justify-content-center align-items-center" style="height: 120px; border: 1px solid white;">
                    <button type="button" id="cancel" class="ldBtnInactive mr-3 mb-3">취소하기</button>
                    <input type="submit" value="등록하기" id="submit" class="ldBtn ml-3 mb-3">
                </div>
            


            <!-- 여행 연결 -->
            <div class="modal fade" id="myModal">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                    
                        <!-- Modal Header -->
                        <div class="modal-header border-bottom-0">
                            <h4 class="modal-title">내 여행일정</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        
                        <!-- 여행일정 -->
                        <div class="modal-body d-flex justify-content-center p-0">
                            <div style="position: relative; width: 770px; height: 330px; overflow: hidden;" 
                                class="d-flex align-items-center justify-content-start">
                                
                                    <ul style="zoom: 0.8; list-style: none; position: absolute; left: 0;" id="danimList" class="d-flex align-items-center p-0">
											<%for(int i=0; i<tripList.size(); i++) {%>
                                            <label>
                                            <li class="pr-1">
                                            	<input type="checkbox" name="selectTrip" id="<%=tripList.get(i).getNo()%>" value="<%=tripList.get(i).getNo()%>"
                                            		onclick="doOpenCheck(this);">
                                                <div class="card" style="width: 235px; height: 385px;" >
                                                    <div class="d-flex justify-content-between p-2">
                                                        <span><%=tripList.get(i).getCategory()%></span>
                                                        <span><%=tripList.get(i).getWriteDate() %></span>
                                                    </div>
                                                    <img src="<%=request.getContextPath()%>/views/picture/trip/<%=tripList.get(i).getImage()%>" class="card-img" alt="..." width="235px" height="235px">
                                                    <div class="d-flex flex-column justify-content-center card-body p-2" style="line-height: 22px;">
                                                        <span><%=tripList.get(i).getTitle()%><span><br>
                                                        <span><%=loginUser.getNickName()%></span><br>
                                                        <img src="<%=request.getContextPath()%>/views/picture/trip/likeChecked.png" width="20px" height="20px"/>
						                                <span>
						                                	<%
						                                	int likeCount = 0;
						                                	for(int j=0; j<likeList.size(); j++){ 
						                                		if(tripList.get(i).getNo()==likeList.get(j).getTripNo())
						                                			likeCount = likeList.get(j).getLikeCount();
						                                	}
						                                	%>
						                                	<%=likeCount %>
						                                </span>   <!--좋아요 수 가져오기 !!-->
                                                    </div>
                                                </div>
                                            </li>
                                            </label>
                                            <%} %>             
                                    </ul>
                                
                                
                                    <div style="width: 766px; position: absolute;" class="d-flex flex-row justify-content-md-between">
                                        <button type="button" style="border:none; background: none;" id="back">
                                            <img src="<%=request.getContextPath()%>/images/img-left_icon.png" style="width: 50px;">
                                        </button>
                                        <button type="button" style="border:none; background: none;" id="next">
                                            <img src="<%=request.getContextPath()%>/images/img-right_icon.png"style="width: 50px;">
                                        </button>
                                    </div>
                            </div>
                        </div>
                        
                    
                        <!-- Modal footer -->
                        <div class="modal-footer border-top-0">
                            <button type="button" class="ldBtn" data-dismiss="modal">선택완료</button>
                        </div>
                    </div>
                </div>
            </div>


            <!--사진&정보 스타일-->
            <style>
                td > input[type=checkbox] {
                    display:none;                 
                }
                input[type=checkbox] + label { 
                    display: inline-block; 
                    cursor: pointer; 
                    margin: 0;                
                }
                input[type=checkbox]:checked + label {
                    color: #00abbf; 
                    font-weight: 550; 
                }    
                input[type="number"]::-webkit-outer-spin-button,
                input[type="number"]::-webkit-inner-spin-button {
                    -webkit-appearance: none;
                    margin: 0;
                }    
                input[type="date"]::-webkit-outer-spin-button,
                input[type="date"]::-webkit-inner-spin-button {
                    -webkit-appearance: none;
                    margin: 0;
                }
                /*스위치버튼*/
                #switchBtnBox{
                    width: 27px;
                    height: 14px;
                    background-color: #00abbf;
                    border-radius: 10px;
                    margin-right: 5px;
                    padding-left: 1px;
                    padding-right: 1px;
                }
                #switchBtn{
                    width: 11px;
                    height: 11px;
                    background-color: white;
                    border-radius: 10px;
                    box-shadow: 2px 2px 2px #59595996;
                }
                #minus, #plus{
                    border: 2px solid #dadada;
                    background-color: white;
                    border-radius: 5px;
                    width: 17px;
                    height: 17px;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    cursor: pointer;
                }  
                input[name="imageFile"]{    
                    display:none;
                }
            </style>     
               
            <script>
                /*동행 공개설정 스크립트*/
                $("#donghangPw").hide();
                $("#publicEnabled").click(()=>{
                    if(!$("#publicEnabled").is(":checked")){
                        $("#publicEnabledLabel").text('비공개');
                        $("#switchBtnBox").css("background-color","#dadada");
                        $("#switchBtnBox").addClass("justify-content-end");
                        $("#publicEnabled").val("비공개");
                        $("#donghangPw").show();
                    }else{
                        $("#publicEnabledLabel").text('공개');
                        $("#switchBtnBox").css("background-color","#00abbf");
                        $("#switchBtnBox").removeClass("justify-content-end");
                        $("#publicEnabled").val("공개");
                        $("#donghangPw").hide();
                    }
                });

                /*동행인원수 증감 버튼*/
                let peopleNum = $("#recruitPeopleNo").val();
                $("#minus").click(()=>{
                    if($("#recruitPeopleNo").val()>0){
                        peopleNum--;
                        $("#recruitPeopleNo").val(peopleNum);
                    }
                    
                    console.log($("#recruitPeopleNo").val());
                });
                $("#plus").click(()=>{
                        peopleNum++;
                        $("#recruitPeopleNo").val(peopleNum);
                        console.log($("#recruitPeopleNo").val());
                });

                /*파일로 올린 사진을 미리보기*/
                /* 1)버튼을 눌러 사진파일 받기 */
                $(function () {
                    $('#btnFileUplaod').click(function (e) {
                        e.preventDefault();
                        $('#file').click();
                    });
                });

/*                 function changeValue(obj){
                    alert(obj.value);
                }   */ 

                /* 2) 미리보기 fn*/
                function readInputFile(input) {
                    if(input.files && input.files[0]) {
                        var reader = new FileReader();
                        reader.onload = function (e) {
                        $('#preview').attr("src", e.target.result);
                    }
                    reader.readAsDataURL(input.files[0]);
                    }
                }
            
                $("#file").on('change', function(){
                    readInputFile(this);
                });               
                
                
                /* trip일정 선택해서 넣어주기 */
                $("#")

            </script>    

            <!--모달 스타일-->
            <style>
                fieldset.form-group {
                position: relative;
                }        
                legend {
                font-size: 18px;
                position: absolute;
                top: -15px;
                left: 1rem;
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
                .ldBtnInactive{
                    border-radius: 20px;
                    background-color: white;
                    border: 2px solid #dadada;
                    color: #dadada;
                    padding: 6px 15px 6px 15px;
                }   
                .ldBtnInactive:hover,.btn:active {
                    color: white;
                    background-color: #dadada;
                }   
                .rotateBtn{
                    transform: rotate(180deg);
                }   
                input:focus {outline:none;}
                .modal li{
                    cursor: pointer;
                }
            </style> 


            <!--여행일정 모달 스크립트-->
			<script>        
                if($("#danimList").offset().left == 0){
                    $("#back").css("visibility","hidden");
                }

                $("#back").click(()=>{
                    $("#danimList").animate({left: "+=237px"});
                });

                $("#next").click(()=>{
                    $("#danimList").animate({left: "-=237px"});
                    $("#back").css("visibility","visible");
                });

                /*리스트에 체크된 값을 히든인풋에 넣어주기*/                
                $('button[data-dismiss="modal"]').click(()=>{
                    /* alert($('input[name="selectTrip"]:checked').val()); */
                    let no = $('input[name="selectTrip"]:checked').val();
                    $("#selectTripNo").val(no);
                    console.log( $("#selectTripNo").val());
                });
   
                let liNo = $('input[name="selectTrip"]:checked').val();
                let str = "#ck"+liNo;
                /* 체크박스 개수 제한 */
                function doOpenCheck(chk){
                var obj = document.getElementsByName("selectTrip");
                    for(var i=0; i<obj.length; i++){
                        if(obj[i] != chk){
                            obj[i].checked = false;
                        }
                    }
                }

            </script>

    	</form>
        </div>
    </section>

<%@ include file="/views/common/footer.jsp"%> 