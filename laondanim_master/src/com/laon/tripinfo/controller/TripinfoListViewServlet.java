package com.laon.tripinfo.controller;

import static com.laon.common.template.PageTemplate.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.CommonKey;
import com.laon.tripinfo.model.service.TripInfoService;
import com.laon.tripinfo.model.vo.Tripinfo;

/**
 * Servlet implementation class TripinfoListViewServlet
 */
@WebServlet("/tripinfo/tripinfoListView.do")
public class TripinfoListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripinfoListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TripinfoListViewServlet. doGet()");
		
		int currentPage = getCurrentPage(request);
		int pagePerRow = 8;
		List<Tripinfo> list = new TripInfoService().selectTripinfoPage(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow));
		int totalRowCount = new TripInfoService().selectTripinfoCount();
		String pageBar = getPageBar(totalRowCount, currentPage, pagePerRow, request, "");
		
		request.setAttribute(CommonKey.TRIPINFO_LIST, list);
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
