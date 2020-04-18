package com.laon.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.mypage.model.service.MypageService;

/**
 * Servlet implementation class MyPageConTripDelete
 */
@WebServlet("/mypage/myConTripDel.do")
public class MyPageConTripMultiDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageConTripMultiDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		String[] tripCk=request.getParameterValues("dnCks");
		int[] tripNo=new int[tripCk.length];
		for(int i=0; i<tripCk.length; i++) {
			tripNo[i]=Integer.parseInt(tripCk[i]);
		}
		
		int result=new MypageService().myConTripDelete(tripNo);
		
		String msg="";
		String loc="";
		if(result>0) {
			msg="나의 여행기가 삭제되었습니다.";
			loc="/myPage/myPageContent.do?userNo="+userNo;
		}else {
			msg="나의 여행기 삭제에 실패했습니다.";
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
