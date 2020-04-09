package com.laon.etc.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.laon.common.robot.LaonRobot;
import com.oreilly.servlet.MultipartRequest;

//좋아요 테이블
public class Like implements LaonRobot<Like>{

 // 넘버 좋아요 기본키
 private int no;

 // 유저 테이블 넘버 회원 참조키
 private int userNo;

 // 여행기 테이블 넘버 여행기 참조키
 private int tripNo;

 // 취소여부 취소 여부
 private String cancled;
 
 public Like() {
	// TODO Auto-generated constructor stub
}
 
 






 public Like(int no, int userNo, int tripNo, String cancled) {
	super();
	this.no = no;
	this.userNo = userNo;
	this.tripNo = tripNo;
	this.cancled = cancled;
}








@Override
public String toString() {
	return "Like [no=" + no + ", userNo=" + userNo + ", tripNo=" + tripNo + ", cancled=" + cancled + "]";
}








public int getNo() {
	return no;
}








public void setNo(int no) {
	this.no = no;
}








public int getUserNo() {
	return userNo;
}








public void setUserNo(int userNo) {
	this.userNo = userNo;
}








public int getTripNo() {
	return tripNo;
}








public void setTripNo(int tripNo) {
	this.tripNo = tripNo;
}








public String getCancled() {
	return cancled;
}








public void setCancled(String cancled) {
	this.cancled = cancled;
}








// LikeTb 모델 복사
 public void CopyData(Like param)
 {
     this.no = param.getNo();
     this.userNo = param.getUserNo();
     this.tripNo = param.getTripNo();
     this.cancled = param.getCancled();
 }

//Like
	private String cNo = "no";
	private String cUserNo = "user_no";
	private String cTripNo = "category";
	private String cCancled = "write_date";


@Override
public List<Like> rsProcess(List<Like> list, ResultSet rs) throws SQLException {
	while (rs.next()) {
		Like item = new Like();
		item.setNo(rs.getInt(cNo));
		item.setUserNo(rs.getInt(cUserNo));
		item.setTripNo(rs.getInt(cTripNo));
		item.setCancled(rs.getString(cCancled));
		list.add(item);
	}
	return list;
}




@Override
public Like rsProcess(Like item, ResultSet rs) throws SQLException {
	while (rs.next()) {
		item.setNo(rs.getInt(cNo));
		item.setUserNo(rs.getInt(cUserNo));
		item.setTripNo(rs.getInt(cTripNo));
		item.setCancled(rs.getString(cCancled));
	}
	return item;
}








@Override
public Like mrProcess(Like item, MultipartRequest mr, Picture pic) {
	// TODO Auto-generated method stub
	return null;
}
}
