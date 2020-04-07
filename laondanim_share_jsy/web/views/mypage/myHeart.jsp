<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<div>
	<!-- 다님길 -->
	<div class="menu">
		<div class="manuBar">
			<div>
				<span>다님길</span>
			</div>
			<div>
				<img class="imgDrop" src="<%=request.getContextPath() %>/images/drop.png">
			</div>
		</div>
		<hr>
	</div>
	
	<!-- 다님길 목록 -->
	<div>
		<div id="myDNInfo">
			<div>
				<span>총 ?개의 ♥ 다님길</span>
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
		
		<div>
			<div id="gallery" class="carousel slide" data-ride="carousel" data-interval="false">
			
				<div class="carousel-inner">
					<div class="carousel-item active">
						<div class="row">
							<div>
								<img class="card-img-top"
									src="http://via.placeholder.com/800x450/caa8f5/ffffff?text=Image+1"
									alt="Image 1" />
							</div>

							<div>
								<img class="card-img-top"
									src="http://via.placeholder.com/800x450/9984d4/ffffff?text=Image+2"
									alt="Image 2" />
							</div>

							<div>
								<img class="card-img-top"
									src="http://via.placeholder.com/800x450/592e83/ffffff?text=Image+3"
									alt="Image 3" />
							</div>

							<div>
								<img class="card-img-top"
									src="http://via.placeholder.com/800x450/230c33/ffffff?text=Image+4"
									alt="Image 4" />
							</div>
						</div>
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
	
	<!-- 맛집 -->
	<div class="menu">
		<div class="manuBar">
			<div>
				<span>맛집</span>
			</div>
			<div>
				<img class="imgDrop" src="<%=request.getContextPath() %>/images/drop.png">
			</div>
		</div>
		<hr>
	</div>
	
	<!-- 맛집 목록 -->
	<div>
		<div id="myMGInfo">
			<div>
				<span>총 ?개의 ♥ 맛집</span>
			</div>
			<div id="mgCk1">
				<button class="btn">선택삭제</button>
			</div>
			<div id="mgCk2">
				<label><input type="checkbox" id="mgAll">&nbsp;전체 선택</label>&nbsp;&nbsp;|&nbsp;&nbsp;
				<button class="btn">삭제</button>&nbsp;&nbsp;|&nbsp;&nbsp;
				<button class="btn" id="dnEndBtn">돌아가기</button>
			</div>
		</div>
		
		<div>
			<div id="gallery" class="carousel slide" data-ride="carousel" data-interval="false">
			
				<div class="carousel-inner">
					<div class="carousel-item active">
						<div class="row">
							<div>
								<img class="card-img-top"
									src="http://via.placeholder.com/800x450/caa8f5/ffffff?text=Image+1"
									alt="Image 1" />
							</div>

							<div>
								<img class="card-img-top"
									src="http://via.placeholder.com/800x450/9984d4/ffffff?text=Image+2"
									alt="Image 2" />
							</div>

							<div>
								<img class="card-img-top"
									src="http://via.placeholder.com/800x450/592e83/ffffff?text=Image+3"
									alt="Image 3" />
							</div>

							<div>
								<img class="card-img-top"
									src="http://via.placeholder.com/800x450/230c33/ffffff?text=Image+4"
									alt="Image 4" />
							</div>
						</div>
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
    
    #myDNInfo,#myMGInfo,.manuBar{
    	display:flex;
    	justify-content: space-between;
    	margin-left: 40px;
    	margin-right: 40px;
    }

	#dnCk2,#dnCk3,#bdCk2,#bdCk3{
		display:none;
	}
	
	#gallery img{
		width:200px;
		height:200px;
		
	}
	
	.row{
        display: flex;
        justify-content: center;
    }
    
	.row div{
		padding:10px;
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