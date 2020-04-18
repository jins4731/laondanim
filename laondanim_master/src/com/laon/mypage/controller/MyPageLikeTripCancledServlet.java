package com.laon.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.mypage.model.service.MypageService;

/**
 * Servlet implementation class MyPageLikeTripCancledServlet
 */
@WebServlet("/mypage/myLikeTripCancled.do")
public class MyPageLikeTripCancledServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageLikeTripCancledServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		int likeNo=Integer.parseInt(request.getParameter("likeNo"));
		
		int result=new MypageService().likeTripCancled(userNo,likeNo);
		
		String msg="";
		String loc="";
		if(result>0) {
			msg="좋아요한 여행길이 취소 되었습니다.";
			loc="/myPage/myPageHeart.do?userNo="+userNo;
		}else {
			msg="좋아요한 여행길이 취소에 실패했습니다.";
			loc="/myPage/myPageHeart.do?userNo="+userNo;
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
