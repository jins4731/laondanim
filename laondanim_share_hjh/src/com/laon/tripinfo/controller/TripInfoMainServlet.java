package com.laon.tripinfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.tripinfo.model.service.TripInfoService;
import com.laon.tripinfo.model.vo.TripInfo;
import com.laon.tripinfo.model.vo.TripInfoComment;

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
		String type=request.getParameter("searchType");
		String key=request.getParameter("searchKeyword");
	
		
		int cPage;
		
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		
		int numPerPage=10;
			
		List<TripInfo> list=new TripInfoService().selectTripinfoList(cPage,numPerPage,category,type,key);
		
		int totalDate=new TripInfoService().selectCountTripInfo(category,type,key);
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
			+"&category="+category
			+"'>[이전]</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()
				+"/tripinfo/tripinfoMain?cPage="+pageNo
				+"&category="+category
				+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/tripinfo/tripinfoMain?cPage="+pageNo
			+"&category="+category
			+"'>[다음]</a>";
		}
		
		request.setAttribute("pageBar", pageBar);
		
		request.setAttribute("list", list);
		
		request.setAttribute("totalData",totalDate);
		
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
