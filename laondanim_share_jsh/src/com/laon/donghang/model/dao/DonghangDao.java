package com.laon.donghang.model.dao;

import static com.laon.common.template.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.laon.common.PropPath; //<-com.laon.common.template.PropPath;로 되어있어 변경함
import com.laon.donghang.model.vo.Donghang;
import com.laon.donghang.model.vo.DonghangJoinUserPicture;

public class DonghangDao {
	private Properties prop = new Properties();

	private String no = "no";
	private String userNo = "user_no";
	private String tripNo = "trip_no";
	private String writeDate = "write_date";
	private String viewcount = "viewcount";
	private String tag = "tag";
	private String title = "title";
	private String content = "content";
	private String travleLocale = "travle_locale";
	private String travleStartDate = "travle_start_date";
	private String travleEndDate = "travle_end_date";
	private String recruitStartDate = "recruit_start_date";
	private String recruitEndDate = "recruit_end_date";
	private String pw = "pw";
	private String publicEnabled = "public_enabled";
	private String ended = "ended";
	private String deleted = "deleted";
	private String recruitPeopleNo = "recruit_people_no";
	private String joinPeopleNo = "join_people_no";
	private String nickName = "nick_name";
	private String image = "image";

	
	
	private String selectDonghang = "selectDonghang";
	private String selectDonghangPage = "selectDonghangPage";
	private String selectDonghangCount = "selectDonghangCount";

	public DonghangDao() {
		try {
			prop.load(new FileReader(DonghangDao.class.getResource(PropPath.DONGHANG).getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Donghang rsProcess(ResultSet rs, Donghang donghang) throws SQLException {
		while (rs.next()) {
			donghang.setNo(rs.getInt(no));
			donghang.setUserNo(rs.getInt(userNo));
			donghang.setTripNo(rs.getInt(tripNo));
			donghang.setWriteDate(rs.getDate(writeDate));
			donghang.setViewcount(rs.getInt(viewcount));
			donghang.setTag(rs.getString(tag));
			donghang.setTitle(rs.getString(title));
			donghang.setContent(rs.getString(content));
			donghang.setTravleLocale(rs.getString(travleLocale));
			donghang.setTravleStartDate(rs.getDate(travleStartDate));
			donghang.setTravleEndDate(rs.getDate(travleEndDate));
			donghang.setRecruitStartDate(rs.getDate(recruitStartDate));
			donghang.setRecruitEndDate(rs.getDate(recruitEndDate));
			donghang.setPw(rs.getInt(pw));
			donghang.setPublicEnabled(rs.getString(publicEnabled));
			donghang.setEnded(rs.getString(ended));
			donghang.setDeleted(rs.getString(deleted));
			donghang.setRecruitPeopleNo(rs.getInt(recruitPeopleNo));
			donghang.setJoinPeopleNo(rs.getInt(joinPeopleNo));
		}
		return donghang;
	}

	public List<Donghang> rsProcess(ResultSet rs, List<Donghang> list) throws SQLException {
		while (rs.next()) {
			Donghang donghang = new Donghang();
			donghang.setNo(rs.getInt(no));
			donghang.setUserNo(rs.getInt(userNo));
			donghang.setTripNo(rs.getInt(tripNo));
			donghang.setWriteDate(rs.getDate(writeDate));
			donghang.setViewcount(rs.getInt(viewcount));
			donghang.setTag(rs.getString(tag));
			donghang.setTitle(rs.getString(title));
			donghang.setContent(rs.getString(content));
			donghang.setTravleLocale(rs.getString(travleLocale));
			donghang.setTravleStartDate(rs.getDate(travleStartDate));
			donghang.setTravleEndDate(rs.getDate(travleEndDate));
			donghang.setRecruitStartDate(rs.getDate(recruitStartDate));
			donghang.setRecruitEndDate(rs.getDate(recruitEndDate));
			donghang.setPw(rs.getInt(pw));
			donghang.setPublicEnabled(rs.getString(publicEnabled));
			donghang.setEnded(rs.getString(ended));
			donghang.setDeleted(rs.getString(deleted));
			donghang.setRecruitPeopleNo(rs.getInt(recruitPeopleNo));
			donghang.setJoinPeopleNo(rs.getInt(joinPeopleNo));
			list.add(donghang);
		}
		return list;
	}
	
	public List<DonghangJoinUserPicture> joinRsProcess(ResultSet rs, ArrayList<DonghangJoinUserPicture> arrayList) throws SQLException {
		while (rs.next()) {
			DonghangJoinUserPicture donghang = new DonghangJoinUserPicture();
			donghang.setNo(rs.getInt(no));
			donghang.setUserNo(rs.getInt(userNo));
			donghang.setTripNo(rs.getInt(tripNo));
			donghang.setWriteDate(rs.getDate(writeDate));
			donghang.setViewcount(rs.getInt(viewcount));
			donghang.setTag(rs.getString(tag));
			donghang.setTitle(rs.getString(title));
			donghang.setContent(rs.getString(content));
			donghang.setTravleLocale(rs.getString(travleLocale));
			donghang.setTravleStartDate(rs.getDate(travleStartDate));
			donghang.setTravleEndDate(rs.getDate(travleEndDate));
			donghang.setRecruitStartDate(rs.getDate(recruitStartDate));
			donghang.setRecruitEndDate(rs.getDate(recruitEndDate));
			donghang.setPw(rs.getInt(pw));
			donghang.setPublicEnabled(rs.getString(publicEnabled));
			donghang.setEnded(rs.getString(ended));
			donghang.setDeleted(rs.getString(deleted));
			donghang.setRecruitPeopleNo(rs.getInt(recruitPeopleNo));
			donghang.setJoinPeopleNo(rs.getInt(joinPeopleNo));
			donghang.setNickName(rs.getString(nickName));
			donghang.setImage(rs.getString(image));
			arrayList.add(donghang);
		}
		return arrayList;
	}	

	public Donghang selectDonghang(Connection conn, String no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectDonghang);
		Donghang donghang = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(no));
			rs = pstmt.executeQuery();
			donghang = rsProcess(rs, new Donghang());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return donghang;
	}

	public List<DonghangJoinUserPicture> selectDonghangPage(Connection conn, int start, int end, String userTag) {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		List<DonghangJoinUserPicture> list = null;
		//태그길이만큼  when~then sql문 만들기
		String[] userTagArr = userTag.split(",");
		String likeSql = "";
		for(String tag : userTagArr) {
			likeSql += "WHEN TAG LIKE '%" + tag + "%' THEN '1' ";
		}
		
		try {
			stmt = conn.createStatement();
			sql = "SELECT * FROM (SELECT A.*, ROWNUM AS RNUM FROM (SELECT DH.*, CASE "
					+ likeSql 
					+"ELSE '0' END AS TAG_COUNT FROM DONGHANG_TB DH ORDER BY TAG_COUNT DESC) A) WHERE RNUM BETWEEN "+ start +" AND "+end;
			
			rs = stmt.executeQuery(sql);
			list = joinRsProcess(rs, new ArrayList<DonghangJoinUserPicture>());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return list;
	}

	public int selectDonghangCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectDonghangCount);
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

	public String selectUserTag(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectUserTag");
		String userTag = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			rs.next();
			userTag = rs.getString("TAG");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return userTag;
	}

	public List<Donghang> selectDonghangKeyword(Connection conn, int start, int end, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectDonghangKeyword");
		List<Donghang> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Donghang>());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int selectDonghangKeywordCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectDonghangKeywordCount");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
}
