<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.laon.donghang.model.vo.MyDong" %>
<%
	List<MyDong> myDong=(List)request.getAttribute("myDong");
	int myDHCount=(int)request.getAttribute("myDHCount");
	String myDHPasing=(String)request.getAttribute("myDHPasing");
%>    
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
					<form action="<%=request.getContextPath() %>/mypage/myDHDelete.do" method="get">
						<!-- 닫힘 내용 -->
						<div>
							<!-- 정보 -->
							<div id="myDHInfo">
								<div style="height:45px;">
									<span>총 <%=myDHCount %>개의 동행</span>
								</div>
								<div id="dhCk1">
									<button class="btn" type="button">선택삭제</button>
								</div>
								<div id="dhCk2">
									<label><input type="checkbox" id="dhAll">&nbsp;전체 선택</label>&nbsp;&nbsp;|&nbsp;&nbsp;
									<button class="btn" type="submit">삭제</button>&nbsp;&nbsp;|&nbsp;&nbsp;
									<button class="btn" id="dhEndBtn" type="button">돌아가기</button>
								</div>
							</div>
							<!-- 게시글위치 -->
							<table id="dhTbl" class="d-flex justify-content-center">
								<input type="hidden" value="<%=loginUser.getNo() %>" name="userNo" id="userNo">
								<tr class="d-flex flex-wrap">
								<%for(MyDong d:myDong){ %>
									<td class="p-1">
					                    <div class="dhCk3" style="margin:10px;">
											<label style="width:130px;">
												<input type="checkbox" class="dhCks" name="dhCks" value="<%=d.getNo()%>">
											</label>
										</div>
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
													<img src="<%=request.getContextPath() %>/images/images.jpeg" class="card-img" alt="..." width="155px" height="155px" onclick="location.replace('<%=request.getContextPath()%>/donghang/donghangView.do?loginUserNo=<%=loginUser.getNo() %>&no=<%=d.getNo()%>')">
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
							</table>
						</div>
					</form>
					<div class="d-flex justify-content-center">
						<%=myDHPasing %>
					</div>
				</div>
			</section>
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
    
    #myDHInfo,.manuBar{
    	display:flex;
    	justify-content: space-between;
    	margin-left: 40px;
    	margin-right: 40px;
    }

	#dhCk2,.dhCk3{
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
	/* 내동행 */
	$(function(){
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
	});
	
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
</script>