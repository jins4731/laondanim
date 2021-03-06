<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.laon.donghang.model.vo.DonghangJoinUserPicture"%>
<%@ page import="com.laon.donghang.model.vo.DonghangJoin"%>
<%@ page import="com.laon.user.model.vo.UserProfile"%>

<%@ page import="com.laon.common.CommonKey"%>
<%@ page import="com.laon.common.MypageKey"%>
<%@page import="com.laon.common.DonghangKey"%>
<%@page import="com.laon.common.UserKey"%>

<%@ page import="java.util.List"%>

<%@ include file="/views/common/header.jsp"%>

<%
	DonghangJoinUserPicture dh = (DonghangJoinUserPicture)request.getAttribute(CommonKey.DONGHANG_ITEM);
	String userImage = (String)request.getAttribute(MypageKey.USER_IMAGE);
	List<UserProfile> joinList = (List)request.getAttribute(DonghangKey.JOIN_PEOPLE);
	
	//페이지이용하고 있는 로그인 유저의 프로필 사진
	UserProfile uProfile=(UserProfile)session.getAttribute("userProfile");
	
	//페이지이용하고 있는 로그인 유저의 동행 참여여부(테이블로 가져와서 안에서 처리)
	DonghangJoin dji = (DonghangJoin)request.getAttribute(CommonKey.DONGHANG_JOIN_ITEM);
	
	//작성자 프사 저장
	String dhWriterimg = "";
	for(UserProfile u : joinList){
		if(u.getNo()==dh.getUserNo()){
			dhWriterimg = u.getImage();
		}
	}	
%>
   	<div style="height: 170px;"></div>
    <section class="d-flex flex-column justify-content-center align-items-center">
        <div style="width: 1366px;" class="d-flex flex-column justify-content-center align-items-center">

            <!-- 제목 + 버튼 줄 -->
            <div class="d-flex flex-row justify-content-between align-items-center" style="width: 828px; height: 100px; position: relative;">
                <div id="reportBox" class="d-flex justify-content-between align-items-center pl-3 pr-3">
                	<div class="d-flex justify-content-between align-items-center" id="reportBtn">
                		<p class="m-0 mr-2">신고하기</p><span><img src="<%=request.getContextPath()%>/images/report_icon.png"></span>
               		</div>
                	<div>
                	<p class="m-0"><img src="<%=request.getContextPath()%>/images/close_icon.png" id="reportBoxClosBtn"></p>
                	</div>
                </div>
                <div class="d-flex flex-row justify-content-center align-items-center" style="width: 480px;">
                    <!--글쓴이 프사 넣기-->
					<%if(dh.getUserNo()!=loginUser.getNo()){ %>
	                    <%if(dhWriterimg.equals("")){ %>
	                    <img src="<%=request.getContextPath()%>/images/profile_icon.png" alt="" style="width: 50px; height: 50px;" class="profileImg">
	                    <%} else{%>
	                        <!-- 얘 수정 --> 
	              	 	<img src="<%=request.getContextPath()%>/views/picture/profile/<%=dhWriterimg%>" alt="" style="width: 50px; height: 50px;" class="profileImg">
	                    <%} %>
					<%}else{ %>
						<img src="<%=request.getContextPath()%>/views/picture/profile/<%=uProfile.getImage()%>" alt="프로필사진" style="width: 70px; height: 70px;" class="m-0 profileImg">
					<%}%>
                    <div class="d-flex flex-column pl-1" style="width: 380px;">
                        <div class="d-flex flex-row align-items-center">
                            <% if(dh.getEnded().equals("N")){%>
                            	<div class="recruitBox d-inline-block mr-1" style="line-height:14px;">
                            		모집중
                            	</div>
                            <%}else{%>
                            	<div class="recruitEndBox d-inline-block mr-1" style="line-height:14px;">
                            		모집종료
                           		</div>
                            <%}%>
                            <p class="m-0" style="font-size:18px;"><%=dh.getTitle()%></p>

                        </div>
                        <p class="m-0"><%=dh.getNickName()%></p>
                    </div>
					<%if(dh.getUserNo()!=loginUser.getNo()){ %>
                    <img src="<%=request.getContextPath()%>/images/menu-vertical_icon.png" alt="메뉴" id="verticalMenuBtn" style="width: 20px; height: 20px;">
                    <%} else{ %>
                    <img src="" alt="메뉴" style="width: 20px; height: 20px; visibility: hidden;">
                    <%} %>
                </div>
                <div>
            	    <%if(dh.getTripNo() > 0) {%>
                    <button id="danimLinkBtn" type="button" class="ldBtn" onclick="location.replace('<%=request.getContextPath()%>/trip/tripView.do?no=<%=dh.getTripNo()%>')">
                    	여행일정 보기 <strong class="ml-1">&#9002;</strong>
                    </button>
                    <%}else {%>
                    <button id="danimLinkBtn" type="button" class="ldBtnInactive" onclick="alert('연결된 여행일정이 없습니다.');">
                    	여행일정 보기 <strong class="ml-1">&#9002;</strong>
                    </button>                    	
                    <%}%>


					<!-- 로그인 유저가 동행작성자일 때 -->
					
                <%if( dh.getRecruitPeopleNo() <= dh.getJoinPeopleNo() ) {%>
                		<button type="button" class="ldBtnInactive ml-2" disabled>
			            	동행 모집마감
			            </button>
			    <%} else{ %>
                    <%if( loginUser.getNo()==dh.getUserNo() ) {%>
                    <button type="button" class="ldBtn ml-2"
						onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangUpdate.do?userNo=<%=loginUser.getNo()%>&no=<%=dh.getNo()%>')">
                    	수정
                    </button>  
					<button type="button" class="ldBtnDelet ml-2" 
						onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangDelete.do?no=<%=dh.getNo()%>&fileName=<%=dh.getImage()%>')">
                    	삭제
                    </button>                    
                    <%} else if( dji==null || (loginUser.getNo()!=dji.getUserNo())  ){ %>                    
	                    <button type="button" class="ldBtn ml-2" data-toggle="modal" data-target="#myModal">
	                    	참여하기
	                    </button>
                 	<%} else if( dji!=null && (loginUser.getNo() == dji.getUserNo()) ) {%>
                 	
                    	<!-- 수락대기중과 거절됨 분기 -->
		                    <%	if(dji.getConfirmed().equals("J")) {%>
		                 	    <button type="button" class="ldBtnInactive ml-2" disabled>
			                    	수락대기중
			                    </button>
			                <%} else if(dji.getConfirmed().equals("N")) {%>
			                	<button type="button" class="ldBtnInactive ml-2" disabled>
			                    	참여거절됨
			                    </button>
			                <%} else if(dji.getConfirmed().equals("Y")) {%>
			                	<button type="button" class="ldBtnInactive ml-2" disabled>
			                    	참여중인 동행
			                    </button>
			                <%}%>
			                
                    <%} else if(dh.getEnded().equals("Y")) {%>
                   		<button type="button" class="ldBtnInactive ml-2" disabled>
	                    	동행마감
	                    </button>
					<%} %>
				<%} %>
                </div>
            </div>

            <!-- 이미지 + 정보 줄 -->
            <div class="d-flex justify-content-center align-items-center" style="width: 1000px; height: 350px;">
                <div style="width: 480px; height: 270px; position: relative;" class="border d-flex justify-content-center align-items-center mr-5">
                <%if(dh.getImage().equals("null")){ %>
                	<img style="width: 100%; height: 100%;" src="<%=request.getContextPath()%>/images/defaultImage.jpg">
                <%}else{%>
                    <img style="width: 100%; height: 100%;" src="<%=request.getContextPath()%>/upload/donghang/<%=dh.getImage()%>">
                <%}%>    
                </div>


                <table class="p-0" style="width: 300px; height: 250px;">
                        <tr>
                            <td class="p-0">
                                <div class="d-flex flex-row justify-content-between align-items-center">
	                            <% if(dh.getEnded().equals("N")){%>
                                    <div class="recruitBox" style="line-height:14px;">
                                    	모집중
                                    </div>
	                            <%}else{%>
	                            	<div class="recruitEndBox" style="line-height:14px;">
	                            		모집종료
	                            	</div>
	                            <%}%>                           
                                    <p class="m-0">~ <%=dh.getRecruitEndDate()%></p>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td class="p-0">여행지역</td>
                        </tr>
                        <tr>
                            <td class="p-0 border-bottom">
                                <span class="pl-3"></span><%=dh.getTravleLocale()%>
                            </td>
                        </tr>

                        <tr>
                            <td class="p-0 pt-2">모집인원</td>
                        </tr>
                        <td class="p-0 border-bottom">
                            <span class="pl-3"></span><strong><%=dh.getJoinPeopleNo()%></strong> / <%=dh.getRecruitPeopleNo()%>
                        </td>
                        </tr>
                        <tr>
                            <td class="p-0 pt-2">여행일</td>
                        </tr>
                        <tr>
                            <td class="p-0 border-bottom">
                                <span class="pl-3"></span> <%=dh.getTravleStartDate()%> ~ <%=dh.getTravleEndDate()%>
                            </td>
                        </tr>
                </table>
            </div>

            <div class="d-flex flex-column align-items-center" style="width: 828px;">
                <div class="d-flex justify-content-between align-items-center" style="width: 95%;">
                    <p class="m-0">현재 참여 동행인</p>
                    <img src="<%=request.getContextPath()%>/images/expand-arrow.png" style="width:17px;" id="joinMemberBtn"
                    type="button" data-toggle="collapse" data-target="#detailText" aria-expanded="true" aria-controls="detailText">
                </div>
                <hr class="mt-2 mb-1" style="width: 828px; border-bottom: 2px solid #dadada;">
                <div class="row collapse multi-collapse " id="detailText" style="width: 95%;">                            
                    <div class="d-flex flex-wrap justify-content-between">
                    <%if(joinList.size() == 0) {%>
                    	<div>참여중인 동행인이 없습니다.</div>
                    <%} else{
                    	  for(UserProfile up : joinList){
                    %>             
                        <div class="d-flex justify-content-center align-items-center m-2">
                            <img src="<%=request.getContextPath()%>/views/picture/profile/<%=up.getImage()%>" alt="프로필사진" style="width: 40px; height: 40px;" class="profileImg">
                            <p class="m-0 ml-2"><%=up.getNickName()%></p>
                        </div>
                    <%}} %>  
                    </div>            
                </div>               
            </div>


            <div>
                <div class="d-flex flex-column justify-content-end align-items-center" style="height: 320px; border: 1px solid white;">
                    <fieldset class="form-group">
                        <legend for="email-label" class="bg-white p-0 m-0 text-center" style="width: 20%;">상세내용</legend>
                        <div class="p-4" style="width: 828px; height: 240px; border-radius: 5px; border:2px solid #dadada;">
                        	<%=dh.getContent()%>
                        </div>
                    </fieldset>
                </div> 
            </div>            
        </div>



    <!------------------------------------------------------------------------------------------------------------------------------>
    <!-- 참여신청 모달 -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header d-flex justify-content-center border-bottom-0 mt-3">
                    <div class="d-flex justify-content-between align-items-center" style="width: 650px;">                        
                        <div class="d-flex flex-row justify-content-start align-items-center"> 
                                                   
                            <% if(dh.getEnded().equals("N")){%>
                            	<div class="recruitBox d-inline-block mr-1" style="line-height:14px;">
                            		모집중
                            	</div>
                            <%}else{%>
                            	<div class="recruitEndBox d-inline-block mr-1" style="line-height:14px;">
                            		모집종료
                           		</div>
                            <%}%>
                            <h5 class="m-0"><%=dh.getTitle()%></h5>
                            <p class="m-0 ml-4">~ <%=dh.getRecruitEndDate()%></p>
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
                                    <img src="<%=request.getContextPath()%>/views/picture/profile/<%=uProfile.getImage()%>" alt="프로필사진" style="width: 70px; height: 70px;" class="m-0 profileImg">
                                </div>
                                <p class="m-0"><%=loginUser.getUserId()%></p>
                                <p class="m-0"><%=loginUser.getNickName()%></p>
                            </div>

                            <table style="width: 420px;">
                                <tr>
                                    <td class="p-0 pr-2">이름</td>
                                    <td class="p-0 pl-2">성별</td>
                                </tr>
                                <tr>
                                    <td class="p-0 pr-2"><%=loginUser.getName()%><hr class="m-0"></td>
                                    <td class="p-0 pl-2"><%=loginUser.getGender()%><hr class="m-0"></td>
                                </tr>
                                <tr>
                                    <td class="p-0 pr-2 pt-4">생년월일</td>
                                    <td class="p-0 pl-2 pt-4">휴대전화 번호</td>
                                </tr>
                                <tr>
                                    <td class="p-0 pr-2"><%=loginUser.getBirthday()%><hr class="m-0"></td>
                                    <td class="p-0 pl-2"><%=loginUser.getPhone()%><hr class="m-0"></td>
                                </tr>
                            </table>
                        </div>

                        <div class="d-flex flex-column justify-content-end align-items-center" style="border: 1px solid white;">
                            <fieldset class="form-group m-0">
                                <legend for="email-label" class="bg-white p-0 m-0 w-25 text-center">자기소개</legend>
                                <textarea class="form-control p-2" cols="87" rows="4" name="donghangJoinContent" id="donghangJoinContent"></textarea>
                            </fieldset>
                        </div> 
                    </div>
                </div>
                <div class="modal-footer d-flex justify-content-center border-top-0">
                    <button id="donghangJoinSubmitBtn" type="button" class="ldBtn mb-3" data-dismiss="modal" onclick="fn_DonghangJoin();">
                    	참여신청
                    </button>
                </div>
            </div>
        </div>
    </div>




	<!--  참여확인 안내 모달  ------------------------------------------------------------------------->
    <div class="modal" id="donghangJoinResultModal">
        <div class="modal-dialog">
        <div class="modal-content">
        
            <!-- Modal Header -->
            <div class="modal-header border-bottom-0">
            <!-- <h4 class="modal-title">Modal Heading</h4> -->
            <button type="button" class="close modal-close" data-dismiss="modal">&times;</button>
            </div>
            
            <!-- Modal body -->
            <div class="modal-body" id="donghangJoinResult">
            </div>
            
            <!-- Modal footer -->
            <div class="modal-footer border-top-0">
            <button id="pageReload" type="button" class="ldBtn modal-close" data-dismiss="modal">Close</button>
            </div>
            
        </div>
        </div>
    </div>


	<!---------------------------------------------------------------------------------------------------- 신고모달 ------------>
	<div class="modal" id="reportModal">
	    <div class="modal-dialog">
	      <div class="modal-content">
	   
	        <div class="modal-header">
	            <h4 id="report-title">사용자 신고</h4>
	            <button type="button" class="close" data-dismiss="modal">&times;</button>
	          </div>
	   <!-- Modal body -->
	    <div class="modal-body">
	    <br>
	    <div class="report-box">
	        <h3>어떤문제가 있나요?</h3>
	        <br>
	        <form action="<%=request.getContextPath()%>/donghang/userReport.do" method="post">
	        <input type="hidden" name="userNo" value="<%=dh.getUserNo()%>">
	        <input type="hidden" name="donghangNo" value="<%=dh.getNo()%>">
	        <input type="hidden" name="loginUserNo" value="<%=loginUser.getNo()%>">
	        <input type="radio" name="report" id="report3" value="폭력적위협" checked>폭력적 위협<br>
	        <input type="radio" name="report" id="report4" value="스팸및사기" checked>스팸 및 사기<br>
	        <input type="radio" name="report" id="report5" value="사생활침해" checked>사생활 침해<br>
	        <input type="radio" name="report" id="report6" value="기타" checked>기타:
	        <input type="text" placeholder="내용을 입력해주세요" name="reportText" id="report7"><br><br>
	       
	        <div class="modal-footer">
	            <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
	            <input type="submit" class="btn btn-primary" id="reportSubmit" value="신고">
	        </div>
	        
	        </form>
	        </div>
	        </div>
	        </div>
	
	    </div>
	</div>
	<!----------------------------------------------------------------------------- ----------------------------------->

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
            width: 45px;
            height: 17px;
            border-radius: 15px;
            text-align: center;
            background-color: #00abbf;
            color: white;
            font-size: 10px;
            font-weight: 600;
            padding: 2px 4px 2px 4px;
            display: table-cell;
            vertical-align: middle;
        }
        .recruitEndBox{
            width: 45px;
            height: 17px;
            border-radius: 15px;
            text-align: center;
            background-color: #dadada;
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
		#reportBox{
			position: absolute;
			width:200px; 
			height: 45px;
			border: 1px solid #dadada;
			background-color: white;
			top: 65px;
			right:295px;
			box-shadow: 0 0 3px #dadada;
		}
		#reportBox img{
			width: 25px;
			height: 25px;
		}
		#reportBoxClosBtn{
			cursor: pointer;
		}
		#reportBtn *{
			cursor: pointer;		
		}
		.profileImg{
			border-radius: 35px;
		}
    </style> 

    <!-- 스크립트 -->
    <script>
        var angle = 0; 
        $("#joinMemberBtn").click(()=>{
            let has = $("#joinMemberBtn").hasClass('rotateBtn');
            if(!has){
                $("#joinMemberBtn").addClass('rotateBtn');
            }else{
                $("#joinMemberBtn").removeClass('rotateBtn');
            }
        });
        
        
        //Ajax 참여신청 모달
        function fn_DonghangJoin(){
         	$.ajax({
        		url : "<%=request.getContextPath()%>/donghang/donghangJoin.do",
        		type : "get",
        		dataType : "html",
        		data : {userNo: <%=loginUser.getNo()%>,
	        			donghangNo: <%=dh.getNo()%>,
	        			content: $("#donghangJoinContent").val()},
        		success : data=>{
        			$("#donghangJoinResult").html(data);
        		}
        	})    	
        }
        
         $("#donghangJoinSubmitBtn").click(()=>{
        	setTimeout(()=>{
                $("#donghangJoinResultModal").modal("show");
        	}, 600)
        });

         $('#pageReload').click(function() {
        	    location.reload();
        });        
         
        //신고
       	$("#reportBox").attr("style","visibility: hidden;");	
        
        $("#verticalMenuBtn").click(()=>{
        	$("#reportBox").attr("style","visibility: visibility;");
        });
        $("#reportBoxClosBtn").click(()=>{
        	$("#reportBox").attr("style","visibility: hidden;");
        });
        $("#reportBtn").click(()=>{
        	$("#reportModal").modal("show");
        });
        
    </script>
    
    
    </section>
</div><!-- 	<div class="body-wrapper">닫기 -->    
<%@ include file="/views/common/footer.jsp"%> 