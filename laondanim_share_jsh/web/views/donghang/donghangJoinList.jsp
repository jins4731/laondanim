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

%>

   	<div style="height: 170px;"></div>
    
<section class="d-flex flex-row justify-content-center">
        <div style="width: 1366px;" class="border pt-5 pb-5 d-flex flex-column align-items-center justify-content-center">
            <div class="p-5">
                	동행 신청 수신함
            </div>

            <!-- 총 컨텐츠 수 & 필터 -->
            <div class="d-flex justify-content-between align-items-center pl-2 pr-2 mt-3 mb-3" style="width: 1140px;">
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
                      <a id="N" class="dropdown-item" onclick="fn_joinFilterBtn_change(this);">거절</a>
                    </div>
                </div>
            </div>

            <!------ 삭제메뉴 ------>
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
                        삭제 <span><img src="<%=request.getContextPath()%>/image/trash_icon.png"></span>
                    </button>
                    <button type="button" style="margin-right: 15px;" onclick="fn_deleteBtnsClose();">
                        <img src="icon/deleteBack_icon.png">
                    </button>
                </div>
            </div>




            <!-- 신청 목록가져오기 -->
            <div class="d-flex flex-wrap justify-content-start" style="width: 1140px;"> <!-- 목록상자 -->
	
				<%for(DonghangJoinDonghangJoinTb j : joinList){ %>
                <!----------------------------------------------------------------------------------------> 
                <div class="d-flex flex-column" style="height: 200px;">                               
                <input type="checkbox" name="joinListCB" value="1" id="ch1" class="mb-2 ml-3"/>
                <!-- ↑인풋 / ↓라벨 -->
                <label for="ch1"> 
                    <div class="joinListCard d-flex flex-column justify-content-between" onclick="fn_joinItemModal_open(this);" id="1">
                        <div class="d-flex justify-content-between align-items-center" style="height: 25px;">
                            <div class="d-flex align-items-center">
                                <div class="confirmedJbox mr-1 ml-1" style="line-height:14px;">
                                    대기중
                                </div>
                                <%-- <img src="<%=request.getContextPath()%>/image/newIcon.png"> --%>
                            </div>

                            <div class="dropdown">
                                <button class="dropdown-toggle verticalDot pl-3 pr-1" type="button" id="soloDelete" 
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <img src="<%=request.getContextPath()%>/image/menu-vertical_icon.png" alt="">
                                </button>
                                <div class="dropdown-menu text-center" aria-labelledby="soloDelete" style="width: 140px;">
                                    <a class="dropdown-item" onclick="fn_joinItem_soloDelete(this);">
                                        <span class="d-flex justify-content-center align-items-center">
                                            <span>삭제하기</span> <img src="icon/trash_icon.png" style="width: 20px; height: 20px;" class="ml-3">
                                        </span>
                                    </a>
                                </div>
                            </div>                               
                        </div>
                        <div class="align-self-center titleBox">
                            	제목safkjklasjfkljalkjf;ajdlkfj와우뭐가이렇게길어나화장실다녀와서
                        </div>
                        <div class="d-flex">
                            <img src="<%=request.getContextPath()%>/image/profile_icon.png" style="width:45px; height: 45px;" class="mr-2">
                            <div>
                                <p class="pId m-0">아이디</p>
                                <p class="pNick m-0">닉네임</p>                                
                            </div>
                        </div>
                    </div>
                </label>
                </div>
                <!---------------------------------------------------------------------------------------->
				<%} %>
            </div> <!-- 목록상자 끝 -->


			<div class="d-flex justify-content-center align-items-center m-3" style="height: 80px;">
				<%=pageBar%>
			</div>

        </div>
    </section>


    <!---------------------------------------------------------------------------------------------------- 참여신청 모달 ----------->
    <div class="modal fade" id="joinItemModal" tabindex="-1" role="dialog" aria-labelledby="joinItemModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header d-flex justify-content-center border-bottom-0 mt-3">
                    <div class="d-flex justify-content-between align-items-center" style="width: 650px;">                        
                        <div class="d-flex flex-row justify-content-start align-items-center">                            
                            <div class="confirmedJbox mr-1 ml-1" style="line-height:14px;">
                                대기중
                            </div>
                            <h5 class="titleBox m-0">제목ddddddddddddddddddddddddddddddddddddddddddddddddd</h5>
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
                            <div class="d-flex flex-column mr-4 ml-5">
                                <div class="d-flex justify-content-center align-items-center">
                                    <img src="icon/profile_icon.png" alt="프로필사진" style="width: 70px; height: 70px;" class="m-0">
                                </div>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="d-flex flex-column">
                                        <p class="pId m-0">아이디user1</p>
                                        <p class="pNick m-0">닉네임닉닉닉</p>
                                    </div>
                                    <div class="dropdown">
                                        <button class="dropdown-toggle verticalDot pl-3 pr-1" type="button" id="reportUser" 
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <img src="icon/menu-vertical_icon.png" alt="">
                                        </button>
                                        <div class="dropdown-menu text-center" aria-labelledby="reportUser" style="width: 140px;">
                                            <a class="dropdown-item" onclick="fn_reportUser(this);">
                                                <span class="d-flex justify-content-center align-items-center">
                                                    <span>신고하기</span> <img src="<%=request.getContextPath()%>/image/report_icon.png" style="width: 20px; height: 20px;" class="ml-3 mb-1">
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
                                <textarea class="form-control p-2" cols="87" rows="4" disabled><div></div></textarea>                                
                            </fieldset>
                        </div> 
                    </div>
                </div>
                <div class="modal-footer d-flex justify-content-center border-top-0">
                    <input type="hidden" name="confirmedValue" value="J">
                    <button id="rejectBtn" type="button" class="ldBtnDelet mb-3 mr-3" data-dismiss="modal">거절</button>
                    <button id="acceptBtn" type="button" class="ldBtn mb-3 ml-3" data-dismiss="modal">수락</button>
                </div>
            </div>
        </div>
    </div>
    <!---------------------------------------------------------------------------------------------------- 참여신청 모달 ----------->



    <!-----------------------------------------------------------------------------------------   스타일 시작   ---->
    <style>
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
        }
        //두번클릭 고치기 도전

    </script>


    <!-----------------------------------------------------------------------------------------   스크립트 끝   ---->  	
   	
<%@ include file="/views/common/footer.jsp"%> 