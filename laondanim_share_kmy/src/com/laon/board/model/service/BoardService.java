package com.laon.board.model.service;


import static com.laon.common.JDBCTemplate.close;
import static com.laon.common.JDBCTemplate.commit;
import static com.laon.common.JDBCTemplate.getConnection;
import static com.laon.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.laon.board.model.dao.BoardDao;
import com.laon.board.model.vo.Board;
import com.laon.board.model.vo.BoardComment;
import com.laon.board.model.vo.BoardCommentJoinUser;
import com.laon.board.model.vo.BoardJoinUser;

public class BoardService {

	public BoardDao dao=new BoardDao();
	
	
	public int insertBoard(BoardJoinUser b) {
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
	
	/*
	 * public List<BoardJoinUser> selectBoard(int cPage,int numPerPage){ Connection
	 * conn=getConnection(); List<BoardJoinUser>
	 * list=dao.selectBoard(conn,cPage,numPerPage); close(conn); return list;
	 * 
	 * 
	 * }
	 */
	
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
	
	public List<BoardJoinUser> searchBoard(int cPage,int perPage,String category,String searchDetail,String searchBox,String recent,String viewCount){
		Connection conn=getConnection();
		List<BoardJoinUser> list=dao.searchBoard(conn,cPage,perPage,category,searchDetail,searchBox,recent,viewCount);
		close(conn);
		return list;
	}

	public int searchCount(String category,String searchDetail,String searchBox) {
		Connection conn=getConnection();
		int count=dao.searchCount(conn,category,searchDetail,searchBox);
		close(conn);
		return count;
	}

	public int insertComment(BoardComment bc) {
		Connection conn=getConnection();
		int result=dao.insertComment(conn,bc);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public List<BoardCommentJoinUser> selectComment(int boardNo) {
		Connection conn=getConnection();
		List<BoardCommentJoinUser> list=dao.selectComment(conn,boardNo);
		close(conn);
		return list;
				
	}

	public int deleteComment(int commentNo) {
		Connection conn=getConnection();
		int result=dao.deleteComment(conn,commentNo);
		if(result>0) commit(conn);
		else rollback(conn);		
		close(conn);
		return result;
	}
	
	
	
	
}