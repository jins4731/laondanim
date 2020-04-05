package com.laon.trip.model.dao;

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
import com.laon.common.PropPath;
import com.laon.trip.model.vo.Trip;

public class TripDao {
	private Properties prop = new Properties();

	private String no = "no";
	private String userNo = "user_no";
	private String category = "category";
	private String writeDate = "write_date";
	private String tag = "tag";
	private String title = "title";
	private String content = "content";
	private String travleLocale = "travle_locale";
	private String peopleNum = "people_num";
	private String travleType = "travle_type";
	private String travleStartDate = "travle_start_date";
	private String travleEndDate = "travle_end_date";
	private String publicEnabled = "public_enabled";
	private String deleted = "deleted";

	private String selectTrip = "selectTrip";
	private String selectTripPage = "selectTripPage";
	private String selectTripCount = "selectTripCount";

	public TripDao() {
		try {
			prop.load(new FileReader(TripDao.class.getResource(PropPath.TRIP).getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Trip rsProcess(ResultSet rs, Trip trip) throws SQLException {
		while (rs.next()) {
			trip.setNo(rs.getInt(no));
			trip.setUserNo(rs.getInt(userNo));
			trip.setCategory(rs.getString(category));
			trip.setWriteDate(rs.getDate(writeDate));
			trip.setTag(rs.getString(tag));
			trip.setTitle(rs.getString(title));
			trip.setContent(rs.getString(content));
			trip.setTravleLocale(rs.getString(travleLocale));
			trip.setPeopleNum(rs.getInt(peopleNum));
			trip.setTravleType(rs.getString(travleType));
			trip.setTravleStartDate(rs.getDate(travleStartDate));
			trip.setTravleEndDate(rs.getDate(travleEndDate));
			trip.setPublicEnabled(rs.getString(publicEnabled));
			trip.setDeleted(rs.getString(deleted));
		}
		return trip;
	}

	public List<Trip> rsProcess(ResultSet rs, List<Trip> list) throws SQLException {
		while (rs.next()) {
			Trip trip = new Trip();
			trip.setNo(rs.getInt(no));
			trip.setUserNo(rs.getInt(userNo));
			trip.setCategory(rs.getString(category));
			trip.setWriteDate(rs.getDate(writeDate));
			trip.setTag(rs.getString(tag));
			trip.setTitle(rs.getString(title));
			trip.setContent(rs.getString(content));
			trip.setTravleLocale(rs.getString(travleLocale));
			trip.setPeopleNum(rs.getInt(peopleNum));
			trip.setTravleType(rs.getString(travleType));
			trip.setTravleStartDate(rs.getDate(travleStartDate));
			trip.setTravleEndDate(rs.getDate(travleEndDate));
			trip.setPublicEnabled(rs.getString(publicEnabled));
			trip.setDeleted(rs.getString(deleted));
			list.add(trip);
		}
		return list;
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
			list = rsProcess(rs, new ArrayList<Trip>());
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

}
