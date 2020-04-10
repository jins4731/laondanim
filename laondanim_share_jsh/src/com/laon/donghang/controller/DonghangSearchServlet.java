package com.laon.donghang.controller;

import static com.laon.common.template.PageTemplate.getCurrentPage;
import static com.laon.common.template.PageTemplate.getEndNum;
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

/**
 * Servlet implementation class DonghangFinderServlet
 */
@WebServlet("/donghang/donghangSearch.do")
public class DonghangSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonghangSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//검색키워드 값 받기
		String keyword = request.getParameter("searchKeyword");
		
		int currentPage = getCurrentPage(request);
		int pagePerRow = 10;
		
		List<Donghang> list = new DonghangService().selectDonghangKeyword(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow), keyword);
		int totalRowCount = new DonghangService().selectDonghangKeywordCount(keyword);

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
			pageBar += "<span><a href='"+request.getContextPath()+ "/donghang/donghangSearch.do?keyword="+ keyword +"&currentPage="+(pageBarFirst-1)+"'>"+"이전"+"</a></span>";
		}else {
			pageBar += "<span>"+"이전"+"</span>";
		}
		
		// 페이지 숫자
		for(int i = pageBarFirst;i <= pageBarLast;i++) {
			if(currentPage == i) 
			{
				pageBar += "<span>"+i+"</span>&nbsp;";
			}else {
				pageBar += "<span><a href='"+request.getContextPath()+ "/donghang/donghangSearch.do?keyword="+ keyword +"&currentPage="+i+"'>"+i+"</a></span>&nbsp;";
			}
		}
		
		// 다음 버튼
		if(totalPageSize > pageBarSize&&!(pageBarLast==totalPageSize)) {
			pageBar += "<span><a href='"+request.getContextPath()+ "/donghang/donghangSearch.do?keyword="+ keyword +"&currentPage="+(pageBarLast+1)+"'>"+"다음"+"</a></span>";
		}else {
			pageBar += "<span>"+"다음"+"</span>";
		}
		
		request.setAttribute(CommonKey.LIST, list);
		request.setAttribute(CommonKey.PAGE_BAR, pageBar);
		
		//총 콘텐츠 수 가져오기
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
