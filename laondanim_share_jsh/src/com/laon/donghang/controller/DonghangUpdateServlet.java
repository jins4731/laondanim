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
		String no = request.getParameter("no");
		
		DonghangJoinUserPicture donghangItem = new DonghangService().selectDonghangJoinUserPicture(no);
		//TRIP LIST
		int iNo = Integer.parseInt(no);
		List<TripMyCon> list = new DonghangService().selectMyTripList(iNo);
		//LIKE LIST
		List<Like> likeList = new DonghangService().selectLike(list);
		
		System.out.println("_____________________서블릿__________________________");
		for(TripMyCon t : list){
			System.out.println(t);	
		}
		for(Like l : likeList){
			System.out.println(l);	
		}
		System.out.println(donghangItem);
		
		request.setAttribute(CommonKey.TRIP_LIST, list);
		request.setAttribute(CommonKey.LIKE_LIST, likeList);
		request.setAttribute(CommonKey.DONGHANG_ITEM, donghangItem);
		
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
