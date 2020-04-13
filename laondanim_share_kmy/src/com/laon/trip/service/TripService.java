package com.laon.trip.service;

import static com.laon.common.JDBCTemplate.close;
import static com.laon.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.laon.etc.model.vo.Like;
import com.laon.etc.model.vo.Picture;
import com.laon.trip.model.dao.TripDao;
import com.laon.trip.model.vo.Trip;

public class TripService {

	private TripDao dao = new TripDao();
	
	//list 가져오기	
	public ArrayList<Trip> selectTripPage(int cPage, int perPage, String lo, String category, String keyword, String recent, String like){ //키워드 검색 태그
		Connection conn = getConnection();
		ArrayList<Trip> list = dao.selectTripPage(conn, cPage, perPage, lo, category, keyword, recent, like);
		close(conn);
		return list;
	}
	
	//총 데이터 숫자 가져오기
	public int selectTripCount(String lo, String category, String keyword) {
		Connection conn = getConnection();
		int count = dao.selectTripCount(conn, lo, category, keyword);
		close(conn);
		return count;
	}
	
	//데이터 리스트 tag 이름 가져오기
	public String[] getTagList(String search){
		Connection conn = getConnection();
		String arrTag[] = dao.getTagList(conn, search);
		close(conn);
		return arrTag;
	}
	
	//사진 리스트 가져오기
	public ArrayList<Picture> selectPicture(ArrayList<Trip> list){
		Connection conn = getConnection();
		ArrayList<Picture> pictureList = dao.selectPicture(conn, list);
		return pictureList;
	}
	
	//좋아요 리스트 가져오기
	public ArrayList<Like> selectLike(ArrayList<Trip> list){
		Connection conn = getConnection();
		ArrayList<Like> likeList = dao.selectLike(conn, list);
		return likeList;
	}
	
}
