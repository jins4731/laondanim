package com.laon.trip.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.laon.trip.model.vo.TripJson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class TestAjaxServlet
 */
@WebServlet("/testAjax")
public class TestAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("TestAjaxServlet. doGet()");
		System.out.println("contentType : " + request.getContentType());
			
		
		if(ServletFileUpload.isMultipartContent(request)) {
			System.out.println("멀티파트 폼 데이터 입니다.");
		}
		
		
		String saveDir = getServletContext().getRealPath("/upload/");
		int maxSize = 1024*1024*10;
		String encoding = "UTF-8";
		
		
		MultipartRequest mr = new MultipartRequest(request, saveDir, maxSize,encoding, new DefaultFileRenamePolicy());
		Enumeration e = mr.getParameterNames();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		String str = mr.getParameter("ad");
		System.out.println(str);
		
		
		Gson g = new Gson();
		TripJson trip = g.fromJson(str, TripJson.class);
		System.out.println(trip);
		
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
