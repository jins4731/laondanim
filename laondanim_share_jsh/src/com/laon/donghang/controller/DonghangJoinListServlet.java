package com.laon.donghang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.donghang.model.service.DonghangService;
import com.laon.donghang.model.vo.Donghang;
import com.laon.donghang.model.vo.DonghangJoin;
import com.laon.user.model.vo.UserProfile;

/**
 * Servlet implementation class DonghangJoinListServlet
 */
@WebServlet(name="DonghangJoinListServlet", urlPatterns = "/donghang/donghangJoinlist.do")
public class DonghangJoinListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonghangJoinListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 유저 no받기
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		//동행 작성자 = 로그인 유저가 작성한 동행리스트를 가져오기
		List<Donghang> dhList = new DonghangService().selectDonghangList(userNo);
		//동행 참여 리스트 가져오기
		List<DonghangJoin> joinList = new DonghangService().selectDonghangJoinList();
		//유저프로필 리스트 가져오기
		List<UserProfile> userList = new DonghangService().selectUserProfileAll();
		
		request.getRequestDispatcher("/views/donghang/donghangJoinList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
