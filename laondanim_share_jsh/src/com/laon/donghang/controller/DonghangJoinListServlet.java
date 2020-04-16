package com.laon.donghang.controller;

import java.io.IOException;
import java.util.List;

import static com.laon.common.template.PageTemplate.getCurrentPage;
import static com.laon.common.template.PageTemplate.getEndNum;
import static com.laon.common.template.PageTemplate.getPageBar;
import static com.laon.common.template.PageTemplate.getStartNum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.CommonKey;
import com.laon.donghang.model.service.DonghangService;
import com.laon.donghang.model.vo.DonghangJoinDonghangJoinTb;
import com.laon.user.model.vo.UserProfile;

/**
 * Servlet implementation class DonghangJoinListServlet
 */
@WebServlet(name="DonghangJoinListServlet", urlPatterns = "/donghang/donghangJoinlist.do")
public class DonghangJoinListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonghangJoinListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 유저 no받기
		int userNo = Integer.parseInt(request.getParameter("userNo"));

		//유저가 만든 동행의 참여목록을 가져오기
		List<DonghangJoinDonghangJoinTb> joinList = new DonghangService().selectDonghangJoinList(userNo);
		
		//유저 목록 가져오기
		List<UserProfile> userList =  new DonghangService().selectUserProfileAll();
		
		//페이징		
		int currentPage = getCurrentPage(request);
		int pagePerRow = 8;		
		int totalRowCount = new DonghangService().selectJoinCount(userNo);
		String pageBar = getPageBar(totalRowCount, currentPage, pagePerRow, request, "/donghang/donghangJoinlist.do?userNo=");
		
		
		request.setAttribute(CommonKey.DONGHANG_JOIN_LIST, joinList);
		request.setAttribute(CommonKey.PAGE_BAR, pageBar);
		request.setAttribute(CommonKey.USER_LIST, userList);
		request.setAttribute(CommonKey.TOTAL_ROWCOUNT, totalRowCount);
		request.getRequestDispatcher("/views/donghang/donghangJoinList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
