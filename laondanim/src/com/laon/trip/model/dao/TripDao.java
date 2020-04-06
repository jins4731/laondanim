package com.laon.trip.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.laon.trip.model.vo.Trip;
import static com.laon.common.JDBCTemplate.*;

public class TripDao {

	private Properties prop = new Properties();
	
	public TripDao() {
		// TODO Auto-generated constructor stub
		try {
			String path = TripDao.class.getResource("/sql/trip/trip-query.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Trip> searchList(Connection conn, int cPage, int perPage){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Trip> list = new ArrayList<Trip>();
		String sql = prop.getProperty("searchtriplist"); 
		Trip t = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*perPage+1);
			pstmt.setInt(2, cPage*perPage);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				t= new Trip();
				
				t.setNo(rs.getInt("NO"));
				t.setUserTbNo(rs.getInt("USER_TB_NO"));
				t.setCategory(rs.getString("CATEGORY"));
				t.setWriteDate(rs.getDate("WRITE_DATE"));
				t.setTag(rs.getString("TAG").split(","));
				t.setTitle(rs.getString("TITLE"));
				t.setContent(rs.getString("CONTENT"));
				t.setTripLocate(rs.getString("TRAVLE_LOCALE"));
				t.setPeopleNum(rs.getInt("PEOPLE_NUM"));
				t.setTripType(rs.getString("TRAVLE_TYPE"));
				t.setStartDate(rs.getDate("TRAVLE_START_DATE"));
				t.setEndDate(rs.getDate("TRAVLE_END_DATE"));
				t.setPublicEnabled(rs.getString("PUBLIC_ENABLED").charAt(0));
				t.setDeleted(rs.getString("DELETED").charAt(0));
				
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
	
	public ArrayList<Trip> searchList(Connection conn, int cPage, int perPage, String keyword){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Trip> list = new ArrayList<Trip>();
		String sql = prop.getProperty("searchtriplistkeyword"); 
		Trip t = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, (cPage-1)*perPage+1);
			pstmt.setInt(3, cPage*perPage);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				t= new Trip();
				
				t.setNo(rs.getInt("NO"));
				t.setUserTbNo(rs.getInt("USER_TB_NO"));
				t.setCategory(rs.getString("CATEGORY"));
				t.setWriteDate(rs.getDate("WRITE_DATE"));
				t.setTag(rs.getString("TAG").split(","));
				t.setTitle(rs.getString("TITLE"));
				t.setContent(rs.getString("CONTENT"));
				t.setTripLocate(rs.getString("TRAVLE_LOCALE"));
				t.setPeopleNum(rs.getInt("PEOPLE_NUM"));
				t.setTripType(rs.getString("TRAVLE_TYPE"));
				t.setStartDate(rs.getDate("TRAVLE_START_DATE"));
				t.setEndDate(rs.getDate("TRAVLE_END_DATE"));
				t.setPublicEnabled(rs.getString("PUBLIC_ENABLED").charAt(0));
				t.setDeleted(rs.getString("DELETED").charAt(0));
				
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
	
	
	public ArrayList<Trip> searchListPr(Connection conn, int cPage, int perPage, String type, String keyword){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Trip> list = new ArrayList<Trip>();
		
		String sql = "";
		if(keyword==null) {
			sql = prop.getProperty("searchtriplistpr");
		}else {
			sql = prop.getProperty("searchtriplistprkeyword");
		} 
		
		
		Trip t = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			if(keyword==null) {
				pstmt.setString(1, type);
				pstmt.setInt(2, (cPage-1)*perPage+1);
				pstmt.setInt(3, cPage*perPage);
			}else {
				pstmt.setString(1, type);
				pstmt.setString(2, "%"+keyword+"%");
				pstmt.setInt(3, (cPage-1)*perPage+1);
				pstmt.setInt(4, cPage*perPage);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				t= new Trip();
				
				t.setNo(rs.getInt("NO"));
				t.setUserTbNo(rs.getInt("USER_TB_NO"));
				t.setCategory(rs.getString("CATEGORY"));
				t.setWriteDate(rs.getDate("WRITE_DATE"));
				t.setTag(rs.getString("TAG").split(","));
				t.setTitle(rs.getString("TITLE"));
				t.setContent(rs.getString("CONTENT"));
				t.setTripLocate(rs.getString("TRAVLE_LOCALE"));
				t.setPeopleNum(rs.getInt("PEOPLE_NUM"));
				t.setTripType(rs.getString("TRAVLE_TYPE"));
				t.setStartDate(rs.getDate("TRAVLE_START_DATE"));
				t.setEndDate(rs.getDate("TRAVLE_END_DATE"));
				t.setPublicEnabled(rs.getString("PUBLIC_ENABLED").charAt(0));
				t.setDeleted(rs.getString("DELETED").charAt(0));
				
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
	
	public int getTotalData(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("totaldata");
		
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			count = rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}
	
	public int getTotalData(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("totaldatakeyword");
		
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			
			rs.next();
			
			count = rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}
	
	public int getTotalDataPr(Connection conn, String type, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String sql = "";
		if(keyword==null) {
			sql = prop.getProperty("totaldatapr");
		}else {
			sql = prop.getProperty("totaldataprkeyword");
		}
		
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			if(keyword==null) {
				pstmt.setString(1, type);
			}else {
				pstmt.setString(1, type);
				pstmt.setString(2, "%"+keyword+"%");
			}
			rs = pstmt.executeQuery();
			
			rs.next();
			
			count = rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
		
	}
}
