package com.laon.mypage.model.service;

import static com.laon.common.JDBCTemplate.close;
import static com.laon.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.laon.board.model.vo.Board;
import com.laon.donghang.model.vo.Donghang;
import com.laon.mypage.model.dao.MypageDao;
import com.laon.trip.model.vo.Trip;
import com.laon.user.model.vo.User;
import com.laon.user.model.vo.UserProfile;

public class MypageService {
	private MypageDao dao=new MypageDao();
	
	public UserProfile selectUserNo(int no) {
		Connection conn=getConnection();
		UserProfile up=dao.selectUserNo(conn,no);
		close(conn);
		
		return up;
	}
	
	public List<Trip> selectMyTrip(){
		Connection conn=getConnection();
		List<Trip> list=dao.selectMyTrip(conn);
		close(conn);
		
		return list;
	}
	
	public List<Trip> selectMyTripAll(int start,int end){
		Connection conn=getConnection();
		List<Trip> list=dao.selectMyTripAll(conn,start,end);
		close(conn);
		
		return list;
	}
	
	public int selectMyTripCount() {
		Connection conn = getConnection();
		int result = dao.selectMyTripCount(conn);
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
	
	public List<Donghang> selectMyDong(){
		Connection conn=getConnection();
		List<Donghang> list=dao.selectMyDong(conn);
		close(conn);
		
		return list;
	}
	
	public List<Donghang> selectMyDHAll(int start,int end){
		Connection conn=getConnection();
		List<Donghang> list=dao.selectMyDHAll(conn,start,end);
		close(conn);
		
		return list;
	}
	
	public int selectMyDongCount() {
		Connection conn = getConnection();
		int result = dao.selectMyDongCount(conn);
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
