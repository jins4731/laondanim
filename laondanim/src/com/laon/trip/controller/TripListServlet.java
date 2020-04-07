package com.laon.trip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.Paging;
import com.laon.trip.model.vo.Trip;
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
		System.out.println("lo값이 무엇인가?" + lo);
		//최근순 클릭스 recent 값 가져오기
		String recent = request.getParameter("recent");
		recent=recent==null?"null":recent;
		
		int cPage;
			
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		
		int perPage = 10;
		int totalData=0;
		ArrayList<Trip> list = null;
		
//		System.out.println("참이냐 거짓이냐" + category.equals("전체 여행기"));
//		if((keyword.equals("null") && category.equals("null")) || category.equals("전체 여행기")) {
//			totalData = new TripService().getTotalData();
//			list = new TripService().searchList(cPage, perPage);	//여행기 리스트 가져오기
//			System.out.println("전체 데이터 개수 : " + totalData);
//			System.out.println("리스트 : " + list);
//			//사진 리스트 가져오기 추가
//		}
//		
//		//검색 버튼을 눌러서 keyword 값을 쿼리 스트링 형식으로 전송했기 때문에 값이 있다.
//		if(!keyword.equals("null")){	
//			totalData = new TripService().getTotalData(keyword);
//			list = new TripService().searchList(cPage, perPage, keyword);
//			request.setAttribute("keyword", keyword);			
//		}
//		
//		//category의 값이 있으면 select 박스를 바꿧다는 얘기 해당 category 에 해당하는 데이터 출력
//		if(!category.equals("null") && !category.equals("전체 여행기")) {				
//			//category = category.equals("여행 일정")?"plan":"review";
//			totalData = new TripService().getTotalDataPr(category, keyword);
//			System.out.println("totalData"+ totalData);
//			list = new TripService().searchListPr(cPage, perPage, category, keyword);
//			request.setAttribute("category", category);
//		}
//		
//		//lo의 값이 있으면 dropdown 박스를 바꿧다는 얘기 해당 category에 해당하는 데이터 출력
//		if(!lo.equals("null") && !lo.equals("선택 지역별")) {
//			totalData = new TripService().getTotalDataLo(lo, category, keyword);
//			list = new TripService().searchList(cPage, perPage, lo, category, keyword);
//			request.setAttribute("lo", lo);
//			System.out.println("totalData의 값은?"+totalData);
//			System.out.println("list의 값은 과연??"+list);
//		}
		totalData = new TripService().getTotalDataLo(lo, category, keyword);
		list = new TripService().searchList(cPage, perPage, lo, category, keyword, recent);
		
		String pageBar = new Paging().pageBar(request.getContextPath()+"/trip/list.do", totalData, cPage, perPage, keyword, category, lo); //페이지바 가져오기
		
		//쿼리스트링 저장
		request.setAttribute("keyword", keyword);
		request.setAttribute("category", category);
		request.setAttribute("lo", lo);
		request.setAttribute("recent", recent);
		
		request.setAttribute("triplist", list);	//여행기 리스트 저장
		//request.setAttribute("picture", picture); //사진 리스트 저장 
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
