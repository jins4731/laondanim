<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

<body>
    <form id="form1" action="<%=request.getContextPath()%>/testAjax" method="POST" enctype="multipart/form-data">
        <input type="text" name="text1">
        <input type="text" name="text2">
        <input type="file" name="file1" id="file1" multiple>

        <button type="button" name="bt1" onclick="requestAjax()">
            Ajax보내기 버튼</button>
        <button type="button" name="bt1" onclick="responseAjax()">
            Ajax가져오기 버튼</button>
        <input type="button" value="전송" id="submitBt">
    </form>

    <textarea name="textarea1" id="textarea1" cols="30" rows="10">
        dool.txt,moo.txt,cat.txt
    </textarea>


    <script>

        $("#submitBt").on("click",function(event){
        	 
        	var textarea1Arr = $("#textarea1").val().split(',');
            var json2 = {
                name: 'hong',
                age: 22
            };
            var jsonArray = new Array();
            for (let i = 0; i < 5; i++) {
                var json = {
                    name: 'honh' + i,
                    age: 22 + i
                };
                jsonArray.push(json);
            }
            var json = {name:jsonArray}
            
            console.log(jsonArray);
            console.log(textarea1Arr);
            
           
            var form = $("#form1")[0];
            var data = new FormData(form);
            data.append("ad",JSON.stringify(json));

            console.log(data);
            $.ajax({
                url: "<%=request.getContextPath()%>/testAjax",
                type: "post",
                enctype: "multipart/form-data", 
                data:data,
                processData: false,
                contentType: false,
                dataType: "html", //xml,html,script,json,jsonp,text
                success: function (data, status, xmlHttpRequest) {
                    console.log(data, status, xmlHttpRequest);
                    location.replace('<%=request.getContextPath()%>/');
                },
                error: function (xmlHttpRequest, status, error) {
                    console.log(xmlHttpRequest, status, error);
                },
                complete: function (xmlHttpRequest, status) {
                    console.log(xmlHttpRequest, status);
                }
            });
            
        });


        function requestAjax() {
            var textarea1Arr = $("#textarea1").val().split(',');
            var json2 = {
                name: '홍길동',
                age: 22
            };
            var jsonArray = new Array();
            for (let i = 0; i < 5; i++) {
                var json = {
                    name: '홍길동' + i,
                    age: 22 + i
                };
                jsonArray.push(json);
            }
            
            console.log(jsonArray);
            console.log(textarea1Arr);
            $.ajax({
                url: "<%=request.getContextPath()%>/testAjax",
                type: "post",
                data: JSON.stringify({list:jsonArray}),
                //application/json, application/javascript, application/xml, text/xml, text,html, text/plain
                contentType: "application/json", 
                dataType: "json", //xml,html,script,json,jsonp,text
                success: function (data, status, xmlHttpRequest) {
                    console.log(data, status, xmlHttpRequest);
                   
                },
                error: function (xmlHttpRequest, status, error) {
                    console.log(xmlHttpRequest, status, error);
                },
                complete: function (xmlHttpRequest, status) {
                    console.log(xmlHttpRequest, status);
                }
            });
        }
        
        function responseAjax(){
        	
        }

    </script>
</body>

</html>