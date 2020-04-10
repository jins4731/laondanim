package com.laon.trip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.CommonKey;
import com.laon.etc.model.service.EtcService;
import com.laon.etc.model.vo.Picture;
import com.laon.trip.model.service.TripService;
import com.laon.trip.model.vo.Trip;
import com.laon.trip.model.vo.TripSchedule;
import com.laon.user.model.service.UserService;
import com.laon.user.model.vo.User;

/**
 * Servlet implementation class TripDetailServlet
 */
@WebServlet("/trip/tripView.do")
public class TripViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TripViewServlet. doGet()");
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");
		
		
		Trip trip = new TripService().selectTrip("1");
		List<TripSchedule> scheduleList = new TripService().selectTripScheduleList(trip.getNo());
		User user = new UserService().selectUser(trip.getUserNo());
		Picture pic = new EtcService().selectPictureUserNo(user.getNo());
		
		System.out.println(trip);
		System.out.println(scheduleList);
		System.out.println(user);
		System.out.println(pic);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setAttribute(CommonKey.TRIP_ITEM, trip);
		request.setAttribute(CommonKey.USER_ITEM, user);
		request.setAttribute(CommonKey.SCHEDULE_LIST, scheduleList);
		request.setAttribute(CommonKey.PICTURE_ITEM, pic);
		request.getRequestDispatcher("/views/trip/tripView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
