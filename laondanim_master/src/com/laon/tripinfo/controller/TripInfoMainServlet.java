package com.laon.tripinfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laon.tripinfo.model.service.TripInfoService;
import com.laon.tripinfo.model.vo.Mind;
import com.laon.tripinfo.model.vo.TripInfoComment;
import com.laon.tripinfo.model.vo.TripInfoPicture;
import com.laon.user.model.vo.User;

/**
 * Servlet implementation class GuideMainServlet
 */
@WebServlet("/tripinfo/tripinfoMain")
public class TripInfoMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripInfoMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category=request.getParameter("category");
		
		String type=request.getParameter("type");
		type = type==null?"상호명":type;
		
		String keyword = request.getParameter("keyword");
		keyword = keyword==null?"null":keyword;
		
		String mind = request.getParameter("mind");
		mind = mind==null?"null":mind;
		
		
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		int userNo = loginUser.getNo();
		System.out.println("서블릿에서 userNo :"+userNo);
		
		List<TripInfoComment> commentList = new TripInfoService().selectComment();
		
		
		
		
		
		int cPage;
		
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		
		int numPerPage=10;
		
		/* 여행정보 리스트 가져오기 (카테고리)*/
//		List<TripInfoPicture> list=new TripInfoService().selectTripinfoList(cPage,numPerPage,category);
		List<TripInfoPicture> list=new TripInfoService().selectTripinfoList(cPage,numPerPage,category,type,keyword,mind);
		//모든 찜 목록 리스트
			
			List<Mind> mindList = new TripInfoService().selectMind();
			
			for(Mind mmm : mindList) {
				System.out.println("서블릿에서는?" + mmm);
			}
			
			
		
		
		
		
		//Mind vo 에 count 멤버변수를 로 만들고
		//dao 에서 나온 count(*) 값을 count 멤버 변수에 set하고 mind 테이블의 정보를 마찬가지로 Mind vo 에 대입
		
		//list 들을 밑에 heartCount에 넣고 
		//set 한다음 jsp로 전송
		//jsp 에서 해당 mind 리스트의 여행정보 no 값과 출력된 여행정보 게시글의 no 값을 비교해서 일치하는 mind vo 객체의 count 값을 찜 개수에 넣음 
		List<Mind> heartCount = new TripInfoService().heartCount(list);
		//LIST의 NO 를 매개 변수로 MIND_TB 에서 no와 일치하는 row 수를 세는 메소드 구현
		//SELECT * FROM MIND_TB WHERE TRIP_INFO_NO=?
		//여기서 row가 여러개 나올 수 도 있고 그렇지 않을 수 도 있음
	
		
		
		
		
		int totalDate=new TripInfoService().selectCountTripInfo(category,type,keyword);
		int totalPage=(int)Math.ceil((double)totalDate/numPerPage);
		
		String pageBar="";
		int pageBarSize=5;
		
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		
		if(pageNo==1) {
			pageBar+="<span>[이전]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/tripinfo/tripinfoMain?cPage="+(pageNo-1)
			+"&category="+category+"&type="+type+"&keyword="+keyword+"&mind="+mind
			+"'>[이전]</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()
				+"/tripinfo/tripinfoMain?cPage="+pageNo
				+"&category="+category+"&type="+type+"&keyword="+keyword+"&mind="+mind
				+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/tripinfo/tripinfoMain?cPage="+pageNo
			+"&category="+category+"&type="+type+"&keyword="+keyword+"&mind="+mind
			+"'>[다음]</a>";
		}
		
		request.setAttribute("pageBar", pageBar);
		
		request.setAttribute("list", list);
		
		request.setAttribute("totalData",totalDate);
		
		request.setAttribute("heartCount", heartCount);
		
		request.setAttribute("mindList", mindList);
		
		request.setAttribute("commentList",  commentList);
		
		request.getRequestDispatcher("/views/tripinfo/tripinfoMain.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
