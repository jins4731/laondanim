package com.laon.donghang.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@WebServlet(name="DonghangUpdateEndServlet", urlPatterns = "/donghang/donghangUpdateEnd.do")
public class DonghangUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonghangUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg","multipart-form error");
			request.setAttribute("loc", "/donghang/donghangListView.do");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path = getServletContext().getRealPath("/upload/donghang/");
		int maxSize = 1024*1024*10;
		
		MultipartRequest mr=new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());

		int userNo = Integer.parseInt(mr.getParameter("userNo"));
		int no = Integer.parseInt(mr.getParameter("no"));
		//저장 값 받기
		String title = mr.getParameter("donghangTitle");
		String image = mr.getFilesystemName("imageFile");
		String travleLocale = mr.getParameter("travelLocalSelect");
		int recruitPeopleNo = Integer.parseInt(mr.getParameter("recruitPeopleNo"));
		
		
		//Date
		Date travelStartDate=null;
		Date travelEndDate=null;
		Date recruitStartDate=null;
		Date recruitEndDate=null;
		try {
			travelStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(mr.getParameter("travelStartDate"));
			travelEndDate = new SimpleDateFormat("yyyy-MM-dd").parse(mr.getParameter("travelEndDate"));
			recruitStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(mr.getParameter("recruitStartDate"));
			recruitEndDate = new SimpleDateFormat("yyyy-MM-dd").parse(mr.getParameter("recruitEndDate"));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		java.sql.Date sqlTravelStartDate = new java.sql.Date(travelStartDate.getTime());
		java.sql.Date sqlTravelEndDate = new java.sql.Date(travelEndDate.getTime());
		java.sql.Date sqlRecruitStartDate = new java.sql.Date(recruitStartDate.getTime());
		java.sql.Date sqlRecruitEndDate = new java.sql.Date(recruitEndDate.getTime());
		
		
		
		String publicEnabled = mr.getParameter("publicEnabled");

		if(publicEnabled.equals("공개")||publicEnabled.equals("on")) {
			publicEnabled = "N";
		}else {
			publicEnabled = "Y";			
		}
		
		Integer pw;
		if(mr.getParameter("donghangPw")!=null) {
			pw = Integer.parseInt(mr.getParameter("donghangPw"));
		}else {
			pw = null;
		}
		
		int tripNo = Integer.parseInt(mr.getParameter("selectTripNo"));
		String content = mr.getParameter("content");
		String tag = mr.getParameter("tag");
		

		//vo저장
		Donghang donghang = new Donghang(no, userNo, tripNo, null, 0, tag, title, content,
				travleLocale, sqlTravelStartDate, sqlTravelEndDate, sqlRecruitStartDate, sqlRecruitEndDate,
				pw, publicEnabled, "N", "N", recruitPeopleNo, 0);
		//insert 결과
		int dhResult = new DonghangService().updateDonghaong(donghang);
		//사진 저장
		Picture pic = new Picture(0, 0, 0, no, userNo, image);
		//insert 결과
		int ptResult  = new DonghangService().updatePicture(pic);

		int result = dhResult*ptResult;
		String msg = "";
		String loc = "";
		if(result > 0) {
			msg = "동행찾기 글이 수정되었습니다.";
			loc = "/donghang/donghangView.do?no="+no;
		}else {
			msg = "동행찾기 글 수정에 실패하였습니다. 다시 시도해주세요.";
			loc = "/donghang/donghangUpdateEnd.do?userNo="+userNo+"&no="+no;
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}