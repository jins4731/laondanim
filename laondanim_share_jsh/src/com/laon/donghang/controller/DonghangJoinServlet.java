package com.laon.donghang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.donghang.model.service.DonghangService;
import com.laon.donghang.model.vo.DonghangJoin;

/**
 * Servlet implementation class DonghangJoinServlet
 */
@WebServlet(name = "DonghangJoinServlet", urlPatterns = "/donghang/donghangJoin.do")
public class DonghangJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonghangJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서버에 들어옴!");
		
		int userNo = Integer.parseInt(request.getParameter("userNo")); //유저넘버
		int donghangNo = Integer.parseInt(request.getParameter("donghangNo")); //동행 글 넘버
		String content = request.getParameter("content");

		DonghangJoin join = new DonghangJoin(0, userNo, donghangNo, content, "", "", "", "");
		
		int result = new DonghangService().donghangJoin(join);
		
		if(result>0) {
			response.getWriter().write("<h5><span>&#x1F64B</span>동행신청 완료되었습니다.</h5>");
		}else {
			response.getWriter().write("<h5><span>&#x1F630</span>동행 신청 실패...다시 시도해주세요!</h5>");
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
