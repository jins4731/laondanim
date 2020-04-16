<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.laon.board.model.vo.BoardJoinUser" %>	
<%
 BoardJoinUser b= (BoardJoinUser)request.getAttribute("BoardJoinUser");
//태그 분리하여 출력하기

	if(b.getTag()!=null){
	String tag=b.getTag();
	String[] taglist=tag.split("#");
	b.setTag(String.join(" #",taglist));
	}


%>
<%@ include file="/views/common/header.jsp"%>
<style>
        .dropdown-container{
            /*border: 1px solid black;*/
            width: 150px;
            height: 50px;
           margin-top: 50px;
           margin-bottom:auto;
            margin-left: auto;
            margin-right: auto;
        }
        .boardWrite-container{
        	text-align:center;
        	margin-left: auto;
            margin-right: auto;
        }

        .board-tag-container{
        	margin-top:20px;
        	} 
    </style>
<div style="height: 170px;"></div> 
<section class="d-flex flex-column justify-content-center align-items-center">
 
<form action="<%=request.getContextPath()%>/board/boardalterEnd.do" method="post" id="frm">
<table class="boardWrite-container">
<tr>
	<td>
 <div class="dropdown-container">
        <select class="form-control" name="board-selector" id="board-selector">
        	<option value="all" selected>유형선택</option><!-- 이거 선택하면 안되는데.. -->
        	<option value="qna">질문글</option>
        	<option value="others">자유글</option>
        </select>
	</td>
</tr>
<tr>
	<td>
	<div class="input-group mb-3">
	<div class="input-group-prepend">
	<span class="input-group-text">제목</span>
	</div>
	<input type="text" class="form-control" placeholder="게시글 제목을 입력하세요"  value="<%=b.getTitle()%>" name="boardWrite-title" id="boardWrite-title" >
	</div>
	</td>
</tr>
<tr>
	<td style="width:766px; height:412px;">
	<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:100%; height:412px;"><%=b.getContent() %></textarea>
	
	</td>
</tr>
<tr>
	<td>
	<textarea name="boardTag" id="boardTag" placeholder="#태그를 #입력하세요" cols=105 rows=5><%=b.getTag()==null?" ":b.getTag()%></textarea>
	</td>
</tr>
<tr>
	<td>
	<button class="btn btn-success" id="savebutton" name="boardNo" value="<%=b.getNo() %>">수정완료</button>
	</td>
</tr>

 </table> 
</form>   

</section>
<script>
$(function(){
    //전역변수선언
    var editor_object = [];
     
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: editor_object,
        elPlaceHolder: "smarteditor",
        sSkinURI: "<%=request.getContextPath()%>/smarteditor/SmartEditor2Skin.html",
        htParams : {
            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseToolbar : true,            
            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseVerticalResizer : true,    
            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
            bUseModeChanger : true,
        }
    });
    

     
    //전송버튼 클릭이벤트
    $("#savebutton").click(function(){
    	var selector=$("#board-selector").val();
    	if(selector=="all"){
    		alert("글 유형을 선택하세요");
    		return false;
    	}
    
        //id가 smarteditor인 textarea에 에디터에서 대입
        editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
        $("#smarteditor").val().replace(/[<][^>]*[>]/g, "");
        // 이부분에 에디터 validation 검증
    
        
        //폼 submit
        $("#frm").submit();
    })
  
    
})
</script>	
	





<%@ include file="/views/common/footer.jsp"%> 