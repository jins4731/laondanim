package com.laon.trip.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.laon.trip.model.dao.TripDao;
import com.laon.trip.model.vo.Trip;

import static com.laon.common.JDBCTemplate.*;

public class TripService {

	private TripDao dao = new TripDao();
	
	public ArrayList<Trip> searchList(int cPage, int perPage){ //전체 검색
		Connection conn = getConnection();
		ArrayList<Trip> list = dao.searchList(conn, cPage, perPage);
		close(conn);
		return list;
	}
	
	//overloading
	public ArrayList<Trip> searchList(int cPage, int perPage, String keyword){ //키워드 검색 태그
		Connection conn = getConnection();
		ArrayList<Trip> list = dao.searchList(conn, cPage, perPage, keyword);
		close(conn);
		return list;
	}
	
	public ArrayList<Trip> searchListPr(int cPage, int perPage, String type){ //키워드 검색 태그
		Connection conn = getConnection();
		ArrayList<Trip> list = dao.searchListPr(conn, cPage, perPage, type);
		close(conn);
		return list;
	}
	
	public int getTotalData() {
		Connection conn= getConnection();
		int count = dao.getTotalData(conn);
		close(conn);
		return count;
	}
	
	public int getTotalData(String keyword) {
		Connection conn= getConnection();
		int count = dao.getTotalData(conn,keyword);
		close(conn);
		return count;
	}
	
	public int getTotalDataPr(String type) {
		Connection conn = getConnection();
		int count = dao.getTotalDataPr(conn,type);
		close(conn);
		return count;
	}
}
