<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.laon.trip.model.vo.Trip,com.laon.board.model.vo.Board" %>
<%
	List<Trip> trip=(List)request.getAttribute("trip");
	int tripCount=(int)request.getAttribute("tripCount");
	String tripPasing=(String)request.getAttribute("tripPasing");
%>
<%@ include file="/views/common/header.jsp"%>
<div class="container">
	<div class="row">
	   	<div class="col-4">
			<%@ include file="/views/mypage/myPageAside.jsp" %>
		</div>
		<div class="col-8">
			<section>
				<div id="myMenuBtn">
					<button type="button" id="myCon" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageContent')">내 컨텐츠</button>
					<button type="button" id="myH" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageHeart')">내 마음함</button>
					<button type="button" id="myDh" class="btn btn-info">내 동행</button>
				</div>
				<div id="myPageView">
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
						<table id="dnTbl">
							<tr class="d-flex flex-wrap justify-content-center">
							<%for(Trip t:trip){ %>
								<td class="p-1">
									<div class="dnCk3" style="margin:10px;">
										<label style="width:130px;">
											<input type="checkbox" class="dnCks" value="<%=t.getNo()%>">
										</label>
									</div>
									<div class="card" style="width: 155px; height: 250px;" >
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
											      		<a class="dropdown-item" href="#">수정</a>
											     		<a class="dropdown-item" href="#">삭제</a>
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
								</td>
							<%} %>
							</tr>
						</table>
						<div>
							<%=tripPasing %>
						</div>
					</div>
				</div>
			</section>
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
    
    #myDNInfo,.manuBar{
    	display:flex;
    	justify-content: space-between;
    	margin-left: 40px;
    	margin-right: 40px;
    }

	#dnCk2,.dnCk3{
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