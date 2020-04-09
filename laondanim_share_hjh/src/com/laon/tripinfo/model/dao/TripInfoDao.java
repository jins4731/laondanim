package com.laon.tripinfo.model.dao;

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
import com.laon.tripinfo.model.vo.TripInfo;
import com.laon.tripinfo.model.vo.TripInfoComment;

public class TripInfoDao {
	
	private Properties prop=new Properties();
	
	public TripInfoDao() {
		try {
			String path=TripInfoDao.class.getResource("/sql/tripinfo/tripinfo-query.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<TripInfo> selectTripinfoList(Connection conn,int cPage,int numPerPage,String category,String key,String type) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<TripInfo> list=new ArrayList<TripInfo>();
		if(key==null||type==null) {
			String sql=prop.getProperty("selectTripinfoList");
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, category);
				pstmt.setInt(2, (cPage-1)*numPerPage+1);
				pstmt.setInt(3, cPage*numPerPage);
				rs=pstmt.executeQuery();	
				while(rs.next()) {
					TripInfo ti= new TripInfo();
					ti.setTripinfoNo(rs.getInt("no"));
					ti.setTripinfoCategory(rs.getString("category"));
					ti.setTripinfoTag(rs.getString("tag"));
					ti.setTripinfoName(rs.getString("name"));
					ti.setTripinfoAddress(rs.getString("address"));
					ti.setTripinfotime(rs.getString("BUSINESS_HOURS"));
					ti.setTripinfoNumber(rs.getString("tel"));
					ti.setTripinfoHomePage(rs.getString("HOMEPAGE"));
					ti.setTripinfoNaver(rs.getString("naver"));
					ti.setTripinfoSns(rs.getString("sns"));
					list.add(ti);	
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return list;
		
		}else {
			String sql="";
			switch(key) {
			case "name" : sql = prop.getProperty("selectNameTripinfo");break;
			case "address" : sql = prop.getProperty("selectAddressTripinfo");break;
			case "tag" : sql = prop.getProperty("selectTagTripinfo");break;
			}		
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, "%"+type+"%");
				pstmt.setString(2, category);
				pstmt.setInt(3, (cPage-1)*numPerPage+1);
				pstmt.setInt(4, cPage*numPerPage);
				rs=pstmt.executeQuery();	
				while(rs.next()) {
					TripInfo ti= new TripInfo();
					ti.setTripinfoNo(rs.getInt("no"));
					ti.setTripinfoCategory(rs.getString("category"));
					ti.setTripinfoTag(rs.getString("tag"));
					ti.setTripinfoName(rs.getString("name"));
					ti.setTripinfoAddress(rs.getString("address"));
					ti.setTripinfotime(rs.getString("BUSINESS_HOURS"));
					ti.setTripinfoNumber(rs.getString("tel"));
					ti.setTripinfoHomePage(rs.getString("HOMEPAGE"));
					ti.setTripinfoNaver(rs.getString("naver"));
					ti.setTripinfoSns(rs.getString("sns"));
					list.add(ti);	
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return list;
		}
	}
	
	public int selectCountTripInfo(Connection conn,String category , String key,String type) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		if(type==null||key==null) {
			String sql=prop.getProperty("selectCountTripInfo");
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, category);
				rs=pstmt.executeQuery();
				rs.next();
				count=rs.getInt(1);
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return count;
		}else {
			
			String sql="";
			switch(key) {
			case "name" : sql = prop.getProperty("selectNameCountTripInfo");break;
			case "address" : sql = prop.getProperty("selectAddressCountTripInfo");break;
			case "tag" : sql = prop.getProperty("selectTagCountTripInfo");break;
			}
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, category);
				pstmt.setString(2, "%"+type+"%");
				rs=pstmt.executeQuery();
				rs.next();
				count=rs.getInt(1);
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return count;
		}//IF문
		
}//메소드
	
}//클래스
