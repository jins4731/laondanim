<%@page import="com.sun.mail.handlers.image_gif"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*,com.laon.tripinfo.model.vo.*,com.laon.user.model.vo.User"%>
<%

	List<TripInfoPicture> list = (List) request.getAttribute("list");
	List<Mind> heartCount = (List)request.getAttribute("heartCount");
	List<Mind> userMindList = (List)request.getAttribute("userMindList");
	List<Picture> pictureList = (List)request.getAttribute("pictureList");
	List<TripInfo2> tripInfoList = (List)request.getAttribute("tripInfoList");
	List<Mind> mindList = (List)request.getAttribute("mindList");
	List<TripInfoComment> commentList = (List)request.getAttribute("commentList");


	//맛집 숙소 명소
	String category = request.getParameter("category");
   	//type(지역명, 상호명, 태그)에 따른 분기 처리
   	String type = (String)request.getAttribute("type");	// 
	//검색 태그 값
   	String keyword = (String)request.getAttribute("keyword");
   	
	String first = (String)request.getAttribute("first");
	first = first!=null?first:"";
%>
<style>
#myHeart {
	position: fixed;
	right: 50%;
	margin-right: -700px;
	margin-top: 300px;
	text-align: center;
}
.carousel, .slide {
	width: 600px;
	height: 300px;
} 


</style>
<link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css">
	<script src="https://unpkg.com/swiper/js/swiper.min.js"></script>
<%@ include file="/views/common/header.jsp"%>
<body>
<%
	int userNo = loginUser.getNo();
%>
<div style="height: 170px"></div>
	<section class="d-flex flex-column justify-content-center h-100">
		<div class="container">
			<!-- 필터 버튼 눌렀을 때 데이터 처리 -->
			<input type="hidden" value="<%=type==null?"상호명":type %>" id="type"/> <!-- type 저장 input 태그 -->
     		<input type="hidden" value="<%=keyword %>" id="keyword"/>
     		<input type="hidden" id="userNo" value="<%=loginUser==null?"":userNo%>"/>
     		  		
			<script>
				//선택 type 드랍 다운 선택 시 서블릿 요청 필터 처리 
				$(function(){
					$("#type-btn").siblings("div").children().each(function(i,v){
		                $(this).click(function(){
		                    var type = $(this).html();
		                    console.log(type);
		                    var keyword = $("#keyword").val();
		                    $("#type-btn").html(type);
		                  <%--   location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?type='+type+'&keyword='+keyword); --%>
		                })
		            })
						            		           
					//선택 드랍다운 선택 시 선택 버튼 체인지
		            var type = $("#type").val().trim();
		        	
		            $("#type-btn").html(type);		            		       		            	
		          		            
		            $("#mind").click(function(){
	                	var keyword = $("#keyword").val();
	                    var category = $("#category").val();
	                	var mind = 'mind';
	                	location.href="<%=request.getContextPath()%>/tripinfo/tripinfoMain?category="+category+"&keyword="+keyword+"&mind="+mind;
	                });
		            
		            $("#search-btn").click(function(){
						var type = $("#type-btn").html();
		            	var keyword = $("#search").val();
		            	
		            	location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%=category%>&type='+type+'&keyword='+keyword);
					})  
					
					//게시물의 찜 클릭시
					<%-- $(".ck").click(function(e){
      				$.ajax({
      					url:"<%=request.getContextPath()%>/trip/tripCheckLike.do",
      					data:{tripNo : $(this).parent().find("input").val()},
      					success:function(data){
      						//data : result 값
      						console.log("data : " + data);
      						if(data>0){
      							let src = $(e.target).parent().find("img").attr("src");
      							console.log("src = " + src);
      							console.log(e.target);
      							if(src == "<%=request.getContextPath()%>/views/picture/trip/likeChecked.png"){
      								$(e.target).attr("src", "<%=request.getContextPath()%>/views/picture/trip/likeUnchecked.png");
      								let minus = $(e.target).parent().parent().next().text().trim();
      								$(e.target).parent().parent().next().text(parseInt(minus)-1);
      							}else{
      								$(e.target).attr("src", "<%=request.getContextPath()%>/views/picture/trip/likeChecked.png");
      								let plus = $(e.target).parent().parent().next().text().trim();
      								$(e.target).parent().parent().next().text(parseInt(plus)+1);
      							}
      							console.log("html : " + $(e.target).parent().parent().next().text());     							
      						}				
      					}
      				});
      			}) --%>
      			
      				//게시물의 찜 클릭 시
					$(".ck").click(function(e){
						$.ajax({
							url : "<%=request.getContextPath()%>/tripinfo/tripinfoMind.do",
							data: {
								tripinfoNo : $(this).parent().find("input").eq(0).val(),
								category : $(this).parent().find("input").eq(1).val(),
								userNo : <%=loginUser==null?1:loginUser.getNo()%>
							},
							
							success : function(data){
								console.log(data);
								if(data>0){
									<%-- const heartUp=$(e.target);
									const heartCount=$(".heartCount");
									if(heartUp.attr('src')=="<%=request.getContextPath()%>/views/picture/icon/heart1.jpg"){
										
										heartUp.attr('src','<%=request.getContextPath()%>/views/picture/icon/heart2.jpg');
										//+
										console.log("this");
										console.log(e.target);
										console.log($(e.target).parent());
										var plus = heartUp.parent().next().find("span").text();												
										heartUp.parent().next().find("span").text(parseInt(plus)+1); 
									
	      							console.log("html : " + $(e.target).parent().parent().next().text());
									}else{	
										
										heartUp.attr('src','<%=request.getContextPath()%>/views/picture/icon/heart1.jpg');
										//-
										var minus = heartUp.parent().next().find("span").text();												
										heartUp.parent().next().find("span").text(parseInt(minus)-1);
									
									}--%>
									let src = $(e.target).parent().find("img").attr("src");
	      							console.log("src = " + src);
	      							console.log(e.target);
	      							if(src == "<%=request.getContextPath()%>/views/picture/icon/heart2.jpg"){
	      								$(e.target).attr("src", "<%=request.getContextPath()%>/views/picture/icon/heart1.jpg");
	      								let minus = $(e.target).parent().parent().next().text().trim();
	      								$(e.target).parent().parent().next().text(parseInt(minus)-1);
	      							}else{
	      								$(e.target).attr("src", "<%=request.getContextPath()%>/views/picture/icon/heart2.jpg");
	      								let plus = $(e.target).parent().parent().next().text().trim();
	      								$(e.target).parent().parent().next().text(parseInt(plus)+1);
	      							}
								}
							}
						});
					})							
						
				});
				
				//검색창 x 버튼 클릭시 클리어
				function searchCancel(){
	                $("#cancel").click(function(){
	                    console.log($("#search").val());
	                    $("#search").val("");
	                });
				}
			</script>
			
			<!-- 검색창 -->
			<div class="container mb-5 mt-4">
	            <div class="row justify-content-center">
	                <div class="col-8 border border-secondary rounded d-flex flex-row justify-content-between p-0">
	                    <div class="d-flex flex-row">
	                        <div class="dropdown">
		 						<button class="btn btn-light dropdown-toggle border border-secondary rounded mr-3" type="button" id="type-btn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		   							상호명
		 						</button>
		 						
		 						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
		   							<a class="dropdown-item" href="#">상호명</a>
		   							<a class="dropdown-item" href="#">지역명</a>							
									<a class="dropdown-item" href="#">태그명</a>
								</div>																						
							</div>	
	                    </div>
						
						<input type="text" placeholder="검색하세요 :)" class="form-control border-0 ml-2" size="100" list="data" id="search"/>	
						
	                    
	                    <button id="cancel" class="btn btn-light border-0 ml-auto" onclick="searchCancel()">&times;</button>
	                   	<input type="button" id="search-btn" class="btn btn-primary" value="검색"/>	        
	                </div>
	            </div>
        	</div>
			<!-- <div class="d-flex flex-row justify-content-center">
                <div class="d-flex flex-row my-auto mr-5">              
               		<div class="dropdown">
 						<button class="btn btn-light dropdown-toggle border border-secondary rounded mr-3" type="button" id="type-btn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   							상호명
 						</button>
 						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
   							<a class="dropdown-item" href="#">상호명</a>
   							<a class="dropdown-item" href="#">지역명</a>							
							<a class="dropdown-item" href="#">태그명</a>
						</div>
						
					</div>	
					<div>
						<input type="text" size="20" id="search"/>
					</div>
					<div>
						<input type="button" id="search-btn" class="btn btn-primary" value="검색"/>						
					</div>
				</div>
			</div> -->
  
			<!--------------------------------------------------찜목록 버튼---------------------------------------------------->
			<div class="my-heart">
				<button type="button" class="btn" id="myHeart" >
					<img src="<%=request.getContextPath()%>/views/picture/icon/heart2.jpg" width="70px" height="70px">
				</button>
			</div>	
					
			<script>
				//찜목록(하트) 클릭시 모달창 띄우기
				$(function(){
					
					var userNo = $("#userNo").val();
					
					$("#myHeart").click(function(e){
						
						$.ajax({
							url:"<%=request.getContextPath()%>/tripinfo/userMind.do?userNo="+userNo,
							type:"get",
							success:function(data){
								$("#myModal").html(data);
							}
						});
						
						$("#myModal").modal({
							remote : '<%=request.getContextPath()%>/views/tripinfo/myHeartModal.jsp'
						});	
					});	
				})
			</script>
			
			<!-- 카테고리 -->
			 <div class="container">
	           <div class="row justify-content-between" >
	                <div class="d-flex flex-row">
		                <div class="col category">              		        		
							<button type="button" id="cafe-button" class="btn btn-primary" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="맛집"%>&userNo=<%=loginUser==null?"":loginUser.getNo()%>&first=<%=first%>')">
								맛집
							</button>
						</div>
						
						<div class="col category">
							<button type="button" id="room-button" class="btn btn-primary" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="숙소"%>&userNo=<%=loginUser==null?"":loginUser.getNo()%>&first=<%=first%>')">
								숙소
							</button>
						</div>
							
						<div class="col category">
							<button type="button" id="attraction-button" class="btn btn-primary" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="명소"%>&userNo=<%=loginUser==null?"":loginUser.getNo()%>&first=<%=first%>')">
								명소
							</button>							
						</div>					
					</div>
	           </div>
	        </div>
			<!-----------------------------------------------카테고리 버튼---------------------------------------------------->
			<%-- <div class="category">
				<button type="button" id="cafe-button" class="btn btn-primary" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="맛집"%>&userNo=<%=loginUser==null?"":loginUser.getNo()%>')">
					맛집
				</button>
				<button type="button" id="room-button" class="btn btn-primary" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="숙소"%>&userNo=<%=loginUser==null?"":loginUser.getNo()%>')">
					숙소
				</button>
				<button type="button" id="attraction-button" class="btn btn-primary" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="명소"%>&userNo=<%=loginUser==null?"":loginUser.getNo()%>')">
					명소
				</button>
			</div> --%>
			
			<!-- 전체 목록 개수 / 필터 -->			
			<div class="container mt-4">
	            <div class="row justify-content-between">
	                <div class="col-4 d-flex align-items-center">
	                    <h6 class="display-6 mt-2">총 <%=request.getAttribute("totalData")%>건의 여행기가 있습니다.</h6>
	                </div>
	
	                <div class="col-3 d-flex justify-content-end">
	                    <button id="mind-btn" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%=category%>&mind=mind')">
							<span>마음 순</span>
						</button> 
	                </div>
	            </div>
	        </div>
        
		<%-- 	<!------------------------------------------------여행정보 카운팅---------------------------------------------------->
			<div class="box001 d-flex" style="justify-content: space-between;">
				<div class="msg001">
					<span>총 <%=request.getAttribute("totalData")%>건의 여행정보가 있습니다.
					</span>
				</div>
				
				<!-------------------------------------------------여행정보 정렬---------------------------------------------------->
				<div class="array">
					<button id="mind-btn" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%=category%>&mind=mind')">
						<span>마음 순</span>
					</button>
				</div>
			</div> --%> 
			
			<!--여행 정보 리스트-->
				 <div class="container mt-3 justify-content-center mb-5" style="height:640px;">
	            <div class="row mb-2 h-50 row1">
	            <%
	            int size = list.size();
	            int count = 0;
	            if(size<5) count = size;
	    		else count = 5;
	            int cnt=1;
	            	for(int i=0; i<5; i++){      		
	            %>
	            <input type="hidden" value="<%=count %>" id="count1"/>
	                <div class="col h-100 p-0 mr-2">
	                    <div class="card h-100" >
	                        <div class="card-header h-20 p-1 d-flex justify-content-between bg-white border-bottom-0">
	                            <span class="ml-1"><%=i<count?list.get(i).getTripinfoName():"" %></span>	                            	              
	                        </div>
	                       
	                        <div class="card-body h-50 w-100 p-0 border-0" data-toggle="modal" data-target="#mymodal<%=cnt++%>">
	                            <div class="hdTagBox">
	                                 <ul class="hdTag">                            
		                                <%if(i<count&&list.get(i).getTripinfoTag()!=null){
	                                   String[] tagArr = list.get(i).getTripinfoTag().split(",");   
	                                   for(String tag : tagArr){%>
	                                    <li><a>#<%=tag%></a></li>
	                                	<%} } %> 
		                            </ul>                              
	                            </div>  
	                            <img src="<%
	                            String picture="";
	                            for(int j=0; j<pictureList.size(); j++){ 
	                            	if(i<count&&list.get(i).getTripinfoNo()==pictureList.get(j).getTripinfoNo()){
	                            		picture = pictureList.get(j).getImage();
	       								break; //break; 하면 처음 꺼만 안하면 마지막 꺼
	                            	}
	                            	//picture=pictureList.get(5).getImage(); //나중에 삭제 테스트용
	                            }
	                            %><%=request.getContextPath()+"/views/picture/tripinfo/"+picture%>" class="img-thumbnail p-0 h-100 w-100 rounded-0 border-0" style="height:50%"/> 
	                                          
	                        </div>
	     <style>
	              
	           .card-body{
	               position: relative;
	           }
	   
	           .hdTagBox{
	               width: 100%;
	               height: 100%;
	               position: absolute;
	               background-color: rgba(0, 0, 0, 0.63);
	               display: flex;
	               justify-content: center;
	               align-items: center;
	               visibility: hidden;
	           }
	   
	           .hdTag{
	               width: 90%;
	               margin: 0px;
	               padding: 0px;
	               color: white;
	               /* border: 1px solid white; */
	               list-style: none;
	           }
	   
	           .hdTag li{
	               display: inline;
	               padding-right: 5px;
	           }
	   
	           .card-body:hover .hdTagBox{
	               visibility: visible;
	           }
	   
	           .hdTagBox:hover{
	           }
	       </style>
	                        <div class="card-footer h-30 d-flex flex-column p-1 text-center bg-white">                                                  
	                            <span class="location-info"><%
	                            	if(i<count){
	                            %>
	                            <%=list.get(i).getTripinfoAddress().indexOf("도") < 4 && list.get(i).getTripinfoAddress().indexOf("도") != -1
								? list.get(i).getTripinfoAddress().substring(list.get(i).getTripinfoAddress().indexOf("도") + 1,
										list.get(i).getTripinfoAddress().indexOf(" ", list.get(i).getTripinfoAddress().indexOf("도") + 2))
								: list.get(i).getTripinfoAddress().substring(0, list.get(i).getTripinfoAddress().indexOf(" "))%>
								<%
			                            	}else{
								%>
											""
								<%
			                            	}
								%>
						
								<span>
	                            <%
	                           		int loginNo = loginUser.getNo();	//로그인된 유저 아이디 
	                           		String mindCheck = "";
	                           	
	                           		for(Mind mind : mindList){
	                           			if(mind.getUserNo()==loginNo){
	                           				if(i<count&&mind.getTripinfoNo()==list.get(i).getTripinfoNo()){
	                           					mindCheck = mind.getCancled();	// 게시물에 대한 좋아요 체크 여부 'N' OR 'Y'
	                           				}
	                           			}
	                           		} 
	                           	
	                           %>
	                            
	                           <div class="d-flex flex-row justify-content-center align-items-center">
	                                <div class="mr-2">
	                                	<input type="hidden" value="<%=i<count?list.get(i).getTripinfoNo():""%>"/>
	                                	<input type="hidden" class='mind-category' name="mind-category" id="mind-category"								
										value="<%=request.getParameter("category") == null ? "" : request.getParameter("category")%>" />
	                                	<%
		                                	String src="";
		                                	
		                                	if(i<count&&mindCheck.equals("N")||mindCheck.equals("")){ 
		                                		src = request.getContextPath()+"/views/picture/icon/heart1.jpg";
		                                	}else{
		                                		src = request.getContextPath()+"/views/picture/icon/heart2.jpg";
		                                	}
	                                	%>                           
	                                	<button class="ck">
	                                		<img src="<%=src%>" class="like-ck" width="30px" height="30px">                                                           	                                	                 	                              
	                                	</button>                                                           	                                	                 	                              
	                                </div>
	                             
	                                <div>
										<%
	                                	int mindCount = 0;
	                                	for(int j=0; j<heartCount.size(); j++){ 
	                                		if(i<count&&list.get(i).getTripinfoNo()==heartCount.get(j).getTripinfoNo())
	                                			mindCount = heartCount.get(j).getCount();
	                                	}
	                                	%>
	                                	<%=mindCount %>
									</div>   <!--좋아요 수 가져오기 !!-->
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <%
	            		}
	                %>
	                 <script>
	        		var count=$("#count1").val();
	        		console.log("count : "+ count);
	        		var col = $(".row1>.col");
	        		if(count<5){
	        			for(let i=count; i<5; i++){
	        				$(col).eq(i).addClass("invisible");
	        			}
	        		}
	       		 </script>
	            </div>
	
	            <div class="row mb-2 h-50 row2">
	            <%
	           
	            if(size<10) count = size-5;
	    		else count = 5;
	            
	            	for(int i=5; i<10; i++){      		
	            %>
	            <input type="hidden" value="<%=count %>" id="count2"/>
	                <div class="col h-100 p-0 mr-2">
	                    <div class="card h-100" >
	                        <div class="card-header h-20 p-1 d-flex justify-content-between bg-white border-bottom-0">
	                            <span class="ml-1"><%=i-5<count?list.get(i).getTripinfoName():"" %></span>	                     
	                        </div>
	                        <div class="card-body h-50 w-100 p-0 border-0" data-toggle="modal" data-target="#mymodal<%=cnt++%>">
	                        	<div class="hdTagBox">
	                                <ul class="hdTag">                            
		                                <%if(i-5<count&&list.get(i).getTripinfoTag()!=null){
	                                   String[] tagArr = list.get(i).getTripinfoTag().split(",");   
	                                   for(String tag : tagArr){%>
	                                    <li><a>#<%=tag%></a></li>
	                                	<%} } %> 
		                            </ul>                               
	                            </div>
	                            
	                             <img src="<%
	                            String picture="";
	                            for(int j=1; j<pictureList.size(); j++){ 
	                            	if(i-5<count&&list.get(i).getTripinfoNo()==pictureList.get(j).getTripinfoNo()){
	                            		picture = pictureList.get(j).getImage();
	       								break; //break; 하면 처음 꺼만 안하면 마지막 꺼
	                            	}
	                            	//picture=pictureList.get(6).getImage(); //나중에 삭제 테스트용
	                            }
	                            %><%=request.getContextPath()+"/views/picture/tripinfo/"+picture%>" class="img-thumbnail p-0 h-100 w-100 rounded-0 border-0"/>
	                        </div>
	                        
	                        <div class="card-footer h-30 d-flex flex-column p-1 text-center bg-white">
	                            <span class="location-info">
	                            <%
	                            	if(i-5<count){
	                            %>
	                            <%=list.get(i).getTripinfoAddress().indexOf("도") < 4 && list.get(i).getTripinfoAddress().indexOf("도") != -1
						? list.get(i).getTripinfoAddress().substring(list.get(i).getTripinfoAddress().indexOf("도") + 1,
								list.get(i).getTripinfoAddress().indexOf(" ", list.get(i).getTripinfoAddress().indexOf("도") + 2))
						: list.get(i).getTripinfoAddress().substring(0, list.get(i).getTripinfoAddress().indexOf(" "))%>
						<%
	                            	}else{
						%>
									""
						<%
	                            	}
						%>
								<span>
							
	                            
	                           <%
	                           		int loginNo = loginUser.getNo();	//로그인된 유저 아이디 
	                           		
	                           		String mindCheck = "";
	                           		
	                           		for(Mind mind : mindList){                        			
	                           			if(mind.getUserNo()==loginNo){                  
	                           				if(i-5<count&&mind.getTripinfoNo()==list.get(i).getTripinfoNo()){
	                           					mindCheck = mind.getCancled();	// 게시물에 대한 좋아요 체크 여부 'N' OR 'Y'
	                           				}
	                           			}
	                           		}
	                           		
	                           %>
	                            <div class="d-flex flex-row justify-content-center align-items-center">
	                                <div class="mr-2">
	                                	<input type="hidden" value="<%=i-5<count?list.get(i).getTripinfoNo():""%>"/>	                             	
										<input type="hidden" class='mind-category' name="mind-category" id="mind-category"								
										value="<%=request.getParameter("category") == null ? "" : request.getParameter("category")%>" />
										
	                                	<%
	                                	String src="";
	                                	
	                                	if(i-5<count&&mindCheck.equals("N")||mindCheck.equals("")){ 
	                                		src = request.getContextPath()+"/views/picture/icon/heart1.jpg";
	                                	}else{
	                                		src = request.getContextPath()+"/views/picture/icon/heart2.jpg";
	                                	}
	                                	%>                           
	                                	<button class="ck">
	                                		<img src="<%=src%>" class="like-ck" width="30px" height="30px">                                                           	                                	                 	                              
	                                	</button>
	                                </div>
	                             
	                                <div>
										<%
	                                	int mindCount = 0;
	                                	for(int j=0; j<heartCount.size(); j++){ 
	                                		if(i-5<count&&list.get(i).getTripinfoNo()==heartCount.get(j).getTripinfoNo())
	                                			mindCount = heartCount.get(j).getCount();
	                                	}
	                                	%>
	                                	<%=mindCount %>
									</div>   <!--좋아요 수 가져오기 !!-->
	                            </div>
	                        </div>
	                    </div>
	                </div>
	               
	                <%
	            		}
	                %>
	                 <script>
	        		var count = $("#count2").val();
	        		console.log("count : "+ count);
	        		var col = $(".row2>.col");
	        		console.log(col);
	        		if(count<10){
	        			for(let i=count; i<5; i++){
	        				$(col).eq(i).addClass("invisible");
	        			}
	        		}
	       		 </script>
	            </div>
	      
	        </div> 
        
			<!------------------------------------------------여행정보 리스트---------------------------------------------------->
			<%-- <div class="tripinfoList">
				<div class="tripinfo-card-list d-flex flex-wrap"
					style="height: 700px;">
					<%
					int cnt=1;
						for (TripInfoPicture tp : list) {
						
					%>
					
					<div class="card"
						style="width: 221px; height: 350px; border-radius: 25px;">
						<div class="tripinfo-card-title d-flex"
							style="justify-content: center;">
							<span><%=tp.getTripinfoName()%></span>
						</div>
						
						<div class="img-wrapper" data-toggle="modal"
							data-target="#myModal<%=cnt%>">
							<%
								cnt++;
							%>
							<img src="<%=request.getContextPath()%><%=tp.getImage() %>"
								class="card-img-top" alt="..." width="250px" height="250px">
							<div class="darkness"></div>
							<div class="tag-plus">
								<span><%=tp.getTripinfoTag()%></span>
							</div>
						</div>
						<div class="card-body justify-content-between d-flex">

							<div class="tripinfo-card-location">
								<span class="location-info"><%=tp.getTripinfoAddress().indexOf("도") < 4 && tp.getTripinfoAddress().indexOf("도") != -1
						? tp.getTripinfoAddress().substring(tp.getTripinfoAddress().indexOf("도") + 1,
								tp.getTripinfoAddress().indexOf(" ", tp.getTripinfoAddress().indexOf("도") + 2))
						: tp.getTripinfoAddress().substring(0, tp.getTripinfoAddress().indexOf(" "))%><span>
							</div>
							<div class="tripinfo-card-heart d-flex">
								<div class="tripinfo-card-heartNo d-flex">
								
									<input type="hidden" id="mind-tripinfono" value="<%=tp.getTripinfoNo()%>"/>
									<input type="hidden" class='mind-category' name="mind-category" id="mind-category"								
									value="<%=request.getParameter("category") == null ? "" : request.getParameter("category")%>" />
									
									<%
									String cancled="";
									for(Mind m : mindList){
										if(userNo==m.getUserNo()){
											if(m.getTripinfoNo()==tp.getTripinfoNo()){
												
												cancled=m.getCancled();
											}
										}
									}
									System.out.println("이건?" + tp.getTripinfoNo());
									System.out.println("cancled = " + cancled);
									%>
									
									<button type="button"class="card-heart-button btn">
									<%if(cancled.equals("Y")){ %>
									<img class="card-heart-up"
												src="<%=request.getContextPath()%>/views/picture/icon/heart2.jpg"
												width="30px" height="30px">
									<%}else{ %>
									<img class="card-heart-up"
												src="<%=request.getContextPath()%>/views/picture/icon/heart1.jpg"
												width="30px" height="30px">
									<%} %>	
												</button>
									
									<div class="heartCount">
									<%for(Mind m : heartCount) { %>
										<%if(tp.getTripinfoNo()==m.getTripinfoNo()){  %>
										<span><%=m.getCount()%></span>
										
										<%}
										} %>
										
									</div>
								</div>
							</div>
						</div>
					</div>
					
					
					<%
					
						}
					%> --%>
					 
					
					
						
						
						
					 
				</div>
			</div>
			
			<!-------------------------------------------여행정보 리스트 페이징---------------------------------------------------->
			<div class="tripinfo-page d-flex" style="justify-content: center;">
				<%=request.getAttribute("pageBar")%>
			</div>
			<div class="modal fade" id="myModal" data-toggle="modal" data-target="#myModal">
			
			</div>
			
			<!------------------------------------------------상세 페이지-------------------------------------------------->
			
			<%
			int cnt2=1;
				for (TripInfoPicture tp: list) {
				
			%>
			
			
			<div class="modal fade" id="myModal<%=cnt2%>">
			
				<div class="modal-dialog modal-xl">
					<div class="modal-content">

<!-- 	<style>
	div{
		border:1px solid black;
	}
	</style> -->
						<!--------------------------------------------상세페에지 해더------------------------------------------>
						<div class="modal-header tripinfo-header pb-0">
							<div class="tripinfo-title d-flex d-block">
								<div class="modal-title mr-5" style="text-align:center;">
									<h4><%=tp.getTripinfoName()%></h4>																		
								</div>
								
								<%for(Mind m : heartCount) { %>
										<%if(tp.getTripinfoNo()==m.getTripinfoNo()){  %>
								<div>
									<img src="<%=request.getContextPath()%>/views/picture/icon/heart2.jpg" width="10px" height="10px">
									<%=m.getCount()%>
								</div>
										
									<%}
									} %>								
							</div>														
								
							<div class="box002 d-flex">					
								<div class="danimgil">
									<button class="btn btn-primary" onclick="location.replace('<%=request.getContextPath()%>/trip/tripListView.do?infoNo=<%=tp.getTripinfoNo()%>')">관련 여행기 연결</button>
								</div>
								
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
						</div>
						
						
						
						<div class="pl-3">
							<span><%=tp.getTripinfoAddress()%></span>
						</div>
						<div class="tripinfo-view-tag p-0">
							<ul	class="mt-1" style="list-style:none">
								<li class="d-flex">
									<%
										String tags = tp.getTripinfoTag();
										String[] tagArray = tags.split(",");
										
										for(String tag : tagArray){											
									%>
										<a>#<%=tag%>&nbsp;&nbsp;</a>
									<%
										}
									%>
								</li>
							</ul>
							<%-- <div class="tripinfo-tag">
								<span><%=tp.getTripinfoTag()%></span>
							</div> --%>
						</div>

						<!-----------------------------------------상세페이지 바디---------------------------------------------->
						<div class="modal-body d-flex" >
							<div id="demo" class="carousel slide " data-ride="carousel">

								<!-- Indicators -->
								<ul class="carousel-indicators">
									<li data-target="#demo" data-slide-to="0" class="active"></li>
									<li data-target="#demo" data-slide-to="1"></li>
									<li data-target="#demo" data-slide-to="2"></li>
								</ul>

								<!-----------------------------------슬라이드 사진-------------------------------------------->					
									<div class="carousel-inner">
									
									<%
											String[] image = new String [pictureList.size()];
											int i=0;
									
											for(Picture p : pictureList){
												if(p.getTripinfoNo()==tp.getTripinfoNo()){
													
														
													image[i] = p.getImage();
													i++;
													
												}
											}
									%>								
									
										<div class="carousel-item active" style="width:600px; height:300px">
											<img src="<%=request.getContextPath()%>/views/picture/tripinfo/<%=image[0]%>" alt="" class="img-thumbnail" width="100%" height="100%">																
										</div>
										<div class="carousel-item"style="width:600px; height:300px">
											<img src="<%=request.getContextPath()%>/views/picture/tripinfo/<%=image[1]%>" alt="" class="img-thumbnail" width="100%" height="100%">																
										</div>
										<div class="carousel-item"style="width:600px; height:300px">
											<img src="<%=request.getContextPath()%>/views/picture/tripinfo/<%=image[2]%>" alt="" class="img-thumbnail" width="100%" height="100%">																
										</div>
									</div>	
									
									
								

								<!-- 왼쪽 오른쪽 -->
								<a class="carousel-control-prev" href="#demo" data-slide="prev">
									<span class="carousel-control-prev-icon"></span>
								</a> 
								<a class="carousel-control-next" href="#demo" data-slide="next">
									<span class="carousel-control-next-icon"></span>
								</a>
							</div>
							
							<div class="cafe-information  " style="text-align: center;">
								<div class="tripinfo-time">
									<span>영업시간</span><br> <span><%=tp.getTripinfotime()%></span>
								</div>
								<hr>
								<div class="tripinfo-phone">
									<span>전화번호</span><br> <span><%=tp.getTripinfoNumber()%></span>
								</div>
								<hr>
								<div class="tripinfo-address">
									<span>주소</span><br> <input class="test1234" id="address<%=cnt2%>"
										type="text" value="<%=tp.getTripinfoAddress()%>" />
									<input type="hidden" value="<%=tp.getTripinfoName()%>" id="name<%=cnt2%>"/>
								</div>
								<hr>
								<!----------------------------------------------여행정보 링크-------------------------------------------->
								<div class="tripinfo-link">
									<a href="<%=tp.getTripinfoNaver()%>"> <img
										src="<%=request.getContextPath()%>/views/picture/icon/naver(1).png"
										alt="naver" width="30px" height="30px">
									</a> <a href="<%=tp.getTripinfoHomePage()%>"> <img
										src="<%=request.getContextPath()%>/views/picture/icon/naver(1).png"
										alt="naver" width="30px" height="30px">
									</a> <a href="<%=tp.getTripinfoSns()%>"> <img
										src="<%=request.getContextPath()%>/views/picture/icon/naver(1).png"
										alt="naver" width="30px" height="30px">
									</a>
								</div>
							</div>
						</div>
						<!-----------------------------------------------상세페이지 풋터----------------------------------------->
						<div class="modal-footer">
							<div class="d-flex" style="width: 100%;">
								<div class="tripinfo-map" id="test<%=cnt2%>"
									style="width: 500px; height: 350px;">
								</div>
						<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=603e034a0a0fb8c413b7624a370dd29b&libraries=services"></script>
						<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=603e034a0a0fb8c413b7624a370dd29b&libraries=LIBRARY"></script>		
						<!-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=603e034a0a0fb8c413b7624a370dd29b"></script> -->
							<!-- services 라이브러리 불러오기 -->
						
						<!-- 카카오 맵 api 추가 정호-->		
						
				
							<div class="tripinfo-comment" style="width:700px; height:350px; border:solid 1px red;">
									<div class="tripinfo-comment-title" style="height: 30px;">
										<span>한줄평</span>
									</div>
									<%-- <input type="hidden" value="<%=loginUser.getNickName() %>" id="nick"/> --%>
						
									<div class="tripinfo-comment-list">
										<table class="tripinfo-comment-table">
										<%
										for(TripInfoComment tc : commentList) { 
											if(tc.getTripinfoTbNo()==tp.getTripinfoNo()) {
										%>		
											<tr class="comment-tr">
												<td style="width:70px;"><span><%=loginUser==null?"":loginUser.getName()%></span></td>
												<td style="width:450px;"><span><%=tc.getContent()%></span></td>
												<td style="width:100px;"><span><%=tc.getWriteDate()%></span></td>
												<td style="width:50px;" class="comment-menu"><a href="#" data-toggle="popover" title="Popover Header" data-content="Some content inside the popover">...</a></td>
											</tr>				
										<%
											
												}
											}	
										%>
										
										</table>
									</div>
									<style>
										.comment-menu{
											display:none;
										}
										.comment-tr:hover .comment-menu{
											display:inline;
										}
									</style>
									
								<div class="tripinfo-comment-input" id="comment-container">
										<div class="comment-editor">									
											<input type="hidden"  value="<%=tp.getTripinfoNo()%>"/>
											<input type="hidden" value="<%=loginUser==null?"":loginUser.getNo()%>"/>
											<input type="hidden" value="<%=loginUser==null?"":loginUser.getNickName()%>"/>
											<input type="text"  placeholder="최대  30 글자" maxlength="30"/>
											<button type="button" class="btn-insert">등록</button>
										</div>
								</div>
									
							</div>
								 
								</div>
							</div>

						</div>
					</div>
				</div>
				
				<%
				
					cnt2++;
			
					}
				%>
				
				<script> 
				$(function(){
					$(".btn-insert").click(function(e){
						$.ajax({
							url : "<%=request.getContextPath()%>/tripinfo/insertComment.do",
							dataType:"json",
							type:"post",
							data : {
								//tripinfoNo : 1
								//userNo : 101
								//content:입력한 내용
								
								tripinfoNo :$(this).parent().find("input").eq(0).val(),
								userNo : $(this).parent().find("input").eq(1).val(),
								nickName : $(this).parent().find("input").eq(2).val(),	
								content :  $(this).parent().find("input").eq(3).val()
								
							},
							
							success :data=>{
								console.log(data);
								//let table=$("<table>");
								let tr=$("<tr class='comment-tr'>").append($("<td style='width:70px;'>").html(data["nickName"]))
										.append($("<td style='width:450px;'>").html(data["content"]))
										.append($("<td style='width:100px;'>").html("2020-04-17"))
										.append($("<td style='width:50px;'class='comment-menu'>").html("..."));
								//table.append(tr);
								console.log(tr);
								$(".tripinfo-comment-table").append(tr);
							},
							
							error:(r,e,m)=>{ 
								console.log(r);
								console.log(m);
							}
						})
					})
				})
				
	
				
					//팝 오버 
					$(document).ready(function(){
 					 $('[data-toggle="popover"]').popover();   
					});

				</script>
				
				<script>
							//-----------------------------------------------지도 api----------------------------------------------------
							//1
								$("#myModal1").on('shown.bs.modal', function(){									
									var search = document.getElementById("address1").value;
									console.log("address1");
									console.log(search);
									var mapContainer = document.getElementById("test1"), // 지도를 표시할 div 						
								    mapOption = {
								        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
								        level: 3 // 지도의 확대 레벨
								    };  
									
									// 지도를 생성합니다    
									var map = new kakao.maps.Map(mapContainer, mapOption); 
									
									// 주소-좌표 변환 객체를 생성합니다
									var geocoder = new kakao.maps.services.Geocoder();
									
									// 주소로 좌표를 검색합니다
									geocoder.addressSearch(search, function(result, status) {
									
									    // 정상적으로 검색이 완료됐으면 
									     if (status === kakao.maps.services.Status.OK) {
									
									        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
									
									        // 결과값으로 받은 위치를 마커로 표시합니다
									        var marker = new kakao.maps.Marker({
									            map: map,
									            position: coords
									        });
									
									        // 인포윈도우로 장소에 대한 설명을 표시합니다
									        var name = document.getElementById("name1").value;
									        var infowindow = new kakao.maps.InfoWindow({
									            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
									        });
									        infowindow.open(map, marker);
									
									        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
									        map.setCenter(coords);
									    } 
									});
									
								});	
							
							//2
							$("#myModal2").on('shown.bs.modal', function(){									
									var search = document.getElementById("address2").value;
									console.log("address2");
									console.log(search);
									var mapContainer = document.getElementById("test2"), // 지도를 표시할 div 						
								    mapOption = {
								        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
								        level: 3 // 지도의 확대 레벨
								    };  
									
									// 지도를 생성합니다    
									var map = new kakao.maps.Map(mapContainer, mapOption); 
									
									// 주소-좌표 변환 객체를 생성합니다
									var geocoder = new kakao.maps.services.Geocoder();
									
									// 주소로 좌표를 검색합니다
									geocoder.addressSearch(search, function(result, status) {
									
									    // 정상적으로 검색이 완료됐으면 
									     if (status === kakao.maps.services.Status.OK) {
									
									        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
									
									        // 결과값으로 받은 위치를 마커로 표시합니다
									        var marker = new kakao.maps.Marker({
									            map: map,
									            position: coords
									        });
									
									        // 인포윈도우로 장소에 대한 설명을 표시합니다
									        var name = document.getElementById("name2").value;
									        var infowindow = new kakao.maps.InfoWindow({
									            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
									        });
									        infowindow.open(map, marker);
									
									        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
									        map.setCenter(coords);
									    } 
									});
								});			
							//3
							$("#myModal3").on('shown.bs.modal', function(){									
									var search = document.getElementById("address3").value;
									console.log("address3");
									console.log(search);
									var mapContainer = document.getElementById("test3"), // 지도를 표시할 div 						
								    mapOption = {
								        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
								        level: 3 // 지도의 확대 레벨
								    };  
									
									// 지도를 생성합니다    
									var map = new kakao.maps.Map(mapContainer, mapOption); 
									
									// 주소-좌표 변환 객체를 생성합니다
									var geocoder = new kakao.maps.services.Geocoder();
									
									// 주소로 좌표를 검색합니다
									geocoder.addressSearch(search, function(result, status) {
									
									    // 정상적으로 검색이 완료됐으면 
									     if (status === kakao.maps.services.Status.OK) {
									
									        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
									
									        // 결과값으로 받은 위치를 마커로 표시합니다
									        var marker = new kakao.maps.Marker({
									            map: map,
									            position: coords
									        });
									
									        // 인포윈도우로 장소에 대한 설명을 표시합니다
									        var name = document.getElementById("name3").value;
									        var infowindow = new kakao.maps.InfoWindow({
									            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
									        });
									        infowindow.open(map, marker);
									
									        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
									        map.setCenter(coords);
									    } 
									});
								});			
							//4
								$("#myModal4").on('shown.bs.modal', function(){									
									var search = document.getElementById("address4").value;
									console.log("address4");
									console.log(search);
									var mapContainer = document.getElementById("test4"), // 지도를 표시할 div 						
								    mapOption = {
								        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
								        level: 3 // 지도의 확대 레벨
								    };  
									
									// 지도를 생성합니다    
									var map = new kakao.maps.Map(mapContainer, mapOption); 
									
									// 주소-좌표 변환 객체를 생성합니다
									var geocoder = new kakao.maps.services.Geocoder();
									
									// 주소로 좌표를 검색합니다
									geocoder.addressSearch(search, function(result, status) {
									
									    // 정상적으로 검색이 완료됐으면 
									     if (status === kakao.maps.services.Status.OK) {
									
									        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
									
									        // 결과값으로 받은 위치를 마커로 표시합니다
									        var marker = new kakao.maps.Marker({
									            map: map,
									            position: coords
									        });
									
									        // 인포윈도우로 장소에 대한 설명을 표시합니다
									        var name = document.getElementById("name4").value;
									        var infowindow = new kakao.maps.InfoWindow({
									            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
									        });
									        infowindow.open(map, marker);
									
									        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
									        map.setCenter(coords);
									    } 
									});
								});			
							//5
								$("#myModal5").on('shown.bs.modal', function(){									
									var search = document.getElementById("address5").value;
									console.log("address5");
									console.log(search);
									var mapContainer = document.getElementById("test5"), // 지도를 표시할 div 						
								    mapOption = {
								        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
								        level: 3 // 지도의 확대 레벨
								    };  
									
									// 지도를 생성합니다    
									var map = new kakao.maps.Map(mapContainer, mapOption); 
									
									// 주소-좌표 변환 객체를 생성합니다
									var geocoder = new kakao.maps.services.Geocoder();
									
									// 주소로 좌표를 검색합니다
									geocoder.addressSearch(search, function(result, status) {
									
									    // 정상적으로 검색이 완료됐으면 
									     if (status === kakao.maps.services.Status.OK) {
									
									        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
									
									        // 결과값으로 받은 위치를 마커로 표시합니다
									        var marker = new kakao.maps.Marker({
									            map: map,
									            position: coords
									        });
									
									        // 인포윈도우로 장소에 대한 설명을 표시합니다
									        var name = document.getElementById("name5").value;
									        var infowindow = new kakao.maps.InfoWindow({
									            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
									        });
									        infowindow.open(map, marker);
									
									        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
									        map.setCenter(coords);
									    } 
									});
								});			
							//6
								$("#myModal6").on('shown.bs.modal', function(){									
									var search = document.getElementById("address6").value;
									console.log("address6");
									console.log(search);
									var mapContainer = document.getElementById("test6"), // 지도를 표시할 div 						
								    mapOption = {
								        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
								        level: 3 // 지도의 확대 레벨
								    };  
									
									// 지도를 생성합니다    
									var map = new kakao.maps.Map(mapContainer, mapOption); 
									
									// 주소-좌표 변환 객체를 생성합니다
									var geocoder = new kakao.maps.services.Geocoder();
									
									// 주소로 좌표를 검색합니다
									geocoder.addressSearch(search, function(result, status) {
									
									    // 정상적으로 검색이 완료됐으면 
									     if (status === kakao.maps.services.Status.OK) {
									
									        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
									
									        // 결과값으로 받은 위치를 마커로 표시합니다
									        var marker = new kakao.maps.Marker({
									            map: map,
									            position: coords
									        });
									
									        // 인포윈도우로 장소에 대한 설명을 표시합니다
									        var name = document.getElementById("name6").value;
									        var infowindow = new kakao.maps.InfoWindow({
									            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
									        });
									        infowindow.open(map, marker);
									
									        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
									        map.setCenter(coords);
									    } 
									});
								});			
							//7
								$("#myModal7").on('shown.bs.modal', function(){									
									var search = document.getElementById("address7").value;
									console.log("address7");
									console.log(search);
									var mapContainer = document.getElementById("test7"), // 지도를 표시할 div 						
								    mapOption = {
								        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
								        level: 3 // 지도의 확대 레벨
								    };  
									
									// 지도를 생성합니다    
									var map = new kakao.maps.Map(mapContainer, mapOption); 
									
									// 주소-좌표 변환 객체를 생성합니다
									var geocoder = new kakao.maps.services.Geocoder();
									
									// 주소로 좌표를 검색합니다
									geocoder.addressSearch(search, function(result, status) {
									
									    // 정상적으로 검색이 완료됐으면 
									     if (status === kakao.maps.services.Status.OK) {
									
									        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
									
									        // 결과값으로 받은 위치를 마커로 표시합니다
									        var marker = new kakao.maps.Marker({
									            map: map,
									            position: coords
									        });
									
									        // 인포윈도우로 장소에 대한 설명을 표시합니다
									        var name = document.getElementById("name7").value;
									        var infowindow = new kakao.maps.InfoWindow({
									            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
									        });
									        infowindow.open(map, marker);
									
									        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
									        map.setCenter(coords);
									    } 
									});
								});			
							//8
								$("#myModal8").on('shown.bs.modal', function(){									
									var search = document.getElementById("address8").value;
									console.log("address8");
									console.log(search);
									var mapContainer = document.getElementById("test8"), // 지도를 표시할 div 						
								    mapOption = {
								        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
								        level: 3 // 지도의 확대 레벨
								    };  
									
									// 지도를 생성합니다    
									var map = new kakao.maps.Map(mapContainer, mapOption); 
									
									// 주소-좌표 변환 객체를 생성합니다
									var geocoder = new kakao.maps.services.Geocoder();
									
									// 주소로 좌표를 검색합니다
									geocoder.addressSearch(search, function(result, status) {
									
									    // 정상적으로 검색이 완료됐으면 
									     if (status === kakao.maps.services.Status.OK) {
									
									        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
									
									        // 결과값으로 받은 위치를 마커로 표시합니다
									        var marker = new kakao.maps.Marker({
									            map: map,
									            position: coords
									        });
									
									        // 인포윈도우로 장소에 대한 설명을 표시합니다
									        var name = document.getElementById("name8").value;
									        var infowindow = new kakao.maps.InfoWindow({
									            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
									        });
									        infowindow.open(map, marker);
									
									        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
									        map.setCenter(coords);
									    } 
									});
								});			
							//9
								$("#myModal1").on('shown.bs.modal', function(){									
									var search = document.getElementById("address9").value;
									console.log("address9");
									console.log(search);
									var mapContainer = document.getElementById("test9"), // 지도를 표시할 div 						
								    mapOption = {
								        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
								        level: 3 // 지도의 확대 레벨
								    };  
									
									// 지도를 생성합니다    
									var map = new kakao.maps.Map(mapContainer, mapOption); 
									
									// 주소-좌표 변환 객체를 생성합니다
									var geocoder = new kakao.maps.services.Geocoder();
									
									// 주소로 좌표를 검색합니다
									geocoder.addressSearch(search, function(result, status) {
									
									    // 정상적으로 검색이 완료됐으면 
									     if (status === kakao.maps.services.Status.OK) {
									
									        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
									
									        // 결과값으로 받은 위치를 마커로 표시합니다
									        var marker = new kakao.maps.Marker({
									            map: map,
									            position: coords
									        });
									
									        // 인포윈도우로 장소에 대한 설명을 표시합니다
									        var name = document.getElementById("name9").value;
									        var infowindow = new kakao.maps.InfoWindow({
									            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
									        });
									        infowindow.open(map, marker);
									
									        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
									        map.setCenter(coords);
									    } 
									});
								});			
							//10
							$("#myModal10").on('shown.bs.modal', function(){									
									var search = document.getElementById("address10").value;
									console.log("address10");
									console.log(search);
									var mapContainer = document.getElementById("test10"), // 지도를 표시할 div 						
								    mapOption = {
								        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
								        level: 3 // 지도의 확대 레벨
								    };  
									
									// 지도를 생성합니다    
									var map = new kakao.maps.Map(mapContainer, mapOption); 
									
									// 주소-좌표 변환 객체를 생성합니다
									var geocoder = new kakao.maps.services.Geocoder();
									
									// 주소로 좌표를 검색합니다
									geocoder.addressSearch(search, function(result, status) {
									
									    // 정상적으로 검색이 완료됐으면 
									     if (status === kakao.maps.services.Status.OK) {
									
									        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
									
									        // 결과값으로 받은 위치를 마커로 표시합니다
									        var marker = new kakao.maps.Marker({
									            map: map,
									            position: coords
									        });
									
									        // 인포윈도우로 장소에 대한 설명을 표시합니다
									        var name = document.getElementById("name10").value;
									        var infowindow = new kakao.maps.InfoWindow({
									            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
									        });
									        infowindow.open(map, marker);
									
									        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
									        map.setCenter(coords);
									    } 
									});
								});			
						</script>
				
			
	</section>




	<%@ include file="/views/common/footer.jsp"%>