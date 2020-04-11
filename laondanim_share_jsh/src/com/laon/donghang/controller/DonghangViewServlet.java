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
import com.laon.donghang.model.service.DonghangService;
import com.laon.donghang.model.vo.DonghangJoinUserPicture;

/**
 * Servlet implementation class DonghangViewServlet
 */
@WebServlet("/donghang/donghangView.do")
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
		
		
		
		List<DonghangJoinUserPicture> list = new DonghangService().selectDonghangView(no, hasRead);
	
		
		request.setAttribute(CommonKey.DONGHANG_LIST, list);
		
		request.getRequestDispatcher("/views/board/boardView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
