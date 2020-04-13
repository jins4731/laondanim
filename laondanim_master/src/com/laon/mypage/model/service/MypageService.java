package com.laon.mypage.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.laon.board.model.vo.Board;
import com.laon.donghang.model.vo.Donghang;
import com.laon.donghang.model.vo.MyDong;
import com.laon.mypage.model.dao.MypageDao;
import com.laon.trip.model.vo.TripMyCon;
import com.laon.user.model.vo.UserProfile;

public class MypageService {
	private MypageDao dao=new MypageDao();
	
	public UserProfile selectUserNo(int no) {
		Connection conn=getConnection();
		UserProfile up=dao.selectUserNo(conn,no);
		close(conn);
		
		return up;
	}
	
	public List<TripMyCon> selectMyTrip(int userNo){
		Connection conn=getConnection();
		List<TripMyCon> list=dao.selectMyTrip(conn,userNo);
		close(conn);
		
		return list;
	}
	
	public List<TripMyCon> selectMyTripAll(int userNo,int start,int end){
		Connection conn=getConnection();
		List<TripMyCon> list=dao.selectMyTripAll(conn,userNo,start,end);
		close(conn);
		
		return list;
	}
	
	public List selectTripLike(int userNo) {
		Connection conn=getConnection();
		List like=dao.selectTripLike(conn,userNo);
		close(conn);
		
		return like;
	}
	
	public int selectMyTripCount(int userNo) {
		Connection conn = getConnection();
		int result = dao.selectMyTripCount(conn,userNo);
		close(conn);
		return result;
	}
	
	public List<Board> selectMyBoard(int start,int end){
		Connection conn=getConnection();
		List<Board> list=dao.selectMyBoard(conn,start,end);
		close(conn);
		
		return list;
	}
	
	public int selectMyBoardCount() {
		Connection conn = getConnection();
		int result = dao.selectMyBoardCount(conn);
		close(conn);
		
		return result;
	}
	
	public List<MyDong> selectMyDong(int userNo){
		Connection conn=getConnection();
		List<MyDong> list=dao.selectMyDong(conn,userNo);
		close(conn);
		
		return list;
	}
	
	public List<MyDong> selectMyDHAll(int userNo,int start,int end){
		Connection conn=getConnection();
		List<MyDong> list=dao.selectMyDHAll(conn,userNo,start,end);
		close(conn);
		
		return list;
	}
	
	public int selectMyDongCount(int userNo) {
		Connection conn = getConnection();
		int result = dao.selectMyDongCount(conn,userNo);
		close(conn);
		
		return result;
	}
	
	public List selectJoinDong(){
		Connection conn=getConnection();
		List list=dao.selectJoinDong(conn);
		close(conn);
		
		return list;
	}
	
}