package com.laon.etc.model.vo;

//신고 테이블
public class Reports {

 // 넘버 신고 기본키
 private int no;

 // 유저 테이블 넘버 회원 참조키
 private int userNo;

 // 여행기 테이블 넘버 여행기 참조키
 private int tripNo;

 // 동행 테이블 넘버 동행 참조키
 private int donghangNo;

 // 동행 댓글 테이블 넘버 동행 댓글 참조키
 private int donghangCommentNo;

 // 여행정보 테이블 넘버 여행정보 참조키
 private int tripinfoNo;

 // 여행정보 테이블 댓글 넘버 여행정보 댓글 참조키
 private int tripinfoCommentNo;

 // 게시판 테이블 넘버 게시판 참조키
 private int boardNo;

 // 게시판 댓글 테이블 넘버 게시판 댓글 참조키
 private int boardCommentNo;
 
 public Reports() {
	// TODO Auto-generated constructor stub
}
 
 
 





 public Reports(int no, int userNo, int tripNo, int donghangNo, int donghangCommentNo, int tripinfoNo,
		int tripinfoCommentNo, int boardNo, int boardCommentNo) {
	super();
	this.no = no;
	this.userNo = userNo;
	this.tripNo = tripNo;
	this.donghangNo = donghangNo;
	this.donghangCommentNo = donghangCommentNo;
	this.tripinfoNo = tripinfoNo;
	this.tripinfoCommentNo = tripinfoCommentNo;
	this.boardNo = boardNo;
	this.boardCommentNo = boardCommentNo;
}








@Override
public String toString() {
	return "Reports [no=" + no + ", userNo=" + userNo + ", tripNo=" + tripNo + ", donghangNo=" + donghangNo
			+ ", donghangCommentNo=" + donghangCommentNo + ", tripinfoNo=" + tripinfoNo + ", tripinfoCommentNo="
			+ tripinfoCommentNo + ", boardNo=" + boardNo + ", boardCommentNo=" + boardCommentNo + "]";
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








public int getDonghangNo() {
	return donghangNo;
}








public void setDonghangNo(int donghangNo) {
	this.donghangNo = donghangNo;
}








public int getDonghangCommentNo() {
	return donghangCommentNo;
}








public void setDonghangCommentNo(int donghangCommentNo) {
	this.donghangCommentNo = donghangCommentNo;
}








public int getTripinfoNo() {
	return tripinfoNo;
}








public void setTripinfoNo(int tripinfoNo) {
	this.tripinfoNo = tripinfoNo;
}








public int getTripinfoCommentNo() {
	return tripinfoCommentNo;
}








public void setTripinfoCommentNo(int tripinfoCommentNo) {
	this.tripinfoCommentNo = tripinfoCommentNo;
}








public int getBoardNo() {
	return boardNo;
}








public void setBoardNo(int boardNo) {
	this.boardNo = boardNo;
}








public int getBoardCommentNo() {
	return boardCommentNo;
}








public void setBoardCommentNo(int boardCommentNo) {
	this.boardCommentNo = boardCommentNo;
}








// ReportsTb 모델 복사
 public void CopyData(Reports param)
 {
     this.no = param.getNo();
     this.userNo = param.getUserNo();
     this.tripNo = param.getTripNo();
     this.donghangNo = param.getDonghangNo();
     this.donghangCommentNo = param.getDonghangCommentNo();
     this.tripinfoNo = param.getTripinfoNo();
     this.tripinfoCommentNo = param.getTripinfoCommentNo();
     this.boardNo = param.getBoardNo();
     this.boardCommentNo = param.getBoardCommentNo();
 }
}
