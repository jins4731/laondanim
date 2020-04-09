<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>

<style>
.searchContainer {
	border: 1px solid coral;
	display: flex;
	flex-direction: row;
	justify-content: center;
	padding-top: 50px;
	padding-bottom: 20px;
}

.searchBox {
	border: 1px solid coral;
	display: flex;
	flex-direction: row;
	height: 35px;
	border: 1.5px solid #00abbf;
	border-radius: 20px;
	overflow: hidden;
}

.searchBoxElement {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	padding-left: 10px;
	padding-right: 10px;
	border: none;
	background-color: #00abbf;
	color: white;
}

.searchBoxElement img {
	width: 20px;
	height: 20px;
	margin-right: 5px;
}

.searchContainer input {
	height: 30px;
	border: none;
	margin-left: 5px;
}

.searchContainer input:focus {
	outline: none;
}

.searchBoxElement>p {
	padding-top: 10px;
}

.board-dropdown {
	margin-top: 30px;
	margin-left: 140px;
	margin-right: auto;
}

.write {
	display: flex;
	flex-direction: row;
	justify-content: space-around;
	align-items: center;
	/* border: 1px solid black; */
	width: 180px;
	margin-right: 270px;
	margin-left: auto;
	margin-bottom: 30px;
}

.write>a {
	border: none;
	border-bottom: 2px solid rgb(224, 224, 224);
	background-color: white;
}

table * {
	text-align: center;
}

.filter {
	border: 1px solid black;
	width: 1000px;
	display: flex;
	margin-right: auto;
	margin-left: auto;
	margin-bottom: 30px;
}

.filter ul {
	list-style: none;
	display: flex;
}

.filter ul>li {
	padding-left: 10px;
}

#filter-container {
	border: 1px solid black;
	margin-left: auto;
	margin-right: 0px;
}

.board-container {
	width: 1000px;
	margin-left: auto;
	margin-right: auto;
}
</style>
<section>
    <div class="searchContainer">
        <div class="searchBox">
            <div class="searchBoxElement" data-toggle="dropdown">
                <img src="<%=request.getContextPath()%>/icon/search_icon.png" alt="search_icon">
                <p>키워드 검색</p>
                <select name="searchfilter">
                    <option value="작성자">작성자</option>
                    <option value="제목+내용">제목+내용</option>
                    <option value="제목+내용">제목</option>
                    <option value="제목+내용">내용</option>
                    <option value="제목+내용">키워드태그</option>
                </select>
            </div>
            <input type="text" name="searchBox" id="searchBox" size="40px">
        </div>
    </div>
<!--드롭다운 필터버튼-->
<div class="dropdown board-dropdown">
    <button type="button" class="btn btn-default dropdown toggle" data-toggle="dropdown">전체게시글<span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu">
        <li><a href="#">전체게시글</a></li>
        <li class="divider"></li>
        <li><a href="#">질문글</a></li>
        <li><a href="#">자유글</a></li>  
    </ul>
</div>
<!--게시글 작성버튼-->
<div class="write">
    <a href="<%=request.getContextPath()%>/board/write.do">게시글 작성<img src="<%=request.getContextPath()%>/icon/pen_icon.png"></a>
</div>
<!--게시글 수 출력/필터링-->
<div class="filter">
    <div id="print-post">총 100건의 게시물이 있습니다</div>
    <div id="filter-container">
    <ul class="comm-filter">
    <li><a href="#">최근 순</a></li>
    <li><a href="#">조회수 순</a></li>
    <li><a href="#">댓글 순</a></li>
    </ul>
    </div>
</div>
<!--게시글 내용출력-->
<div class="board-container">
<table class="table table-bordered">
    <thead>
    <tr>
        <th>NO</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>공지</td>
        <td>커뮤니티 이용 규칙을 준수해주세요</td>
        <td>관리자</td>
        <td>2020.03.20</td>
        <td>100</td>
    </tr>
    <tr>
        <td>4</td>
        <td>경주 벚꽃개화시기 아시는분?</td>
        <td>경주가고싶다</td>
        <td>2020.03.20</td>
        <td>10</td>
    </tr>
    <tr>
        <td>3</td>
        <td>강릉 맛집 추천해주세요</td>
        <td>김강릉</td>
        <td>2020.03.20</td>
        <td>100</td>
    </tr>
    <tr>
        <td>2</td>
        <td>제주도 지금 날씨 어떤가요?</td>
        <td>이제주</td>
        <td>2020.03.20</td>
        <td>100</td>
    </tr>
    <tr>
        <td>1</td>
        <td>군산 당일치기 가능할까요?</td>
        <td>노군산</td>
        <td>2020.03.20</td>
        <td>100</td>
    </tr>
    </tbody>
</table>
<hr/>
<!--페이징 처리하기-->
<div class="text-center">
    <ul class="pagination">
        <li><a href="#"><<</a></li>
       <li><a href="#"><</a></li>
       <li><a href="#">1</a></li>
       <li><a href="#">2</a></li>
       <li><a href="#">3</a></li>
       <li><a href="#">4</a></li>
       <li><a href="#">5</a></li>
       <li><a href="#">></a></li>
       <li><a href="#">>></a></li>
    </ul>
</div>
</div>
</section>
<%@ include file="/views/common/footer.jsp"%> 