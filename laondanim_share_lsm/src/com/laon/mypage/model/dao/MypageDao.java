package com.laon.mypage.model.dao;

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
import com.laon.donghang.model.vo.Donghang;
import com.laon.donghang.model.vo.DonghangJoin;
import com.laon.trip.model.vo.Trip;

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
	
	public List<Trip> selectMyTrip(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Trip> list=new ArrayList<Trip>();
		String sql=prop.getProperty("selectMyTrip");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Trip t=new Trip();
				t.setNo(rs.getInt("no"));
				t.setCategory(rs.getString("category"));
				t.setWriteDate(rs.getDate("write_date"));
				t.setTitle(rs.getString("title"));
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
	
	public List<Trip> selectMyTripAll(Connection conn,int start,int end){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Trip> list=new ArrayList<Trip>();
		String sql=prop.getProperty("selectMyTripAll");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Trip t=new Trip();
				t.setNo(rs.getInt("no"));
				t.setCategory(rs.getString("category"));
				t.setWriteDate(rs.getDate("write_date"));
				t.setTitle(rs.getString("title"));
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
	
	public int selectMyTripCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectMyTripCount");
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
	
	public List<Donghang> selectMyDong(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Donghang> list=new ArrayList<Donghang>();
		String sql=prop.getProperty("selectMyDong");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Donghang d=new Donghang();
				d.setNo(rs.getInt("no"));
				d.setEnded(rs.getString("ended"));
				d.setWriteDate(rs.getDate("write_date"));
				d.setTitle(rs.getString("title"));
				d.setTravleLocale(rs.getString("travle_locale"));
				d.setTravleStartDate(rs.getDate("travle_start_date"));
				d.setTravleEndDate(rs.getDate("travle_end_date"));
				d.setJoinPeopleNo(rs.getInt("join_people_no"));
				d.setRecruitPeopleNo(rs.getInt("recruit_people_no"));
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
	
	public List<Donghang> selectMyDHAll(Connection conn,int start,int end){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Donghang> list=new ArrayList<Donghang>();
		String sql=prop.getProperty("selectMyDHAll");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Donghang d=new Donghang();
				d.setNo(rs.getInt("no"));
				d.setEnded(rs.getString("ended"));
				d.setWriteDate(rs.getDate("write_date"));
				d.setTitle(rs.getString("title"));
				d.setTravleLocale(rs.getString("travle_locale"));
				d.setTravleStartDate(rs.getDate("travle_start_date"));
				d.setTravleEndDate(rs.getDate("travle_end_date"));
				d.setJoinPeopleNo(rs.getInt("join_people_no"));
				d.setRecruitPeopleNo(rs.getInt("recruit_people_no"));
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
	
	public int selectMyDongCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectMyDongCount");
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
