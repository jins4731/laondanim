package com.laon.mypage.model.dao;

import static com.laon.common.template.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.laon.board.model.dao.BoardDao;
import com.laon.board.model.vo.Board;
import com.laon.common.PropPath;
import com.laon.common.robot.LaonRobot;

public class MypageDao {
	private Properties prop = new Properties();
	
	// 기존에 구현되어있는 Dao들을 가져다 쓰고 새로 추가해야되는 기능이 있으면
	// 작성 예시용 처럼 추가해서 사용
	
	
	// 작성 예시용
	
	// Board
	 private String no = "no";
	 private String userNo = "user_no";
	 private String category = "category";
	 private String writeDate = "write_date";
	 private String viewcount = "viewcount";
	 private String tag = "tag";
	 private String title = "title";
	 private String content = "content";
	 private String deleted = "deleted";
	 
	 private String selectBoard = "selectBoard";
	 private String selectBoardPage = "selectBoardPage";
	 private String selectBoardCount = "selectBoardCount";
	 
	 
	 
	 
	
	public MypageDao() {
		try {
			prop.load(new FileReader(MypageDao.class.getResource(PropPath.MYPAGE).getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public <E> E rsProcess(ResultSet rs, E item) throws SQLException {
		if(item instanceof LaonRobot) {
			LaonRobot<E> robot = (LaonRobot<E>)item;
			item = robot.rsProcess(item,rs);
		}
		return item;
	}

	public <E> List<E> rsProcess(ResultSet rs, List<E> list,E item) throws SQLException {
		List<E> newlist = null;
		if(item instanceof LaonRobot) {
			LaonRobot<E> robot = (LaonRobot<E>)item;
			newlist = robot.rsProcess(list,rs);
		}
		return newlist;
	}

	
	
	
	
	public Board selectBoard(Connection conn, String no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectBoard);
		Board board = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(no));
			rs = pstmt.executeQuery();
			board = rsProcess(rs, new Board());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return board;
	}
	
	public List<Board> selectBoardPage(Connection conn, int start,int end) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectBoardPage);
		List<Board> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Board>(),new Board());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	

	public int selectBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectBoardCount);
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
}
