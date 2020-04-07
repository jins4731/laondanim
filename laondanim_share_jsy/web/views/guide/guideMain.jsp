<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>길잡이 메인</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
    .container{
        border: 1px solid black;
        width: 1366px;
    }
    .search{
        border: 1px solid black;
        display: flex;
        justify-content: center;
        margin-top: 30px;
        margin-bottom: 30px;
    }
    .category{
        border: 1px solid black;
        margin-bottom: 30px;
    }
    .box001{
        border: 1px solid black;
        display: flex;
        margin-bottom: 30px;
    }
    .msg001{
        border: 1px solid black;
    }
    .array{
        border: 1px solid black;
    }
    .guideList{
        border: 1px solid black;
    }
    .page{
        border: 1px solid black;
        margin-top: 30px;
        display: flex;
        justify-content: center;
    }
    .card{
        border: 1px solid black;
    }
    .cafe-title{
      border: 1px solid black;
      display: flex;
      width: 200px;
      height: 50px;
      
     
    }
 
</style>
</head>
<body>
    <section>
        <div class="container">
           <div class="search">
            <input type="text">
           </div>
             <!-- 내 마음함 버튼 -->
         <button type="button" class="btn fas fa-heart" id="myHeart" data-toggle="modal" data-target="#myModal"></button>
           <div class="category">
            <button type="button" class="btn btn-success">맛집</button>
            <button type="button" class="btn btn-success">숙소</button>
            <button type="button" class="btn btn-success">명소</button>
           </div>
           <div class="box001">
               <div class="msg001">
                   <span>총 208건이 검색되었습니다.</span>
               </div>
               <div class="array">
                   <span>최근 순</span>
                   <span>마음 순</span>
               </div>
           </div>
           <div class="guideList">
               <div class="card" data-toggle="modal" data-target="#myModal1">
               	<table>
            <tr>
                <td>
                  <div class="cafe-card">
                    <div class="cafe-card-head">
                      <span>성심당</span>
                    </div>
                    <div class="cafe-card-body">
                      <img src="<%=request.getContextPath()%>/images/sungsimdang1.jpeg" alt="" width="250px" height="250">
                    </div>
                    <div class="cafe-card-foot">
                      <div class="cafe-card-location">
                        <span>전주</span>
                      </div>
                      <div class="cafe-card-heart">

                      </div>
                    </div>
                  </div>
                </td>

               </tr>
        </table>
               </div>
           </div>
           <div class="page">
            <ul class="pagination">
                <li class="page-item disabled"><a class="page-link" href="#">Prev</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
              </ul>
           </div>

        
        
          <!-- The Modal -->
          <div class="modal fade" id="myModal">
            <div class="modal-dialog">
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
                              <div class="msg002"></div>
                              <div class="heart-cafe"></div>
                            </div>
                          </div>
                        </div>
                        <div class="card">
                          <div class="card-header collapsed card-link" data-toggle="collapse" href="#collapseTwo">
                            <h4>숙소</h4>
                          </div>
                          <div id="collapseTwo" class="collapse" data-parent="#accordion">
                            <div class="card-body">
                                <div class="msg003"></div>
                                <div class="heart-lodge"></div>
                            </div>
                          </div>
                        </div>
                        <div class="card">
                          <div class="card-header collapsed card-link" data-toggle="collapse" href="#collapseThree">
                             <h4>명소</h4>
                          </div>
                          <div id="collapseThree" class="collapse" data-parent="#accordion">
                            <div class="card-body">
                                <div class="msg004"></div>
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
  <div class="modal fade" id="myModal1">
    <div class="modal-dialog modal-xl">
      <div class="modal-content">
      
        <!-- 상세페에지 해더 -->
        <div class="modal-header">
          <div class="cafe-title">
            <div class="modal-title">
              <h4>대구 성심당</h4>
            </div>
            <div class="heart-no">
              <span class="fas fa-heart"></span>
              <span>2020</span>
            </div>
            <div class="cafe-address">
              <span>경기도 의정부시 의정부동 385</span>
            </div>
          </div>
            <div class="heart-up"><button class="btn fas fa-heart"></button></div>
            <div class="danimgil">
                <button class="btn btn-primary">관련 다님길 연결</button>
            </div>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <div class="cafe-tag"></div>
        </div>
        
        <!-- 상세페이지 바디 -->
        <div class="modal-body">
          <div id="demo" class="carousel slide" data-ride="carousel">

            <!-- Indicators -->
            <ul class="carousel-indicators">
              <li data-target="#demo" data-slide-to="0" class="active"></li>
              <li data-target="#demo" data-slide-to="1"></li>
              <li data-target="#demo" data-slide-to="2"></li>
            </ul>
            
            <!-- 슬라이드 사진 -->
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="<%=request.getContextPath()%>/images/sungsimdang1.jpeg" alt="성심당1" width="600" height="400">
              </div>
              <div class="carousel-item">
                <img src="<%=request.getContextPath()%>/images/sungsimdang2.jpg" alt="성심당2" width="600" height="400">
              </div>
              <div class="carousel-item">
                <img src="<%=request.getContextPath()%>/images/sungsimdang3.jpg" alt="성심당3" width="600" height="400">
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
          <div class="cafe-information">
              <div class="cafe-time">
                <span>영업시간</span><br>
                <span>08 : 00 ~ 22 : 00</span>
              </div>
              <hr>
              <div class="cafe-phone">
                <span>전화번호</span><br>
                <span>010-9638-2327</span>
              </div>
              <hr>
              <div class="cafe-link">
                  <button class="cafe-home fas fa-heart"></button>
                  <button class="cafe-naver fas fa-heart"></button>
                  <button class="cafe-sns fas fa-heart"></button>
              </div>
          </div>
        </div>
        
        <!-- 상세페이지 풋터 -->
        <div class="modal-footer">
          <div class="cafe-map"></div>
          <div class="cafe-comment">
              <div class="cafe-comment-title"></div>
              <div class="cafe-comment-list"></div>
              <div class="cafe-comment-page"></div>
              <div class="cafe-comment-input">
                <form action="">
                <input type="text">
                <input type="submit" value="등록">
              </form>
              </div>
          </div>
        </div>
        
      </div>
    </div>
  </div>
    </section>
    <style>
      .modal-footer{
        border : solid 1px red;
      }
      .carousel , .slide{
        width: 600px;
        height: 400px;
      }
      .cafe-information{
        border: 1px solid black;
      }
    
      
      .cafe-map{
        border: 1px solid black;
        width: 300px;
        height: 300px;
      }
      .cafe-comment{
        border: 1px solid black;
        width: 300px;
        height: 200px;
      }
      .cafe-comment-title{
        border: 1px solid black;
      }
      .cafe-comment-list{
        border: 1px solid black;
      }
      .cafe-comment-page{
        border: 1px solid black;
      }
      .cafe-comment-input{
        border: 1px solid black;
      }
    </style>
</body>
</html>