<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.laon.trip.model.vo.Trip, java.util.*,com.laon.common.CommonKey, com.laon.etc.model.vo.*" %>
<%@ include file = "/views/common/header.jsp"%>
    <!--section-->
    <%
    	ArrayList<Trip> list = (ArrayList<Trip>)request.getAttribute(CommonKey.LIST);
    	String pageBar = (String)request.getAttribute(CommonKey.PAGE_BAR);
    	int totalItemCount= Integer.parseInt(request.getAttribute("totalItemCount").toString());
    	//사진 리스트 가져오기
    	ArrayList<Picture> pictureList = (ArrayList<Picture>)request.getAttribute("pictureList");
    	ArrayList<Like> likeList = (ArrayList<Like>)request.getAttribute("likeList");
    	System.out.println("jsp 페이지에서 likelist 잘 들어왓나?" + likeList);
    	//검색 태그 값
    	String keyword = (String)request.getAttribute("keyword");
    	System.out.println("jsp keyword : "+ keyword);
    	//여행 일정 / 후기 게시물에 따른 분기 처리
    	String category = (String)request.getAttribute("category");	//전체 여행기 select 값 가져오기
    	//지역 에 따른 분기  처리
    	String lo = (String)request.getAttribute("lo");
     %>
    <section>
    	<!--필터 버튼 눌렀을 때 데이터 처리-->
     	<input type="hidden" value="<%=category==null?"전체 여행기":category %>" id="category"/> <!-- category 저장 input 태그 -->
     	<input type="hidden" value="<%=keyword %>" id="keyword"/>
     	<input type="hidden" value="<%=lo==null?"선택 지역별":lo %>" id="location"/>     	
        <input type="hidden" value="aa" id="rl" />
        <!-- 검색창 -->
        <div class="container mb-5 mt-4">
            <div class="row justify-content-center">
                <div class="col-7 border border-secondary rounded d-flex flex-row justify-content-between p-0">
                    <div class="d-flex flex-row mr-2 dd">
                        <button class="btn btn-light border-0" id="btn-search" style="width:140px">키워드 검색</button>
                        <input type="text" placeholder="키워드로 검색하세요 :)" class="form-control border-0 ml-2" size="100" list="data" id="search"/>
                    </div>

                    <div>
                        <button id="cancel" class="btn btn-light border-0 ml-auto" onclick="searchCancel()">&times;</button>
                    </div>
                </div>
            </div>
        </div>

          <script>
            $(function(){   
            	$("#search").keyup(function(){
            		$.ajax({
            			url : '<%=request.getContextPath()%>/trip/datalist.do',
            			data : {search : $("#search").val()}, 
            			success : function(data){
            				let tags = data.split(",");	//배열로 저장
            				let da = ['1'];
            				let check = 0;
            				for(let i=0; i<tags.length; i++){
            					for(let j=0; j<da.length; j++){
            						if(da[j]==tags[i])
            							check=1;
            					}
            					if(check==0)
            						da.push(tags[i]);
            				}
            				console.log(da);
            				for(let i=0; i<da.length; i++){
            					let op = $("<option>").attr("value", da[i]).html(da[i]);
	    						if(i==0) $("#data").html(op);
	    						else $("#data").append(op);
            				}
            			}
            		});
            	});
            	
            	var key = $("#keyword").val();
            	console.log(key);
            	if(key!='null') $("#search").val(key);
            	//검색 버튼 클릭했을 때 검색한 값 쿼리스트링으로 전송
            	$("#btn-search").click(function(){      
                	var keyword = $("#search").val();                	
                    location.replace('<%=request.getContextPath()%>/trip/tripListView.do?keyword='+keyword);
                });
            	
            	//여행 category 드랍 다운 선택 시 서블릿 요청 필터 처리 
            	$("#plan-review").siblings("div").children().each(function(i,v){
                    $(this).click(function(){
                        var category = $(this).html();
                        var keyword = $("#keyword").val();
                        $("#plan-review").html(category);
                        location.replace('<%=request.getContextPath()%>/trip/tripListView.do?category='+category+'&keyword='+keyword);
                    })
                })
                
                //지역 lo 드랍 다운 선택 시 서블릿 요청 필터 처리
                $("#lo").siblings("div").children().each(function(i,v){
                    $(this).click(function(){
                    	var lo = $(this).html();
                        console.log(lo);
                    	var keyword = $("#keyword").val();
                        var category = $("#category").val();
                        $("#lo").html(lo);
                        location.replace('<%=request.getContextPath()%>/trip/tripListView.do?category='+category+'&keyword='+keyword+'&lo='+lo);
                    })
                })
                
                //여행 category 드랍다운 선택 시 선택 버튼 체인지
                var category = $("#category").val().trim();
            	console.log("여행 or 후기 : "+ category);
                $("#plan-review").html(category);
            	
                //lo 드랍다운 선택시 선택 버튼 체인지
                var lo = $("#location").val().trim();
                console.log(lo);
                $("#lo").html(lo);
                
                //최근순 버튼 클릭 시 정렬 최근순으로 정렬
                $("#recent").click(function(){
                	var keyword = $("#keyword").val();
                    var category = $("#category").val();
                    var lo = $("#location").val();
                	var recent = 'recent';
                	var like='null';
                	location.href="<%=request.getContextPath()%>/trip/tripListView.do?category="+category+"&keyword="+keyword+"&lo="+lo+"&recent="+recent+"&like="+like;
                });
                
                //좋아요 순 버튼 클릭시 정렬 많은 순으로 정렬
                $("#like").click(function(){
                	var keyword = $("#keyword").val();
                    var category = $("#category").val();
                    var lo = $("#location").val();
                    var recent ='null';
                	var like = 'like';
                	location.href="<%=request.getContextPath()%>/trip/tripListView.do?category="+category+"&keyword="+keyword+"&lo="+lo+"&recent="+recent+"&like="+like;
                });
            });
            
            //검색창 x 버튼 클릭시 클리어
            function searchCancel(){
                $("#cancel").click(function(){
                    console.log($("#search").val());
                    $("#search").val("");
                });
            }
			
  
            
            
            
            //데이터리스트에서 keyup 할때마다 태그 값들 가져오기 
        </script>



        <!--데이터리스트 작성-->
            <datalist id="data">

            </datalist>
        <!----------------------->
		<style>
			
		</style>
        <!-- 필터 / 작성 -->
        <div class="container">
           <div class="row justify-content-between" >
                <div class="d-flex flex-row">
                <div class="col-3  d-flex flex-row my-auto mr-5">              
               		<div class="dropdown">
 						<button class="btn btn-light dropdown-toggle border border-secondary rounded mr-3" type="button" id="plan-review" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   							전체여행기
 						</button>
 						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
   							<a class="dropdown-item" href="#">전체 여행기</a>
							<a class="dropdown-item" href="#">여행 일정</a>
							<a class="dropdown-item" href="#">여행 후기</a>
						</div>
					</div>	
				</div>					
						
   				<div class="col-3  d-flex flex-row my-auto">              
               		<div class="dropdown">
 						<button class="btn btn-light dropdown-toggle border border-secondary rounded mr-3" type="button" id="lo" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   							선택 지역별
 						</button>
 						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
   							<a class="dropdown-item" href="#">선택 지역별</a>
   							<a class="dropdown-item" href="#">서울</a>
							<a class="dropdown-item" href="#">부산</a>
							<a class="dropdown-item" href="#">대구</a>
							<a class="dropdown-item" href="#">인천</a>
							<a class="dropdown-item" href="#">광주</a>
							<a class="dropdown-item" href="#">대전</a>
							<a class="dropdown-item" href="#">울산</a>
							<a class="dropdown-item" href="#">세종</a>
						</div>
					</div>
                </div>
				</div>
				
                <div class="col-2 d-flex flex-row my-auto">
                    <button class="btn btn-lg btn-outline-secondary border-0" style="text-decoration: underline;" onclick="location.href('trip/wrtie')">다님길 작성 <i class="fas fa-edit fa-2x"></i></button> <!--클릭 했을 때 작성 서블릿으로-->
                    
                </div>
           </div>
        </div>

        <style>
            /* * {
                /*모든 요소 초기화*/
                border-collapse: collapse;
                margin: 0px;
                padding: 0px;
                text-decoration: none;
                color: black;
                list-style: none;
            } */

            /* div{
                border:1px solid black;
            } */

            /* .row{
                border:1px solid red;
            }

            .col-4{
                border:1px solid blue;
            }

            .col-3{
                border:1px solid blue;
            }

            h6{
                border:1px black solid; 
            } */
        </style>

        <!-- 전체 목록 개수 / 필터 -->
        <div class="container mt-4">
            <div class="row justify-content-between">
                <div class="col-4 d-flex align-items-center">
                    <h6 class="display-6 mt-2">총 <%=totalItemCount%>건의 여행기가 있습니다.</h6>
                </div>

                <div class="col-3 d-flex justify-content-end">
                    <button class="btn btn-mg btn-outline-secondary border-0" id="recent">최근순</button>  
                    <button class="btn btn-mg btn-outline-secondary border-0" id="like">좋아요순</button> 
                </div>
            </div>
        </div>

        <!-- <style>
            .container{
                border:1px solid black;
            }
        </style> -->

        <!-- 여행기 데이터 목록 / 카드-->
        <!-- 일의 자리 숫자가 5보다 작거나 같으면 첫번째로우에 그렇지 않으면 두번째 로우에 -->
        <!-- for each문 이용해서 데이터 넣음 -->
        <!-- 가져온 리스트의 데이터 개수에 따라 일의 자리숫자에 따라서 div태그 추가할지 안할지 결정 -->
        <!--  -->
        
        <div class="container mt-3 justify-content-center" style="height:640px;">
            <div class="row mb-2 h-50 row1">
            <%
            int size = list.size();
            int count = 0;
            if(size<5) count = size;
    		else count = 5;
            
            	for(int i=0; i<5; i++){      		
            %>
            <input type="hidden" value="<%=count %>" id="count1"/>
                <div class="col h-100 p-0 mr-2">
                    <div class="card h-100" >
                        <div class="card-header h-20 p-1 d-flex justify-content-between bg-white border-bottom-0">
                            <span class="ml-1"><%=i<count?list.get(i).getCategory():"" %></span>
                            
                            <span class="mr-1"><%=i<count?list.get(i).getWriteDate():"" %></span>
                        </div>
                        <div class="card-body h-50 w-100 p-0 border-0">
                            <img src="<%
                            String picture="";
                            for(int j=0; j<pictureList.size(); j++){ 
                            	if(i<count&&list.get(i).getNo()==pictureList.get(j).getTripNo()){
                            		picture = pictureList.get(j).getImage();
       								break; //break; 하면 처음 꺼만 안하면 마지막 꺼
                            	}
                            	//picture=pictureList.get(5).getImage(); //나중에 삭제 테스트용
                            }
                            %><%=request.getContextPath()+picture%>" class="img-thumbnail p-0 h-100 w-100 rounded-0 border-0"/>
                        </div>
                        <div class="card-footer h-30 d-flex flex-column p-1 text-center bg-white">
                            <span><%=i<count?list.get(i).getTitle():"" %></span>
                            <span>닉네임</span>
                            <div>
                                <span><i class="fas fa-thumbs-up"></i></span> <!--<i class="far fa-thumbs-up"></i>-->
                                <span>
                                	<%
                                	int likeCount = 0;
                                	for(int j=0; j<likeList.size(); j++){ 
                                		if(i<count&&list.get(i).getNo()==likeList.get(j).getTripNo())
                                			likeCount = likeList.get(j).getLikeCount();
                                	}
                                	%>
                                	<%=likeCount %>
                                </span>   <!--좋아요 수 가져오기 !!-->
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
                            <span class="ml-1"><%=i-5<count?list.get(i).getCategory():"" %></span>
                            
                            <span class="mr-1"><%=i-5<count?list.get(i).getWriteDate():"" %></span>
                        </div>
                        <div class="card-body h-50 w-100 p-0 border-0">
                             <img src="<%
                            String picture="";
                            for(int j=1; j<pictureList.size(); j++){ 
                            	if(i-5<count&&list.get(i).getNo()==pictureList.get(j).getTripNo()){
                            		picture = pictureList.get(j).getImage();
       								break; //break; 하면 처음 꺼만 안하면 마지막 꺼
                            	}
                            	//picture=pictureList.get(6).getImage(); //나중에 삭제 테스트용
                            }
                            %><%=request.getContextPath()+picture%>" class="img-thumbnail p-0 h-100 w-100 rounded-0 border-0"/>
                        </div>
                        <div class="card-footer h-30 d-flex flex-column p-1 text-center bg-white">
                            <span><%=i-5<count?list.get(i).getTitle():"" %></span>
                            <span>닉네임</span>
                            <div>
                                <span><i class="fas fa-thumbs-up"></i></span> <!--<i class="far fa-thumbs-up"></i>-->
                                <span>
									<%
                                	int likeCount = 0;
                                	for(int j=0; j<likeList.size(); j++){ 
                                		if(i-5<count&&list.get(i).getNo()==likeList.get(j).getTripNo())
                                			likeCount = likeList.get(j).getLikeCount();
                                	}
                                	%>
                                	<%=likeCount %>
								</span>   <!--좋아요 수 가져오기 !!-->
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

        <!--페이지 버튼-->
        <div class="container mt-3">
                <%=pageBar %>
        </div>

  
    </section>
    <style>
    	.card-body img{
                object-fit: cover;
            }
    </style>
  
<%@ include file = "/views/common/footer.jsp"%>
