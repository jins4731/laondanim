package com.laon.tripinfo.model.vo;

import java.sql.Date;

//여행정보 댓글 테이블
public class TripinfoComment {

 // 넘버 여행정보댓글 기본키
 private int no;

 // 여행정보 테이블 넘버 여행정보 참조키
 private int tripinfoNo;

 // 유저 테이블 넘버 회원 참조키
 private int userNo;

 // 작성 날짜 작성 날짜
 private Date writeDate;

 // 내용 댓글 내용
 private String content;

 // 삭제여부 삭제했을 때 표시
 private String deleted;
 
 public TripinfoComment() {
	// TODO Auto-generated constructor stub
}
 



 public TripinfoComment(int no, int tripinfoNo, int userNo, Date writeDate, String content, String deleted) {
	super();
	this.no = no;
	this.tripinfoNo = tripinfoNo;
	this.userNo = userNo;
	this.writeDate = writeDate;
	this.content = content;
	this.deleted = deleted;
}




@Override
public String toString() {
	return "TripinfoComment [no=" + no + ", tripinfoNo=" + tripinfoNo + ", userNo=" + userNo + ", writeDate="
			+ writeDate + ", content=" + content + ", deleted=" + deleted + "]";
}




public int getNo() {
	return no;
}




public void setNo(int no) {
	this.no = no;
}




public int getTripinfoNo() {
	return tripinfoNo;
}




public void setTripinfoNo(int tripinfoNo) {
	this.tripinfoNo = tripinfoNo;
}




public int getUserNo() {
	return userNo;
}




public void setUserNo(int userNo) {
	this.userNo = userNo;
}




public Date getWriteDate() {
	return writeDate;
}




public void setWriteDate(Date writeDate) {
	this.writeDate = writeDate;
}




public String getContent() {
	return content;
}




public void setContent(String content) {
	this.content = content;
}




public String getDeleted() {
	return deleted;
}




public void setDeleted(String deleted) {
	this.deleted = deleted;
}




// TripinfoCommentTb 모델 복사
 public void CopyData(TripinfoComment param)
 {
     this.no = param.getNo();
     this.tripinfoNo = param.getTripinfoNo();
     this.userNo = param.getUserNo();
     this.writeDate = param.getWriteDate();
     this.content = param.getContent();
     this.deleted = param.getDeleted();
 }
}