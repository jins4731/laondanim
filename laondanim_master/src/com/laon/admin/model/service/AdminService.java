package com.laon.admin.model.service;

import java.sql.Connection;
import java.util.List;

import com.laon.admin.model.dao.AdminDao;
import com.laon.admin.model.vo.Reports;
import com.laon.board.model.dao.BoardDao;
import com.laon.tripinfo.model.vo.Picture;
import com.laon.tripinfo.model.vo.Tripinfo;

import static com.laon.common.template.JDBCTemplate.getConnection;
import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.commit;
import static com.laon.common.template.JDBCTemplate.rollback;



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

	public int insertTripInfo(Tripinfo ti) {
		Connection conn=getConnection();
		int result=dao.insertTripInfo(ti,conn);
		if(result>0) {
			
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int searchTripInfoNo(String name, String tel) {
		Connection conn=getConnection();
		int no=dao.searchTripInfoNo(conn,name,tel);
		close(conn);
		return no;
		
		
	}

	public int insertPicture(Picture p) {
		Connection conn=getConnection();
		int result=dao.insertPicture(p,conn);
		if(result>0) {
			
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
