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

import com.laon.board.model.vo.Board;
import com.laon.donghang.model.vo.Donghang;
import com.laon.donghang.model.vo.MyDong;
import com.laon.etc.model.vo.Like;
import com.laon.trip.model.vo.TripMyCon;
import com.laon.user.model.vo.UserProfile;

public class MypageDao {
	private Properties prop=new Properties();
	
	public MypageDao() {
		try {
			String path=MypageDao.class.getResource("/sql/mypage/mypage-query.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public UserProfile selectUserNo(Connection conn, int no) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserProfile up=null;
		String sql=prop.getProperty("selectUserNo");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				up=new UserProfile();
				up.setNo(rs.getInt("no"));
				up.setCreatedDate(rs.getDate("created_date"));
				up.setUserId(rs.getString("user_id"));
				up.setPassword(rs.getString("password"));
				up.setName(rs.getString("name"));
				up.setNickName(rs.getString("nick_name"));
				up.setBirthday(rs.getDate("birthday"));
				up.setGender(rs.getString("gender"));
				up.setPhone(rs.getInt("phone"));
				up.setEmail(rs.getString("email"));
				up.setTag(rs.getString("tag"));
				up.setImage(rs.getString("image"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return up;
	}
	
	public List<TripMyCon> selectMyTrip(Connection conn,int userNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<TripMyCon> list=new ArrayList<TripMyCon>();
		String sql=prop.getProperty("selectMyTrip");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TripMyCon t=new TripMyCon();
				t.setNo(rs.getInt("no"));
				t.setCategory(rs.getString("category"));
				t.setWriteDate(rs.getDate("write_date"));
				t.setTitle(rs.getString("title"));
				t.setImage(rs.getString("image"));
				list.add(t);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<TripMyCon> selectMyTripAll(Connection conn,int userNo,int start,int end){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<TripMyCon> list=new ArrayList<TripMyCon>();
		String sql=prop.getProperty("selectMyTripAll");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TripMyCon t=new TripMyCon();
				t.setNo(rs.getInt("no"));
				t.setCategory(rs.getString("category"));
				t.setWriteDate(rs.getDate("write_date"));
				t.setTitle(rs.getString("title"));
				t.setImage(rs.getString("image"));
				list.add(t);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List selectTripLike(Connection conn,int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List like=new ArrayList();
		Like l=null;
		String sql = prop.getProperty("selectTripLike");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {				
				l=new Like();
				l.setNo(rs.getInt("no"));
//				l.setLikeCount(rs.getInt("lk"));------------------------------------------------------>나중에 수정
				like.add(l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return like;
	}
	
	public int selectMyTripCount(Connection conn,int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectMyTripCount");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
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
	
	public List<Board> selectMyBoard(Connection conn,int start,int end){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Board> list=new ArrayList<Board>();
		String sql=prop.getProperty("selectMyBoard");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Board b=new Board();
				b.setNo(rs.getInt("no"));
				b.setCategory(rs.getString("category"));
				b.setTitle(rs.getString("title"));
				b.setWriteDate(rs.getDate("write_date"));
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
	
	public int selectMyBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectMyBoardCount");
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
	
	public List<MyDong> selectMyDong(Connection conn,int userNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<MyDong> list=new ArrayList<MyDong>();
		String sql=prop.getProperty("selectMyDong");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MyDong d=new MyDong();
				d.setNo(rs.getInt("no"));
				d.setEnded(rs.getString("ended"));
				d.setWriteDate(rs.getDate("write_date"));
				d.setTitle(rs.getString("title"));
				d.setTravleLocale(rs.getString("travle_locale"));
				d.setTravleStartDate(rs.getDate("travle_start_date"));
				d.setTravleEndDate(rs.getDate("travle_end_date"));
				d.setJoinPeopleNo(rs.getInt("join_people_no"));
				d.setRecruitPeopleNo(rs.getInt("recruit_people_no"));
				d.setImage(rs.getString("image"));
				list.add(d);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<MyDong> selectMyDHAll(Connection conn,int userNo,int start,int end){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<MyDong> list=new ArrayList<MyDong>();
		String sql=prop.getProperty("selectMyDHAll");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MyDong d=new MyDong();
				d.setNo(rs.getInt("no"));
				d.setEnded(rs.getString("ended"));
				d.setWriteDate(rs.getDate("write_date"));
				d.setTitle(rs.getString("title"));
				d.setTravleLocale(rs.getString("travle_locale"));
				d.setTravleStartDate(rs.getDate("travle_start_date"));
				d.setTravleEndDate(rs.getDate("travle_end_date"));
				d.setJoinPeopleNo(rs.getInt("join_people_no"));
				d.setRecruitPeopleNo(rs.getInt("recruit_people_no"));
				d.setImage(rs.getString("image"));
				list.add(d);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int selectMyDongCount(Connection conn,int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectMyDongCount");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
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
	
	public List selectJoinDong(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List list=new ArrayList();
		String sql=prop.getProperty("selectJoinDong");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
