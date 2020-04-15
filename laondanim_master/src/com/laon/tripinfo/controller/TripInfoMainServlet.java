package com.laon.tripinfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laon.tripinfo.model.service.TripInfoService;
import com.laon.tripinfo.model.vo.Mind;
import com.laon.tripinfo.model.vo.Picture;
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
		
		
		int cPage;
		
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		
		int numPerPage=10;
		
		List<TripInfoPicture> list=new TripInfoService().selectTripinfoList(cPage,numPerPage,category,type,keyword,mind);
			
		List<Mind> mindList = new TripInfoService().selectMind();
			
		List<Mind> heartCount = new TripInfoService().heartCount(list);
		
		//TripInfoPicture list로 picture list 가져오기
		ArrayList<Picture> pictureList = new TripInfoService().selectPicture((ArrayList<TripInfoPicture>)list);
		
		//TripInfoPicture list로 tripinfo_comment list 가져오기
		ArrayList<TripInfoComment> tripInfoCommentList = new TripInfoService().selectComment(list);
		
		int totalDate=new TripInfoService().selectCountTripInfo(category,type,keyword);
		int totalPage=(int)Math.ceil((double)totalDate/numPerPage);
		
		String pageBar="";
		int pageBarSize=5;
		
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		
		if(pageNo==1) {
			pageBar+="<span>이전</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/tripinfo/tripinfoMain?cPage="+(pageNo-1)
			+"&category="+category+"&type="+type+"&keyword="+keyword+"&mind="+mind
			+"'>이전</a>";
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
			pageBar+="<span>다음</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/tripinfo/tripinfoMain?cPage="+pageNo
			+"&category="+category+"&type="+type+"&keyword="+keyword+"&mind="+mind
			+"'>다음</a>";
		}
		
		request.setAttribute("pageBar", pageBar);
		
		request.setAttribute("list", list);
		
		request.setAttribute("totalData",totalDate);
		
		request.setAttribute("heartCount", heartCount);
		
		request.setAttribute("mindList", mindList);		
		
		request.setAttribute("pictureList", pictureList);
		
		request.setAttribute("tripInfoCommentList", tripInfoCommentList);
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
