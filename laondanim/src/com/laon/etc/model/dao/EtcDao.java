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
import com.laon.etc.model.vo.Like;

public class EtcDao {
	private Properties prop = new Properties();

	// Like
	private String no = "no";
	private String userNo = "user_no";
	private String tripNo = "category";
	private String cancled = "write_date";
	
	private String selectLikeList = "selectLikeList";
	

	public EtcDao() {
		try {
			prop.load(new FileReader(EtcDao.class.getResource(PropPath.ETC).getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Like rsProcess(ResultSet rs, Like like) throws SQLException {
		while (rs.next()) {
			like.setNo(rs.getInt(no));
			like.setUserNo(rs.getInt(userNo));
			like.setTripNo(rs.getInt(tripNo));
			like.setCancled(rs.getString(cancled));
		}
		return like;
	}

	public List<Like> rsProcess(ResultSet rs, List<Like> list) throws SQLException {
		while (rs.next()) {
			Like like = new Like();
			like.setNo(rs.getInt(no));
			like.setUserNo(rs.getInt(userNo));
			like.setTripNo(rs.getInt(tripNo));
			like.setCancled(rs.getString(cancled));
			list.add(like);
		}
		return list;
	}


	public List<Like> selectLikeList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectLikeList);
		List<Like> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Like>());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	
}
