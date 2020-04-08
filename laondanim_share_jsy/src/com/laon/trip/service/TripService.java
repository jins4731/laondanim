package com.laon.trip.service;

import static com.laon.common.JDBCTemplate.close;
import static com.laon.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.laon.trip.model.dao.TripDao;
import com.laon.trip.model.vo.Trip;
import com.laon.trip.model.vo.TripPicture;

public class TripService {

	private TripDao dao = new TripDao();
	
	public ArrayList<Trip> searchList(int cPage, int perPage, String lo, String category, String keyword, String recent, String like){ //키워드 검색 태그
		Connection conn = getConnection();
		ArrayList<Trip> list = dao.searchList(conn, cPage, perPage, lo, category, keyword, recent, like);
		close(conn);
		return list;
	}
			
	public int getTotalData(String lo, String category, String keyword) {
		Connection conn = getConnection();
		int count = dao.getTotalData(conn, lo, category, keyword);
		close(conn);
		return count;
	}
	
	
}
