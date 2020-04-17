package com.laon.tripinfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.tripinfo.model.service.TripInfoService;

/**
 * Servlet implementation class TripInfoDeleteMindServlet
 */
@WebServlet("/tripinfo/deleteMind.do")
public class TripInfoDeleteMindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripInfoDeleteMindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tripinfoNo=Integer.parseInt(request.getParameter("tripinfoNo"));
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		
		System.out.println("서블릿에서 유저no"+userNo);
		System.out.println("서블릿에서 트립인포no"+tripinfoNo);
		
		
		int result = new TripInfoService().deleteMind(tripinfoNo,userNo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
