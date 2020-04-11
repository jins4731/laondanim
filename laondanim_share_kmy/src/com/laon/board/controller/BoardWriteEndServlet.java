package com.laon.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.board.model.service.BoardService;
import com.laon.board.model.vo.Board;
import com.laon.board.model.vo.BoardJoinUser;
import com.laon.user.model.vo.User;

/**
 * Servlet implementation class BoardWriteEndServlet
 */
@WebServlet("/board/boardWriteEnd.do")
public class BoardWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//커뮤니티 게시판의 값을 디비에 넣어주는 서블릿
		String category=request.getParameter("board-selector");
		String title=request.getParameter("boardWrite-title");
		User u=(User)request.getSession().getAttribute("loginUser");
		String text=request.getParameter("smarteditor");
		String tag=request.getParameter("boardTag");
		
		
		
		//유저넘버는 회원 기본키
		
		
		System.out.println("유저넘버 :"+u.getNo());
		
		//세션의 유저아이디를 가지고 유저 테이블에가서 유저넘버 가져오기
		
		BoardJoinUser b=new BoardJoinUser(0,u.getNo(),category,null,0,tag,title,text,'N',u.getNickName()); 
		System.out.println("보드테이블의 유저넘버:"+b.getUserNo());
		System.out.println("등록한글"+b);
		int result=new BoardService().insertBoard(b);
		System.out.println("결과값이 있니?"+result);
		//msg창을 이용해 result 분기처리 해주기 
		if(result>0) {
			
			request.setAttribute("BoardJoinUser", b);
			request.getRequestDispatcher("/views/board/boardView.jsp").forward(request, response);;
		}else {
			request.setAttribute("msg", "게시글 등록에 실패하였습니다");
			request.setAttribute("loc","/views/board/boardWrite.jsp");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
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
