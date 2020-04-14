package com.laon.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.board.model.service.BoardService;

/**
 * Servlet implementation class BoardAlterCommentServlet
 */
@WebServlet("/board/alterComment.do")
public class BoardAlterCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAlterCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//댓글을 수정하는 서블릿
		//UPDATE board_comment_tb SET CONTENT='수정함' WHERE NO=158;
		//CONTENT랑 COMMENT NO만 받아오면됨.
		String alterContent=request.getParameter("commentContent");
		int commentNo=Integer.parseInt(request.getParameter("commentRef"));
		int boardNo=Integer.parseInt(request.getParameter("boardRef"));
		
		
		int result=new BoardService().alterComment(alterContent,commentNo);
		
		String msg="";
		String loc="";
		
		
		 if(result>0) { msg="댓글이 수정되었습니다"; loc="/board/boardView?no="+boardNo;
		  
		 }else { msg="댓글 수정실패(알수없는 오류)"; loc="/board/boardView?no="+boardNo; }
		  
		 request.setAttribute("msg", msg); request.setAttribute("loc", loc);
		 request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);
		 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
