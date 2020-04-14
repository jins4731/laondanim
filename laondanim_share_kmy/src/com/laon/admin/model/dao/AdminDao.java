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

import com.laon.admin.model.vo.Reports;

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

	public List<Reports> selectReport(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Reports> list=new ArrayList();
		String sql=prop.getProperty("selectReport");
	try{pstmt=conn.prepareStatement(sql);
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
	
	
	
	
	
	
	
}
