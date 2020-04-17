<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
					<div class="d-flex flex-column justify-content-center align-items-center">
						<div class="d-flex flex-column justify-content-center align-items-center" id="pwCk" style="text-align:center;">
							<div style="margin:5px;">
								<span>
									정보 수정을 위한 확인이 필요합니다.
								</span>
							</div>
							<div id="pwCkView" style="width:380px;height:40px;"></div>
							<div style="margin:5px;">
								<input type="password" name="pw" id="pw" placeholder="비밀번호 입력" class="d-flex text-center border-0 p-2" style="width:380px;">
								<hr style="width:380px;">
							</div>
							
							<div class=" align-self-end mr-2">
								<button type="button" style="border-radius:100px;width:80px;" class="btn btn-info text-align" onclick="location.replace('<%=request.getContextPath()%>/myPage/myInfoUpdate.do?userNo=<%=loginUser.getNo()%>')">확인</button>
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
	*{
        border-collapse:collapse;
        margin:0px;
        padding:0px;
        text-decoration: none;
        color:black;
        list-style:none;
		/* border:1px solid green; */
    }
    
    #pwCk{
    	padding-top: 200px;
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
	$(function(){
		$("#pw").keyup(()=>{
			$.ajax({
				url:"<%=request.getContextPath()%>/myPage/myPwckEnd.do?userNo=<%=loginUser.getNo()%>",
				dataType:"json",
				data:{pw:$("#pw").val()},
				success:data=>{
					if(data==true){
						let ck=$("#pwCkView").attr("class","alert alert-success m-0 p-2 text-center").html("비밀번호가 일치합니다.");
					}else{
						let ck=$("#pwCkView").attr("class","alert alert-danger m-0 p-2 text-center").html("비밀번호가 일치하지 않습니다.");
					}
				}
			});
		});
	});
</script>