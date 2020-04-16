package com.laon.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.laon.common.JDBCTemplate.close;

import com.laon.admin.model.vo.ReportsJoinUser;

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

	public List<ReportsJoinUser> selectReport(Connection conn,int cPage,int perPage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ReportsJoinUser> list=new ArrayList();
		String sql=prop.getProperty("selectReport");
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, (cPage-1)*perPage+1);
		pstmt.setInt(2,cPage*perPage);
		rs=pstmt.executeQuery();
		while(rs.next()) {
		ReportsJoinUser re=new ReportsJoinUser();
		re.setNo(rs.getInt("no"));
		re.setUserNo(rs.getInt("user_no"));
		re.setDonghangNo(rs.getInt("donghang_no"));
		re.setBoardNo(rs.getInt("board_no"));
		re.setReportContent(rs.getString("report_content"));
		re.setStatus(rs.getString("status"));
		re.setUserId(rs.getString("user_id"));
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
	
	
	
	
	
	
	
}
