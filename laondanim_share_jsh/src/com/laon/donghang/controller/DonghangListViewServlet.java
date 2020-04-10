package com.laon.donghang.controller;

import static com.laon.common.template.PageTemplate.getCurrentPage;
import static com.laon.common.template.PageTemplate.getEndNum;
import static com.laon.common.template.PageTemplate.getPageBar;
import static com.laon.common.template.PageTemplate.getStartNum;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.CommonKey;
import com.laon.donghang.model.service.DonghangService;
import com.laon.donghang.model.vo.Donghang;
import com.laon.donghang.model.vo.DonghangJoinUserPicture;
import com.laon.user.model.vo.User;

/**
 * Servlet implementation class DonghangListViewServlet
 */
@WebServlet("/donghang/donghangListView.do")
public class DonghangListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonghangListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("DonghangListViewServlet. doGet()");
		//해당 유저의 관심사 tag를 가져와서 배열만들기
		String userTag = request.getParameter("userTag");

		
		
		int currentPage = getCurrentPage(request);
		int pagePerRow = 10;
		
		List<DonghangJoinUserPicture> donghangList = new DonghangService().selectDonghangPage(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow), userTag);
		int totalRowCount = new DonghangService().selectDonghangCount();

		//page바 서블릿에서 구현
		int totalPageSize = (int) Math.ceil((double)totalRowCount/pagePerRow); // 총 페이지 갯수
		
		int pageBarSize = 5; // 페이지바 크기
		int pageBarFirst = ((currentPage-1)/pageBarSize)*pageBarSize+1; // 페이지바 첫번째 숫자
		int pageBarLast = pageBarFirst + pageBarSize-1; // 페이지바 마지막 숫자
		if(pageBarLast > totalPageSize) { // 페이지바 마지막 크기 보정
			pageBarLast = totalPageSize;
		}
		
		String pageBar = "";
		
		// 이전 버튼
		if(totalPageSize > pageBarSize&&!(pageBarLast==pageBarSize)) {
			pageBar += "<span><a href='"+request.getContextPath()+ "/donghang/donghangListView.do?userTag="+userTag +"&currentPage="+(pageBarFirst-1)+"'>"+"이전"+"</a></span>";
		}else {
			pageBar += "<span>"+"이전"+"</span>";
		}
		
		// 페이지 숫자
		for(int i = pageBarFirst;i <= pageBarLast;i++) {
			if(currentPage == i) 
			{
				pageBar += "<span>"+i+"</span>&nbsp;";
			}else {
				pageBar += "<span><a href='"+request.getContextPath()+ "/donghang/donghangListView.do?userTag="+userTag +"&currentPage="+i+"'>"+i+"</a></span>&nbsp;";
			}
		}
		
		// 다음 버튼
		if(totalPageSize > pageBarSize&&!(pageBarLast==totalPageSize)) {
			pageBar += "<span><a href='"+request.getContextPath()+ "/donghang/donghangListView.do?userTag="+userTag +"&currentPage="+(pageBarLast+1)+"'>"+"다음"+"</a></span>";
		}else {
			pageBar += "<span>"+"다음"+"</span>";
		}
		
		request.setAttribute(CommonKey.DONGHANG_LIST, donghangList);
		request.setAttribute(CommonKey.PAGE_BAR, pageBar);
		
		//총 콘텐츠 수 가져오기
//		int totalContent = new DonghangService().selectDonghangCount();이거 지우기
		request.setAttribute("totalRowCount", totalRowCount);
		

		
		
		request.getRequestDispatcher("/views/donghang/donghangList.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
