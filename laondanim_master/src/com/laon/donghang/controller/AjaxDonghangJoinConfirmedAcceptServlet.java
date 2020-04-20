package com.laon.donghang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.donghang.model.service.DonghangService;

/**
 * Servlet implementation class AjaxDonghangJoinConfirmedAccept
 */
@WebServlet(name="AjaxDonghangJoinConfirmedAcceptServlet",urlPatterns = "/donghang/confirmedAccept.do")
public class AjaxDonghangJoinConfirmedAcceptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxDonghangJoinConfirmedAcceptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//화면에서 회원이 입력한 "Y"값
		String confirmedValue = request.getParameter("confirmedValue");
		//조인테이블 no
		int joinNo = Integer.parseInt(request.getParameter("joinNo"));
		//동행 no
		int dhNo = Integer.parseInt(request.getParameter("no"));
		
		//JDBC 업데이트로 confirmed컬럼 값 바꿔주기		
		int joinResult = new DonghangService().joinComfirmedUpdate(confirmedValue, joinNo, dhNo);

		//donghang_tb 업데이트
		int dhResult = new DonghangService().donghangJoinPlus(dhNo);
		
		int result = joinResult*dhResult;
		
		if(result < 0) {
			response.getWriter().write(
					"<span class='ml-2'>&#x274C</span>수락 실패하였습니다. 다시 시도해주세요.");
		} else {
			response.getWriter().write("<span class='ml-2'>&#x1F44D</span>동행 수락하셨습니다.");
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
