package com.laon.board.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		
		//카테고리 저장설정
		if(category.equals("qna")) {
			category="질문글";
		}else {
			category="자유글";
		}
	
		//날짜 만들기
		
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy/MM/dd");
		Date time = new Date();
		
		String date = format1.format(time);
		Date today = null;
		try {
			today = format1.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("날짜:"+today);
		//태그저장하기(앞뒤-사이공백없이,태그사이에 #으로 구분)
		tag=tag.replaceAll(" ", "");
		tag=tag.trim();
		System.out.println("태그저장할 문자열 만듬:"+tag);
		//유저넘버는 회원 기본키
		
		
		System.out.println("유저넘버 :"+u.getNo());
		
		//세션의 유저아이디를 가지고 유저 테이블에가서 유저넘버 가져오기
		
		BoardJoinUser b=new BoardJoinUser(0,u.getNo(),category,today,0,tag,title,text,'N',u.getNickName()); 
		int result=new BoardService().insertBoard(b);
		
		System.out.println("보드테이블의 유저넘버:"+b.getUserNo());
		System.out.println("등록한글"+b);

		System.out.println("결과값이 있니?"+result);
		//msg창을 이용해 result 분기처리 해주기 
		if(result>0) {
			
			/* request.setAttribute("BoardJoinUser", b); */
			request.getRequestDispatcher("/board/list.do").forward(request, response);;
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
