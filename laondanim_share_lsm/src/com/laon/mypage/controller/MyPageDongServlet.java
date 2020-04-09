package com.laon.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.donghang.model.vo.Donghang;
import com.laon.donghang.model.vo.DonghangJoin;
import com.laon.mypage.model.service.MypageService;
import com.laon.user.model.vo.User;

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
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		User u=new MypageService().selectUserNo(userNo);
		
		List<Donghang> myDong=new MypageService().selectMyDong();
		int myDongCount=new MypageService().selectMyDongCount();
		
//		List joinDong=new MypageService().selectJoinDong();
		
		request.setAttribute("user", u);
		
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
