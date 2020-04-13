package com.laon.trip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.laon.common.etc.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test.do")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msg = "";
		String loc = "";
		if(!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("멀티 파트 전송이 아닙니다.");
			return;
		}
		
		String saveDir = getServletContext().getRealPath("/upload/");
		int maxSize = 1024*1024*10;
		String encoding = "UTF-8";
		
		MyFileRenamePolicy mfp = new MyFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(request, saveDir, maxSize,encoding,mfp );
		
		String reFile = mr.getFilesystemName("file");
		String oriFile = mr.getOriginalFileName("file");
		
		System.out.println("찐이름 : " + mr.getOriginalFileName("file"));
		System.out.println("리이름 : " + mr.getFilesystemName("file"));
		
		String fileNames = mr.getParameter("fileNames");
		fileNames.substring(0, fileNames.length()-1);
		System.out.println("변경전 : " + fileNames);
		String[] fileName = fileNames.split(",");
		for (int i = 0; i < fileName.length; i++) {
			System.out.println("변경후 : " +(mfp.getMap().get(fileName[i])));
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
