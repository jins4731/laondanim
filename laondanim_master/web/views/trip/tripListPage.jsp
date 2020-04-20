<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.laon.trip.model.vo.Trip2, java.util.*,com.laon.common.CommonKey, com.laon.etc.model.vo.*" %>
<%@ include file = "/views/common/header.jsp"%>
    <!--section-->
    <%
       ArrayList<Trip2> list = (ArrayList<Trip2>)request.getAttribute(CommonKey.LIST);
       String pageBar = (String)request.getAttribute(CommonKey.PAGE_BAR);
       int totalItemCount= Integer.parseInt(request.getAttribute("totalItemCount").toString());
       //사진 리스트 가져오기
       ArrayList<Picture> pictureList = (ArrayList<Picture>)request.getAttribute("pictureList");
       ArrayList<Like> likeCountList = (ArrayList<Like>)request.getAttribute("likeCountList");
       ArrayList<User> userList = (ArrayList<User>)request.getAttribute("userList");
       ArrayList<Like> likeList = (ArrayList<Like>)request.getAttribute(CommonKey.LIKE_LIST);
       
       //검색 태그 값
       String keyword = (String)request.getAttribute("keyword");
       //여행 일정 / 후기 게시물에 따른 분기 처리
       String category = (String)request.getAttribute("category");   //전체 여행기 select 값 가져오기
       //지역 에 따른 분기  처리
       String lo = (String)request.getAttribute("lo");
       
     %>
          
    <div style="height: 170px;"></div>
     
    <section class="d-flex flex-column justify-content-center align-items-center">
       <!--필터 버튼 눌렀을 때 데이터 처리-->
        <input type="hidden" value="<%=category==null?"전체 여행기":category %>" id="category"/> <!-- category 저장 input 태그 -->
        <input type="hidden" value="<%=keyword %>" id="keyword"/>
        <input type="hidden" value="<%=lo==null?"선택 지역별":lo %>" id="location"/>        
        <input type="hidden" value="aa" id="rl" />
        
        <!-- 검색창 -->
        <!-- <div class="container mb-5 mt-4">
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
        </div> -->
		
		 <!--검색창-->
        <div class="d-flex justify-content-center align-items-center">
            <div id="searchDIV" class="d-flex justify-content-center align-items-center m-5">
                <select class="form-control border-0 rounded-0" name="searchFilter" id="searchFilter">
                    <!-- <option value="">전체 검색</option> -->
                    <option value="searchKeyword">태그 검색</option>                    
                </select>
                <input type="text" name="keyword" class="pl-2"  list="data" id="search" value=""/>
                
                <button id="btn-search">
                	<img src="<%=request.getContextPath()%>/images/inactiveSearch_icon.png" alt="searchIcon" id="searchIcon"/>
                </button>
            </div>
        </div>
        <!--검색창 스타일-->
        <style>
            #searchDIV{
                height: 45px;
                width: 450px;
                border: 3px solid #00abbf;
                background-color: #00abbf;
                border-radius: 30px;
                overflow: hidden;
            }
            #searchDIV select{
                width: 33%;
                height: 100%;
                background-color: #00abbf;
                color: white;
                padding-left: 20px;
                -webkit-appearance: none;
                background-image: url('<%=request.getContextPath()%>/images/down_icon.png');
                background-repeat: no-repeat;
                background-position: right center;
                /* background: ; */
            }
            #searchDIV input[type="text"]{
                width: 57%;
                height: 100%;
                border: none;
            }
            #searchDIV input[type="text"]:focus{
                outline: none;
            }
            #searchDIV button{
            	width: 10%;
            	height: 100%;
            	padding: 0px;
            	margin: 0px;
            	border: none;
            	background: white;
            }
            #searchDIV button:focus{
                outline: none;
            }       

			/* by 세현 */
			#searchFilterStyle .ldBtnC{
			    border-radius: 20px;
			    background-color: white;
			    border: 2px solid #00abbf;
			    color: #00abbf;
			    padding: 6px 15px 6px 15px;
			    width: 130px;
			}  
			.ldBtnC:hover,.ldBtnC:active {
			    color: white;
			    background-color: #00abbf;
			}   
			.ldBtnSubmit{
			    border-radius: 20px;
			    background-color: #00abbf;
			    border: 2px solid #00abbf;
			    color: white;
			    padding: 6px 15px 6px 15px;   
			}      
			.ldBtnF{
				background: none;
				color: #595959;
				font-weight: bolder;
				border: none;
			}              
        </style>
          <script>
            $(function(){   
               $("#search").keyup(function(){
                  $.ajax({
                     url : '<%=request.getContextPath()%>/trip/datalist.do',
                     data : {search : $("#search").val()}, 
                     success : function(data){
                        let tags = data.split(",");   //배열로 저장
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
                        //var keyword = $("#keyword").val();
                        var keyword = $("#search").val();
                        console.log("몬데");
                        console.log(keyword);
                        $("#plan-review").html(category);
                        location.replace('<%=request.getContextPath()%>/trip/tripListView.do?category='+category+'&keyword='+keyword);
                    })
                })
                
                //지역 lo 드랍 다운 선택 시 서블릿 요청 필터 처리
                $("#lo").siblings("div").children().each(function(i,v){
                    $(this).click(function(){
                       var lo = $(this).html();
                        console.log(lo);
                       //var keyword = $("#keyword").val();
                       var keyword = $("#search").val();
                       
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
                   //var keyword = $("#keyword").val();
                   var keyword = $("#search").val();
                    var category = $("#category").val();
                    var lo = $("#location").val();
                   var recent = 'recent';
                   var like='null';
                   location.href="<%=request.getContextPath()%>/trip/tripListView.do?category="+category+"&keyword="+keyword+"&lo="+lo+"&recent="+recent+"&like="+like;
                });
                
                //좋아요 순 버튼 클릭시 정렬 많은 순으로 정렬
                $("#like").click(function(){
                   //var keyword = $("#keyword").val();
                   var keyword = $("#search").val();
                    var category = $("#category").val();
                    var lo = $("#location").val();
                    var recent ='null';
                   var like = 'like';
                   location.href="<%=request.getContextPath()%>/trip/tripListView.do?category="+category+"&keyword="+keyword+"&lo="+lo+"&recent="+recent+"&like="+like;
                });
               
                //좋아요 아이콘 클릭시 up & down 
                $(".ck").click(function(e){
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
               })
            });
            
            //검색창 x 버튼 클릭시 클리어
            function searchCancel(){
                $("#cancel").click(function(){
                    console.log($("#search").val());
                    $("#search").val("");
                    $("#keyword").val("null");
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
        <div class="container" id="searchFilterStyle">
           <div class="row justify-content-between" >
                <div class="d-flex flex-row">
                <div class="col-3  d-flex flex-row my-auto mr-5">              
                     <div class="dropdown">
                   <button class="ldBtnC dropdown-toggle mr-3" type="button" id="plan-review" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                   <button class="dropdown-toggle mr-3 ldBtnC" type="button" id="lo" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
            
            <div class="col-3 d-flex flex-row my-auto">
                 <button id="tWriteBtn" style="display:inline" class="d-flex align-items-end justify-content-center mt-3 mb-3 btn btn-lg" style="text-decoration: underline;" onclick="location.replace('<%=request.getContextPath()%>/trip/tripInsertView.do?no=<%=loginUser.getNo()%>')">                   
                 	 <p class="m-0">여행기 작성</p> 
                 	 <img src="<%=request.getContextPath()%>/images/write_icon.png" class="ml-2 w-25">
                 </button>                                                               
             </div>
          		<style>
            #tWriteBtn{
                width: 500px;
                border-radius: 0px;
                border-top: none;
                border-left: none;
                border-right: none;
                border-bottom: 3px solid #595959;
            }
        </style>
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
        <div class="container mt-4 mb-3">
            <div class="row justify-content-between align-items-center">
                <div class="col-4 d-flex align-items-center">
                    <h6 class="display-6 mt-2">총 <%=totalItemCount%>건의 여행기가 있습니다.</h6>
                </div>

                <div class="col-3 d-flex justify-content-end">
                    <button class="ldBtnF border-0 mr-2" id="recent">최근순</button>  
                    <button class="ldBtnF border-0 " id="like">좋아요순</button> 
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
                       <%
                       	int no = 0;
                       if(i<count){
                    	   no=list.get(i).getNo();
                    	   
                       }
                       %>
                        <div class="card-body h-50 w-100 p-0 border-0">
                        <%if(i<count && list.get(i).getDeleted()=='N'){ %>
                            <div class="hdTagBox" onclick="location.replace('<%=request.getContextPath()%>/trip/tripView.do?no=<%=i<count?list.get(i).getNo():""%>')">
                                 <ul class="hdTag">                            
                                   <%if(i<count&&list.get(i).getTag()!=null){
                                   String[] tagArr = list.get(i).getTag().split(",");   
                                   for(String tag : tagArr){%>
                                    <li><a>#<%=tag%></a></li>
                                   <%} } %> 
                               </ul>                              
                            </div>  
                            <%}else{ %>
                            <div class="hdTagBox" onclick="">
                                 <ul class="hdTag">                            
                                   
                                    <li><a>삭제된 게시물 입니다.</a></li>
                                   
                               </ul>                              
                            </div> 
                            <%} %>
                            <img src="<%
                            String picture="";
                            for(int j=0; j<pictureList.size(); j++){ 
                               if(i<count&&list.get(i).getNo()==pictureList.get(j).getTripNo()){
                                  picture = pictureList.get(j).getImage();
                               break; //break; 하면 처음 꺼만 안하면 마지막 꺼
                               }
                               //picture=pictureList.get(5).getImage(); //나중에 삭제 테스트용
                            }
                            %><%=request.getContextPath()+"/views/picture/trip/"+picture%>" class="img-thumbnail p-0 h-100 w-100 rounded-0 border-0" style="height:50%"/> 
                                          
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
           .card-footer .ck{
     			border : none;
     			background: none;      
           }
       </style>
                        <div class="card-footer h-30 d-flex flex-column p-1 text-center bg-white">
                            <span><%=i<count?list.get(i).getTitle():"" %></span>
                            <span>
                               <%
                               String userNick = "";
                                  for(User u : userList){
                                     if(i<count && list.get(i).getUserTbNo()==u.getNo()){
                                        userNick = u.getNickName();
                                        break;
                                     }
                                  }
                               %>
                               <%=userNick %>
                            </span>
                            
                            <%
                                 int loginNo = loginUser.getNo();   //로그인된 유저 아이디 
                                 String likeCheck = "";
                                 for(Like like : likeList){
                                    if(like.getUserNo()==loginNo){
                                       if(i<count&&like.getTripNo()==list.get(i).getNo()){
                                          likeCheck = like.getCancled();   // 게시물에 대한 좋아요 체크 여부 'N' OR 'Y'
                                       }
                                    }
                                 } 
                           %>
                            
                           <div class="d-flex flex-row justify-content-center align-items-center">
                                <div class="mr-2">
                                   <input type="hidden" value="<%=i<count?list.get(i).getNo():""%>"/>
                                   <%
                                   String src="";
                                   
                                   if(i<count&&likeCheck.equals("N")||likeCheck.equals("")){ 
                                      src = request.getContextPath()+"/views/picture/trip/likeUnchecked.png";
                                   }else{
                                      src = request.getContextPath()+"/views/picture/trip/likeChecked.png";
                                   }
                                   %>                           
                                   <button class="ck">
                                      <img src="<%=src%>" class="like-ck" width="30px" height="30px">                                                                                                                                                   
                                   </button>                                                                                                                                                   
                                </div>
                             
                                <div>
                           <%
                                   int likeCount = 0;
                                   for(int j=0; j<likeCountList.size(); j++){ 
                                      if(i<count&&list.get(i).getNo()==likeCountList.get(j).getTripNo())
                                         likeCount = likeCountList.get(j).getLikeCount();
                                   }
                                   %>
                                   <%=likeCount %>
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
                            <span class="ml-1"><%=i-5<count?list.get(i).getCategory():"" %></span>
                            
                            <span class="mr-1"><%=i-5<count?list.get(i).getWriteDate():"" %></span>
                        </div>
                        
                        <div class="card-body h-50 w-100 p-0 border-0">
                           <%if(i-5<count&&list.get(i).getDeleted()=='N'){ %>
                           <div class="hdTagBox" onclick="location.replace('<%=request.getContextPath()%>/trip/tripView.do?no=<%=i-5<count?list.get(i).getNo():""%>')">
                                <ul class="hdTag">                            
                                   <%if(i-5<count&&list.get(i).getTag()!=null){
                                   String[] tagArr = list.get(i).getTag().split(",");   
                                   for(String tag : tagArr){%>
                                    <li><a>#<%=tag%></a></li>
                                   <%} } %> 
                               </ul>                               
                            </div>
                            <%}else{ %>
                            <div class="hdTagBox" onclick="">
                                 <ul class="hdTag">                            
                                   
                                    <li><a>삭제된 게시물 입니다.</a></li>
                                   
                               </ul>                              
                            </div> 
                            <%} %>
                             <img src="<%
                            String picture="";
                            for(int j=1; j<pictureList.size(); j++){ 
                               if(i-5<count&&list.get(i).getNo()==pictureList.get(j).getTripNo()){
                                  picture = pictureList.get(j).getImage();
                               break; //break; 하면 처음 꺼만 안하면 마지막 꺼
                               }
                               //picture=pictureList.get(6).getImage(); //나중에 삭제 테스트용
                            }
                            %><%=request.getContextPath()+"/views/picture/trip/"+picture%>" class="img-thumbnail p-0 h-100 w-100 rounded-0 border-0"/>
                        </div>
                        
                        <div class="card-footer h-30 d-flex flex-column p-1 text-center bg-white">
                            <span><%=i-5<count?list.get(i).getTitle():"" %></span>
                            <span>
                               <%
                               String userNick = "";
                            
                                  for(User u : userList){
                                     if(i-5<count && list.get(i).getUserTbNo()==u.getNo()){
                                        userNick = u.getNickName();
                                     }
                                  }
                               %>
                               <%=userNick%>
                            </span>
                           <%
                                 int loginNo = loginUser.getNo();   //로그인된 유저 아이디 
                                 
                                 String likeCheck = "";
                                 
                                 for(Like like : likeList){                                 
                                    if(like.getUserNo()==loginNo){                  
                                       if(i-5<count&&like.getTripNo()==list.get(i).getNo()){
                                          likeCheck = like.getCancled();   // 게시물에 대한 좋아요 체크 여부 'N' OR 'Y'
                                       }
                                    }
                                 }
                           %>
                           
                            <div class="d-flex flex-row justify-content-center align-items-center">
                                <div class="mr-2">
                                   <input type="hidden" value="<%=i-5<count?list.get(i).getNo():""%>"/>
                                   <%
                                   String src="";
                                   if(i-5<count&&likeCheck.equals("N")||likeCheck.equals("")){ 
                                      src = request.getContextPath()+"/views/picture/trip/likeUnchecked.png";
                                   }else{
                                      src = request.getContextPath()+"/views/picture/trip/likeChecked.png";
                                   }
                                   %>                           
                                   <button class="ck">
                                      <img src="<%=src%>" class="like-ck" width="30px" height="30px">                                                                                                                                                   
                                   </button>
                                </div>
                             
                                <div>
                           <%
                                   int likeCount = 0;
                                   for(int j=0; j<likeCountList.size(); j++){ 
                                      if(i-5<count&&list.get(i).getNo()==likeCountList.get(j).getTripNo())
                                         likeCount = likeCountList.get(j).getLikeCount();
                                   }
                                   %>
                                   <%=likeCount %>
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

        <!--페이지 버튼-->
        <div class="container mt-5 mb-5">
                <%=pageBar %>
        </div>
   
  
    </section>
    <style>
       .card-body img{
                object-fit: cover;
            }
    </style>
  
<%@ include file = "/views/common/footer.jsp"%>