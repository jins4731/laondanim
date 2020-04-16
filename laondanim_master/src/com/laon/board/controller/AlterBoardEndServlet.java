package com.laon.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.board.model.service.BoardService;
import com.laon.board.model.vo.BoardJoinUser;
import com.laon.user.model.vo.User;

/**
 * Servlet implementation class AlterBoardEndServlet
 */
@WebServlet("/board/boardalterEnd.do")
public class AlterBoardEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterBoardEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 수정한것을 저장하는 로직
		int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		String category=request.getParameter("board-selector");
		String title=request.getParameter("boardWrite-title");
		User u=(User)request.getSession().getAttribute("loginUser");
		String text=request.getParameter("smarteditor");
		String tag=request.getParameter("boardTag");
		
		
		//카테고리 저장설정
		if(category.equals("qna")) {
			category="질문글";
		}else {
			category="자유글";
		}
		//태그저장하기(앞뒤-사이공백없이,태그사이에 #으로 구분)
		tag=tag.replaceAll(" ", "");
		tag=tag.trim();
		System.out.println("태그저장할 문자열 만듬:"+tag);
		BoardJoinUser b=new BoardJoinUser(boardNo,u.getNo(),category,null,0,tag,title,text,'N',u.getNickName()); 
		int result=new BoardService().alterBoard(b);
		
		
		String msg="";
		String loc="";
		if(result>0) {
			msg="게시글 수정 성공";
			loc="/board/boardView.do?no="+boardNo;
		}else {
			msg="게시글 수정 실패";
			loc="/board/boardView.do?no="+boardNo;
		
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
