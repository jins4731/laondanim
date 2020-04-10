package com.laon.donghang.model.dao;

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

	public List<Donghang> selectDonghangPage(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectDonghangPage);
		List<Donghang> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<Donghang>(),new Donghang());
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
}
