package com.laon.board.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;
import static com.laon.common.JDBCTemplate.close;
import static com.laon.common.JDBCTemplate.commit;
import static com.laon.common.JDBCTemplate.getConnection;
import static com.laon.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.laon.board.model.dao.BoardDao;
import com.laon.board.model.vo.Board;
import com.laon.board.model.vo.BoardJoinUser;

public class BoardService {

	public BoardDao dao=new BoardDao();
	
	
	public int insertBoard(Board b) {
		Connection conn=getConnection();
		int result=dao.insertBoard(conn,b);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public List<BoardJoinUser> selectBoard(int cPage,int numPerPage){
		Connection conn=getConnection();
		List<BoardJoinUser> list=dao.selectBoard(conn,cPage,numPerPage);
		close(conn);
		return list;
		
		
	}
	
	public int countBoard() {
		Connection conn=getConnection();
		int count=dao.countBoard(conn);
		close(conn);
		System.out.println("서비스 몇개야:"+count);
		return count;
	}

	public BoardJoinUser boardDetail(int boardNo, boolean hasRead) {
		Connection conn=getConnection();
		BoardJoinUser b=dao.boardDetail(conn,boardNo);
		if(!hasRead&&b!=null) {
			//안읽었을때
			int result=dao.updateReadCount(conn,boardNo);
			if(result>0) {
				commit(conn);
				b.setViewCount(dao.boardDetail(conn, boardNo).getViewCount());
			}
			else rollback(conn);
			
		}
		close(conn);
		return b;
		
	}
	
	
	
	
}
