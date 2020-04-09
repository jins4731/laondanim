package com.laon.mypage.controller;

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
 * Servlet implementation class MyPageDongServlet
 */
@WebServlet("/myPage/myPageDong.do")
public class MyPageDongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageDongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Donghang> myDong=new MypageService().selectMyDong();
		int myDongCount=new MypageService().selectMyDongCount();
		System.out.println(myDong);
		request.setAttribute("myDong", myDong);
		request.setAttribute("myDongCount", myDongCount);
		
		request.getRequestDispatcher("/views/mypage/myDong.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
