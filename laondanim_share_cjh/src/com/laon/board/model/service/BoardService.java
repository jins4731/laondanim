package com.laon.board.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.laon.board.model.dao.BoardDao;
import com.laon.board.model.vo.Board;

public class BoardService {
	private BoardDao dao = new BoardDao();
	
	public Board selectBoard(String no) {
		Connection conn = getConnection();
		Board board = dao.selectBoard(conn, no);
		close(conn);
		return board;
	}
	
	public List<Board> selectBoardPage(int start,int end){
		Connection conn = getConnection();
		List<Board> list = dao.selectBoardPage(conn, start ,end);
		close(conn);
		return list;
	}

	public int selectBoardCount() {
		Connection conn = getConnection();
		int result = dao.selectBoardCount(conn);
		close(conn);
		return result;
	}
}
