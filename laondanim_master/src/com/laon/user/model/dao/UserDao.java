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

import com.laon.etc.model.vo.Picture;
import com.laon.user.model.vo.User;
import com.laon.user.model.vo.UserProfile;

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
	
	//-----------------------------------------------------------------------------------> 
	public User login(Connection conn,String id,String pw) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User u=null;
		String sql=prop.getProperty("login");
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
        rs = pstmt.executeQuery();
        u = rsProcess(rs, new User());		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}return u;
		
		
	}
	
	public User findId(Connection conn,String name,String email) {
		//�̸�,�̸����� ��ġ�ϴ� ȸ���� �ִ��� Ȯ�� ��. ���Ϻ�����
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
		//�̸�,�̸����� ��ġ�ϴ� ȸ���� �ִ��� Ȯ�� ��. ���Ϻ�����
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
		//�ӽú�й�ȣ�� ��� �����ϴ� ����
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
	
	public int searchReport(Connection conn, int userNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		String sql=prop.getProperty("searchReport");
		System.out.println("������ sql="+sql);
	try{pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, userNo);
		rs=pstmt.executeQuery();
		rs.next();
		result=rs.getInt(1);
		System.out.println(result);
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}return result;}
public int selectUserNo(Connection conn, String userId, String password, String email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectUserNo");
		int userNo = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			pstmt.setString(3, email);

			rs = pstmt.executeQuery();			
			rs.next();
			userNo = rs.getInt("NO");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return userNo;
	}
	
public int insertPicture(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertUserPicture");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
						
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);	
		}
		return result;
	}
}
