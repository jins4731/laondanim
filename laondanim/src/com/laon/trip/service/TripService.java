package com.laon.trip.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.laon.trip.model.dao.TripDao;
import com.laon.trip.model.vo.Trip;

import static com.laon.common.JDBCTemplate.*;

public class TripService {

	private TripDao dao = new TripDao();
	
	//selectList
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
	
	public ArrayList<Trip> searchList(int cPage, int perPage, String lo, String category, String keyword, String recent){ //키워드 검색 태그
		Connection conn = getConnection();
		ArrayList<Trip> list = dao.searchList(conn, cPage, perPage, lo, category, keyword, recent);
		close(conn);
		return list;
	}
	
	public ArrayList<Trip> searchListPr(int cPage, int perPage, String type, String keyword){ //키워드 검색 태그
		Connection conn = getConnection();
		ArrayList<Trip> list = dao.searchListPr(conn, cPage, perPage, type, keyword);
		close(conn);
		return list;
	}
	
//	public ArrayList<Trip> searchListRe(String keyword, String category){
//		Connection conn = getConnection();
//		ArrayList<Trip> list = dao.searchListRe(conn, keyword, category);
//		close(conn);
//		return list;
//	}
	
	
	//get totalData
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
	
	public int getTotalDataPr(String type, String keyword) {
		Connection conn = getConnection();
		int count = dao.getTotalDataPr(conn,type, keyword);
		close(conn);
		return count;
	}
	
	public int getTotalDataLo(String lo, String category, String keyword) {
		Connection conn = getConnection();
		int count = dao.getTotalData(conn, lo, category, keyword);
		close(conn);
		return count;
	}
}
