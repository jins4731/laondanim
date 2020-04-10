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
import com.laon.etc.model.vo.Like;
import com.laon.etc.model.vo.Picture;

public class EtcDao {
	private Properties prop = new Properties();

	
	
	private String selectLikeList = "selectLikeList";
	
	
	
	private String selectPictureUserNo = "selectPictureUserNo";
	
	
	
	

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
	
	
	public Picture selectPictureUserNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectPictureUserNo);
		Picture pic = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			pic = rsProcess(rs, new Picture());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return pic;
	}

	
}
