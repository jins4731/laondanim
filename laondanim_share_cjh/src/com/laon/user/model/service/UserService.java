package com.laon.user.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.laon.user.model.dao.UserDao;
import com.laon.user.model.vo.User;

public class UserService {
private UserDao dao = new UserDao();
	
	public User selectUser(String no) {
		Connection conn = getConnection();
		User user = dao.selectUser(conn, no);
		close(conn);
		return user;
	}
	
	public List<User> selectUserPage(int start,int end){
		Connection conn = getConnection();
		List<User> list = dao.selectUserPage(conn, start ,end);
		close(conn);
		return list;
	}

	public int selectUserCount() {
		Connection conn = getConnection();
		int result = dao.selectUserCount(conn);
		close(conn);
		return result;
	}
}
