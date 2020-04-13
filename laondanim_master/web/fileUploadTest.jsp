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
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=40b8b885a553f3222dde4e5effec0d3e"></script>
    <link rel="stylesheet" href="css/mdb.min.css">
    <script src="js/mdb.min.js"></script>
</head>

<body>
    <form id="formId" action="<%=request.getContextPath() %>/test.do" method="post" enctype="multipart/form-data">
       
        <input type="text" id="fileNames" name="fileNames" value="">
        <input type="submit" value="전송">
    </form>
    <input type="text" name="user" placeholder="이름 입력" form="formId">
    <div id="previewContainer">
        <p>No files currently selected for upload</p>
    </div>


    <style>
        #carouselInner img {
            width: 100%;
            height: 500px;
            object-fit: contain;
        }
    </style>
    <div class="row p-5">
        <!-- 컨테이너 -->

        <div id="carouselContainer" class="col p-0 carousel slide rounded-sm bg-dark" data-ride="carousel">

            <!-- 인디케이터 -->
            <ul id="carouselIndicators" class="carousel-indicators">

            </ul>

            <!-- 이너 -->
            <div id="carouselInner" class="carousel-inner  d-inline-flex align-items-center"
                style="width:100%;height:500px;position: relative;">

                <div style="position:absolute;left: 50%;top: 50%;width: 50px;height: 50px;
        transform: translate(-50%,-50%);z-index: 1;"
                    class="d-inline-flex  view overlay zoom p-1 img-fluid align-items-center justify-content-center">

                    <img src="picture/trip/plus.png" alt="" style="object-fit: contain;width: 100%;height: 100%;">
                    <input type="file" id="file" name="file" multiple="true" accept="image/jpg, image/png"
                        style="width: 100%;height: 100%;position: absolute;" form="formId">
                </div>

                

                <!-- 사진 공간 -->



            </div>

            <a href="#carouselContainer" data-slide="prev" class="carousel-control-prev">
                <span class="carousel-control-prev-icon" style="width: 50px;height: 50px;"></span>
            </a>
            <a href="#carouselContainer" data-slide="next" class="carousel-control-next">
                <span class="carousel-control-next-icon" style="width: 50px;height: 50px;"></span>
            </a>
        </div>
    </div>


    <script>
        $(function(){
        	console.log("ㅎㅇㅎㅇ");
            $('.carousel-item').remove();
            $('#carouselIndicators').empty();
        });

        var input = document.querySelector('#file');
        var previewContainer = document.querySelector('#previewContainer');
        // input.style.opacity = 0;
        input.addEventListener('change', updateImageDisplay);
        /* $("#file").on("change", function (e) {
            console.log(e.target)
        }); */

        const fileTypes = [
            'image/jpeg',
            'image/pjpeg',
            'image/png'
        ];
        function validFileType(file) {
            return fileTypes.includes(file.type);
        }
        function returnFileSize(number) {
            if (number < 1024) {
                return number + 'bytes';
            } else if (number >= 1024 && number < 1048576) {
                return (number / 1024).toFixed(1) + 'KB';
            } else if (number >= 1048576) {
                return (number / 1048576).toFixed(1) + 'MB';
            }
        }

       
        function updateImageDisplay() {
            while (previewContainer.firstChild) {
                previewContainer.removeChild(previewContainer.firstChild);
            }
            const currentFiles = input.files;
            if (currentFiles.length === 0) { //추가된 파일이 하나도 없을대
                // 파일이 없음을 표시
            } else { // 추가된 파일이 있을때

            	var count = 0;
            	 var isActive = false;
            	  $('.carousel-item').remove();
                  $('#carouselIndicators').empty();
                for (const file of currentFiles) {
                	console.log("count :" + count);
                	console.log("isActive :" + isActive);
      
                    if (validFileType(file)) {
                        const img = $("<img>").attr("src", URL.createObjectURL(file));
                        const item = $('<div class="carousel-item">').append(img);
                        if(isActive == false){
                            item.addClass('active');
                        }    
                        const inner = $('#carouselInner').append(item);


                        const indicatorItem = $('<li>');
                        indicatorItem.attr("data-target", '#carouselContainer');
                        indicatorItem.attr("data-slide-to", count);
                        if(isActive == false){
                            indicatorItem.addClass("active");
                            isActive = true;
                           // console.log("count : " + count);
                        }
                        
                        const indicator = $('#carouselIndicators');
                        indicator.append(indicatorItem);

                        if(count == 0){
                            $("#fileNames").val(file.name+",")
                        }else{
                            $("#fileNames").val($("#fileNames").val() + file.name+",")
                        }
                        
                    } else {
                        console.log("잘못된 파일 접근입니다.");
                    }
                    count++;
                }
            }
        }

    </script>
</body>

</html>