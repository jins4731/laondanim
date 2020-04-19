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

import com.laon.common.TagFilter;
import com.laon.tripinfo.model.service.TripInfoService;
import com.laon.tripinfo.model.vo.InfoTagCount;
import com.laon.tripinfo.model.vo.Mind;
import com.laon.tripinfo.model.vo.Picture;
import com.laon.tripinfo.model.vo.TripInfo2;
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
		
		String first = request.getParameter("first");
		first=first==null?"null":first;
		
		String type=request.getParameter("type");
		type = type==null?"상호명":type;
		
		String keyword = request.getParameter("keyword");
		keyword = keyword==null?"null":keyword;
		
		String mind = request.getParameter("mind");
		mind = mind==null?"null":mind;
		
		
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		int userNo = loginUser.getNo();
		//tag
		String userTag = loginUser.getTag();
		
		ArrayList<InfoTagCount> infoTagCountList = null;
		infoTagCountList = new TagFilter().infoTagCountList(userTag, category);
		
		for(InfoTagCount it : infoTagCountList) {
			System.out.println(it);
		}
		
		int cPage;
		
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		
		int numPerPage=10;
		
		TripInfoPicture ti = null;
		List<TripInfoPicture> list = new ArrayList<TripInfoPicture>();
				
		if(first.equals("first")) {
			for(int i=(cPage-1)*numPerPage; i<(cPage)*numPerPage; i++) {
				if(i<infoTagCountList.size()) {
					ti = new TripInfoPicture();
					
					ti.setTripinfoNo(infoTagCountList.get(i).getNo());
					ti.setTripinfoCategory(infoTagCountList.get(i).getCategory());
					ti.setTripinfoTag(String.join(",", infoTagCountList.get(i).getTag()));
					ti.setTripinfoName(infoTagCountList.get(i).getName());
					ti.setTripinfoAddress(infoTagCountList.get(i).getAddress());
					ti.setTripinfotime(infoTagCountList.get(i).getBusinessHours());
					ti.setTripinfoNumber(infoTagCountList.get(i).getTel());
					ti.setTripinfoHomePage(infoTagCountList.get(i).getHomepage());
					ti.setTripinfoNaver(infoTagCountList.get(i).getNaver());
					ti.setTripinfoSns(infoTagCountList.get(i).getSNS());
					
					list.add(ti);
				}
			}
		}else {
			list =new TripInfoService().selectTripinfoList(cPage,numPerPage,category,type,keyword,mind);
		}
		
			
		List<Mind> mindList = new TripInfoService().selectMind();
			
		List<Mind> heartCount = new TripInfoService().heartCount(list);
		
		
		
		//TripInfoPicture list로 picture list 가져오기
		ArrayList<Picture> pictureList = new TripInfoService().selectPicture((ArrayList<TripInfoPicture>)list);
		
		//TripInfoPicture list로 tripinfo_comment list 가져오기
		List<TripInfoComment> commentList = new TripInfoService().selectComment();
		
		int totalDate=new TripInfoService().selectCountTripInfo(category,type,keyword);
		int totalPage=(int)Math.ceil((double)totalDate/numPerPage);
		
		String pageBar="<ul class=\"pagination justify-content-center\"> <li class='page-item'><a class='page-link' href='' area-label='Previous'>&laquo;</a></li>";
		int pageBarSize=5;
		
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		
		if(pageNo==1) {
			pageBar+="<li class='page-item'><a class='page-link' href='' area-label='Previous'>&lt;</a></li>";
		}else {
			pageBar+="<li class='page-item'><a class='page-link' href='"+request.getContextPath()+"/tripinfo/tripinfoMain?cPage="+(pageNo-1)
					+"&category="+category+"&type="+type+"&keyword="+keyword+"&mind="+mind+"&first="+first+"' area-label='Previous'>&lt;</a></li>";
					
					
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<li class='page-item'><a class='page-link' href=''>"+pageNo+"</a></li>";
			}else {
				pageBar+="<li class='page-item'><a class='page-link' href='"+request.getContextPath()+"/tripinfo/tripinfoMain?cPage="+pageNo+"&category="+category+"&type="+type+"&keyword="+keyword+"&mind="+mind+"&first="+first+"'>"+pageNo+"</a></li>";											
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<li class='page-item'><a class='page-link' href='' area-label='Previous'>&gt;</a></li>";
		}else {
			pageBar+="<li class='page-item'><a class='page-link' href='"+request.getContextPath()+"/tripinfo/tripinfoMain?cPage="+pageNo+"&category="+category+"&type="+type+"&keyword="+keyword+"&mind="+mind+"&first="+first+"' area-label='Previous'>&gt;</a></li>";
					
		}
		pageBar +=
				  "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&raquo;</a></li> </ul>"
				 ;
		
		request.setAttribute("pageBar", pageBar);
		
		request.setAttribute("list", list);
		
		request.setAttribute("totalData",totalDate);
		
		request.setAttribute("heartCount", heartCount);
		
		request.setAttribute("mindList", mindList);		
		
		request.setAttribute("pictureList", pictureList);
		
		request.setAttribute("first", first);
		
		request.setAttribute("commentList",commentList);
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
