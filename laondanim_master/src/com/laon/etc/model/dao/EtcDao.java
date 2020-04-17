package com.laon.etc.model.dao;

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

import com.laon.common.PropPath;
import com.laon.common.robot.LaonRobot;
import com.laon.donghang.model.vo.Donghang;
import com.laon.etc.model.vo.Like;
import com.laon.etc.model.vo.Mind;
import com.laon.etc.model.vo.Picture;
import com.laon.trip.model.vo.Trip;
import com.laon.tripinfo.model.vo.Tripinfo;
import com.laon.user.model.vo.User;

public class EtcDao {
	private Properties prop = new Properties();

	
	
	private String selectLikeList = "selectLikeList";
	
	
	
	private String selectPictureUserNo = "selectPictureUserNo";
	private String selectPictureTripNo = "selectPictureTripNo";
	private String selectPictureTripinfoNo = "selectPictureTripinfoNo";
	private String selectPictureDonghangNo = "selectPictureTripDonghangNo";
	private String selectMindListUserNo = "selectMindListUserNo";
	
	
	
	

	public EtcDao() {
		try {
			prop.load(new FileReader(EtcDao.class.getResource(PropPath.ETC).getPath()));
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


	public List<Like> selectLikeList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectLikeList);
		List<Like> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Like>(), new Like());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
	public List<Picture> selectPictureListUserNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectPictureUserNo);
		List<Picture> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Picture>(),new Picture());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}


	public List<Picture> selectPictureListTripNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectPictureTripNo);
		List<Picture> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Picture>(),new Picture());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	public List<Picture> selectPictureListTripinfoNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectPictureTripinfoNo);
		List<Picture> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Picture>(),new Picture());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	public List<Picture> selectPictureListDonghangNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectPictureDonghangNo);
		List<Picture> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Picture>(),new Picture());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
	public List<Picture> selectPictureWhereNoIn(Connection conn, List<Integer> noList ,String coulmnName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PICTURE_TB WHERE " +coulmnName + " IN (";
		for (Integer integer : noList) {
			sql += "'" + integer + "',";
		}
		sql = sql.substring(0, sql.length()-1);
		sql += ")";
		System.out.println(sql);
		List<Picture> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Picture>(),new Picture());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}


	public List<Mind> selectMindListUserNo(Connection conn, String userNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectMindListUserNo);
		List<Mind> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(userNo));
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Mind>(),new Mind());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	

	
}
