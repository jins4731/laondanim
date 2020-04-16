package com.laon.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.user.model.service.UserService;
import com.laon.user.model.vo.User;

/**
 * Servlet implementation class AuthAlterPwServlet
 */
@WebServlet("/user/authPwck.do")
public class AuthAlterPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthAlterPwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//디비에 저장된 임시 비밀번호를 확인하는 로직
		String authId=request.getParameter("authId");
		String authPw=request.getParameter("authPw");
		User u=new UserService().login(authId,authPw);
		
		if(u.getNo()>0) {
			//일치하는 값이 있을때
			 response.setContentType("text/csv;charset=UTF-8");
			 response.getWriter().write("1");
			
		}else {
			 response.setContentType("text/csv;charset=UTF-8");
			 response.getWriter().write("0");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
