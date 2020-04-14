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
					<!-- 내 다님길 -->
					<div class="menu">
						<div class="manuBar">
							<div>
								<span>내 다님길</span>
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
								<span>총 <%=tripCount %>개의 다님길</span>
							</div>
						</div>
						<!-- 게시글위치 -->
						<table id="dnTbl">
							<tr class="d-flex flex-wrap justify-content-center">
							<%for(TripMyCon t:trip){ %>
								<td class="p-1">
									<div class="card" style="width: 155px; height: 250px;" >
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
											     		<a class="dropdown-item" href="#">삭제</a>
											    	</div>
												</div>
											</div>
											<%if(t.getImage()==null){ %>
												<img src="<%=request.getContextPath() %>/images/images.jpeg" class="card-img" alt="..." width="155px" height="155px">
											<%}else{ %>
												<img src="<%=request.getContextPath() %>/views/picture/trip/<%=t.getImage()%>" class="card-img" alt="..." width="155px" height="155px">
											<%} %>
			                           </div>
			                           <div class="d-flex card-body p-2">
			                           		<div style="width:150px;font-size:12px;">
												<p class="mb-0"><%=t.getTitle() %></p>
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
					<!-- 닫힘 내용 -->
					<div>
						<!-- 정보 -->
						<div id="myBDInfo">
							<div>
								<span>총 <%=boardCount %>개의 게시글</span>
							</div>
							<div id="bdCk1">
								<button class="btn">선택삭제</button>
							</div>
							<div id="bdCk2">
								<label><input type="checkbox" id="bdAll">&nbsp;전체 선택</label>&nbsp;&nbsp;|&nbsp;&nbsp;
								<button class="btn" onclick="fnBoardDel();">삭제</button>&nbsp;&nbsp;|&nbsp;&nbsp;
								<button class="btn" id="bdEndBtn">돌아가기</button>
							</div>
						</div>
						<!-- 게시글위치 -->
						<div>
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
											<input type="checkbox" class="bdCks" name="bdCks">
										</div>
									</td>
									<td style="width:100px;">
										<%=b.getCategory() %>
									</td>
									<td>
										<a href="#"><%=b.getTitle() %></a>
									</td>
									<td style="width:150px;">
										<%=b.getWriteDate() %>
									</td>
									<td style="width:80px;">
										<button class="btn">수정</button>
									</td>
								</tr>
							<%} %>
							</table>
							<div>
								<%=boardPasing %>
							</div>
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
        border:1px solid green;
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
	
	#myMenuBtn>button{	
		width:150px;
		margin: 20px;
    	border-radius: 100px;
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