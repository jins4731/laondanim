<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*,com.laon.tripinfo.model.vo.*,com.laon.user.model.vo.User"%>
<%
	List<TripInfoPicture> list = (List) request.getAttribute("list");
	List<Mind> heartCount = (List)request.getAttribute("heartCount");
	List<Mind> userMindList = (List)request.getAttribute("userMindList");
	List<Picture> pictureList = (List)request.getAttribute("pictureList");
	List<TripInfo> tripInfoList = (List)request.getAttribute("tripInfoList");
	List<Mind> mindList = (List)request.getAttribute("mindList");
	List<TripInfoComment> commentList = (List)request.getAttribute("commentList");
	

	//맛집 숙소 명소
	String category = request.getParameter("category");
			
	
   	//type(지역명, 상호명, 태그)에 따른 분기 처리
   	String type = (String)request.getAttribute("type");	//
  
	//검색 태그 값
   	String keyword = (String)request.getAttribute("keyword");
   	

	
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<%@ include file="/views/common/header.jsp"%>
<body>
<%
	int userNo = loginUser.getNo();
%>
	<section>
		<div class="container">
			<!------------------------------------------------검색창----------------------------------------------------->
			<input type="hidden" value="<%=type==null?"상호명":type %>" id="type"/> <!-- type 저장 input 태그 -->
     		<input type="hidden" value="<%=keyword %>" id="keyword"/>
     		
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
				})
			</script>
			
			<div class="d-flex flex-row justify-content-center">
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
						<script>
						$("#search-btn").click(function(){
							var type = $("#type-btn").html();
			            	var keyword = $("#search").val();
			            	
			            	location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%=category%>&type='+type+'&keyword='+keyword);
						})
			            	
			            
						</script>
					</div>
				</div>
			</div>
			<!--------------------------------------------------찜목록 버튼---------------------------------------------------->
			<div class="my-heart">
				<button type="button" class="btn" id="myHeart" >
					<img src="<%=request.getContextPath()%>/views/picture/icon/heart2.jpg" width="70px" height="70px">
				</button>
			</div>	
			<input type="hidden" id="userNo" value="<%=loginUser==null?"":userNo%>"/>
			<script>
			
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
			<!-----------------------------------------------카테고리 버튼---------------------------------------------------->
			<div class="category">
				<button type="button" id="cafe-button" class="btn btn-primary" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="맛집"%>&userNo=<%=loginUser==null?"":loginUser.getNo()%>')">
					맛집
				</button>
				<button type="button" id="room-button" class="btn btn-primary" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="숙소"%>&userNo=<%=loginUser==null?"":loginUser.getNo()%>')">
					숙소
				</button>
				<button type="button" id="attraction-button" class="btn btn-primary" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="명소"%>&userNo=<%=loginUser==null?"":loginUser.getNo()%>')">
					명소
				</button>
			</div>
			<!------------------------------------------------여행정보 카운팅---------------------------------------------------->
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
			</div>
			<!------------------------------------------------여행정보 리스트---------------------------------------------------->
			<div class="tripinfoList">
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
					%>
					<script>
						$(function(){
							$(".card-heart-button").click(function(e){
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
											const heartUp=$(e.target);
											const heartCount=$(".heartCount");
											if(heartUp.attr('src')=="<%=request.getContextPath()%>/views/picture/icon/heart1.jpg"){
												
												heartUp.attr('src','<%=request.getContextPath()%>/views/picture/icon/heart2.jpg');
												//+
												console.log("this");
												console.log(e.target);
												console.log($(e.target).parent());
												var plus = heartUp.parent().next().find("span").text();												
												heartUp.parent().next().find("span").text(parseInt(plus)+1);
											
											}else{	
												
												heartUp.attr('src','<%=request.getContextPath()%>/views/picture/icon/heart1.jpg');
												//-
												var minus = heartUp.parent().next().find("span").text();												
												heartUp.parent().next().find("span").text(parseInt(minus)-1);
											
											}
										}
									}
								});
							})							
						})
						
						
					</script>
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
			<%
				cnt2++;
			%>
				<div class="modal-dialog modal-xl">
					<div class="modal-content">


						<!--------------------------------------------상세페에지 해더------------------------------------------>
						<div class="modal-header tripinfo-header">
							<div class="tripinfo-title d-flex flex-wrap">
								<div class="modal-title" style="text-align:center;">
									<h4><%=tp.getTripinfoName()%></h4>
								</div>
								
								<div class="heart-no">
								<%for(Mind m : heartCount) { %>
										<%if(tp.getTripinfoNo()==m.getTripinfoNo()){  %>
										<span><img src="<%=request.getContextPath()%>/views/picture/icon/heart2.jpg" width="10px" height="10px"><%=m.getCount()%></span>
										
										<%}
										} %>				
							</div>
							</div>
							<div class="box002 d-flex">
					
								<div class="danimgil">
									<button class="btn btn-primary">관련 다님길 연결</button>
								</div>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
						</div>
						<div class="tripinfo-view-tag d-flex justify-content-center">
							<div class="tripinfo-tag">
								<span><%=tp.getTripinfoTag()%></span>
							</div>
						</div>

						<!-----------------------------------------상세페이지 바디---------------------------------------------->
						<div class="modal-body d-flex">
							<div id="demo" class="carousel slide " data-ride="carousel">

								<!-- Indicators -->
								<ul class="carousel-indicators">
									<li data-target="#demo" data-slide-to="0" class="active"></li>
									<li data-target="#demo" data-slide-to="1"></li>
									<li data-target="#demo" data-slide-to="2"></li>
								</ul>

								<!-----------------------------------슬라이드 사진-------------------------------------------->
								<div class="carousel-inner ">
									<div class="carousel-item active">
										<img
											src="<%=request.getContextPath()%>/views/picture/tripinfo/tripinfo(1).jpg"
											alt="성심당1" width="450px" height="250px">
									</div>
									<div class="carousel-item">
										<img
											src="<%=request.getContextPath()%>/views/picture/tripinfo/tripinfo(2).jpg"
											alt="성심당2" width="450px" height="250px">
									</div>
									<div class="carousel-item">
										<img
											src="<%=request.getContextPath()%>/views/picture/tripinfo/tripinfo(3).jpg"
											alt="성심당3" width="450px" height="250px">
									</div>
								</div>

								<!-- 왼쪽 오른쪽 -->
								<a class="carousel-control-prev" href="#demo" data-slide="prev">
									<span class="carousel-control-prev-icon"></span>
								</a> <a class="carousel-control-next" href="#demo" data-slide="next">
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
									<span>주소</span><br> <input class="test1234" id="test9999"
										type="text" value="<%=tp.getTripinfoAddress()%>" />
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
								<div class="tripinfo-map " id="test0000"
									style="width: 500px; height: 350px;"></div>
								<div class="tripinfo-comment" style="width:700px; height:350px; border:solid 1px red;">
									<div class="tripinfo-comment-title" style="height: 30px;">
										<span>한줄평</span>
									</div>
									<div class="tripinfo-comment-list">
										
									</div>
									<div class="tripinfo-comment-page d-flex"
										style="height: 50px; justify-content: center;"></div>

									<div class="tripinfo-comment-input" id="comment-container">
										<div class="comment-editor">
									
												<input type="hidden"  value="<%=tp.getTripinfoNo()%>"/>
												<input type="hidden" value="<%=loginUser==null?"":loginUser.getNo()%>"/>
												<input type="text"  placeholder="최대  20 글자" maxlength="20"/>
												<button type="button" class="btn-insert">등록</button>
										</div>
									</div>
								</div>
								</dvi>
							</div>

						</div>
					</div>
				</div>
				</div>
				<%
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
									content :  $(this).parent().find("input").eq(2).val()
									
								},
								
								success :data=>{
									console.log(data);
									let table=$("<table>");
									for(let i=0;i<data.lenth;i++){
										let tr=$("<tr>").append($("<td>").html(data[i]['userNo']))
											.append($("<td>")).html(data[])
									}
								}
							})
						})
					})
					
					
				</script>
			
	</section>

	<script>
//-----------------------------------------------지도 api----------------------------------------------------
var search = document.getElementById("test9999").value;
var mapContainer = document.getElementById('test0000'), // 지도를 표시할 div 
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
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});



	</script>


	<%@ include file="/views/common/footer.jsp"%>