package com.laon.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.laon.mypage.model.service.MypageService;
import com.laon.user.model.vo.UserProfile;

/**
 * Servlet implementation class MyPageInfoPwckEndServlet
 */
@WebServlet("/myPage/myPwckEnd.do")
public class MyPageInfoPwckEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageInfoPwckEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		String pw=request.getParameter("pw");
		
		boolean flag=new MypageService().selectPwck(userNo,pw);
		
		response.setContentType("application/json);charset=UTF-8");
		new Gson().toJson(flag,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
