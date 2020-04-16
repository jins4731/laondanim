package com.laon.trip.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.laon.common.template.MultiPartFormTemplate;
import com.laon.trip.model.vo.TripData;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class TripInsertViewEndServlet
 */
@WebServlet("/trip/tripInsertViewEnd.do")
public class TripInsertViewEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripInsertViewEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("TripInsertViewEndServlet.  doGet()");
		
		
		
		System.out.println("contentType : " + request.getContentType());
			
		
		if(ServletFileUpload.isMultipartContent(request)) {
			System.out.println("멀티파트 폼 데이터 입니다.");
		}
		
		
		String saveDir = getServletContext().getRealPath("/upload/");
		int maxSize = 1024*1024*10;
		String encoding = "UTF-8";
		
		
		MultiPartFormTemplate.mulitPartProcess(request, response, saveDir, new TripData());
		
		
//		MultipartRequest mr = new MultipartRequest(request, saveDir, maxSize,encoding, new DefaultFileRenamePolicy());
//		Enumeration e = mr.getParameterNames();
//		while (e.hasMoreElements()) {
//			System.out.println(e.nextElement());
//		}
		
//		String tripData = mr.getParameter("tripData");
//		System.out.println(tripData);
//		
//		
//		Gson g = new Gson();
//		TripData trip = g.fromJson(tripData, TripData.class);
//		System.out.println(trip);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
