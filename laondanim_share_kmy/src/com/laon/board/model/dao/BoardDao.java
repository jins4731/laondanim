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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.laon.board.model.vo.Board;
import com.laon.board.model.vo.BoardComment;
import com.laon.board.model.vo.BoardCommentJoinUser;
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
	
	public int insertBoard(Connection conn,BoardJoinUser b) {
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
	
	
	/*
	 * public List<BoardJoinUser> selectBoard(Connection conn,int cPage,int
	 * numPerPage){ PreparedStatement pstmt=null; ResultSet rs=null;
	 * List<BoardJoinUser> list=new ArrayList(); String
	 * sql=prop.getProperty("selectBoard"); try{pstmt=conn.prepareStatement(sql);
	 * pstmt.setInt(1, (cPage-1)*numPerPage+1); pstmt.setInt(2, cPage*numPerPage);
	 * rs=pstmt.executeQuery(); while(rs.next()) { BoardJoinUser b=new
	 * BoardJoinUser(); b.setNo(rs.getInt("no")); b.setUserNo(rs.getInt("user_no"));
	 * b.setCategory(rs.getString("category"));
	 * b.setWriteDate(rs.getDate("write_date"));
	 * b.setViewCount(rs.getInt("viewcount")); b.setTag(rs.getString("tag"));
	 * b.setTitle(rs.getString("title")); b.setContent(rs.getString("content"));
	 * b.setDeleted(rs.getString("deleted").charAt(0));
	 * b.setNickName(rs.getString("nick_name")); list.add(b); } }catch(SQLException
	 * e) { e.printStackTrace(); }finally { close(rs); close(pstmt); }return list;
	 * 
	 * }
	 */
	
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
	
	public List<BoardJoinUser> searchBoard(Connection conn,int cPage,int perPage,String category,String searchDetail,String searchBox,String recent,String viewCount){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BoardJoinUser> list=new ArrayList();
		String sql="";
	
		//검색창부터
		//작성자writer  제목title 내용content 키워드 태그tags
		if(searchDetail.equals("writer")) {
			sql=prop.getProperty("selectBoardSortWriter");
		}if(searchDetail.equals("title")) {
			sql=prop.getProperty("selectBoardSortTitle");
		}if(searchDetail.equals("content")) {
			sql=prop.getProperty("selectBoardSortContent");
		}if(searchDetail.equals("tags")) {
			sql=prop.getProperty("selectBoardSortTags");
		}if(searchDetail.equals("null")) {
			sql=prop.getProperty("selectBoard");
		}
		System.out.println("패턴1적용전:"+sql);
		/*
		 * if(!recent.equals("null") && viewCount.equals("null")) { //최신순 버튼 눌렀을때 ORDER
		 * BY WRITEDATE DESC 추가 sql=sql.replace("DELETED='N'",
		 * "DELETED='N' ORDER BY WRITE_DATE DESC");
		 * 
		 * }
		 */ 
		if(recent.equals("null") &&!viewCount.equals("null")) {
			//조회수순 버튼 눌렀을때 ORDER BY VIEWCOUNT DESC 추가
			sql=sql.replace("DELETED='N' ORDER BY WRITE_DATE DESC", "DELETED='N' ORDER BY VIEWCOUNT DESC");
			  }
		
		
		
		System.out.println("패턴2적용전:"+sql);
		if(category.equals("null")||category.equals("all")) {
			//전체를 출력할경우 category= 이거를 category!= 이걸로 바꿔줘야함
			Pattern pattern=Pattern.compile("=");
			Matcher matcher=pattern.matcher(sql);
			int count=0;
			while(matcher.find()) {
				count++;
			}
			matcher.reset();
			int[] indexs=new int[count];
			int i=0;
			while(matcher.find()) {
				indexs[i]=matcher.start();
				i++;
		}
		System.out.println("indexs.length:"+indexs.length);
		int targetIndex=indexs[1];
		sql=sql.substring(0,targetIndex)+"!="+sql.substring(targetIndex+1,sql.length());
			
		}
		System.out.println("패턴2적용후:"+sql);
	
	
	try{pstmt=conn.prepareStatement(sql);
		if(category.equals("null")){//처음화면일때
			pstmt.setString(1, "null");
			pstmt.setInt(2, (cPage-1)*perPage+1);
			pstmt.setInt(3,cPage*perPage);
		}else if(category.equals("all")&&(searchDetail.equals("null") ||searchBox.equals("null"))) {//최신이나 조회수순 눌렀을때
			pstmt.setString(1, "null");
			pstmt.setInt(2, (cPage-1)*perPage+1);
			pstmt.setInt(3,cPage*perPage);
		}
		else {//검색했을때
		pstmt.setString(1, category);
		pstmt.setString(2, "%"+searchBox+"%");
		pstmt.setInt(3, (cPage-1)*perPage+1);
		pstmt.setInt(4,cPage*perPage);
		}
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
	}
		return list;

		
		
	}

	public int searchCount(Connection conn,String category,String searchDetail,String searchBox) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BoardJoinUser> list=new ArrayList();
		String sql="";
		int result=0;
		if(searchDetail.equals("writer")) {
			sql=prop.getProperty("selectBoardSortWriter");
		}if(searchDetail.equals("title")) {
			sql=prop.getProperty("selectBoardSortTitle");
		}if(searchDetail.equals("content")) {
			sql=prop.getProperty("selectBoardSortContent");
		}if(searchDetail.equals("tags")) {
			sql=prop.getProperty("selectBoardSortTags");
		}if(searchDetail.equals("null")) {
			sql=prop.getProperty("selectBoard");
			sql=sql.replace("WHERE DELETED='N'", "WHERE CATEGORY=? AND DELETED='N'");
		}
		sql=sql.replace("WHERE RNUM BETWEEN ? AND ?", " ");
		System.out.println("적용됨 sql?"+sql);
		if(category.equals("null")||category.equals("all")) {
			//전체를 출력할경우 category= 이거를 category!= 이걸로 바꿔줘야함
			Pattern pattern=Pattern.compile("=");
			Matcher matcher=pattern.matcher(sql);
			int count=0;
			while(matcher.find()) {
				count++;
			}
			matcher.reset();
			int[] indexs=new int[count];
			int i=0;
			while(matcher.find()) {
				indexs[i]=matcher.start();
				i++;
		}
		System.out.println("indexs.length:"+indexs.length);
		int targetIndex=indexs[1];
		
		sql=sql.substring(0,targetIndex)+"!="+sql.substring(targetIndex+1,sql.length());
		System.out.println("완성된 sql문:"+sql);	
		System.out.println("카테고리뭐야:"+category);
		}
		try{pstmt=conn.prepareStatement(sql);
		if(category.equals("null")||category.equals("all")&&searchBox.equals("null")) {
			pstmt.setString(1, "null");
		}
		else { pstmt.setString(1, category);
			pstmt.setString(2, "%"+searchBox+"%");
		}
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
		result=list.size();
	}
		return result;
		
		
	}

	public int insertComment(Connection conn, BoardComment bc) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertComment");
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,bc.getUserNo());
		pstmt.setInt(2,bc.getBoardNo());
		pstmt.setString(3,bc.getContent());
		pstmt.setInt(4, bc.getLevel());
		pstmt.setInt(5,bc.getBoardCommentRef());
		result=pstmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}

		return result;
	}

	public List<BoardCommentJoinUser> selectComment(Connection conn, int boardNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BoardCommentJoinUser> list=new ArrayList();
		String sql=prop.getProperty("selectComment");
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			BoardCommentJoinUser bc=new BoardCommentJoinUser();
			bc.setNo(rs.getInt("no"));
			bc.setUserNo(rs.getInt("user_no"));
			bc.setBoardNo(rs.getInt("board_no"));
			bc.setWriteDate(rs.getDate("write_date"));
			bc.setContent(rs.getString("content"));
			bc.setLevel(rs.getInt("comment_level"));
			bc.setBoardCommentRef(rs.getInt("board_comment_ref"));
			bc.setCommentWriter(rs.getString("nick_name"));
			list.add(bc);
		}
	
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}return list;
		
	}

	public int deleteComment(Connection conn,int commentNo) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("deleteComment");
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, commentNo);
		result=pstmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}return result;
	
	}
	
	
}
