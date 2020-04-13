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
import com.laon.common.robot.LaonRobot;
import com.laon.trip.model.vo.Trip;
import com.laon.trip.model.vo.TripSchedule;
import com.laon.tripinfo.model.vo.Tripinfo;

public class TripDao {
	private Properties prop = new Properties();
	
	

	private String selectTrip = "selectTrip";
	private String selectTripPage = "selectTripPage";
	private String selectTripCount = "selectTripCount";
	
	 private String selectTripScheduleList = "selectTripScheduleList";
	 
	 
	 
	 
	 

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
		System.out.println(sql);
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

}
