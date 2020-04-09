package com.laon.etc.model.vo;

//좋아요 테이블
public class Like {

 // 넘버 좋아요 기본키
 private int no;

 // 유저 테이블 넘버 회원 참조키
 private int userNo;

 // 여행기 테이블 넘버 여행기 참조키
 private int tripNo;

 // 취소여부 취소 여부
 private String cancled;
 
 
 // 좋아요 개수
 private int likeCount;
 
 public Like() {
	// TODO Auto-generated constructor stub
}
 
 






 public Like(int no, int userNo, int tripNo, String cancled, int likeCount) {
	super();
	this.no = no;
	this.userNo = userNo;
	this.tripNo = tripNo;
	this.cancled = cancled;
	this.likeCount = likeCount;
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








public int getLikeCount() {
	return likeCount;
}








public void setLikeCount(int likeCount) {
	this.likeCount = likeCount;
}








// LikeTb 모델 복사
 public void CopyData(Like param)
 {
     this.no = param.getNo();
     this.userNo = param.getUserNo();
     this.tripNo = param.getTripNo();
     this.cancled = param.getCancled();
 }








@Override
public String toString() {
	return "Like [no=" + no + ", userNo=" + userNo + ", tripNo=" + tripNo + ", cancled=" + cancled + ", likeCount="
			+ likeCount + "]";
}
 
 
}
