package com.laon.common.template;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.laon.common.CommonKey;
import com.laon.common.PropPath;


public class JDBCTemplate {
	//Connection 객체 생성해서 반환하는 기능
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Properties prop=new Properties();
			prop.load(new FileReader(JDBCTemplate.class.getResource(PropPath.DRIVER).getPath()));
			Class.forName(prop.getProperty(CommonKey.DRIVER));
			conn=DriverManager.getConnection(prop.getProperty(CommonKey.URL),
					prop.getProperty(CommonKey.USER),prop.getProperty(CommonKey.PASSWORD));
			conn.setAutoCommit(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// sql연결객체를 닫아주는 기능
	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs!=null && !rs.isClosed()) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt!=null && !stmt.isClosed()) {
				stmt.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.commit();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.rollback();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
