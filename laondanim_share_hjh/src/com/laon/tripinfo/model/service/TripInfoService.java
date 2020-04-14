package com.laon.tripinfo.model.service;

import static com.laon.common.JDBCTemplate.close;
import static com.laon.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.laon.tripinfo.model.dao.TripInfoDao;
import com.laon.tripinfo.model.vo.Mind;
import com.laon.tripinfo.model.vo.Picture;
import com.laon.tripinfo.model.vo.TripInfo;
import com.laon.tripinfo.model.vo.TripInfoComment;
import com.laon.tripinfo.model.vo.TripInfoPicture;
import com.laon.user.model.vo.User;

public class TripInfoService {
	
	private  TripInfoDao dao=new TripInfoDao();
	
	/* 여행정보 리스트 가져오기 */
	public List<TripInfoPicture> selectTripinfoList(int cPage,int numPerPage ,String category, String type, String keyword, String mind ){
		
		Connection conn=getConnection();
		
		List<TripInfoPicture> list=dao.selectTripinfoList(conn,cPage,numPerPage,category, type, keyword, mind);
		close(conn);
		
		return list;
	}
	
	
	
	/* 여행정보 리스트 카운팅  */
	public int selectCountTripInfo(String category, String type, String keyword) {
		
		Connection conn=getConnection();
		int count=dao.selectCountTripInfo(conn,category,type,keyword);
	 	close(conn);
		return count;
	}
	
	
	
	/* 로그인한 유저가 해당 여행정보를 클릭했는지 체크 */
	public String checkMind(int userNo,int tripinfoNo) {
		Connection conn=getConnection();
		String cancled=dao.checkMind(conn,userNo,tripinfoNo);
		close(conn);
		return cancled;
	}
	
	/* 로그인한 유저가 해당 여행정보를 처음 클릭했을 때 */
	public int insertMind(int userNo , int tripinfoNo) {
		
		Connection conn=getConnection();
		int result=dao.insertMind(conn,userNo,tripinfoNo);
		close(conn);
		return result;
		
	}
	
	/* 로그인한 유저가 해당 여행정보를 1번 이상 클릭했을 때  */
	public int updateMind(int userNo , int tripinfoNo,String cancled ) {
		
		Connection conn=getConnection();
		int result=dao.updateMind(conn,userNo,tripinfoNo,cancled);
		close(conn);
		return result;
	}
	
	public Picture selectUserPicture(int userNo) {
		Connection conn=getConnection();
		Picture p=dao.selectUserPicture(conn,userNo);
		close(conn);
		return p;
	}
	
	public List<Mind> heartCount(List<TripInfoPicture> list){
		Connection conn=getConnection();
		List<Mind> heartCount=dao.heartCount(conn,list);
		close(conn);
		return heartCount;
	}
	
	//로그인한 유저가 찜한 목록 리스트 가져오기
	public List<Mind> selectUserMind(int userNo){
		Connection conn = getConnection();
		List<Mind> userMindList = dao.selectUserMind(conn, userNo);
		close(conn);
		return userMindList;
	}
	
	public List<Picture> selectPicture(List<Mind> userMindList){
		Connection conn = getConnection();
		List<Picture> pictureList = dao.selectPicture(conn, userMindList);
		close(conn);
		return pictureList;
	}
	
	public List<TripInfo> selectTripinfo(List<Mind> userMindList) {
		
		Connection conn = getConnection();
		List<TripInfo> tripInfoList = dao.selectTripinfo(conn, userMindList);
		close(conn);
		return tripInfoList;
	}
	
	public List<Mind> selectMind(){
		
		Connection conn = getConnection();
		List<Mind> selectMind = dao.selectMind(conn);
		close(conn);
		return selectMind;
	}
	
	public List<TripInfoComment> selectComment(){
		
		Connection conn = getConnection();
		List<TripInfoComment> commentList = dao.selectComment(conn);
		close(conn);
		return commentList;
	}
	
	public int insertComment(TripInfoComment tc) {
		Connection conn=getConnection();
		int result=dao.insertComment(conn,tc);
		close(conn);
		return result;
	}
	
	public List<TripInfoComment> selectUserComment(){
		
		Connection conn = getConnection();
		List<TripInfoComment> comment = dao.selectUserComment(conn);
		close(conn);
		return comment;
	}
	
	public List<User> selectUser(List<TripInfoPicture> list){
		
		Connection conn = getConnection();
		List<User> selectUser = dao.selectUser(conn,list);
		close(conn);
		return selectUser;
	}

	
	

	
	
	
	 

}
