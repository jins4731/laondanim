<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.laon.donghang.model.vo.MyDong,com.laon.donghang.model.vo.DonghangJoin" %>
<%
	List<DonghangJoin> joinDong=(List)request.getAttribute("joinDong");
	List<MyDong> oriJoinDong=(List)request.getAttribute("oriJoinDong");
	List<UserProfile> userNick=(List)request.getAttribute("userNick");
	String myJDPasing=(String)request.getAttribute("myJDPasing");
	int myJDCount=(int)request.getAttribute("myJDCount");
%>
<%@ include file="/views/common/header.jsp"%>
<div class="container">
	<div class="row">
	   	<div class="col-4">
			<%@ include file="/views/mypage/myPageAside.jsp" %>
		</div>
		<div class="col-8">
			<section>
				<div id="myMenuBtn">
					<button type="button" id="myCon" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageContent.do?userNo=<%=loginUser.getNo()%>')">내 컨텐츠</button>
					<button type="button" id="myH" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageHeart.do?userNo=<%=loginUser.getNo()%>')">내 마음함</button>
					<button type="button" id="myDh" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageDong.do?userNo=<%=loginUser.getNo()%>')">내 동행</button>
				</div>
				<div id="myPageView">
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
							<div id="jDhCk1">
								<button class="btn">선택삭제</button>
							</div>
							<div id="jDhCk2">
								<label><input type="checkbox" id="jDhAll">&nbsp;전체 선택</label>&nbsp;&nbsp;|&nbsp;&nbsp;
								<button class="btn">삭제</button>&nbsp;&nbsp;|&nbsp;&nbsp;
								<button class="btn" id="jDhEndBtn">돌아가기</button>
							</div>
						</div>
						<!-- 게시글위치 -->
						<table id="dhTbl">
							<tr class="d-flex flex-wrap justify-content-center">
							<%for(MyDong j:oriJoinDong){ %>
								<td class="p-1">
			                    	<div class="jDhCk3" style="margin:10px;">
										<input type="checkbox" class="jDhCks">
									</div>
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
														    	<a class="dropdown-item" href="#">삭제</a>
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
						</table>
						<div class="d-flex justify-content-center">
							<%=myJDPasing %>
						</div>
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
    
    #joinDHInfo,.manuBar{
    	display:flex;
    	justify-content: space-between;
    	margin-left: 40px;
    	margin-right: 40px;
    }

	#jDhCk2,.jDhCk3{
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
	/* 참여동행 */
	$(function(){
		$("#jDhCk1>button").click(()=>{
			$("#jDhCk1").css("display","none");
			$("#jDhCk2").css("display","block");
			$(".jDhCk3").css("display","block");
		});
		
		$("#jDhEndBtn").click(()=>{
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
	});
	
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