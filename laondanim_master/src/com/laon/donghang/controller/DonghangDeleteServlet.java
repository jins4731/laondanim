package com.laon.donghang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.donghang.model.service.DonghangService;

/**
 * Servlet implementation class DonghangDeleteServlet
 */
@WebServlet("/donghang/donghangDelete.do")
public class DonghangDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonghangDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		int result = new DonghangService().deleteDonghang(no);
		
		String fileName = request.getParameter("fileName");
		
		//파일을 지워주는 로직 구현 ==> 해요..?
//		String path = getServletContext().getRealPath("/upload/donghang/");
//		File f = new File(path+fileName);
//		if(f.exists()) {
//			f.delete();
//		}
		
		String msg = "";
		String loc = "";
		
		if(result>0) {
			msg="해당 동행찾기글이 삭제되었습니다.";
			loc="/donghang/donghangListView.do";
		}else {
			msg="삭제에 실패하였습니다. 다시 시도해주세요.";
			loc="/donghang/donghangView.do?no="+no;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc",loc);
		
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
