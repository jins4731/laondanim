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
import com.laon.donghang.model.vo.DonghangJoin;
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
			
			while(rs.next()) {
				up=new UserProfile();
				up.setNo(rs.getInt("no"));
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
	
	public boolean selectPwck(Connection conn,int userNo,String pw){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean flag=false;
		String sql=prop.getProperty("selectPwck");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				flag=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return flag;
	}
	
	public int updateUserProfile(Connection conn,UserProfile up) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateUserInfo");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, up.getPassword());
			pstmt.setString(2, up.getNickName());
			pstmt.setInt(3, up.getPhone());
			pstmt.setString(4, up.getEmail());
			pstmt.setString(5, up.getTag());
			pstmt.setInt(6, up.getNo());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
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
				l.setLikeCount(rs.getInt("lk"));
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
	
	public List<DonghangJoin> selectJoin(Connection conn,int userNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<DonghangJoin> list=new ArrayList<DonghangJoin>();
		String sql=prop.getProperty("selectJoin");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				DonghangJoin dj=new DonghangJoin();
				dj.setNo(rs.getInt("no"));
				dj.setUserNo(rs.getInt("user_no"));
				dj.setDonghangNo(rs.getInt("donghang_no"));
				dj.setContent(rs.getString("content"));
				dj.setConfirmed(rs.getString("confirmed"));
				dj.setCancled(rs.getString("cancled"));
				dj.setReported(rs.getString("reported"));
				dj.setDeleted(rs.getString("deleted"));
				list.add(dj);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<MyDong> selectOriJoin(Connection conn, List<DonghangJoin> jd){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<MyDong> list=new ArrayList<MyDong>();
		String sql=prop.getProperty("selectOriJoin");
		
		try {
			pstmt=conn.prepareStatement(sql);
			for(DonghangJoin j:jd) {
				pstmt.setInt(1, j.getDonghangNo());
				rs=pstmt.executeQuery();
				if(rs.next()) {
					MyDong d=new MyDong();
					d.setNo(rs.getInt("no"));
					d.setUserNo(rs.getInt("user_no"));
					d.setWriteDate(rs.getDate("write_date"));
					d.setTitle(rs.getString("title"));
					d.setTravleLocale(rs.getString("travle_locale"));
					d.setTravleStartDate(rs.getDate("travle_start_date"));
					d.setTravleEndDate(rs.getDate("travle_end_date"));
					d.setPw(rs.getInt("pw"));
					d.setPublicEnabled(rs.getString("public_enabled"));
					d.setJoinPeopleNo(rs.getInt("join_people_no"));
					d.setRecruitPeopleNo(rs.getInt("recruit_people_no"));
					d.setImage(rs.getString("image"));
					list.add(d);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<MyDong> selectOriJoinAll(Connection conn, List<DonghangJoin> jd,int start,int end){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<MyDong> list=new ArrayList<MyDong>();
		String sql=prop.getProperty("selectOriJoinAll");
		
		try {
			pstmt=conn.prepareStatement(sql);
			for(DonghangJoin j:jd) {
				pstmt.setInt(1, j.getDonghangNo());
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					MyDong d=new MyDong();
					d.setNo(rs.getInt("no"));
					d.setUserNo(rs.getInt("user_no"));
					d.setWriteDate(rs.getDate("write_date"));
					d.setTitle(rs.getString("title"));
					d.setTravleLocale(rs.getString("travle_locale"));
					d.setTravleStartDate(rs.getDate("travle_start_date"));
					d.setTravleEndDate(rs.getDate("travle_end_date"));
					d.setPw(rs.getInt("pw"));
					d.setPublicEnabled(rs.getString("public_enabled"));
					d.setJoinPeopleNo(rs.getInt("join_people_no"));
					d.setRecruitPeopleNo(rs.getInt("recruit_people_no"));
					d.setImage(rs.getString("image"));
					list.add(d);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<UserProfile> selectUserNick(Connection conn, List<MyDong> ojd){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<UserProfile> userNick=new ArrayList<UserProfile>();
		String sql=prop.getProperty("selectUserNick");
		
		try {
			pstmt=conn.prepareStatement(sql);
			for(MyDong j:ojd) {
				pstmt.setInt(1, j.getUserNo());
				rs=pstmt.executeQuery();
				if(rs.next()) {
					UserProfile up=new UserProfile();
					up.setNo(rs.getInt("no"));
					up.setNickName(rs.getString("nick_Name"));
					userNick.add(up);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return userNick;
	}
	
	public int selectMyJDCount(Connection conn,int userNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectMyJDCount");
		int result=0;
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
}
