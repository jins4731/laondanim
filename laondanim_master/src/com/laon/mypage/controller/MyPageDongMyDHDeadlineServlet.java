package com.laon.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.mypage.model.service.MypageService;

/**
 * Servlet implementation class MyPageDongMyDHDeadlineServlet
 */
@WebServlet("/mypage/myDongDeadline.do")
public class MyPageDongMyDHDeadlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageDongMyDHDeadlineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		int dongNo=Integer.parseInt(request.getParameter("no"));
		String title=request.getParameter("title");
		
		int result=new MypageService().myDongDeadline(dongNo);
		
		String msg="";
		String loc="";
		if(result>0) {
			msg="["+title+"] 동행 모집이 마감되었습니다.";
			loc="/myPage/myPageDong.do?userNo="+userNo;
		}else {
			msg="["+title+"] 동행 모집이 마감에 실패했습니다.";
			loc="/myPage/myPageDong.do?userNo="+userNo;
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
