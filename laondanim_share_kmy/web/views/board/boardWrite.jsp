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
   /*      .post-title{
            width: 250px;
            margin-left: auto;
            margin-right: auto;
            padding-top: 30px;
        }
        .index-container{
           /*border: 1px solid black;*/
            width:740px;
            height: 500px;
            padding-top: 30px;
            margin-left: auto;
            margin-right: auto;
        }
        .board-tag-container{
        	margin-top:20px;
        	} */
    </style>
<section>
<form action="<%=request.getContextPath()%>/board/boardWriteEnd.do" method="post" id="boardText"> 

<table class="boardWrite-container">
<tr>
	<td>
 <div class="dropdown-container">
        <select class="form-control" name="board-selector">
        	<option value="all" selected>전체게시글</option>
        	<option value="qna">질문글</option>
        	<option value="others">자유글</option>
        </select>
	</td>
</tr>
<tr>
	<td>
	<input type="text" placeholder="게시글 제목을 입력하세요" name="boardWrite-title" style="width:250px;height:35px" size="100">
	</td>
</tr>
<tr>
	<td style="width:766px; height:412px;">
	<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:100%; height:412px;">
	</textarea>
	</td>
</tr>
<tr>
	<td>
	<textarea name="boardTag" placeholder="#태그를 #입력하세요" cols=105 rows=5></textarea>
	</td>
</tr>
<tr>
	<td>
	<input type="button" class="btn btn-default" value="취소하기">
	<input type="submit" class="btn btn-default" id="savebutton" value="작성완료">
	</td>
</tr>

 </table> 
</form>   

</section>
<script>
$(function(){
    //전역변수선언
    var editor_object = [];
     
    nhn.husky.EZCreator.createInIFrame({//명령어. iframe을 이용하여 화면에 띄워줌
        oAppRef: editor_object,
        elPlaceHolder: "smarteditor",//textarea의 id값
        sSkinURI: "<%=request.getContextPath()%>/smarteditor/SmartEditor2Skin.html",
        //에디터 스킨 html파일경로
        htParams : {
            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseToolbar : true,            
            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseVerticalResizer : true,    
            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
            bUseModeChanger : true,
        }
    });
   /*  //전송버튼 클릭이벤트
    $("#savebutton").click(function(){
        //id가 smarteditor인 textarea에 에디터에서 대입
        editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
        //editorobject라는 배열변수->id가 스마트에디터인 textarea폼에 입렫한 h 
        // 이부분에 에디터 validation 검증
         
        //폼 submit
        $("#frm").submit();
    }) */
    
    
    
})





</script>
<%@ include file="/views/common/footer.jsp"%> 