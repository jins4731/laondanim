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
		//전체 여행기 클릭 시, category 값 가져오기
		String category = request.getParameter("category")==null?"전체 여행기":request.getParameter("category");
		//최근순 클릭스 recent 값 가져오기
		String recent = request.getParameter("recent");
		System.out.println("recent의 값은?"+recent);
		
		System.out.println("category:"+category);
		System.out.println(keyword);
		int cPage;
			
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		
		int perPage = 10;
		int totalData=0;
		ArrayList<Trip> list = null;
		
		if((keyword==null && category==null) || category.equals("전체 여행기")) {
			totalData = new TripService().getTotalData();
			list = new TripService().searchList(cPage, perPage);	//여행기 리스트 가져오기
			//사진 리스트 가져오기 추가
		}
		
		//검색 버튼을 눌러서 keyword 값을 쿼리 스트링 형식으로 전송했기 때문에 값이 있다.
		if(keyword!=null){	
			totalData = new TripService().getTotalData(keyword);
			list = new TripService().searchList(cPage, perPage, keyword);
			request.setAttribute("keyword", keyword);
		}
		
		//category의 값이 있으면 select 박스를 바꿧다는 얘기 해당 category 에 해당하는 데이터 출력
		if(category!=null && !category.equals("전체 여행기")) {
			//category = category.equals("여행 일정")?"plan":"review";
			totalData = new TripService().getTotalDataPr(category, keyword);
			System.out.println("totalData"+ totalData);
			list = new TripService().searchListPr(cPage, perPage, category, keyword);
			request.setAttribute("category", category);
		}
		
		
		
		String pageBar = new Paging().pageBar(request.getContextPath()+"/trip/list.do", totalData, cPage, perPage, keyword, category); //페이지바 가져오기
		
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
