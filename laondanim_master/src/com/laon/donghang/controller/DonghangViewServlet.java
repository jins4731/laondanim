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
import com.laon.donghang.model.vo.DonghangJoinUserPicture;
import com.laon.mypage.model.service.MypageService;
import com.laon.user.model.service.UserService;
import com.laon.user.model.vo.User;
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
		boolean hasRead = false; //false�� ��ȸ�� ���� & true�� ��ȸ�� �״��
		
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
			c.setMaxAge(-1); //<=���� ���� �� ����!
			response.addCookie(c);
		}
				
		//����� ���� ��������
		DonghangJoinUserPicture donghangItem = new DonghangService().selectDonghangView(no, hasRead);
		
		//�ۼ��� �����ʻ��� ��������
		int writerNo = donghangItem.getUserNo();
		String writerImage = new MypageService().selectUserNo(writerNo).getImage();
		
		//�ش� ������ ������ ����Ʈ ��������
		List<UserProfile> joinList = new DonghangService().selectDonghangJoinMember(no);
		
		//�α��� ������ �����ʻ��� ��������
		int loginUserNo= Integer.parseInt(request.getParameter("loginUserNo"));
		String loginUserImg = new MypageService().selectUserNo(loginUserNo).getImage();
		
		request.setAttribute(CommonKey.DONGHANG_ITEM, donghangItem);
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
