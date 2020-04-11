package com.laon.mypage.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.mypage.model.service.MypageService;
import com.laon.user.model.vo.UserProfile;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MyPageInfoUpdateEndServlet
 */
@WebServlet("/myPage/myInfoUpdateEnd.do")
public class MyPageInfoUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageInfoUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=getServletContext().getRealPath("/picture/profile/");
		
		int maxSize=1024*1024*10;
		MultipartRequest mr=new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		int userNo=Integer.parseInt(mr.getParameter("userNo"));
		String cDate=mr.getParameter("cDate");
		String userId = mr.getParameter("userId");
		String password = mr.getParameter("userPw");
		String name = mr.getParameter("userName");
		String nickName = mr.getParameter("userNickName");
		String inputBirthday = mr.getParameter("userBirth");
		String gender = mr.getParameter("gender");
		int phone = Integer.parseInt(mr.getParameter("userPhone"));
		String email = mr.getParameter("userEmail");
		String likeArea = mr.getParameter("likeArea");
		String[] likeTag = mr.getParameterValues("likeTag");
		String oriPro=mr.getParameter("oriPro");
		String nPro=mr.getFilesystemName("profile");
		
		File f=mr.getFile("profile");
		if(f!=null && f.length()>0) {
			File delFile=new File(path+oriPro);
			boolean flag=delFile.delete();
		}else {
			nPro=oriPro;
		}
		
		java.sql.Date creDate=java.sql.Date.valueOf(cDate);
		java.sql.Date birthday = java.sql.Date.valueOf(inputBirthday);
		
		String strLikeTag = String.join(",", likeTag);
		String tag = likeArea + "," + strLikeTag;
		
		UserProfile up = new UserProfile(userNo, creDate, userId, password, name, nickName, birthday, gender, phone, email, tag, nPro);
		
		int result=new MypageService().updateUserProfile(up);
		
		String msg="";
		String loc="";
		if(result>0) {
			msg="회원 정보 수정이 완료되었습니다.";
			loc="/myPage/myPageContent.do?userNo="+userNo;
		}else {
			msg="회원 정보 수정에 실패했습니다.";
			loc="/myPage/myPageContent.do?userNo="+userNo;
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc",loc);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
