package com.laon.trip.model.dao;

import static com.laon.common.template.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import com.laon.common.PropPath;
import com.laon.common.robot.LaonRobot;
import com.laon.etc.model.vo.Like;
import com.laon.etc.model.vo.Picture;
import com.laon.trip.model.vo.Day;
import com.laon.trip.model.vo.Schedule;
import com.laon.trip.model.vo.TagCount;
import com.laon.trip.model.vo.Trip;
import com.laon.trip.model.vo.Trip2;
import com.laon.trip.model.vo.TripData;
import com.laon.trip.model.vo.TripSchedule;
import com.laon.tripinfo.model.vo.Tripinfo;
import com.laon.user.model.vo.User;

public class TripDao {
	private Properties prop = new Properties();
	
	

	private String selectTrip = "selectTrip";
	private String selectTripPage = "selectTripPage";
	private String selectTripCount = "selectTripCount";
	
	 private String selectTripScheduleList = "selectTripScheduleList";
	 private String insertTrip = "insertTrip";
	 private String insertTripSchedule = "insertTripSchedule";
	 private String selectTripLastNum = "selectTripLastNum";
	 
	 
	 
	 
	 

	public TripDao() {
		try {
			prop.load(new FileReader(TripDao.class.getResource(PropPath.TRIP).getPath()));
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
	

	public Trip selectTrip(Connection conn, String no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectTrip);
		Trip trip = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(no));
			rs = pstmt.executeQuery();
			trip = rsProcess(rs, new Trip());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return trip;
	}

	public List<Trip> selectTripPage(Connection conn, int start, int end) {
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = prop.getProperty(selectTripPage);
	      List<Trip> list = null;
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, start);
	         pstmt.setInt(2, end);
	         rs = pstmt.executeQuery();
	         list = rsProcess(rs, new ArrayList<Trip>(),new Trip());
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         close(rs);
	         close(pstmt);
	      }
	      return list;
	   }
	
	public int selectTripCount(Connection conn) {
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = prop.getProperty(selectTripCount);
	      int result = 0;
	      try {
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         rs.next();
	         result = rs.getInt(1);
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         close(rs);
	         close(pstmt);
	      }
	      return result;
	   }
	
	public List<TripSchedule> selectTripScheduleList(Connection conn, int tripNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectTripScheduleList);
		List<TripSchedule> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tripNo);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<TripSchedule>(), new TripSchedule());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public List<Tripinfo> selectTripinfoWhereNoIn(Connection conn, List<Integer> tripinfoNoList) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TRIPINFO_TB WHERE NO IN (";
		for (Integer integer : tripinfoNoList) {
			sql += "'" + integer + "',";
		}
		sql = sql.substring(0, sql.length()-1);
		sql += ")";
		
		List<Tripinfo> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Tripinfo>(),new Tripinfo());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	////==============================================================================================
	public ArrayList<Trip2> selectTripPage(Connection conn, int cPage, int perPage, String lo, String category, String keyword, String recent, String like, ArrayList<TagCount> tripTagCountList, String first){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectTripPage2");
		int check = 0;			   
		ArrayList<Trip2> list = new ArrayList<Trip2>();
		Trip2 t = null;
		System.out.println("====변화전====");
		System.out.println(sql);
		if(first.equals("first")) {
			for(int i=(cPage-1)*perPage; i<cPage*perPage; i++) {
				if(i<tripTagCountList.size()) {
				
				t = new Trip2();
				
				t.setNo(tripTagCountList.get(i).getNo());
				t.setUserTbNo(tripTagCountList.get(i).getUserTbNo());
				t.setCategory(tripTagCountList.get(i).getCategory());
				t.setWriteDate(tripTagCountList.get(i).getWriteDate());
				t.setTag(String.join(",", tripTagCountList.get(i).getTag()));
				t.setTitle(tripTagCountList.get(i).getTitle());
				t.setContent(tripTagCountList.get(i).getContent());
				t.setTripLocate(tripTagCountList.get(i).getTripLocate());
				t.setPeopleNum(tripTagCountList.get(i).getPeopleNum());
				t.setTripType(tripTagCountList.get(i).getTripType());
				t.setStartDate(tripTagCountList.get(i).getStartDate());
				t.setPublicEnabled(tripTagCountList.get(i).getPublicEnabled());
				t.setDeleted(tripTagCountList.get(i).getDeleted());
				
				list.add(t);
				
				}
			}
			
			return list;
		}else {
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
				sql = prop.getProperty("selectTripPage2");
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
				   //SELECT * FROM (SELECT A.*, ROWNUM AS RNUM FROM (SELECT TR.*, 
				   //(SELECT COUNT(*) FROM LIKE_TB WHERE TR.NO=TRIP_NO AND CANCLED='Y') AS CNT FROM TRIP_TB TR 
				   //WHERE CATEGORY=? AND TRAVLE_LOCALE=? AND TAG LIKE ? ORDER BY CNT DESC)A) WHERE RNUM BETWEEN ? AND ?
	
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
				   int targetIndex=0;
				   
				   
				   targetIndex = indexs[3];
				
				   
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
			System.out.println("====변화후====");
			System.out.println(sql);
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
					t= new Trip2();
					
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
	}

	
	
	
	
	public int selectTripCount(Connection conn, String lo, String category, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectTripCount2");
		//SELECT COUNT(*) FROM TRIP_TB WHERE CATEGORY=? AND TRAVLE_LOCALE=? AND TAG LIKE AND DELETED='N'?
		
		if(category.equals("null") || category.equals("전체 여행기")) {
			sql =sql.replaceFirst("=", "!=");
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

			   int targetIndex = 0;
			   
			   targetIndex = indexs[1];
			   
			   sql = sql.substring(0, targetIndex) + "!=" + sql.substring(targetIndex+1, sql.length());
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

	public ArrayList<Picture> selectPicture(Connection conn, ArrayList<Trip2> list){
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
	
	public ArrayList<Like> selectLikeCount(Connection conn, ArrayList<Trip2> list){
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
	
	public ArrayList<User> selectUser(Connection conn, ArrayList<Trip2> list){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectUser");
		
		ArrayList<User> userList = new ArrayList<User>();
		User u = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(Trip2 t : list) {
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
					u.setTag(rs.getString("TAG"));	//�迭�� ���� ���
					
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
	
	//���ƿ� ��ư update
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
	
	//���ƿ� ��ư insert
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
	
	public ArrayList<Trip2> selectTagList(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectTagList");
		Trip2 t = null;
		
		ArrayList<Trip2> tagList = new ArrayList<Trip2>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				t = new Trip2();
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
				
				tagList.add(t);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return tagList;
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

	public List<Tripinfo> selectTripinfoList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TRIPINFO_TB";
		List<Tripinfo> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Tripinfo>(),new Tripinfo());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int insertTrip(Connection conn, TripData data) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty(insertTrip);
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(data.getUserNo()));
//			pstmt.setInt(1, 1);
			pstmt.setString(2, data.getCategory());
			pstmt.setString(3, data.getTag());
			pstmt.setString(4, data.getTitle());
			pstmt.setString(5, data.getContent());
			pstmt.setString(6, data.getTravleLocale());
			pstmt.setInt(7, Integer.parseInt(data.getPeopleNum()));
			pstmt.setString(8, data.getTravleTyp());
			pstmt.setDate(9, Date.valueOf(data.getTravleStartDate()));
			pstmt.setDate(10, Date.valueOf(data.getTravleEndDate()));
			pstmt.setString(11, data.getPublicEnabled());
//			pstmt.setString(11, "y");
//			pstmt.setString(12, data.getDeleted());
			pstmt.setString(12, "N");
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int[] insertTripSchedule(Connection conn, TripData data2, int tripNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = prop.getProperty(insertTripSchedule);
		int result[] = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<data2.getScheduleData().length;i++) {
				Day d = data2.getScheduleData()[i];
				for (int k = 0; k < d.getScheduleList().length; k++) {
					Schedule s = d.getScheduleList()[k];
					
					pstmt.setInt(1, tripNo);
					pstmt.setInt(2, Integer.parseInt(s.getTripinfoNo()));
					pstmt.setInt(3, Integer.parseInt(s.getDays()));
					pstmt.setInt(4, Integer.parseInt(s.getOrders()));
					pstmt.setString(5, s.getRequiredHours());
					pstmt.setString(6, s.getTransport());
					
					pstmt.addBatch();
					
				}
			}
			result = pstmt.executeBatch();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int selectTripLastSeq(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectTripLastNum);
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	} 
	
	public ArrayList<TripSchedule> selectSchedule(Connection conn, int no){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectSchedule");
		int result = 0;
		ArrayList<TripSchedule> scheduleList = new ArrayList<TripSchedule>();
		TripSchedule s = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			 
			while(rs.next()) {
				s = new TripSchedule();
				//s.setNo(rs.getInt("NO"));
				s.setTripNo(rs.getInt("TRIP_NO"));
				//s.setTripinfoNo(rs.getInt("TRIPINFO_NO"));
				//s.setDay(rs.getInt("DAY"));
				//s.setOrders(rs.getInt("ORDERS"));
				//s.setRequiredHours(rs.getString("REQUIRED_HOURS"));
				//s.setTransport(rs.getString("TRANSPORT"));
				
				scheduleList.add(s);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return scheduleList;
	}
	
	public ArrayList<Trip2> selectTripList(Connection conn, ArrayList<TripSchedule> scheduleList){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectTripList");
		
		Trip2 t = null;
		ArrayList<Trip2> tripList = new ArrayList<Trip2>();
		try {
			pstmt = conn.prepareStatement(sql);
		
			int cnt = 0;

			for(TripSchedule ts : scheduleList) {
				pstmt.setInt(1, ts.getTripNo());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					t = new Trip2();
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
					t.setDeleted(rs.getString("DELETED").charAt(0));
										
					tripList.add(t);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return tripList;
	}
}
