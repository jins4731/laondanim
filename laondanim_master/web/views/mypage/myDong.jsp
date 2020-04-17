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
						                        		<a class="dropdown-item" href="<%=request.getContextPath()%>/donghang/donghangJoinlist.do?userNo=<%=loginUser.getNo()%>&no=<%=d.getNo()%>">신청서 수신함</a>
						                        		<a class="dropdown-item" href="#">채팅</a>
												      	<a class="dropdown-item" href="#">모집 마감</a>
												     	<a class="dropdown-item" href="#">동행 수정</a>
												     	<a class="dropdown-item" href="#">동행 삭제</a>
						                        	<%}else{ %>
												    	<a class="dropdown-item" href="<%=request.getContextPath()%>/donghang/donghangJoinlist.do?userNo=<%=loginUser.getNo()%>&no=<%=d.getNo()%>">신청서 수신함</a>
												    	<a class="dropdown-item" href="#">채팅</a>
												     	<a class="dropdown-item" href="#">동행 수정</a>
												     	<a class="dropdown-item" href="#">동행 삭제</a>
						                        	<%} %>
												    </div>
												</div>
											</div>
											<%if(d.getImage()==null){ %>
												<img src="<%=request.getContextPath() %>/images/images.jpeg" class="card-img" alt="..." width="155px" height="155px">
											<%}else{ %>
												<img src="<%=request.getContextPath() %>/views/picture/trip/<%=d.getImage()%>" class="card-img" alt="..." width="155px" height="155px">
											<%} %>
										</div>
				                        <div class="d-flex flex-column justify-content-center p-2" style="font-size:7px;">
				                        	<p class="mb-0"><%=d.getTitle() %></p>
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
											    	<button type="button" class="btn" data-toggle="dropdown">
											      		...
											    	</button>
					                        		<div class="dropdown-menu">
					                        		<%for(DonghangJoin dj:joinDong){ 
					                        			if(j.getNo()==dj.getDonghangNo()){
													    	if(dj.getConfirmed().equals("N")){ %>
														    	<a class="dropdown-item" href="<%=request.getContextPath()%>/myPage/myDongJoinRefusal.do?userNo=<%=loginUser.getNo()%>&dongJoinNo=<%=dj.getNo()%>">삭제</a>
								                        	<%}else if(dj.getConfirmed().equals("Y")){ %>
								                        		<a class="dropdown-item" href="#">채팅</a>
														      	<a class="dropdown-item" href="#">동행 나가기</a>
								                        	<%}else{ %>
								                        		<a class="dropdown-item" href="#">보낸 신청서 보기</a>
														      	<a class="dropdown-item" href="#">참여 신청 취소</a>
						                        	<%} } }%>
						                        	</div>
												</div>
			                           		</div>
			                           		<%if(j.getImage()==null){ %>
												<img src="<%=request.getContextPath() %>/images/images.jpeg" class="card-img" alt="..." width="155px" height="155px">
											<%}else{ %>
												<img src="<%=request.getContextPath() %>/views/picture/trip/<%=j.getImage()%>" class="card-img" alt="..." width="155px" height="155px">
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
							<%if(joinDong.size()==4){ %>
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
	
	#myMenuBtn>button{	
		width:150px;
		margin: 20px;
    	border-radius: 100px;
	}
	
	.tover{
		white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
	}
</style>

<script>
	/* 내동행 */
	/* $(function(){
		$("#dhCk1>button").click(()=>{
			$("#dhCk1").css("display","none");
			$("#dhCk2").css("display","block");
			$(".dhCk3").css("display","block");
		});
		
		$("#dhEndBtn").click(()=>{
			$("#dhCk1").css("display","block");
			$("#dhCk2").css("display","none");
			$(".dhCk3").css("display","none");
		});
		
		$("#dhAll").click(()=>{
			if($("#dhAll").is(":checked")){							
				$(".dhCks").prop("checked",true);
			}else{
				$(".dhCks").prop("checked",false);
			}
		});
	}); */
	
	/* 참여동행 */
	/* $(function(){
		$("#jDhCk1>button").click(()=>{
			$("#jDhCk1").css("display","none");
			$("#jDhCk2").css("display","block");
			$(".jDhCk3").css("display","block");
		});
		
		$("#dhEndBtn").click(()=>{
			$("#jDhCk1").css("display","block");
			$("#jDhCk2").css("display","none");
			$(".jDhCk3").css("display","none");
		});
		
		$("#jDhAll").click(()=>{
			if($("#jDhAll").is(":checked")){							
				$(".jDhCks").prop("checked",true);
			}else{
				$(".jDhCks").prop("checked",false);
			}
		});
	}); */
	
	$(function(){
		$(".imgDrop").stop().css({"transform":"rotate(90deg)"});
	});
	var flag=false;
	$(".menu").click(function(){
		if(flag){
			$(this).next().slideDown();
			$(this).find(".imgDrop").stop().css({'transform': 'rotate(90deg)'},1000);
			flag=false;
		}else{
			$(this).next().slideUp();
			$(this).find(".imgDrop").stop().css({'transform': 'rotate(-90deg)'},1000);
			flag=true;
		}
	});
</script>
