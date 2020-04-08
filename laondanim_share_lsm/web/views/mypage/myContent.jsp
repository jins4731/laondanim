<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.laon.trip.model.vo.Trip,com.laon.board.model.vo.Board" %>
<%
	List<Trip> trip=(List)request.getAttribute("trip");
	String tripPasing=(String)request.getAttribute("tripPasing");
	int tripCount=(int)request.getAttribute("tripCount");

	List<Board> board=(List)request.getAttribute("board");
	String boardPasing=(String)request.getAttribute("boardPasing");
	int boardCount=(int)request.getAttribute("boardCount");
%>
    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>



<%@ include file="/views/common/header.jsp"%>
<div class="container">
	<div class="row">
	   	<div class="col-4">
			<%@ include file="/views/mypage/myPageAside.jsp" %>
		</div>
	
	<div class="col-8">
		<section>
			<div id="myMenuBtn">
				<button type="button" id="myCon" class="btn btn-info">내 컨텐츠</button>
				<button type="button" id="myH" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageHeart')">내 마음함</button>
				<button type="button" id="myDh" class="btn btn-info">내 동행</button>
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
							<div>
								<span>총 <%=tripCount %>개의 다님길</span>
							</div>
							<div id="dnCk1">
								<button class="btn">선택삭제</button>
							</div>
							<div id="dnCk2">
								<label><input type="checkbox" id="dnAll">&nbsp;전체 선택</label>&nbsp;&nbsp;|&nbsp;&nbsp;
								<button class="btn">삭제</button>&nbsp;&nbsp;|&nbsp;&nbsp;
								<button class="btn" id="dnEndBtn">돌아가기</button>
							</div>
						</div>
						<!-- 게시글위치 -->
						<div class="carousel slide" data-ride="carousel" data-interval="false">
							<div class="carousel-inner">
								<div class="carousel-item active" >
									<table id="dnTbl">
										<tr>
										<%for(Trip t:trip){ %>
											<td class="p-1">
												<div class="dnCk3" style="margin:10px;">
													<input type="checkbox" class="dnCks" value="<%=t.getNo()%>">
												</div>
												<div class="card" style="width: 155px; height: 255px;" >
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
															      <a class="dropdown-item" href="#">신청서 수신함</a>
															      <a class="dropdown-item" href="#">모집 마감</a>
															      <a class="dropdown-item" href="#">동행 수정</a>
															      <a class="dropdown-item" href="#">동행 삭제</a>
															    </div>
															</div>
						                            	</div>
						                            	<img src="<%=request.getContextPath() %>/images/images.jpeg" class="card-img" alt="..." width="155px" height="155px">
						                            </div>
													<div class="d-flex card-body p-2">
														<div style="width:150px;font-size:12px;">
															<p class="mb-0"><%=t.getTitle() %></p>
															<span>좋아요</span>
														</div>
													</div>
												</div>
												<a class="carousel-control-prev" href="#gallery" role="button" data-slide="prev" style="width:30px;">
													<span class="carousel-control-prev-icon" aria-hidden="true"></span>
													<span class="sr-only">Previous</span>
												</a>
												<a class="carousel-control-next" href="#gallery" role="button" data-slide="next" style="width:30px;">
													<span class="carousel-control-next-icon" aria-hidden="true"></span>
													<span class="sr-only">Next</span>
												</a>
											</td>
										<%} %>
										</tr>
									</table>
									<%=tripPasing %>
								</div>
							</div>
						</div>
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
								<button class="btn">삭제</button>&nbsp;&nbsp;|&nbsp;&nbsp;
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
											<input type="checkbox" class="bdCks" style="width:10px;">
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
									<td style="width:50px;"></td>
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
    
    #dnTbl{
    	margin-left: 60px;
    	margin-right: 60px;
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
	
	.carousel-control-prev-icon { background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M5.25 0l-4 4 4 4 1.5-1.5-2.5-2.5 2.5-2.5-1.5-1.5z'/%3E%3C/svg%3E"); }
	.carousel-control-next-icon { background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M2.75 0l-1.5 1.5 2.5 2.5-2.5 2.5 1.5 1.5 4-4-4-4z'/%3E%3C/svg%3E"); }
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