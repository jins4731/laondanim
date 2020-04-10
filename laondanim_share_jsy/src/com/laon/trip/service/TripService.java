package com.laon.trip.service;

import static com.laon.common.JDBCTemplate.close;
import static com.laon.common.JDBCTemplate.getConnection;
import static com.laon.common.JDBCTemplate.commit;
import static com.laon.common.JDBCTemplate.rollback;


import java.sql.Connection;
import java.util.ArrayList;

import com.laon.etc.model.vo.Like;
import com.laon.etc.model.vo.Picture;
import com.laon.trip.model.dao.TripDao;
import com.laon.trip.model.vo.Trip;
import com.laon.user.model.vo.User;

public class TripService {

	private TripDao dao = new TripDao();
	
	//list ��������	
	public ArrayList<Trip> selectTripPage(int cPage, int perPage, String lo, String category, String keyword, String recent, String like){ //Ű���� �˻� �±�
		Connection conn = getConnection();
		ArrayList<Trip> list = dao.selectTripPage(conn, cPage, perPage, lo, category, keyword, recent, like);
		close(conn);
		return list;
	}
	
	//�� ������ ���� ��������
	public int selectTripCount(String lo, String category, String keyword) {
		Connection conn = getConnection();
		int count = dao.selectTripCount(conn, lo, category, keyword);
		close(conn);
		return count;
	}
	
	//������ ����Ʈ tag �̸� ��������
	public String[] getTagList(String search){
		Connection conn = getConnection();
		String arrTag[] = dao.getTagList(conn, search);
		close(conn);
		return arrTag;
	}
	
	//���� ����Ʈ ��������
	public ArrayList<Picture> selectPicture(ArrayList<Trip> list){
		Connection conn = getConnection();
		ArrayList<Picture> pictureList = dao.selectPicture(conn, list);
		return pictureList;
	}
	
	//���ƿ� ���� ����Ʈ ��������
	public ArrayList<Like> selectLikeCount(ArrayList<Trip> list){
		Connection conn = getConnection();
		ArrayList<Like> likeCountList = dao.selectLikeCount(conn, list);
		return likeCountList;
	}
	
	//���ƿ� ������� ����Ʈ ��������
	public ArrayList<Like> selectLike(int loginNo){
		Connection conn = getConnection();
		ArrayList<Like> likeList = dao.selectLike(conn, loginNo);
		return likeList;
	}
	
	//ȸ�� ����Ʈ ��������
	public ArrayList<User> selectUser(ArrayList<Trip> list){
		Connection conn = getConnection();
		ArrayList<User> userList = dao.selectUser(conn, list);
		return userList;
	}
	
	//���ƿ� ��ư ��������
	public int updateLike(int tripNo, int userNo) {
		Connection conn = getConnection();
		String cancled="";
		int insertResult = 0;
		int result = 0;
		
		cancled = dao.selectLikeCancled(conn, tripNo, userNo);
		
		if(cancled.equals("")) {
			insertResult = dao.insertLike(conn, tripNo, userNo);
		}
		else if(insertResult>0 || !cancled.equals("")){
			result = dao.updateLike(conn, tripNo, userNo, cancled);
		}
		
		if(result>0)commit(conn);
		else rollback(conn);
		
		return result;
	}
}
