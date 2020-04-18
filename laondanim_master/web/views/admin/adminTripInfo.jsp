<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<!-- 관리자가 여행정보 입력하는 로직 -->
<!-- 만들 항목 -->
<!-- 카테고리:맛집숙소명소 중에 select/tag:선택/name:장소명이나 축제명, 숙소명/address:주소 입력/운영시간 /전화번호/홈페이지/네이버 링크/sns -->
<style>
table{
	text-align:center;
	margin-left:auto;
	margin-right:auto;
	margin-top:5%;
	
	}
</style>
<script>

function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출.
	var pop = window.open("<%=request.getContextPath()%>/popup/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
}

function jusoCallBack(roadFullAddr){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.	
	/* 	var userAddr=$("#userAddr").val() 
		userAddr= roadFullAddr;	 */	
		console.log(roadFullAddr);
		console.log(typeof(roadFullAddr));
	$("#userAddr").val(roadFullAddr);
}

$("#cancelSubmit").click(function(){
	location.replace="/admin/tripInfo.do";
	
});

</script>
<div style='height: 170px;'></div>
<section class="d-flex flex-column justify-content-center align-items-center">

 <hr/>
    <div class="admin-header d-flex flex-column justify-content-center align-items-center">
        <h2>관리자 게시판</h2>
        <hr class="boder w-100">
    </div>
<div class="d-flex pr-2">

	<div class="ml-2 mr-5">
	<h4>카테고리</h4>
	<hr/>
	<a href="<%=request.getContextPath()%>/admin/adminView.do"><h5>신고 리스트 관리</h5></a>
	<br/>
	<a href="<%=request.getContextPath()%>/admin/tripInfo.do"><h5>여행정보 등록</h5></a>
	</div>

<table class="table table-bordered" style="width:1000px">
<form action="<%=request.getContextPath()%>/admin/tripInfoEnd.do" method="post" enctype="multipart/form-data" >
	<tr>
		<td colspan="2">
		<h3>여행정보 등록(관리자 전용)</h3>
		</td>
	</tr>
	<tr>
		<td>
		 	카테고리 선택
		</td>
		<td>
			<select class="form-control" name="trip-selector" id="trip-selector">
        		<option value="all" selected>유형선택</option><!-- 이거 선택하면 안되는데.. -->
        		<option value="맛집">맛집</option>
        		<option value="숙소">숙소</option>
        		<option value="명소">명소</option>
       	 	</select>
		</td>
	</tr>
	<tr>
		<td>
			태그 입력
		</td>
		<td>
			<input type="text" class="form-control"  name="tripTag" id="tripTag" placeholder="맛집탐방,힐링,">
		</td>
	</tr>
	<tr>
		<td>
			장소명 또는 축제명
		</td>
		<td>
			<input type="text" class="form-control"  name="tripTitle" id="tripTitle">
		</td>
	</tr>
	<tr>
		<td rowspan="3">
			사진 첨부
		</td>
		<td>
			<input type="file" name="upFile" id="upFile">
			
		</td>
	</tr>
	<tr>
		<td>
			<input type="file" name="upFile2" id="upFile2">
		</td>
	</tr>
	<tr>
		<td>
			<input type="file" name="upFile3" id="upFile3">
		</td>
	</tr>
	<tr>
		<td>
			주소입력
		</td>
		<td>
			<div class="d-flex justify-content-center align-items-center">
			<input type="text" id="userAddr" name="userAddr" class="form-control" placeholder="Enter Addr" required="true" readonly="true"
			style="width:550px;"/>
			<button type="button" class="btn btn-primary" onclick="goPopup();" >주소 찾기</button>
			</div>
		</td>
		
	</tr>
	<tr>
		<td>
			운영시간
		</td>
		<td>
			<input type="text"  class="form-control" placeholder="예시)11:00 - 21:30" id="businessHour" name="businessHour">
		</td>
	</tr>
	<tr>
		<td>
			전화번호
		</td>
		<td>
			<input type="text" class="form-control" id="tripTel" name="tripTel" placeholder="(-포함)010-1234-5678">
		</td>
	</tr>
	<tr>
		<td>
			홈페이지
		</td>
		<td>
			<input type="text"  class="form-control" id="homePage" name="homePage">
		</td>
	</tr>
	<tr>
		<td>
			네이버 링크연결
		</td>
		<td>
			<input type="text"  class="form-control" id="naverLink" name="naverLink" placeholder="https://store.naver.com/">
		</td>
	</tr>
	<tr>
		<td>
			SNS
		</td>
		<td>
			<input type="text"  class="form-control" id="snsLink" name="snsLink">
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<button  class="btn btn-warning" id="cancelSubmit">등록 취소</button>
		<button type="submit" class="btn btn-primary" >여행기 등록</button>
		</td>
	</tr>
</form> 
</table>

</div>
</section>





<%@ include file="/views/common/footer.jsp"%> 