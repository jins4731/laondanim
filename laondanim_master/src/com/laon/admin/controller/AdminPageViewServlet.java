package com.laon.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.admin.model.service.AdminService;
import com.laon.admin.model.vo.ReportsJoinUser;
import com.laon.common.Paging;

/**
 * Servlet implementation class AdminPageViewServlet
 */
@WebServlet("/admin/adminView.do")
public class AdminPageViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//관리자 페이지
	
		
		
		
		//페이징 처리하기 
		int cPage; 
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		 }catch(NumberFormatException e) { 
			 cPage=1; 
			 }
		 
		int perPage=7;
		//신고테이블에 입력된 값 받아서 화면에 뿌려주기
		List<ReportsJoinUser> list=new AdminService().selectReport(cPage,perPage);
		
		int totalData=new AdminService().countReport();
		
		String pageBar=new Paging().pageBar(request.getContextPath()+"/admin/adminView.do",totalData,cPage,perPage);
		
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("reports", list);
		request.getRequestDispatcher("/views/admin/adminPage.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
