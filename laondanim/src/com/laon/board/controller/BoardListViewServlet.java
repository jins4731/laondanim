package com.laon.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.board.model.service.BoardService;
import com.laon.board.model.vo.Board;
import com.laon.common.CommonKey;
import com.laon.common.template.PageTemplate;

import static com.laon.common.template.PageTemplate.*;
import static com.laon.common.template.MsgTemplate.*;

/**
 * Servlet implementation class BoardListViewServlet
 */
@WebServlet("/board/boardListView.do")
public class BoardListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardListViewServlet. doGet()");
		int currentPage = getCurrentPage(request);
		int pagePerRow = 8;
		List<Board> list = new BoardService().selectBoardPage(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow));
		int totalRowCount = new BoardService().selectBoardCount();
		String pageBar = getPageBar(totalRowCount, currentPage, pagePerRow, request, "");
		
		request.setAttribute(CommonKey.LIST, list);
		request.setAttribute(CommonKey.PAGE_BAR, pageBar);
		request.getRequestDispatcher("").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
