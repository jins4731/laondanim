package com.laon.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.mypage.model.service.MypageService;

/**
 * Servlet implementation class MyPageDongJoinRefusal
 */
@WebServlet("/myPage/myDongJoinRefusal.do")
public class MyPageDongJoinRefusalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageDongJoinRefusalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		
		int dongJoinNo=Integer.parseInt(request.getParameter("dongJoinNo"));
		
		int result=new MypageService().dongJoinRefusal(dongJoinNo);
		
		String msg="";
		String loc="";
		if(result>0) {
			msg="거절된 동행 삭제가 완료되었습니다.";
			loc="/myPage/myPageContent.do?userNo="+userNo;
		}else {
			msg="거절된 동행 삭제에 실패했습니다.";
			loc="/myPage/myPageContent.do?userNo="+userNo;
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
