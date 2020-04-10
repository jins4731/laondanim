package com.laon.board.model.dao;


import static com.laon.common.JDBCTemplate.close;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.laon.board.model.vo.Board;
import com.laon.board.model.vo.BoardJoinUser;


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
		pstmt.setInt(1,b.getUserNo());
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
	
	
	
	public List<BoardJoinUser> selectBoard(Connection conn,int cPage,int numPerPage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BoardJoinUser> list=new ArrayList();
		String sql=prop.getProperty("selectBoard");
		try{pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, (cPage-1)*numPerPage+1);
		pstmt.setInt(2, cPage*numPerPage);
		rs=pstmt.executeQuery();
		while(rs.next()) {
		BoardJoinUser b=new BoardJoinUser();
		b.setNo(rs.getInt("no"));
		b.setUserNo(rs.getInt("user_no"));
		b.setCategory(rs.getString("category"));
		b.setWriteDate(rs.getDate("write_date"));
		b.setViewCount(rs.getInt("viewcount"));
		b.setTag(rs.getString("tag"));
		b.setTitle(rs.getString("title"));
		b.setContent(rs.getString("content"));
		b.setDeleted(rs.getString("deleted").charAt(0));
		b.setNickName(rs.getString("nick_name"));
		list.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
		
	}
	
	public int countBoard(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		String sql=prop.getProperty("countBoard");
	try{pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		rs.next();
		count=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return count;
		
	}
	/////////////여기서 부터 작업해 ~~쿼리문도 써라~~~/////////////
	public BoardJoinUser boardDetail(Connection conn, int boardNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BoardJoinUser b=null;
		String sql=prop.getProperty("boardDetail");
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,boardNo);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			b=new BoardJoinUser();
			b.setNo(rs.getInt("no"));
			b.setUserNo(rs.getInt("user_no"));
			b.setCategory(rs.getString("category"));
			b.setWriteDate(rs.getDate("write_date"));
			b.setViewCount(rs.getInt("viewcount"));
			b.setTag(rs.getString("tag"));
			b.setTitle(rs.getString("title"));
			b.setContent(rs.getString("content"));
			b.setDeleted(rs.getString("deleted").charAt(0));
			b.setNickName(rs.getString("nick_name"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return b;
		
	}
	
	public int updateReadCount(Connection conn,int no) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateReadCount");
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		result=pstmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}return result;
	}
	
	
	
}
