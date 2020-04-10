<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
 <style>
        .dropdown-container{
            /*border: 1px solid black;*/
            width: 150px;
            height: 50px;
           margin-top: 100px;
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
<section>
 
<form action="<%=request.getContextPath()%>/board/boardWriteEnd.do" method="post" id="frm">
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
	<input type="text" placeholder="게시글 제목을 입력하세요" name="boardWrite-title" id="boardWrite-title" style="width:250px;height:35px" size="100">
	</td>
</tr>
<tr>
	<td style="width:766px; height:412px;">
	<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:100%; height:412px;"></textarea>
	
	</td>
</tr>
<tr>
	<td>
	<textarea name="boardTag" id="boardTag" placeholder="#태그를 #입력하세요" cols=105 rows=5></textarea>
	</td>
</tr>
<tr>
	<td>
	<input type="button" class="btn btn-default" value="취소하기">
	<input type="button" class="btn btn-default" id="savebutton" value="글작성" />
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