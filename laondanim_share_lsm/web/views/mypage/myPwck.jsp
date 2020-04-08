<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<div class="d-flex flex-column justify-content-center align-items-center">
	<div class="d-flex flex-column justify-content-center align-items-center" id="pwCk">
		<div>
			<span>
				정보 수정을 위한 확인이 필요합니다.
			</span>
		</div>
		<div>
			<span>
				여기에 유효성체크
			</span>
		</div>
		
		<div>
			<input type="text" placeholder="비밀번호 입력" class="d-flex text-center border-0 p-2" style="width:380px;">
			<hr style="width:380px;">
		</div>
		
		<div class=" align-self-end mr-2">
			<input type="button" class="btn btn-info text-align" value="확인">
		</div>
	</div>
</div>

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
    
    #pwCk{
    	padding-top: 200px;
    }
</style>