package com.laon.trip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.CommonKey;
import com.laon.common.Paging;
import com.laon.etc.model.vo.Like;
import com.laon.etc.model.vo.Picture;
import com.laon.trip.model.vo.Trip;
import com.laon.trip.service.TripService;
/**
 * Servlet implementation class TripListServlet
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
		//최근순 클릭스 recent 값 가져오기
		String recent = request.getParameter("recent");
		recent=recent==null?"null":recent;
		//좋아요 순 클릭스 like 값 가져오기
		String like = request.getParameter("like");
		like=like==null?"null":like;
		
		int cPage;
			
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		
		int perPage = 10;
		int totalItemCount=0;
		
		ArrayList<Trip> list = null;
		ArrayList<Picture> pictureList = null;
		ArrayList<Like> likeList = null;
		
		totalItemCount = new TripService().selectTripCount(lo, category, keyword);
		list = new TripService().selectTripPage(cPage, perPage, lo, category, keyword, recent,like);
		//리스트에서 가져오고 해당 리스트로 매칭되는 picture 가져오기
		pictureList = new TripService().selectPicture(list);
		
		//해당 리스트로 매칭되는 좋아요 수 가져오기
		likeList = new TripService().selectLike(list);
		
		String pageBar = new Paging().pageBar(request.getContextPath()+"/trip/tripListView.do", totalItemCount, cPage, perPage, keyword, category, lo, recent, like); //페이지바 가져오기
		
		//쿼리스트링 저장
		request.setAttribute("keyword", keyword);
		request.setAttribute("category", category);
		request.setAttribute("lo", lo);
		request.setAttribute("recent", recent);
		request.setAttribute("like", like);
		
		request.setAttribute(CommonKey.LIST, list);	//여행기 리스트 저장
		request.setAttribute("pictureList", pictureList); //사진 리스트 저장 
		request.setAttribute("likeList", likeList);//좋아요 리스트 저장
		request.setAttribute(CommonKey.PAGE_BAR, pageBar);	//pageBar 저장
		request.setAttribute(CommonKey.totalItemCount, totalItemCount);
		request.getRequestDispatcher("/views/trip/tripListPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
