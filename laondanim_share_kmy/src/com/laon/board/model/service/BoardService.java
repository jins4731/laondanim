package com.laon.board.model.service;

import static com.laon.common.JDBCTemplate.getConnection;
import static com.laon.common.JDBCTemplate.close;
import static com.laon.common.JDBCTemplate.commit;
import static com.laon.common.JDBCTemplate.rollback;
import java.sql.Connection;

import com.laon.board.model.dao.BoardDao;
import com.laon.board.model.vo.Board;

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
	
	
	
	
	
}
