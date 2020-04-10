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

import com.laon.board.model.vo.Board;
import com.laon.mypage.model.service.MypageService;
import com.laon.trip.model.vo.Trip;
import com.laon.trip.model.vo.TripMyCon;
import com.laon.user.model.vo.User;
import com.laon.user.model.vo.UserProfile;

/**
 * Servlet implementation class MyPageContentServlet
 */
@WebServlet("/myPage/myPageContent.do")
public class MyPageContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageContentServlet() {
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
		int pagePerRow = 5;
		
		List<TripMyCon> trip=new MypageService().selectMyTrip(userNo);
		int tripCount = new MypageService().selectMyTripCount();
		
		List<Board> board=new MypageService().selectMyBoard(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow));
		int boardCount = new MypageService().selectMyBoardCount();
		String boardPasing = getPageBar(boardCount, currentPage, pagePerRow, request, "/myPage/myPageContent.do");
		
		request.setAttribute("userProfile", up);
		
		request.setAttribute("trip", trip);
		request.setAttribute("tripCount", tripCount);
		
		request.setAttribute("board", board);
		request.setAttribute("boardPasing", boardPasing);
		request.setAttribute("boardCount", boardCount);
		request.getRequestDispatcher("/views/mypage/myContent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
