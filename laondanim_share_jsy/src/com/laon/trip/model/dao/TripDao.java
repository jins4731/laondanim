package com.laon.trip.model.dao;

import static com.laon.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.laon.trip.model.vo.Trip;

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
				t.setUserTbNo(rs.getInt("USER_NO"));
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
				t.setUserTbNo(rs.getInt("USER_NO"));
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
		if(keyword.equals("null")) {
			sql = prop.getProperty("searchtriplistpr");
		}else {
			sql = prop.getProperty("searchtriplistprkeyword");
		} 
		
		
		Trip t = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			if(keyword.equals("null")) {
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
				t.setUserTbNo(rs.getInt("USER_NO"));
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
		if(keyword.equals("null")) {
			sql = prop.getProperty("totaldatapr");
		}else {
			sql = prop.getProperty("totaldataprkeyword");
		}
		
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			if(keyword.equals("null")) {
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
	
	public ArrayList<Trip> searchList(Connection conn, int cPage, int perPage, String lo, String category, String keyword, String recent, String like){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int check = 0;
		System.out.println("category : " + category);
		System.out.println("keyword : " + keyword);
		System.out.println("lo : " + lo);
		System.out.println("like : "+ like);
		System.out.println("recent : " + recent);
		Pattern pattern = Pattern.compile("(?==[^?])="); // 검색할 문자 패턴
		   String str = "SELECT * FROM (SELECT * FROM (SELECT A.*, ROWNUM AS R FROM (SELECT * FROM TRIP_TB WHERE CATEGORY=? AND TRAVLE_LOCALE=? AND TAG LIKE ?)A) WHERE R BETWEEN ? AND ?)B JOIN (SELECT TRIP_NO, COUNT(*)AS COUNT FROM (SELECT * FROM TRIP_TB  JOIN LIKE_TB ON TRIP_TB.NO=LIKE_TB.TRIP_NO) GROUP BY TRIP_NO)C ON B.NO=C.TRIP_NO ORDER BY WRITE_DATE DESC";
		   Matcher matcher = pattern.matcher(str); // 패턴을 이용해 Matcher객체 반환
		   while (matcher.find()) { // Matcher객체로 문자 탐색  
		      System.out.println("matcher.group() : "+ matcher.group()); 
		   }
		if(!like.equals("null")&&!recent.equals("null"))
			sql = prop.getProperty("sortlistwritelike");
		if(!like.equals("null"))
			sql = prop.getProperty("sortlistlike");
		if(!recent.equals("null"))
			System.out.println("sortlistwrite들어오냐");
			sql = prop.getProperty("sortlistwrite");
		if(like.equals("null")&&recent.equals("null")) {
			System.out.println("둘다 널일떄 찍힘?");
			sql = prop.getProperty("searchtriplist2");
			check=1;
		}
		System.out.println("변화전 : " + sql);
		
		if(category.equals("null") || category.equals("전체 여행기")) {
			sql =sql.replaceFirst("=", "!=");
			
		}
		if(lo.equals("null") || lo.equals("선택 지역별")) {
			if(check==1)
				sql = replaceLast(sql, "=", "!=", 0);
			else
				sql = replaceLast(sql, "=", "!=", 1);
		}
		if(keyword.trim().equals("null")) {			
			sql = sql.replaceFirst("LIKE", "!=");
			System.out.println("4번    여기여기");
		}
		System.out.println("변화 : " + sql);
		
		ArrayList<Trip> list = new ArrayList<Trip>();
		Trip t = null;
		try {
			pstmt = conn.prepareStatement(sql);
			if(category.equals("null") || category.equals("전체 여행기")) pstmt.setString(1, "null");
			else pstmt.setString(1, category);
						
			if(lo.equals("null") || lo.equals("선택 지역별")) pstmt.setString(2, "null");
			else pstmt.setString(2, lo);
			
			if(keyword.equals("null")) pstmt.setString(3, "null");
			else pstmt.setString(3, "%"+keyword+"%");
			pstmt.setInt(4, (cPage-1)*perPage+1);
			pstmt.setInt(5, cPage*perPage);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				t= new Trip();
				
				t.setNo(rs.getInt("NO"));
				t.setUserTbNo(rs.getInt("USER_NO"));
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
	
	public int getTotalData(Connection conn, String lo, String category, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("lo : " + lo);
		System.out.println("category : " + category);
		System.out.println("keyword : " + keyword);
		
		String sql = prop.getProperty("totaldatafilter");
		//SELECT COUNT(*) FROM TRIP_TB WHERE CATEGORY=? AND TRAVLE_LOCALE=? AND TAG LIKE ?
		System.out.println("변화전 : " + sql);

		if(category.equals("null") || category.equals("전체 여행기")) {
			sql =sql.replaceFirst("=", "!=");
		}
		if(lo.equals("null") || lo.equals("선택 지역별")) {
			sql = replaceLast(sql, "=", "!=",0);
		}
		if(keyword.equals("null")) {			
			sql = sql.replaceFirst("LIKE", "!=");
		}
		
		int count = 0;
		System.out.println("변화 : " + sql);
		try {
			pstmt = conn.prepareStatement(sql);
			if(category.equals("null") || category.equals("전체 여행기")) pstmt.setString(1, "null");
			else pstmt.setString(1, category);
						
			if(lo.equals("null") || lo.equals("선택 지역별")) pstmt.setString(2, "null");
			else pstmt.setString(2, lo);
			
			if(keyword.equals("null")) pstmt.setString(3, "null");
			else pstmt.setString(3, "%"+keyword+"%");
						
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
	
	private static String replaceLast(String string, String toReplace, String replacement, int check) {    

		   int pos = 0;
		   if(check==0) pos = string.lastIndexOf(toReplace);     
		   else pos = string.lastIndexOf(toReplace,3);
		   
		   if (pos > -1) {        

		   return string.substring(0, pos)+ replacement + string.substring(pos +   toReplace.length(), string.length());     

		   } else { 

			return string;     

		   } 

		} 

	public String[] getTagList(Connection conn, String search){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("tagdatalist");
		ArrayList<String> tagList = new ArrayList<String>();
		String tag = "";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				tag = rs.getString("TAG");
				
				tagList.add(tag);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		String[] arrTag = new String[tagList.size()];
		tagList.toArray(arrTag);
		
		return arrTag;
	}

	
}
