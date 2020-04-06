<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<div>
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
			<div>
				<span>총 ?개의 동행</span>
			</div>
			<div id="dhCk1">
				<button class="btn">선택삭제</button>
			</div>
			<div id="dhCk2">
				<label><input type="checkbox" id="dhAll">&nbsp;전체 선택</label>&nbsp;&nbsp;|&nbsp;&nbsp;
				<button class="btn">삭제</button>&nbsp;&nbsp;|&nbsp;&nbsp;
				<button class="btn" id="dhEndBtn">돌아가기</button>
			</div>
		</div>
		<!-- 게시글위치 -->
		<div class="carousel slide" data-ride="carousel" data-interval="false">
			<div class="carousel-inner">
				<div class="carousel-item active d-flex justify-content-center" >
					<table id="dhTbl">
						<tr>
							<td class="p-1">
		                     	<div class="dhCk3" style="margin:10px;">
									<input type="checkbox" class="dhCks">
								</div>
		                        <div class="card" style="width: 235px; height: 415px;" >
		                            <div class="d-flex justify-content-between p-2">
		                                <span>모집여부</span>
		                                <span>2020-02-08</span>
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
		                            	<img src="<%=request.getContextPath() %>/images/images.jpeg" class="card-img" alt="..." width="235px" height="235px">
		                            </div>
		                            <div class="d-flex flex-column justify-content-center card-body p-2" style="line-height: 22px;">
		                                <p class="mb-0">제목을 넣을 자리</p>
		                                <ul class="p-0 m-0">
		                                    <li>동행지역 : <span>경상북도 경주시</span></li>
		                                    <li>기간 : <span>20-03-09 ~ 20-03-30</span></li>
		                                    <li>인원 : <span>6 / 7</span></li>
		                                </ul>
		                            </div>
		                        </div>
		                    </td>
						</tr>
					</table>
				</div>
				
				<a class="carousel-control-prev" href="#gallery" role="button" data-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="carousel-control-next" href="#gallery" role="button" data-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
				
			</div>
		</div>
	</div>
	
	<!-- 참여중인 동행 -->
	<div class="menu">
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
			<div>
				<span>총 ?개의 동행</span>
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
		<div class="carousel slide" data-ride="carousel" data-interval="false">
			<div class="carousel-inner">
				<div class="carousel-item active d-flex justify-content-center" >
					<table id="dhTbl">
						<tr>
							<td class="p-1">
		                     	<div class="jDhCk3" style="margin:10px;">
									<input type="checkbox" class="jDhCks">
								</div>
		                        <div class="card" style="width: 235px; height: 415px;" >
		                            <div class="d-flex justify-content-between p-2">
		                                <span>동행상태</span>
		                                <span>2020-02-08</span>
		                            </div>
		                            <div>
		                            	<div style="position: absolute;">
			                            	<div class="dropdown" style="position: relative;">
											    <button type="button" class="btn" data-toggle="dropdown">
											      ...
											    </button>
											    <div class="dropdown-menu">
											      <a class="dropdown-item" href="#">Link 1</a>
											      <a class="dropdown-item" href="#">Link 2</a>
											      <a class="dropdown-item" href="#">Link 3</a>
											    </div>
											</div>
		                            	</div>
		                            	<img src="<%=request.getContextPath() %>/images/images.jpeg" class="card-img" alt="..." width="235px" height="235px">
		                            </div>
		                            <div class="d-flex flex-column justify-content-center card-body p-2" style="line-height: 22px;">
		                                <p class="mb-0">제목을 넣을 자리</p>
		                                <ul class="p-0 m-0">
		                                    <li>동행지역 : <span>경상북도 경주시</span></li>
		                                    <li>기간 : <span>20-03-09 ~ 20-03-30</span></li>
		                                    <li>인원 : <span>6 / 7</span></li>
		                                </ul>
		                            </div>
		                        </div>
		                    </td>
						</tr>
					</table>
				</div>
				
				<a class="carousel-control-prev" href="#gallery" role="button" data-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="carousel-control-next" href="#gallery" role="button" data-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
				
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
        border:1px solid green;
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
	
	.carousel-control-prev-icon { background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M5.25 0l-4 4 4 4 1.5-1.5-2.5-2.5 2.5-2.5-1.5-1.5z'/%3E%3C/svg%3E"); }
	.carousel-control-next-icon { background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M2.75 0l-1.5 1.5 2.5 2.5-2.5 2.5 1.5 1.5 4-4-4-4z'/%3E%3C/svg%3E"); }
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
	
	/* 참여동행 */
	$(function(){
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