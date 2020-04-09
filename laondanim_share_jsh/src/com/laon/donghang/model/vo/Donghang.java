package com.laon.donghang.model.vo;

import java.sql.Date;

//동행 테이블
public class Donghang {

 // 넘버 동행 기본키
 private int no;

 // 유저 테이블 넘버 회원 참조키
 private int userNo;

 // 여행기 테이블 넘버 여행기 참조키
 private int tripNo;

 // 작성 날짜 작성 날짜
 private Date writeDate;

 // 조회수 조회수
 private int viewcount;

 // 태그 태그
 private String tag;

 // 제목 제목
 private String title;

 // 내용 내용
 private String content;

 // 여행 지역 여행 지역
 private String travleLocale;

 // 여행 시작 날짜 여행시작날짜
 private Date travleStartDate;

 // 여행 끝 날짜 여행끝날짜
 private Date travleEndDate;

 // 모집 시작 날짜 모집시작날짜
 private Date recruitStartDate;

 // 모집 끝 날짜 모집 끝날짜
 private Date recruitEndDate;

 // 비번 비번
 private int pw;

 // 공개 활성여부 공개 활성 여부
 private String publicEnabled;

 // 마감여부 마감 여부
 private String ended;

 // 삭제여부 삭제 여부
 private String deleted;

 // 모집 인원 넘버 동행 모집 인원
 private int recruitPeopleNo;

 // 참여 인원 넘버 동행 참여 인원
 private int joinPeopleNo;
 
 public Donghang() {
	// TODO Auto-generated constructor stub
}
 

 

 public Donghang(int no, int userNo, int tripNo, Date writeDate, int viewcount, String tag, String title, String content,
		String travleLocale, Date travleStartDate, Date travleEndDate, Date recruitStartDate, Date recruitEndDate,
		int pw, String publicEnabled, String ended, String deleted, int recruitPeopleNo, int joinPeopleNo) {
	super();
	this.no = no;
	this.userNo = userNo;
	this.tripNo = tripNo;
	this.writeDate = writeDate;
	this.viewcount = viewcount;
	this.tag = tag;
	this.title = title;
	this.content = content;
	this.travleLocale = travleLocale;
	this.travleStartDate = travleStartDate;
	this.travleEndDate = travleEndDate;
	this.recruitStartDate = recruitStartDate;
	this.recruitEndDate = recruitEndDate;
	this.pw = pw;
	this.publicEnabled = publicEnabled;
	this.ended = ended;
	this.deleted = deleted;
	this.recruitPeopleNo = recruitPeopleNo;
	this.joinPeopleNo = joinPeopleNo;
}




@Override
public String toString() {
	return "Donghang [no=" + no + ", userNo=" + userNo + ", tripNo=" + tripNo + ", writeDate=" + writeDate
			+ ", viewcount=" + viewcount + ", tag=" + tag + ", title=" + title + ", content=" + content
			+ ", travleLocale=" + travleLocale + ", travleStartDate=" + travleStartDate + ", travleEndDate="
			+ travleEndDate + ", recruitStartDate=" + recruitStartDate + ", recruitEndDate=" + recruitEndDate + ", pw="
			+ pw + ", publicEnabled=" + publicEnabled + ", ended=" + ended + ", deleted=" + deleted
			+ ", recruitPeopleNo=" + recruitPeopleNo + ", joinPeopleNo=" + joinPeopleNo + "]";
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




public Date getWriteDate() {
	return writeDate;
}




public void setWriteDate(Date writeDate) {
	this.writeDate = writeDate;
}




public int getViewcount() {
	return viewcount;
}




public void setViewcount(int viewcount) {
	this.viewcount = viewcount;
}




public String getTag() {
	return tag;
}




public void setTag(String tag) {
	this.tag = tag;
}




public String getTitle() {
	return title;
}




public void setTitle(String title) {
	this.title = title;
}




public String getContent() {
	return content;
}




public void setContent(String content) {
	this.content = content;
}




public String getTravleLocale() {
	return travleLocale;
}




public void setTravleLocale(String travleLocale) {
	this.travleLocale = travleLocale;
}




public Date getTravleStartDate() {
	return travleStartDate;
}




public void setTravleStartDate(Date travleStartDate) {
	this.travleStartDate = travleStartDate;
}




public Date getTravleEndDate() {
	return travleEndDate;
}




public void setTravleEndDate(Date travleEndDate) {
	this.travleEndDate = travleEndDate;
}




public Date getRecruitStartDate() {
	return recruitStartDate;
}




public void setRecruitStartDate(Date recruitStartDate) {
	this.recruitStartDate = recruitStartDate;
}




public Date getRecruitEndDate() {
	return recruitEndDate;
}




public void setRecruitEndDate(Date recruitEndDate) {
	this.recruitEndDate = recruitEndDate;
}




public int getPw() {
	return pw;
}




public void setPw(int pw) {
	this.pw = pw;
}




public String getPublicEnabled() {
	return publicEnabled;
}




public void setPublicEnabled(String publicEnabled) {
	this.publicEnabled = publicEnabled;
}




public String getEnded() {
	return ended;
}




public void setEnded(String ended) {
	this.ended = ended;
}




public String getDeleted() {
	return deleted;
}




public void setDeleted(String deleted) {
	this.deleted = deleted;
}




public int getRecruitPeopleNo() {
	return recruitPeopleNo;
}




public void setRecruitPeopleNo(int recruitPeopleNo) {
	this.recruitPeopleNo = recruitPeopleNo;
}




public int getJoinPeopleNo() {
	return joinPeopleNo;
}




public void setJoinPeopleNo(int joinPeopleNo) {
	this.joinPeopleNo = joinPeopleNo;
}




// DonghangTb 모델 복사
 public void CopyData(Donghang param)
 {
     this.no = param.getNo();
     this.userNo = param.getUserNo();
     this.tripNo = param.getTripNo();
     this.writeDate = param.getWriteDate();
     this.viewcount = param.getViewcount();
     this.tag = param.getTag();
     this.title = param.getTitle();
     this.content = param.getContent();
     this.travleLocale = param.getTravleLocale();
     this.travleStartDate = param.getTravleStartDate();
     this.travleEndDate = param.getTravleEndDate();
     this.recruitStartDate = param.getRecruitStartDate();
     this.recruitEndDate = param.getRecruitEndDate();
     this.pw = param.getPw();
     this.publicEnabled = param.getPublicEnabled();
     this.ended = param.getEnded();
     this.deleted = param.getDeleted();
     this.recruitPeopleNo = param.getRecruitPeopleNo();
     this.joinPeopleNo = param.getJoinPeopleNo();
 }
}