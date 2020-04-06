<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.laon.trip.model.vo.Trip, java.util.*" %>
<%@ include file = "/views/common/header.jsp"%>
    <!--section-->
    <%
    	ArrayList<Trip> list = (ArrayList<Trip>)request.getAttribute("triplist");
    	System.out.println(list);
    	String pageBar = (String)request.getAttribute("pageBar");
    	int totalData= Integer.parseInt(request.getAttribute("totalData").toString());
    	
    	//여행 일정 / 후기 게시물에 따른 분기 처리
    	String category = (String)request.getAttribute("category");	//전체 여행기 select 값 가져오기
		if(category !=null){
	    	switch(category){
	    	case "plan":
	    		category = "여행 일정";
	    		break;
	    		
	    	case "review":
	    		category = "여행 후기";
	    		break;
	    	default:
	    		category = "전체 여행기";
	    		break;
	    	}
		}
     %>
    <section>
    	<!--필터 버튼 눌렀을 때 데이터 처리-->
     	<input type="hidden" value="<%=category==null?"전체 여행기":category %>" id="category"/> <!-- category 저장 input 태그 -->
     
        <!-- 검색창 -->
        <div class="container mb-5 mt-4">
            <div class="row justify-content-center">
                <div class="col-7 border border-secondary rounded d-flex flex-row justify-content-between p-0">
                    <div class="d-flex flex-row mr-2">
                        <button class="btn btn-light border-0" id="btn-search"><i class="fas fa-search"></i> 키워드 검색</button>
                        <input type="text" placeholder="키워드로 검색하세요 :)" class="form-control border-0 ml-2" size="100" id="search">
                    </div>

                    <div>
                        <button id="cancel" class="btn btn-light border-0 ml-auto" onclick="searchCancel()">&times;</button>
                    </div>
                </div>
            </div>
        </div>

          <script>
            $(function(){            
            	//검색 버튼 클릭했을 때 검색한 값 쿼리스트링으로 전송
            	$("#btn-search").click(function(){      
                	var keyword = $("#search").val();                	
                    location.replace('<%=request.getContextPath()%>/trip/list.do?keyword='+keyword);
                });
            	
            	//여행 category 드랍 다운 선택 시 서블릿 요청 필터 처리 
            	$("#plan-review").siblings("div").children().each(function(i,v){
                    $(this).click(function(){
                        var category = $(this).html();
                        $("#plan-review").html(category);
                        location.replace('<%=request.getContextPath()%>/trip/list.do?category='+category);
                    })
                })
                
                //여행 category 드랍다운 선택 시 선택 버튼 체인지
                var category = $("#category").val().trim();
                $("#plan-review").html(category);
            	
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
                <div class="col-3  d-flex flex-row my-auto">              
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
						
   

                    <!-- <select class="selectpicker border border-secondary w-50 rounded" data-style="bg-white" id="lo">
                        <option>전체 지역별</option>
                        <option value="seoul">서울</option>
                        <option value="pusan">부산</option>
                        <option value="daegu">대구</option>
                        <option value="incheon">인천</option>
                        <option value="gwangju">광주</option>
                        <option value="daejeon">대전</option>
                        <option value="ulsan">울산</option>
                        <option value="sejong">세종</option>
                    </select> -->
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
                    <h6 class="display-6 mt-2">총 <%=totalData%>건의 여행기가 있습니다.</h6>
                </div>

                <div class="col-3 d-flex justify-content-end">
                    <button class="btn btn-mg btn-outline-secondary border-0" id="recent">최근순</button>   <!--ajax 정렬-->
                    <button class="btn btn-mg btn-outline-secondary border-0" id="like">좋아요순</button> <!--ajax 정렬-->
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
        
        <div class="container mt-3 bg-white justify-content-center" style="height:640px;">
            <div class="row mb-2 h-50 row1">
            <%
            int size = list.size();
            int count = 0;
            if(size<5) count = size;
    		else count = 5;
            System.out.println("count : " + count);
            
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
                            <img src="plane-solid.svg" class="img-thumbnail p-0 h-100 rounded-0 border-0"/>
                        </div>
                        <div class="card-footer h-30 d-flex flex-column p-1 text-center bg-white">
                            <span><%=i<count?list.get(i).getTitle():"" %></span>
                            <span>닉네임</span>
                            <div>
                                <span><i class="fas fa-thumbs-up"></i></span> <!--<i class="far fa-thumbs-up"></i>-->
                                <span>2025</span>   <!--좋아요 수 가져오기 !!-->
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
        		console.log(col);
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
            System.out.println("count : " + count);
            
            	for(int i=0; i<5; i++){      		
            %>
            <input type="hidden" value="<%=count %>" id="count2"/>
                <div class="col h-100 p-0 mr-2">
                    <div class="card h-100" >
                        <div class="card-header h-20 p-1 d-flex justify-content-between bg-white border-bottom-0">
                            <span class="ml-1"><%=i<count?list.get(i).getCategory():"" %></span>
                            
                            <span class="mr-1"><%=i<count?list.get(i).getWriteDate():"" %></span>
                        </div>
                        <div class="card-body h-50 w-100 p-0 border-0">
                            <img src="plane-solid.svg" class="img-thumbnail p-0 h-100 rounded-0 border-0"/>
                        </div>
                        <div class="card-footer h-30 d-flex flex-column p-1 text-center bg-white">
                            <span><%=i<count?list.get(i).getTitle():"" %></span>
                            <span>닉네임</span>
                            <div>
                                <span><i class="fas fa-thumbs-up"></i></span> <!--<i class="far fa-thumbs-up"></i>-->
                                <span>2025</span>   <!--좋아요 수 가져오기 !!-->
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
    
  
<%@ include file = "/views/common/footer.jsp"%>
