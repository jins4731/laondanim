<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.laon.donghang.model.vo.DonghangJoinUserPicture"%>
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
	String loginUserImg = (String)request.getAttribute(UserKey.IMAGE);
%>

    <section class="d-flex flex-column justify-content-center align-items-center">
        <div style="width: 1366px;" class="d-flex flex-column justify-content-center align-items-center">

            <!-- 제목 + 버튼 줄 -->
            <div class="d-flex flex-row justify-content-between align-items-center" style="width: 828px; height: 100px;">
                <div class="d-flex flex-row justify-content-center align-items-center" style="width: 480px;">
                    <!--글쓴이 프사 넣기-->
                    <img src="<%=userImage%>" alt="" style="width: 50px; height: 50px;">

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
                            <p class="m-0"><%=dh.getTitle()%></p>

                        </div>
                        <p class="m-0"><%=dh.getNickName()%></p>
                    </div>

                    <img src="icon/menu-vertical_icon.png" alt="메뉴" style="width: 20px; height: 20px;">
                </div>
                <div>
            	    <%if(dh.getTripNo() < 0) {%>
                    <button id="danimLinkBtn" type="button" class="ldBtn">
                    	다님일정 보기 <strong class="ml-1">&#9002;</strong>
                    </button>
                    <%}else {%>
                    <button id="danimLinkBtn" type="button" class="ldBtnInactive" onclick="alert('연결된 다님일정이 없습니다.');">
                    	다님일정 보기 <strong class="ml-1">&#9002;</strong>
                    </button>                    	
                    <%}%>
                    <%if(loginUser.getNo()!=dh.getUserNo()){ %>
                    <button type="button" class="ldBtn ml-2" data-toggle="modal" data-target="#myModal">
                    	참여하기
                    </button>
                    <%}else {%>
                    <button type="button" class="ldBtn ml-2"
						onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangUpdate.do?userNo=<%=loginUser.getNo()%>&no=<%=dh.getNo()%>')">
                    	수정
                    </button>  
					<button type="button" class="ldBtnDelet ml-2" 
						onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangDelete.do?no=<%=dh.getNo()%>&fileName=<%=dh.getImage()%>')">
                    	삭제
                    </button>                    
                    <%}%>
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
                    <img src="icon/expand-arrow.png" style="width:17px;" id="joinMemberBtn"
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
                            <img src="<%=up.getImage()%>" alt="프로필사진" style="width: 40px; height: 40px;">
                            <p class="m-0"><%=up.getNickName()%></p>
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
	<form name="donghangJoinForm" id="donghangJoinForm" method="post">
		
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
                                    <img src="<%=loginUserImg%>" alt="프로필사진" style="width: 70px; height: 70px;" class="m-0">
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
                                <textarea class="form-control p-2" cols="87" rows="4" name="donghangJoinContent"></textarea>
                            </fieldset>
                        </div> 
                    </div>
                </div>
                <div class="modal-footer d-flex justify-content-center border-top-0">
                    <button id="donghangJoinSubmitBtn" type="button" class="ldBtn mb-3" data-dismiss="modal" onclick="fn_donghangJoin();">
                    	참여신청
                    </button>
                </div>
            </div>
        </div>
    </div>
    
    </form>



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
            <button type="button" class="btn btn-danger modal-close" data-dismiss="modal">Close</button>
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
        function fn_donghangJoin(){
        	let formData = $("#donghangJoinForm");	
        	  var formData = $("#form1").serialize();

              $.ajax({
                  cache : false,
                  url : "<%=request.getContextPath()%>/donghang/donghangJoin.do?userNo=<%=loginUser.getNo()%>&no=<%=dh.getNo()%>",
                  type : 'POST', 
                  data : formData, 
                  success : function(data) {
                      var jsonObj = JSON.parse(data);
                      alert("성공");
                  }, // success 
          
                  error : function(xhr, status) {
                      alert(xhr + " : " + status);
                  }
              }); // $.ajax */
        }
        
        $("#donghangJoinSubmitBtn").click(()=>{
        	
        	setTimeout(()=>{
                $("#donghangJoinResultModal").modal("show");
        	}, 1000)

        });

        
    </script>
    
    
    </section>
</div><!-- 	<div class="body-wrapper">닫기 -->    
<%@ include file="/views/common/footer.jsp"%> 