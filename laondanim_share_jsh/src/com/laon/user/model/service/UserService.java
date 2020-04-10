package com.laon.user.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.commit;
import static com.laon.common.template.JDBCTemplate.rollback;
import static com.laon.common.template.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.laon.user.model.dao.UserDao;
import com.laon.user.model.vo.User;

public class UserService {
	
	private UserDao dao = new UserDao();

	public User login(String id,String pw) {
		Connection conn=getConnection();
		User u=dao.login(conn,id,pw);
		close(conn);
		return u;

	}
	
	public User findId(String name,String email) {
		Connection conn=getConnection();
		User u=dao.findId(conn,name,email);
		close(conn);
		return u;
	}
	
	public User findPw(String id,String email) {
		Connection conn=getConnection();
		User u=dao.findPw(conn,id,email);
		close(conn);
		return u;
	}

	public int updateTemPw(String id,String authenticationKey) {
		// 임시비밀번호로 db에 저장하는 로직
		Connection conn=getConnection();
		int result=dao.updateTemPw(conn,id,authenticationKey);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
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
