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
import com.laon.trip.model.vo.TripPicture;

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
		
		if(!like.equals("null")&&!recent.equals("null")) {
			sql = prop.getProperty("sortlistwritelike");
		}
		if(!like.equals("null") && recent.equals("null")) {
			System.out.println("like클릭했을 떄 들어오는 dao 입니다.");
			sql = prop.getProperty("sortlistlike");
		}
		if(!recent.equals("null") && like.equals("null")) {
			System.out.println("sortlistwrite들어오냐");
			sql = prop.getProperty("sortlistwrite");
		}
		if(like.equals("null")&&recent.equals("null")) {
			System.out.println("둘다 널일떄 찍힘?");
			sql = prop.getProperty("searchtriplist");
			check=1;
		}
		
		System.out.println("변화전 : " + sql);
		if(category.equals("null") || category.equals("전체 여행기")) {
			Pattern pattern = Pattern.compile("=");
			   Matcher matcher = pattern.matcher(sql);
			   int count = 0;
			   while (matcher.find()) {
			      count++;
			   }
			   matcher.reset();
			   int[] indexs = new int[count];
			   int i = 0;
			   while (matcher.find()) {
			      indexs[i] =  matcher.start();
			      System.out.println(indexs[i]);
			      i++;
			   }
			   System.out.println("indexs.length : " + indexs.length);
			   int targetIndex = indexs[1];
			   
			   sql = sql.substring(0, targetIndex) + "!=" + sql.substring(targetIndex+1, sql.length());
		}
		if(lo.equals("null") || lo.equals("선택 지역별")) {
			Pattern pattern = Pattern.compile("=");
			   Matcher matcher = pattern.matcher(sql);
			   int count = 0;
			   while (matcher.find()) {
			      count++;
			   }
			   matcher.reset();
			   int[] indexs = new int[count];
			   int i = 0;
			   while (matcher.find()) {
			      indexs[i] =  matcher.start();
			      System.out.println(indexs[i]);
			      i++;
			   }
			   System.out.println("indexs.length : " + indexs.length);
			   int targetIndex = indexs[2];
			   sql = sql.substring(0, targetIndex) + "!=" + sql.substring(targetIndex+1, sql.length());
		}
		
		if(keyword.equals("null")) {
			System.out.println("sql 모길래 : " + sql);
			Pattern pattern = Pattern.compile("LIKE");
			   Matcher matcher = pattern.matcher(sql);
			   int count = 0;
			   while (matcher.find()) {
			      count++;
			   }
			   matcher.reset();
			   int[] indexs = new int[count];
			   int i = 0;
			   while (matcher.find()) {
			      indexs[i] =  matcher.start();
			      System.out.println(indexs[i]);
			      i++;
			   }
			   System.out.println("indexs.length : " + indexs.length);
			   int targetIndex = indexs[1];
			   sql = sql.substring(0, targetIndex) + "!=" + sql.substring(targetIndex+4, sql.length());

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

	public ArrayList<TripPicture> searchPicture(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<TripPicture> pictureList = new ArrayList();
		
		String sql = prop.getProperty("searchpicture");
		
		TripPicture tp = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				tp = new TripPicture();
				tp.setNo(rs.getInt("NO"));
				tp.setTRIP_NO(rs.getInt("TRIP_NO"));
				tp.setImage(rs.getString("IMAGE"));
				
				pictureList.add(tp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return pictureList;
	}
	
	
}
