<%@page import="com.laon.donghang.model.vo.DonghangJoinUserPicture"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.laon.common.CommonKey" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="com.laon.donghang.model.vo.Donghang" %>
<%@page import="com.laon.donghang.model.vo.DonghangJoinUserPicture" %>

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
	
<style>
/* 	*:not(:not([type="submit"])){
		font-family: NanumSquare;
		font-size: 17px;
	} */
	/* 카테고리 제목 폰트 */
	@font-face { font-family: 'Cafe24Danjunghae'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Danjunghae.woff') format('woff'); font-weight: normal; font-style: normal; }
	/* 본문 폰트 */
	@font-face { font-family: 'S-CoreDream-4Regular'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-4Regular.woff') format('woff'); font-weight: normal; font-style: normal; }
	.laonTitleFont{
		font-family: Cafe24Danjunghae;
		font-size: 35px;
		color: #595959;
	}
	.laonBodyFont{
		font-family: NanumSquare;
		font-size: 22px;
		color: #595959;
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
	.ldBtnSubmit{
	    border-radius: 20px;
	    background-color: #00abbf;
	    border: 2px solid #00abbf;
	    color: white;
	    padding: 6px 15px 6px 15px;   
	}  
</style>
   	<div style="height: 170px;"></div>
    <section class="d-flex flex-row justify-content-center">
        <div style="width: 1366px;" class="pt-5 pb-5">


        <!--검색창-->
        <div class="d-flex justify-content-center align-items-center">
            <div id="searchDIV" class="d-flex justify-content-center align-items-center m-5">
                <select class="form-control border-0 rounded-0" name="searchFilter" id="searchFilter">
                    <!-- <option value="">전체 검색</option> -->
                    <option value="searchLocal">지역검색</option>
                    <option value="searchKeyword">키워드 검색</option>                    
                </select>
                <input type="text" id="keyword" name="keyword" class="pl-2" 
                <%if(!keyword.equals("null")){ %>value='<%=keyword%>'
                <%}else{%>
                	value=""
                <%}%>/>
                <button id="inputKeywordBtn">
                	<img src="<%=request.getContextPath()%>/images/inactiveSearch_icon.png" alt="searchIcon" id="searchIcon"/>
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
                background-image: url('<%=request.getContextPath()%>/images/down_icon.png');
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
					$("#searchIcon").attr('src','<%=request.getContextPath()%>/images/search_icon.png').fadeIn(300);
				})
			});
			$("#keyword").focusout(()=>{
				$("#searchIcon").fadeOut(200, ()=>{
					$("#searchIcon").attr('src','<%=request.getContextPath()%>/images/inactiveSearch_icon.png').fadeIn(300);
				})
			});
        </script>

        <!-- 작성 -->
        <div class="d-flex justify-content-center">
            <div class="d-flex justify-content-end align-items-end" style="width: 1140px;">
                <button class="btn btn-lg d-flex align-items-end justify-content-center mt-3 mb-3" 
                        onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangWrite.do?userNo=<%=loginUser.getNo()%>')" id="dhWriteBtn">
                    <p class="m-0">동행찾기 작성</p>                    
                    <img src="<%=request.getContextPath()%>/images/write_icon.png" class="ml-2 w-25">
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
	        
	        .lockIcon{
		         position: absolute; 
		         width: 30px;
		         filter: drop-shadow(0px 0px 3px #000);
	         }
	         input[type=password]:focus {
			    outline: none;
			 }
	    </style>
        <!-- 동행 데이터 목록 / 카드-->        
        <div class="container mt-5 mb-5 bg-white justify-content-center" style="height:760px; width: 1140px;">
            <div class="row h-50 mb-2">

				<%
					for(DonghangJoinUserPicture dh : topList){				
				%>
                <div class="col h-100 p-0 mr-2">
                <%if(dh.getPublicEnabled().equals("Y")&&(dh.getPublicEnabled().equals("Y")&&dh.getUserNo()!=loginUser.getNo())){ %>
                    <div class="card m-0" style="height: 100%;" 
                    onclick="fn_pwInput(<%=dh.getPw()%>, <%=loginUser.getNo()%>,<%=dh.getNo()%>);">
                <%}else{ %>
                    <div class="card m-0" style="height: 100%;" 
                    onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangView.do?loginUserNo=<%=loginUser.getNo()%>&no=<%=dh.getNo()%>');">
				<%} %>
                        <!--헤더-->
                        <div class="card-header h-20 p-1 d-flex justify-content-between bg-white align-items-center border-0" style="height: 9%;">
                            <span class="ml-1"><%=dh.getEnded().equals('Y')?"모집마감":"모집중"%></span>
                            <span class="mr-1"><%=dh.getWriteDate()%></span>
                        </div>

                        <!--바디(이미지)-->
                        <div class="card-body h-50 w-100 p-0 border-0" style="height: 50%; position: relative;">
                            <div class="hdTagBox">
                                <ul class="hdTag">
                                <%if(!dh.getTag().isEmpty()){
                                	String[] tagArr = dh.getTag().split(",");	
                                	for(String tag : tagArr){%>
                                    <li><a>#<%=tag%></a></li>
                                <%} } %>
                                </ul>
                            </div>           
                            <%if(dh.getPublicEnabled().equals("Y")) {%>             
                            <img src="<%=request.getContextPath()%>/images/lock_icon.png" class="mt-2 ml-1 lockIcon"/>
                            <%} %>
                            <img src="<%=request.getContextPath()%>/upload/donghang/<%=dh.getImage()%>" class="img-thumbnail p-0 h-100 rounded-0 border-0"/>
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
                                    <%=dh.getJoinPeopleNo()%> / <%=dh.getRecruitPeopleNo()%>
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
                <%if(dh.getPublicEnabled().equals("Y")){ %>
                    <div class="card m-0" style="height: 100%;" 
                    onclick="fn_pwInput(<%=dh.getPw()%>, <%=loginUser.getNo()%>,<%=dh.getNo()%>);">
                <%}else{ %>
                    <div class="card m-0" style="height: 100%;" 
                    onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangView.do?loginUserNo=<%=loginUser.getNo()%>&no=<%=dh.getNo()%>');">
				<%} %>
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
                            <%if(dh.getPublicEnabled().equals("Y")) {%>             
                            <img src="<%=request.getContextPath()%>/images/lock_icon.png" class="mt-2 ml-1 lockIcon"/>
                            <%} %>
                            <img src="<%=request.getContextPath()%>/upload/donghang/<%=dh.getImage()%>" class="img-thumbnail p-0 h-100 rounded-0 border-0"/>
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
                                    <%=dh.getJoinPeopleNo()%> / <%=dh.getRecruitPeopleNo()%>
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
    
    <!-------------------------------------------------- 동행 비번입력 --------------------------------------------------------------------->
    <!-- 닉네임 글자수 안내 모달 -->
    <div class="modal" id="pwInputModal">
        <div class="modal-dialog">
        <div class="modal-content">
        
            <!-- Modal Header -->
            <div class="modal-header border-bottom-0">
            <p class="mt-4 ml-5 laonBodyFont"><strong class="laonBodyFont">비공개 동행</strong>입니다.<br>비밀번호를 입력해주세요.</p>
            
            <button type="button" class="close modal-close" data-dismiss="modal">&times;</button>
            </div>
            
            <!-- Modal body -->
            <div class="modal-body d-flex">
            	<div class="d-flex justify-content-center w-100">
            		<input type="password" name="inputDhPw" id="inputDhPw" required="required"
            			style="width: 360px; border-bottom: 2px soild #dadada; border-top: none; border-left: none; border-right: none;"/>
            	</div>
            </div>
            
            <!-- Modal footer -->
            <div class="modal-footer border-top-0">
            <button type="button" class="ldBtnSubmit modal-close mr-5" data-dismiss="modal" id="dhPwBtn">입력</button>
            </div>
            
        </div>
        </div>
    </div>
    <!-- -------------------------------------------------------------------------------------------------------------------------------- -->    
    <!-- -------------------------------------------------------------------------------------------------------------------------------- -->
       <!-- 비번 오류 Modal -->
    <div class="modal" id="pwErorrModal">
        <div class="modal-dialog">
        <div class="modal-content">
        
            <!-- Modal Header -->
            <div class="modal-header border-bottom-0">
            <button type="button" class="close modal-close" data-dismiss="modal">&times;</button>
            </div>
            
            <!-- Modal body -->
            <div class="modal-body">
            	<span class='ml-2'>&#x274C</span>비밀번호가 틀립니다. 다시 시도해주세요.
            </div>
            
            <!-- Modal footer -->
            <div class="modal-footer border-top-0">
            <button type="button" class="ldBtnSubmit modal-close" data-dismiss="modal">Close</button>
            </div>
            
        </div>
        </div>
    </div>    
    <!-- -------------------------------------------------------------------------------------------------------------------------------- -->
    <!-- INPUT SCRIPT -->
    <script>
		//셀렉트 옵션 값 받기
		let searchFilter = $("#searchFilter option:selected").val();
		$("#searchFilter").change(()=>{
			searchFilter = $("#searchFilter option:selected").val();
			alert(searchFilter);
		});
		
    	//1) 검색텍스트를 넣고 버튼을 늘릭 했을 때 (검색어만 있고 최근순default)
		$("#inputKeywordBtn").click(()=>{
			let keyword = $("#keyword").val();
			
			if(keyword==null||keyword.trim()==""){
					alert("검색어를 입력해주세요!");
			}else{
				location.replace('<%=request.getContextPath()%>/donghang/donghangListView.do?searchFilter=' + searchFilter + '&keyword=' + keyword);
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
    	//동행비번 모달 띄우기
    	let dhPw;
    	let luNo;
    	let dhNo;
    	let inputPw;
    	function fn_pwInput(pw,uN,dN){
    		//alert(pw);
    		$("#pwInputModal").modal("show");
    		dhPw = pw;
    		luNo = uN;
    		dhNo = dN;
        	console.log(dhPw,luNo,dhNo);
    	}
    	
    	$("#dhPwBtn").click(()=>{
    		inputPw = $("#inputDhPw").val();
    		if(inputPw==dhPw){
    			location.replace('<%=request.getContextPath()%>/donghang/donghangView.do?loginUserNo='+luNo+'&no='+dhNo);
    		}else{
    			$("#pwErorrModal").modal("show");
    		}
    	});


    </script>

<%@ include file="/views/common/footer.jsp"%> 