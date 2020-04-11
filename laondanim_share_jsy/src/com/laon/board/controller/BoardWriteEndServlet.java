package com.laon.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.board.model.service.BoardService;
import com.laon.board.model.vo.Board;
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
		
		if(category.equals("qna")) {
			category="질문글";
		}else if(category.equals("others")) {
			category="자유글";
		}
		
		//유저넘버는 회원 기본키
		
		int no=u.getNo();
		System.out.println("유저넘버 :"+no);
		//스마트에디터 된다는 전제하에
		//디비가
		//세션의 유저아이디를 가지고 유저 테이블에가서 유저넘버 가져오기************8
		
		
		Board b=new Board(0,no,category,null,0,tag,title,text,'N'); 
		int result=new BoardService().insertBoard(b);
		
		//msg창을 이용해 result 분기처리 해주기 
		if(result>0) {
			request.setAttribute("msg", "글을 성공적으로 등록되었습니다");
			request.setAttribute("loc", "/views/board/boardView.jsp");
		}else {
			request.setAttribute("msg", "게시글 등록에 실패하였습니다");
			request.setAttribute("msg","/views/board/boardWrite.jsp");
		}
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
