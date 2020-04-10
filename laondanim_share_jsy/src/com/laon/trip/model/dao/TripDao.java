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
import com.laon.user.model.vo.User;

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
			sql = prop.getProperty("selectTripPage");
			check=1;
		}
		
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
			      i++;
			   }
			   int targetIndex = indexs[2];
			   //SELECT * FROM (SELECT A.*, ROWNUM AS RNUM FROM (SELECT TR.*, (SELECT COUNT(*) FROM LIKE_TB WHERE TR.NO=TRIP_NO AND CANCLED='Y') AS CNT FROM TRIP_TB TR WHERE CATEGORY=? AND TRAVLE_LOCALE=? AND TAG LIKE ? ORDER BY CNT DESC)A) WHERE RNUM BETWEEN ? AND ?

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
			      i++;
			   }

			   int targetIndex = indexs[3];
			   sql = sql.substring(0, targetIndex) + "!=" + sql.substring(targetIndex+1, sql.length());
		}
		
		if(keyword.equals("null")) {
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
			      i++;
			   }

			   int targetIndex = indexs[1];
			   sql = sql.substring(0, targetIndex) + "!=" + sql.substring(targetIndex+4, sql.length());

		}
		
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
				t.setTag(rs.getString("TAG"));
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
		
		String sql = prop.getProperty("selectTripCount");
		//SELECT COUNT(*) FROM TRIP_TB WHERE CATEGORY=? AND TRAVLE_LOCALE=? AND TAG LIKE ?

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
	
	public ArrayList<Like> selectLikeCount(Connection conn, ArrayList<Trip> list){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectLikeCount");
		
		ArrayList<Like> likeListCount = new ArrayList<Like>();
		Like l = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(int i=0; i<list.size(); i++) {			
				pstmt.setInt(1, list.get(i).getNo());	
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					l = new Like();
					
					l.setTripNo(rs.getInt("NO"));
					l.setLikeCount(rs.getInt("CNT"));
					
					likeListCount.add(l);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return likeListCount;
	}
	
	public ArrayList<Like> selectLike(Connection conn, int loginNo){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectLike");
		
		ArrayList<Like> likeList = new ArrayList<Like>();
		Like l = null;
		try {
				pstmt = conn.prepareStatement(sql);
			
			
				
				pstmt.setInt(1, loginNo);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					l = new Like();
					l.setNo(rs.getInt("NO"));
					l.setUserNo(rs.getInt("USER_NO"));
					l.setTripNo(rs.getInt("TRIP_NO"));
					l.setCancled(rs.getString("CANCLED"));
					
					likeList.add(l);
				}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return likeList;
	}
	public ArrayList<User> selectUser(Connection conn, ArrayList<Trip> list){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectUser");
		
		ArrayList<User> userList = new ArrayList<User>();
		User u = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(Trip t : list) {
				pstmt.setInt(1, t.getUserTbNo());
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					u = new User();
					
					u.setNo(rs.getInt("NO"));
					u.setCreatedDate(rs.getDate("CREATED_DATE"));
					u.setUserId(rs.getString("USER_ID"));
					u.setPassword(rs.getString("PASSWORD"));
					u.setName(rs.getString("NAME"));
					u.setNickName(rs.getString("NICK_NAME"));
					u.setBirthday(rs.getDate("BIRTHDAY"));
					u.setGender(rs.getString("GENDER"));
					u.setPhone(rs.getString("PHONE"));
					u.setEmail(rs.getString("EMAIL"));
					u.setTag(rs.getString("TAG"));	//배열로 수정 고민
					
					userList.add(u);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return userList;
	}
	
	//LIKE 테이블 가져오기 (TRIP_NO, USER_NO)를 가지고
	public String selectLikeCancled(Connection conn, int tripNo, int userNo){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectLikeCancled");
		
		String cancled = "";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, tripNo);
			pstmt.setInt(2, userNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cancled = rs.getString("CANCLED");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return cancled;
	}
	
	//좋아요 버튼 update
	public int updateLike(Connection conn, int tripNo, int userNo, String cancled) {
		PreparedStatement pstmt = null;
		
		//LIKE_TB SET CANCLED=? WHERE TRIP_NO=? AND USER_NO=?
		String sql = prop.getProperty("updateLike");
	
		int result = 0;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cancled.equals("N")?"Y":"N");
			pstmt.setInt(2, tripNo);
			pstmt.setInt(3, userNo);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
			
		return result;
	}
	
	//좋아요 버튼 insert
	public int insertLike(Connection conn, int tripNo, int userNo) {
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertLike");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, tripNo);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
}
