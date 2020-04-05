package com.laon.tripinfo.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.laon.tripinfo.model.dao.TripinfoDao;
import com.laon.tripinfo.model.vo.Tripinfo;

public class TripinfoService {
	private TripinfoDao dao = new TripinfoDao();

	public Tripinfo selectTripinfo(String no) {
		Connection conn = getConnection();
		Tripinfo tripinfo = dao.selectTripinfo(conn, no);
		close(conn);
		return tripinfo;
	}

	public List<Tripinfo> selectTripinfoPage(int start, int end) {
		Connection conn = getConnection();
		List<Tripinfo> list = dao.selectTripinfoPage(conn, start, end);
		close(conn);
		return list;
	}

	public int selectTripinfoCount() {
		Connection conn = getConnection();
		int result = dao.selectTripinfoCount(conn);
		close(conn);
		return result;
	}
}
