<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside>
	<div>
		<!-- 프로필 -->
		<div class="card" style="width: 300px">
			<img class="card-img-top"
				src="<%=request.getContextPath() %>/images/images.jpeg"
				alt="Card image" style="width: 100%">
			<div class="card-body">
				<div id="myProfile">
					<div>
						<h4 class="card-title">아이디 자리</h4>
						<p class="card-text">닉네임 자리</p>
					</div>
					<div>
						<a href="#" class="btn btn-info">정보수정</a>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 알람 -->
		<div id="alram">
			<label>
				<img src="<%=request.getContextPath() %>/images/icon.png">
				<span>? 개의 알림이 있습니다.</span>
			</label>
		</div>
		
		<!-- 팁 -->
		<div class="alert alert-info tip">
			<div>
				<strong>TIP!</strong>
			</div>
			<div>
				<span>팁자리 ㅇㅇ</span>
			</div>
		</div>
	</div>
</aside>
<style>
	aside{
		width:320px;
	}
	
	*{
        border-collapse:collapse;
        margin:0px;
        padding:0px;
        text-decoration: none;
        color:black;
        list-style:none;
    }

	#myProfile{
		display:flex;
	}
	
	#myProfile>div:first-child{
		flex:8;
	}
	
	#myProfile>div:last-child{
		margin-top: 15px;
	}
	
	#alram{
		margin:20px;
	}
	
	.tip{
		display:inline-block;
		width:300px;
		height:150px;
	}
	
	.tip div{
		display:flex;
	}
	
	.tip div:last-child {
		height:100px;
		justify-content:center;
		align-items: center;
		
		
	}
}
</style>