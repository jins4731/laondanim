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
	//디비 정보 아직 지정전임..
	public UserDao() {
		try {
			String path=UserDao.class.getResource("/sql/user/user-query.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public User login(Connection conn,String id,String pw) {
		//로그인 했을때
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
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
	
	public User findId(Connection conn,String name,String email) {
		//이름,이메일이 일치하는 회원이 있는지 확인 후. 메일보내줘
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
		//이름,이메일이 일치하는 회원이 있는지 확인 후. 메일보내줘
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
		//임시비밀번호로 디비에 변경하는 로직
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
