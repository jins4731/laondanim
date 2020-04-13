package com.laon.trip.model.vo;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laon.common.PictureKey;
import com.laon.common.TripKey;
import com.laon.common.robot.LaonRobot;
import com.laon.etc.model.vo.Picture;
import com.laon.user.model.vo.User;
import com.oreilly.servlet.MultipartRequest;

//여행기 테이블
public class Trip implements LaonRobot<Trip>{
	
private List<Picture> pictureList;

private User user;

private List<TripSchedule> tripScheduleList;

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















public User getUser() {
	return user;
}





public void setUser(User user) {
	this.user = user;
}





public List<TripSchedule> getTripScheduleList() {
	return tripScheduleList;
}





public void setTripScheduleList(List<TripSchedule> tripScheduleList) {
	this.tripScheduleList = tripScheduleList;
}










public List<Picture> getPictureList() {
	if(pictureList == null) {
		pictureList = new ArrayList<Picture>();
	}
	return pictureList;
}





public void setPictureList(List<Picture> pictureList) {
	this.pictureList = pictureList;
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


//Trip
		private String cNo = "no";
		private String cUserNo = "user_no";
		private String cCategory = "category";
		private String cWriteDate = "write_date";
		private String cTag = "tag";
		private String cTitle = "title";
		private String cContent = "content";
		private String cTravleLocale = "travle_locale";
		private String cPeopleNum = "people_num";
		private String cTravleType = "travle_type";
		private String cTravleStartDate = "travle_start_date";
		private String cTravleEndDate = "travle_end_date";
		private String cPublicEnabled = "public_enabled";
		private String cDeleted = "deleted";
 
 


@Override
public List<Trip> rsProcess(List<Trip> list, ResultSet rs) throws SQLException {
	
	while (rs.next()) {
	Trip trip = new Trip();
	trip.setNo(rs.getInt(cNo));
	trip.setUserNo(rs.getInt(cUserNo));
	trip.setCategory(rs.getString(cCategory));
	trip.setWriteDate(rs.getDate(cWriteDate));
	trip.setTag(rs.getString(cTag));
	trip.setTitle(rs.getString(cTitle));
	trip.setContent(rs.getString(cContent));
	trip.setTravleLocale(rs.getString(cTravleLocale));
	trip.setPeopleNum(rs.getInt(cPeopleNum));
	trip.setTravleType(rs.getString(cTravleType));
	trip.setTravleStartDate(rs.getDate(cTravleStartDate));
	trip.setTravleEndDate(rs.getDate(cTravleEndDate));
	trip.setPublicEnabled(rs.getString(cPublicEnabled));
	trip.setDeleted(rs.getString(cDeleted));
	list.add(trip);
}
	
	return list;
}





@Override
public Trip rsProcess(Trip item, ResultSet rs) throws SQLException {
	// TODO Auto-generated method stub
	while (rs.next()) {
		item.setNo(rs.getInt(cNo));
		item.setUserNo(rs.getInt(cUserNo));
		item.setCategory(rs.getString(cCategory));
		item.setWriteDate(rs.getDate(cWriteDate));
		item.setTag(rs.getString(cTag));
		item.setTitle(rs.getString(cTitle));
		item.setContent(rs.getString(cContent));
		item.setTravleLocale(rs.getString(cTravleLocale));
		item.setPeopleNum(rs.getInt(cPeopleNum));
		item.setTravleType(rs.getString(cTravleType));
		item.setTravleStartDate(rs.getDate(cTravleStartDate));
		item.setTravleEndDate(rs.getDate(cTravleEndDate));
		item.setPublicEnabled(rs.getString(cPublicEnabled));
		item.setDeleted(rs.getString(cDeleted));
	}
	return item;
}





@Override
public Trip mrProcess(Trip item, MultipartRequest mr, List<Picture> picList) {
	item.setUserNo(Integer.parseInt(mr.getParameter(TripKey.USER_NO)));
	item.setCategory(mr.getParameter(TripKey.CATEGORY));
	item.setWriteDate(Date.valueOf(mr.getParameter(TripKey.WRITE_DATE)));
	item.setTag(mr.getParameter(TripKey.TAG));
	item.setTitle(mr.getParameter(TripKey.TITLE));
	item.setContent(mr.getParameter(TripKey.CONTENT));
	item.setTravleLocale(mr.getParameter(TripKey.TRAVLE_lOCALE));
	item.setPeopleNum(Integer.parseInt(mr.getParameter(TripKey.PEOPLE_NUM)));
	item.setTravleType(mr.getParameter(TripKey.TRAVLE_TYPE));
	item.setTravleStartDate(Date.valueOf(mr.getParameter(TripKey.TRAVLE_START_DATE)));
	item.setTravleEndDate(Date.valueOf(mr.getParameter(TripKey.TRAVLE_END_DATE)));
	item.setPublicEnabled(mr.getParameter(TripKey.PUBLIC_ENABLED));
	item.setDeleted(mr.getParameter(TripKey.DELETED));
	
	
	// 스케줄 추가
	int scheduleNum = 0;
	tripScheduleList = new ArrayList<TripSchedule>(); 
	for (int i = 0; i < scheduleNum; i++) {
		TripSchedule schedule = new TripSchedule();
		schedule.setTripinfoNo(Integer.parseInt(mr.getParameter("")));
		schedule.setDay(Integer.parseInt(mr.getParameter("")));
		schedule.setOrders(Integer.parseInt(mr.getParameter("")));
		schedule.setRequiredHours(mr.getParameter(""));
		schedule.setTransport(mr.getParameter(""));
	}
	
	
	// 사진 추가
	pictureList = picList;
	String fileNames = mr.getParameter("fileNames");
	fileNames = fileNames.substring(0, fileNames.length()-1);
	String[] fileName = fileNames.split(",");
	for (int i = 0; i < fileName.length; i++) {
		Picture pic = new Picture();
		pic.setImage(fileName[i]);
		pictureList.add(pic);
	}
	
	
	return item;
}
}
