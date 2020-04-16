package com.laon.admin.model.service;

import java.sql.Connection;
import java.util.List;

import com.laon.admin.model.dao.AdminDao;
import com.laon.admin.model.vo.Reports;
import com.laon.board.model.dao.BoardDao;
import static com.laon.common.JDBCTemplate.getConnection;
import static com.laon.common.JDBCTemplate.close;
import static com.laon.common.JDBCTemplate.commit;
import static com.laon.common.JDBCTemplate.rollback;


public class AdminService {

	public AdminDao dao=new AdminDao();

	public List<Reports> selectReport(int cPage,int perPage) {
		Connection conn=getConnection();
		List<Reports> list=dao.selectReport(conn,cPage,perPage);
		close(conn);
		return list;
	}

	public int closeAccount(int userNo) {
		Connection conn=getConnection();
		int result=dao.closeAccount(conn,userNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int countReport() {
		Connection conn=getConnection();
		int result=dao.countReport(conn);
		close(conn);
		return result;
	}
}
