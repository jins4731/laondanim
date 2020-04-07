package com.laon.user.model.dao;

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

import com.laon.common.PropPath;
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
			prop.load(new FileReader(UserDao.class.getResource(PropPath.USER).getPath()));
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
			list.add(user);
		}
		return list;
	}

	public User selectUser(Connection conn, String no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectUser);
		User user = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(no));
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

	public List<User> selectUserPage(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectUserPage);
		List<User> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			list = rsProcess(rs, new ArrayList<User>());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int selectUserCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectUserCount);
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
}
