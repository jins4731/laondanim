<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.laon.tripinfo.model.vo.*" %>
<%
	List<TripInfo> list = (List)request.getAttribute("list");
	List<TripInfoComment> comments = (List)request.getAttribute("comments");
	String type=request.getParameter("searchType");
	String key=request.getParameter("searchKeyword");
	
%>
       <script>
           	var location=$("<%=ti.getTripinfoAddress()%>");
           	var jbSplit=location.split(" ");
           	for(var i in jbSplit){
           		document.write('<span>'+jbSplit[i]+'</span>');
           	}
           </script>
<!-- <!DOCTYPE html>
<html>
<head>
<title>첫번째 길잡이 메인</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script> -->
<%@ include file="/views/common/header.jsp" %>
<style>
       	.my-heat-icon{display:none;}
       	.my-heart-cafe:hover .my-heat-icon{display:inline;}
       	.darkness {
			position:absolute;
            	top:23px;
				width:220px;
				height:250px;
			 background:#000000;
			 /* 추가된 부분 */
			 opacity:0;
				 transition:all .6s linear;
		}
		.tag-plus {
        		font-size: 7px;
 				position:absolute;
 				top:40px;
 				left:60px;
 				width:100px;
 				height:55px;
 				border-radius:50%;
 				text-align:center;
 				/* 추가된 부분 */
 				opacity:0;
 				transform:scale(2);
 				transition:all .3s linear;
		}
		.tag-plus span {
				 font-size:2.3em;
 				 color:#ffffff;
				 user-select:none;
		}

		/* 추가된 부분 */
		.img-wrapper:hover .darkness{
				 opacity:0.4;
		}

		/* 추가된 부분 */
		.img-wrapper:hover .tag-plus {
				 opacity:1;
				 transform:scale(1);
		}
			
			
      .modal-footer{
        display: flex;
      }
      .carousel , .slide{
        width: 600px;
        height: 400px;
      }
      .tripinfo-header{
        justify-content: space-between;
      }
   
         
    .search-container{
        display: flex;
        justify-content: center;
        margin-top: 30px;
        margin-bottom: 30px;
    }
    .category{
        margin-bottom: 30px;
    }
    .box001{
        margin-bottom: 30px;
    }
    .tripinfo-page{
        margin-top: 30px;
        display: flex;
        justify-content: center;
    }
    .tripinfo-title{
      width: 200px;
      height: 50px;
      justify-content: space-between;
    }
    #myHeart { 
      position: fixed; 
      right: 50%; 
      margin-right: -700px; 
      margin-top: 300px;
      text-align:center; 
      }
   
</style>
<!-- </head> -->
<body>
    <section>
        <div class="container">
           <div class="search-container">
            <select id="searchType">
              <option value="name"<%=type!=null&&type.equals("name")?"selected":"" %>>상호명</option>
              <option value="address"<%=type!=null&&type.equals("address")?"selected":"" %>>지역명</option>
              <option value="tag"<%=type!=null&&type.equals("tag")?"selected":"" %>>키워드</option>
            </select>
            <div id="search-name">
              <form action="<%=request.getContextPath()%>/tripinfo/tripinfoMain" method="post">
              	<input type="hidden" class='input-category' name="category" value="<%=request.getParameter("category")==null?"":request.getParameter("category") %>"/>
                <input type="hidden" value="name" name="searchType"/>
                <input type="text" name="searchKeyword" placeholder="상호명 입력" value="<%=type!=null&&type.equals("name")?key:""%>">
                <button type="submit">검색</button>
              </form>
            </div>
            <div id="search-address">
              <form action="<%=request.getContextPath()%>/tripinfo/tripinfoMain" method="post">
              	<input type="hidden" class='input-category' name="category" value="<%=request.getParameter("category")==null?"":request.getParameter("category") %>"/> 
                <input type="hidden" value="address" name="searchType" />
                <input type="text" name="searchKeyword" id="search-address-input"placeholder="지역명 입력" list="data" autocomplete="off" value="<%=type!=null&&type.equals("address")?key:""%>">
                <datalist id="data"></datalist>
                <button type="submit">검색</button>
              </form>
            </div>
            <div id="search-tag">
              <form action="<%=request.getContextPath()%>/tripinfo/tripinfoMain" method="post">
              	<input type="hidden" class='input-category' name="category" value="<%=request.getParameter("category")==null?"":request.getParameter("category") %>"/>
                <input type="hidden" value="tag" name="searchType"/>
                <input type="text" name="searchKeyword" placeholder="태그 입력" value="<%=type!=null&&type.equals("tag")?key:""%>">
                <button type="submit">검색</button>
              </form>
            </div>
           </div>
            <script>
            	/* 필터 스크립트 */
        	$(function(){
        		$("#searchType").change(function(){
        			const name=$("#search-name");
        			const address=$("#search-address");
        			const tag=$("#search-tag");
        			name.hide();
        			address.hide();
        			tag.hide();
        			const type=$(this).val();
        			$("#search-"+type).css("display","inline-block");
        		});
        		$("#searchType").change();
        	});
           	/* 하트를 누르면 하트가 바뀌는 스크립트 */
        	$(function(){
        		$(".card-heart-button").click(function(){
        			const heartUp=$(this).find(".card-heart-up");
        			if(heartUp.attr('src')!="<%=request.getContextPath()%>/images/heart2.jpg"){
        				
        				heartUp.attr('src','<%=request.getContextPath()%>/images/heart2.jpg');
        			}else{
        				heartUp.attr('src','<%=request.getContextPath()%>/images/heart1.jpg');
        			}
        		})
        	})
        </script>
        
             <!-- 내 마음함 버튼 -->
            <div class="my-heart">
              <button type="button" class="btn fab fa-gratipay fa-4x" id="myHeart" data-toggle="modal" data-target="#myModal"></button>
            </div>
            <div class="category">
            	<button id="cafe-button" class="btn btn-primary" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="맛집"%>')">
            		<i class="fas fa-utensils"></i>&nbsp&nbsp&nbsp맛집
            	</button>
            	<button id="room-button" class="btn btn-primary" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="숙소"%>')">
            		<i class="fas fa-home"></i>&nbsp&nbsp&nbsp숙소
            	</button>
            	<button id="attraction-button" class="btn btn-primary" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="명소"%>')">
            		<i class="fas fa-map-marker-alt"></i>&nbsp&nbsp&nbsp명소
            	</button>
            </div>
           <div class="box001 d-flex" style="justify-content: space-between;">
               <div class="msg001">
                   <span>총 <%=request.getAttribute("totalData")%>건의 여행정보가 있습니다.</span>
               </div>
               <div class="array">
                   <a href="#"><span>마음 순</span></a>
               </div>
           </div>
           <div class="tripinfoList">
               <div class="tripinfo-card-list d-flex flex-wrap" style="height: 700px;" >
                <%for(TripInfo ti : list) { %>
                      <div class="card"  style="width: 221px; height: 350px; border-radius: 25px;  box-shadow: 5px 5px 20px;">
                        <div class="tripinfo-card-title d-flex"style="justify-content: center;">
                          <span><%=ti.getTripinfoName() %></span>
                        </div>
                        <div class="img-wrapper" data-toggle="modal" data-target="#myModal1">
                         <img src="<%=request.getContextPath()%>/images/sungsimdang1.jpeg" class="card-img-top" alt="..." width="250px" height="250px">
                         <div class="darkness"></div>
  						 <div class="tag-plus"><span><%=ti.getTripinfoTag() %></span></div>
                        </div>
                        <div class="card-body justify-content-between d-flex">
                          <div class="tripinfo-card-location">
                            <span class="location-info"><%=ti.getTripinfoAddress()%><span>
                          </div>
                          <div class="tripinfo-carde-heartNo">
                          	<button class="card-heart-button btn" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMind">
                          		<img class="card-heart-up" src="<%=request.getContextPath()%>/images/heart1.jpg" width="30px" height="30px">
                          	</button>
                            <span>2020</span>
                          </div>
                        </div>
                      </div>
               
                <%} %>
               </div>
           </div>
           <div class="tripinfo-page d-flex" style="justify-content: center;">
           	<%=request.getAttribute("pageBar") %>
           </div>
           
       
          <!-- The Modal -->
          <div class="modal fade" id="myModal">
            <div class="modal-dialog modal-lg">
              <div class="modal-content">
              
                <!-- 내 마음함 헤더 -->
                <div class="modal-header">
                  <h4 class="modal-title">내 마음함</h4>
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                
                <!-- 내 마음함 내용 -->
                <div class="modal-body">
                    <div id="accordion">
                        <div class="card">
                          <div class="card-header card-link" data-toggle="collapse" href="#collapseOne">
                              <h4>맛집</h4>
                          </div>
                          <div id="collapseOne" class="collapse show" data-parent="#accordion">
                            <div class="card-body">
                              <div class="msg002" style="margin-bottom: 10px;">
                                <span>총 10개의 맛집</span>
                              </div>
                              <div class="heart-cafe d-flex" style="align-item:center">
                                <div class="my-heart-cafe d-flex flex-wrap" style="width: 130px; justify-content: center;">
                                  <img src="<%=request.getContextPath()%>/images/sungsimdang1.jpeg" alt="성심당1" width="130px" height="130px">
                                  <div class="my-heat-icon" style="margin-top: 10px;">
                                    <i class="fas fa-trash-alt"></i>
                                  </div>
                                </div>
                                <div class="my-heart-cafe d-flex flex-wrap" style="width: 130px; justify-content: center;">
                                  <img src="<%=request.getContextPath()%>/images/sungsimdang1.jpeg" alt="성심당1" width="130px" height="130px">
                                  <div class="my-heat-icon" style="margin-top: 10px;">
                                    <i class="fas fa-trash-alt"></i>
                                  </div>
                                </div>
                                <div class="my-heart-cafe d-flex flex-wrap" style="width: 130px; justify-content: center;">
                                  <img src="<%=request.getContextPath()%>/images/sungsimdang1.jpeg" alt="성심당1" width="130px" height="130px">
                                  <div class="my-heat-icon" style="margin-top: 10px;">
                                    <i class="fas fa-trash-alt"></i>
                                  </div>
                                </div>
                                <div class="my-heart-cafe d-flex flex-wrap" style="width: 130px; justify-content: center;">
                                  <img src="<%=request.getContextPath()%>/images/sungsimdang1.jpeg" alt="성심당1" width="130px" height="130px">
                                  <div class="my-heat-icon" style="margin-top: 10px;">
                                    <i class="fas fa-trash-alt"></i>
                                  </div>
                                </div>
                                <div class="my-heart-cafe d-flex flex-wrap" style="width: 130px; justify-content: center;">
                                  <img src="<%=request.getContextPath()%>/images/sungsimdang1.jpeg" alt="성심당1" width="130px" height="130px">
                                  <div class="my-heat-icon" style="margin-top: 10px;">
                                    <i class="fas fa-trash-alt"></i>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="card">
                          <div class="card-header collapsed card-link" data-toggle="collapse" href="#collapseTwo">
                            <h4>숙소</h4>
                          </div>
                          <div id="collapseTwo" class="collapse" data-parent="#accordion">
                            <div class="card-body">
                                <div class="msg003">
                                  <span>총 11개의 숙소</span>
                                </div>
                                <div class="heart-rooms"></div>
                            </div>
                          </div>
                        </div>
                        <div class="card">
                          <div class="card-header collapsed card-link" data-toggle="collapse" href="#collapseThree">
                             <h4>명소</h4>
                          </div>
                          <div id="collapseThree" class="collapse" data-parent="#accordion">
                            <div class="card-body">
                                <div class="msg004">
                                  <span>총 17개의 명소</span>
                                </div>
                                <div class="heart-attraction"></div>
                            </div>
                          </div>
                        </div>
                      </div>
                </div>
              </div>
            </div>
          </div>    
  <!-- 상세 페이지 -->
  <%for(TripInfo ti : list) { %>
  <div class="modal fade" id="myModal1">
    <div class="modal-dialog modal-xl">
      <div class="modal-content">
       
      
        <!-- 상세페에지 해더 -->
        <div class="modal-header tripinfo-header">
          <div class="tripinfo-title d-flex flex-wrap">
            <div class="modal-title">
              <h4><%=ti.getTripinfoName() %></h4>
            </div>
            <div class="heart-no">
              <span class="fas fa-heart"></span>
              <span>2020</span>
            </div>
          </div>
          <div class="box002 d-flex">
            <div class="heart-up">
              <button class="btn fas fa-heart"></button>
            </div>
            <div class="danimgil">
                <button class="btn btn-primary">관련 다님길 연결</button>
            </div>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
        </div>
        <div class="tripinfo-view-tag d-flex justify-content-center">
          <div class="tripinfo-tag">
            <span><%=ti.getTripinfoTag() %></span>
          </div>
        </div>
        
        <!-- 상세페이지 바디 -->
        <div class="modal-body d-flex">
          <div id="demo" class="carousel slide col-8" data-ride="carousel">

            <!-- Indicators -->
            <ul class="carousel-indicators">
              <li data-target="#demo" data-slide-to="0" class="active"></li>
              <li data-target="#demo" data-slide-to="1"></li>
              <li data-target="#demo" data-slide-to="2"></li>
            </ul>
            
            <!-- 슬라이드 사진 -->
            <div class="carousel-inner ">
              <div class="carousel-item active">
                <img src="<%=request.getContextPath()%>/images/sungsimdang1.jpeg" alt="성심당1" width="100%" height="400">
              </div>
              <div class="carousel-item">
                <img src="<%=request.getContextPath()%>/images/sungsimdang2.jpg" alt="성심당2" width="100%" height="400">
              </div>
              <div class="carousel-item">
                <img src="<%=request.getContextPath()%>/images/sungsimdang3.jpg" alt="성심당3" width="100%" height="400">
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
          <div class="cafe-information col-4 "style="text-align:center;">
              <div class="tripinfo-time">
                <span>영업시간</span><br>
                <span><%=ti.getTripinfotime() %></span>
              </div>
              <hr>
              <div class="tripinfo-phone">
                <span>전화번호</span><br>
                <span><%=ti.getTripinfoNumber() %></span>
              </div>
              <hr>
              <div class="tripinfo-address">
                <span>주소</span><br>
                <span><%=ti.getTripinfoAddress() %></span>
              </div>
              <hr>
              <div class="tripinfo-link">
                  <a href="<%=ti.getTripinfoNaver()%>">
                  	<img src="<%=request.getContextPath()%>/images/naver(1).png" alt="naver" width="50px" height="50px">
                  </a>
                  <a href="<%=ti.getTripinfoHomePage()%>">
                  	<img src="<%=request.getContextPath()%>/images/naver(1).png" alt="naver" width="50px" height="50px">
                  </a>
                  <a href="<%=ti.getTripinfoSns()%>">
                  	<img src="<%=request.getContextPath()%>/images/naver(1).png" alt="naver" width="50px" height="50px">
                  </a>
              </div>
          </div>
        </div>
        
        <!-- 상세페이지 풋터 -->
        <div class="modal-footer">
          <dvi class="d-flex" style="width:100%;">
            <div class="tripinfo-map col-5">
              <img src="<%=request.getContextPath()%>/images/kokokoko.jpg" alt="지도3" width="100%" height="100%" >
            </div>
            <div class="tripinfo-comment col-7">
                <div class="tripinfo-comment-title" style="height: 30px;">
                  <span>한줄평</span>
                </div>
                <div class="tripinfo-comment-list">
                  <table id="tbl-comment">
			<!-- 댓글출력하기 -->
			<%if(comments!=null&&!comments.isEmpty()){ 
			for(TripInfoComment tc : comments){%>
	  <tr class="level2">
		 <td>
			<sub>작성자</sub>
     </td>
     <td>
        <%=tc.getContent() %>
     </td>
     <td>
      <sub><%=tc.getWriteDate()%></sub>
     </td>
	   <td>
			<i class="fas fa-align-justify"></i>
		 </td>
  	</tr>
			<%}
			} %>
		</table>
                </div>
                <div class="tripinfo-comment-page d-flex" style="height: 50px; justify-content: center;">
             
                </div>
                
                  <div class="tripinfo-comment-input" id="comment-container">
			<div class="comment-editor">
				<form action="<%=request.getContextPath()%>/tripinfo/tripinfoCommentInsert" method="post">
					<input type="text" name="commentContent"></input>
					<button type="submit" id="btn-insert">등록</button>
				</form>
			</div>
                
                </div>
            </div>
        </dvi>
        </div>
        
      </div>
    </div>
  </div>
  <%} %>
</section>
 
<%@ include file="/views/common/footer.jsp" %>

