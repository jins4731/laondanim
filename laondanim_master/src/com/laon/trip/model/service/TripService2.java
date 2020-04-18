package com.laon.trip.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.commit;
import static com.laon.common.template.JDBCTemplate.getConnection;
import static com.laon.common.template.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.laon.etc.model.vo.Like;
import com.laon.etc.model.vo.Picture;
import com.laon.trip.model.dao.TripDao;
import com.laon.trip.model.vo.TagCount;
import com.laon.trip.model.vo.Trip2;
import com.laon.trip.model.vo.TripSchedule;
import com.laon.user.model.vo.User;

public class TripService2 {

	private TripDao dao = new TripDao();
	
	//list 가져오기	
	public ArrayList<Trip2> selectTripPage(int cPage, int perPage, String lo, String category, String keyword, String recent, String like, ArrayList<TagCount> tripTagCountList, String first){ //Ű���� �˻� �±�
		Connection conn = getConnection();
		ArrayList<Trip2> list = dao.selectTripPage(conn, cPage, perPage, lo, category, keyword, recent, like, tripTagCountList, first);
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
	public ArrayList<Picture> selectPicture(ArrayList<Trip2> list){
		Connection conn = getConnection();
		ArrayList<Picture> pictureList = dao.selectPicture(conn, list);
		close(conn);
		return pictureList;
	}
	
	//좋아요 개수 리스트 가져오기
	public ArrayList<Like> selectLikeCount(ArrayList<Trip2> list){
		Connection conn = getConnection();
		ArrayList<Like> likeCountList = dao.selectLikeCount(conn, list);
		close(conn);
		return likeCountList;
	}
	
	//좋아요 모든 정보 리스트 가져오기
	public ArrayList<Like> selectLike(int loginNo){
		Connection conn = getConnection();
		ArrayList<Like> likeList = dao.selectLike(conn, loginNo);
		close(conn);
		return likeList;
	}
	
	//회원 리스트 가져오기
	public ArrayList<User> selectUser(ArrayList<Trip2> list){
		Connection conn = getConnection();
		ArrayList<User> userList = dao.selectUser(conn, list);
		close(conn);
		return userList;
	}
	
	//좋아요 버튼 업데이터
	public int updateLike(int tripNo, int userNo) {
		Connection conn = getConnection();
		String cancled="";
		int insertResult = 0;
		int result = 0;
		
		cancled = dao.selectLikeCancled(conn, tripNo, userNo);
		
		if(cancled.equals("")) {
			result = dao.insertLike(conn, tripNo, userNo);
			if(result>0) commit(conn);
			else rollback(conn);
		}
		if(!cancled.equals("")){
			result = dao.updateLike(conn, tripNo, userNo, cancled);
		}
		
		if(result>0)commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public ArrayList<Trip2> selectTagList(){
		Connection conn = getConnection();
		ArrayList<Trip2> tagList =dao.selectTagList(conn);
		close(conn);
		return tagList;
	}
	
	public ArrayList<TripSchedule> selectSchedule(int no){
		Connection conn = getConnection();
		ArrayList<TripSchedule> scheduleList = dao.selectSchedule(conn, no);
		close(conn);
		return scheduleList;
	}
	
	public ArrayList<Trip2> selectTripList(ArrayList<TripSchedule> scheduleList){
		Connection conn = getConnection();
		ArrayList<Trip2> tripList = dao.selectTripList(conn, scheduleList);
		close(conn);
		return tripList;
	}
}
