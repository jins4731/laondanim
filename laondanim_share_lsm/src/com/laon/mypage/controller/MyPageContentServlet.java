package com.laon.mypage.controller;

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

import static com.laon.common.MyPaging.*;

/**
 * Servlet implementation class MyPageContentServlet
 */
@WebServlet("/myPage/myPageContent")
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
		int currentPage = getCurrentPage(request);
		int pagePerRow = 4;
		
		List<Trip> trip=new MypageService().selectMyTrip(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow));
		int tripCount = new MypageService().selectMyTripCount();
		String tripPasing = getPageBar(tripCount, currentPage, pagePerRow, request, "/myPage/myPageContent");
		
		List<Board> board=new MypageService().selectMyBoard(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow));
		int boardCount = new MypageService().selectMyBoardCount();
		String boardPasing = getPageBar(boardCount, currentPage, pagePerRow, request, "/myPage/myPageContent");
		
		request.setAttribute("trip", trip);
		request.setAttribute("tripPasing", tripPasing);
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
