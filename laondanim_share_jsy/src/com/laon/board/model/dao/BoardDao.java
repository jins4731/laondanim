package com.laon.board.model.dao;

import static com.laon.common.template.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.laon.board.model.vo.Board;


public class BoardDao {

	private Properties prop=new Properties();
	
	public BoardDao() {
		try {
			String path=BoardDao.class.getResource("/sql/board/board-query.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertBoard(Connection conn,Board b) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertBoard");
	try{
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,b.getNo());
		pstmt.setString(2,b.getCategory());
		pstmt.setString(3,b.getTag());
		pstmt.setString(4, b.getTitle());
		pstmt.setString(5, b.getContent());
		pstmt.setString(6, String.valueOf(b.getDeleted()));
		result=pstmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}return result;
		
	}
	
}
