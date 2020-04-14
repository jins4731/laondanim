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

	public List<Reports> selectReport() {
		Connection conn=getConnection();
		List<Reports> list=dao.selectReport(conn);
		close(conn);
		return list;
	}
}
