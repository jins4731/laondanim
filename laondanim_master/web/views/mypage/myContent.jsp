<%@page import="com.laon.trip.model.vo.TripMyCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.laon.trip.model.vo.TripMyCon,com.laon.board.model.vo.Board,com.laon.etc.model.vo.Like" %>
<%
	List<TripMyCon> trip=(List)request.getAttribute("trip");
	int tripCount=(int)request.getAttribute("tripCount");
	List<Like> tripLike=(List)request.getAttribute("tripLike");

	List<Board> board=(List)request.getAttribute("board");
	String boardPasing=(String)request.getAttribute("boardPasing");
	int boardCount=(int)request.getAttribute("boardCount");
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
					<!-- 내 다님길 -->
					<div class="menu">
						<div class="manuBar">
							<div>
								<span>내 여행기</span>
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
						<div id="myDNInfo">
							<div style="height:45px;">
								<span>총 <%=tripCount %>개의 여행기</span>
							</div>
						</div>
						<!-- 게시글위치 -->
						<%if(trip.size()>0){ %>
						<table id="dnTbl">
							<tr class="d-flex flex-wrap">
								<%for(TripMyCon t:trip){ %>
								<td class="p-1">
									<div class="card" style="width: 155px; height: 250px;">
										<div class="d-flex justify-content-between p-2" style="font-size:5px;">
						    				<span><%=t.getCategory() %></span>
						    				<span><%=t.getWriteDate() %></span>
										</div>
										<div>
		                            		<div style="position: absolute;">
			                            		<div class="dropdown" style="position: relative;">
											    	<button type="button" class="btn" data-toggle="dropdown">
											    	  ...
											    	</button>
											   	 	<div class="dropdown-menu">
											      		<a class="dropdown-item" href="#">수정</a>
											     		<a class="dropdown-item" href="<%=request.getContextPath()%>/myPage/myTripDelete.do?userNo=<%=loginUser.getNo()%>&tripNo=<%=t.getNo()%>&title=<%=t.getTitle()%>" onclick="return confirm('[<%=t.getTitle() %>] 여행기를 삭제 하시겠습니까?');">삭제</a>
											    	</div>
												</div>
											</div>
											<%if(t.getImage()==null){ %>
												<img src="<%=request.getContextPath() %>/images/images.jpeg" class="card-img" alt="..." width="155px" height="155px" onclick="location.replace('<%=request.getContextPath()%>/trip/tripView.do?no=<%=t.getNo()%>')">
											<%}else{ %>
												<img src="<%=request.getContextPath() %>/views/picture/trip/<%=t.getImage()%>" class="card-img" alt="..." width="155px" height="155px" onclick="location.replace('<%=request.getContextPath()%>/trip/tripView.do?no=<%=t.getNo()%>')">
											<%} %>
			                           </div>
			                           <div class="d-flex card-body p-2">
			                           		<div style="width:150px;font-size:12px;">
												<p class="mb-0 tover"><%=t.getTitle() %></p>
												<%for(Like l:tripLike){%>
												<%if(t.getNo()==l.getNo()) {%>
													<span><%=l.getLikeCount() %></span>
												<%} }%>
											</div>
										</div>
									</div>
								</td>
							<%} %>
							</tr>
							<%if(trip.size()==4){ %>
							<tr>
								<td colspan="4" style="text-align: center;">
									<button class="btn" onclick="location.replace('<%=request.getContextPath()%>/myPage/myConTrip.do?userNo=<%=loginUser.getNo()%>')">+더보기</button>
								</td>
							</tr>
							<%} %>
						</table>
						<%}else{ %>
						<div style="text-align: center;">
							<span>등록된 여행기가 없습니다.</span>
						</div>
						<%} %>
					</div>
					
					<!-- 내 게시글 -->
					<div class="menu" style="padding-top:20px;">
						<div class="manuBar">
							<div>
								<span>내 게시글</span>
							</div>
							<div>
								<img class="imgDrop" src="<%=request.getContextPath() %>/images/drop.png">
							</div>
						</div>
						<hr>
					</div>
					<form action="<%=request.getContextPath()%>/mypage/myBoardDel.do" method="get">
						<input type="hidden" value="<%=loginUser.getNo() %>" name="userNo" id="userNo">
						<!-- 닫힘 내용 -->
						<div>
							<!-- 정보 -->
							<div id="myBDInfo">
								<div style="height:45px;">
									<span>총 <%=boardCount %>개의 게시글</span>
								</div>
								<%if(board.size()>0){ %>
								<div id="bdCk1">
									<button class="btn" type="button">선택삭제</button>
								</div>
								<div id="bdCk2">
									<label><input type="checkbox" id="bdAll">&nbsp;전체 선택</label>&nbsp;&nbsp;|&nbsp;&nbsp;
									<button class="btn" type="submit">삭제</button>&nbsp;&nbsp;|&nbsp;&nbsp;
									<button class="btn" type="button" id="bdEndBtn">돌아가기</button>
								</div>
								<%} %>
							</div>
							<!-- 게시글위치 -->
							<div>
							<%if(board.size()>0){%>
								<table id="bdTbl" class="table">
									<tr>
										<th style="width:50px;"></th>
										<th>글종류</th>
										<th>글제목</th>
										<th>작성시간</th>
										<th></th>
									</tr>
									<%for(Board b:board){ %>
									<tr>
										<td style="width:50px;">
											<div class="bdCk3">
												<input type="checkbox" class="bdCks" name="bdCks" value="<%=b.getNo()%>">
											</div>
										</td>
										<td style="width:100px;">
											<%=b.getCategory() %>
										</td>
										<td>
											<a class="tover" href="<%=request.getContextPath()%>/board/boardView.do?no=<%=b.getNo()%>"><%=b.getTitle() %></a>
										</td>
										<td style="width:150px;">
											<%=b.getWriteDate() %>
										</td>
										<td style="width:100px;">
											<button class="btn" type="button" onclick="location.replace('<%=request.getContextPath()%>/board/alterBoard.do?boardNo=<%=b.getNo()%>')">수정</button>
										</td>
									</tr>
								<%} %>
								</table>
								<%}else{  %>
								<div style="text-align: center;">
									<span>등록된 게시물이 없습니다.</span>
								</div>
								<%} %>
								<div class="d-flex justify-content-center">
									<%=boardPasing %>
								</div>
							</div>
						</div>
					</form>
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
	
	img{
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
    
    #myDNInfo,#myBDInfo,.manuBar{
    	display:flex;
    	justify-content: space-between;
    	margin-left: 40px;
    	margin-right: 40px;
    }

	#dnCk2,.dnCk3,#bdCk2,.bdCk3{
		display:none;
	}
	
	#myMenuBtn{
		text-align:center;
	}
	
	#myMenuBtn>#myCon{
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
	/* 다님길 */
	$(function(){
		$("#dnCk1>button").click(()=>{
			$("#dnCk1").css("display","none");
			$("#dnCk2").css("display","block");
			$(".dnCk3").css("display","block");
		});
		
		$("#dnEndBtn").click(()=>{
			$("#dnCk1").css("display","block");
			$("#dnCk2").css("display","none");
			$(".dnCk3").css("display","none");
		});
		
		$("#dnAll").click(()=>{
			if($("#dnAll").is(":checked")){							
				$(".dnCks").prop("checked",true);
			}else{
				$(".dnCks").prop("checked",false);
			}
		});
	});
	
	/* 게시글 */
	$(function(){
		$("#bdCk1>button").click(()=>{
			$("#bdCk1").css("display","none");
			$("#bdCk2").css("display","block");
			$(".bdCk3").css("display","block");
		});
		
		$("#bdEndBtn").click(()=>{
			$("#bdCk1").css("display","block");
			$("#bdCk2").css("display","none");
			$(".bdCk3").css("display","none");
		});
		
		$("#bdAll").click(()=>{
			if($("#bdAll").is(":checked")){							
				$(".bdCks").prop("checked",true);
			}else{
				$(".bdCks").prop("checked",false);
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
