<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.laon.common.CommonKey" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="com.laon.donghang.model.vo.Donghang" %>
<%@page import="com.laon.donghang.model.vo.DonghangJoinDonghangJoinTb" %>
<%@page import="com.laon.user.model.vo.UserProfile" %>

<%@ include file="/views/common/header.jsp"%>

<%
/* request.setAttribute(CommonKey.DONGHANG_JOIN_LIST, joinList);
request.setAttribute(CommonKey.PAGE_BAR, pageBar);
request.setAttribute(CommonKey.USER_LIST, userList);
request.setAttribute(CommonKey.TOTAL_ROWCOUNT, totalRowCount); */

	List<DonghangJoinDonghangJoinTb> joinList = (List<DonghangJoinDonghangJoinTb>)request.getAttribute(CommonKey.DONGHANG_JOIN_LIST);
	String pageBar = (String)request.getAttribute(CommonKey.PAGE_BAR);
	int totalRowCount = (int)request.getAttribute(CommonKey.TOTAL_ROWCOUNT);
	
	List<UserProfile> userList = (List<UserProfile>)request.getAttribute(CommonKey.USER_LIST);
	int no = (int)request.getAttribute("no");
%>

   	<div style="height: 170px;"></div>
    
<section class="d-flex flex-row justify-content-center">
        <div style="width: 1366px;" class="pt-5 pb-5 d-flex flex-column align-items-center justify-content-center">
            <div class="p-5 laonTitleFont">
                	동행 신청 수신함
            </div>

            <!-- 총 컨텐츠 수 & 필터 -->
            <div class="d-flex justify-content-between align-items-center pl-2 pr-2 mt-3 mb-5" style="width: 1140px;">
                <p class="mb-0" style="margin-left: 15px;">총 <%=totalRowCount%>건의 참여신청이 있습니다.</p>
                <div class="dropdown" style="margin-right: 15px;">
                    <button class="joinFilterBtn  dropdown-toggle" type="button" id="joinFilterBtn" 
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      	전체
                    </button>
                    <input type="hidden" id="confirmedFilter" name="confirmedFilter" value="ALL"/>
                    <div class="dropdown-menu text-center" aria-labelledby="filter" style="width: 140px;">
                      <a id="ALL" class="dropdown-item" onclick="fn_joinFilterBtn_change(this);">전체</a>
                      <a id="J" class="dropdown-item" onclick="fn_joinFilterBtn_change(this);" >대기 중</a>
                      <a id="Y" class="dropdown-item" onclick="fn_joinFilterBtn_change(this);">수락</a>
                    </div>
                </div>
            </div>

<%--             <!------ 삭제메뉴 ------>
            <div class="d-flex justify-content-end mt-3 mb-5"  style="width: 1140px;">
                <button type="button" id="deleteBtn" style="margin-right: 15px; height: 30px;">
                    	선택삭제
                </button>
                <div id="hiddenDeleteBtns" style="height: 30px;">
                    <button type="button" style="margin-right: 15px;" onclick="fn_checkAll();">
                        	전체선택
                    </button>
                    <button type="button" style="margin-right: 15px;" onclick="fn_checkFalseAll();">
                        	선택해제
                    </button>
                    <button type="button" style="margin-right: 15px;">
                        	삭제 <span><img src="<%=request.getContextPath()%>/images/trash_icon.png"></span>
                    </button>
                    <button type="button" style="margin-right: 15px;" onclick="fn_deleteBtnsClose();">
                        <img src="icon/deleteBack_icon.png">
                    </button>
                </div>
            </div> --%>




            <!-- 신청 목록가져오기 -->
            <div class="d-flex flex-wrap justify-content-start mt-3" style="width: 1140px;"> <!-- 목록상자 -->
	
				<%for(DonghangJoinDonghangJoinTb j : joinList){ 
					String id="";
					String nick="";
					String uImg="";
					for(UserProfile u : userList){
						if(u.getNo()==j.getUserNo()) id = u.getUserId();
						if(u.getNo()==j.getUserNo()) nick = u.getNickName();
						if(u.getNo()==j.getUserNo()) uImg = u.getImage();
					}	
				%>					
                <!----------------------------------------------------------------------------------------> 
                <div class="d-flex flex-column" style="height: 200px;">                               
                <input type="checkbox" name="joinListCB" value="1" id="ch1" class="mb-2 ml-3"/>
                <!-- ↑인풋 / ↓라벨 -->
                <label for="ch1"> 
                    <div class="joinListCard d-flex flex-column justify-content-between" onclick="fn_joinItemModal_open(this);" id="1">
                        <div class="d-flex justify-content-between align-items-center" style="height: 25px;">
                            <div class="d-flex align-items-center">
                            
                            <%if(j.getConfirmed().equals("J")){ %>
                                <div class="confirmedJbox mr-1 ml-1" style="line-height:14px;">
                                    	대기중
                                </div>
                            <%} else if(j.getConfirmed().equals("Y")){%>
                                <div class="confirmedYbox mr-1 ml-1" style="line-height:14px;">
                                    	수락함
                                </div>                            
                            <%} %>     
                                                          
                            </div>

<%-- 개별삭제 기능 생략됨             <div class="dropdown">
                                <button class="dropdown-toggle verticalDot pl-3 pr-1" type="button" id="soloDelete" 
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <img src="<%=request.getContextPath()%>/images/menu-vertical_icon.png" alt="">
                                </button>
                                <div class="dropdown-menu text-center" aria-labelledby="soloDelete" style="width: 140px;">
                                    <a class="dropdown-item" onclick="fn_joinItem_soloDelete(<%=j.getNo()%>,<%=j.getDhNo()%>);">
                                        <span class="d-flex justify-content-center align-items-center">
                                            <span>삭제하기</span><img src="<%=request.getContextPath()%>/images/trash_icon.png" style="width: 20px; height: 20px;" class="ml-3">
                                        </span>
                                    </a>
                                </div>
                            </div>  --%>                              
                        </div>
                        <div class="align-self-center titleBox">
                            	<%=j.getContent()%>
                        </div>
                        <div class="d-flex">
                            <img src="<%=request.getContextPath()%>/views/picture/profile/<%=uImg%>" style="width:45px; height: 45px;" class="mr-2">
                            <div>
                                <p class="pId m-0"><%=id%></p>
                                <p class="pNick m-0"><%=nick%></p>                                
                            </div>
                        </div>
                    </div>
                </label>
                </div>
                <!---------------------------------------------------------------------------------------->
				<%} %>
            </div> <!-- 목록상자 끝 -->

			<%if(totalRowCount>8){ %>
			<div class="d-flex justify-content-center align-items-center m-3" style="height: 80px;">
				<%=pageBar%>
			</div>
			<%} %>

        </div>
    </section>


    <!---------------------------------------------------------------------------------------------------- 참여신청 모달 ----------->
	<%for(DonghangJoinDonghangJoinTb j : joinList){ 
		String id="";
		String nick="";
		String uImg="";
		Date bDay = null;
		String gender="";
		String phone = "";
		String name = "";		
		for(UserProfile u : userList){					
			if(u.getNo()==j.getUserNo()) id = u.getUserId();
			if(u.getNo()==j.getUserNo()) nick = u.getNickName();
			if(u.getNo()==j.getUserNo()) uImg = u.getImage();
			if(u.getNo()==j.getUserNo()) bDay = u.getBirthday();
			if(u.getNo()==j.getUserNo()) gender = u.getGender();
			if(u.getNo()==j.getUserNo()) name = u.getName();
			if(u.getNo()==j.getUserNo()) phone = u.getPhone();
		}
	%>
    <div class="modal fade" id="joinItemModal" tabindex="-1" role="dialog" aria-labelledby="joinItemModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header d-flex justify-content-center border-bottom-0 mt-3">
                    <div class="d-flex justify-content-between align-items-center" style="width: 650px;">                        
                        <div class="d-flex flex-row justify-content-start align-items-center"> 
                            <%if(j.getConfirmed().equals("J")){ %>
                                <div class="confirmedJbox mr-1 ml-1" style="line-height:14px;">
                                    	대기중
                                </div>
                            <%} else if(j.getConfirmed().equals("Y")){%>
                                <div class="confirmedYbox mr-1 ml-1" style="line-height:14px;">
                                    	수락함
                                </div>                            
                            <%} else if(j.getConfirmed().equals("N")){%>     
                                <div class="confirmedNbox mr-1 ml-1" style="line-height:14px;">
                                    	거절함
                                </div>                                                        
                            <%}%>                                                    

                            <h5 class="titleBox m-0"><%=j.getTitle()%></h5>
                            <p class="m-0 ml-4">~ <%=j.getRecruitEndDate()%></p>
                        </div>
                        
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" style="font-size: 30px;">&times;</span>
                        </button>
                    </div>
                    
                </div>
                <div class="modal-body">
                    <div class="d-flex flex-column justify-content-center align-items-center"">

                        <div class="d-flex justify-content-between align-items-center mb-4" style="width: 650px; height: 160px;">
                            <div class="d-flex flex-column mr-4 ml-5">
                                <div class="d-flex justify-content-center align-items-center">
                                    <img src="<%=request.getContextPath()%>/views/picture/profile/<%=uImg%>" alt="프로필사진" style="width: 70px; height: 70px;" class="m-0">
                                </div>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="d-flex flex-column">
		                                <p class="pId m-0"><%=id%></p>
		                                <p class="pNick m-0"><%=nick%></p>                                         
                                    </div>
                                    <div class="dropdown">
                                        <button class="dropdown-toggle verticalDot pl-3 pr-1" type="button" id="reportUser" 
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <img src="icon/menu-vertical_icon.png" alt="">
                                        </button>
                                        <div class="dropdown-menu text-center" aria-labelledby="reportUser" style="width: 140px;">
                                            <a class="dropdown-item" onclick="fn_reportUser(this);">
                                                <span class="d-flex justify-content-center align-items-center">
                                                    <span>신고하기</span> <img src="<%=request.getContextPath()%>/images/report_icon.png" style="width: 20px; height: 20px;" class="ml-3 mb-1">
                                                </span>
                                            </a>
                                        </div>
                                    </div>  
                                </div>
                            </div>

                            <table style="width: 420px;">
                                <tr>
                                    <td class="p-0 pr-2">이름</td>
                                    <td class="p-0 pl-2">성별</td>
                                </tr>
                                <tr>
                                    <td class="p-0 pr-2"><%=name%><hr class="m-0"></td>
                                    <td class="p-0 pl-2"><%=gender%><hr class="m-0"></td>
                                </tr>
                                <tr>
                                    <td class="p-0 pr-2 pt-4">생년월일</td>
                                    <td class="p-0 pl-2 pt-4">휴대전화 번호</td>
                                </tr>
                                <tr>
                                    <td class="p-0 pr-2"><%=bDay%><hr class="m-0"></td>
                                    <td class="p-0 pl-2"><%=phone%><hr class="m-0"></td>
                                </tr>
                            </table>
                        </div>

                        <div class="d-flex flex-column justify-content-end align-items-center" style="border: 1px solid white;">
                            <fieldset class="form-group m-0">
                                <legend for="email-label" class="bg-white p-0 m-0 w-25 text-center">자기소개</legend>
                                <textarea class="form-control p-2 pt-3 pb-3" cols="87" rows="4" disabled><%=j.getContent()%></textarea>                                
                            </fieldset>
                        </div> 
                    </div>
                </div>
                <%if(j.getConfirmed().equals("J")){ %>
                <div class="modal-footer d-flex justify-content-center border-top-0">
                    <input type="hidden" name="confirmedValue" id="confirmedValue">
                    <input type="hidden" name="joinTbNo" id="joinTbNo" value="<%=j.getNo()%>">
                    <button id="rejectBtn" type="button" class="ldBtnDelet mb-3 mr-3" data-dismiss="modal">거절</button>
                    <button id="acceptBtn" type="button" class="ldBtn mb-3 ml-3" data-dismiss="modal">수락</button>
                </div>
                <%} else if(j.getConfirmed().equals("Y")){ %>
                <div class="modal-footer d-flex justify-content-center border-top-0">
                    <button type="button" class="ldBtn mb-3 ml-3" data-dismiss="modal">닫기</button>
                </div>
                <%} %>
            </div>
        </div>
    </div>
    <%} %>
    <!---------------------------------------------------------------------------------------------------- 참여신청 모달 ----------->


    <!------------------------------------------------------------------------------------------------ 수락/거절 안내 모달 ----------->
    <div class="modal" id="confirmedResultModal">
        <div class="modal-dialog">
        <div class="modal-content">
        
            <!-- Modal Header -->
            <div class="modal-header border-bottom-0">
            <!-- <h4 class="modal-title">Modal Heading</h4> -->
            <button type="button" class="close modal-close" data-dismiss="modal">&times;</button>
            </div>
            
            <!-- Modal body -->
            <div class="modal-body" id="confirmedResult">
            </div>
            
            <!-- Modal footer -->
            <div class="modal-footer border-top-0">
            <button type="button" class="ldBtnSubmit modal-close" data-dismiss="modal" id="reloadBtn">Close</button>
            </div>
            
        </div>
        </div>
    </div>
    <!---------------------------------------------------------------------------------------------- 수락/거절 안내 모달 끝 --------->    



    <!-----------------------------------------------------------------------------------------   스타일 시작   ---->
    <style>
	/* 카테고리 제목 폰트 */
	@font-face { font-family: 'Cafe24Danjunghae'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Danjunghae.woff') format('woff'); font-weight: normal; font-style: normal; }
	/* 본문 폰트 */
	@font-face { font-family: 'S-CoreDream-4Regular'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-4Regular.woff') format('woff'); font-weight: normal; font-style: normal; }
		.laonTitleFont{
			font-family: Cafe24Danjunghae;
			font-size: 35px;
			color: #595959;
		}    
        .confirmedJbox{
            width: 45px;
            height: 17px;
            border-radius: 15px;
            text-align: center;
            background-color: #d60047;
            color: white;
            font-size: 10px;
            font-weight: 600;
            padding: 2px 4px 2px 4px;
            display: table-cell;
            vertical-align: middle;
        }
        .confirmedYbox{
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
        .confirmedNbox{
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
        .joinListCard{
            width: 280px;
            height: 170px;
            border: 2px solid #dadada;
            border-radius: 5px;
            padding: 10px 5px 10px 5px;
            margin-left: 2.5px;
            margin-right: 2.5px;
        }
        .pId{
            font-size: 14px;
            font-weight: 600;
            color: #595959;
        }
        .pNick{
            font-size: 14px;
            color: #595959;
        }
        .titleBox{
            width: 240px;
            overflow:hidden; 
            text-overflow:ellipsis; 
            white-space:nowrap;
            font-weight: 600;
            color: #595959;
        }
        #deleteBtn{
            border: none;
            background: none;
        }
        #hiddenDeleteBtns > button{
            border: none;
            background: none;
        }
        input[type=checkbox] + label { 
            display: inline-block; 
            cursor: pointer; 
            margin: 0;                
        }
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
        fieldset legend{
            font-size: 16px;
        }
        textarea{ 
            /* width:500px;  
            height:100px;       */
            resize:none;
            background-color: white;
        }  
        .form-control:disabled{
            background-color: white;
        }
        .ldBtn{
            border-radius: 20px;
            background-color: white;
            border: 2px solid #00abbf;
            color: #00abbf;
            padding: 6px 35px 6px 35px;
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
            padding: 6px 35px 6px 35px;
        }   
        .ldBtnInactive:hover,.ldBtnInactive:active {
            color: white;
            background-color: #dadada;
        }                 
		.ldBtnDelet{		
            border-radius: 20px;
            background-color: white;
            border: 2px solid #d60047;
            color: #d60047;
            padding: 6px 35px 6px 35px;
		}
		.ldBtnDelet:hover,.ldBtnDelet:active{	
            color: white;
            background-color: #d60047;
        }        
        .dropdown-menu{
            min-width: 0px;
        }
        .joinFilterBtn{
            width: 140px;
            height: 37px;
            border: 2px solid #dadada;
            border-radius: 20px;
            background-color: white;
        }
        .dropdown-item{
            cursor: pointer;
        }
        .verticalDot{
            border: none;
            background:none;
            height: 19px;
            padding: 0px;
            display: flex;
            justify-content: center;
            align-items: center;
            z-index: 10;
        }
        .verticalDot > img{
            height: 19px;
            width: 19px;
        }
        .joinListCard .dropdown-toggle::after,
        .modal-body .dropdown-toggle::after {
            display:none;
        }
        .joinListCard .dropdown-menu,
        .modal-body .dropdown-menu {
            padding: 2px;
        }
    </style>
    <!-----------------------------------------------------------------------------------------   스타일 끝   ------>

    <!-----------------------------------------------------------------------------------------   스크립트 시작   -->
    <script>
        // 체크박스 비활성화
        $("input[type=checkbox]").prop("disabled", true);
        $("input[type=checkbox]").attr("style", "display:none");
        // 삭제 메뉴 숨기기
        $("#hiddenDeleteBtns").hide();
        // 삭제 메뉴 활성화 + 체크박스 활성화 + 카드클릭이벤트 막기
        $("#deleteBtn").click(()=>{
            $("#deleteBtn").hide();
            $(".joinListCard").attr('onclick', '').unbind('click');
            $("input[type=checkbox]").attr("style", "display:block");
            $("input[type=checkbox]").prop("disabled", false);
            $("#hiddenDeleteBtns").show();         
        });
        // 삭제 메뉴 비활성화 + 체크박스 비활성화 fn
        function fn_deleteBtnsClose(){
            $("#hiddenDeleteBtns").hide();
            $("input[type=checkbox]").prop("checked",false);    
            $(".joinListCard").attr('onclick', 'fn_joinItemModal_open(this);').unbind('click');
            $("input[type=checkbox]").attr("style", "display:none");
            $("input[type=checkbox]").prop("disabled", true);
            $("#deleteBtn").show();
        }  
        // 체크박스 전체선택 fn      
        function fn_checkAll(){
            $("input[type=checkbox]").prop("checked",true);
        }
        // 체크박스 해제 fn
        function fn_checkFalseAll(){
            $("input[type=checkbox]").prop("checked",false);            
        }  
        // 자기소개 모달 띄우기
        function fn_joinItemModal_open(e){
            // alert($(e).attr("id"));
            $("#joinItemModal").modal("show");
        }
        //필터
        console.log($("#confirmedFilter").val());
        function fn_joinFilterBtn_change(e){
            $("#joinFilterBtn").text($(e).text());
            $("#confirmedFilter").val($(e).attr("id"));
            console.log($("#confirmedFilter").val());
            
            location.replace('<%=request.getContextPath()%>/donghang/donghangJoinlist.do?userNo=<%=loginUser.getNo()%>&no=<%=no%>&filter='+$("#confirmedFilter").val());
        }
        //두번클릭 고치기 도전
		
        //수락 Ajax
        $("#acceptBtn").click(()=>{
        	$("#confirmedValue").val("Y");
        	let confirmedValue = $("#confirmedValue").val();
        	let joinTbNo = $("#joinTbNo").val();
        	
    		let xhr = new XMLHttpRequest();
    		
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status == 200){						
						//xhr객체의 responseText에 데이터를 저장
						$("#confirmedResult").html(xhr.responseText);
					} else if(xhr.status == 404){
						alert("404 error")
					}
				}
			}
			//전송에 대한 설정 : open()함수
			
			xhr.open("get","<%=request.getContextPath()%>/donghang/confirmedAccept.do?confirmedValue="+confirmedValue+"&joinNo="+joinTbNo+"&no="+<%=no%>);
			
			//전송! : send()
			xhr.send();		
			

           setTimeout(()=>{
                $("#confirmedResultModal").modal("show");
           }, 600)
   	    
        });
        
        $("#reloadBtn").click(()=>{
        	location.reload();
        });
        
      //수락 Ajax
        $("#rejectBtn").click(()=>{
        	$("#confirmedValue").val("N");
        	let confirmedValue = $("#confirmedValue").val();
        	let joinTbNo = $("#joinTbNo").val();
        	
    		let xhr = new XMLHttpRequest();
    		
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status == 200){						
						//xhr객체의 responseText에 데이터를 저장
						$("#confirmedResult").html(xhr.responseText);
					} else if(xhr.status == 404){
						alert("404 error")
					}
				}
			}
			//전송에 대한 설정 : open()함수
			
			xhr.open("get","<%=request.getContextPath()%>/donghang/confirmedReject.do?confirmedValue="+confirmedValue+"&joinNo="+joinTbNo+"&no="+<%=no%>);
			
			//전송! : send()
			xhr.send();		
			

           setTimeout(()=>{
                $("#confirmedResultModal").modal("show");
           }, 600);
   	    
        });
        
        $("#reloadBtn").click(()=>{
        	location.reload();
        });        
        
    </script>

    <!-----------------------------------------------------------------------------------------   스크립트 끝   ---->  	
   	
<%@ include file="/views/common/footer.jsp"%> 