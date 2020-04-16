package com.laon.mypage.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.commit;
import static com.laon.common.template.JDBCTemplate.getConnection;
import static com.laon.common.template.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.laon.board.model.vo.Board;
import com.laon.donghang.model.vo.DonghangJoin;
import com.laon.donghang.model.vo.MyDong;
import com.laon.etc.model.vo.Like;
import com.laon.etc.model.vo.Mind;
import com.laon.etc.model.vo.Picture;
import com.laon.mypage.model.dao.MypageDao;
import com.laon.trip.model.vo.TripMyCon;
import com.laon.tripinfo.model.vo.TripinfoMyMind;
import com.laon.user.model.vo.User;
import com.laon.user.model.vo.UserProfile;

public class MypageService {
	private MypageDao dao=new MypageDao();
	
	//로그인 유저 프로필 정보
	public UserProfile selectUserNo(int no) {
		Connection conn=getConnection();
		UserProfile up=dao.selectUserNo(conn,no);
		close(conn);
		
		return up;
	}
	
	//정보수정페이지 전 패스워드 체크
	public boolean selectPwck(int userNo,String pw){
		Connection conn=getConnection();
		boolean flag=dao.selectPwck(conn,userNo,pw);
		close(conn);
		
		return flag;
	}
	
	//정보수정 + 프로필 사진
	public int updateUserProfile(User u,Picture p) {
		Connection conn=getConnection();
		int result=dao.updateUserInfo(conn,u);
		if(result>0) {
			result=dao.updateUserProfile(conn, p);
			if(result>0) {				
				commit(conn);
			}else {
				rollback(conn);
			}
		}
		close(conn);
		
		return result;
	}
	
	//내 컨텐츠 최신글 4개
	public List<TripMyCon> selectMyTrip(int userNo){
		Connection conn=getConnection();
		List<TripMyCon> list=dao.selectMyTrip(conn,userNo);
		close(conn);
		
		return list;
	}
	
	//내 컨텐츠 상세페이지 모든 리스트
	public List<TripMyCon> selectMyTripAll(int userNo,int start,int end){
		Connection conn=getConnection();
		List<TripMyCon> list=dao.selectMyTripAll(conn,userNo,start,end);
		close(conn);
		
		return list;
	}
	
	//내 컨텐츠 좋아요 개수
	public List selectMyTripLike(int userNo) {
		Connection conn=getConnection();
		List like=dao.selectMyTripLike(conn,userNo);
		close(conn);
		
		return like;
	}
	
	//내 컨텐츠 총 개수
	public int selectMyTripCount(int userNo) {
		Connection conn = getConnection();
		int result = dao.selectMyTripCount(conn,userNo);
		close(conn);
		return result;
	}
	
	//내 게시글 리스트
	public List<Board> selectMyBoard(int userNo,int start,int end){
		Connection conn=getConnection();
		List<Board> list=dao.selectMyBoard(conn,userNo,start,end);
		close(conn);
		
		return list;
	}
	
	//내 게시글 총 개수
	public int selectMyBoardCount(int userNo) {
		Connection conn = getConnection();
		int result = dao.selectMyBoardCount(conn,userNo);
		close(conn);
		
		return result;
	}
	
	//내 동행 최신글 4개
	public List<MyDong> selectMyDong(int userNo){
		Connection conn=getConnection();
		List<MyDong> list=dao.selectMyDong(conn,userNo);
		close(conn);
		
		return list;
	}
	
	//내 동행 상세페이지 모든 리스트
	public List<MyDong> selectMyDHAll(int userNo,int start,int end){
		Connection conn=getConnection();
		List<MyDong> list=dao.selectMyDHAll(conn,userNo,start,end);
		close(conn);
		
		return list;
	}
	
	//내 동행 총 개수
	public int selectMyDongCount(int userNo) {
		Connection conn = getConnection();
		int result = dao.selectMyDongCount(conn,userNo);
		close(conn);
		
		return result;
	}
	
	//참여동행 조회
	public List<DonghangJoin> selectJoin(int userNo){
		Connection conn=getConnection();
		List<DonghangJoin> list=dao.selectJoin(conn,userNo);
		close(conn);
		
		return list;
	}
	
	//참여동행 기준으로 동행 리스트 최신글 4개
	public List<MyDong> selectOriJoin(List<DonghangJoin> jd){
		Connection conn=getConnection();
		List<MyDong> list=dao.selectOriJoin(conn,jd);
		close(conn);
		
		return list;
	}
	
	//참여동행 기준으로 참여동행 상세 페이지 모든 리스트
	public List<MyDong> selectOriJoinAll(List<DonghangJoin> jd,int start,int end){
		Connection conn=getConnection();
		List<MyDong> list=dao.selectOriJoinAll(conn,jd,start,end);
		close(conn);
		
		return list;
	}
	
	//참여동행 리스트의 원글 작성자 닉네임
	public List<UserProfile> selectUserNick(List<MyDong> ojd){
		Connection conn=getConnection();
		List<UserProfile> userNick=dao.selectUserNick(conn,ojd);
		close(conn);

		return userNick;
	}
	
	//참여동행 총 개수
	public int selectMyJDCount(int userNo) {
		Connection conn=getConnection();
		int result=dao.selectMyJDCount(conn,userNo);
		close(conn);
		
		return result;
	}
	
	//내가 좋아요한 여행기 넘버
	public List<Like> selectTripLike(int userNo){
		Connection conn=getConnection();
		List<Like> likeT=dao.selectTripLike(conn, userNo);
		close(conn);
		
		return likeT;
	}
	
	//내가 좋아요한 여행기 리스트
	public List<TripMyCon> selectTripList(List<Like> likeT){
		Connection conn=getConnection();
		List<TripMyCon> tripList=dao.selectTripList(conn,likeT);
		close(conn);
		
		return tripList;
	}
	
	//내가 좋아요한 여행기 리스트 전체
	public List<TripMyCon> selectTripListAll(List<Like> likeT,int start,int end){
		Connection conn=getConnection();
		List<TripMyCon> tripList=dao.selectTripListAll(conn,likeT,start,end);
		close(conn);
		
		return tripList;
	}
	
	//내가 좋아요한 여행기 작성자 닉네임
	public List<UserProfile> selectTripUserNick(List<TripMyCon> tl){
		Connection conn=getConnection();
		List<UserProfile> userNick=dao.selectTripUserNick(conn,tl);
		close(conn);
		
		return userNick;
	}
	
	//내가 좋아요한 여행기 총 개수
	public int selectLikeTripCount(int userNo) {
		Connection conn=getConnection();
		int count=dao.selectLikeTripCount(conn,userNo);
		close(conn);
		
		return count;
	}
	
	//내가 찜한 여행정보 넘버
	public List<Mind> selectMind(int userNo){
		Connection conn=getConnection();
		List<Mind> mind=dao.selectMind(conn,userNo);
		close(conn);
		
		return mind;
	}
	
	//내가 찜한 여행정보 리스트
	public List<TripinfoMyMind> selectMindList(List<Mind> mind){
		Connection conn=getConnection();
		List<TripinfoMyMind> mindList=dao.selectMindList(conn,mind);
		close(conn);
		
		return mindList;
	}
	
	//참여 동행 거절 삭제
	public int dongJoinRefusal(int no) {
		Connection conn=getConnection();
		int result=dao.dongJoinRefusal(conn,no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
}
