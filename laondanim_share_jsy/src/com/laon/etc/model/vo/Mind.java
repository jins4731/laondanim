package com.laon.etc.model.vo;

//찜목록 테이블
public class Mind {

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
}
