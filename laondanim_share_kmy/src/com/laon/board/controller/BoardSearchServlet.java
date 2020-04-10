package com.laon.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.board.model.service.BoardService;
import com.laon.board.model.vo.BoardJoinUser;
import com.laon.common.Paging;

/**
 * Servlet implementation class BoardSearchServlet
 */
@WebServlet("/board/search.do")
public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//검색버튼 눌렀을때.
		//category 값 null이면 검색안한 디폴트
		String category=request.getParameter("category");
		category=category==null?"null":category;
		//게시글 관련검색 searchDetail null이면 검색안한 디폴트
		String searchDetail=request.getParameter("detail");
		searchDetail=searchDetail==null?"null":searchDetail;
		//검색창에 입력한값 검색안하면 디폴트
		String searchBox=request.getParameter("searchBox");
		searchBox=searchBox==null?"null":searchBox;
		//세가지가 null이면-> 검색 안한거
		
		//최신순 검색순은 각각 문자열을 받아옴.스트링 값이 null일경우  누르지 않은 버튼 임! 둘중 하나만 누르게 할거니까
		String recent=request.getParameter("recent");
		String viewCount=request.getParameter("viewCount");
		/*category
		 * 전체게시글all 질문글qna 자유글others
		 * searchDetail
		 * 작성자writer 제목+내용titleContent 제목title 내용content 키워드 태그tags
		 */
		
		
		
		int cPage;
		
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		int perPage = 5;
		int totalItemCount=0;
		
		totalItemCount=new BoardService().countBoard();

		
	/*	if(category.equals("qna")) {
			category="질문글";
		}else if(category.equals("others")) {
			category="자유글";
		}else {
			category="all";
		}*/
		
		List<BoardJoinUser> list=new BoardService().searchBoard(cPage,perPage,category,searchDetail,searchBox,recent,viewCount); 
		
		String pageBar=new Paging().pageBar(request.getContextPath()+"/board/search.do",
				totalItemCount,cPage,perPage,category,searchDetail,searchBox,recent,viewCount);
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
