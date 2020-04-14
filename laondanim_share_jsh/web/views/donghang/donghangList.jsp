<%@page import="com.laon.donghang.model.vo.DonghangJoinUserPicture"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.laon.common.CommonKey" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="com.laon.donghang.model.vo.Donghang" %>

<%@ include file="/views/common/header.jsp"%>

<%
	List<DonghangJoinUserPicture> list = (List)request.getAttribute(CommonKey.DONGHANG_LIST);

	int count = 0;
	List<DonghangJoinUserPicture> topList = new ArrayList();
	List<DonghangJoinUserPicture> bottomList = new ArrayList();
	
	for(DonghangJoinUserPicture dh : list){
		count++;
		if(count <= 5){
			topList.add(dh);
		}else{
			bottomList.add(dh);
		}		
	}
	
	SimpleDateFormat newFm = new SimpleDateFormat("yy-MM-dd");
	
	String keyword = (String)request.getAttribute(CommonKey.KEYWORD);
	int totalRowNum = (int)request.getAttribute(CommonKey.TOTAL_ROWCOUNT);
%>

   	<div style="height: 170px;"></div>
    <section class="d-flex flex-row justify-content-center">
        <div style="width: 1366px;" class="pt-5 pb-5">


        <!--검색창-->
        <div class="d-flex justify-content-center align-items-center">
            <div id="searchDIV" class="d-flex justify-content-center align-items-center m-5">
                <select class="form-control border-0 rounded-0" name="searchFilter" id="searchFilter">
                    <!-- <option value="">전체 검색</option> -->
                    <option value="">지역검색</option>
                    <option value="">키워드 검색</option>                    
                </select>
                <input type="text" id="keyword" name="keyword" class="pl-2" 
                <%if(!keyword.equals("null")){ %>value='<%=keyword%>'
                <%}else{%>
                	value=""
                <%}%>/>
                <button id="inputKeywordBtn">
                	<img src="<%=request.getContextPath()%>/image/inactiveSearch_icon.png" alt="searchIcon" id="searchIcon"/>
                </button>
            </div>
        </div>
        <!--검색창 스타일-->
        <style>
            #searchDIV{
                height: 45px;
                width: 450px;
                border: 3px solid #00abbf;
                background-color: #00abbf;
                border-radius: 30px;
                overflow: hidden;
            }
            #searchDIV select{
                width: 33%;
                height: 100%;
                background-color: #00abbf;
                color: white;
                padding-left: 20px;
                -webkit-appearance: none;
                background-image: url('<%=request.getContextPath()%>/image/down_icon.png');
                background-repeat: no-repeat;
                background-position: right center;
                background: ;
            }
            #searchDIV input[type="text"]{
                width: 57%;
                height: 100%;
                border: none;
            }
            #searchDIV input[type="text"]:focus{
                outline: none;
            }
            #searchDIV button{
            	width: 10%;
            	height: 100%;
            	padding: 0px;
            	margin: 0px;
            	border: none;
            	background: white;
            }
            #searchDIV button:focus{
                outline: none;
            }            
        </style>
       	<!-- 검색 아이콘 스크립트 -->
        <script>
				
			$("#keyword").focus(()=>{
				$("#searchIcon").fadeOut(200, ()=>{
					$("#searchIcon").attr('src','<%=request.getContextPath()%>/image/search_icon.png').fadeIn(300);
				})
			});
			$("#keyword").focusout(()=>{
				$("#searchIcon").fadeOut(200, ()=>{
					$("#searchIcon").attr('src','<%=request.getContextPath()%>/image/inactiveSearch_icon.png').fadeIn(300);
				})
			});
        </script>

        <!-- 작성 -->
        <div class="d-flex justify-content-center">
            <div class="d-flex justify-content-end align-items-end" style="width: 1140px;">
                <button class="btn btn-lg btn-outline-secondary d-flex align-items-end justify-content-center mt-3 mb-3" 
                        onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangWrite.do?userNo=<%=loginUser.getNo()%>')" id="dhWriteBtn">
                    <p class="m-0">동행찾기 작성</p>                    
                    <img src="<%=request.getContextPath()%>/image/write_icon.png" class="ml-2 w-25">
                </button>            
            </div>
        </div>
        <!--작성 스타일-->
        <style>
            #dhWriteBtn{
                width: 220px;
                border-radius: 0px;
                border-top: none;
                border-left: none;
                border-right: none;
                border-bottom: 3px solid #595959;
            }
        </style>

        <!-- 전체 목록 개수 / 순서정렬 필터 -->
        <div class="container mt-4 ">
            <div class="row justify-content-between">
                <div class="col d-flex align-items-center">
                    <h6 class="display-6 mt-2">총 <%=totalRowNum%>건의 동행이 있습니다.</h6>
                </div>

                <div class="col d-flex justify-content-end">
                    <button class="btn btn-outline-secondary border-0" id="inputRecentBtn">최근 순</button>   <!--ajax 정렬-->
                    <button class="btn btn-outline-secondary border-0" id="inputViewCountBtn">조회수 순</button> <!--ajax 정렬-->
                    <button class="btn btn-outline-secondary border-0" id="inputNearScheduleBtn">가까운 일정 순</button> <!--ajax 정렬-->
                </div>
            </div>
        </div> 


        <!-- 동행 데이터 목록 / 카드-->
		<!-- 태그 스타일 -->
	    <style>
	        ul{
	            list-style: none;
	        }
	
			.card{
				cursor: pointer;
			}
			
	        .card-body{
	            position: relative;
	        }
	
	        .hdTagBox{
	            width: 100%;
	            height: 100%;
	            position: absolute;
	            background-color: rgba(0, 0, 0, 0.63);
	            display: flex;
	            justify-content: center;
	            align-items: center;
	            visibility: hidden;
	        }
	
	        .hdTag{
	            width: 90%;
	            margin: 0px;
	            padding: 0px;
	            color: white;
	            /* border: 1px solid white; */
	            list-style: none;
	        }
	
	        .hdTag li{
	            display: inline;
	            padding-right: 5px;
	        }
	
	        .card-body:hover .hdTagBox{
	            visibility: visible;
	        }
	
	        .hdTagBox:hover{
	        }
	    </style>
        <!-- 동행 데이터 목록 / 카드-->        
        <div class="container mt-5 mb-5 bg-white justify-content-center" style="height:760px; width: 1140px;">
            <div class="row h-50 mb-2">

				<%
					for(DonghangJoinUserPicture dh : topList){				
				%>
                <div class="col h-100 p-0 mr-2">
                    <div class="card m-0" style="height: 100%;" 
                    onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangView.do?loginUserNo=<%=loginUser.getNo()%>&no=<%=dh.getNo()%>');">

                        <!--헤더-->
                        <div class="card-header h-20 p-1 d-flex justify-content-between bg-white align-items-center border-0" style="height: 9%;">
                            <span class="ml-1"><%=dh.getEnded().equals('Y')?"모집마감":"모집중"%></span>
                            <span class="mr-1"><%=dh.getWriteDate()%></span>
                        </div>

                        <!--바디(이미지)-->
                        <div class="card-body h-50 w-100 p-0 border-0" style="height: 50%;">
                            <div class="hdTagBox">
                                <ul class="hdTag">
                                <%if(!dh.getTag().isEmpty()){
                                	String[] tagArr = dh.getTag().split(",");	
                                	for(String tag : tagArr){%>
                                    <li><a>#<%=tag%></a></li>
                                <%} } %>
                                </ul>
                            </div>                        
                            <img src="<%=request.getContextPath()%>/image/<%=dh.getImage()%>" class="img-thumbnail p-0 h-100 rounded-0 border-0"/>
                        </div>

                        <!--푸터-->
                        <div class="card-footer h-30 d-flex flex-column bg-white border-0 justify-content-around" style="height: 31%;">
                            <span><%=dh.getTitle()%></span>
                            <span><%=dh.getNickName()%></span>
                            <div>
                                <p class="m-0">
                                    <span>동행지역 : </span>
                                    <%=dh.getTravleLocale()%>
                                </p>
                                <p class="m-0">
                                    <span>동행기간 : </span>
                                    <%=newFm.format(dh.getTravleStartDate())%> ~ <%=newFm.format(dh.getTravleEndDate())%>
                                </p>
                                <p class="m-0">
                                    <span>동행인원 : </span>
                                    <%=dh.getRecruitPeopleNo()%> / <%=dh.getJoinPeopleNo()%>
                                </p>
                            </div>
                        </div>

                    </div>
                </div>
				<%} %>
				<%for(int i=0; i<5-topList.size(); i++){ %>
                <div class="col h-100 p-0 mr-2">
                    <div style="height: 100%;" >
                    </div>
                </div>
                <%} %>
            </div>
            <div class="row h-50 mt-2">

				<%
					for(DonghangJoinUserPicture dh : bottomList){				
				%>
                <div class="col h-100 p-0 mr-2">
                    <div class="card m-0" style="height: 100%;" 
                    onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangView.do?loginUserNo=<%=loginUser.getNo()%>&no=<%=dh.getNo()%>');">

                        <!--헤더-->
                        <div class="card-header h-20 p-1 d-flex justify-content-between bg-white align-items-center border-0" style="height: 9%;">
                            <span class="ml-1"><%=dh.getEnded().equals('Y')?"모집마감":"모집중"%></span>
                            <span class="mr-1"><%=dh.getWriteDate()%></span>
                        </div>

                        <!--바디(이미지)-->
                        <div class="card-body h-50 w-100 p-0 border-0" style="height: 50%;">
                            <div class="hdTagBox">
                                <ul class="hdTag">
                                <%if(!dh.getTag().isEmpty()){
                                	String[] tagArr = dh.getTag().split(",");	
                                	for(String tag : tagArr){%>
                                    <li><a>#<%=tag%></a></li>
                                <%} } %>
                                </ul>
                            </div>                        
                            <img src="<%=request.getContextPath()%>/image/<%=dh.getImage()%>" class="img-thumbnail p-0 h-100 rounded-0 border-0"/>
                        </div>

                        <!--푸터-->
                        <div class="card-footer h-30 d-flex flex-column bg-white border-0 justify-content-around" style="height: 31%;">
                            <span><%=dh.getTitle()%></span>
                            <span><%=dh.getNickName()%></span>
                            <div>
                                <p class="m-0">
                                    <span>동행지역 : </span>
                                    <%=dh.getTravleLocale()%>
                                </p>
                                <p class="m-0">
                                    <span>동행기간 : </span>
                                    <%=newFm.format(dh.getTravleStartDate())%> ~ <%=newFm.format(dh.getTravleEndDate())%>
                                </p>
                                <p class="m-0">
                                    <span>동행인원 : </span>
                                    <%=dh.getRecruitPeopleNo()%> / <%=dh.getJoinPeopleNo()%>
                                </p>
                            </div>
                        </div>

                    </div>
                </div>
				<%} %>
				<%for(int i=0; i<5-bottomList.size(); i++){ %>
                <div class="col h-100 p-0 mr-2">
                    <div style="height: 100%;" >
                    </div>
                </div>
                <%} %>
            </div>
        </div>
        <!--카드 스타일-->
        <link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css"> 
        <style>
            .card{
                font-family: 'NanumSquare', sans-serif !important;
                border: 2px solid #dadada;
            }
            .card-body{
                overflow: hidden;
            }
            .card-body img{
                object-fit: cover;
            }

            .card-header{
                font-size: 14px;
            }
            .card-footer{
                padding: 5px 10px 5px 10px;
            }
            .card-footer span:nth-child(2){
                font-size: 13px;
            }
            .card-footer div span{
                font-size: 13px;
            }
            .card-footer p{
                font-size: 13px;
            }
            .card-footer p > span{
                font-size: 13px;
                font-weight: 600;
            }            
        </style>



        <!--페이지 버튼-->
        <div class="d-flex justify-content-center align-items-center">
        	<%=request.getAttribute(CommonKey.PAGE_BAR) %>
        </div>

        </div>
    </section>
    
    
    
    <!-- INPUT SCRIPT -->
    <script>
    	//1) 검색텍스트를 넣고 버튼을 늘릭 했을 때 (검색어만 있고 최근순default)
		$("#inputKeywordBtn").click(()=>{
			let keyword = $("#keyword").val();
			
			if(keyword==null||keyword.trim()==""){
					alert("검색어를 입력해주세요!");
			}else{
				location.replace('<%=request.getContextPath()%>/donghang/donghangListView.do?keyword='+keyword);
			}
		});
    	
    	//최근등록 버튼
    	$("#inputRecentBtn").click(()=>{
			let keyword = $("#keyword").val();
			if(keyword.trim()==""){
				keyword = "null";
			}
    		let recent = 'recent';
    		let viewcount = 'null';
    		let nearSchedule = 'null';
    		location.replace('<%=request.getContextPath()%>/donghang/donghangListView.do?keyword='+keyword+'&recent='+recent+'&viewcount='+viewcount+'&nearSchedule='+nearSchedule);
    	});
	    //조회수 버튼
    	$("#inputViewCountBtn").click(()=>{
			let keyword = $("#keyword").val();
			if(keyword.trim()==""){
				keyword = "null";
			}
    		let recent = 'null';
    		let viewcount = 'viewcount';
    		let nearSchedule = 'null';
    		location.replace('<%=request.getContextPath()%>/donghang/donghangListView.do?keyword='+keyword+'&recent='+recent+'&viewcount='+viewcount+'&nearSchedule='+nearSchedule);
    	});
    	//가까운일정순 버튼
    	$("#inputNearScheduleBtn").click(()=>{
			let keyword = $("#keyword").val();
			if(keyword.trim()==""){
				keyword = "null";
			}
    		let recent = 'null';
    		let viewcount = 'null';
    		let nearSchedule = 'nearSchedule';
    		location.replace('<%=request.getContextPath()%>/donghang/donghangListView.do?keyword='+keyword+'&recent='+recent+'&viewcount='+viewcount+'&nearSchedule='+nearSchedule);
    	});
    	
    </script>
</section>
<%@ include file="/views/common/footer.jsp"%> 