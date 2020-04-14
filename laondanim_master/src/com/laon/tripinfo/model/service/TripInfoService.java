package com.laon.tripinfo.model.service;

import static com.laon.common.template.JDBCTemplate.*;


import java.sql.Connection;
import java.util.List;

import com.laon.tripinfo.model.dao.TripInfoDao;
import com.laon.tripinfo.model.vo.Mind;
import com.laon.tripinfo.model.vo.Picture;
import com.laon.tripinfo.model.vo.TripInfo2;
import com.laon.tripinfo.model.vo.Tripinfo;
import com.laon.tripinfo.model.vo.TripInfoComment;
import com.laon.tripinfo.model.vo.TripInfoPicture;

public class TripInfoService {
	
	private  TripInfoDao dao=new TripInfoDao();
	
	public List<Tripinfo> selectTripinfoPage(int start, int end) {
	      Connection conn = getConnection();
	      List<Tripinfo> list = dao.selectTripinfoPage(conn, start, end);
	      close(conn);
	      return list;
	   }

	   public int selectTripinfoCount() {
	      Connection conn = getConnection();
	      int result = dao.selectTripinfoCount(conn);
	      close(conn);
	      return result;
	   }
	
	
	
	
	
	
	
	
	
	
	
	///========================================================================================================
	
	/* �������� ����Ʈ �������� */
	public List<TripInfoPicture> selectTripinfoList(int cPage,int numPerPage ,String category, String type, String keyword, String mind ){
		
		Connection conn=getConnection();
		
		List<TripInfoPicture> list=dao.selectTripinfoList(conn,cPage,numPerPage,category, type, keyword, mind);
		close(conn);
		
		return list;
	}
	
	
	
	/* �������� ����Ʈ ī����  */
	public int selectCountTripInfo(String category, String type, String keyword) {
		
		Connection conn=getConnection();
		int count=dao.selectCountTripInfo(conn,category,type,keyword);
	 	close(conn);
		return count;
	}
	
	
	/* �α����� ������ �ش� ���������� Ŭ���ߴ��� üũ */
	public String checkMind(int userNo,int tripinfoNo) {
		Connection conn=getConnection();
		String cancled=dao.checkMind(conn,userNo,tripinfoNo);
		close(conn);
		return cancled;
	}
	
	/* �α����� ������ �ش� ���������� ó�� Ŭ������ �� */
	public int insertMind(int userNo , int tripinfoNo) {
		
		Connection conn=getConnection();
		int result=dao.insertMind(conn,userNo,tripinfoNo);
		close(conn);
		return result;
		
	}
	
	/* �α����� ������ �ش� ���������� 1�� �̻� Ŭ������ ��  */
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
	
	//�α����� ������ ���� ��� ����Ʈ ��������
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
	
	public List<TripInfo2> selectTripinfo(List<Mind> userMindList) {
		
		Connection conn = getConnection();
		List<TripInfo2> tripInfoList = dao.selectTripinfo(conn, userMindList);
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

	
	

	
	
	
	 

}
