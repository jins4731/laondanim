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
import com.laon.etc.model.vo.Like;
import com.laon.trip.model.vo.TripMyCon;

/**
 * Servlet implementation class DonghangWriteServlet
 */
@WebServlet(name="DonghangWriteServlet", urlPatterns = "/donghang/donghangWrite.do")
public class DonghangWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonghangWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("userNo"));
		
		//TRIP LIST
		List<TripMyCon> list = new DonghangService().selectMyTripList(no);
		//LIKE LIST
		List<Like> likeList = new DonghangService().selectLike(list);
		for(TripMyCon t : list) {
			System.out.println("trList ==== "+t);
		}
		for(Like l : likeList) {
			System.out.println("LikeList ==== "+l);
		}
		request.setAttribute(CommonKey.TRIP_LIST, list);
		request.setAttribute(CommonKey.LIKE_LIST, likeList);
		
		
		request.getRequestDispatcher("/views/donghang/donghangWrite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
