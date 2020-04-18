package com.laon.admin.model.dao;

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


import com.laon.admin.model.vo.Reports;
import com.laon.tripinfo.model.vo.Picture;
import com.laon.tripinfo.model.vo.Tripinfo;

public class AdminDao {
	
	private Properties prop=new Properties();
	
	public AdminDao() {
		try {
			String path=AdminDao.class.getResource("/sql/admin/admin-query.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public List<Reports> selectReport(Connection conn,int cPage,int perPage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Reports> list=new ArrayList();
		String sql=prop.getProperty("selectReport");
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, (cPage-1)*perPage+1);
		pstmt.setInt(2,cPage*perPage);
		rs=pstmt.executeQuery();
		while(rs.next()) {
		Reports re=new Reports();
		re.setNo(rs.getInt("no"));
		re.setUserNo(rs.getInt("user_no"));
		re.setDonghangNo(rs.getInt("donghang_no"));
		re.setBoardNo(rs.getInt("board_no"));
		re.setReportContent(rs.getString("report_content"));
		re.setStatus(rs.getString("status"));
		list.add(re);
			}
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
		
		return list;
	}

	public int closeAccount(Connection conn, int userNo) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("closeAccount");
	try{
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, userNo);
		result=pstmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}return result;
		
	}

	public int countReport(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		String sql=prop.getProperty("countReport");
	try{pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		rs.next();
		count=rs.getInt(1);
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}return count;
	
	
	
	}

	public int insertTripInfo(Tripinfo ti, Connection conn) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertTripInfo");
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, ti.getCategory());
		pstmt.setString(2, ti.getTag());
		pstmt.setString(3, ti.getName());
		pstmt.setString(4, ti.getAddress());
		pstmt.setString(5, ti.getBusinessHours());
		pstmt.setString(6, ti.getTel());
		pstmt.setString(7, ti.getHomepage());
		pstmt.setString(8, ti.getNaver());
		pstmt.setString(9, ti.getSns());
		result=pstmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}return result;
		
	
	}

	public int searchTripInfoNo(Connection conn, String name, String tel) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int no=0;
		String sql=prop.getProperty("searchTripInfo");
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, tel);
		rs=pstmt.executeQuery();
		if(rs.next());
		no=rs.getInt(1);
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}
		return no;
	}

	public int insertPicture(Picture p, Connection conn) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertPicture");
		System.out.println("dao출력:"+p.getTripinfoNo());
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, p.getTripinfoNo());
		System.out.println(p.getTripinfoNo());
		pstmt.setString(2, p.getImage());
		result=pstmt.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}return result;
		
	}
	
	
	
	
	
	
	
}
