package com.laon.user.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import static com.laon.common.JDBCTemplate.close;

import com.laon.user.model.vo.User;

public class UserDao {

private Properties prop=new Properties();
	//�뵒鍮� �젙蹂� �븘吏� 吏��젙�쟾�엫..
	public UserDao() {
		try {
			String path=UserDao.class.getResource("/sql/user/user-query.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public User login(Connection conn,String id,String pw) {
		//濡쒓렇�씤 �뻽�쓣�븣
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User u=null;
		String sql=prop.getProperty("login");
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		rs=pstmt.executeQuery();
		if(rs.next()){
			u=new User();
			u.setNo(rs.getInt("no"));
			u.setCreatedDate(rs.getDate("created_date"));
			u.setUserId(rs.getString("user_id"));
			u.setName(rs.getString("name"));
			u.setNickName(rs.getString("nick_name"));
			u.setEmail(rs.getString("email"));
			u.setBirthday(rs.getDate("birthday"));
			u.setGender(rs.getString("gender"));
			u.setPhone(rs.getString("phone"));
			u.setEmail(rs.getString("email"));
			u.setTag(rs.getString("tag"));
			
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}return u;
		
		
	}
	
	public User findId(Connection conn,String name,String email) {
		//�씠由�,�씠硫붿씪�씠 �씪移섑븯�뒗 �쉶�썝�씠 �엳�뒗吏� �솗�씤 �썑. 硫붿씪蹂대궡以�
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User u=null;
		String sql=prop.getProperty("findId");
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		rs=pstmt.executeQuery();
		if(rs.next()){
			u=new User();
			u.setUserId(rs.getString("user_id"));
			u.setName(rs.getString("name"));
			u.setEmail(rs.getString("email"));
			
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}return u;
		
		
	}
	public User findPw(Connection conn,String id,String email) {
		//�씠由�,�씠硫붿씪�씠 �씪移섑븯�뒗 �쉶�썝�씠 �엳�뒗吏� �솗�씤 �썑. 硫붿씪蹂대궡以�
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User u=null;
		String sql=prop.getProperty("findPw");
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, email);
		rs=pstmt.executeQuery();
		if(rs.next()){
			u=new User();
			u.setUserId(rs.getString("user_id"));
			u.setEmail(rs.getString("email"));
			
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}return u;
		
	}



	public int updateTemPw(Connection conn,String id, String authenticationKey) {
		//�엫�떆鍮꾨�踰덊샇濡� �뵒鍮꾩뿉 蹂�寃쏀븯�뒗 濡쒖쭅
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateTemPw");
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, authenticationKey);
			pstmt.setString(2, id);
			result=pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				
				close(pstmt);

		}
		return result;

	
	}	
	
	
	
	
}

