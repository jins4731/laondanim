package com.laon.donghang.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.admin.model.vo.Reports;
import com.laon.board.model.service.BoardService;
import com.laon.donghang.model.service.DonghangService;

/**
 * Servlet implementation class DonghangReportServlet
 */
@WebServlet("/donghang/userReport.do")
public class DonghangReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonghangReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int loginUserNo=Integer.parseInt(request.getParameter("loginUserNo"));
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		int donghangNo=Integer.parseInt(request.getParameter("donghangNo"));
		String report=request.getParameter("report");
		String reportText=request.getParameter("reportText");
		
		if(report.equals("기타")) {
			report=reportText;
		}
		
		Reports re=new Reports(0,userNo,donghangNo,0,report,null);
		int result=new DonghangService().insertReport(re);
		System.out.println("결과가있니:"+result);
		String msg="";
		String loc="";
		if(result>0) { 
			 msg="신고가 접수되었습니다"; loc="donghang/donghangView.do?loginUserNo="+loginUserNo+"&no="+donghangNo;
		  
		}else { 
			 msg="신고 신청실패(알수없는 오류)"; loc="donghang/donghangView.do?loginUserNo="+loginUserNo+"&no="+donghangNo; 
			 }
		  
		 request.setAttribute("msg", msg); 
		 request.setAttribute("loc", loc);
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
