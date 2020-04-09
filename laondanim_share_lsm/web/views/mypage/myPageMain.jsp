<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
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
			<button type="button" id="myCon" class="btn btn-info">내 컨텐츠</button>
			<button type="button" id="myH" class="btn btn-info">내 마음함</button>
			<button type="button" id="myDh" class="btn btn-info">내 동행</button>
		</div>
		<div id="myPageView"></div>
	</section>
	</div>
	</div>
</div>
<%@ include file="/views/common/footer.jsp"%>

<script>
	$(function(){
		$.ajax({
			url:"<%=request.getContextPath()%>/myPage/myPageContent",
			data:id="userId",
			dataType:"html",
			success:(data)=>{
				$("#myPageView").html(data);
			}
		});
		
		$("#myCon").click(()=>{
			$.ajax({
				url:"<%=request.getContextPath()%>/myPage/myPageContent",
				data:id="userId",
				dataType:"html",
				success:(data)=>{
					$("#myPageView").html(data);
				}
			});
		});
		
		$("#myH").click(()=>{
			$.ajax({
				url:"<%=request.getContextPath()%>/myPage/myPageHeart",
				data:id="userId",
				dataType:"html",
				success:(data)=>{
					$("#myPageView").html(data);
				}
			});
		});
		
		$("#myDh").click(()=>{
			$.ajax({
				url:"<%=request.getContextPath()%>/myPage/myPageDong",
				data:id="userId",
				dataType:"html",
				success:(data)=>{
					$("#myPageView").html(data);
				}
			});
		});
	});
</script>

<style>
	*{
        border-collapse:collapse;
        margin:0px;
        padding:0px;
        text-decoration: none;
        color:black;
        list-style:none;
		border:1px solid green;
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