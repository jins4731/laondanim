package com.laon.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laon.user.model.service.UserService;
import com.laon.user.model.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//로그인시 디비에 있는 데이터와 비교하여 로그인 하게 함.
		String id=request.getParameter("userId");
		String pw=request.getParameter("password");
		//클라이언트가 보낸 데이터가 db에 있는 Member테이블에 있는지 확인
		
		User u=new UserService().login(id,pw);
		System.out.println("유저 존재하는지:"+u);
		//세션 만들어주기
		if(u!=null) {//로그인 성공했을떄
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", u);
			/* request.getRequestDispatcher("/").forward(request, response); */
			//아이디 저장 위한 쿠키 설정
			 System.out.println(request.getParameter("saveId"));
			 String saveId=request.getParameter("saveId");
			 Cookie c=new Cookie("saveId",u.getUserId());
			 if(saveId!=null) {
				 //쿠키에 로그인한 아이디 저장
				 c.setMaxAge(3*24*60*60);
				 //쿠키값 저장 메소드 실행
			 }else {
				 c.setMaxAge(0);				 
			 }
			 response.addCookie(c);
			 response.sendRedirect(request.getContextPath());
			
		}else {//로그인 실패했을때
			
			request.setAttribute("msg", "아이디나 비밀번호가 일치하지 않습니다");
			request.setAttribute("loc", "/");//메인으로 이동
			RequestDispatcher rd=request.getRequestDispatcher("/views/common/msg.jsp");
			rd.forward(request, response);
		
		
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
