package com.laon.donghang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.CommonKey;
import com.laon.common.DonghangKey;
import com.laon.common.MypageKey;
import com.laon.common.UserKey;
import com.laon.donghang.model.service.DonghangService;
import com.laon.donghang.model.vo.DonghangJoin;
import com.laon.donghang.model.vo.DonghangJoinUserPicture;
import com.laon.mypage.model.service.MypageService;
import com.laon.user.model.vo.UserProfile;

/**
 * Servlet implementation class DonghangViewServlet
 */
@WebServlet(name="DonghangViewServlet", urlPatterns = "/donghang/donghangView.do")
public class DonghangViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonghangViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		Cookie[] cookies = request.getCookies();
		
		String cookieVal = "";
		boolean hasRead = false; //false면 조회수 증가 & true면 조회수 그대로
		
		if(cookies!=null) {
			for(Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();
				
				if("boardCookie".equals(name)) {
					cookieVal = value;
					
					if(value.contains("|"+no+"|")) {
						hasRead = true;
						break;
					}
				}
			}
		}
		
		if(!hasRead) {
			Cookie c = new Cookie("boardCookie", cookieVal+"|"+no+"|");
			c.setMaxAge(-1); //<=세션 종료 시 삭제!
			response.addCookie(c);
		}
				
		//동행글 정보 가저오기
		DonghangJoinUserPicture donghangItem = new DonghangService().selectDonghangView(no, hasRead);
		
		//작성자 프로필사진 가져오기
		int writerNo = donghangItem.getUserNo();
		String writerImage = new MypageService().selectUserNo(writerNo).getImage();

		//해당 동행의 참여자 리스트 가져오기
		List<UserProfile> joinList = new DonghangService().selectDonghangJoinMember(no);
		
		//로그인 유저의 프로필사진 가져오기
		int loginUserNo= Integer.parseInt(request.getParameter("loginUserNo"));
		String loginUserImg = new MypageService().selectUserNo(loginUserNo).getImage();
		
		//로그인 유저가 해당 동행의 참여했는지 여부 가져오기
		DonghangJoin donghangJoinItem = new DonghangService().selectUserDonghangJoin(no, loginUserNo);
		
		request.setAttribute(CommonKey.DONGHANG_ITEM, donghangItem);
		request.setAttribute(CommonKey.DONGHANG_JOIN_ITEM, donghangJoinItem);
		request.setAttribute(MypageKey.USER_IMAGE, writerImage);
		request.setAttribute(DonghangKey.JOIN_PEOPLE, joinList);
		request.setAttribute(UserKey.IMAGE, loginUserImg);
		
		request.getRequestDispatcher("/views/donghang/donghangView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
