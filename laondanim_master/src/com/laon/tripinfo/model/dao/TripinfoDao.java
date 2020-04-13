package com.laon.tripinfo.model.dao;

import static com.laon.common.template.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.laon.common.CommonKey;
import com.laon.common.PropPath;
import com.laon.common.robot.LaonRobot;
import com.laon.tripinfo.model.vo.Tripinfo;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.SQLName;

public class TripinfoDao {
	private Properties prop = new Properties();

	private String no = "no";
	private String category = "category";
	private String tag = "tag";
	private String name = "name";
	private String address = "address";
	private String businessHours = "business_hours";
	private String tel = "tel";
	private String homepage = "homepage";
	private String naver = "naver";
	private String sns = "sns";
	

	private String selectTripinfo = "selectTripinfo";
	private String selectTripinfoPage = "selectTripinfoPage";
	private String selectTripInfoWheresList = "selectTripInfoWheresList";
	private String selectTripinfoCount = "selectTripinfoCount";

	public TripinfoDao() {
		try {
			prop.load(new FileReader(Tripinfo.class.getResource(PropPath.TRIPINFO).getPath()));
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
	

	public Tripinfo selectTripinfo(Connection conn, String no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectTripinfo);
		Tripinfo tripinfo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(no));
			rs = pstmt.executeQuery();
			tripinfo = rsProcess(rs, new Tripinfo());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return tripinfo;
	}

	public List<Tripinfo> selectTripinfoPage(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectTripinfoPage);
		List<Tripinfo> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Tripinfo>(), new Tripinfo());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int selectTripinfoCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectTripinfoCount);
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

	public List<Tripinfo> selectTripInfoWheresList(Connection conn, String[] scheduleNoList) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectTripInfoWheresList);
		List<Tripinfo> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ArrayDescriptor desc = ArrayDescriptor.createDescriptor("VARCHAR2", conn);
			Array array = new ARRAY(desc, conn, scheduleNoList);
			pstmt.setArray(1, array);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Tripinfo>(), new Tripinfo());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
