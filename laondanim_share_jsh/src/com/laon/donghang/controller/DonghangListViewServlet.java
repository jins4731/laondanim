package com.laon.donghang.controller;

import static com.laon.common.template.PageTemplate.getCurrentPage;
import static com.laon.common.template.PageTemplate.getEndNum;
import static com.laon.common.template.PageTemplate.getPageBar;
import static com.laon.common.template.PageTemplate.getStartNum;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.CommonKey;
import com.laon.donghang.model.service.DonghangService;
import com.laon.donghang.model.vo.Donghang;

/**
 * Servlet implementation class DonghangListViewServlet
 */
@WebServlet("/donghang/donghangListView.do")
public class DonghangListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonghangListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DonghangListViewServlet. doGet()");
		
		int currentPage = getCurrentPage(request);
		int pagePerRow = 10;
		List<Donghang> list = new DonghangService().selectDonghangPage(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow));
		int totalRowCount = new DonghangService().selectDonghangCount();
		String pageBar = getPageBar(totalRowCount, currentPage, pagePerRow, request, "");
		
		request.setAttribute(CommonKey.LIST, list);
		request.setAttribute(CommonKey.PAGE_BAR, pageBar);
		
		
		
		
		
		request.getRequestDispatcher("").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
