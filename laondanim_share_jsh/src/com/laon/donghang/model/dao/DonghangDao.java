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
	private String nickName = "nick_Name";
	private String image = "image";

	
	
	private String selectDonghang = "selectDonghang";
	private String selectDonghangPage = "selectDonghangPage";
	private String selectDonghangCount = "selectDonghangCount";
	private String selectDonghangKeywordCount = "selectDonghangKeywordCount";
	private String selectDonghangKeywordRecent = "selectDonghangKeywordRecent";
	private String selectDonghangKeywordViewcount = "selectDonghangKeywordViewcount";
	private String selectDonghangKeywordNearSchedule = "selectDonghangKeywordNearSchedule";
	private String selectDonghangRecent = "selectDonghangRecent";
	private String selectDonghangViewcount = "selectDonghangViewcount";
	private String selectDonghangNearSchedule = "selectDonghangNearSchedule";

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
	
	//join vo용 rs
	public List<DonghangJoinUserPicture> joinRsProcess(ResultSet rs, List<DonghangJoinUserPicture> list) throws SQLException {
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

			list.add(donghang);
		}
		return list;
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

	public List<DonghangJoinUserPicture> selectDonghangPage(Connection conn, int start, int end, String keyword, String recent, String viewcount, String nearSchedule) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		List<DonghangJoinUserPicture> list = null;
		boolean haveLike = true;

		//sql문 나누기
		if( !keyword.equals("null") && !recent.equals("null") ) { //키워드 O, 최신순
			sql = prop.getProperty(selectDonghangKeywordRecent);
		}else if( !keyword.equals("null") && !viewcount.equals("null") ) { //키워드 O, 조회수순
			sql = prop.getProperty(selectDonghangKeywordViewcount);
		}else if( !keyword.equals("null") && !nearSchedule.equals("null") ) { //키워드 O, 가까운 일정순
			sql = prop.getProperty(selectDonghangKeywordNearSchedule);
		}else if( keyword.equals("null") && !recent.equals("null") ) { //키워드 X, 최근순
			sql = prop.getProperty(selectDonghangRecent);
		}else if( keyword.equals("null") && !viewcount.equals("null") ) { //키워드 X, 조회수순
			sql = prop.getProperty(selectDonghangViewcount);
		}else if( keyword.equals("null") && !nearSchedule.equals("null") ) { //키워드 X, 가까운 일정순
			sql = prop.getProperty(selectDonghangNearSchedule);
		}else if( !keyword.equals("null") && recent.equals("null") && viewcount.equals("null") && nearSchedule.equals("null")) {
			sql = prop.getProperty(selectDonghangKeywordRecent); //검색만 했을 때! (기본 최신순 정렬)
		}else {
			sql = prop.getProperty(selectDonghangPage);
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			//키워드 o, x 분기
			if(!keyword.equals("null")) {
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}else {
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}
			rs = pstmt.executeQuery();
			list = joinRsProcess(rs, new ArrayList<DonghangJoinUserPicture>());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
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
	
	public int selectDonghangCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		if(keyword.equals("null")) {			
			sql = prop.getProperty(selectDonghangCount);
		} else {
			sql = prop.getProperty(selectDonghangKeywordCount);
		}
		System.out.println(sql);
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(!keyword.equals("null")) {	
				pstmt.setString(1, "%"+keyword+"%");
			}
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

	public List<DonghangJoinUserPicture> selectDonghangTag(Connection conn, int start, int end, String userTag) {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		List<DonghangJoinUserPicture> list = null;
		//태그길이만큼  when~then sql문 만들기
		String[] userTagArr = userTag.split(",");
		String likeSql = "";
		for(String tag : userTagArr) {
			likeSql += "WHEN DH.TAG LIKE '%" + tag + "%' THEN '1' ";
		}
		
		try {
			stmt = conn.createStatement();
			sql = "SELECT * FROM (SELECT A.*, ROWNUM AS RNUM FROM (SELECT DH.*, U.NICK_NAME, P.IMAGE, CASE "
					+ likeSql 
					+"ELSE '0' END AS TAG_COUNT FROM DONGHANG_TB DH "
					+ "INNER JOIN USER_TB U ON DH.USER_NO = U.NO INNER JOIN PICTURE_TB P ON DH.NO = P.DONGHANG_NO ORDER BY TAG_COUNT DESC) A) "
					+ "WHERE RNUM BETWEEN "+ start +" AND "+end;
			
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
}
