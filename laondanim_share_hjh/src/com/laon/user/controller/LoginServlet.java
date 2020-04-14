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
		String id=request.getParameter("userId");
		String pw=request.getParameter("password");
		//�겢�씪�씠�뼵�듃媛� 蹂대궦 �뜲�씠�꽣媛� db�뿉 �엳�뒗 Member�뀒�씠釉붿뿉 �엳�뒗吏� �솗�씤
		
		User u=new UserService().login(id,pw);
		System.out.println("sasd:"+u);
		//�꽭�뀡 留뚮뱾�뼱二쇨린
		if(u!=null) {//濡쒓렇�씤 �꽦怨듯뻽�쓣�뻹
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", u);
			/* request.getRequestDispatcher("/").forward(request, response); */
			//�븘�씠�뵒 ���옣 �쐞�븳 荑좏궎 �꽕�젙
			 System.out.println(request.getParameter("saveId"));
			 String saveId=request.getParameter("saveId");
			 Cookie c=new Cookie("saveId",u.getUserId());
			 if(saveId!=null) {
				 //荑좏궎�뿉 濡쒓렇�씤�븳 �븘�씠�뵒 ���옣
				 c.setMaxAge(3*24*60*60);
				 //荑좏궎媛� ���옣 硫붿냼�뱶 �떎�뻾
			 }else {
				 c.setMaxAge(0);				 
			 }
			 response.addCookie(c);
			 response.sendRedirect(request.getContextPath());
			
		}else {//濡쒓렇�씤 �떎�뙣�뻽�쓣�븣
			
			request.setAttribute("msg", "로그인에 실패했습니다");
			request.setAttribute("loc", "/");//硫붿씤�쑝濡� �씠�룞
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
