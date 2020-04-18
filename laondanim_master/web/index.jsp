<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@ include file="/views/common/header.jsp"%>

	<link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css"> .nanumsquare { font-family: 'NanumSquare', sans-serif !important; }
	<style type="text/css">
	/* 카테고리 제목 폰트 */
	@font-face { font-family: 'Cafe24Danjunghae'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Danjunghae.woff') format('woff'); font-weight: normal; font-style: normal; }
	/* 본문 폰트 */
	@font-face { font-family: 'S-CoreDream-4Regular'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-4Regular.woff') format('woff'); font-weight: normal; font-style: normal; }
	
			
	section > div {
		font-family: 'Open Sans';
		font-style: normal;
		text-align: center;
		position: relative;
		top: 50%;  
		transform: translateY(-50%);
		height: 100%;
	}


	/* span {
		font-size: 4em;
		font-style: normal;
		color: #fff;
	} */

	/*여기서부터 내가 넣은 코드*/
	#myVideo {
		position: fixed;
		right: 0;
		bottom: 0;
		min-width: 100%;
		min-height: 100%;
	}
	.pTitle{
		font-size: 55px;
		/* font-weight: 700; */
		color: white;
		text-shadow: 0 0 8px #000000;
		letter-spacing: 3px;
		font-family: Cafe24Danjunghae;
	}
	.pHr{
		width: 800px;
		height: 3px;
		border: none;
		background-image: linear-gradient(to right, rgba(255, 255, 255, 0),white, rgba(255, 255, 255, 0));
		margin-bottom: 30px;
	}
	.pAdd{
		font-size: 17px;
		margin-bottom: 8px;
		letter-spacing: 0.8px;
		color: white;
		text-shadow: 0 0 3px #595959;
		font-family: S-CoreDream-4Regular;
	}
	.pBody{
		margin: 0px;
		font-size: 35px;
		/* letter-spacing: 1.2px; */
		color: white;
		text-shadow: 0 0 5px #595959;
		font-family: S-CoreDream-4Regular;		
	}
	#videoDiv{
		position: absolute; 
		height: 100%; 
		width: 100%; 
		background-color: #cce8ef;
		z-index: -5;
	}
	.flexColumnBox{
		width: 100%;
		height: 350px;
		background-color: #0000004d;
	}

	</style>
	


	<div id="videoDiv">
		<%  Random random = new Random();
			int rd = random.nextInt(3); 
			%>
		<video autoplay muted loop id="myVideo">
			<source src="<%=request.getContextPath()%>/main/video/<%=rd%>.mp4" type="video/mp4">
		</video>		
	</div>
	<div id="main" class="scroll-container">

		<section class="section1">					
		</section>
		<section class="section2"> <!--여행기-->
			<div class="d-flex justify-content-center align-items-center w-100">
				<div class="d-flex flex-column justify-content-center flexColumnBox">
					<div>
						<p class="pTitle">#여행기</p>
						<hr class="pHr">
					</div>
					<div>
						<p class="pAdd">나만 알고 있는 우리동네 힐링 산책로부터 제대로 즐기는 제주도 본전뽑기 코스까지</p>
						<p class="pBody">국내여행가들을 위한 여행 정보공유 게시판</p>
					</div>
				</div>
			</div>
		</section>
		<section class="section3">
			<div class="d-flex justify-content-center align-items-center w-100">
				<div class="d-flex flex-column justify-content-center flexColumnBox">
					<div>
						<p class="pTitle">#여행정보</p>
						<hr class="pHr">
					</div>
					<div>
						<p class="pAdd">여행일정 짜느라 힘드셨죠? 이제 라온다님이 도와드릴게요!</p>
						<p class="pBody">라온다님이 추천하는 국내 여행지 정보</p>
					</div>
				</div>			
			</div>
		</section>
		<section class="section4">
			<div class="d-flex justify-content-center align-items-center w-100">
				<div class="d-flex flex-column justify-content-center flexColumnBox">
					<div>
						<p class="pTitle">#동행찾기</p>
						<hr class="pHr">
					</div>
					<div>
						<p class="pAdd">"나랑 같이 여행 갈 사람? 선착순 1명!"</p>
						<p class="pBody">혼자는 심심한 당신을 위해 동행찾기 게시판</p>
					</div>
				</div>			
			</div>
		</section>
		<section class="section5">
				<div class="d-flex justify-content-center align-items-center w-100">
					<div class="d-flex flex-column justify-content-center flexColumnBox">
						<div>
							<p class="pTitle">#게시판</p>
							<hr class="pHr">
						</div>
						<div>
							<p class="pAdd">"제주도 맛집리스트 좀 공유합시다"</p>
							<p class="pBody">사담부터 질문까지 함께 나누는 자유게시판</p>
						</div>
					</div>			
				</div>			
		</section>

	</div>

<!---------------------------------------------------------------------------------------------------- 스타일 -------->	
<style>
body, html {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	overflow: hidden;
}

.scroll-container {
	width: 100%;
	height: 100%;
	position: relative;
	margin: 0;
	padding: 0;
	background-color: none;
}

.scroll-container section {
	width: 100%;
	height: 100%;
}

.dots {	
	z-index: 1;
	list-style: none;
	padding: 0;
	position: absolute;	
    top: 50%;
    -webkit-transform: translateY(-50%);
	-moz-transform: translateY(-50%);
	-o-transform: translateY(-50%);
	-ms-transform: translateY(-50%);
    transform: translateY(-50%);
}

.dots li a {
	padding: 10px;
	width: 4px;
	height: 5px;
	display: block;
}

.dots li a:before {
	content: '';
	position: absolute;
	width: 8px;
	height: 8px;
	background: rgba(255, 255, 255, 0.48);
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	-ms-border-radius: 10px;
	-o-border-radius: 10px;
	border-radius: 10px;	
	-webkit-transition: -webkit-transform 0.3s ease, background-color 0.3s ease;
	-moz-transition: -moz-transform 0.3s ease, background-color 0.3s ease;
	-ms-transition: -ms-transform 0.3s ease, background-color 0.3s ease;
	-o-transition: -o-transform 0.3s ease, background-color 0.3s ease;
	transition: transform 0.3s ease, background-color 0.3s ease;
}

.dots li a.active:before {
	content: '';
	background-color: #FFFFFF;
	width: 14px;
	height: 14px;
	margin-top: -4px;
	left: 7px; 
	background-color: white;
	-webkit-transform: scale(1.0);
	-moz-transform: scale(1.0);
	-ms-transform: scale(1.0);
	-o-transform: scale(1.0);
	transform: scale(1.0);
}

.dots-right {
	left: 25px;
}

.dots-left {
	right: 10px;
}
</style>
<!---------------------------------------------------------------------------------------------------- 스타일 끝-------->	

<!---------------------------------------------------------------------------------------------------- js 시작 --------->

	<script>
/**
 * Full page
 */
 (function () {
	'use strict';
	
	/**
	 * Full scroll main function
	 */
	var fullScroll = function (params) {
		/**
		 * Main div
		 * @type {Object}
		 */
		var main = document.getElementById('main');
		
		/**
		 * Sections div
		 * @type {Array}
		 */
		var sections = main.getElementsByTagName('section');
		
		/**
		 * Full page scroll configurations
		 * @type {Object}
		 */
		var defaults = {
			container : main,
			sections : sections,
			animateTime : params.animateTime || 0.7,
			animateFunction : params.animateFunction || 'ease',
			maxPosition: sections.length - 1,
			currentPosition: 0,
			displayDots: typeof params.displayDots != 'undefined' ? params.displayDots : true,
			dotsPosition: params.dotsPosition || 'left'
		};

		this.defaults = defaults;
		/**
		 * Init build
		 */
		this.init();
	};

	/**
	 * Init plugin
	 */
	fullScroll.prototype.init = function () {
		this.buildSections()
			.buildDots()
			.buildPublicFunctions()
			.addEvents();

		var anchor = location.hash.replace('#', '').split('/')[0];
		location.hash = 0;
		this.changeCurrentPosition(anchor);
	};

	/**
	 * Build sections
	 * @return {Object} this(fullScroll)
	 */
	fullScroll.prototype.buildSections = function () {
		var sections = this.defaults.sections;
		for (var i = 0; i < sections.length; i++) {
			sections[i].setAttribute('data-index', i);
		}
		return this;
	};

	/**
	 * Build dots navigation
	 * @return {Object} this (fullScroll)
	 */
	fullScroll.prototype.buildDots = function () {		
		this.ul = document.createElement('ul');
		this.ul.classList.add('dots');
		this.ul.classList.add(this.defaults.dotsPosition == 'right' ? 'dots-right' : 'dots-left');
		var _self = this;
		var sections = this.defaults.sections;		

		for (var i = 0; i < sections.length; i++) {
			var li = document.createElement('li');
			var a = document.createElement('a');
		
			a.setAttribute('href', '#' + i);			
			li.appendChild(a);
			_self.ul.appendChild(li);
		}

		this.ul.childNodes[0].firstChild.classList.add('active');

		if (this.defaults.displayDots) {
			document.body.appendChild(this.ul);
		}

		return this;
	};

	/**
	 * Add Events
	 * @return {Object} this(fullScroll)
	 */
	fullScroll.prototype.addEvents = function () {
		
		if (document.addEventListener) {
			document.addEventListener('mousewheel', this.mouseWheelAndKey, false);
			document.addEventListener('wheel', this.mouseWheelAndKey, false);
			document.addEventListener('keyup', this.mouseWheelAndKey, false);
			document.addEventListener('touchstart', this.touchStart, false);
			document.addEventListener('touchend', this.touchEnd, false);
			window.addEventListener("hashchange", this.hashChange, false);

			/**
			 * Enable scroll if decive don't have touch support
			 */
			if(/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) {
				if(!('ontouchstart' in window)){
					document.body.style = "overflow: scroll;";
					document.documentElement.style = "overflow: scroll;";
				}
			}			

		} else {
			document.attachEvent('onmousewheel', this.mouseWheelAndKey, false);
			document.attachEvent('onkeyup', this.mouseWheelAndKey, false);
		}
		
		return this;
	};	

	/**
	 * Build public functions
	 * @return {[type]} [description]
	 */
	fullScroll.prototype.buildPublicFunctions = function () {
		var mTouchStart = 0;
		var mTouchEnd = 0;
		var _self = this;

		this.mouseWheelAndKey = function (event) {
			if (event.deltaY > 0 || event.keyCode == 40) {	
				_self.defaults.currentPosition ++;
				_self.changeCurrentPosition(_self.defaults.currentPosition);				
			} else if (event.deltaY < 0 || event.keyCode == 38) {
				_self.defaults.currentPosition --;
				_self.changeCurrentPosition(_self.defaults.currentPosition);	
			}
			_self.removeEvents();
		};

		this.touchStart = function (event) {
			mTouchStart = parseInt(event.changedTouches[0].clientY);
			mTouchEnd = 0;
		};

		this.touchEnd = function (event) {
			mTouchEnd = parseInt(event.changedTouches[0].clientY);
			if (mTouchEnd - mTouchStart > 100 || mTouchStart - mTouchEnd > 100) {
				if (mTouchEnd > mTouchStart) {
					_self.defaults.currentPosition --;
				} else {
					_self.defaults.currentPosition ++;					
				}
				_self.changeCurrentPosition(_self.defaults.currentPosition);
			}			
		};

		this.hashChange = function (event) {
			if (location) {
				var anchor = location.hash.replace('#', '').split('/')[0];
				if (anchor !== "") {
					if (anchor < 0) {
						_self.changeCurrentPosition(0);
					} else if (anchor > _self.defaults.maxPosition) {
						_self.changeCurrentPosition(_self.defaults.maxPosition);
					} else {
						_self.defaults.currentPosition = anchor;
						_self.animateScroll();
					}					
				}				
			}
		};

		this.removeEvents = function () {
			if (document.addEventListener) {
			document.removeEventListener('mousewheel', this.mouseWheelAndKey, false);
			document.removeEventListener('wheel', this.mouseWheelAndKey, false);
			document.removeEventListener('keyup', this.mouseWheelAndKey, false);
			document.removeEventListener('touchstart', this.touchStart, false);
			document.removeEventListener('touchend', this.touchEnd, false);

			} else {
				document.detachEvent('onmousewheel', this.mouseWheelAndKey, false);
				document.detachEvent('onkeyup', this.mouseWheelAndKey, false);
			}

			setTimeout(function(){
				_self.addEvents();
			}, 600);
		};

		this.animateScroll = function () {
			var animateTime = this.defaults.animateTime;
			var animateFunction = this.defaults.animateFunction;
			var position = this.defaults.currentPosition * 100;

			this.defaults.container.style.webkitTransform = 'translateY(-' + position + '%)';
			this.defaults.container.style.mozTransform = 'translateY(-' + position + '%)';
			this.defaults.container.style.msTransform = 'translateY(-' + position + '%)';
			this.defaults.container.style.transform = 'translateY(-' + position + '%)';
			this.defaults.container.style.webkitTransition = 'all ' + animateTime + 's ' + animateFunction;
			this.defaults.container.style.mozTransition = 'all ' + animateTime + 's ' + animateFunction;
			this.defaults.container.style.msTransition = 'all ' + animateTime + 's ' + animateFunction;
			this.defaults.container.style.transition = 'all ' + animateTime + 's ' + animateFunction;

			for (var i = 0; i < this.ul.childNodes.length; i++) {
					this.ul.childNodes[i].firstChild.classList.remove('active');
					if (i == this.defaults.currentPosition) {
					this.ul.childNodes[i].firstChild.classList.add('active');		
				}
			}
		};

		this.changeCurrentPosition = function (position) {
			if (position !== "") {
				_self.defaults.currentPosition = position;
				location.hash = _self.defaults.currentPosition;
			}	
		};

		return this;
	};
	window.fullScroll = fullScroll;
})();		
	</script>
	<script type="text/javascript">
	
		new fullScroll({
			displayDots: true,
			dotsPosition: 'left',
			animateTime: 0.7,
			animateFunction: 'ease'
		});
	</script>


<%@ include file="/views/common/footer.jsp"%> 
