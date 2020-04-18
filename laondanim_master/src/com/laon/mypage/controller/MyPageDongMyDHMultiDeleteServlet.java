package com.laon.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.mypage.model.service.MypageService;

/**
 * Servlet implementation class MyPageMyDHDeleteServlet
 */
@WebServlet("/mypage/myDHDelete.do")
public class MyPageDongMyDHMultiDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageDongMyDHMultiDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		String[] myDongCk=request.getParameterValues("dhCks");
		int[] myDongNo=new int[myDongCk.length];
		for(int i=0; i<myDongCk.length; i++) {
			myDongNo[i]=Integer.parseInt(myDongCk[i]);
		}
		
		int result=new MypageService().myDongMultiDelete(myDongNo);
		String msg="";
		String loc="";
		if(result>0) {
			msg="나의 동행이 삭제되었습니다.";
			loc="/myPage/myDongMyDH.do?userNo="+userNo;
		}else {
			msg="나의 동행 삭제에 실패했습니다.";
			loc="/myPage/myDongMyDH.do?userNo="+userNo;
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
