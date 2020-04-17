package com.laon.etc.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.laon.common.robot.LaonRobot;
import com.oreilly.servlet.MultipartRequest;

//찜목록 테이블
public class Mind implements LaonRobot<Mind> {

 // 넘버 찜 기본키
 private int no;

 // 유저 테이블 넘버 회원 참조키
 private int userNo;

 // 여행정보 테이블 넘버 여행 정보 참조키
 private int tripinfoNo;

 // 취소여부 취소 여부
 private String cancled;
		 

public Mind() {
	// TODO Auto-generated constructor stub
}








 public Mind(int no, int userNo, int tripinfoNo, String cancled) {
	super();
	this.no = no;
	this.userNo = userNo;
	this.tripinfoNo = tripinfoNo;
	this.cancled = cancled;
}








@Override
public String toString() {
	return "Mind [no=" + no + ", userNo=" + userNo + ", tripinfoNo=" + tripinfoNo + ", cancled=" + cancled + "]";
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








public int getTripinfoNo() {
	return tripinfoNo;
}








public void setTripinfoNo(int tripinfoNo) {
	this.tripinfoNo = tripinfoNo;
}








public String getCancled() {
	return cancled;
}








public void setCancled(String cancled) {
	this.cancled = cancled;
}








// MindTb 모델 복사
 public void CopyData(Mind param)
 {
     this.no = param.getNo();
     this.userNo = param.getUserNo();
     this.tripinfoNo = param.getTripinfoNo();
     this.cancled = param.getCancled();
 }








@Override
public List<Mind> rsProcess(List<Mind> list, ResultSet rs) throws SQLException {
	while (rs.next()) {
		Mind item =  new Mind();
		item.setNo(rs.getInt("no"));
		item.setUserNo(rs.getInt("user_no"));
		item.setTripinfoNo(rs.getInt("tripinfo_no"));
		item.setCancled(rs.getString("cancled"));
		list.add(item);
	}
	return list;
}








@Override
public Mind rsProcess(Mind item, ResultSet rs) throws SQLException {
	while (rs.next()) {
		item.setNo(rs.getInt("no"));
		item.setUserNo(rs.getInt("user_no"));
		item.setTripinfoNo(rs.getInt("tripinfo_no"));
		item.setCancled(rs.getString("cancled"));
	}
	return item;
}








@Override
public Mind mrProcess(Mind item, MultipartRequest mr, List<Picture> picList) {
	// TODO Auto-generated method stub
	return null;
}
}
