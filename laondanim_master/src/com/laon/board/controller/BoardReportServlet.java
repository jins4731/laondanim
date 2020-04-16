package com.laon.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.admin.model.vo.Reports;
import com.laon.board.model.service.BoardService;

/**
 * Servlet implementation class BoardReportServlet
 */
@WebServlet("/board/userReport.do")
public class BoardReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글을 신고하는 로직
		//신고테이블에 넣는다
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		String report=request.getParameter("report");
		String reportText=request.getParameter("reportText");
		
		if(report.equals("기타")) {
			report=reportText;
		}
		
		Reports re=new Reports(0,userNo,0,boardNo,report,null);
		int result=new BoardService().insertReport(re);
		System.out.println("결과가있니:"+result);
		String msg="";
		String loc="";
		if(result>0) { 
			 msg="신고가 접수되었습니다"; loc="/board/boardView.do?no="+boardNo;
		  
		}else { 
			 msg="신고 신청실패(알수없는 오류)"; loc="/board/boardView.do?no="+boardNo; 
			 }
		  
		 request.setAttribute("msg", msg); request.setAttribute("loc", loc);
		 request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);
		 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
