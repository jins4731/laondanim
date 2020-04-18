package com.laon.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.mypage.model.service.MypageService;

/**
 * Servlet implementation class MyPageConBoardDelete
 */
@WebServlet("/mypage/myBoardDel.do")
public class MyPageConBoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageConBoardDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		String[] boardCk=request.getParameterValues("bdCks");
		int[] boardNo=new int[boardCk.length];
		for(int i=0; i<boardCk.length; i++) {
			boardNo[i]=Integer.parseInt(boardCk[i]);
		}
		for(int i=0; i<boardNo.length; i++) {
			System.out.println(boardNo[i]);
		}
		
		int result=new MypageService().myBoardDelete(boardNo);
		String msg="";
		String loc="";
		if(result>0) {
			msg="나의 게시글이 삭제되었습니다.";
			loc="/myPage/myPageContent.do?userNo="+userNo;
		}else {
			msg="나의 게시글 삭제에 실패했습니다.";
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
