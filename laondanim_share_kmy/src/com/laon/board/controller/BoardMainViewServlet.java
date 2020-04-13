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
 * Servlet implementation class EnterBoardPageServlet
 */
@WebServlet("/board/list.do")
public class BoardMainViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardMainViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//커뮤니티 게시판으로 이동 하는 서블릿
		//이동했을때 페이징이랑 
		
		//페이징 처리하기
		int cPage;
		try {
				cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		
		int numPerPage=5;
		///전체 게시판글을 불러오는 로직
		String category="null";
		String searchDetail="null";
		String searchBox="null";
		String recent="null";
		String viewCount="null";
		
		List<BoardJoinUser> list=new BoardService().searchBoard(cPage,numPerPage,category,searchDetail,searchBox,recent,viewCount);
		///////////////////////////////////////////////////////////////////////////////////////////
		int totalData=new BoardService().countBoard();
		System.out.println("총데이터수:"+totalData);
		int totalPage=(int)Math.ceil((double)totalData/numPerPage);
		
		//페이지 바는 템플릿으로 구현을 해본다
		String url=request.getContextPath();
		String pageBar=new Paging().pageBar(request.getContextPath()+"/board/list.do",totalData,cPage,numPerPage);
		System.out.println(pageBar);
		request.setAttribute("pageBar",pageBar);
		
		//총 데이터수도 보내줭
		
		request.setAttribute("totalData", totalData);
		//리스트 출력해서 보내줌
		request.setAttribute("list",list);
		request.getRequestDispatcher("/views/board/boardMain.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
