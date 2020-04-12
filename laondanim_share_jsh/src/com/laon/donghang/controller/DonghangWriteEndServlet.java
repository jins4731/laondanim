package com.laon.donghang.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.laon.donghang.model.service.DonghangService;
import com.laon.donghang.model.vo.Donghang;
import com.laon.etc.model.vo.Picture;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class DonghangWriteEndServlet
 */
@WebServlet(name="DonghangWriteEndServlet", urlPatterns = "/donghang/donghangWriteEnd.do")
public class DonghangWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonghangWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg","multipart-form error");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);;
		}
		
		String path = getServletContext().getRealPath("/upload/donghang/");
		int maxSize = 1024*1024*10;
		
		MultipartRequest mr=new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		//str => date
		SimpleDateFormat toDate = new SimpleDateFormat("yyyy-MM-dd");

		//저장 값 받기
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String title = mr.getParameter("donghangTitle");
		String image = mr.getParameter("imageFile");
		String travleLocale = mr.getParameter("travelLocalSelect");
		String recruitPeopleNo = mr.getParameter("recruitPeopleNo");
		System.out.println(userNo);
		System.out.println(title);
		System.out.println(image);
		System.out.println(travleLocale);
		System.out.println(recruitPeopleNo);
		
		//date처리
		String travleStartDate = mr.getParameter("travleStartDate");
		String travelEndtDate = mr.getParameter("travelEndtDate");
		String recruitStartDate = mr.getParameter("recruitStartDate");
		String recruitEndtDate = mr.getParameter("recruitEndtDate");
		System.out.println(mr.getParameter("travleStartDate"));
		System.out.println(mr.getParameter("travelEndtDate"));
		System.out.println(mr.getParameter("recruitStartDate"));
		System.out.println(mr.getParameter("recruitEndtDate"));
		

		String publicEnabled = mr.getParameter("publicEnabled");
		System.out.println(publicEnabled);
		if(publicEnabled.equals("공개")) {
			publicEnabled = "N";
		}else {
			publicEnabled = "Y";			
		}
		int pw = Integer.parseInt(mr.getParameter("donghangPw"));
		int tripNo = Integer.parseInt(mr.getParameter("selectTripNo"));
		String content = mr.getParameter("content");
		String tag = mr.getParameter("tag");
		System.out.println(pw);
		System.out.println(tripNo);
		System.out.println(content);
		System.out.println(tag);
		
		//동행&사진 테이블을 위한 시퀀스 번호를 가져와서 저장
		int donghangNo = new DonghangService().selectDonghangSeqNextVal();
		
		//vo저장
		Donghang donghang = new Donghang();
//		Donghang donghang = new Donghang(donghangNo, userNo, tripNo, null, 0, tag, title, content,
//				travleLocale, travleStartDate, travleEndDate, recruitStartDate, recruitEndDate,
//				pw, publicEnabled, "N", "N", recruitPeopleNo, 0);
		//insert 결과
		int dhResult = new DonghangService().insertDonghaong(donghang);
			
		System.out.println("씨뱅~ : "+donghang);
		//사진 저장
		Picture pic = new Picture(0, 0, 0, donghangNo, userNo, image);
		//insert 결과
		int ptResult  = new DonghangService().insertPicture(pic);

		System.out.println("씨뱅뱅~ : "+pic);
		int result = dhResult*ptResult;
		String msg = "";
		String loc = "";
		if(result > 0) {
			msg = "동행찾기 글이 등록되었습니다.";
			loc = "/donghang/donghangListView.do";
		}else {
			msg = "동행찾기 글 등록에 실패하였습니다. 다시 시도해주세요.";
			loc = "/donghang/donghangWriteEnd.do";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/donghaong/donghaongWrite.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
