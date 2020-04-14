package com.laon.donghang.controller;

import static com.laon.common.template.PageTemplate.getCurrentPage;
import static com.laon.common.template.PageTemplate.getEndNum;
import static com.laon.common.template.PageTemplate.getPageBar;
import static com.laon.common.template.PageTemplate.getStartNum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.CommonKey;
import com.laon.common.DonghangKey;
import com.laon.common.Paging;
import com.laon.donghang.model.service.DonghangService;
import com.laon.donghang.model.vo.Donghang;
import com.laon.donghang.model.vo.DonghangJoinUserPicture;
import com.laon.user.model.vo.User;

/**
 * Servlet implementation class DonghangListViewServlet
 */
@WebServlet(name = "DonghangListViewServlet", urlPatterns = "/donghang/donghangListView.do")
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
		//첫화면을 위해 태그 가져오기
		String userTag = request.getParameter("userTag");
		userTag=(userTag==null?"null":userTag);
		//검색 키워드 값 가져오기 
		String keyword = request.getParameter("keyword");
		keyword=(keyword==null?"null":keyword);
		//최근순 클릭 recent값
		String recent = request.getParameter("recent");
		recent=(recent==null?"null":recent);
		//조회수순 클릭 viewcount값
		String viewcount = request.getParameter("viewcount");
		viewcount=(viewcount==null?"null":viewcount);
		//가까운일정순 클릭 
		String nearSchedule = request.getParameter("nearSchedule");
		nearSchedule=(nearSchedule==null?"null":nearSchedule);
		
		int currentPage = getCurrentPage(request);
		int pagePerRow = 10;
		
		List<DonghangJoinUserPicture> list = new ArrayList<DonghangJoinUserPicture>();
		//Tag를 기준으로 첫화면 이후 화면 나누면 안됨 어케 처리할까..?
//		if(userTag!=null) {
//			list = new DonghangService().selectDonghangTag(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow), userTag);
//		}else {
			list = new DonghangService().selectDonghangPage(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow), keyword, recent, viewcount, nearSchedule);
//		}
		
		int totalRowCount = new DonghangService().selectDonghangCount(keyword);
		
		String pageBar = new Paging().pageBar2(request.getContextPath()+"/donghang/donghangListView.do", totalRowCount, currentPage, pagePerRow, userTag, keyword, recent, viewcount, nearSchedule );
		
		//쿼리스트링 저장
		request.setAttribute(CommonKey.KEYWORD, keyword);
		
		request.setAttribute(CommonKey.DONGHANG_LIST, list);
		request.setAttribute(CommonKey.PAGE_BAR, pageBar);
		request.setAttribute(CommonKey.TOTAL_ROWCOUNT, totalRowCount);
		
		
		request.getRequestDispatcher("/views/donghang/donghangList.jsp").forward(request, response);
		
//		System.out.println(userTag+keyword+recent+viewcount+nearSchedule+"********************************");
//		for(DonghangJoinUserPicture dh : list) {
//			System.out.println("list : "+dh);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
