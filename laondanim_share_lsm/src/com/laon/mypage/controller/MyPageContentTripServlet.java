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

import com.laon.mypage.model.service.MypageService;
import com.laon.trip.model.vo.TripMyCon;
import com.laon.user.model.vo.UserProfile;

/**
 * Servlet implementation class MyPageContentDetailServlet
 */
@WebServlet("/myPage/myConTrip.do")
public class MyPageContentTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageContentTripServlet() {
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
		
		List<TripMyCon> trip=new MypageService().selectMyTripAll(userNo,getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow));
		int tripCount = new MypageService().selectMyTripCount(userNo);
		String tripPasing = getPageBar(tripCount, currentPage, pagePerRow, request, "/myPage/myConTrip.do");
		
		List tripLike=new MypageService().selectTripLike(userNo);
		
		request.setAttribute("userProfile", up);
		request.setAttribute("tripLike", tripLike);
		
		request.setAttribute("trip", trip);
		request.setAttribute("tripPasing", tripPasing);
		request.setAttribute("tripCount", tripCount);
		request.getRequestDispatcher("/views/mypage/myConTrip.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
