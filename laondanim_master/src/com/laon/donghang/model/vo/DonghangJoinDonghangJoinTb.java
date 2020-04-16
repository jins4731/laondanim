package com.laon.donghang.model.vo;

import java.sql.Date;

//동행 참여신청서 테이블
public class DonghangJoinDonghangJoinTb {
 // 넘버 동행 기본키
 private int dhNo;
 
 // 제목 제목
 private String title;
 
 // 모집 끝 날짜 모집 끝날짜
 private Date recruitEndDate;
 
 // 마감여부 마감 여부
 private String ended;
	
 // 넘버 동행 참가신청 기본키
 private int no;

 // 유저 테이블 넘버 회원 참조키
 private int userNo;

 // 동행 테이블 넘버 동행 참조키
 private int donghangNo;

 // 내용 자기소개
 private String content;

 // 확인여부 동행장이 수락 혹은 거절
 private String confirmed;

 // 취소여부 참여한사람이 취소여부
 private String cancled;

 // 신고여부 동행장이 관리(신고 )
 private String reported;

 // 삭제여부 동행장이 삭제 여부
 private String deleted;
 
 public DonghangJoinDonghangJoinTb() {
	// TODO Auto-generated constructor stub
}
 






public DonghangJoinDonghangJoinTb(int dhNo, String title, Date recruitEndDate, String ended, int no, int userNo,
		int donghangNo, String content, String confirmed, String cancled, String reported, String deleted) {
	super();
	this.dhNo = dhNo;
	this.title = title;
	this.recruitEndDate = recruitEndDate;
	this.ended = ended;
	this.no = no;
	this.userNo = userNo;
	this.donghangNo = donghangNo;
	this.content = content;
	this.confirmed = confirmed;
	this.cancled = cancled;
	this.reported = reported;
	this.deleted = deleted;
}







@Override
public String toString() {
	return "DonghangJoinDonghangJoinTb [dhNo=" + dhNo + ", title=" + title + ", recruitEndDate=" + recruitEndDate
			+ ", ended=" + ended + ", no=" + no + ", userNo=" + userNo + ", donghangNo=" + donghangNo + ", content="
			+ content + ", confirmed=" + confirmed + ", cancled=" + cancled + ", reported=" + reported + ", deleted="
			+ deleted + "]";
}







public int getDhNo() {
	return dhNo;
}







public void setDhNo(int dhNo) {
	this.dhNo = dhNo;
}







public String getTitle() {
	return title;
}







public void setTitle(String title) {
	this.title = title;
}







public Date getRecruitEndDate() {
	return recruitEndDate;
}







public void setRecruitEndDate(Date recruitEndDate) {
	this.recruitEndDate = recruitEndDate;
}







public String getEnded() {
	return ended;
}







public void setEnded(String ended) {
	this.ended = ended;
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







public int getDonghangNo() {
	return donghangNo;
}







public void setDonghangNo(int donghangNo) {
	this.donghangNo = donghangNo;
}







public String getContent() {
	return content;
}







public void setContent(String content) {
	this.content = content;
}







public String getConfirmed() {
	return confirmed;
}







public void setConfirmed(String confirmed) {
	this.confirmed = confirmed;
}







public String getCancled() {
	return cancled;
}







public void setCancled(String cancled) {
	this.cancled = cancled;
}







public String getReported() {
	return reported;
}







public void setReported(String reported) {
	this.reported = reported;
}







public String getDeleted() {
	return deleted;
}







public void setDeleted(String deleted) {
	this.deleted = deleted;
}



}