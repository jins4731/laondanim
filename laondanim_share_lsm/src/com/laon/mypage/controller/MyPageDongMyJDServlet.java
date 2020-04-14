package com.laon.mypage.controller;

import static com.laon.common.MyPaging.getCurrentPage;
import static com.laon.common.MyPaging.getEndNum;
import static com.laon.common.MyPaging.getPageBar;
import static com.laon.common.MyPaging.getStartNum;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.donghang.model.vo.DonghangJoin;
import com.laon.donghang.model.vo.MyDong;
import com.laon.mypage.model.service.MypageService;
import com.laon.user.model.vo.UserProfile;

/**
 * Servlet implementation class MyPageDongMyJDServlet
 */
@WebServlet("/myPage/myDongMyJD.do")
public class MyPageDongMyJDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageDongMyJDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		UserProfile up=new MypageService().selectUserNo(userNo);
		
		int currentPage = getCurrentPage(request);
		int pagePerRow = 20;
		
		List<DonghangJoin> joinDong=new MypageService().selectJoin(userNo);
		List<MyDong> oriJoinDong=new MypageService().selectOriJoinAll(joinDong, getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow));
		List<UserProfile> userNick=new MypageService().selectUserNick(oriJoinDong);
		int myJDCount=new MypageService().selectMyJDCount(userNo);
		String myJDPasing = getPageBar(myJDCount, currentPage, pagePerRow, request, "/myPage/myDongMyJD.do");
		
		request.setAttribute("userProfile", up);
		
		request.setAttribute("joinDong", joinDong);
		request.setAttribute("oriJoinDong", oriJoinDong);
		request.setAttribute("userNick", userNick);
		request.setAttribute("myJDCount", myJDCount);
		request.setAttribute("myJDPasing", myJDPasing);
		request.getRequestDispatcher("/views/mypage/myDongMyJD.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
