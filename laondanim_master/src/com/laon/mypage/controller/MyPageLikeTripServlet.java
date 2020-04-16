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

import com.laon.etc.model.vo.Like;
import com.laon.mypage.model.service.MypageService;
import com.laon.trip.model.vo.TripMyCon;
import com.laon.user.model.vo.UserProfile;

/**
 * Servlet implementation class MyPageLikeTripServlet
 */
@WebServlet("/myPage/myLikeTrip.do")
public class MyPageLikeTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageLikeTripServlet() {
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
		
		List<Like> likeT=new MypageService().selectTripLike(userNo);
		List<TripMyCon> tripList=new MypageService().selectTripListAll(likeT, getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow));
		List<UserProfile> userNick=new MypageService().selectTripUserNick(tripList);
		int likeTripCount=new MypageService().selectLikeTripCount(userNo);
		String myLTPasing = getPageBar(likeTripCount, currentPage, pagePerRow, request, "/myPage/myLikeTrip.do");
		
		request.setAttribute("userProfile", up);
		
		request.setAttribute("likeT", likeT);
		request.setAttribute("tripList", tripList);
		request.setAttribute("userNick", userNick);
		request.setAttribute("likeTripCount", likeTripCount);
		request.setAttribute("myLTPasing", myLTPasing);
		
		request.getRequestDispatcher("/views/mypage/myLikeTrip.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
