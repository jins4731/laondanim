package com.laon.user.model.dao;

import static com.laon.common.template.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.laon.user.model.vo.User;

public class UserDao {
	private Properties prop = new Properties();

	private String no = "no";
	private String createdDate = "created_date";
	private String userId = "user_id";
	private String password = "password";
	private String name = "name";
	private String nickName = "nick_name";
	private String birthday = "birthday";
	private String gender = "gender";
	private String phone = "phone";
	private String email = "email";

	private String selectUser = "selectUser";
	private String selectUserPage = "selectUserPage";
	private String selectUserCount = "selectUserCount";

	public UserDao() {
		try {
			prop.load(new FileReader(UserDao.class.getResource("/sql/user/user-query.properties").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public User login(Connection conn,String id,String pw) {
		//로그인 했을때
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
	
	public boolean userIdDuplicate(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		
		String sql = prop.getProperty("userIdDuplicate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return flag;
	}

	public boolean userNickNameDuplicate(Connection conn, String userNickName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		
		String sql = prop.getProperty("userNickNameDuplicate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userNickName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return flag;
	}

	public int userInsert(Connection conn, User u) {
		PreparedStatement pstmt=null;
		int result = 0;
		String sql=prop.getProperty("userInsert");

		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getName());
			pstmt.setString(4, u.getNickName());
			pstmt.setDate(5, u.getBirthday());
			pstmt.setString(6, u.getGender());
			pstmt.setString(7, u.getPhone());
			pstmt.setString(8, u.getEmail());
			pstmt.setString(9, u.getTag());			
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


}
