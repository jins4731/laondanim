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

import com.laon.donghang.model.vo.Donghang;
import com.laon.mypage.model.service.MypageService;

/**
 * Servlet implementation class MyPageDongMyDHServlet
 */
@WebServlet("/myPage/myDongMyDH")
public class MyPageDongMyDHServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageDongMyDHServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = getCurrentPage(request);
		int pagePerRow = 20;
		
		List<Donghang> myDong=new MypageService().selectMyDHAll(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow));
		int myDHCount = new MypageService().selectMyTripCount();
		String myDHPasing = getPageBar(myDHCount, currentPage, pagePerRow, request, "/myPage/myConTrip");
		
		request.setAttribute("myDong", myDong);
		request.setAttribute("myDHPasing", myDHPasing);
		request.setAttribute("myDHCount", myDHCount);
		request.getRequestDispatcher("/views/mypage/myDongMyDH.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
