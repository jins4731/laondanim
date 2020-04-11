package com.laon.donghang.model.vo;

import java.sql.Date;

public class MyDong {
	private int no;
	private int userNo;
	private int tripNo;
	private Date writeDate;
	private int viewcount;
	private String tag;
	private String title;
	private String content;
	private String travleLocale;
	private Date travleStartDate;
	private Date travleEndDate;
	private Date recruitStartDate;
	private Date recruitEndDate;
	private int pw;
	private String publicEnabled;
	private String ended;
	private String deleted;
	private int recruitPeopleNo;
	private int joinPeopleNo;
	private String image;
	
	public MyDong() {}

	public MyDong(int no, int userNo, int tripNo, Date writeDate, int viewcount, String tag, String title,
			String content, String travleLocale, Date travleStartDate, Date travleEndDate, Date recruitStartDate,
			Date recruitEndDate, int pw, String publicEnabled, String ended, String deleted, int recruitPeopleNo,
			int joinPeopleNo, String image) {
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
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
