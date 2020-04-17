<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<!-- 관리자가 여행정보 입력하는 로직 -->
<!-- 만들 항목 -->
<!-- 카테고리:맛집숙소명소 중에 select
tag:선택
name:장소명이나 축제명, 숙소명
address:주소 입력
운영시간 
전화번호
홈페이지
네이버 링크
sns -->
<style>
table{
	text-align:center;
	margin-left:auto;
	margin-right:auto;
	margin-top:5%;
	
	}
</style>
<div style="height: 170px;"></div> 
<section class="d-flex flex-column justify-content-center align-items-center">
<aside>

<div>
<h4>관리자 페이지</h4>
<hr/>
<a href="">신고 리스트 관리</a>
<br/>
<a href="">여행정보 등록</a>
</div>

</aside>
<div>
<form action="" post="" method="post" enctype="multipart/form-data">
<table class="table table-bordered" style="width:1000px">
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
			<input type="text" class="form-control"  name="tripTag">
		</td>
	</tr>
	<tr>
		<td>
			장소명 또는 축제명
		</td>
		<td>
			<input type="text" class="form-control"  name="tripTitle">
		</td>
	</tr>
	<tr>
		<td>
			사진 첨부
		</td>
		<td>
			<input type="file" name="upfile">
		</td>
	<tr>
		<td>
			주소입력
		</td>
		<td>
			<input type="text"  class="form-control" name="tripAddress">
			<button class="btn btn-primary" >주소 찾기</button>
		</td>
		
	</tr>
	<tr>
		<td>
			운영시간
		</td>
		<td>
			<input type="text"  class="form-control" placeholder="예시)11:00 - 21:30" name="businessHour">
		</td>
	</tr>
	<tr>
		<td>
			전화번호
		</td>
		<td>
			<input type="text" class="form-control" name="tripTel" placeholder="(-포함)010-1234-5678">
		</td>
	</tr>
	<tr>
		<td>
			홈페이지
		</td>
		<td>
			<input type="text"  class="form-control" name="homePage">
		</td>
	</tr>
	<tr>
		<td>
			네이버 링크연결
		</td>
		<td>
			<input type="text"  class="form-control" name="naverLink" placeholder="https://store.naver.com/">
		</td>
	</tr>
	<tr>
		<td>
			SNS
		</td>
		<td>
			<input type="text"  class="form-control" name="snsLink">
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<button type="submit" class="btn btn-warning">등록 취소</button>
		<button type="submit" class="btn btn-primary">여행기 등록</button>
		</td>
	</tr>
</table>
</form>
</div>
</section>





<%@ include file="/views/common/footer.jsp"%> 