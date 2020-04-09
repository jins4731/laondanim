package com.laon.trip.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.laon.trip.model.dao.TripDao;
import com.laon.trip.model.vo.Trip;
import com.laon.trip.model.vo.TripSchedule;

public class TripService {
private TripDao dao = new TripDao();
	
	public Trip selectTrip(String no) {
		Connection conn = getConnection();
		Trip trip = dao.selectTrip(conn, no);
		close(conn);
		return trip;
	}
	
	public List<Trip> selectTripPage(int start,int end){
		Connection conn = getConnection();
		List<Trip> list = dao.selectTripPage(conn, start ,end);
		close(conn);
		return list;
	}

	public int selectTripCount() {
		Connection conn = getConnection();
		int result = dao.selectTripCount(conn);
		close(conn);
		return result;
	}

	public List<TripSchedule> selectTripScheduleList(int no) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		List<TripSchedule> schedulelist = dao.selectTripScheduleList(conn,no);
		close(conn);
		return schedulelist;
	}
	
}
