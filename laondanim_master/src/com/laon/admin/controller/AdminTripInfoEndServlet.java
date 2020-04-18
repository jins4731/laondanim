package com.laon.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.laon.admin.model.service.AdminService;
import com.laon.tripinfo.model.vo.Picture;
import com.laon.tripinfo.model.vo.Tripinfo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class AdminTripInfoEndServlet
 */
@WebServlet("/admin/tripInfoEnd.do")
public class AdminTripInfoEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTripInfoEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "공지사항 작성오류![form:encType]");
			request.setAttribute("loc", "/board/write");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		String path=getServletContext().getRealPath("/views/picture/tripinfo/");
		int maxSize=1024*1024*10;
		MultipartRequest mr=new MultipartRequest(request,path,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		
		//db에 저장할 값을 받아오기
		Tripinfo ti=new Tripinfo(0,mr.getParameter("trip-selector"),mr.getParameter("tripTag"),mr.getParameter("tripTitle"),
				mr.getParameter("userAddr"),mr.getParameter("businessHours"),mr.getParameter("tripTel"),mr.getParameter("homePage"),
				mr.getParameter("naverLink"),mr.getParameter("snsLink"));
		System.out.println(ti);
		int result=new AdminService().insertTripInfo(ti);
		System.out.println("인포 입력결과:"+result);
		
		
		
		
		
		String msg="";
		String loc="";
		
		if(result>0) {
			
			int no=new AdminService().searchTripInfoNo(ti.getName(),ti.getTel());
			System.out.println("인포 번호:"+no);
			Picture p=new Picture(0,0,0,0,no,mr.getFilesystemName("upFile"));
			System.out.println("파일이름:"+mr.getFilesystemName("upFile"));
			int result1=new AdminService().insertPicture(p);
			
				if(mr.getFilesystemName("upFile2")!=null||mr.getFilesystemName("upFile2")!=" ") {
					Picture p2=new Picture(0,0,0,0,no,mr.getFilesystemName("upFile2"));
					int result2=new AdminService().insertPicture(p2);
				}
				if(mr.getFilesystemName("upFile3")!=null||mr.getFilesystemName("upFile3")!=" ") {
					Picture p3=new Picture(0,0,0,0,no,mr.getFilesystemName("upFile3"));
					int result3=new AdminService().insertPicture(p3);
				}
			
			
			
			if(result1>0) {
				
				msg="여행정보등록 성공";
				loc="/admin/tripInfo.do";
				
			}else {
				
				msg="사진파일 등록에 실패하였습니다";
				loc="/admin/tripInfo.do";
				
			}
		}else {
			msg="여행정보 등록에 실패하였습니다";
			loc="/admin/tripInfo.do";
			
			
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
