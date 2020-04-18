6--package com.laon.trip.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.UserKey;
import com.laon.trip.model.service.TripService;
import com.laon.tripinfo.model.vo.Tripinfo;

/**
 * Servlet implementation class TripInsertViewServlet
 */
@WebServlet("/trip/tripInsertView.do")
public class TripInsertViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripInsertViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TripInsertViewServlet. doGet()");
		String userNo = request.getParameter(UserKey.NO);
//		String userNo = "1";
		System.out.println("userNo : " + userNo);
		
		List<Tripinfo> list = new TripService().selectZzimList(userNo);
//		List<Tripinfo> list = new TripService().selectTripinfoList();
		List<Tripinfo> matzipList = new ArrayList();
		List<Tripinfo> myoungsoList = new ArrayList();
		List<Tripinfo> sooksoList = new ArrayList();
		for (Tripinfo tripinfo : list) {
			if(tripinfo.getCategory().equals("맛집")) {
				matzipList.add(tripinfo);
			}else if(tripinfo.getCategory().equals("명소")) {
				myoungsoList.add(tripinfo);
			}else if(tripinfo.getCategory().equals("숙소")) {
				sooksoList.add(tripinfo);
			}
		}
		
		System.out.println("matzipList : " + matzipList);
		System.out.println("myoungsoList : " + myoungsoList);
		System.out.println("sooksoList : " + sooksoList);
		
		
		request.setAttribute("userNo", userNo);
		request.setAttribute("matzipList", matzipList);
		request.setAttribute("myoungsoList", myoungsoList);
		request.setAttribute("sooksoList", sooksoList);
		request.getRequestDispatcher("/views/trip/tripInsertView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
