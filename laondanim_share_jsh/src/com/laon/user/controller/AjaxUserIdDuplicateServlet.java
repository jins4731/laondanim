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
		//ȭ�鿡�� ȸ���� �Է��� id�� �޾ƿ���
		String userId = request.getParameter("userId");
		//JDBC ���̵� �ߺ� Ȯ��
		boolean isUseable = new UserService().userIdDuplicate(userId);
			//���̵� ������ true(=>���Ұ� ���̵�)
		
		if(isUseable) {
			response.getWriter().write(
					"<span class='ml-2'>&#x274C</span>"+"<strong>"+userId+"</strong><span id='idCheckEnd'>(��)�� <span style='color:red;'>�̹� �������</span> ���̵��Դϴ�.</span>");
		} else {
			response.getWriter().write("<span class='ml-2'>&#x1F44D</span>"+"<strong>"+userId+"</strong><span id='idCheckEnd'>�� <span style='color:green;'>��밡����</span> ���̵��Դϴ�.</span>");
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
