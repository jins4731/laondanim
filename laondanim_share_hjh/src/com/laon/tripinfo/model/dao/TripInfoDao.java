package com.laon.tripinfo.model.dao;

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

import com.laon.tripinfo.model.vo.Mind;
import com.laon.tripinfo.model.vo.Picture;
import com.laon.tripinfo.model.vo.TripInfo;
import com.laon.tripinfo.model.vo.TripInfoComment;
import com.laon.tripinfo.model.vo.TripInfoPicture;
import com.laon.user.model.vo.User;

public class TripInfoDao {

	private Properties prop = new Properties();

	public TripInfoDao() {
		try {
			String path = TripInfoDao.class.getResource("/sql/tripinfo/tripinfo-query.properties").getPath();
			prop.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 여행정보 리스트 가져오기  */
	public List<TripInfoPicture> selectTripinfoList(Connection conn, int cPage,int numPerPage ,String category, String type, String keyword, String mind) {
		System.out.println(category);
		System.out.println(type);
		System.out.println(keyword);
		System.out.println(mind);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TripInfoPicture> list = new ArrayList();
		
		String sql = "";
		sql = mind.equals("null")?prop.getProperty("selectTripInfoPage"):prop.getProperty("sortMind");
		
		System.out.println("변화전 " + sql);
		//SELECT * FROM (SELECT A.*, ROWNUM AS RNUM FROM (SELECT TR.*, (SELECT COUNT(*) 
		//FROM MIND_TB WHERE TR.NO=TRIPINFO_NO AND CANCLED='Y') AS CNT FROM TRIPINFO_TB TR 
		//WHERE CATEGORY=? AND ADDRESS LIKE ? AND NAME LIKE ? AND TAG LIKE ?)A) 
		//WHERE RNUM BETWEEN ? AND ?
		//지역명, 상호명, 태그명
		
		if(type.equals("null") && keyword.equals("null") || type.equals("상호명")&&keyword.equals("null")) {
			for(int j=0; j<3; j++) {
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
			   int targetIndex = indexs[0];
			   
			   //SELECT * FROM (SELECT A.*, ROWNUM AS RNUM FROM (SELECT TR.*, (SELECT COUNT(*) FROM LIKE_TB WHERE TR.NO=TRIP_NO AND CANCLED='Y') AS CNT FROM TRIP_TB TR WHERE CATEGORY=? AND TRAVLE_LOCALE=? AND TAG LIKE ? ORDER BY CNT DESC)A) WHERE RNUM BETWEEN ? AND ?

			   sql = sql.substring(0, targetIndex) + "!=" + sql.substring(targetIndex+4, sql.length());
			}
		}
		
		if(type.equals("상호명") && !keyword.equals("null")) {
			for(int j=0; j<2; j++) {
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
			   int targetIndex = indexs[j];
			   //SELECT * FROM (SELECT A.*, ROWNUM AS RNUM FROM (SELECT TR.*, (SELECT COUNT(*) FROM LIKE_TB WHERE TR.NO=TRIP_NO AND CANCLED='Y') AS CNT FROM TRIP_TB TR WHERE CATEGORY=? AND TRAVLE_LOCALE=? AND TAG LIKE ? ORDER BY CNT DESC)A) WHERE RNUM BETWEEN ? AND ?

			   sql = sql.substring(0, targetIndex) + "!=" + sql.substring(targetIndex+4, sql.length());
			}
		}
		
		if(type.equals("지역명") && !keyword.equals("null")) {
			for(int j=0; j<2; j++) {
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
		}
		if(type.equals("태그명") && !keyword.equals("null")) {
			for(int j=0; j<2; j++) {
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

			   int targetIndex = indexs[0];
			   
			   sql = sql.substring(0, targetIndex) + "!=" + sql.substring(targetIndex+4, sql.length());
			
			}
		}
		System.out.println("변화 후 : " + sql);
			try {
							
				pstmt = conn.prepareStatement(sql);
				
				if(type.equals("null") && keyword.equals("null")) {
					pstmt.setString(1, category);
					pstmt.setString(2, "null");
					pstmt.setString(3, "null");
					pstmt.setString(4, "null");
				}
				
				if(type.equals("상호명")) {
					pstmt.setString(1, category);
					pstmt.setString(2, "null");
					if(keyword.equals("null"))
						pstmt.setString(3, "null");
					else
						pstmt.setString(3, "%"+keyword+"%");
					pstmt.setString(4, "null");
				}
				
							
				if(type.equals("지역명")) {
					pstmt.setString(1, category);
					pstmt.setString(2, "%"+keyword+"%");
					if(keyword.equals("null"))
						pstmt.setString(3, "null");
					else
						pstmt.setString(3, "%"+keyword+"%");
					pstmt.setString(4, "null");
				}
				
				if(type.equals("태그명")) {
					pstmt.setString(1, category);
					pstmt.setString(2, "null");
					if(keyword.equals("null"))
						pstmt.setString(3, "null");
					else
						pstmt.setString(3, "%"+keyword+"%");
					pstmt.setString(4, "%"+keyword+"%");
				}
								
				pstmt.setInt(5, (cPage-1)*numPerPage+1);
				pstmt.setInt(6, cPage*numPerPage);
				
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					TripInfoPicture tp = new TripInfoPicture();
					tp.setTripinfoNo(rs.getInt("no"));
					tp.setTripinfoCategory(rs.getString("category"));
					tp.setTripinfoTag(rs.getString("tag"));
					tp.setTripinfoName(rs.getString("name"));
					tp.setTripinfoAddress(rs.getString("address"));
					tp.setTripinfotime(rs.getString("BUSINESS_HOURS"));
					tp.setTripinfoNumber(rs.getString("tel"));
					tp.setTripinfoHomePage(rs.getString("HOMEPAGE"));
					tp.setTripinfoNaver(rs.getString("naver"));
					tp.setTripinfoSns(rs.getString("sns"));
					
					list.add(tp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}return list;
	}

	/* 여행정보 리스트 카운팅  */
	public int selectCountTripInfo(Connection conn, String category, String type, String keyword) {
		System.out.println("type이 모니? "+ type);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		//SELECT COUNT(*) FROM TRIPINFO_TB WHERE CATEGORY=? AND ADDRESS LIKE ? AND NAME LIKE ? AND TAG LIKE ?
		String sql = prop.getProperty("selectCountTripInfo");
		System.out.println("변화전 : " + sql);
		//지역명, 상호명, 태그명
		
		if(type.equals("상호명") && keyword.equals("null")) {
			sql = sql.replaceFirst("LIKE", "!=");
			sql = sql.replaceFirst("LIKE", "!=");
			sql = sql.replaceFirst("LIKE", "!=");
		}
		
		if(type.equals("지역명")) {
			sql = replaceLast(sql, "LIKE", "!=",0);
			sql = replaceLast(sql, "LIKE", "!=",0);
		}
		
		if(type.equals("상호명")) {
			sql = sql.replaceFirst("LIKE", "!=");
			sql = replaceLast(sql, "LIKE", "!=",0);
		}
		
		if(type.equals("태그명")) {
			sql = sql.replaceFirst("LIKE", "!=");
			sql = sql.replaceFirst("LIKE", "!=");
		}
		System.out.println("변화후 : " + sql);
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, category);
				
				if(type.equals("상호명") && keyword.equals("null")) {
					pstmt.setString(2, "null");
					pstmt.setString(3, "null");
					pstmt.setString(4, "null");
				}
				
				if(type.equals("지역명")) {
					pstmt.setString(2,"%"+keyword+"%");
					pstmt.setString(3, "null");
					pstmt.setString(4, "null");
				}
				
				if(type.equals("상호명")) {
					pstmt.setString(2,"null");
					pstmt.setString(3, "%"+keyword+"%");
					pstmt.setString(4, "null");
				}
				
				if(type.equals("태그명")) {
					pstmt.setString(2,"null");
					pstmt.setString(3, "null");
					pstmt.setString(4, "%"+keyword+"%");
				}
				rs = pstmt.executeQuery();
				rs.next();
				count = rs.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			return count;
	}
	
	/* 접속한 유저가 이 여행정보를 찜했는지 체크하는 dao */
	public String checkMind(Connection conn, int userNo, int tripinfoNo) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String cancled = null;
		String sql = prop.getProperty("checkMind");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, tripinfoNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cancled = rs.getString("cancled");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return cancled;
	}

	/* 로그인한 유저가 해당 여행정보를 처음 클릭 했을 때 */
	public int insertMind(Connection conn, int userNo, int tripinfoNo) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		// insert into MIND_TB values(?,?,?,?)
		String sql = prop.getProperty("insertMind");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, tripinfoNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	/* 로그인한 유저가 해당 여행정보를 한번 이상 클릭 했을 때 */
	public int updateMind(Connection conn, int userNo, int tripinfoNo, String cancled) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = prop.getProperty("updateMind");
		try {
			pstmt = conn.prepareStatement(sql);
			// CANCLED Y 일때는 N, 아닐 때는 , Y
			pstmt.setString(1, cancled.equals("Y") ? "N" : "Y");
			pstmt.setInt(2, userNo);
			pstmt.setInt(3, tripinfoNo);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	
	/* 로그인한 유저가 찜한 여행정보 이미지 리스트 */
	public List<Mind> selectUserMind(Connection conn, int userNo) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Mind> userMindList = new ArrayList<Mind>();
		String sql = prop.getProperty("selectUserMind");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Mind mind = new Mind();
				mind.setNo(rs.getInt("no"));
				mind.setUserNo(rs.getInt("user_no"));
				mind.setTripinfoNo(rs.getInt("tripinfo_no"));
				mind.setCancled(rs.getString("cancled"));
		
				userMindList.add(mind);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		System.out.println("dao에서 ");
		for(Mind m : userMindList) {
			System.out.println(m);
		}
		return userMindList;
	}

	
	public Picture selectUserPicture(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Picture p = null;
		String sql = prop.getProperty("selectUserPicture");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				p = new Picture();
				p.setImage(rs.getString("image"));
				p.setPictureNo(rs.getInt("no"));
				p.setUserNo(rs.getInt("user_no"));
				p.setTripNo(rs.getInt("trip_no"));
				p.setDonghangNo(rs.getInt("donghang_no"));
				p.setTripinfoNo(rs.getInt("tripinfo_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return p;
	}
	
	public List<Mind> heartCount(Connection conn , List<TripInfoPicture> list){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Mind> heartCount = new ArrayList();
		String sql = prop.getProperty("heartCount");
		for(TripInfoPicture tp : list) {
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, tp.getTripinfoNo());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Mind m = new Mind();
	
					m.setTripinfoNo(rs.getInt("no"));					
					m.setCount(rs.getInt("CNT"));
					
					heartCount.add(m);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
		}return heartCount;
	}

	public List<Picture> selectPicture(Connection conn, List<Mind> userMindList){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectPicture");
		
		List<Picture> pictureList = new ArrayList<Picture>();
		
		Picture p = null;
		
		for(Mind m : userMindList) {
		try {
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setInt(1, m.getTripinfoNo());
								
			rs = pstmt.executeQuery();
				
			while(rs.next()) {
				p = new Picture();
				
				p.setPictureNo(rs.getInt("NO"));
				p.setTripNo(rs.getInt("TRIP_NO"));
				p.setTripinfoNo(rs.getInt("TRIPINFO_NO"));
				p.setDonghangNo(rs.getInt("DONGHANG_NO"));
				p.setUserNo(rs.getInt("USER_NO"));
				p.setImage(rs.getString("IMAGE"));
				
				pictureList.add(p);
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		}
		return pictureList;
	}
	
	public List<TripInfo> selectTripinfo(Connection conn, List<Mind> userMindList){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TripInfo> tripInfoList = new ArrayList();
		String sql = prop.getProperty("selectTripinfo");
		for(Mind mind : userMindList ) {
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mind.getTripinfoNo());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					TripInfo t = new TripInfo();
					t.setTripinfoNo(rs.getInt("NO"));
					t.setTripinfoCategory(rs.getString("CATEGORY"));
					t.setTripinfoTag(rs.getString("TAG"));
					t.setTripinfoName(rs.getString("NAME"));
					t.setTripinfoAddress(rs.getString("ADDRESS"));
					t.setTripinfotime(rs.getString("BUSINESS_HOURS"));
					t.setTripinfoNumber(rs.getString("TEL"));
					t.setTripinfoHomePage(rs.getString("HOMEPAGE"));
					t.setTripinfoNaver(rs.getString("NAVER"));
					t.setTripinfoSns(rs.getString("SNS"));
					tripInfoList.add(t);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
		}return tripInfoList;
	
	}
	
	public List<Mind> selectMind(Connection conn){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Mind> selectMind = new ArrayList();
		String sql = prop.getProperty("selectMind");
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Mind m = new Mind();
				m.setNo(rs.getInt("no"));
				m.setTripinfoNo(rs.getInt("tripinfo_no"));
				m.setUserNo(rs.getInt("user_no"));
				m.setCancled(rs.getString("cancled"));
				selectMind .add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return selectMind;
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
	
	
	/* 댓글 인서트하기 */
	public int insertComment(Connection conn,TripInfoComment tc) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = prop.getProperty("insertComment");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, tc.getTripinfoTbNo());
			pstmt.setInt(2, tc.getUserTbNo());
			pstmt.setString(3, tc.getContent());
		

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	/* 댓글 불러오기 */
	public List<TripInfoComment> selectComment(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TripInfoComment> commentList = new ArrayList();
		String sql = prop.getProperty("selectComment");
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TripInfoComment tc = new TripInfoComment();
				tc.setTripinfoCommentNo(rs.getInt("no"));
				tc.setTripinfoTbNo(rs.getInt("tripinfo_no"));
				tc.setUserTbNo(rs.getInt("user_no"));
				tc.setWriteDate(rs.getDate("write_date"));
				tc.setContent(rs.getString("content"));
				tc.setDeleted(rs.getString("deleted").charAt(0));
				commentList.add(tc);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return commentList;
	}
	
	/* 방금 작성한 댓글 불러오기 */
	public List<TripInfoComment> selectUserComment(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TripInfoComment> comment = new ArrayList();
		String sql = prop.getProperty("selectUserComment");
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TripInfoComment tc = new TripInfoComment();
				tc.setTripinfoCommentNo(rs.getInt("no"));
				tc.setTripinfoTbNo(rs.getInt("tripinfo_no"));
				tc.setUserTbNo(rs.getInt("user_no"));
				tc.setWriteDate(rs.getDate("write_date"));
				tc.setContent(rs.getString("content"));
				tc.setDeleted(rs.getString("deleted").charAt(0));
				comment.add(tc);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return comment;
	}
	
	public List<User> selectUser(Connection conn,List<TripInfoPicture> list){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> selectUser = new ArrayList();
		String sql = prop.getProperty("selectUser");
		try {
			pstmt = conn.prepareStatement(sql);
			for(TripInfoPicture tc : list) {
				rs = pstmt.executeQuery();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return selectUser;
	}
	
	
}// 클래스
