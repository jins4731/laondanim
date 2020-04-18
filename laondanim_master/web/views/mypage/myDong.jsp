<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.laon.donghang.model.vo.MyDong,com.laon.donghang.model.vo.DonghangJoin" %>
<%
	List<MyDong> myDong=(List)request.getAttribute("myDong");
	int myDongCount=(int)request.getAttribute("myDongCount");
	List<DonghangJoin> joinDong=(List)request.getAttribute("joinDong");
	List<MyDong> oriJoinDong=(List)request.getAttribute("oriJoinDong");
	List<UserProfile> userNick=(List)request.getAttribute("userNick");
	int myJDCount=(int)request.getAttribute("myJDCount");
%>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> -->

<%@ include file="/views/common/header.jsp"%>
<div style="height: 170px;"></div>
<div class="container">
	<div class="row">
	   	<div class="col-4">
			<%@ include file="/views/mypage/myPageAside.jsp" %>
		</div>
		<div class="col-8">
			<section class="d-flex flex-column justify-content-center align-items-center">
				<div id="myMenuBtn">
					<button type="button" id="myCon" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageContent.do?userNo=<%=loginUser.getNo()%>')">내 컨텐츠</button>
					<button type="button" id="myH" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageHeart.do?userNo=<%=loginUser.getNo()%>')">내 마음함</button>
					<button type="button" id="myDh" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageDong.do?userNo=<%=loginUser.getNo()%>')">내 동행</button>
				</div>
				<div id="myPageView" class="w-100">
					<!-- 내 동행 -->
					<div class="menu">
						<div class="manuBar">
							<div>
								<span>내가 만든 동행</span>
							</div>
							<div>
								<img class="imgDrop" src="<%=request.getContextPath() %>/images/drop.png">
							</div>
						</div>
						<hr>
					</div>
					<!-- 닫힘 내용 -->
					<div>
						<!-- 정보 -->
						<div id="myDHInfo">
							<div style="height:45px;">
								<span>총 <%=myDongCount %>개의 동행</span>
							</div>
						</div>
						<!-- 게시글위치 -->
						<%if(myDong.size()>0){%>
						<table id="dhTbl">
							<tr class="d-flex flex-wrap justify-content-center">
								<%for(MyDong d:myDong){ %>
								<td class="p-1">
				                    <div class="card" style="width: 155px; height: 275px;" >
				                    	<div class="d-flex justify-content-between p-2" style="font-size:5px;">
				                    		<%if(d.getEnded().equals("N")){ %>
				                        		<span>모집중</span>
				                        	<%}else{ %>
				                        		<span>모집종료</span>
				                        	<%} %>
				                            <span><%=d.getWriteDate() %></span>
				                        </div>
				                        <div>
				                        	<div style="position: absolute;">
												<div class="dropdown" style="position: relative;">
													<button type="button" class="btn" data-toggle="dropdown">
												    	...
												    </button>
												    <div class="dropdown-menu">
												    <%if(d.getEnded().equals("N")){ %>
												    	<a class="dropdown-item" href="<%=request.getContextPath()%>/donghang/donghangJoinlist.do?userNo=<%=loginUser.getNo()%>&no=<%=d.getNo()%>&filter=ALL">신청서 수신함</a>
												      	<a class="dropdown-item" href="<%=request.getContextPath()%>/mypage/myDongDeadline.do?userNo=<%=loginUser.getNo() %>&no=<%=d.getNo() %>&title=<%=d.getTitle() %>" onclick="return confirm('[<%=d.getTitle() %>] 동행 모집을 마감하시겠습니까?');">모집 마감</a>
												     	<a class="dropdown-item" href="<%=request.getContextPath()%>/donghang/donghangUpdate.do?userNo=<%=loginUser.getNo()%>&no=<%=d.getNo()%>">동행 수정</a>
												     	<a class="dropdown-item" href="<%=request.getContextPath()%>/mypage/myDongDel.do?userNo=<%=loginUser.getNo()%>&no=<%=d.getNo() %>">동행 삭제</a>
						                        	<%}else{ %>
						                        		<a class="dropdown-item" href="<%=request.getContextPath()%>/donghang/donghangJoinlist.do?userNo=<%=loginUser.getNo()%>&no=<%=d.getNo()%>&filter=ALL">신청서 수신함</a>
												     	<a class="dropdown-item" href="<%=request.getContextPath()%>/donghang/donghangJoinlist.do?userNo=<%=loginUser.getNo()%>&no=<%=d.getNo()%>">동행 수정</a>
												     	<a class="dropdown-item" href="<%=request.getContextPath()%>/mypage/myDongDel.do?userNo=<%=loginUser.getNo()%>&no=<%=d.getNo() %>">동행 삭제</a>
						                        	<%} %>
												    </div>
												</div>
											</div>
											<%if(d.getImage()==null){ %>
												<img src="<%=request.getContextPath() %>/images/images.jpeg" class="card-img" alt="..." width="155px" height="155px"  onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangView.do?loginUserNo=<%=loginUser.getNo() %>&no=<%=d.getNo()%>')">
											<%}else{ %>
												<img src="<%=request.getContextPath() %>/upload/donghang/<%=d.getImage()%>" class="card-img" alt="..." width="155px" height="155px" onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangView.do?loginUserNo=<%=loginUser.getNo() %>&no=<%=d.getNo()%>')">
											<%} %>
										</div>
				                        <div class="d-flex flex-column justify-content-center p-2" style="font-size:7px;">
				                        	<p class="mb-0 tover"><%=d.getTitle() %></p>
				                       		<ul class="p-0 m-0">
				                            	<li class="tover">동행지역 : <span><%=d.getTravleLocale() %></span></li>
				                            	<li>기간 : <span><%=d.getTravleStartDate() %></span><br>
				                            			<div style="text-align:right;">
				                            			  <span> ~ <%=d.getTravleEndDate() %></span>
				                            			</div>
				                            	</li>
				                            	<li>인원 : <span><%=d.getJoinPeopleNo() %> / <%=d.getRecruitPeopleNo() %></span></li>
				                           	</ul>
										</div>
									</div>
								</td>
							<%} %>
							</tr>
							<%if(myDong.size()==4){ %>
							<tr>
								<td colspan="4" style="text-align: center;">
									<button class="btn" onclick="location.replace('<%=request.getContextPath()%>/myPage/myDongMyDH.do?userNo=<%=loginUser.getNo()%>')">+더보기</button>
								</td>
							</tr>
							<%} %>
						</table>
						<%}else{  %>
						<div style="text-align: center;">
							<span>등록된 나의 동행이 없습니다.</span>
						</div>
						<%} %>
					</div>
					
					<!-- 참여중인 동행 -->
					<div class="menu" style="padding-top:20px;">
						<div class="manuBar">
							<div>
								<span>참여중인 동행</span>
							</div>
							<div>
								<img class="imgDrop" src="<%=request.getContextPath() %>/images/drop.png">
							</div>
						</div>
						<hr>
					</div>
					<!-- 닫힘 내용 -->
					<div>
						<!-- 정보 -->
						<div id="joinDHInfo">
							<div style="height:45px;">
								<span>총 <%=myJDCount %>개의 동행</span>
							</div>
						</div>
						<!-- 게시글위치 -->
						<%if(oriJoinDong.size()>0){%>
						<table id="dhTbl">
							<tr class="d-flex flex-wrap justify-content-center">
								<%for(MyDong j:oriJoinDong){ %>
								<td class="p-1">
			                       	<div class="card" style="width: 155px; height: 290px;" >
			                        	<div class="d-flex justify-content-between p-2" style="font-size:5px;">
			                        		<%for(DonghangJoin dj:joinDong){ 
			                        			if(j.getNo()==dj.getDonghangNo()){
					                        		if(dj.getConfirmed().equals("N")){ %>
						                        		<span>참여거절</span>
						                        	<%}else if(dj.getConfirmed().equals("Y")){ %>
						                        		<span>참여중</span>
						                        	<%}else{ %>
						                        		<span>대기중</span>
				                        	<%} } }%>
			                            	<span><%=j.getWriteDate() %></span>
			                            </div>
			                           	<div>
			                           		<div style="position: absolute;">
			                            		<div class="dropdown" style="position: relative;">
			                            		<%for(DonghangJoin dj:joinDong){ 
					                        		if(j.getNo()==dj.getDonghangNo()){
													    if(!dj.getConfirmed().equals("Y")){ %>
											    	<button type="button" class="btn" data-toggle="dropdown">
											      		...
											    	</button>
											    	<%} } }%>
					                        		<div class="dropdown-menu">
					                        		<%for(DonghangJoin dj:joinDong){ 
					                        			if(j.getNo()==dj.getDonghangNo()){
													    	if(dj.getConfirmed().equals("N")){ %>
														    	<a class="dropdown-item" href="<%=request.getContextPath()%>/myPage/myDongJoinRefusal.do?userNo=<%=loginUser.getNo()%>&dongJoinNo=<%=dj.getNo()%>">삭제</a>
								                        	<%-- <%}else if(dj.getConfirmed().equals("Y")){ %>
														      	<a class="dropdown-item" href="#">동행 나가기</a> --%>
								                        	<%}else if(dj.getConfirmed().equals("J")){ %>
														      	<a class="dropdown-item" href="<%=request.getContextPath()%>/mypage/myDongJoinCancle.do?userNo=<%=loginUser.getNo()%>&djNo=<%=dj.getNo()%>&title=<%=j.getTitle() %>" onclick="return confirm('[<%=j.getTitle() %>] 동행 참여 신청을 취소 하시겠습니까?');">참여 신청 취소</a>
						                        	<%} } }%>
						                        	</div>
												</div>
			                           		</div>
			                           		<%if(j.getImage()==null){ %>
												<img src="<%=request.getContextPath() %>/images/images.jpeg" class="card-img" alt="..." width="155px" height="155px" onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangView.do?loginUserNo=<%=loginUser.getNo() %>&no=<%=j.getNo()%>')">
											<%}else{ %>
												<img src="<%=request.getContextPath() %>/upload/donghang/<%=j.getImage()%>" class="card-img" alt="..." width="155px" height="155px" onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangView.do?loginUserNo=<%=loginUser.getNo() %>&no=<%=j.getNo()%>')">
											<%} %>
			                           </div>
			                           <div class="d-flex flex-column justify-content-center card-body p-2" style="font-size:7px;">
			                               <p class="mb-0"><%=j.getTitle() %></p>
			                               <%String nick="";
			                               for(UserProfile un:userNick){ 
			                            	   if(j.getUserNo()==un.getNo()){
			                            		   nick=un.getNickName();
			                            	   }
		                            	   }%>
		                            	   <span><%=nick %></span>
			                               <ul class="p-0 m-0">
			                                   <li>동행지역 : <span><%=j.getTravleLocale() %></span></li>
			                                   <li>기간 : <span><%=j.getTravleStartDate() %></span><br>
				                            			<div style="text-align:right;">
				                            			  <span> ~ <%=j.getTravleEndDate() %></span>
				                            			</div>
			                                   </li>
			                                   <li>인원 : <span><%=j.getJoinPeopleNo() %> / <%=j.getRecruitPeopleNo() %></span></li>
			                               </ul>
			                           </div>
			                       </div>
			                   </td>
			                <%} %>
							</tr>
							<%if(oriJoinDong.size()==4){ %>
							<tr>
								<td colspan="4" style="text-align: center;">
									<button class="btn" onclick="location.replace('<%=request.getContextPath()%>/myPage/myDongMyJD.do?userNo=<%=loginUser.getNo()%>')">+더보기</button>
								</td>
							</tr>
							<%} %>
						</table>
						<% }else{ %>
	                	<div style="text-align: center;">
							<span>참여중인 동행이 없습니다.</span>
						</div>
		                <%} %>
					</div>
				</div>
			</section>
		</div>
	</div>
</div>
<%@ include file="/views/common/footer.jsp"%>

<div class="modal" id="myDongDeadline">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header border-bottom-0">
				<h4 class="modal-title">동행 모집 마감</h4>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<div id="enrollEmailAut_result"></div>
			</div>

			<!-- Modal footer -->
			<div class="modal-footer border-top-0">
				<button type="button" class="ldBtnSubmit modal-close" data-dismiss="modal">Close</button>
				<button type="button">확인</button>
			</div>
		</div>
	</div>
</div>

<style>
	div.menu{
		width:auto;
		cursor:pointer;
	}
	
	*{
        border-collapse:collapse;
        margin:0px;
        padding:0px;
        text-decoration: none;
        color:black;
        list-style:none;
        /* border:1px solid green; */
    }
    
    #myDHInfo,#joinDHInfo,.manuBar{
    	display:flex;
    	justify-content: space-between;
    	margin-left: 40px;
    	margin-right: 40px;
    }

	#dhCk2,.dhCk3,#jDhCk2,.jDhCk3{
		display:none;
	}
	
	#myMenuBtn{
		text-align:center;
	}
	
	#myMenuBtn>#myDh{
		color: white;
    	background-color: #00abbf;
	}
	
	#myMenuBtn>button{	
		width:150px;
		margin: 20px;
    	border-radius: 100px;
    	border-radius: 20px;
	    background-color: white;
	    border: 2px solid #00abbf;
	    color: #00abbf;
	    padding: 6px 15px 6px 15px;
	}
	
	#myMenuBtn>button:hover{
		color: white;
    	background-color: #00abbf;
	}
	
	.tover{
		white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
	}
</style>

<script>
	$(function(){
		$(".imgDrop").stop().css({"transform":"rotate(-90deg)"});
	});
	var flag=false;
	$(".menu").click(function(){
		if(flag){
			$(this).next().slideDown();
			$(this).find(".imgDrop").stop().css({'transform': 'rotate(-90deg)'},1000);
			flag=false;
		}else{
			$(this).next().slideUp();
			$(this).find(".imgDrop").stop().css({'transform': 'rotate(90deg)'},1000);
			flag=true;
		}
	});
	
	$(".modal-close").click(()=>{
	    $("#myDongDeadline").hide();
	});
</script>