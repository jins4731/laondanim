package com.laon.mypage.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.laon.board.model.vo.Board;
import com.laon.mypage.model.dao.MypageDao;

public class MypageService {
	
	// 다른 Dao에서 가져다 쓰고 없으면 MypageDao 작성후에 사용
	// 밑에는 작성 예시
	
	private MypageDao dao = new MypageDao();

	public Board selectBoard(String no) {
		Connection conn = getConnection();
		Board board = dao.selectBoard(conn, no);
		close(conn);
		return board;
	}

	public List<Board> selectBoardPage(int start, int end) {
		Connection conn = getConnection();
		List<Board> list = dao.selectBoardPage(conn, start, end);
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
