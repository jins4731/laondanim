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
		//ȸ���� �� input������ �޾� DB�� ����
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
		
		//��������� Date�� ����
		java.sql.Date birthday = java.sql.Date.valueOf(inputBirthday);
		
		//�����±� ��ġ��
		String strLikeTag = String.join(",", likeTag);
		String tag = likeArea + "," + strLikeTag;
		
		//User ��ü�� ����
		User u = new User(0, null, userId, password, name, nickName, birthday, gender, phone, email, tag);
		
		//JDBC
		int result = new UserService().userInsert(u);

		//���������� �ۼ��ϱ�
		String msg="";
		String loc="";
		if(result>0) {
			//ȸ�����Լ���
			msg="��´ٴԿ� ���Ű��� ȯ���մϴ� :)";
			loc="";
		}else {
			//ȸ�����Խ���
			msg="ȸ�����Կ� �����Ͽ����ϴ�. �ٽ� �õ����ּ���.";
			//ȸ������������
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
