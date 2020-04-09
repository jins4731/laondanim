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

import com.laon.etc.model.vo.Like;
import com.laon.etc.model.vo.Picture;
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
	
	public ArrayList<Trip> selectTripPage(Connection conn, int cPage, int perPage, String lo, String category, String keyword, String recent, String like){
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
			sql = prop.getProperty("selectTripPageSortAll");
		}
		if(!like.equals("null") && recent.equals("null")) {
			sql = prop.getProperty("selectTripPageSortLike");
		}
		if(!recent.equals("null") && like.equals("null")) {
			sql = prop.getProperty("selectTripPageSortWrite");
		}
		if(like.equals("null")&&recent.equals("null")) {
			System.out.println("둘다 널일떄 찍힘?");
			sql = prop.getProperty("selectTripPage");
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
	
	public int selectTripCount(Connection conn, String lo, String category, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("lo : " + lo);
		System.out.println("category : " + category);
		System.out.println("keyword : " + keyword);
		
		String sql = prop.getProperty("selectTripCount");
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
		String sql = prop.getProperty("selectTagDataList");
		ArrayList<String> tagList = new ArrayList<String>();
		String tag = "";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+search+"%");
			
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

	public ArrayList<Picture> selectPicture(Connection conn, ArrayList<Trip> list){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Picture> pictureList = new ArrayList<Picture>();
		String sql = prop.getProperty("selectPicture");
		
		Picture p = new Picture();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(int i=0; i<list.size(); i++) {
				pstmt.setInt(1, list.get(i).getNo());
				rs = pstmt.executeQuery();
				
				//private int no;
				//private int TRIP_NO;
				//private String image;
				
				while(rs.next()) {
					p = new Picture();
					p.setNo(rs.getInt("NO"));
					p.setTripNo(rs.getInt("TRIP_NO"));
					p.setTripinfoNo(rs.getInt("TRIPINFO_NO"));
					p.setDonghangNo(rs.getInt("DONGHANG_NO"));
					p.setUserNo(rs.getInt("USER_NO"));
					p.setImage(rs.getString("IMAGE"));
					
					pictureList.add(p);
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return pictureList;
	}
	
	public ArrayList<Like> selectLike(Connection conn, ArrayList<Trip> list){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectLike");
		
		ArrayList<Like> likeList = new ArrayList<Like>();
		Like l = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(int i=0; i<list.size(); i++) {
				System.out.println("dao에서 list(trip no) 값 : " + list.get(i).getNo()); //여기서 1 int형 나와요
				//DAO 에서 pstmt.setInt 할때 오류가 납니다 ..
				
				pstmt.setInt(1, list.get(i).getNo());	//여기서 이값은
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					l = new Like();
					l.setTripNo(rs.getInt("NO"));
					l.setLikeCount(rs.getInt("CNT"));
					
					likeList.add(l);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return likeList;
	}
	
}
