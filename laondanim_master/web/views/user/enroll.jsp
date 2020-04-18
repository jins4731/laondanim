<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp"%>
<div style="height: 160px"></div>

	
<style>
	/* 카테고리 제목 폰트 */
	@font-face { font-family: 'Cafe24Danjunghae'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Danjunghae.woff') format('woff'); font-weight: normal; font-style: normal; }
	/* 본문 폰트 */
	@font-face { font-family: 'S-CoreDream-4Regular'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-4Regular.woff') format('woff'); font-weight: normal; font-style: normal; }
	.laonTitleFont{
		font-family: Cafe24Danjunghae;
		font-size: 35px;
		color: #595959;
	}
	.laonBodyFont{
		font-family: NanumSquare;
		font-size: 22px;
		color: #595959;
	}
	.ldBtn{
	    border-radius: 20px;
	    background-color: white;
	    border: 2px solid #00abbf;
	    color: #00abbf;
	    padding: 6px 15px 6px 15px;
	}  
	.ldBtn:hover,.ldBtn:active {
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
</style>
<section>
    <div class="d-flex flex-column align-items-center justify-content-center">
        <!-- 회원가입 -->
        <div class="p-5">
            <h2 class="laonTitleFont">회원가입</h2>
        </div>

        <div class="">

            <form id="아이디정하기"
                action="<%=request.getContextPath()%>/user/enrollEnd.do"
                method="post"
                onsubmit="return fn_checkEnd();"
                class="d-flex flex-column justify-content-center align-items-center">

                <table class="" style="width: 400px; height: 580px;">
                    <tr>
                        <th>아이디</th>
                        <td><input type="text" id="userId" name="userId" class="form-control" placeholder="아이디 입력 (5글자 이상)" required></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td class="d-flex justify-content-end">                                    
                            <button type="button" class="ldBtn" onclick="fn_duplicateId();">중복확인</button>
                        </td>
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
                        <td><input type="text" name="userName" class="form-control" placeholder="이름 입력" required></td>

                    </tr>
                    <tr>
                        <th>닉네임</th>
                        <td><input type="text" name="userNickName" id="userNickName" class="form-control" placeholder="닉네임 입력 (3글자 이상)" required></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td class="d-flex justify-content-end">
                            <button type="button" class="ldBtn" onclick="fn_duplicateNickName();">중복확인</button>
                        </td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td><input type="date" name="userBirth" class="form-control" required></td>
                    </tr>
                    <tr>
                        <th>성별</th>
                        <td class="form-group">
                                <select name="userGender" class="form-control" id="genderSelect" required>
                                  <option value="" disabled selected>성별 선택</option>
                                  <option>남성</option>
                                  <option>여성</option>
                                </select>                                    
                        </td>
                        <input type="hidden" name="gender" id="gender">
                    </tr>
                    <tr>
                        <th>휴대전화</th>
                        <td><input type="tel" class="form-control" placeholder="(-없이)01012345678" name="userPhone" id="phone" required>
                        </td>
                    </tr>


                </table>


                <div class="d-flex flex-column mt-5 mb-4 justify-content-center align-self-center text-center">
                    <div class="d-flex justify-content-center align-self-center text-center" style="width: 400px; height: auto;">
                        <hr class="w-25">
                        <p class="w-50 m-0 " style="font-weight: 600;"> 본인확인 이메일 인증 </p>
                        <hr class="w-25">
                    </div>

                    <table class="" style="width: 400px;">
                        <tr>
                            <th class="pt-3" style="width: 95.6px; text-align: left;">이메일 </th>
                            <td class="pt-3"><input type="email" id="userEmail" name="userEmail" class="form-control" placeholder="이메일 입력" required></td>
                        </tr>
                        <tr>
                            <th></th>
                            <td class="d-flex justify-content-end pt-2 pb-3">                                        
                                <button type="button" class="ldBtn btn-sm" id="mailBtn" onclick="fn_enrollEmailAut();">인증번호 발송</button>
                            </td>
                        </tr>
                    </table>
                    <table id="autCodeInputTb" style="width: 400px; display: none;">
                        <div>
                        	<tr>
                        		<td colspan='2'>
                        			<div class="alert alert-success m-1 mb-3 p-2 text-center">
                                   		인증코드가 발송되었습니다.<br>
                        				메일을 확인해주세요.
                                	</div>
                        		</td>
                        	</tr>
                            <tr>
                       			<input type="hidden" id="authenticationKey" name="authenticationKey"/>                            
                                <th style="width: 95.6px; text-align: left;">인증코드</th>
                                <td><input type="text" id="autCode" name="autCode" class="form-control" placeholder="인증코드 입력" required></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td class="d-flex justify-content-end pt-2 pb-2">
                                    <input type="button" class="ldBtn btn-sm" id="autCodeCheckBtn" onclick="fn_autCodeCheck()" value="본인인증 확인">
                                </td>
                            </tr>
                        </div>
                    </table>
                    <hr  style="width: 400px;">
                </div>

                <div class="d-flex flex-column mt-5 mb-3 justify-content-center align-self-center text-center" style="width: 400px; height: auto;">
                    <p class="m-0 " style="font-weight: 600;">회원님의 여행 관심사를 알려주세요<span>&#x1F60A</span></p>                  
                </div>              
                
                <div class="form-group d-flex flex-column justify-content-center mt-4" style="width: 400px;">
                    <p class="mb-2 ml-2 align-items-start">관심지역을 <strong>선택</strong>해주세요.</p>
                    <div class="form-group">
                        <select name="likeArea" class="form-control" id="likeAreaSelect" required>
                          <option value="" disabled selected>관심지역 선택</option>
                          <option>서울</option>
                          <option>부산</option>
                          <option>대구</option>
                          <option>인천</option>
                          <option>광주</option>
                          <option>대전</option>
                          <option>울산</option>
                          <option>세종</option>
                          <option>경기</option>
                          <option>강원</option>
                          <option>충청북도</option>
                          <option>충청남도</option>
                          <option>전라북도</option>
                          <option>전라남도</option>
                          <option>경상북도</option>
                          <option>경상남도</option>
                          <option>제주도</option>
                        </select>                                    
                    </div>
                    <input type="hidden" id="likeArea" name="likeArea">
                </div>

                <div class="form-group d-flex flex-column flex-wrap justify-content-center" style="width: 400px;">
                    <p class="mb-2 ml-2 align-items-start">관심태그를 <strong>클릭</strong>해주세요. (최대 5개)</p>
                    <div class="checkbox border text-center p-2 rounded-lg">
                        <input type="checkbox" name="likeTag" id="cb1" value="혼자여행"><label for="cb1">#혼자여행</label>
                        <input type="checkbox" name="likeTag" id="cb2" value="가족여행"><label for="cb2">#가족여행</label>
                        <input type="checkbox" name="likeTag" id="cb3" value="우정여행"><label for="cb3">#우정여행</label>
                        <input type="checkbox" name="likeTag" id="cb4" value="커플여행"><label for="cb4">#커플여행</label>
                        <input type="checkbox" name="likeTag" id="cb5" value="맛집투어"><label for="cb5">#맛집투어</label>
                        <input type="checkbox" name="likeTag" id="cb6" value="카페투어"><label for="cb6">#카페투어</label>
                        <input type="checkbox" name="likeTag" id="cb7" value="관광지_탐방"><label for="cb7">#관광지_탐방</label>
                        <input type="checkbox" name="likeTag" id="cb8" value="힐링"><label for="cb8">#힐링</label>
                        <input type="checkbox" name="likeTag" id="cb9" value="축제"><label for="cb9">#축제</label>
                        <input type="checkbox" name="likeTag" id="cb10" value="인생샷"><label for="cb10">#인생샷</label>
                        <input type="checkbox" name="likeTag" id="cb11" value="숨은_명소"><label for="cb11">#숨은_명소</label>
                        <input type="checkbox" name="likeTag" id="cb12" value="액티비티"><label for="cb12">#액티비티</label>
                        <input type="checkbox" name="likeTag" id="cb13" value="당일치기"><label for="cb13">#당일치기</label>
                        <input type="checkbox" name="likeTag" id="cb14" value="주말여행"><label for="cb14">#주말여행</label>
                        <input type="checkbox" name="likeTag" id="cb15" value="캠핑"><label for="cb15">#캠핑</label>
                    </div>
                </div>


                <input type="submit" class="ldBtnSubmit btn-block mt-5 mb-4 w-50" value="회원가입">
                
            </form>

        </div>

    </div>
</section>


    <!-- 아이디 글자수 안내 모달 -->
    <div class="modal" id="idLengthCheck">
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
            	아이디를 5 자 이상 입력해주세요!
            </div>
            
            <!-- Modal footer -->
            <div class="modal-footer border-top-0">
            <button type="button" class="ldBtnSubmit modal-close" data-dismiss="modal">Close</button>
            </div>
            
        </div>
        </div>
    </div>


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
            <button type="button" class="ldBtnSubmit modal-close" data-dismiss="modal">Close</button>
            </div>
            
        </div>
        </div>
    </div>
    
        
    <!-- 아이디 중복체크 Modal -->
    <div class="modal" id="duplicateId">
        <div class="modal-dialog">
        <div class="modal-content">
        
            <!-- Modal Header -->
            <div class="modal-header border-bottom-0">
            <h4 class="modal-title">아이디 중복확인</h4>
            <button type="button" class="close modal-close" data-dismiss="modal">&times;</button>
            </div>
            
            <!-- Modal body -->
            <div class="modal-body">
            	<div id="idModal_result">
            	</div>
            </div>
            
            <!-- Modal footer -->
            <div class="modal-footer border-top-0">
            <button type="button" class="ldBtnSubmit modal-close" data-dismiss="modal">Close</button>
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
            <button type="button" class="ldBtnSubmit modal-close" data-dismiss="modal">Close</button>
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
            <button type="button" class="ldBtnSubmit modal-close" data-dismiss="modal">Close</button>
            </div>
            
        </div>
        </div>
    </div>


    <!-- 이메일 인증코드 확인 Ajax 모달 -->
    <div class="modal" id="enrollEmailAut">
        <div class="modal-dialog">
        <div class="modal-content">
        
            <!-- Modal Header -->
            <div class="modal-header border-bottom-0">
            <h4 class="modal-title">이메일 인증</h4>
            <button type="button" class="close modal-close" data-dismiss="modal">&times;</button>
            </div>
            
            <!-- Modal body -->
            <div class="modal-body">
            	<div id="enrollEmailAut_result">
            	</div>
            </div>
            
            <!-- Modal footer -->
            <div class="modal-footer border-top-0">
            <button type="button" class="ldBtnSubmit modal-close" data-dismiss="modal">Close</button>
            </div>
            
        </div>
        </div>
    </div>


    <!-- 이메일 인증코드 글자수 안내 모달 -->
    <div class="modal" id="autCodeCheck">
        <div class="modal-dialog">
        <div class="modal-content">
        
            <!-- Modal Header -->
            <div class="modal-header border-bottom-0">
            <!-- <h4 class="modal-title">Modal Heading</h4> -->
            <button type="button" class="close modal-close" data-dismiss="modal">&times;</button>
            </div>
            
            <!-- Modal body -->
            <div class="modal-body" id="autCodeCheck_result">
            </div>
            
            <!-- Modal footer -->
            <div class="modal-footer border-top-0">
            <button type="button" class="ldBtnSubmit modal-close" data-dismiss="modal">Close</button>
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
    
    
    //Ajax 아이디 중복확인
    function fn_duplicateId(){
		let userId = $("#userId").val();
		
		if( userId.trim().length<5){
			$("#idLengthCheck").show();
			return;
		} else {   	
	    	$("#duplicateId").show();
	    	
    		let xhr = new XMLHttpRequest();
    		
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status == 200){						
						//xhr객체의 responseText에 데이터를 저장
						$("#idModal_result").html(xhr.responseText);
					} else if(xhr.status == 404){
						alert("404 error")
					}
				}
			}
			//전송에 대한 설정 : open()함수
			
			xhr.open("get","<%=request.getContextPath()%>/user/idCheck.do?userId="+userId);
			
			//전송! : send()
			xhr.send();
		}
	}//Ajax 아이디 중복확인 닫기
	
	$(".modal-close").click(()=>{
	    $("#duplicateId").hide();
		$("#idLengthCheck").hide();
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
	    $("#duplicateId").hide();
		$("#idLengthCheck").hide();
	    $("#duplicateNickName").hide();
		$("#nickNameLengthCheck").hide();
		$("#emailCheck").hide();
		$("#enrollEmailAut").hide();
		$("#autCodeCheck").hide();		
	});

		
    //Ajax 이메일 인증
    function fn_enrollEmailAut(){
		let userEmail = $("#userEmail").val();
		
		if($("#userEmail").val()===""){
			$("#emailCheck").show();
			return;
		} else {   	
	    	$("#autCodeInputTb").show();
	    	
    		let xhr = new XMLHttpRequest();
    		
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status == 200){						
						//xhr객체의 responseText에 데이터를 저장
						$("#authenticationKey").html(xhr.responseText);
					} else if(xhr.status == 404){
						alert("404 error")
					}
				}
			}
			//전송에 대한 설정 : open()함수
			
			xhr.open("get","<%=request.getContextPath()%>/user/enrollEmailAut.do?userEmail="+userEmail);
			
			//전송! : send()
			xhr.send();
		}
	}//Ajax 이메일 인증 닫기
	
	
	//보낸 인증코드 = 유저코드 비교
	function fn_autCodeCheck(){
		let autCode = $("#autCode").val(); //유저가 입력한 코드
		let authenticationKey = $("#authenticationKey").text(); //라온이 보낸 코드
		
		if($("#autCode").val()===""){
			$("#autCodeCheck_result").html("<span class='ml-2'>&#x274C</span><span id='autCodeCheckEnd'>인증코드가 <span style='color:red;'>틀렸습니다.</span> 정확히 입력해주세요.</span>");
			$("#autCodeCheck").show();
			return;
		} else if(autCode !== authenticationKey) {
			$("#autCodeCheck_result").html("<span class='ml-2'>&#x274C</span><span id='autCodeCheckEnd'>인증코드가 <span style='color:red;'>틀렸습니다.</span> 정확히 입력해주세요.</span>");   	
			$("#autCodeCheck").show();
		} else if(autCode === authenticationKey){
			$("#autCodeCheck_result").html("<span class='ml-2'>&#x1F44D</span><span id='autCodeCheckEnd'>인증이 <span style='color:green;'>완료되었습니다!</span> 가입을 진행해주세요.</span>");  
			$("#autCodeCheck").show(); 			
		}
	}	
	
	
	//gender Select > Option에서 값 받기
	$("#genderSelect").change(()=>{
		let ckOption = $("#genderSelect option:checked").text();
        $("#gender").val(ckOption);
    });
	
	
	//likeArea Select > Option에서 값 받기
	$("#likeAreaSelect").change(()=>{
		let ckOption = $("#likeAreaSelect option:checked").text();
        $("#likeArea").val(ckOption);
    });
	
	
	//중복 아이디 + 중복 닉네임 + 틀린 인증코드 가입방지
    function fn_checkEnd(){
		//아이디
        let idMD = $("#idCheckEnd").text();
		//닉네임
        let nnMD = $("#nickNameCheckEnd").text();
		//인증코드
		let autP = $("#autCodeCheckEnd").text();
		
        if(idMD==="(은)는 이미 사용중인 아이디입니다."){
        	alert("중복된 아이디는 가입할 수 없습니다.");
        	return false;
        }else if($("#idCheckEnd").length===0){
        	alert("아이디 중복확인을 해주세요.");
        	return false;
        }
        if(nnMD==="(은)는 이미 사용중인 닉네임입니다."){
        	alert("중복된 닉네임은 가입할 수 없습니다.");
        	return false;
        }else if($("#nickNameCheckEnd").length===0){
        	alert("닉네임 중복확인을 해주세요.");
        	return false;
        }
        if(autP!=="인증이 완료되었습니다! 가입을 진행해주세요."){
        	alert("메일인증을 다시 시도해주세요.");
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
<%@ include file="/views/common/footer.jsp"%> 