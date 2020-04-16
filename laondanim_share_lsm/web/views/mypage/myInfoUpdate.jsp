<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp"%>
<div class="container">
	<div class="row">
	   	<div class="col-4">
			<%@ include file="/views/mypage/myPageAside.jsp" %>
		</div>
		<div class="col-8">
			<section>
				<div id="myMenuBtn">
					<button type="button" id="myCon" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageContent.do?userNo=<%=loginUser.getNo()%>')">내 컨텐츠</button>
					<button type="button" id="myH" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageHeart.do?userNo=<%=loginUser.getNo()%>')">내 마음함</button>
					<button type="button" id="myDh" class="btn btn-info" onclick="location.replace('<%=request.getContextPath()%>/myPage/myPageDong.do?userNo=<%=loginUser.getNo()%>')">내 동행</button>
				</div>
				<div id="myPageView">
				    <div class="d-flex flex-column align-items-center justify-content-center">
				        <div class="p-5">
				            <h2>정보 수정</h2>
				        </div>
				
				        <div class="">
				
				            <form id="myInfo" action="<%=request.getContextPath()%>/myPage/myInfoUpdateEnd.do" method="post" onsubmit="return fn_checkEnd();" enctype="multipart/form-data">
				                <table class="" style="width: 400px; height: 580px;">
				                	<input type="hidden" id="userNo" name="userNo" value="<%=up.getNo() %>">
				                	<input type="hidden" id="cDate" name="cDate" value="<%=up.getCreatedDate() %>">
				                	<input type="hidden" id="oriPro" name="oriPro" value="<%=up.getImage() %>">
				                	
				                	<tr>
				                		<th>프로필</th>
				                		<td style="position:relative;">
				                		<%if(up.getImage()!=null){ %>
				                			<input type="file" id="pofile" name="profile">
				                			<span id="proImg"><%=up.getImage() %></span>
				                		<%}else{ %>
				                			<input type="file" id="pofile" name="profile">
				                		<%} %>
				                		</td>
				                	</tr>
				                    <tr>
				                        <th>아이디</th>
				                        <td><input type="text" id="userId" name="userId" class="form-control" value="<%=up.getUserId()%>" readonly></td>
				                    </tr>
				                    <tr>
				                        <th>비밀번호</th>
				                        <td><input type="password" id="userPw" name="userPw" class="form-control" placeholder="비밀번호 입력" required></td>
				                    </tr>
				                    <tr>
				                        <th></th>
				                        <td><input type="password" id="pwck" name="pwck" class="form-control" placeholder="비밀번호 재확인" required></td>
				
				                    </tr>
				                    <tr>
				                        <td colspan="2">
				                            <div style="position: relative; width: 394px; height: 45px;">         
				                                
				                                <div class="alert alert-light m-0 p-2 text-center" id="" style="position: absolute; width: 100%;">
													비밀번호는 숫자와 영(소)문자 조합 5~10자리를 사용
				                                </div> 
				                                <div class="alert alert-success m-0 p-2 text-center" id="alert-success" style="position: absolute; width: 100%;">
				                                   	비밀번호가 일치합니다.
				                                </div> 
				                                <div class="alert alert-danger m-0 p-2 text-center" id="alert-danger" style="position: absolute; width: 100%;">
				                                   	 비밀번호가 일치하지 않습니다.
				                                </div>
				                                <div class="alert alert-danger m-0 p-2 text-center" id="alert-pw-validate" style="position: absolute; width: 100%;">
				                                   	 숫자, 영문자 조합 5~10자리로 입력해주세요.
				                                </div>
				                            </div>
				                        </td>
				                    </tr>                    
				                    <tr>
				                        <th>이름</th>
				                        <td><input type="text" name="userName" class="form-control" value="<%=up.getName()%>" readonly></td>
				
				                    </tr>
				                    <tr>
				                        <th>닉네임</th>
				                        <td><input type="text" name="userNickName" id="userNickName" class="form-control"  value="<%=up.getNickName()%>"></td>
				                    </tr>
				                    <tr>
				                        <th></th>
				                        <td class="d-flex justify-content-end">
				                            <button type="button" class="btn btn-primary" onclick="fn_duplicateNickName();">중복확인</button>
				                        </td>
				                    </tr>
				                    <tr>
				                        <th>생년월일</th>
				                        <td><input type="date" name="userBirth" class="form-control"  value="<%=up.getBirthday()%>" readonly></td>
				                    </tr>
				                    <tr>
				                        <th>성별</th>
				                        <td><input type="text" name="gender" id="gender" class="form-control" value="<%=up.getGender()%>" readonly></td>
				                    </tr>
				                    <tr>
				                        <th>휴대전화</th>
				                        <td><input type="tel" class="form-control" name="userPhone" id="phone"  value="<%=up.getPhone()%>">
				                        </td>
				                    </tr>
				
			                        <tr>
			                            <th>이메일 </th>
			                            <td><input type="email" id="userEmail" name="userEmail" class="form-control" value="<%=up.getEmail()%>"></td>
			                        </tr>
				                </table>
				                
				                <div class="d-flex flex-column mt-5 mb-3 justify-content-center align-self-center text-center" style="width: 400px; height: auto;">
				                    <p class="m-0 " style="font-weight: 600;">회원님의 여행 관심사를 알려주세요<span>&#x1F60A</span></p>                  
				                </div>              
				                
				                <div class="form-group d-flex flex-column justify-content-center mt-4" style="width: 400px;">
				                    <p class="mb-2 ml-2 align-items-start">관심지역을 <strong>선택</strong>해주세요.</p>
				                    <div class="form-group">
				                    	<select name="likeArea" class="form-control" id="likeAreaSelect" required>
				                          <option value="" disabled selected>관심지역 선택</option>
				                          <option value="서울">서울</option>
				                          <option value="부산">부산</option>
				                          <option value="대구">대구</option>
				                          <option value="인천">인천</option>
				                          <option value="광주">광주</option>
				                          <option value="대전">대전</option>
				                          <option value="울산">울산</option>
				                          <option value="세종">세종</option>
				                          <option value="경기">경기</option>
				                          <option value="강원">강원</option>
				                          <option value="충청북도">충청북도</option>
				                          <option value="충청남도">충청남도</option>
				                          <option value="전라북도">전라북도</option>
				                          <option value="전라남도">전라남도</option>
				                          <option value="경상북도">경상북도</option>
				                          <option value="경상남도">경상남도</option>
				                          <option value="제주도">제주도</option>
				                        </select>                                    
				                    </div>
				                    <input type="hidden" id="likeArea" name="likeArea">
				                </div>
				                
				                <%
				                	String[] tags=up.getTag().split(",");
				                %>
				                <script>
				                $(function () {
				                	$('#likeArea option[value=<%=tags[0]%>]').attr('selected', 'selected');
				                });
				                </script>
				                <%
				                	String[] checkTag=new String[15];
				                	if(tags!=null){
				                		for(String t:tags){
				                			switch(t){
				                				case "혼자여행":checkTag[0]="checked";break;
				                				case "가족여행":checkTag[1]="checked";break;
				                				case "우정여행":checkTag[2]="checked";break;
				                				case "커플여행":checkTag[3]="checked";break;
				                				case "맛집투어":checkTag[4]="checked";break;
				                				case "카페투어":checkTag[5]="checked";break;
				                				case "관광지_탐방":checkTag[6]="checked";break;
				                				case "힐링":checkTag[7]="checked";break;
				                				case "축제":checkTag[8]="checked";break;
				                				case "인생샷":checkTag[9]="checked";break;
				                				case "숨은_명소":checkTag[10]="checked";break;
				                				case "액티비티":checkTag[11]="checked";break;
				                				case "당일치기":checkTag[12]="checked";break;
				                				case "주말여행":checkTag[13]="checked";break;
				                				case "캠핑":checkTag[14]="checked";break;
				                			}
				                		}
				                	}
				                %>
				                
				                <div class="form-group d-flex flex-column flex-wrap justify-content-center" style="width: 400px;">
				                    <p class="mb-2 ml-2 align-items-start">관심태그를 <strong>클릭</strong>해주세요. (최대 5개)</p>
				                    <div class="checkbox border text-center p-2 rounded-lg">
				                        <input type="checkbox" name="likeTag" id="cb1" value="혼자여행" <%=checkTag[0] %>><label for="cb1">#혼자여행</label>
				                        <input type="checkbox" name="likeTag" id="cb2" value="가족여행" <%=checkTag[1] %>><label for="cb2">#가족여행</label>
				                        <input type="checkbox" name="likeTag" id="cb3" value="우정여행" <%=checkTag[2] %>><label for="cb3">#우정여행</label>
				                        <input type="checkbox" name="likeTag" id="cb4" value="커플여행" <%=checkTag[3] %>><label for="cb4">#커플여행</label>
				                        <input type="checkbox" name="likeTag" id="cb5" value="맛집투어" <%=checkTag[4] %>><label for="cb5">#맛집투어</label>
				                        <input type="checkbox" name="likeTag" id="cb6" value="카페투어" <%=checkTag[5] %>><label for="cb6">#카페투어</label>
				                        <input type="checkbox" name="likeTag" id="cb7" value="관광지_탐방" <%=checkTag[6] %>><label for="cb7">#관광지_탐방</label>
				                        <input type="checkbox" name="likeTag" id="cb8" value="힐링" <%=checkTag[7] %>><label for="cb8">#힐링</label>
				                        <input type="checkbox" name="likeTag" id="cb9" value="축제" <%=checkTag[8] %>><label for="cb9">#축제</label>
				                        <input type="checkbox" name="likeTag" id="cb10" value="인생샷" <%=checkTag[9] %>><label for="cb10">#인생샷</label>
				                        <input type="checkbox" name="likeTag" id="cb11" value="숨은_명소" <%=checkTag[10] %>><label for="cb11">#숨은_명소</label>
				                        <input type="checkbox" name="likeTag" id="cb12" value="액티비티" <%=checkTag[11] %>><label for="cb12">#액티비티</label>
				                        <input type="checkbox" name="likeTag" id="cb13" value="당일치기" <%=checkTag[12] %>><label for="cb13">#당일치기</label>
				                        <input type="checkbox" name="likeTag" id="cb14" value="주말여행" <%=checkTag[13] %>><label for="cb14">#주말여행</label>
				                        <input type="checkbox" name="likeTag" id="cb15" value="캠핑" <%=checkTag[14] %>><label for="cb15">#캠핑</label>
				                    </div>
				                </div>
				                <input type="submit" class="btn btn-primary btn-block mt-5 mb-4" value="정보수정">
				            </form>
				        </div>
				    </div>
				</div>
			</section>
		</div>
	</div>
</div>
<%@ include file="/views/common/footer.jsp"%>


<style>
	#myMenuBtn{
		text-align:center;
	}
	
	#myMenuBtn>button{	
		width:150px;
		margin: 20px;
    	border-radius: 100px;
	}
	
	span#proImg{
		position:absolute;
		left:79px;
		top:7px;
		width:258px;
		background-color: white;
	}
</style>

<script>
	$(function(){
		$("[name=profile]").change(function(){
			if($(this).val()==""){
				$("#proImg").show();
			}else{
				$("#proImg").hide();
			}
		});
	});
</script>



    <!-- 닉네임 글자수 안내 모달 -->
    <div class="modal" id="nickNameLengthCheck">
        <div class="modal-dialog">
        <div class="modal-content">
        
            <!-- Modal Header -->
            <div class="modal-header border-bottom-0">
            <!-- <h4 class="modal-title">Modal Heading</h4> -->
            <button type="button" class="close modal-close" data-dismiss="modal">&times;</button>
            </div>
            
            <!-- Modal body -->
            <div class="modal-body">
            	<span class="ml-2">&#x274C</span>
            	닉네임을 3 자 이상 입력해주세요!
            </div>
            
            <!-- Modal footer -->
            <div class="modal-footer border-top-0">
            <button type="button" class="btn btn-danger modal-close" data-dismiss="modal">Close</button>
            </div>
            
        </div>
        </div>
    </div>
    



    <!-- 닉네임 중복체크 Modal -->
    <div class="modal" id="duplicateNickName">
        <div class="modal-dialog">
        <div class="modal-content">
        
            <!-- Modal Header -->
            <div class="modal-header border-bottom-0">
            <h4 class="modal-title">닉네임 중복확인</h4>
            <button type="button" class="close modal-close" data-dismiss="modal">&times;</button>
            </div>
            
            <!-- Modal body -->
            <div class="modal-body">
            	<div id="nickNameModal_result">
            	</div>
            </div>
            
            <!-- Modal footer -->
            <div class="modal-footer border-top-0">
            <button type="button" class="btn btn-danger modal-close" data-dismiss="modal">Close</button>
            </div>
            
        </div>
        </div>
    </div>


    <!-- 이메일 입력 안내 모달 -->
    <div class="modal" id="emailCheck">
        <div class="modal-dialog">
        <div class="modal-content">
        
            <!-- Modal Header -->
            <div class="modal-header border-bottom-0">
            <!-- <h4 class="modal-title">Modal Heading</h4> -->
            <button type="button" class="close modal-close" data-dismiss="modal">&times;</button>
            </div>
            
            <!-- Modal body -->
            <div class="modal-body">
            	<span class="ml-2">&#x274C</span>
            	이메일을 입력해주세요.
            </div>
            
            <!-- Modal footer -->
            <div class="modal-footer border-top-0">
            <button type="button" class="btn btn-danger modal-close" data-dismiss="modal">Close</button>
            </div>
            
        </div>
        </div>
    </div>



<style>
    input[type=checkbox] {
        display:none; 
    }

    input[type=checkbox] + label { 
        display: inline-block; 
        cursor: pointer; 
        color: grey;
        margin: 10px;
    }

    input[type=checkbox]:checked + label {
        color: #00abbf; 
        font-weight: 550; 
    }
    /*생년월일, 인증번호 증감버튼 제거 */
    input[type="number"]::-webkit-outer-spin-button,
    input[type="number"]::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }

    input[type="date"]::-webkit-outer-spin-button,
    input[type="date"]::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }    
</style>

<script>

    //체크박스 개수제한 fn
    $(document).ready(function() {
        // 체크박스들이 변경됐을때
        $(":checkbox").change(function() {
            var cnt = 5;
            
            // 셀렉트박스의 값과 체크박스중 체크된 갯수가 같을때, 다른 체크박스들을 disable 처리
            if( cnt == $(":checkbox:checked").length ) {
                $(":checkbox:not(:checked)").attr("disabled", "disabled");
            }
            // 체크된 갯수가 다르면 활성화 시킴
            else {
                $(":checkbox").removeAttr("disabled");
            }
        });
    });
    
	
	//비밀번호 일치 확인
    $(function(){
        $("#alert-success").hide();
        $("#alert-danger").hide();
        $("#alert-pw-validate").hide();

        $("#userPw").keyup(()=>{            
            $("#alert-success").hide();
            $("#alert-danger").hide();                
        })

        $("#pwck").keyup(function(){
            let userPw=$("#userPw").val();
            let pwck=$("#pwck").val();
            const reg = /^(?=.*[a-z])(?=.*\d)[a-z\d]{5,10}$/;

            $("#alert-success").hide();
            $("#alert-danger").hide();

            if(!reg.test(userPw)){
                $("#alert-pw-validate").show();
            } else if(reg.test(userPw)){
                $("#alert-pw-validate").hide();
            }
            if(userPw != "" || pwck != ""){
                if(userPw == pwck){ 
                    $("#alert-success").show(); 
                    $("#alert-danger").hide();
                } else{ 
                    $("#alert-success").hide(); 
                    $("#alert-danger").show(); 
                }
            } 
        }); 
    });

    
    //Ajax 닉네임 중복확인
    function fn_duplicateNickName(){
		let userNickName = $("#userNickName").val();
		
		if( userNickName.trim().length<3){
			$("#nickNameLengthCheck").show();
			return;
		} else {   	
	    	$("#duplicateNickName").show();
	    	
    		let xhr = new XMLHttpRequest();
    		
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status == 200){						
						//xhr객체의 responseText에 데이터를 저장
						$("#nickNameModal_result").html(xhr.responseText);
					} else if(xhr.status == 404){
						alert("404 error")
					}
				}
			}
			//전송에 대한 설정 : open()함수
			
			xhr.open("get","<%=request.getContextPath()%>/user/nickNameCheck.do?userNickName="+userNickName);
			
			//전송! : send()
			xhr.send();
		}
	}//Ajax 닉네임 중복확인 닫기
	
	
	//모달창 닫기
	$(".modal-close").click(()=>{
	    $("#duplicateNickName").hide();
		$("#nickNameLengthCheck").hide();
		$("#emailCheck").hide();
		$("#enrollEmailAut").hide();
		$("#autCodeCheck").hide();		
	});
	
	//likeArea Select > Option에서 값 받기
    $("#likeAreaSelect").change(()=>{
      let ckOption = $("#likeAreaSelect option:checked").text();
        $("#likeArea").val(ckOption);
    });


	//중복 아이디 + 중복 닉네임 + 틀린 인증코드 가입방지
    function fn_checkEnd(){
		//닉네임
        let nnMD = $("#nickNameCheckEnd").text();
		
        if(nnMD==="(은)는 이미 사용중인 닉네임입니다."){
        	alert("중복된 닉네임은 가입할 수 없습니다.");
        	return false;
        }
        
        //관심사 태그 체크박스 하나 이상 확인
        if( $("input[type=checkbox][name=likeTag]:checked").length == 0 ){
		    alert("관심 태그 항목을 하나 이상 체크해 주세요.");
            return false; 
		}

        return true;
	}  		
	
</script>