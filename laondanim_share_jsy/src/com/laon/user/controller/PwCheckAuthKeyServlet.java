package com.laon.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PwCheckAuthKeyServlet
 */
@WebServlet("/user/checkPwKey.do")
public class PwCheckAuthKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwCheckAuthKeyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이메일로 발송된 인증번호가 세션에 저장된 인증번호와 같은지 확인하는 로직
		
				String AuthenticationKey=(String)request.getSession().getAttribute("AuthenticationKey");
				String AuthenticationUser=request.getParameter("userKey");
				String AuthId=(String)request.getSession().getAttribute("AuthId");
				
				//여기서 아이디를 *로 가려주기 !!
				
				
				
				
				if(!AuthenticationKey.equals(AuthenticationUser)) {
					response.getWriter().write("false");
					//일치하지 않을경우
				}else {
					response.getWriter().write("true");
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
