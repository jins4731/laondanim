package com.laon.trip.controller;

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

import com.laon.board.model.service.BoardService;
import com.laon.common.CommonKey;
import com.laon.trip.model.service.TripService;
import com.laon.trip.model.vo.Trip;

/**
 * Servlet implementation class TripListViewServlet
 */
@WebServlet("/trip/tripListView.do")
public class TripListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TripListViewServlet. doGet()");
		
		int currentPage = getCurrentPage(request);
		int pagePerRow = 8;
		List<Trip> list = new TripService().selectTripPage(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow));
		int totalRowCount = new TripService().selectTripCount();
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
