package com.laon.donghang.controller;

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
import com.laon.donghang.model.vo.DonghangJoinUserPicture;
import com.laon.etc.model.vo.Like;
import com.laon.trip.model.vo.TripMyCon;

/**
 * Servlet implementation class DonghangUpdateServlet
 */
@WebServlet(name = "DonghangUpdateServlet" , urlPatterns = "/donghang/donghangUpdate.do")
public class DonghangUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonghangUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String no = request.getParameter("no");
		
		//DonghangJoin
		DonghangJoinUserPicture donghangItem = new DonghangService().selectDonghangJoinUserPicture(no);
		
		//TRIP LIST
		List<TripMyCon> list = new DonghangService().selectMyTripList(userNo);
		//LIKE LIST
		List<Like> likeList = new DonghangService().selectLike(list);
		
		request.setAttribute(CommonKey.DONGHANG_ITEM, donghangItem);
		request.setAttribute(CommonKey.TRIP_LIST, list);
		request.setAttribute(CommonKey.LIKE_LIST, likeList);	
		
		System.out.println("_______________-------------+++++++++++++++");
		System.out.println("업데이트 서블릿 donghangItem :"+donghangItem);
		System.out.println("like list size :"+likeList.size());
		System.out.println("trip list size :"+list.size());
		for(Like l : likeList){
			System.out.println("업데이트 서블릿 like : "+l);
		}
		for(TripMyCon tm : list){
			System.out.println("업데이트 서블릿 tm : "+tm);
		}

		
		request.getRequestDispatcher("/views/donghang/donghangUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
