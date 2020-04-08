package com.laon.trip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.Paging;
import com.laon.trip.model.vo.Trip;
import com.laon.trip.model.vo.TripPicture;
import com.laon.trip.service.TripService;

/**
 * Servlet implementation class TripListServlet
 */
@WebServlet("/trip/list.do")
public class TripListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//검색버튼 눌렀을 때, keyword 값 가져오기 , null 이면 검색 안한거 있으면 검색한거
		String keyword = request.getParameter("keyword");
		keyword=keyword==null?"null":keyword;
		//전체 여행기 클릭 시, category 값 가져오기
		String category = request.getParameter("category")==null?"전체 여행기":request.getParameter("category");
		category=category==null?"null":category;
		//지역 클릭 시, lo 값 가져오기
		String lo = request.getParameter("lo")==null?"선택 지역별":request.getParameter("lo");
		lo=lo==null?"null":lo;
		System.out.println("category값이 무엇인가?" + category);
		System.out.println("lo값이 무엇인가?" + lo);
		System.out.println("keyword값이 무엇인가?" + keyword);
		//최근순 클릭스 recent 값 가져오기
		String recent = request.getParameter("recent");
		recent=recent==null?"null":recent;
		//좋아요 순 클릭스 like 값 가져오기
		String like = request.getParameter("like");
		like=like==null?"null":like;
		
		System.out.println("서블릿 recent : " + recent);
		System.out.println("서블릿 like : " + like);
		int cPage;
			
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		
		int perPage = 10;
		int totalData=0;
		ArrayList<Trip> list = null;
		ArrayList<TripPicture> pictureList = null;

		totalData = new TripService().getTotalDataLo(lo, category, keyword);
		list = new TripService().searchList(cPage, perPage, lo, category, keyword, recent,like);
		pictureList = new TripService().searchPicture();
		
		String pageBar = new Paging().pageBar(request.getContextPath()+"/trip/list.do", totalData, cPage, perPage, keyword, category, lo, recent, like); //페이지바 가져오기
		
		//쿼리스트링 저장
		request.setAttribute("keyword", keyword);
		request.setAttribute("category", category);
		request.setAttribute("lo", lo);
		request.setAttribute("recent", recent);
		request.setAttribute("like", like);
		
		System.out.println("servlet 에서 list : " + list);
		request.setAttribute("triplist", list);	//여행기 리스트 저장
		request.setAttribute("picture", pictureList); //사진 리스트 저장 
		request.setAttribute("pageBar", pageBar);	//pageBar 저장
		request.setAttribute("totalData", totalData);
		request.getRequestDispatcher("/views/trip/triplist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
