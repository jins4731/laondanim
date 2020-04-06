<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<div>
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
				<span>총 ?개의 다님길</span>
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
		<div>
			<table id="dnTbl">
				<tr>
					<td class="p-1">
						<div class="dnCk3" style="margin:10px;">
							<input type="checkbox" class="dnCks">
						</div>
						<div class="card" style="width: 235px; height: 350px;" >
                            <div class="d-flex justify-content-between p-2">
                                <span>다님후기</span>
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
                            <div class="d-flex card-body p-2" style="line-height: 22px;">
                            	<div>
                            		<img src="<%=request.getContextPath() %>/images/images.jpeg" width="50px" height="50px" style="border-radius: 70%">
                            	</div>
                            	<div style="width:150px;">
	                                <p class="mb-0">제목을 넣을 자리</p>
	                                <p class="mb-0">닉네임</p>
                                </div>
                            </div>
                        </div>
                    </td>
				</tr>
				<tr>
					<td colspan="3">
						<span>+ 더보기</span>
					</td>
				</tr>
			</table>
		</div>
	</div>
		
	<!-- 내 게시글 -->
	<div class="menu">
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
				<span>총 ?개의 게시글</span>
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
				<tr>
					<td style="width:50px;">
						<div class="bdCk3" style="margin:10px;width:30px;">
							<input type="checkbox" class="bdCks">
						</div>
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
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
    
    #myDNInfo,#myBDInfo,.manuBar{
    	display:flex;
    	justify-content: space-between;
    	margin-left: 40px;
    	margin-right: 40px;
    }
    
    #dnTbl,#bdTbl{
    	margin-left: 60px;
    	margin-right: 60px;
    }

	#dnCk2,.dnCk3,#bdCk2,.bdCk3{
		display:none;
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