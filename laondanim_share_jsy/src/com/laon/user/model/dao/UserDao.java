package com.laon.user.model.dao;

import static com.laon.common.template.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
	private String tag = "tag";
	
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

	public User rsProcess(ResultSet rs, User user) throws SQLException {
		while (rs.next()) {
			user.setNo(rs.getInt(no));
			user.setCreatedDate(rs.getDate(createdDate));
			user.setUserId(rs.getString(userId));
			user.setPassword(rs.getString(password));
			user.setName(rs.getString(name));
			user.setNickName(rs.getString(nickName));
			user.setBirthday(rs.getDate(birthday));
			user.setGender(rs.getString(gender));
			user.setPhone(rs.getString(phone));
			user.setEmail(rs.getString(email));
			user.setTag(rs.getString(tag));
		}
		return user;
	}

	public List<User> rsProcess(ResultSet rs, List<User> list) throws SQLException {
		while (rs.next()) {
			User user = new User();
			user.setNo(rs.getInt(no));
			user.setCreatedDate(rs.getDate(createdDate));
			user.setUserId(rs.getString(userId));
			user.setPassword(rs.getString(password));
			user.setName(rs.getString(name));
			user.setNickName(rs.getString(nickName));
			user.setBirthday(rs.getDate(birthday));
			user.setGender(rs.getString(gender));
			user.setPhone(rs.getString(phone));
			user.setEmail(rs.getString(email));
			user.setTag(rs.getString(tag));
			list.add(user);
		}
		return list;
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
			u.setUserId(rs.getString("user_id"));
			u.setName(rs.getString("name"));
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


	public User selectUser(Connection conn, int no) {
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = prop.getProperty(selectUser);
	      User user = null;
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, no);
	         rs = pstmt.executeQuery();
	         user = rsProcess(rs, new User());
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         close(rs);
	         close(pstmt);
	      }
	      return user;
	   }	
}