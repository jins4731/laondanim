package com.laon.trip.model.vo;

import java.sql.Date;

//여행기 테이블
public class Trip {

 // 넘버 여행기 기본키
 private int no;

 // 유저 테이블 넘버 회원 참조키
 private int userNo;

 // 카테고리 후기 / 일정
 private String category;

 // 작성 날짜 작성 날짜
 private Date writeDate;

 // 태그 태그
 private String tag;

 // 제목 제목
 private String title;

 // 내용 글작성 내용
 private String content;

 // 여행 지역 여행 지역
 private String travleLocale;

 // 인원 숫자 인원 숫자
 private int peopleNum;

 // 여행 유형 가족/친구/커플
 private String travleType;

 // 여행 시작 날짜 여행시작일
 private Date travleStartDate;

 // 여행 끝 날짜 여행마지막일
 private Date travleEndDate;

 // 공개 활성여부 공개/비공개
 private String publicEnabled;

 // 삭제여부 삭제여부(작성자가 삭제)
 private String deleted;
 
 
 public Trip() {
	// TODO Auto-generated constructor stub
}
 


 

 public Trip(int no, int userNo, String category, Date writeDate, String tag, String title, String content,
		String travleLocale, int peopleNum, String travleType, Date travleStartDate, Date travleEndDate,
		String publicEnabled, String deleted) {
	super();
	this.no = no;
	this.userNo = userNo;
	this.category = category;
	this.writeDate = writeDate;
	this.tag = tag;
	this.title = title;
	this.content = content;
	this.travleLocale = travleLocale;
	this.peopleNum = peopleNum;
	this.travleType = travleType;
	this.travleStartDate = travleStartDate;
	this.travleEndDate = travleEndDate;
	this.publicEnabled = publicEnabled;
	this.deleted = deleted;
}





@Override
public String toString() {
	return "Trip [no=" + no + ", userNo=" + userNo + ", category=" + category + ", writeDate=" + writeDate + ", tag="
			+ tag + ", title=" + title + ", content=" + content + ", travleLocale=" + travleLocale + ", peopleNum="
			+ peopleNum + ", travleType=" + travleType + ", travleStartDate=" + travleStartDate + ", travleEndDate="
			+ travleEndDate + ", publicEnabled=" + publicEnabled + ", deleted=" + deleted + "]";
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





public String getCategory() {
	return category;
}





public void setCategory(String category) {
	this.category = category;
}





public Date getWriteDate() {
	return writeDate;
}





public void setWriteDate(Date writeDate) {
	this.writeDate = writeDate;
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





public int getPeopleNum() {
	return peopleNum;
}





public void setPeopleNum(int peopleNum) {
	this.peopleNum = peopleNum;
}





public String getTravleType() {
	return travleType;
}





public void setTravleType(String travleType) {
	this.travleType = travleType;
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





public String getPublicEnabled() {
	return publicEnabled;
}





public void setPublicEnabled(String publicEnabled) {
	this.publicEnabled = publicEnabled;
}





public String getDeleted() {
	return deleted;
}





public void setDeleted(String deleted) {
	this.deleted = deleted;
}





// TripTb 모델 복사
 public void CopyData(Trip param)
 {
     this.no = param.getNo();
     this.userNo = param.getUserNo();
     this.category = param.getCategory();
     this.writeDate = param.getWriteDate();
     this.tag = param.getTag();
     this.title = param.getTitle();
     this.content = param.getContent();
     this.travleLocale = param.getTravleLocale();
     this.peopleNum = param.getPeopleNum();
     this.travleType = param.getTravleType();
     this.travleStartDate = param.getTravleStartDate();
     this.travleEndDate = param.getTravleEndDate();
     this.publicEnabled = param.getPublicEnabled();
     this.deleted = param.getDeleted();
 }
}
