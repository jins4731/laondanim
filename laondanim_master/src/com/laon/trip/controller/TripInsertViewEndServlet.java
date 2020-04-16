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
import com.laon.common.template.MsgTemplate;
import com.laon.common.template.MultiPartFormTemplate;
import com.laon.trip.model.service.TripService;
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
		
		
		TripData data = MultiPartFormTemplate.mulitPartProcess(request, response, "/upload/", new TripData());
		boolean isGood = new TripService().insertTrip(data);
		
		
		if(isGood) {
			MsgTemplate.sendMSG("작성 완료", "/trip/tripListView.do", request, response);
		}else {
			MsgTemplate.sendMSG("작성 실패", "/trip/tripInsertView.do", request, response);
		}
		
		

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
