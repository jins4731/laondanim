package com.laon.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.board.model.service.BoardService;
import com.laon.board.model.vo.BoardComment;
import com.laon.board.model.vo.BoardCommentJoinUser;
import com.laon.board.model.vo.BoardJoinUser;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/board/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 보는 서블릿
		//게시글 번호 가져옴
		int boardNo=Integer.parseInt(request.getParameter("no"));
		System.out.println("들어왔니?"+boardNo);
		//쿠키로 조회수 설정. f5누르면 조회수가 계속올라가유
		Cookie[] cookies=request.getCookies();
		String cookieVal="";
		boolean hasRead=false;//false면  조회수 증가, true면 조회수 그대로
		if(cookies!=null) {
			for(Cookie c:cookies) {
				String name=c.getName();
				String value=c.getValue();
				System.out.println("쿠키값:"+name+":"+value);
				if("boardCookie".equals(name)) {
					cookieVal=value;
					if(value.contains("|"+boardNo+"|")) {//"|"는 구분자. 앱에서 쿠키값 확인하면 이해 가능.
						hasRead=true;
						break;
					}
				}
			}
		}
		if(!hasRead) {
			//안읽은거면
			Cookie c=new Cookie("boardCookie",cookieVal+"|"+boardNo+"|");
			c.setMaxAge(-1);//session 종료시 삭제
			response.addCookie(c);
		}
		
		BoardJoinUser b=new BoardService().boardDetail(boardNo,hasRead);
		System.out.println("b는뭐야:"+b);
		//댓글도 받아오자
		//게시글의 번호를 댓글도 참조하고 있으니까!
		List<BoardCommentJoinUser> comments=new BoardService().selectComment(boardNo);
		System.out.println("댓글 있니:"+comments.size());
		
		if(b==null) { //게시글이 없을경우
			String msg="선택한 게시물이 존재하지 않습니다"; 
			String loc="/board/board"; 
			request.setAttribute("msg", "선택한 게시물이 존재하지 않습니다");
			request.setAttribute("loc", "/views/board/boardMain.jsp");
			request.getRequestDispatcher("/views/common/msg.jsp");
			
		}else {
		 
			request.setAttribute("BoardJoinUser", b);
			request.setAttribute("comments", comments);
			request.getRequestDispatcher("/views/board/boardView.jsp").forward(request, response);
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
