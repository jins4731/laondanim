package com.laon.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.board.model.service.BoardService;
import com.laon.board.model.vo.BoardComment;

/**
 * Servlet implementation class BoardCommentInsertServlet
 */
@WebServlet("/board/commentInsert.do")
public class BoardCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String commentContent=request.getParameter("commentContent");
		int commentWriter=Integer.parseInt(request.getParameter("commentWriter"));
		int boardNo=Integer.parseInt(request.getParameter("boardRef"));
		int level=Integer.parseInt(request.getParameter("level"));
		int commentRef=Integer.parseInt(request.getParameter("commentRef"));
		
		BoardComment bc=new BoardComment(0,commentWriter,boardNo,null,commentContent,null,level,commentRef);
		System.out.println("댓글 넣을값:"+bc);
		int result=new BoardService().insertComment(bc);
		String msg="";
		if(result>0) {
			msg="댓글등록 성공";
		}else {
			msg="댓글등록 실패";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/board/boardView.do?no="+boardNo);
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
