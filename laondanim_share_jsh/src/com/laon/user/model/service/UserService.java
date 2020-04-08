package com.laon.user.model.service;

import static com.laon.common.JDBCTemplate.close;
import static com.laon.common.JDBCTemplate.getConnection;
import static com.laon.common.JDBCTemplate.commit;
import static com.laon.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.laon.user.model.dao.UserDao;
import com.laon.user.model.vo.User;

public class UserService {
	private UserDao dao = new UserDao();

	public boolean userIdDuplicate(String userId) {
		Connection conn = getConnection();
		boolean flag = dao.userIdDuplicate(conn, userId);
		close(conn);
		return flag;
	}

	public boolean userNickNameDuplicate(String userNickName) {
		Connection conn = getConnection();
		boolean flag = dao.userNickNameDuplicate(conn, userNickName);
		close(conn);
		return flag;
	}

	public int userInsert(User u) {
		Connection conn=getConnection();
		int result=dao.userInsert(conn, u);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}


}
