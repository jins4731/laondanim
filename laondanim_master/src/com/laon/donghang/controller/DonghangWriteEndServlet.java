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
			request.setAttribute("loc", "/donghang/donghangListView.do");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path = getServletContext().getRealPath("/upload/donghang/");
		int maxSize = 1024*1024*10;
		
		MultipartRequest mr=new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());

		int userNo = Integer.parseInt(mr.getParameter("userNo"));
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
		if(publicEnabled==null) publicEnabled = "비공개";
		System.out.println(publicEnabled);
		if(publicEnabled.equals("공개")||publicEnabled.equals("on")) {
			publicEnabled = "N";
		}else {
			publicEnabled = "Y";			
		}
		
		int pw = mr.getParameter("donghangPw")==null||mr.getParameter("donghangPw").equals("")?-1:Integer.parseInt(mr.getParameter("donghangPw")); //-> 비공개인 경우 무조건 -1으로 설정
		int tripNo = mr.getParameter("selectTripNo")==null||mr.getParameter("selectTripNo").equals("")?-1:Integer.parseInt(mr.getParameter("selectTripNo")); //null인 경우 무조건 -1로 설정
		String content = mr.getParameter("content");
		String tag = mr.getParameter("tag");
		System.out.println("롸이트엔드에서의 트립 넘버? : "+tripNo);
		//vo저장
		Donghang donghang = new Donghang(0, userNo, tripNo, null, 0, tag, title, content,
				travleLocale, sqlTravelStartDate, sqlTravelEndDate, sqlRecruitStartDate, sqlRecruitEndDate,
				pw, publicEnabled, "N", "N", recruitPeopleNo, 0);
		//insert 결과
		int dhResult = new DonghangService().insertDonghaong(donghang);
		
		//방금 저장한 no번호 찾기
		int donghangNo = new DonghangService().selectDonghangSeqNextVal(userNo, title);
		
		//사진 저장
		Picture pic = new Picture(0, 0, 0, donghangNo, 0, image);
		//insert 결과
		int ptResult  = new DonghangService().insertPicture(pic);

		int result = dhResult*ptResult;
		String msg = "";
		String loc = "";
		if(result > 0) {
			msg = "동행찾기 글이 등록되었습니다.";
			loc = "/donghang/donghangListView.do";
		}else {
			msg = "동행찾기 글 등록에 실패하였습니다. 다시 시도해주세요.";
			loc = "/donghang/donghangWriteEnd.do?userNo="+userNo;
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
