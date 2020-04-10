package com.laon.donghang.model.vo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.laon.common.DonghangKey;
import com.laon.common.PictureKey;
import com.laon.common.robot.LaonRobot;
import com.laon.etc.model.vo.Picture;
import com.oreilly.servlet.MultipartRequest;

//동행 테이블
public class Donghang implements LaonRobot<Donghang>{
		
	
private Picture picture;

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



 
 private String cNo = "no";
 private String cUserNo = "userNo;";
 private String cTripNo = "tripNo;";
 private String cWriteDate = "write_date";
 private String cViewcount = "view_count";
 private String cTag = "tag";
 private String cTitle = "title";
 private String cContent = "content";
 private String cTravleLocale = "travle_locale";
 private String cTravleStartDate = "travle_start_date";
 private String cTravleEndDate = "travle_end_date";
 private String cRecruitStartDate = "recruit_start_date";
 private String cRecruitEndDate = "recruit_end_date";
 private String cPw = "pw";
 private String cPublicEnabled = "public_enabled";
 private String cEnded = "ended";
 private String cDeleted = "deleted";
 private String cRecruitPeopleNo = "recruit_people_no";
 private String cJoinPeopleNo = "join_people_no";
 

@Override
public List<Donghang> rsProcess(List<Donghang> list, ResultSet rs) throws SQLException {
	// TODO Auto-generated method stub
	while (rs.next()) {
		Donghang item = new Donghang();
		item.setNo(rs.getInt(cNo));
		item.setUserNo(rs.getInt(cUserNo));
		item.setTripNo(rs.getInt(cTripNo));
		item.setWriteDate(rs.getDate(cWriteDate));
		item.setViewcount(rs.getInt(cViewcount));
		item.setTag(rs.getString(cTag));
		item.setTitle(rs.getString(cTitle));
		item.setContent(rs.getString(cContent));
		item.setTravleLocale(rs.getString(cTravleLocale));
		item.setTravleStartDate(rs.getDate(cTravleStartDate));
		item.setTravleEndDate(rs.getDate(cTravleEndDate));
		item.setRecruitStartDate(rs.getDate(cRecruitStartDate));
		item.setRecruitEndDate(rs.getDate(cRecruitEndDate));
		item.setPw(rs.getInt(cPw));
		item.setPublicEnabled(rs.getString(cPublicEnabled));
		item.setEnded(rs.getString(cEnded));
		item.setDeleted(rs.getString(cDeleted));
		item.setRecruitPeopleNo(rs.getInt(cRecruitPeopleNo));
		item.setJoinPeopleNo(rs.getInt(cJoinPeopleNo));
		list.add(item);
	}
	return list;
}




@Override
public Donghang rsProcess(Donghang item, ResultSet rs) throws SQLException {
	// TODO Auto-generated method stub
	while (rs.next()) {
		item.setNo(rs.getInt(cNo));
		item.setUserNo(rs.getInt(cUserNo));
		item.setTripNo(rs.getInt(cTripNo));
		item.setWriteDate(rs.getDate(cWriteDate));
		item.setViewcount(rs.getInt(cViewcount));
		item.setTag(rs.getString(cTag));
		item.setTitle(rs.getString(cTitle));
		item.setContent(rs.getString(cContent));
		item.setTravleLocale(rs.getString(cTravleLocale));
		item.setTravleStartDate(rs.getDate(cTravleStartDate));
		item.setTravleEndDate(rs.getDate(cTravleEndDate));
		item.setRecruitStartDate(rs.getDate(cRecruitStartDate));
		item.setRecruitEndDate(rs.getDate(cRecruitEndDate));
		item.setPw(rs.getInt(cPw));
		item.setPublicEnabled(rs.getString(cPublicEnabled));
		item.setEnded(rs.getString(cEnded));
		item.setDeleted(rs.getString(cDeleted));
		item.setRecruitPeopleNo(rs.getInt(cRecruitPeopleNo));
		item.setJoinPeopleNo(rs.getInt(cJoinPeopleNo));
	}
	return item;
}




@Override
public Donghang mrProcess(Donghang item, MultipartRequest mr, Picture pic) {
	picture = pic;
	picture.setImage(mr.getOriginalFileName(PictureKey.IMAGE));
	item.setNo(Integer.parseInt(mr.getParameter(DonghangKey.NO)));
	item.setUserNo(Integer.parseInt(mr.getParameter(DonghangKey.USER_NO)));
	item.setTripNo(Integer.parseInt(mr.getParameter(DonghangKey.TRIP_NO)));
	item.setWriteDate(Date.valueOf(mr.getParameter(DonghangKey.WRITE_DATE)));
	item.setViewcount(Integer.parseInt(mr.getParameter(DonghangKey.VIEWCOUNT)));
	item.setTag(mr.getParameter(DonghangKey.TAG));
	item.setTitle(mr.getParameter(DonghangKey.TITLE));
	item.setContent(mr.getParameter(DonghangKey.CONTENT));
	item.setTravleLocale(mr.getParameter(DonghangKey.TRAVLE_LOCALE));
	item.setTravleStartDate(Date.valueOf(mr.getParameter(DonghangKey.TRAVLE_START_DATE)));
	item.setTravleEndDate(Date.valueOf(mr.getParameter(DonghangKey.TRAVLE_END_DATE)));
	item.setRecruitStartDate(Date.valueOf(mr.getParameter(DonghangKey.RECRUIT_START_DATE)));
	item.setRecruitEndDate(Date.valueOf(mr.getParameter(DonghangKey.RECRUIT_END_DATE)));
	item.setPw(Integer.parseInt(mr.getParameter(DonghangKey.PW)));
	item.setPublicEnabled(mr.getParameter(DonghangKey.PUBLIC_ENABLED));
	item.setEnded(mr.getParameter(DonghangKey.ENDED));
	item.setDeleted(mr.getParameter(DonghangKey.DELETED));
	item.setRecruitPeopleNo(Integer.parseInt(mr.getParameter(DonghangKey.RECRUIT_PEOPLE_NO)));
	item.setJoinPeopleNo(Integer.parseInt(mr.getParameter(DonghangKey.JOIN_PEOPLE_NO)));
	return item;
}
}