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
 * Servlet implementation class userEnrollEndServlet
 */
@WebServlet(name="UserEnrollEndServlet", urlPatterns="/user/enrollEnd.do")
public class UserEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원이 쓴 input내용을 받아 DB에 저장
		String userId = request.getParameter("userId");
		String password = request.getParameter("userPw");
		String name = request.getParameter("userName");
		String nickName = request.getParameter("userNickName");
		String inputBirthday = request.getParameter("userBirth");
		String gender = request.getParameter("gender");
		int phone = Integer.parseInt(request.getParameter("userPhone"));
		String email = request.getParameter("userEmail");
		String likeArea = request.getParameter("likeArea");
		String[] likeTag = request.getParameterValues("likeTag");
		
		//생년월일을 Date로 변경
		java.sql.Date birthday = java.sql.Date.valueOf(inputBirthday);
		
		//관심태그 합치기
		String strLikeTag = String.join(",", likeTag);
		String tag = likeArea + "," + strLikeTag;
		
		//User 객체에 저장
		User u = new User(0, null, userId, password, name, nickName, birthday, gender, phone, email, tag);
		
		//JDBC
		int result = new UserService().userInsert(u);

		//응답페이지 작성하기
		String msg="";
		String loc="";
		if(result>0) {
			//회원가입성공
			msg="라온다님에 오신것을 환영합니다 :)";
			loc="";
		}else {
			//회원가입실패
			msg="회원가입에 실패하였습니다. 다시 시도해주세요.";
			//회원가입페이지
			loc="/user/enroll.do";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc",loc);
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
