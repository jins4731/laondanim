package com.laon.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.user.model.service.UserService;

/**
 * Servlet implementation class AjaxUserIdDuplicateServlet
 */
@WebServlet("/user/idCheck.do")
public class AjaxUserIdDuplicateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxUserIdDuplicateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//화면에서 회원이 입력한 id값 받아오기
		String userId = request.getParameter("userId");
		//JDBC 아이디 중복 확인
		boolean isUseable = new UserService().userIdDuplicate(userId);
			//아이디가 있으면 true(=>사용불가 아이디)
		
		if(isUseable) {
			response.getWriter().write(
					"<span class='ml-2'>&#x274C</span>"+"<strong>"+userId+"</strong><span id='idCheckEnd'>(은)는 <span style='color:red;'>이미 사용중인</span> 아이디입니다.</span>");
		} else {
			response.getWriter().write("<span class='ml-2'>&#x1F44D</span>"+"<strong>"+userId+"</strong><span id='idCheckEnd'>는 <span style='color:green;'>사용가능한</span> 아이디입니다.</span>");
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
